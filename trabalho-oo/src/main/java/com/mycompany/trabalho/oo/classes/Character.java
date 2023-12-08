/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo.classes;

/**
 *
 * @author jv
 */
public abstract class Character {
    private String name;
    private int health;
    private int maxHealth;
    public int attackPower;
    
    //Mudanca do Yan
    private int level = 1;

    public Character(String name, int health,int maxHealth, int attack) {
        this.name = name;
        this.health = health;
        this.attackPower = attack;
        this.maxHealth = maxHealth;
    }
    public abstract int message();
    public abstract String classe();
    public abstract int idClasse();
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
    
    //Mudanca do Yan
    
    public void UPlevel(int lvl) {
        level++;
        this.maxHealth = this.maxHealth + (2 * level);
        this.health = this.health + (2 * level);
        this.attackPower =+ (1 * level * lvl);
    }
    
    public int getLevel(){
        return this.level;
    }
    
    public void Cura(){
        int cura;
        cura = (this.maxHealth / 10) * level * this.attackPower;
        this.health = this.health + cura;
    }
    
    public void reviver() {
        this.health = this.maxHealth;
    }
}
