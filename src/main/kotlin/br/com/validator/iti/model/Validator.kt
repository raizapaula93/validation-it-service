package br.com.validator.iti.model

interface Validator {
    fun validate(input: String): Boolean
}