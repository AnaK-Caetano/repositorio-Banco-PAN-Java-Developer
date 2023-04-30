import desafio.DIO.dominio.Curso;
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


        System.out.println(cursoA);
        System.out.println(cursoB);
        System.out.println(mentoria);

    }
}
