/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo.classes;

/**
 *
 * @author jv
 */
public class Enemy {
    //variables
    private String name;
    private int health;
    private int damage;
    private int maxHealth;

    public Enemy(String name, int health,int maxHealth, int damage) {
        // Set values
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }


    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
    
    public String attack(Character player) {
        player.takeDamage(this.damage);
        return (getName() + " ataca " + player.getName() + ".");
    }
    
    //Mudanca do Yan
    
    public void reviver() {
        this.health = this.maxHealth;
    }
}