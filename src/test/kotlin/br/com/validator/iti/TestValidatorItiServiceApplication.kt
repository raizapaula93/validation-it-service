package br.com.validator.iti

import org.springframework.boot.fromApplication


fun main(args: Array<String>) {
    fromApplication<ValidatorItiServiceApplication>().run(*args)
}
