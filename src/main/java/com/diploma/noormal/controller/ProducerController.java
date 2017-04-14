package com.diploma.noormal.controller;

import com.diploma.noormal.model.Producer;
import com.diploma.noormal.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Controller
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/producers")
    public @ResponseBody
    List<Producer> hello() {
        return producerService.getAllProducers();
    }
}
