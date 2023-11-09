/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo;

/**
 *
 * @author jv
 */
public class Mage extends Character {
    public Mage(String name, int health,int attack) {
        super(name, health,attack);
    }

    @Override
    public void attack(Enemy opponent) {
        System.out.println(getName() + " attacks " + opponent.getName() + " with a fireball.");
        opponent.setHealth(opponent.getHealth() - 10);
    }
}
