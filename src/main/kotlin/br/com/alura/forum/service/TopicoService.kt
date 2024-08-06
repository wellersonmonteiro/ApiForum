package br.com.alura.forum.service

import br.com.alura.forum.model.Topico
import br.com.alura.forum.dto.NovoTopicoDTO
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val autorService: UsuarioService) {

    fun listar(): List<Topico> {
        return topicos
    }


    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t -> t.id == id }.findFirst().get()
    }

    fun cadastrar(dto: NovoTopicoDTO) {
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscaPorId(dto.idCurso),
            autor = autorService.buscaPorId(dto.idAutor)
        ))

    }
}