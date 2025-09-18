package me.lucasgusmao.berrytuneapi.controller;

import jakarta.websocket.Endpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestEndpointController {

    //Endpoint de teste para verificar se a API está funcionando

    @GetMapping
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("A API está funcionando!");
    }
}
