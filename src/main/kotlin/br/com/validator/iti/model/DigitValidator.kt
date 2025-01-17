package br.com.validator.iti.model

import br.com.validator.iti.exception.DigitValidationException

class DigitValidator : Validator {
    override fun validate(input: String): Boolean {
        if (!input.any { it.isDigit() }) {
            throw DigitValidationException("A senha deve conter pelo menos um número!")
        }
        return true
    }
}