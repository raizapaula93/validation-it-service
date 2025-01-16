package br.com.validator.iti.usecase

import br.com.validator.iti.model.ValidatorFactory
import org.springframework.stereotype.Service

@Service
class ValidationStringUseCase (
    private val validatorFactory: ValidatorFactory
) {
    fun validate(input:String): Boolean{
        val validators = validatorFactory.getStringValidators()
        try {
            validators.forEach { it.validate(input) }
        } catch (e: Exception) {
            println("Validation failed: ${e.message}")
            return false
        }
        return true
    }
}
