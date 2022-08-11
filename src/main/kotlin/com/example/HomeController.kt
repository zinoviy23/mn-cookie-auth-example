package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.cookie.Cookie
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

    @Get("dumpCookies")
    fun dumpCookies(request: HttpRequest<*>): Map<String, Cookie> {
        return request.cookies.asMap()
    }

    @Get("setCookie")
    fun setCookie(): HttpResponse<String> {
        return HttpResponse.ok<String?>().cookie(Cookie.of("Kek", "lol").domain("sashkinsite.com"))
    }
}