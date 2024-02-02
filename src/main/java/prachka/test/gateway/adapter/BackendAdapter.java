package prachka.test.gateway.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class BackendAdapter {

    private static final String REQUESTS_ENDPOINT = "/byname?name=antoon";

    private final RestTemplate restTemplate;

    @Value("${backend.url}")
    private String backendUrl;

    public BackendAdapter(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public String getRequests(String param) {
        Map<String,String> params = new HashMap<>();
        params.put("name", param);
        ResponseEntity<String> response = restTemplate.getForEntity(backendUrl + REQUESTS_ENDPOINT,String.class);
        return response.getBody();
    }
}