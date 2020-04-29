package com.huotn.huosecritytoken.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:leichengyang
 * @desc:com.huotn.huosecritytoken.controller
 * @date:2020-04-29
 */
@RestController
public class UserController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/user/me", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String me() throws JsonProcessingException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        return objectMapper.writeValueAsString(principal);
    }
}

