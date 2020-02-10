package com.sample.dockworker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class MainService {

    public ResponseEntity getCircuitBreakerResult() {
        return ResponseEntity.ok("Circuit breaker open on : " + getIpAddress());
    }

    @HystrixCommand(fallbackMethod = "getCircuitBreakerResult")
    public ResponseEntity getHealthReports(){
        return new RestTemplate().getForEntity("http://localhost:8081/health", String.class);

    }

    private String getIpAddress(){
        try {
            return InetAddress.getLocalHost().getHostAddress() + InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "IP not found";
        }
    }
}
