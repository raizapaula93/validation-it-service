package br.com.validator.iti.controller

data class ErrorDetails(
    val statusCode: Int,
    val message: String,
    val status: Boolean
)