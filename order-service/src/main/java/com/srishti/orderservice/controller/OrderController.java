package com.srishti.orderservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.srishti.orderservice.dto.OrderRequest;
import com.srishti.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest OrderRequest) {
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(OrderRequest));
    }

    public CompletableFuture<String> fallbackMethod(OrderRequest OrderRequest, RuntimeException runtimeException) {
        return CompletableFuture.supplyAsync(()
                -> "Oops! Something went wrong, please try to order after some time...");

    }
    
}
