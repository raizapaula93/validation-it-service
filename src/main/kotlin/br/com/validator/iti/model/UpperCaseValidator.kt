package br.com.validator.iti.model

import br.com.validator.iti.exception.UpperCaseValidationException

class UpperCaseValidator : Validator {
    override fun validate(input: String): Boolean {
        if (!input.any { it.isUpperCase() }) {
            throw UpperCaseValidationException("A senha deve conter pelo menos uma letra maiúscula")
        }
        return true
    }
}