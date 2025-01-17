package br.com.validator.iti.controller


import br.com.validator.iti.usecase.ValidationStringUseCase
import com.ninjasquad.springmockk.MockkBean
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@ExtendWith(SpringExtension::class)
@WebMvcTest(ValidationController::class)
class ValidationControllerTest {

  @Autowired
  private lateinit var mockMvc: MockMvc

  @MockkBean
  private lateinit var stringUseCase: ValidationStringUseCase

  @Test
  fun `validateStringPassword should return OK when validation passes`() {
    val validInput = "Aa1!example"
    every { stringUseCase.validate(validInput) } returns true

    mockMvc.perform(
      MockMvcRequestBuilders.post("/v1/validator-it/string")
      .content(validInput)
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isOk)
      .andExpect(MockMvcResultMatchers.content().string("true"))

    verify { stringUseCase.validate(validInput) }
    confirmVerified(stringUseCase)
  }

  @Test
  fun `validateStringPassword should return BAD_REQUEST when validation fails`() {
    val invalidInput = "Aa1!exaample"
    every { stringUseCase.validate(invalidInput) } returns false

    mockMvc.perform(MockMvcRequestBuilders.post("/v1/validator-it/string")
      .content(invalidInput)
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.status().isBadRequest)
      .andExpect(MockMvcResultMatchers.content().string("false"))

    verify { stringUseCase.validate(invalidInput) }
    confirmVerified(stringUseCase)
  }


}