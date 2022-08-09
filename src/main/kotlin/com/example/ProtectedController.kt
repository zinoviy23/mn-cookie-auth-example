package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("protected")
class ProtectedController {
    @Get(produces = [MediaType.APPLICATION_JSON])
    fun protectedJson(): String {
        return """{"protected": true}"""
    }
}