package ru.shaxowskiy.MySecondTestAppSpringBoot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shaxowskiy.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.shaxowskiy.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.Codes;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.ErrorCodes;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.ErrorMessages;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.Request;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.Response;
import ru.shaxowskiy.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.shaxowskiy.MySecondTestAppSpringBoot.service.ValidationService;
import ru.shaxowskiy.MySecondTestAppSpringBoot.util.DateTimeUtil;

import jakarta.validation.Valid;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("response created: {}", response);

        try {
            validationService.isValid(bindingResult);
            if ("123".equals(request.getUid())) {
                throw new UnsupportedCodeException("uid = 123");
            }
        } catch (ValidationFailedException e) {
            log.error("ValidationFailedException: {}", e.getMessage());
            bindingResult.getAllErrors().forEach(error ->
                    log.error("bindingResult error: {}", error.getDefaultMessage()));
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.info("response changed after validation error: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            log.error("UnsupportedCodeException: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.info("response changed after unsupported code error: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("UnknownException: {}", e.getMessage(), e);
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("response changed after unknown error: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Response modifiedResponse = modifyResponseService.modify(response);
        log.info("response sent: {}", modifiedResponse);

        return new ResponseEntity<>(modifiedResponse, HttpStatus.OK);
    }
}
