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
import ru.shaxowskiy.MySecondTestAppSpringBoot.service.AnnualBonusService;
import ru.shaxowskiy.MySecondTestAppSpringBoot.service.ModifyRequestService;
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
    private final ModifyRequestService modifySourceRequestService;
    private final ModifyRequestService modifySystemNameRequestService;
    private final AnnualBonusService annualBonusService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySourceRequestService") ModifyRequestService modifySourceRequestService,
                        @Qualifier("ModifySystemNameRequestService") ModifyRequestService modifySystemNameRequestService,
                        AnnualBonusService annualBonusService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifySourceRequestService = modifySourceRequestService;
        this.modifySystemNameRequestService = modifySystemNameRequestService;
        this.annualBonusService = annualBonusService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        String receivedTime = DateTimeUtil.getCustomFormat().format(new Date());
        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(receivedTime)
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        log.info("response created: {}", response);

        try {
            validationService.isValid(bindingResult);
            validationService.isSupported(request);
            calculateBonuses(request, response);
            sendToService2(request, receivedTime);
        } catch (ValidationFailedException e) {
            return failed(response, ErrorCodes.VALIDATION_EXCEPTION, ErrorMessages.VALIDATION, HttpStatus.BAD_REQUEST, e);
        } catch (UnsupportedCodeException e) {
            return failed(response, ErrorCodes.UNSUPPORTED_EXCEPTION, ErrorMessages.UNSUPPORTED, HttpStatus.BAD_REQUEST, e);
        } catch (Exception e) {
            return failed(response, ErrorCodes.UNKNOWN_EXCEPTION, ErrorMessages.UNKNOWN, HttpStatus.INTERNAL_SERVER_ERROR, e);
        }

        Response modifiedResponse = modifyResponseService.modify(response);
        log.info("response sent: {}", modifiedResponse);
        return new ResponseEntity<>(modifiedResponse, HttpStatus.OK);
    }

    private void calculateBonuses(Request request, Response response) {
        response.setAnnualBonus(annualBonusService.calculate(request.getPosition(),
                request.getSalary(), request.getBonus(), request.getWorkDays()));
        response.setQuarterlyBonus(annualBonusService.calculateQuarterly(request.getPosition(),
                request.getSalary(), request.getBonus(), request.getWorkDays()));
        log.info("response bonuses calculated: {}", response);
    }

    private void sendToService2(Request request, String receivedTime) {
        request.setSystemTime(receivedTime);
        log.info("request systemTime set to Service 1 receive time: {}", request);
        modifySourceRequestService.modify(request);
        modifySystemNameRequestService.modify(request);
    }

    private ResponseEntity<Response> failed(Response response, ErrorCodes errorCode, ErrorMessages errorMessage,
                                            HttpStatus status, Exception e) {
        log.error("{}: {}", e.getClass().getSimpleName(), e.getMessage());
        response.setCode(Codes.FAILED);
        response.setErrorCode(errorCode);
        response.setErrorMessage(errorMessage);
        log.info("response changed after error: {}", response);
        return new ResponseEntity<>(response, status);
    }
}
