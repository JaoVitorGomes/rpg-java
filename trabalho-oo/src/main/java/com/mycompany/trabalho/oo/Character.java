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
    private int maxHealth;
    public int attackPower;

    public Character(String name, int health,int maxHealth ,int attack) {
        this.name = name;
        this.health = health;
        this.attackPower = attack;
        this.maxHealth = maxHealth;
    }
    public abstract int message();
    public abstract String classe();
    public abstract String attack(Enemy opponent, int attack);    


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    
    public int getMaxHealth() {
        return maxHealth;
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
