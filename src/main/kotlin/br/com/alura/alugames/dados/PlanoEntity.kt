package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(val tipo: String)

@Entity
@DiscriminatorValue("Avulso")
class PlanoAvulsoEntity(tipo: String) : PlanoEntity(tipo)

@Entity
@DiscriminatorValue("Assinatura")
class PlanoAssinaturaEntity(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDeDesconto: Double
) : PlanoEntity(tipo) {

}