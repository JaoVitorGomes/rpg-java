/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabalho.oo;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jv
 */
public class Game1 extends javax.swing.JFrame {
    
        private Character player;
        private Enemy enemy;
        private static List<Character> saves = new ArrayList<>();

    /**
     * Creates new form Game1
     */
    public Game1(String nick, int character) {
        try {
            readArchive("./src/main/java/com/mycompany/trabalho/oo/arquivos/saves.txt", "saves");
            logic(nick, character);
            initComponents();

            jProgressBar1.setValue(this.player.getHealth());
            jProgressBar2.setValue(this.enemy.getHealth());
            jTextPane1.setEditable(false);
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
        
        
        
    }

    
    private void logic(String nick, int character){
     String name;
        int option, attack;
        System.out.println(character);

            switch(character){
            case 0: {
                this.player = new Warrior(nick, 20,20,2);
                break;
            }
            case 1: {
                this.player = new Mage(nick,6,6,6);
                break;
            }
            case 2: {
                this.player = new Thief(nick, 10,10, 5);
                break;
            }
        }
         this.enemy = new Enemy("Goblin fraco", 10,2);


    }
    
    private void verify(int hability){
        String message;
        message = this.player.attack(this.enemy, hability);
        jTextPane1.setText(message);
        System.out.println(this.enemy.getHealth());
        jProgressBar2.setValue(this.enemy.getHealth());
        if(this.enemy.getHealth() > 0){
            message = message + "\n" + this.enemy.attack(this.player);
            jProgressBar1.setValue(this.player.getHealth());
            jTextPane1.setText(message);
             
        }else{
        
        if (player.getHealth() > 0) {
            JOptionPane.showMessageDialog(null,"\nParabens  " + this.player.getName() + "! você ganhou!" );
            
        } else {
            JOptionPane.showMessageDialog(null,"\n" + this.player.getName() + " perdeu!." );
            System.out.println("\n" + this.player.getName() + " perdeu!.");
        }
        }
    
    }
    
    
        private static void readArchive(String referencia, String arrayAlvo) throws IOException {
        BufferedReader bufferLeitura = new BufferedReader(new FileReader(referencia));

        String linha = "";
        String linhaArray[];

        while (true) {
            if (linha != null) {
                linhaArray = linha.split("/&&/");
                switch (arrayAlvo) {
                    case "save":
                        addSave(linhaArray);
                        break;
                    case "placar":
                        //addPlacar(linhaArray);
                        break;
                }
            } else {
                break;
            }

            linha = bufferLeitura.readLine();
        }

        bufferLeitura.close();
    }

    private static void escreveArquivo(String referencia, String conteudo) throws IOException {
        BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(referencia));

        bufferEscrita.write(conteudo);

        bufferEscrita.flush();

        bufferEscrita.close();
    }
    
        private static void salvaArquivos() throws IOException {
        String savesConteudo = "";

        for (Character save: saves) {
            if (!save.getName().isBlank()) {
                savesConteudo += save.getName() + "/&&/" + "0" + "/&&/" + save.getHealth()+ "/&&/" + save.getMaxHealth()+ "/&&/" + save.getAttackPower()+ "/&&/" + "0" + "/&&/" + false;
                savesConteudo += "\n";
            }
        }


        escreveArquivo("./src/main/java/com/mycompany/trabalho/oo/arquivos/saves.txt", savesConteudo);

    }
    
    
    
    private static void addSave(String linhaArray[]) {
        String name = "";
        int character = 0;
        int health = 0;
        int maxHealth = 0;
        int attackPower = 0;
        int level = 0;
        boolean isDead = false;

        for (int i = 0; i < linhaArray.length; i++) {
            switch (i) {
                case 0:
                    name = linhaArray[i];
                    break;
                case 1:
                    character = Integer.parseInt(linhaArray[i]);
                    break;
                case 2:
                    health = Integer.parseInt(linhaArray[i]);
                    break;
                case 3:
                    maxHealth = Integer.parseInt(linhaArray[i]);
                    break;
                case 4:
                    attackPower =  Integer.parseInt(linhaArray[i]);
                    break;
                case 5:
                    level = Integer.parseInt(linhaArray[i]);
                    break;
                case 6:
                    isDead = Boolean.parseBoolean(linhaArray[i]);
                    break;
            }
        }
        
        switch(character) {
            case 0:{
                saves.add(new Warrior(name,health,maxHealth,attackPower));
                break;
            }
            case 1:{
                saves.add(new Mage(name,health,maxHealth,attackPower));
                break;
            }
            case 2:{
                saves.add(new Thief(name,health,maxHealth,attackPower));
                break;
            }
        
        }
    }
/**    
    private static void addPlacar(String linhaArray[]) {
        String name = "";
        int character = 0;
        int health = 0;
        int maxHealth = 0;
        int attackPower = 0;
        int level = 0;
        boolean isDead = false;

        for (int i = 0; i < linhaArray.length; i++) {
            switch (i) {
                case 0:
                    name = linhaArray[i];
                    break;
                case 1:
                    character = Integer.parseInt(linhaArray[i]);
                    break;
                case 2:
                    health = Integer.parseInt(linhaArray[i]);
                    break;
                case 3:
                    maxHealth = Integer.parseInt(linhaArray[i]);
                    break;
                case 4:
                    attackPower =  Integer.parseInt(linhaArray[i]);
                    break;
                case 5:
                    level = Integer.parseInt(linhaArray[i]);
                    break;
                case 6:
                    isDead = Boolean.parseBoolean(linhaArray[i]);
                    break;
            }
        }
        
        switch(character) {
            case 0:{
                saves.add(new Warrior(name,health,maxHealth,attackPower));
                break;
            }
            case 1:{
                saves.add(new Mage(name,health,maxHealth,attackPower));
                break;
            }
            case 2:{
                saves.add(new Thief(name,health,maxHealth,attackPower));
                break;
            }
        
        }
    }
*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jProgressBar1 = new javax.swing.JProgressBar(0,this.player.getMaxHealth());
        jProgressBar2 = new javax.swing.JProgressBar(0,this.enemy.getMaxHealth());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("habilidade 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("habilidade 2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("habilidade 3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("habilidade 4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        jLabel1.setText(this.enemy.getName());

        jLabel2.setText(this.player.getName());

        jLabel3.setText(this.player.classe());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))))))
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(34, 34, 34))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        verify(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        verify(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.player.attack(this.enemy, 0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.player.attack(this.enemy, 1);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
