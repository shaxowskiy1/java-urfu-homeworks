package ru.shaxowskiy.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.Request;
import ru.shaxowskiy.MySecondTestAppSpringBoot.model.Systems;

@Slf4j
@Service
@Qualifier("ModifySystemNameRequestService")
public class ModifySystemNameRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        request.setSystemName(Systems.ERP);
        log.info("request systemName modified: {}", request);

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        log.info("send request to Service 2: {}", request);
        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}
