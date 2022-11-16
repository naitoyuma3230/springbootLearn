package com.example.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
//Class全体のベースRouteを指定
@RequestMapping("hello")
class HelloController {
//  全てのルートは"/hello"から始まる
//  GET:"/"アクセス
    @GetMapping("/")
    fun index(model:Model):String{
        model.addAttribute("message","HELLO Spring Boot")

//      returnはhtml-templateを指定する
        return "index"
    }
}