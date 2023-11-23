package com.clean.emailservice.core.dtos

data class EmailRequest(
    val to: String,
    val subject: String,
    val body: String
)
