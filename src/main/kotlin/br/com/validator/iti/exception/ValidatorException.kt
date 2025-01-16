package br.com.validator.iti.exception

class LengthValidationException(message: String) : Exception(message)
class DigitValidationException(message: String) : Exception(message)
class LowerCaseValidationException(message: String) : Exception(message)
class UpperCaseValidationException(message: String) : Exception(message)
class SpecialCharValidationException(message: String) : Exception(message)
class RepeatedCharValidationException(message: String) : Exception(message)
class WhiteSpaceValidationException(message: String) : Exception(message)
