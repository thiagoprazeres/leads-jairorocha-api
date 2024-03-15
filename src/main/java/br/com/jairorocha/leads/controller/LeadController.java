package br.com.jairorocha.leads.controller;

import br.com.jairorocha.leads.entity.Lead;
import br.com.jairorocha.leads.payload.response.LeadResponse;
import br.com.jairorocha.leads.service.LeadService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/olx/lead")
public class LeadController {
    private final LeadService leadService;

    @PostMapping("/{token}")
    public ResponseEntity<LeadResponse> createLead(@PathVariable String token, @RequestBody Lead lead) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new LeadResponse(leadService.createLead(lead).getId()));
    }
}
