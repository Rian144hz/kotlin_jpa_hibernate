package dominio

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Estudante")
class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
     var nome: String? = null;
     var matricula: String? = null;
     var curso: String? = null;
     var turno: String? = null;
    @Column(name = "dependencias")
     var dp: Int = 0;

    constructor();

    constructor(nome: String?, matricula: String?, curso: String?, turno: String?, dp: Int) {
        this.nome = nome
        this.matricula = matricula
        this.curso = curso
        this.turno = turno
        this.dp = dp
    }




    override fun toString(): String {
        return "Estudante(nome=$nome, matricula=$matricula, curso=$curso, turno=$turno, dp=$dp)"
    }


}