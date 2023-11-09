/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo;

/**
 *
 * @author jv
 */
import java.util.Scanner;

public class Game {

    public void startGame() {
        // Character creation logic
        Character player = createCharacter();
        Enemy enemy = createEnemy();

        // Combat logic
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("\n" + player.getName() + " has " + player.getHealth() + " health.");
            System.out.println(enemy.getName() + " has " + enemy.getHealth() + " health.");
            player.attack(enemy);

            if (enemy.getHealth() > 0) {
                enemy.attack(player);
            }
        }

        // Game over logic
        if (player.getHealth() > 0) {
            System.out.println("\nCongratulations! " + player.getName() + " has won!");
        } else {
            System.out.println("\n" + player.getName() + " has lost.");
        }
    }

    public Character createCharacter() {
        return new Thief("Player 1", 100, 5);
    }

    public Enemy createEnemy() {
        return new Enemy("Enemy 1", 50,2);
    }
}