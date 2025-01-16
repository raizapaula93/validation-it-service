package br.com.validator.iti.model

class RepeatCaracterValidator: Validator {
    override fun validate(input: String): Boolean {
        val caracters = mutableSetOf<Char>()
        for (caracter in input) {
            if (!caracters.add(caracter)) {
                return false
            }
        }
        return true
    }
}