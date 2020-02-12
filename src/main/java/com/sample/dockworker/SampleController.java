package com.sample.dockworker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    private MainService mainService;

    @GetMapping("/hello")
    public ResponseEntity getHelloMessage() {
        return ResponseEntity.ok("Hello World works V2 - Auto");
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/all-services")
    public ResponseEntity serviceInstancesByApplicationName() {
        return ResponseEntity.ok(discoveryClient.getServices());
    }

    @RequestMapping("/all-health")
    public ResponseEntity getHealthReport() {
        return mainService.getHealthReports();
    }
}
