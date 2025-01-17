package br.com.validator.iti.controller

import br.com.validator.iti.exception.ValidationBadRequestException
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest
import kotlin.test.assertEquals

class ControllerExceptionHandlerTest {

    private val controllerExceptionHandler = ControllerExceptionHandler()

    @Test
    fun `handleValidationExceptions should handle different ValidationBadRequestExceptions correctly`() {

        class TestValidationBadRequestException(message: String) : ValidationBadRequestException(message)

        val exceptionMappings = mapOf(
            TestValidationBadRequestException("Erro na validação da senha!") to HttpStatus.BAD_REQUEST
        )

        exceptionMappings.forEach { (exception, expectedStatus) ->
            val webRequest = mockk<WebRequest>()
            val response = controllerExceptionHandler.handleValidationExceptions(exception, webRequest)
            val expectedErrorDetails = ErrorDetails(
                statusCode = expectedStatus.value(),
                message = exception.message ?: "Erro na validação da senha!",
                status = false
            )

            assertEquals(expectedStatus, response.statusCode)
            assertEquals(expectedErrorDetails, response.body)
        }
    }

    @Test
    fun `handleGlobalException should handle generic exceptions correctly`() {
        val exception = Exception("Erro inesperado!")
        val webRequest = mockk<WebRequest>()

        val response = controllerExceptionHandler.handleGlobalException(exception, webRequest)

        val expectedErrorDetails = ErrorDetails(
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message = "Erro inesperado!",
            status = false
        )

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.statusCode)
        assertEquals(expectedErrorDetails, response.body)
    }
}