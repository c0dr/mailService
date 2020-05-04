package com.de.c0dr.mailservice

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("config")
data class MailServiceProperties(val postmark: PostmarkConfig, val mjmlio: MjmlioProperties) {
    data class PostmarkConfig(val apiKey: String, val fromEmail: String)
    data class MjmlioProperties(val apiPublicKey: String, val apiSecretKey: String)
}