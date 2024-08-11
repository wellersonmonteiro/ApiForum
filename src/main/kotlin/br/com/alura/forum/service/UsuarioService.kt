package br.com.alura.forum.service

import br.com.alura.forum.infrastruture.ConexaoCep
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>, var obterporcep: ConexaoCep){
    init {

        val usuario = Usuario(
            id =1,
            nome = "Ana da Silva",
            email = "ana@email.com",
            endereco = obterporcep.getData("01001000")
        )
        val usuario2 = Usuario(
            id =2,
            nome = "Rafael dos Santos",
            email = "usuario2@email.com",
            endereco = obterporcep.getData("01001000")

        )
        usuarios = Arrays.asList(usuario, usuario2)
    }

    fun buscaPorId(id: Long): Usuario {
        return usuarios.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}

