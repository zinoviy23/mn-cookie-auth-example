package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.views.View
import java.security.Principal

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller
class HomeController {
    @Get
    @View("home")
    fun index(principal: Principal?): Map<String, Any> {
        val data = mutableMapOf<_, Any>("loggedIn" to (principal != null))
        if (principal != null) {
            data["username"] = principal.name
        }
        return data
    }
}