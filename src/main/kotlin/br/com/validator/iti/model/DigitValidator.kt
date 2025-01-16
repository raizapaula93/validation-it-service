package br.com.validator.iti.model

class DigitValidator: Validator {
    override fun validate(input: String): Boolean {
        return input.any() { it.isDigit()}
    }
}