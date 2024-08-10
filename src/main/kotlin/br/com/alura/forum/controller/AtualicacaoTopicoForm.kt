package br.com.alura.forum.controller

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class AtualicacaoTopicoForm(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val titulo: String,
    val mensagem: String,
)
