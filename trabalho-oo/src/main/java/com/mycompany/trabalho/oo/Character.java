/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo;

/**
 *
 * @author jv
 */
public abstract class Character {
    private String name;
    private int health;
    public int attackPower;

    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attackPower = attack;
    }
    public abstract int message();
    public abstract void attack(Enemy opponent, int attack);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
        }
    }
    
    public int getAttackPower() {
        return attackPower;
    }

    
    public boolean isAlive() {
        return health > 0;
    }
}
