package com.letscode.hogwartsstudentregister.client;

import com.letscode.hogwartsstudentregister.dto.clients.HouseSelectorKey;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetSelectorHouseKeyClient {

    public HouseSelectorKey execute() {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        var response = restTemplate.exchange(
                "https://api-harrypotter.herokuapp.com/sortinghat",
                HttpMethod.GET,
                entity,
                HouseSelectorKey.class
        );

        if (response.getStatusCode().isError()) try {
            throw new Exception("Erro");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.getBody();
    }
}
