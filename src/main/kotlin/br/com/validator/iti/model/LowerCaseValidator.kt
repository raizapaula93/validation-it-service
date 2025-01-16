package br.com.validator.iti.model

import br.com.validator.iti.exception.LowerCaseValidationException

class LowerCaseValidator : Validator {
    override fun validate(input: String): Boolean {
        if (!input.any { it.isLowerCase() }) {
            throw LowerCaseValidationException("Input must contain at least one lowercase letter")
        }
        return true
    }
}