package br.com.validator.iti.model

import br.com.validator.iti.exception.DigitValidationException

class DigitValidator : Validator {
    override fun validate(input: String): Boolean {
        if (!input.any { it.isDigit() }) {
            throw DigitValidationException("Input must contain at least one digit")
        }
        return true
    }
}