package br.com.alura.forum.controller


import br.com.alura.forum.config.JWTUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopicoControllerTest {

    @Autowired
    private lateinit var webAplicationContext: WebApplicationContext

    @Autowired
    private lateinit var jwt: JWTUtil


    private lateinit var mockMvc: MockMvc

    private var token: String? = null

    companion object {
        private const val RECURSO = "/topicos"
        private const val RECURSO_ID = RECURSO.plus("/%s")
    }

    @BeforeEach
    fun setUp() {
        token = gerarToken()
        mockMvc = MockMvcBuilders.webAppContextSetup(webAplicationContext).apply<DefaultMockMvcBuilder?>(
            SecurityMockMvcConfigurers.springSecurity()
        ).build()

    }

    @Test
    fun `deve retornnar codigo 400 quando chamar topicos sem token`() {
        mockMvc.get(RECURSO).andExpect { status { is4xxClientError() } }
    }

    @Test
    fun `deve retornar codigo 200 quando chamar topicos com token`() {
        mockMvc.get(RECURSO) {
            headers { token?.let { this.setBearerAuth(it) } }
        }.andExpect { status { is2xxSuccessful() } }
    }
    @Test
    fun `deve retornar codigo 200 quando chamar topico por id com token`() {
        mockMvc.get(RECURSO_ID.format("1")) {
            headers { token?.let { this.setBearerAuth(it) } }
        }.andExpect { status { is2xxSuccessful() } }
    }


    private fun gerarToken(): String? {
        val authorities = mutableListOf(br.com.alura.forum.model.Role(1, "LEITURA_ESCRITA"))
        return jwt.generateToken("ana@email.com", authorities)
    }

    @Test
    fun `deve rethornar codigo 200 quando chamar topico por id com token`() {
        println("Token gerado: $token")

        val result = mockMvc.get(RECURSO_ID.format("1")) {
            headers { token?.let { this.setBearerAuth(it) } }
        }.andDo {
            print()
        }.andExpect {
            status { is2xxSuccessful() }
        }.andReturn()

        val responseContent = result.response.contentAsString
        println("Resposta: $responseContent")
    }

}
