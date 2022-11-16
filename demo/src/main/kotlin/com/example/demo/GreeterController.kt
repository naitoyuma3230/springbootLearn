package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

//戻り値をJsonへ自動変換
@RestController
@RequestMapping("greeter")
class GreeterController {
//  Overloadで引数の異なる同名のクラスを作成しルート毎に使い分ける

    @GetMapping("/hello/test")
    fun hello():HelloResponse{
        return HelloResponse("Hello Anyone")
    }


//  RequestのParamをkeyをnameに指定し、/name=の形で受け取る
    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String):HelloResponse{
        return HelloResponse("Hello $name")
    }

//  RequestのParamを/の形で受け取る
    @GetMapping("/hello/{name}")
    fun helloPathValue(@PathVariable("name") name: String):HelloResponse{
        return HelloResponse("Hello $name")
    }
//  psotされたjson形式のデータを@RequestBodyで取得し,
//  key(name)に対応するvalueを$request.nameの形でクラスに渡す
    @PostMapping("/hello")
    fun helloByPost(@RequestBody request:HelloRequest):HelloResponse{
        return HelloResponse("Hello ${request.name}")
    }
}