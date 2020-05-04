package com.de.c0dr.mailservice.adapter.primary

data class MailRequest(
        var recipient: String,
        var variables: Map<String, String>,
        var templateName: String,
        var subject: String
)