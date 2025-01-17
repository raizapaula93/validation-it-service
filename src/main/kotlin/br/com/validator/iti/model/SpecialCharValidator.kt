package br.com.validator.iti.model

import br.com.validator.iti.exception.SpecialCharValidationException

class SpecialCharValidator : Validator {
    override fun validate(input: String): Boolean {
        val specialChars = "!@#$%^&*()-+"
        if (!input.any { it in specialChars }) {
            throw SpecialCharValidationException("A senha deve conter pelo menos um caractere especial: $specialChars")
        }
        return true
    }
}