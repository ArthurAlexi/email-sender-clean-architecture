package com.clean.emailservice.application

import com.clean.emailservice.adapters.EmailSenderAdapter
import com.clean.emailservice.core.EmailSenderUserCase
import org.springframework.stereotype.Service

@Service
class EmailSenderService(val adapter: EmailSenderAdapter ) : EmailSenderUserCase {


    override fun sendEmail(to: String, subject: String, body: String) {
        adapter.sendEmail(to = to, subject =  subject, body =  body)
    }
}