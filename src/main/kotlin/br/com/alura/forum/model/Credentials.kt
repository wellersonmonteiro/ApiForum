package br.com.alura.forum.model

import com.fasterxml.jackson.annotation.JsonAlias

data class Credentials (
    @JsonAlias("userName")
    val username:String = "",
    val password: String = ""
)
