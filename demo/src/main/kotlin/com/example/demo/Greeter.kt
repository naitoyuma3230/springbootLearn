package com.example.demo

import org.springframework.stereotype.Component

@Component
//　interfaceで骨組みを定義
interface Greeter {
    fun sayHello(name:String):String
}