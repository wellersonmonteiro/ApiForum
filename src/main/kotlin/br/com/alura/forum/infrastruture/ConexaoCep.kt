package br.com.alura.forum.infrastruture

import br.com.alura.forum.config.AppConfig
import br.com.alura.forum.model.Endereco
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ConexaoCep(private val restTemplate: RestTemplate) {

    fun getData(cep: String): Endereco? {
        val url = "https://viacep.com.br/ws/$cep/json/"
        val response = restTemplate.getForEntity(url, Endereco::class.java)
        return response.body
    }
}
