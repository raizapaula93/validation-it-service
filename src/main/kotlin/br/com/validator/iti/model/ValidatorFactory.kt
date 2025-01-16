package br.com.validator.iti.model

import org.springframework.stereotype.Service

@Service
class ValidatorFactory {
    fun getStringValidators(): List<Validator> {
        return listOf(
            LengthValidator(),
            DigitValidator(),
            LowerCaseValidator(),
            UpperCaseValidator(),
            SpecialCharValidator(),
            RepeatCaracterValidator()
        )
    }
}