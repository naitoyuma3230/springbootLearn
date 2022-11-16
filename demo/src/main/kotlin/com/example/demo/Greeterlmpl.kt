package com.example.demo

import org.springframework.stereotype.Component


//  @Component：DI対象となり引数に指定するとインスタンスの自動生成が行われる
@Component
//expression-body function:retrunを省略できる記法
class Greeterlmpl:Greeter {
    override fun sayHello(name: String): String = "Hello $name"
}