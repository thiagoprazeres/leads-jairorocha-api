package br.com.jairorocha.leads.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Value("${olxpro.client-name}")
    private String clientName;

    @Value("${olxpro.application-name}")
    private String applicationName;

    @Value("${olxpro.application-description}")
    private String applicationDescription;

    @Value("${olxpro.website}")
    private String website;

    @Value("${olxpro.phone}")
    private String phone;

    @Value("${olxpro.email}")
    private String email;

    @GetMapping
    public String sayHello() {
        StringBuilder message = new StringBuilder("Leads Jairo Rocha\nGerador de Leads integrado ao OLX Pro!\n");
        message.append("Cliente: ").append(clientName).append("\n");
        message.append("Aplicação: ").append(applicationName).append("\n");
        message.append("Descrição: ").append(applicationDescription).append("\n");
        message.append("Website: ").append(website).append("\n");
        message.append("Telefone: ").append(phone).append("\n");
        message.append("E-mail: ").append(email).append("\n");
        return message.toString();
    }
}
