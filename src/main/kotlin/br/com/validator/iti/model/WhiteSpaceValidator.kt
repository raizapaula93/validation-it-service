package br.com.validator.iti.model

import br.com.validator.iti.exception.WhiteSpaceValidationException

class WhiteSpaceValidator : Validator {
    override fun validate(input: String): Boolean {
        if (input.contains(" ")) {
            throw WhiteSpaceValidationException("A senha não deve conter espaços em branco")
        }
        return true
    }
}