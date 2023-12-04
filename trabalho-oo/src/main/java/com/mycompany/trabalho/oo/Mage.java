/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo;
import java.util.*;
/**
 *
 * @author jv
 */
public class Mage extends Character {
    public Mage(String name, int health,int attack) {
        super(name, health,attack);
    }

    @Override
    public void attack(Enemy opponent, int attack) {
        switch(attack){
            case 0: {
                System.out.println(getName() + " ataca " + opponent.getName() + " com fireball.");
                opponent.takeDamage(this.attackPower);
            }
            case 1: {
                System.out.println(getName() + " ataca " + opponent.getName() + " com a mão.");
                opponent.takeDamage(this.attackPower / 2);
            }
        }
    }
    
    @Override
    public int message(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Como você deseja atacar");
        System.out.println("0: atacar com magia\n 1:atacar com a mão");
        return teclado.nextInt();
    }
}
