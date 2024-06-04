/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg.classes;

/**
 *
 * @author JV
 */

public class Save {
    
    private Character personagem;
    private Enemy inimigo;
    private int level;
    
    public Save(Character personagem, Enemy inimigo, int level){
        this.personagem = personagem;
        this.inimigo = inimigo;
        this.level = level;
    }

    public Character getPersonagem() {
        return personagem;
    }

    public Enemy getInimigo() {
        return inimigo;
    }

    public int getLevel() {
        return level;
    }

    public void setPersonagem(Character personagem) {
        this.personagem = personagem;
    }

    public void setInimigo(Enemy inimigo) {
        this.inimigo = inimigo;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    
}
