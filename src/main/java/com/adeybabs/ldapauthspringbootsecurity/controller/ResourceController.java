package com.adeybabs.ldapauthspringbootsecurity.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/resource/v1")
public class ResourceController {

    private static final Logger LOGGER = LogManager.getLogger(ResourceController.class);

    @GetMapping("/userGroup")
    public ResponseEntity<String> findUserGroup() {
        LOGGER.info("Executing findUserGroup()...");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOGGER.info(auth.getName() + " authenticated successfully!");
        return new ResponseEntity<String>("Welcome to infinity network, " + auth.getName() + "!", HttpStatus.OK);
    }
}
