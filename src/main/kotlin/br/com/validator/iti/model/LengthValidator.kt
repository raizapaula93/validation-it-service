package br.com.validator.iti.model

class LengthValidator:Validator {
    override fun validate(input: String): Boolean {
        return input.length in 9..20
    }
}