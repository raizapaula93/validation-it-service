package br.com.validator.iti.model

import br.com.validator.iti.exception.UpperCaseValidationException

class UpperCaseValidator : Validator {
    override fun validate(input: String): Boolean {
        if (!input.any { it.isUpperCase() }) {
            throw UpperCaseValidationException("Input must contain at least one uppercase letter")
        }
        return true
    }
}