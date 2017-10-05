/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeep.controle;

import com.eeep.dao.PessoaDAO;
import com.eeep.excecoes.AdicionarException;
import com.eeep.excecoes.BuscaException;
import com.eeep.model.Filme;
import com.eeep.model.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public class PessoaControle {
    PessoaDAO dao = new PessoaDAO();
    
    public void salvarPessoa(Pessoa pessoa)throws AdicionarException{
        try{
            this.buscarPorCpf(pessoa.getCpf());
            throw new AdicionarException("Pessoa já cadastrada");
        }catch(BuscaException e){
            dao.cadastrarPessoa(pessoa);
        }
    }
    
    
    public Pessoa buscarPorCpf(String cpf)throws BuscaException{
        Pessoa pessoa = dao.buscarPorCpf(cpf);
        if(pessoa!=null){
            return pessoa;
        }else{
            throw new BuscaException("Filme não encontrado.");
        }
    }
    
    public ArrayList<Pessoa> buscarPorNome(String nome)throws BuscaException{
        ArrayList<Pessoa> pessoas = dao.buscarPorNome(nome);
        if(pessoas.size()>0){
            return pessoas;
        }else{
            throw new BuscaException("Nenhuma pessoa encontrada");
        }
    }
}
