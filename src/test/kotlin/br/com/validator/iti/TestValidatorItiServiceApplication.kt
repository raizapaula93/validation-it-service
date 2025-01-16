package br.com.validator.iti

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<ValidatorItiServiceApplication>().with(TestcontainersConfiguration::class).run(*args)
}
