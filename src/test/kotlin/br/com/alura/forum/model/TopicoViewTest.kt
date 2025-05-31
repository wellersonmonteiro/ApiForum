package br.com.alura.forum.model

import br.com.alura.forum.dto.TopicoView
import java.time.LocalDate
import java.time.LocalDateTime

object TopicoViewTest {
    fun build() = TopicoView(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo Kotlin",
        dataCriacao = LocalDateTime.now(),
        status = StatusTopico.NAO_RESPONDIDO,
        dataAlteracao = LocalDate.now()
    )
}