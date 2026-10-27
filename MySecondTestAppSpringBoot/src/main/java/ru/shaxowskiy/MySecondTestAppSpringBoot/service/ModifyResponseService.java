package ru.shaxowskiy.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);

}
