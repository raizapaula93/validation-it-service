package br.com.validator.iti.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ValidatorFactoryTest {

    @Autowired
    private lateinit var validatorFactory: ValidatorFactory

    @Test
    fun testValidators() {
        val validators = validatorFactory.getStringValidators()

        val casosDeTeste = mapOf(
            LengthValidator::class to mapOf(
                "aa" to false,
                "suficientementeLonga" to true,
                "123456789" to true,
                "12345678901234567890" to true
            ),
            DigitValidator::class to mapOf(
                "Abcdefg!hI" to false,
                "tem1Digito1" to true
            ),
            LowerCaseValidator::class to mapOf(
                "ABCDEF3H!I" to false,
                "tem1Minuscula" to true
            ),
            UpperCaseValidator::class to mapOf(
                "abcdefg3h!i" to false,
                "tem1Maiuscula" to true
            ),
            SpecialCharValidator::class to mapOf(
                "Abcdefg3hi" to false,
                "tem1Especial!" to true
            ),
            RepeatCaracterValidator::class to mapOf(
                "semR3pticao" to true,
                "temRepeticao" to false
            ),
            WhiteSpaceValidator::class to mapOf(
                "semEspaco" to true,
                "tem Espaco" to false
            )
        )

        for (validator in validators) {
            val classValidator = validator::class
            val cases = casosDeTeste[classValidator]
            if (cases != null) {
                for ((input, expected) in cases) {
                    try {
                        val result = validator.validate(input)
                        assertEquals(expected, result, "Falha para ${classValidator.simpleName} com entrada '$input'")
                    } catch (e: Exception) {
                        assertFalse(
                            expected,
                            "Exceção lançada para ${classValidator.simpleName} com entrada '$input': ${e.message}"
                        )
                    }
                }
            }
        }
    }
}