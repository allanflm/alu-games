package br.com.alugames.principal
import br.com.alugames.modelo.Gamer

fun main(){
    val gamer1 = Gamer("Allan", "allan@email.com")
    println(gamer1)

    val gamer2 = Gamer(
        "AllanFm",
        "allan@email.com",
        "09/09/2003",
        "allanfm0")

    println(gamer2)

    gamer1.let {
        it.dataDeNascimento = "09/09/2003"
        it.usuario = "allanfm10"

    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "allanf"
    println(gamer1)
}