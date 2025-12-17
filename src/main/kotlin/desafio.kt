enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun printMatriculados() {
        for (item in inscritos) {
            println(item.nome)
        }
    }

    fun printConteudoEducacional() {
        for (item in conteudos) {
            val nivel = when (item.nivel) {
                Nivel.BASICO -> "Basico"
                Nivel.INTERMEDIARIO -> "Intermediário"
                Nivel.DIFICIL -> "Dificil"
                else -> "Não definido"
            }
            println("Nome = ${item.nome}, Nivel = $nivel, Duração = ${item.duracao}")

        }
    }
}

fun main() {
    val ce = listOf(
        ConteudoEducacional("Fluxogramas", Nivel.BASICO, 10),
        ConteudoEducacional("Algoritimos de lógica de programação", Nivel.BASICO, 20),
        ConteudoEducacional("Desenvolvimento javascript", Nivel.INTERMEDIARIO, 30),
        ConteudoEducacional("Desenvolvimento C/C++", Nivel.DIFICIL, 30)
    )

    val formacao = Formacao("Lógica de Programação", ce)


    formacao.matricular(Usuario("Rodrigo Gomes"))
    formacao.matricular(Usuario("Joaozinho"))

    formacao.printMatriculados()
    formacao.printConteudoEducacional()
}