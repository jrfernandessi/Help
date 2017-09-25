/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeep.controle;

import com.eeep.dao.FilmeDAO;
import com.eeep.model.Filme;

/**
 *
 * @author Junior
 */
public class FilmeControle {
    FilmeDAO dao = new FilmeDAO();
    public void salvarFilme(Filme filme){
        dao.cadastrarFilme(filme);
    }
}
