package br.com.validator.iti.usecase

import br.com.validator.iti.model.ValidatorFactory
import org.springframework.stereotype.Service

@Service
class ValidationStringUseCase(
    private val validatorFactory: ValidatorFactory
) {
    fun validate(input: String): Boolean {
        val validators = validatorFactory.getStringValidators()
        validators.forEach { it.validate(input) }
        return true
    }
}

