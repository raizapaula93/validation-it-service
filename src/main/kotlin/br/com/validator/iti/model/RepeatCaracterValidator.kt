package br.com.validator.iti.model

import br.com.validator.iti.exception.RepeatedCharValidationException

class RepeatCaracterValidator : Validator {
    override fun validate(input: String): Boolean {
        val caracters = mutableSetOf<Char>()
        for (caracter in input) {
            if (!caracters.add(caracter)) {
                throw RepeatedCharValidationException("A senha não deve conter elementos repetidos")
            }
        }
        return true
    }
}