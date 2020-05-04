package com.de.c0dr.mailservice.adapter.secondary.sending

import com.de.c0dr.mailservice.MailServiceProperties
import com.wildbit.java.postmark.Postmark
import com.wildbit.java.postmark.client.data.model.message.Message
import com.wildbit.java.postmark.client.data.model.message.MessageResponse
import org.springframework.stereotype.Component


@Component
class PostmarkAdapter(val configuration: MailServiceProperties) : MailSendingAdapter {

    override fun sendMail(toEmail: String, subject: String, htmlBody: String) {
        val client = Postmark.getApiClient(configuration.postmark.apiKey)
        val message = Message(configuration.postmark.fromEmail, toEmail, subject, htmlBody)
        val response: MessageResponse = client.deliverMessage(message)
    }
}