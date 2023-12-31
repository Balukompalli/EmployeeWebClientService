package com.employee.webclient.controller;

import com.employee.webclient.model.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class EmployeeWebclientController {

    @Autowired
    WebClient webClient;

    @PostMapping("/saveEmployee")
    public Mono<String> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return webClient.post().uri("/saveEmployee").syncBody(employeeRequest).retrieve().bodyToMono(String.class);
    }

    @GetMapping("/getEmployees")
    public Flux<EmployeeRequest> getEmployee() {
        return webClient.get().uri("/getEmployees").retrieve()
                .bodyToFlux(EmployeeRequest.class);
    }

    @GetMapping("/getEmployeeById")
    public Mono<EmployeeRequest> getEmployeeById(@RequestParam("employeeId") Long employeeId) {
        return webClient.get()
                .uri("/getEmployeeById?employeeId=" + employeeId)
                .retrieve().bodyToMono(EmployeeRequest.class);
    }

}
