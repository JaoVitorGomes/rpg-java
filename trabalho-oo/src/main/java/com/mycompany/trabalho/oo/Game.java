/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo;

/**
 *
 * @author jv
 */
import java.util.*;

public class Game {

    public void startGame() {
        
        
        //variables
        String name;
        int option;
        Scanner teclado = new Scanner(System.in);
        
        // Character and enemy creation logic
        System.out.println("Bem vindo!");
        
        System.out.println("Digite o nome do jogador:");
        name = teclado.nextLine();
        
        System.out.println("Escolha qual classe vai escolher");
        System.out.println("0: Guerreiro, 1: Mago, 2: Ladrão");
        option = teclado.nextInt();
        
        Character player = createCharacter(option, name);
        Enemy enemy = createEnemy();

        // Combat logic
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("\n" + player.getName() + " tem " + player.getHealth() + " de vida.");
            System.out.println(enemy.getName() + " tem " + enemy.getHealth() + " de vida.");
            player.attack(enemy);

            if (enemy.getHealth() > 0) {
                enemy.attack(player);
            }
        }

        // Game over logic
        if (player.getHealth() > 0) {
            System.out.println("\nParabens! " + player.getName() + " você ganhou!");
        } else {
            System.out.println("\n" + player.getName() + " perdeu!.");
        }
    }

    // Create character
    public Character createCharacter(int option, String name) {
        //Character options
        switch(option){
            case 0 -> {
                return new Warrior(name, 200,2);
            }
            case 1 -> {
                return new Mage(name,75,6);
            }
            case 2 -> {
                return new Thief(name, 100, 5);
            }
        }
        return new Thief(name, 100, 5);
    }

    // Create Enemy
    public Enemy createEnemy() {
        return new Enemy("Goblin fraco", 50,2);
    }
}