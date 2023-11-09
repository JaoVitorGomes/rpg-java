/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo;

/**
 *
 * @author jv
 */
public class Enemy {
    private String name;
    private int health;
    private int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    
    public void setHealth(int damage){
        this.health = this.health - damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
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
    
    public void attack(Character player) {
        System.out.println(getName() + " attacks " + player.getName() + " with a dagger.");
        player.setHealth(this.damage);
    }
}