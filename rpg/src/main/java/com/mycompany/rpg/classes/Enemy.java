/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg.classes;

/**
 *
 * @author JV
 */

// O objetivo dessa classe é a criação dos inimigos, com todos os dados necessario para a criação deles

public class Enemy implements GameEntity{
    //variables
    private String name;
    private int health;
    private int damage;
    private int maxHealth;
    private int armor;
    private int speed;

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
    
    public int getSpeed() {
        return this.speed;
    }
    
    
    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
    
    public String attack(Character player) {
        player.takeDamage(this.damage);
        return (getName() + " ataca " + player.getName() + ".");
    }
    
    //Mudanca do Yan
    @Override
    public void reviver() {
        this.health = this.maxHealth;
    }

    
}