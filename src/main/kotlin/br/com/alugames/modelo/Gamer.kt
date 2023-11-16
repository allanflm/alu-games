package br.com.alugames.modelo

import java.lang.IllegalArgumentException
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    var dataDeNascimento: String? = null
    var usuario: String? = null
        set(value){
            field = value
            if(idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }
    var idInterno: String? = null
        private set

    constructor(nome: String, email: String, dataDeNascimento: String, usuario: String) :
            this(nome, email) {
        this.dataDeNascimento = dataDeNascimento
        this.usuario = usuario
    }

    init {
        if(nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome esta em branco!")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer(Nome = $nome, Email = $email, Data de nascimento = $dataDeNascimento, usuario = $usuario"
    }

    fun criarIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)) {
            return email
        }else{
            throw IllegalArgumentException("Email invalido!")
        }
    }
}
