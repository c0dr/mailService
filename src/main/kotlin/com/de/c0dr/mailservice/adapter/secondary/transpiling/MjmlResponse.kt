package com.de.c0dr.mailservice.adapter.secondary.transpiling

data class MjmlResponse(
        var errors: Array<String>,
        var html: String,
        var mjml: String,
        var mjml_version: String
)