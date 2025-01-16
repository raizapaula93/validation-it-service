package br.com.validator.iti.model

import br.com.validator.iti.exception.RepeatedCharValidationException

class RepeatCaracterValidator: Validator {
    override fun validate(input: String): Boolean {
        val caracters = mutableSetOf<Char>()
        for (caracter in input) {
            if (!caracters.add(caracter)) {
                throw RepeatedCharValidationException("Input must not contain repeated characters")
            }
        }
        return true
    }
}