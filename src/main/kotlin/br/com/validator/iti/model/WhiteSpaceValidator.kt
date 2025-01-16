package br.com.validator.iti.model

import br.com.validator.iti.exception.WhiteSpaceValidationException

class WhiteSpaceValidator: Validator {
    override fun validate(input: String): Boolean {
        if (input.contains(" ")) {
            throw WhiteSpaceValidationException("Input must not contain white spaces")
        }
        return true
    }
}