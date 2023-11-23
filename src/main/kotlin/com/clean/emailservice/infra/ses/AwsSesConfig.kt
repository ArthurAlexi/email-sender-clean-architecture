package com.clean.emailservice.infra.ses

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsSesConfig {
    @Bean
    fun amazonSimpleEmailService() : AmazonSimpleEmailService  = AmazonSimpleEmailServiceClientBuilder.standard().build()
}