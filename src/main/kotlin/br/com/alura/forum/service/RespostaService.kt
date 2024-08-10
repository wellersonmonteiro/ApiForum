package br.com.alura.forum.service

import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.mapper.RespostaFormMapper
import br.com.alura.forum.model.Resposta
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService(private var respostas: List<Resposta>,
                        private val respostaFormMapper: RespostaFormMapper
    ) {



    fun listar(idTopico: Long): List<Resposta> {
        return respostas.stream().filter { r ->
            r.topico.id == idTopico
        }.collect(Collectors.toList())
    }

    fun criarRespsota(form: NovaRespostaForm) {
        val novaResposta = respostaFormMapper.map(form)
        novaResposta.id = respostas.size.toLong() + 1
        respostas = respostas.plus(novaResposta)
    }
}