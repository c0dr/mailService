package com.de.c0dr.mailservice.adapter.secondary.transpiling

import com.de.c0dr.mailservice.MailServiceProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class MJMLIOAdapter(val configuration: MailServiceProperties) : MJMLTranspiler {

    val url = "https://api.mjml.io/v1/render" //todo: replace with locally running API

    override fun transpile(mjml: String): String {
        val body = mutableMapOf("mjml" to mjml)
        val response = restTemplate().postForObject(url, body, MjmlResponse::class.java)
        if (response != null) {
            return response.html
        }
        return ""
    }

    fun restTemplate(): RestTemplate {
        return RestTemplateBuilder().basicAuthentication(configuration.mjmlio.apiPublicKey, configuration.mjmlio.apiSecretKey).build()
    }

}