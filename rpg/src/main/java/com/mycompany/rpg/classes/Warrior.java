/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg.classes;

import java.util.Scanner;

/**
 *
 * @author JV
 */

// O objetivo dessa classe é criar a classe guerreiro para o jogador

public class Warrior extends Character {
    public Warrior(String name, int health,int maxHealth, int attack) {
        super(name, health,maxHealth, attack);
    }

    @Override
    public String attack(Enemy opponent, int attack) {
        switch(attack){
            case 0: {
                opponent.takeDamage(this.getAttackPower());
                return (getName() + " ataca " + opponent.getName() + " com a espada longa.");
            }
            case 1: {
                opponent.takeDamage(this.getAttackPower() / 2);
                return (getName() + " ataca " + opponent.getName() + " com a mão.");
            }
            
            default: {
                return (getName() + " errou");
            }
        }
    }
    @Override
    public int message(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Como você deseja atacar");
        System.out.println("0: atacar com a espada longa\n 1:atacar com a mão");
        return teclado.nextInt();
    }
    
    @Override
    public String classe(){
        return "guerreiro";
    }
    
    @Override
    public int idClasse() {
        return 0;
    }
}