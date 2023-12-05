/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo;

import java.util.Scanner;

/**
 *
 * @author jv
 */
public class Thief extends Character {
    public Thief(String name, int health,int maxHealth,int attack) {
        super(name, health,maxHealth,attack );
    }
    

    @Override
    public String attack(Enemy opponent, int attack) {
        switch(attack){
            case 0: {
                opponent.takeDamage(this.attackPower);
                return (getName() + " ataca " + opponent.getName() + " com a adaga.");
            }
            case 1: {
                opponent.takeDamage(this.attackPower / 2);
                return (getName() + " ataca " + opponent.getName() + " com a mão.");
            }
            
            default:{
                return (getName() + " errou o ataque");
            }
        }
    }
    
    @Override
    public int message(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Como você deseja atacar");
        System.out.println("0: atacar com a adaga\n 1:atacar com a mão");
        return teclado.nextInt();
    }
    
    @Override
    public String classe(){
        return "ladrão";
    }
}