package br.com.alugames.principal

import br.com.alugames.modelo.Jogo
import br.com.alugames.servicos.ConsumoAPI
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    print("Digite um codigo de jogo para buscar: ")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoAPI()
    val informacaoJogo = buscaApi.buscarJogo(busca)

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente novamente!")
    }

    resultado.onSuccess {
        print("Deseja inserir uma descrição personalizada? (S/N) -> ")
        val opcao = leitura.nextLine()

        if (opcao.equals("s", true)) {
            print("Insira a descrição do jogo: ")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }

        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso.")
    }


}