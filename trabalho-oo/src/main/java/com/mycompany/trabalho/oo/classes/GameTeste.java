///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.trabalho.oo.classes;
//
///**
// *
// * @author jv
// */
//import java.util.*;
//
//public class GameTeste {
//
//    public void startGame() {
//        
//        
//        //variables
//        String name;
//        int option, attack;
//        Scanner teclado = new Scanner(System.in);
//        
//        // Character and enemy creation logic
//        System.out.println("Bem vindo!");
//        
//        System.out.println("Digite o nome do jogador:");
//        name = teclado.nextLine();
//        
//        System.out.println("Escolha qual classe vai escolher");
//        System.out.println("0: Guerreiro, 1: Mago, 2: Ladrão");
//        option = teclado.nextInt();
//        
//        Character player = createCharacter(option, name);
//        Enemy enemy = createEnemy();
//
//        System.out.println("\n um "+ enemy.getName() + " apareceu!");
//        // Combat logic
//        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
//            
//
//            attack = player.message();
//            player.attack(enemy, attack);
//            System.out.println(enemy.getName() + " tem " + enemy.getHealth() + " de vida.");
//            if (enemy.getHealth() > 0) {
//                enemy.attack(player);
//            }
//            
//        }
//
//        // Game over logic
//        if (player.getHealth() > 0) {
//            System.out.println("\nParabens! " + player.getName() + " você ganhou!");
//        } else {
//            System.out.println("\n" + player.getName() + " perdeu!.");
//        }
//    }
//
//    // Create character
//    public Character createCharacter(int option, String name) {
//        //Character options
//        switch(option){
//            case 0: {
//                return new Warrior(name, 20,20,2);
//            }
//            case 1: {
//                return new Mage(name,6,6,6);
//            }
//            case 2: {
//                return new Thief(name, 10,10, 5);
//            }
//        }
//        return new Thief(name, 10,10, 5);
//    }
//
//    // Create Enemy
//    public Enemy createEnemy() {
//        return new Enemy("Goblin fraco", 10,10,2);
//    }
//}