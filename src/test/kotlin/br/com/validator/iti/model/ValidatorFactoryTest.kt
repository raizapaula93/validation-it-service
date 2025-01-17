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

  val testCases = mapOf(
   LengthValidator::class to mapOf(
    "aa" to false,
    "longEnough" to true,
    "123456789" to true,
    "12345678901234567890" to true
   ),
   DigitValidator::class to mapOf(
    "Abcdefg!hI" to false,
    "has1Digit1" to true
   ),
   LowerCaseValidator::class to mapOf(
    "ABCDEF3H!I" to false,
    "has1Lower" to true
   ),
   UpperCaseValidator::class to mapOf(
    "abcdefg3h!i" to false,
    "has1Upper" to true
   ),
   SpecialCharValidator::class to mapOf(
    "Abcdefg3hi" to false,
    "has1Special!" to true
   ),
   RepeatCaracterValidator::class to mapOf(
    "noRepati" to true,
    "hasRepeattt" to false
   ),
    WhiteSpaceValidator::class to mapOf(
     "noSpace" to true,
     "has Space" to false
    )
  )

  for (validator in validators) {
   val validatorClass = validator::class
   val cases = testCases[validatorClass]
   if (cases != null) {
    for ((input, expected) in cases) {
     try {
      val result = validator.validate(input)
      assertEquals(expected, result, "Failed for ${validatorClass.simpleName} with input '$input'")
     } catch (e: Exception) {
      assertFalse(expected, "Exception thrown for ${validatorClass.simpleName} with input '$input': ${e.message}")
     }
    }
   }
  }
 }
}