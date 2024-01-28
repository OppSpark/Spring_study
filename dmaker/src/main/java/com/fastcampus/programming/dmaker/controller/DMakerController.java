package com.fastcampus.programming.dmaker.controller;

import com.fastcampus.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author oppspark
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class DMakerController {

    private final DMakerService dMakerService;
    @GetMapping("/developers")
    public List<String> getAllDevelopers(){
        // GET /developers HTTP1.1
        log.info("GET /developers HTTP1.1");
        return Arrays.asList("snow", "elsa","Olaf");
    }

    @GetMapping("/create-developer")
    public List<String> createDevelopers(){
        // GET /developers HTTP1.1
        log.info("GET /create-developers HTTP1.1");

        dMakerService.createDevelopers();

        return Collections.singletonList("Olaf");
    }
}
