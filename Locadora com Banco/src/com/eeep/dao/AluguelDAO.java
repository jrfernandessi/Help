/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeep.dao;

import com.eeep.model.Aluguel;
import com.eeep.model.Filme;
import com.eeep.model.Pessoa;
import com.eeep.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public class AluguelDAO {
    public void salvarAluguel(Aluguel aluguel){
        String sql = "insert into aluguel(cpf_pessoa, codigo_filme, data_aluguel, data_devolucao) values (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, aluguel.getPessoa().getCpf());
            pstm.setInt(2, aluguel.getFilme().getCodigo());
            Date dataAluguel = new Date(aluguel.getDataAluguel().getTime());
            Date dataDevolucao = new Date(aluguel.getDataDevolucao().getTime());
            pstm.setDate(3, dataAluguel);
            pstm.setDate(4, dataDevolucao);
            pstm.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public ArrayList<Aluguel> buscar(String campo){
        String sql = "select * from aluguel as a, filme as f, pessoa as p where a.cpf_pessoa=p.cpf_pessoa and f.codigo_filme = a.codigo_filme  and (nome_pessoa like ? or nome_filme like ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%"+campo+"%");
            pstm.setString(2, "%"+campo+"%");
            rset = pstm.executeQuery();
            while(rset.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setCpf(rset.getString("cpf_pessoa"));
                pessoa.setNome(rset.getString("nome_pessoa"));
                
                Filme filme = new Filme();
                filme.setCodigo(rset.getInt("codigo_filme"));
                filme.setNome(rset.getString("nome_filme"));
                
                Aluguel aluguel = new Aluguel();
                aluguel.setPessoa(pessoa);
                aluguel.setFilme(filme);
                aluguel.setDataAluguel(rset.getDate("data_aluguel"));
                aluguel.setDataDevolucao(rset.getDate("data_devolucao"));
                
                alugueis.add(aluguel);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }if(pstm!=null){
                    pstm.close();
                }if(conn!=null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return alugueis;
        
    }

    public ArrayList<Aluguel> listar() {
        String sql = "select * from aluguel as a, filme as f, pessoa as p where a.cpf_pessoa=p.cpf_pessoa and f.codigo_filme = a.codigo_filme";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setCpf(rset.getString("cpf_pessoa"));
                pessoa.setNome(rset.getString("nome_pessoa"));
                
                Filme filme = new Filme();
                filme.setCodigo(rset.getInt("codigo_filme"));
                filme.setNome(rset.getString("nome_filme"));
                
                Aluguel aluguel = new Aluguel();
                aluguel.setPessoa(pessoa);
                aluguel.setFilme(filme);
                aluguel.setDataAluguel(rset.getDate("data_aluguel"));
                aluguel.setDataDevolucao(rset.getDate("data_devolucao"));
                
                alugueis.add(aluguel);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }if(pstm!=null){
                    pstm.close();
                }if(conn!=null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return alugueis;
        
    }
}
