/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeep.controle;

import com.eeep.dao.FilmeDAO;
import com.eeep.excecoes.AdicionarException;
import com.eeep.excecoes.BuscaException;
import com.eeep.model.Filme;
import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public class FilmeControle {
    FilmeDAO dao = new FilmeDAO();
    public void salvarFilme(Filme filme)throws AdicionarException{
        try{
            this.buscarPorCodigo(filme.getCodigo());
            throw new AdicionarException("Filme já cadastrado");
        }catch(BuscaException e){
            dao.cadastrarFilme(filme);
        }
    }
    
    public Filme buscarPorCodigo(int codigo)throws BuscaException{
        Filme filme = dao.buscarPorCodigo(codigo);
        if(filme!=null){
            return filme;
        }else{
            throw new BuscaException("Filme não encontrado.");
        }
    }
    public ArrayList<Filme> buscarPorNome(String nome) throws BuscaException{
        ArrayList<Filme> filmes = dao.buscarPorNome(nome);
        if(filmes.size()!=0){
            return filmes;
        }else{
            throw new BuscaException("Filme não encontrado");
        }
    }
    public ArrayList<Filme> listar(){
        return dao.listar();
    }
    
    public void deletarFilmePorCodigo(int codigo) throws BuscaException{
        this.buscarPorCodigo(codigo);
        dao.deletarFilmePorCodigo(codigo);
    }
    
    public void atualizarNomePorCodigo(int codigo, String nome) throws BuscaException{
        this.buscarPorCodigo(codigo);
        dao.atualizarNomePorCodigo(codigo, nome);
    }
}
