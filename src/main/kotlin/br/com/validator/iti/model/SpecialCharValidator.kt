package br.com.validator.iti.model

class SpecialCharValidator:Validator {
    override fun validate(input: String): Boolean {
        val specialChars = "!@#$%^&*()+-"
        return input.any{ it in specialChars }
    }
}