package com.de.c0dr.mailservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties(MailServiceProperties::class)
class MailserviceApplication

fun main(args: Array<String>) {
	SpringApplication.run(MailserviceApplication::class.java, *args)
}

