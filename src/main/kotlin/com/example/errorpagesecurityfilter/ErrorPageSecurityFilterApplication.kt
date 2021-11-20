package com.example.errorpagesecurityfilter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ErrorPageSecurityFilterApplication

fun main(args: Array<String>) {
    runApplication<ErrorPageSecurityFilterApplication>(*args)
}

@RestController
@RequestMapping("/")
class HelloController {
    @GetMapping("/login")
    fun login(): String = "login page"

    @GetMapping("/changepassword")
    fun changePassword(): String = "change password page"
}

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
internal class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Configuration(proxyBeanMethods = false)
    @Order(1)
    internal class FormWebSecurityConfigurerAdapter : WebSecurityConfigurerAdapter() {
        override fun configure(http: HttpSecurity) {
            http.authorizeRequests {
                it.anyRequest().permitAll()
            }
        }
    }
}
