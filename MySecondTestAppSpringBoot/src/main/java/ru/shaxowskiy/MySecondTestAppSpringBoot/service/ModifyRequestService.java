package ru.shaxowskiy.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {

    void modify(Request request);

}
