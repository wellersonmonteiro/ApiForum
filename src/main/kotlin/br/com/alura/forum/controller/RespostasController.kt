package br.com.alura.forum.controller

import br.com.alura.forum.dto.AtualizarRespostaForm
import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.dto.RespostaView
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.RespostaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos/respostas/")
class RespostasController(private val service: RespostaService) {

    @GetMapping()
    fun listar(): List<Resposta> {
        return service.listar()
    }

    @PostMapping
    fun cadastrarResposta(
        @RequestBody @Valid resposta: NovaRespostaForm,
        uriBiuler: UriComponentsBuilder,
    ): ResponseEntity<RespostaView> {
        val respostaCriada = service.criarRespsota(resposta)
        val uri = uriBiuler.path("/topicos/respostas/${respostaCriada.id}").build().toUri()
        return ResponseEntity.created(uri).body(respostaCriada)
    }

    @PutMapping
    fun atualizarResposta(@RequestBody @Valid resposta: AtualizarRespostaForm): ResponseEntity<RespostaView> {
        val respostaAtualizada = service.atualizarResposta(resposta)
        return ResponseEntity.ok(respostaAtualizada)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removerResposta(@PathVariable id: Long) {
        service.removerResposta(id)
    }

}