package com.letscode.hogwartsstudentregister.client;

import com.letscode.hogwartsstudentregister.dto.clients.HouseInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class GetSelectorHouseInfoClient {

    public HouseInfo execute(UUID key) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        var response = restTemplate.exchange(
                "https://api-harrypotter.herokuapp.com/house/{key}",
                HttpMethod.GET,
                entity,
                HouseInfo.class,
                key
        );

        if (response.getStatusCode().isError()) {
            throw new HttpClientErrorException(response.getStatusCode());
        }

        return response.getBody();
    }
}
