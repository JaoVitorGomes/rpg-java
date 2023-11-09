/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo;

/**
 *
 * @author jv
 */
public class Thief extends Character {
    public Thief(String name, int health,int attack) {
        super(name, health,attack );
    }
    

    @Override
    public void attack(Enemy opponent) {
        System.out.println(getName() + " ataca " + opponent.getName() + " com uma adaga.");
        opponent.takeDamage(this.attackPower);
    }
}