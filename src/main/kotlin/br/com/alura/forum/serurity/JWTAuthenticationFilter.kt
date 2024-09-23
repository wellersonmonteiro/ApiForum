package br.com.alura.forum.serurity

import br.com.alura.forum.config.JWTUtil
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class JWTAuthenticationFilter(
    private val jwtUtil: JWTUtil
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val token = request.getHeader("Authorization")
        val jwt = getTakenDetail(token)
        if (jwt != null && jwtUtil.isValid(jwt)) {
            val authentication = jwtUtil.getAuthentication(jwt)
            val details = WebAuthenticationDetailsSource().buildDetails(request)
            val authWithDetails = UsernamePasswordAuthenticationToken(
                authentication.principal,
                authentication.credentials,
                authentication.authorities
            ).apply {
                this.details = details
            }
            SecurityContextHolder.getContext().authentication = authWithDetails
        }
        filterChain.doFilter(request, response)
    }

    private fun getTakenDetail(token: String?): String? {
        return token?.takeIf { it.startsWith("Bearer ") }?.substring(7)
    }
}