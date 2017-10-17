/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeep.dao;

import com.eeep.model.Aluguel;
import com.eeep.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
