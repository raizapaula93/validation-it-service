package br.com.validator.iti.exception

abstract class ValidationBadRequestException(message: String) : RuntimeException(message)

class LengthValidationException(message: String) : ValidationBadRequestException(message)
class DigitValidationException(message: String) : ValidationBadRequestException(message)
class LowerCaseValidationException(message: String) : ValidationBadRequestException(message)
class UpperCaseValidationException(message: String) : ValidationBadRequestException(message)
class SpecialCharValidationException(message: String) : ValidationBadRequestException(message)
class RepeatedCharValidationException(message: String) : ValidationBadRequestException(message)
class WhiteSpaceValidationException(message: String) : ValidationBadRequestException(message)

