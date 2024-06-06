/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg.logica;

import java.awt.*;
import javax.swing.*;

import com.mycompany.rpg.classes.Enemy;
import com.mycompany.rpg.classes.Character;

/**
 *
 * @author jv
 */
public class Logic extends JPanel{
    
    private Image fundo;

    private static int level;
    private static int idSave;
        
    private static Character player;
    private static Enemy enemy;

    
    public Logic(){
        ImageIcon ref = new ImageIcon("src/main/java/com/mycompany/rpg/arquivos/images/test.jpg");
        fundo = ref.getImage();

    }

    public void paint(Graphics g){
        Graphics2D grafico = (Graphics2D) g;
        grafico.drawImage(fundo,0,0,null);
        g.dispose();

    }

    public static Character getPlayer() {
        return player;
    }
    
    public static Enemy getEnemy() {
        return enemy;
    }
    
    public static int getLevel(){
        return level;
    }
    
    public static int getIdSave(){
        return idSave;
    
    } 
    
    public static int getPlayerLevel(){
        return player.getLevel();
    }

    public static int getPlayerHealth(){
        return player.getHealth();
    }
    
    public static int getPlayerAttack(){
        return player.getAttackPower();
    }
    
    public static String getPlayerClass(){
        return player.classe();
    
    }
    
    public static void setPlayer(Character player){
        Logic.player = player;
    }

    public static void setEnemy(Enemy enemy){
        Logic.enemy = enemy;
    }
    
    public static void setLevel(int level) {
        Logic.level =  level;
    }

    public static void setIdSave(int idSave) {
        Logic.idSave = idSave;
    }
    
    public static void setPlayerDamage(int damage){
        player.takeDamage(damage);
    }
    
    public static boolean initializate(){
        if(player.speed() < enemy.getSpeed()){
            enemy.attack(player);
                return player.getHealth()<= 0;
        }else{
            return false;
        }
        
    
    }
    
    // public static boolean verify(){
        
    //     switch(vez){
    //         case 0:
                
    //             break;
                
                
    //         case 1:
    //             break;
            
    //         default:
    //             break;
                
    //     }
                 
        
        
    // }
    
}
