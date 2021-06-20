package com.n26.controller;


import com.n26.model.Statistic;
import com.n26.service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping("/")
public class StatisticsAPI {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/statistics")
    public ResponseEntity<Map<String , Object>> getStatistics(){
        return new ResponseEntity<>(statisticsService.getStatistics().getResponseObj(), HttpStatus.OK);
    }
}
