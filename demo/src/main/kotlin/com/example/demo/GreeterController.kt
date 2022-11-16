package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
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
//  クラスにのコンストラクタにGreeterクラスを渡す
//  DI：プロパティのgreeterとしてGreeterクラスのインスタンスが自動生成される
class GreeterController(private val constGreeter: Greeter) {

//  カスタムセッターを使用するとlateinitを使用できないため、Null許容でnullで初期化
    var setterGreeter:Greeter? = null
        //  カスタムセッターは対象プロパティの直下に定義する
        @Autowired
        set(value){
            field = value
        }

//  DI対象のフィールドを指定
    @Autowired
//  クラス型に指定する事でインスタンスの自動生成
//  インスタンスの生成が変数の初期化タイミングより遅いため、lateinitで初期化の遅れを許容する
    private lateinit var fieldGreeter: Greeter

    @GetMapping("/hello/test")
    fun hello():HelloResponse{
        return HelloResponse("Hello Anyone")
    }

    @GetMapping("/hello/byservice/{name}")
    fun helloByService(@PathVariable("name") name:String):HelloResponse{
//      DIによりgreeterプロパティは宣言を省略しGreeterクラスのインスタンスになる
        val message = constGreeter.sayHello(name)
        return HelloResponse(message)
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