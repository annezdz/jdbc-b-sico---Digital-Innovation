package exercicioJDBC;

import part3.Aluno;
import part3.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CursoDAO {

    public List<Curso> list() {
        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {

            PreparedStatement prst = conn.prepareStatement("SELECT * FROM curso");
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("duracao_horas"));
                cursos.add(curso);
            }

        } catch (Exception e) {

        }
        return cursos;
    }
    // 1.1 - Consulta com filtro
    public Curso getById(int id) {
        //Preparar objeto aluno para receber os valores do banco de dados.
        Aluno aluno = new Aluno();

        try (Connection conn = ConnectionFactory.getConnection()) {
            //Preparar consulta SQL
            String sql = "SELECT * FROM aluno WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            //Guardar valores retornados da tabela aluno no objeto aluno
            if (rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de alunos FALHOU!");
            e.printStackTrace();
        }

        //Retorna aluno encontrado no banco de dados.
        return aluno;
    }

    // 2 - Inserção
    public void create(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para inserção de dados do aluno.
            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES(?, ?)";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1 , curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());

            //Executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }

    // 3 - Delete
    public void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para deletar uma linha.
            String sql = "DELETE FROM curso WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            //Executa delete e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }

    // 4 - Atualizar
    public void update(Curso curso) {
        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar SQL para atualizar linhas.
            String sql = "UPDATE curso SET nome = ?, duracao_curso = ? WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());

            //Executa atualização e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }



}


