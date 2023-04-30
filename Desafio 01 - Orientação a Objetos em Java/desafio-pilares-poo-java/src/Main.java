import desafio.DIO.dominio.Bootcamp;
import desafio.DIO.dominio.Curso;
import desafio.DIO.dominio.Dev;
import desafio.DIO.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso cursoA = new Curso();

        cursoA.setTitulo("Aprendendo Java");
        cursoA.setDescricao("Primeiros passos na linguagem Java");
        cursoA.setCargaHoraria(100);

        Curso cursoB = new Curso();

        cursoB.setTitulo("Aprendendo react");
        cursoB.setDescricao("Primeiros passos na linguagem js e integração com react");
        cursoB.setCargaHoraria(95);


        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria em java");
        mentoria.setDescricao("Tire suas dúvidas em java");
        mentoria.setData(LocalDate.now());


        /*
        System.out.println(cursoA);
        System.out.println(cursoB);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Banco Pan Java developer 2023");
        bootcamp.setDescricao("O programa é uma trilha de 114 horas com cursos, desafios práticos e mentorias em tecnologias essenciais para back-end, de banco de dados e SpringBoot. ");
        bootcamp.getConteudos().add(cursoA);
        bootcamp.getConteudos().add(cursoB);
        bootcamp.getConteudos().add(mentoria);


        Dev devAna = new Dev();
        devAna.setNome("Ana K");
        devAna.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos de Ana" + devAna.getConteudosInscritos());

        devAna.progredir();
        System.out.println("-");
        System.out.println("Conteudos inscritos de Ana" + devAna.getConteudosInscritos());
        System.out.println("Conteudos finalizados de Ana" + devAna.getConteudosFinalizados());
        System.out.println("XP é :" + devAna.calcularTotalXp());


        System.out.println("----------");



        Dev devJack = new Dev();
        devJack.setNome("Jacqueline");
        devJack.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos inscritos de Jack" + devJack.getConteudosInscritos());

        devJack.progredir();
        devJack.progredir();
        devJack.progredir();
        System.out.println("-");
        System.out.println("Conteudos inscritos de Jack" + devJack.getConteudosInscritos());
        System.out.println("Conteudos finalizados de Jack" + devJack.getConteudosFinalizados());
        System.out.println("XP é :" + devJack.calcularTotalXp());
    }
}
