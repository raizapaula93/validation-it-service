package br.com.validator.iti.model

class LowerCaseValidator: Validator {
    override fun validate(input: String): Boolean {
        return input.any {it.isLowerCase()}
    }
}