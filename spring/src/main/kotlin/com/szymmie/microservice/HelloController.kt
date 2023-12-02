package com.szymmie.microservice

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    fun getHelloPage(@RequestParam("name") name: String?): String {
        return "<h1>Hello ${name ?: "unknown"}!</h1>"
    }
}