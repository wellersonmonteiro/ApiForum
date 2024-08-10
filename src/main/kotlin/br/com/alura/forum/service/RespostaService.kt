package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizarRespostaForm
import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.mapper.RespostaFormMapper
import br.com.alura.forum.mapper.RespostaViewMapper
import br.com.alura.forum.model.Resposta
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService(private var respostas: List<Resposta>,
                        private val respostaFormMapper: RespostaFormMapper,
                        private val respostaViewMapper: RespostaViewMapper
    ) {



    fun listar(): List<Resposta> {
        return respostas
    }

    fun criarRespsota(form: NovaRespostaForm): RespostaView {
        val novaResposta = respostaFormMapper.map(form)
        novaResposta.id = respostas.size.toLong() + 1
        respostas = respostas.plus(novaResposta)

        return respostaViewMapper.map(novaResposta)
    }

    fun atualizarResposta(form: AtualizarRespostaForm): RespostaView {

        val respostaExistente =  respostas.stream().
        filter { t -> t.id == form.id }.
        findFirst().
        get()
        val respostaAtualizada = Resposta(
            id = respostaExistente.id,
            mensagem = form.mensagem,
            autor = respostaExistente.autor,
            topico = respostaExistente.topico,
            solucao = respostaExistente.solucao
        )
        respostas = respostas.minus(respostaExistente).plus(respostaAtualizada)

        return respostaViewMapper.map(respostaAtualizada)
    }

    fun removerResposta(id: Long) {
        val respostaExistente =  respostas.stream().
        filter { t -> t.id == id }.
        findFirst().
        get()
        respostas = respostas.minus(respostaExistente)
    }
}