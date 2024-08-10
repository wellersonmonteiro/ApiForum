package br.com.alura.forum.mapper

import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper: Mapper<Resposta, RespostaView> {
    override fun map(t: Resposta): RespostaView {
        return RespostaView(
            id = t.id,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            nomeAutor = t.autor.nome
        )
    }
}