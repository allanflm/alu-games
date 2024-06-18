package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo

class JogosDAO {
    fun getJogos(): List<Jogo> {
        val manager = Banco.getEntityManager()
        try {
            val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
            return query.resultList.map { entity ->
                Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id)
            }
        } finally {
            manager.close()
        }
    }
}