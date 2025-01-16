package br.com.validator.iti.controller

import br.com.validator.iti.usecase.ValidationStringUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/validator-it")
class ValidationController(
    private val stringUseCase: ValidationStringUseCase
) {
    @PostMapping("/string")
    fun validateStringPassword(
        @RequestBody body: String
    ) {
        stringUseCase.validate(body)
        return
    }
}