package br.com.fiap.pharmaeasetotem.controller;

import br.com.fiap.pharmaeasetotem.service.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {

    @Autowired
    private RabbitMQProducer producer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return "Mensagem enviada: " + message;
    }
}