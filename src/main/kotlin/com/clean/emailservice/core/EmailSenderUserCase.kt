package com.clean.emailservice.core

interface EmailSenderUserCase {

    fun sendEmail(to: String, subject: String, body: String ) : Unit
}