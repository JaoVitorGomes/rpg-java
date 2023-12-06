/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabalho.oo;

import java.io.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author jv
 */
public class Game1 extends javax.swing.JFrame {
    
        private Character player;
        private Enemy enemy;
        private List<Character> saves;

    /**
     * Creates new form Game1
     */
    public Game1(Character personagem) {
        this.player = personagem;
        
        System.out.println(this.player.getHealth() + " " + this.player.getMaxHealth());
        logic();
        initComponents();

        jLabel2.setText(this.player.getName());
        jLabel3.setText(this.player.classe());
        jLabel1.setText(this.enemy.getName());
        jProgressBar1.setMaximum(this.player.getMaxHealth());
        jProgressBar1.setValue(this.player.getHealth());
        jProgressBar2.setValue(this.enemy.getHealth());
        jProgressBar2.setMaximum(this.enemy.getMaxHealth());
        jTextPane1.setEditable(false);  
    }
    
    private void logic(){

            
        switch(this.player.getLevel()){
            case 1: {
                this.enemy = new Enemy("Goblin fraco", 10,10,2);
                break;
            }
            case 2: {
               this.enemy = new Enemy("Lobo Selvagem", 5,5,6);
                break;
            }
            case 3: {
                this.enemy = new Enemy("Troll", 70,70,5);
                break;
            }
        }
         


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
            player.UPlevel(1);
            //JOptionPane.showMessageDialog(null,"\nParabens  " + this.player.getName() + "! você ganhou!" );
            int selection = JOptionPane.showConfirmDialog(
                                null
                        , "\nParabens  " + this.player.getName() + "! você ganhou!" 
                        , "mensagem "
                        , JOptionPane.OK_OPTION
                        , JOptionPane.INFORMATION_MESSAGE);
                            
            if (selection == JOptionPane.OK_OPTION)
                {
                    // Code to use when OK is PRESSED.
                    Game1 jogo = new Game1(this.player);
                    jogo.setLocationRelativeTo(null);
                    jogo.setVisible(true);
                    dispose();
                }
                else if (selection == JOptionPane.CANCEL_OPTION)
                {
                    // Code to use when CANCEL is PRESSED.
                    System.out.println("Selected Option Is CANCEL : " + selection);
                }
                            
                            
                            
        } else {
            JOptionPane.showMessageDialog(null,"\n" + this.player.getName() + " perdeu!." );
            System.out.println("\n" + this.player.getName() + " perdeu!.");
        }
        }
    
    }

    
    private  void readArchive(String referencia, String arrayAlvo) throws IOException {
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
    
        private  void escreveArquivo(String referencia, String conteudo) throws IOException {
        BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(referencia));

        bufferEscrita.write(conteudo);

        bufferEscrita.flush();

        bufferEscrita.close();
    }
    
        private  void salvaArquivos() throws IOException {
        String savesConteudo = "";

        for (Character save: saves) {
            if (!save.getName().isBlank()) {
                savesConteudo += save.getName() + "/&&/" + "0" + "/&&/" + save.getHealth()+ "/&&/" + save.getMaxHealth()+ "/&&/" + save.getAttackPower()+ "/&&/" + "0" + "/&&/" + false;
                savesConteudo += "\n";
            }
        }


        escreveArquivo("./src/main/java/com/mycompany/trabalho/oo/arquivos/saves.txt", savesConteudo);

    }
    
        private  void addSave(String linhaArray[]) {
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
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("habilidade 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Com a Mão");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("habilidade 3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("habilidade 4");
        jButton4.setMaximumSize(new java.awt.Dimension(370, 304));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        jProgressBar1.setMaximum(10);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jButton7.setText("Repertir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Avançar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton3)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(jButton8))))))
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addGap(5, 5, 5))))
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
        //MUdança do yan : this.player.attack(this.enemy, 0);
        this.player.Cura();
        jProgressBar1.setValue(this.player.getHealth());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //MUdança do yan : this.player.attack(this.enemy, 1);
        JOptionPane.showMessageDialog(null,"\n" + this.player.getName() + " Fugiu!." );
        System.out.println("\n" + this.player.getName() + " fugiu!.");
    }//GEN-LAST:event_jButton4ActionPerformed

    //MUdança do yan :
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.player.reviver();
        this.enemy.reviver();
        jProgressBar1.setMaximum(this.player.getHealth());
        jProgressBar1.setValue(this.player.getHealth());
        jProgressBar2.setValue(this.enemy.getHealth());
        jProgressBar2.setMaximum(this.enemy.getHealth());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Game2 jogo = new Game2(player);
        jogo.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
