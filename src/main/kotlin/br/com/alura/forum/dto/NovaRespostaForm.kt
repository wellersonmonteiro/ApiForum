package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class NovaRespostaForm (
    @field:NotEmpty val mensagem: String,
    @field:NotNull val idAutor: Long,
    val idTopico: Long
)