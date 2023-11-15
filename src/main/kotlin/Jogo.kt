data class Jogo(
    val titulo: String,
    val capa: String
) {
    val descricao = ""
    override fun toString(): String {
        return "Titulo: $titulo \n" +
                "Capa: $capa\n" +
                "Descricao: $descricao"
    }


}