package com.clean.emailservice.controllers

import com.clean.emailservice.application.EmailSenderService
import com.clean.emailservice.core.dtos.EmailRequest
import com.clean.emailservice.core.exceptions.EmailServiceException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("api/v1/email")
class EmailSenderController(val emailSenderService: EmailSenderService){

    @PostMapping()
    fun sendEmail(@RequestBody emailRequest: EmailRequest ): ResponseEntity<String> {
        try {
            emailSenderService.sendEmail(emailRequest.to, emailRequest.subject, emailRequest.body)
            return ResponseEntity.ok("Email send successfully")
        }catch (ex: EmailServiceException){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email")
        }
    }
}
