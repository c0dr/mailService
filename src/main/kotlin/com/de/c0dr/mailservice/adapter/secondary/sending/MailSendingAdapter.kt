package com.de.c0dr.mailservice.adapter.secondary.sending

interface MailSendingAdapter {
    fun sendMail(toEmail: String, subject: String, htmlBody: String)
}