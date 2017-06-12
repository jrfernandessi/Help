/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistajunior.dao;

import com.analistajunior.model.Aluno;
import com.analistajunior.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior
 */
public class AlunoDAO {

    public void cadastrarAluno(Aluno aluno) {
        Connection conn = null;
        PreparedStatement pstm = null;
        //consulta sql a ser executada
        //aqui eh para mudar de acordo com o seu programa
        String sql = "insert "
                + "into aluno(cpf_aluno, nome_aluno)"
                + " values(?, ?)";

        try {
            //cria a conexao com o banco
            conn = ConnectionFactory.getConexao();
            //inicia a preparacao para a consulta
            pstm = conn.prepareStatement(sql);
            //so vai mudar essa parte
            //esta sendo colocado os valores dos conringas
            //fique alerta com o tipo do dado
            pstm.setString(1, aluno.getCpf());
            pstm.setString(2, aluno.getNome());
            //comando para executar o sql
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //no finally eh fechado a conexao
            //primeiro fecha o preparedstatement
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Aluno buscarPorCpf(String cpf) {
        //consulta sql a ser executada
        //aqui eh para mudar de acordo com o seu programa
        String sql = "select * from aluno"
                + " where cpf_aluno=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        //resultaSet eh responsavel por receber todas as tuplas da consulta
        ResultSet rset = null;

        try {
            //cria a conexao com o banco
            conn = ConnectionFactory.getConexao();
            //inicia a preparacao para a consulta
            pstm = conn.prepareStatement(sql);
            //so vai mudar essa parte
            //esta sendo colocado os valores dos conringas
            //fique alerta com o tipo do dado
            pstm.setString(1, cpf);
            //comando para executar a consulta com select
            rset = pstm.executeQuery();

            Aluno aluno = new Aluno();
            //while para passar por todas as tuplas
            while (rset.next()) {
                //aqui voce muda
                //preenchendo o objeto cuidado com o tipo do dado e com nome da coluna
                aluno.setCpf(rset.getString("cpf_aluno"));
                aluno.setNome(rset.getString("nome_aluno"));
                return aluno;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void deletarAlunoPorCpf(String cpf) {
        String sql = "delete from aluno where cpf_aluno=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizarAluno(String cpf, Aluno aluno) {
        String sql = "update aluno "
                + "set cpf_aluno=?, nome_aluno=?"
                + "where cpf_aluno=?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, aluno.getCpf());
            pstm.setString(2, aluno.getNome());
            pstm.setString(3, cpf);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
