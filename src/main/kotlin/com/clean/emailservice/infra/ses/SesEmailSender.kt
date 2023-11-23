package com.clean.emailservice.infra.ses

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.model.*
import com.clean.emailservice.adapters.EmailSenderAdapter
import com.clean.emailservice.core.exceptions.EmailServiceException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SesEmailSender(private val amazonSimpleEmailService: AmazonSimpleEmailService ): EmailSenderAdapter{
    override fun sendEmail(to: String, subject: String, body: String) {

        val sendEmailRequest: SendEmailRequest = SendEmailRequest()
            .withSource("email@email.com")
            .withDestination(Destination().withToAddresses(to))
            .withMessage(Message()
                .withSubject(Content(subject))
                .withBody(Body().withText(Content(body))))

        try {
            amazonSimpleEmailService.sendEmail(sendEmailRequest)
        }catch (e: AmazonSimpleEmailServiceException){
            throw EmailServiceException("Failure while sending email")
        }

    }
}