package com.springcrud.demo01

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun showHello(): String {
        return "Say hello"
    }
}