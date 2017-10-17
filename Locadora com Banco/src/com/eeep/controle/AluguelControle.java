/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeep.controle;

import com.eeep.dao.AluguelDAO;
import com.eeep.excecoes.BuscaException;
import com.eeep.model.Aluguel;
import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public class AluguelControle {
    AluguelDAO dao = new AluguelDAO();
    FilmeControle filmeControle = new FilmeControle();
    PessoaControle pessoaControle = new PessoaControle();
    
    public void salvarAluguel(Aluguel aluguel)throws BuscaException{
        filmeControle.buscarPorCodigo(aluguel.getFilme().getCodigo());
        pessoaControle.buscarPorCpf(aluguel.getPessoa().getCpf());
        dao.salvarAluguel(aluguel);
    }
    
    public ArrayList<Aluguel> buscar(String campo){
        return dao.buscar(campo);
    }
    
    public ArrayList<Aluguel> listar(){
        return dao.listar();
    }
}
