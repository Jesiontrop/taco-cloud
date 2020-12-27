package com.jesiontrop.tacocloud.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TacoCloudClient {

    private RestTemplate restTemplate;

    public TacoCloudClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
