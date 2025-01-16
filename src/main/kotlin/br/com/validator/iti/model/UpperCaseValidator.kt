package br.com.validator.iti.model

class UpperCaseValidator: Validator {
    override fun validate(input: String): Boolean {
        return input.any{ it.isUpperCase()}
    }
}