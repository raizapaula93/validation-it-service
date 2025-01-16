package br.com.validator.iti.model

import br.com.validator.iti.exception.SpecialCharValidationException

class SpecialCharValidator : Validator {
    override fun validate(input: String): Boolean {
        val specialChars = "!@#$%^&*()-+"
        if (!input.any { it in specialChars }) {
            throw SpecialCharValidationException("Input must contain at least one special character")
        }
        return true
    }
}