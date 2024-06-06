package com.mycompany.rpg.view;

import javax.swing.JFrame;

import com.mycompany.rpg.logica.Logic;

public class Game1 extends JFrame {
    

    public Game1(){
        add(new Logic());
        setTitle("RPG-JAVA");
        setSize(1024,728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }


    public static void main(String []args){
        new Game1();
    }
}
