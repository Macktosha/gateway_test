package prachka.test.gateway.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prachka.test.gateway.adapter.BackendAdapter;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EndpointController {

    private final BackendAdapter backendAdapter;

    @Value("${instance.id}")
    private int instanceId;

    @Value("${secret}")
    private String secret;

    @GetMapping("/byname")
    public String getByName(@RequestParam String name) {
        String result = String.format(" %s (gateway %d, secret %s)",
                backendAdapter.getRequests(name), instanceId, secret);
        log.info("Handling byname request. Result {}", result);
        return result;
    }
}
