/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistajunior.controller;

import com.analistajunior.dao.AlunoDAO;
import com.analistajunior.model.Aluno;
import com.analistajunior.util.NegocioException;

/**
 *
 * @author Junior
 */
public class AlunoController {
    AlunoDAO alunoDao = new AlunoDAO();
    
    public void cadastrarAluno(Aluno aluno) throws NegocioException{
        try{
            this.buscarPorCpf(aluno.getCpf());
            throw new NegocioException("Aluno já cadastrado");
        }catch(NegocioException e){
            alunoDao.cadastrarAluno(aluno);
        }
        
    }
    
    public void deletarAlunoPorCpf(String cpf) throws NegocioException{
        this.buscarPorCpf(cpf);
        alunoDao.deletarAlunoPorCpf(cpf);
    }
    
    public void atualizarAluno(String cpf, Aluno aluno) throws NegocioException{
        this.buscarPorCpf(cpf);
        alunoDao.atualizarAluno(cpf, aluno);
    }
    
    public Aluno buscarPorCpf(String cpf) throws NegocioException{
        if(alunoDao.buscarPorCpf(cpf)!=null){
            return alunoDao.buscarPorCpf(cpf);
        }else{
            throw new NegocioException("Aluno não encontrado");
        }
    }
}
