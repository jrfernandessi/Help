/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eeep.model;

import java.util.Date;

/**
 *
 * @author Junior
 */
public class Aluguel {
    private Filme filme;
    private Pessoa pessoa;
    private Date aluguel;
    private Date devolucao;

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getAluguel() {
        return aluguel;
    }

    public void setAluguel(Date aluguel) {
        this.aluguel = aluguel;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }
    
    
}
