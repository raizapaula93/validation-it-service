package br.com.validator.iti.usecase

import br.com.validator.iti.model.Validator
import br.com.validator.iti.model.ValidatorFactory
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import java.lang.RuntimeException

class ValidationStringUseCaseTest {

    private val validatorFactory: ValidatorFactory = mockk()
    private val validator: Validator = mockk()
    private val validationStringUseCase = ValidationStringUseCase(validatorFactory)

    @Test
    fun `validate should return true when all validators pass`() {
        val input = "AbT!9f2ko"
        val validators = listOf(validator)

        every { validatorFactory.getStringValidators() } returns validators
        every { validator.validate(input) } returns true

        val result = validationStringUseCase.validate(input)

        assertTrue(result)
        verify { validatorFactory.getStringValidators() }
        verify { validator.validate(input) }
        confirmVerified(validator)
    }

    @Test
    fun `validate should return false when a validator throws an exception`() {
        val input = "AbT!9f2foo"
        val validators = listOf(validator)

        every { validatorFactory.getStringValidators() } returns validators
        every { validator.validate(input) } throws RuntimeException()

        val result = try {
            validationStringUseCase.validate(input)
        } catch (e: Exception) {
            false
        }

        assertFalse(result)
        verify { validatorFactory.getStringValidators() }
        verify { validator.validate(input) }
        confirmVerified(validator)
    }
}