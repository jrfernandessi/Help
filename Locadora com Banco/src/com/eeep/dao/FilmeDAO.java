/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeep.dao;

import com.eeep.model.Filme;
import com.eeep.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Junior
 */
public class FilmeDAO {

    public void cadastrarFilme(Filme filme) {
        String sql = "insert into filme (codigo_filme, nome_filme)"
                + " values (?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, filme.getCodigo());
            pstm.setString(2, filme.getNome());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Filme buscarPorCodigo(int codigo){
        String sql = "select * from filme where codigo_filme=?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Filme filme = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigo);
            rset = pstm.executeQuery();
            while(rset.next()){
                filme = new Filme();
                filme.setCodigo(rset.getInt("codigo_filme"));
                filme.setNome(rset.getString("nome_filme"));
                
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }
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
        return filme;
    }
}
