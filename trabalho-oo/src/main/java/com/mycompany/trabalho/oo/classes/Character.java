/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo.classes;

/**
 *
 * @author João Vitor e Yan
 */

// O objetivo dessa classe é adicionar os elementos necessarios para um jogador, sendo que dados mais especifico fica
// na propria classe da classe

public abstract class Character implements GameEntity{
    private String name;
    private int health;
    private int maxHealth;
    public int attackPower;
    
    //Mudanca do Yan
    private int level = 1;

    public Character(String name, int health,int maxHealth, int attack){
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
    
    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
        }
    }
    
    public int getAttackPower() {
        return attackPower;
    }

    
    @Override
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
        if(this.health + cura > this.maxHealth){
            this.health = this.maxHealth;
        }else{
            this.health = this.health + cura;
        }
        
    }
    
    @Override
    public void reviver() {
        this.health = this.maxHealth;
    }
}
