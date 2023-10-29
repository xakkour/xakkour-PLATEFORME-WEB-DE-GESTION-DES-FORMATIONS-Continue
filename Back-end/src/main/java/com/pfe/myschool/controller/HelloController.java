package com.pfe.myschool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  HelloController {

    @RequestMapping("/")
        String hello() {
            return "Hello World, Oussama Chakkour From Back-End";
        }
    }