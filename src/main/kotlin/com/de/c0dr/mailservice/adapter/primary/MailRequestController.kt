package com.de.c0dr.mailservice.adapter.primary;

import com.de.c0dr.mailservice.MailApplicationService
import com.de.c0dr.mailservice.adapter.secondary.sending.MailSendingAdapter
import com.de.c0dr.mailservice.adapter.secondary.transpiling.MJMLTranspiler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class MailRequestController(private val mailApplicationService: MailApplicationService, private val mailSendingAdapter: MailSendingAdapter, private val mailTranspilingAdapter: MJMLTranspiler) {

    @PostMapping("/send")
    fun greeting(@RequestBody mailRequest: MailRequest) {
        val formattedTemplate = mailApplicationService.generateTemplate(mailRequest.templateName, mailRequest.variables)
        val htmlTemplate = mailTranspilingAdapter.transpile(formattedTemplate)
        mailSendingAdapter.sendMail(mailRequest.recipient, mailRequest.subject, htmlTemplate)
    }
}