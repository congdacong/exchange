package com.exchange.controller;

import com.exchange.compant.DirectProducer;
import com.exchange.compant.FanoutProducer;
import com.exchange.compant.SimpleProducer;
import com.exchange.compant.WorkProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private WorkProducer fanoutProducer;
    @RequestMapping("/")
    public String getMessage() throws InterruptedException {
         fanoutProducer.send();
         return "success";

    }
}
