package application

import dominio.Estudante
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import jakarta.persistence.PersistenceException

fun main() {
var Estudante1 = Estudante("Matheus","20252pa-0100024","Ciência da computação","Noturno",1);
var Estudante2 = Estudante("Rian","20252pa-0100026","Análise e desenvolvimento de sistemas","Vespertino",4);
var Estudante3 = Estudante("Lucas","20252pa-0100036","Engenharia de Software","Matutino",2);


    var efm:  EntityManagerFactory = Persistence.createEntityManagerFactory("kotlin_jpa");
    var em: EntityManager = efm.createEntityManager();

    try {
        em.transaction.begin();
        em.persist(Estudante1);
        em.persist(Estudante2);
        em.persist(Estudante3);



        em.transaction.commit();

        println("Done!");
    }catch (ex: Exception){
        if(em.transaction.isActive){
            em.transaction.rollback();
        }
        ex.printStackTrace();
    }finally {
        em.close();
        efm.close();
    }

    val jpql = "SELECT e FROM Estudante e";
    val query = em.createQuery(jpql, Estudante::class.java);
    val listandoEveryone: List<Estudante> = query.resultList;

    println("----Listando everyone----");
    listandoEveryone.forEach {estudantes-> println(estudantes);}

    println("-----Listando quem começa com 'M'");
    val listandoComM = listandoEveryone.filter { estudante -> estudante.nome?.startsWith("M", ignoreCase = true)==true }
    listandoComM.forEach {estudante -> println(estudante)};

    println("----- Listando com quem tem mais de duas depêndencias-----");
    val dependenciasMaiorqueDois = listandoEveryone.filter { it.dp>2};
    dependenciasMaiorqueDois.forEach {estudante -> println(estudante)};
    }


