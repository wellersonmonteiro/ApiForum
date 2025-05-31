package br.com.alura.forum.controller

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SecurityRequirement(name =  "baererAuth")
@RequestMapping("/hello")
class HelloController {

    @GetMapping
    fun hello(): String {
        return "Hello World!"
    }

}