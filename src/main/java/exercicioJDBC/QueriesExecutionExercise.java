package exercicioJDBC;

import part3.Aluno;
import part3.AlunoDAO;

import java.util.List;

public class QueriesExecutionExercise {
    public static void main(String[] args) {

            CursoDAO cursoDAO = new CursoDAO();

            // =========================== 1 - Consulta =================================================
//        List<Curso> cursos = cursoDAO.list();
//        cursos.stream().forEach(System.out::println);



            // =========================== 2 - Inserção =================================================
//        Curso cursoParaInsercao = new Curso(
//                "C#",
//                100
//        );
//        cursoDAO.create(cursoParaInsercao);
//


            // =========================== 3 - Delete ===================================================
            cursoDAO.delete(3);


            // =========================== 4 - Atualizar ================================================
//        Aluno alunoParaAtualizar = alunoDAO.getById(3);
//        alunoParaAtualizar.setNome("Joaquim");
//        alunoParaAtualizar.setIdade(18);
//        alunoParaAtualizar.setEstado("RS");

            //alunoDAO.update(alunoParaAtualizar);
        }

    }
