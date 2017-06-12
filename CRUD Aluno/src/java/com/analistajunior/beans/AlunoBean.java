/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistajunior.beans;

import com.analistajunior.controller.AlunoController;
import com.analistajunior.model.Aluno;
import com.analistajunior.util.NegocioException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Junior
 */
@ManagedBean
@RequestScoped
public class AlunoBean {

    Aluno aluno = new Aluno();
    AlunoController controller = new AlunoController();

    public void salvar() {
        try {
            controller.cadastrarAluno(aluno);
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
