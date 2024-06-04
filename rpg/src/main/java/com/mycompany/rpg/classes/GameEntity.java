/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.rpg.classes;

/**
 *
 * @author JV
 */

// O objetivo dessa interface é criar uma "regra" que todas as entidades devem ter, retirando os getters e setters
// sendo assim, abrangendo o Character e o Enemy

public interface GameEntity {
    boolean isAlive();
    void reviver();
    void takeDamage(int damage);
    
}
