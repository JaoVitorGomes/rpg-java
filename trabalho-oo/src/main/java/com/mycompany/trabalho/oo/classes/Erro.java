/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo.classes;

/**
 *
 * @author João Vitor e Yan
 */

public class Erro extends RuntimeException {
    
    public Erro(){
        super("ocorreu um erro na execução, verifique os dados novamente e tente outra vez");
    }
    
}
