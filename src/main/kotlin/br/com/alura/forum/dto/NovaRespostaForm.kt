package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class NovaRespostaForm (
    @field:NotNull val idAutor: Long,
    @field:NotEmpty val mensagem: String,
    val idTopico: Long
)