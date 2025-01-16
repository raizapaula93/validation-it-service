package br.com.validator.iti.model

import br.com.validator.iti.exception.LengthValidationException

class LengthValidator : Validator {
    override fun validate(input: String): Boolean {
        if (input.length < 9) {
            throw LengthValidationException("Input length must be deve ser maior ou igual a 9 caracteres")
        }
        return true
    }
}