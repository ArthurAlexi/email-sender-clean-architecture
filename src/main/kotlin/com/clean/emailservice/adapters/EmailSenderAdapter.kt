package com.clean.emailservice.adapters

interface EmailSenderAdapter {
    fun sendEmail(to: String, subject: String, body: String ) : Unit
}