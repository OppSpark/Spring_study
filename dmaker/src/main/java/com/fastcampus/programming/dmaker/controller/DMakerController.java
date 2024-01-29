package com.fastcampus.programming.dmaker.controller;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.service.DMakerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<String> getAllDevelopers() {
        // GET /developers HTTP1.1
        log.info("GET /developers HTTP1.1");
        return Arrays.asList("snow", "elsa", "Olaf");
    }

    @PostMapping("/create-developer")

    public CreateDeveloper.Response createDevelopers(
            @Valid
            @RequestBody CreateDeveloper.Request request
    ) {
        log.info("request :{}", request);

        return dMakerService.createDeveloper(request);
    }
}
