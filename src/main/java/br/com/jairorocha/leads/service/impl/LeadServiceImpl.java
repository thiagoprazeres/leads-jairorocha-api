package br.com.jairorocha.leads.service.impl;

import br.com.jairorocha.leads.entity.*;
import br.com.jairorocha.leads.repository.LeadRepository;
import br.com.jairorocha.leads.service.LeadService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LeadServiceImpl implements LeadService {
    private final LeadRepository leadRepository;
    @Transactional
    public Lead createLead(Lead lead) {
       return leadRepository.save(lead);
    }
}
