package br.com.alura.forum.model

object TopicoTest {
    fun build() = Topico (
        id =1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo Kotlin",
        curso = CursoTest.build(),
        autor = UsuarrioTest.build(),
    )
}
