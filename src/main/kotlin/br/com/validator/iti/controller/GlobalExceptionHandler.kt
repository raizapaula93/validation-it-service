package br.com.validator.iti.controller

import br.com.validator.iti.exception.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ValidationBadRequestException::class)
    fun handleValidationExceptions(ex: ValidationBadRequestException, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            statusCode = HttpStatus.BAD_REQUEST.value(),
            message = ex.message ?: "Validation error",
            status = false
        )
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleGlobalException(ex: Exception, request: WebRequest): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message = ex.message ?: "Internal server error",
            status = false
        )
        return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}