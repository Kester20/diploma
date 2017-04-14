package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Producer;
import com.diploma.noormal.repository.ProducerRepository;
import com.diploma.noormal.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public List<Producer> getAllProducers() {
        return (List<Producer>) producerRepository.findAll();
    }
}
