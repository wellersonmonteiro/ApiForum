package br.com.alura.forum.controller

import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.RespostaService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos/")
class RespostasController(private val service: RespostaService) {

    @GetMapping("{id}/respostas")
    fun listar(@PathVariable id: Long): List<Resposta> {
        return service.listar(id)
    }

    @PostMapping("respostas")
    fun cadastrarResposta(@RequestBody @Valid resposta: NovaRespostaForm){
        service.criarRespsota(resposta)
    }

}