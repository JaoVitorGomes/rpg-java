/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rpg.view;

import com.mycompany.rpg.classes.Character;
import com.mycompany.rpg.classes.Enemy;
import com.mycompany.rpg.logica.Utils;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author JV
 */

// O objetivo dessa classe é o jogo em si, tanto a logica quanto a visualização

public class Game extends javax.swing.JFrame {
        private static int level;
        private static int idSave;
        
        private Character player;
        private Enemy enemy;

        
        
    public Character getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

        
        
    
    public static void setLevel(int level) {
        Game.level =  level;
    }

    /**
     * Creates new form Game
     * @param save
     */
    public static void setIdSave(int idSave) {
        Game.idSave = idSave;
    }

    public Game(Character personagem, Enemy inimigo) {
        

        this.player =  personagem;
        if(inimigo != null){
            this.enemy = inimigo;
        }else{
            logic();
        }
        System.out.println(this.player.getHealth() + " " + this.player.getMaxHealth());
        
        initComponents();
        System.out.println("depois do init");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jLabel2.setText(this.player.getName());
        jLabel3.setText(this.player.classe());
        jLabel1.setText(this.enemy.getName());
        jProgressBar1.setMaximum(this.player.getMaxHealth());
        jProgressBar1.setValue(this.player.getHealth());
        jProgressBar2.setValue(this.enemy.getHealth());
        jProgressBar2.setMaximum(this.enemy.getMaxHealth());
        jTextPane1.setEditable(false);  
        System.out.println("depois dos botões");
        
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Utils.modifySave(getPlayer(),getEnemy(),level,idSave);
                Utils.limpaSave();
                Utils.salvaArquivos();
                
                System.exit(0); 
            }
        });
    }
    //mudanca do yan
    private void mn(){
        Utils.modifySave(getPlayer(),getEnemy(),level,idSave);
        Utils.limpaSave();
        Utils.salvaArquivos();
        TelaInicio frame = new TelaInicio();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        dispose();
    }
    private void logic(){

        int contador = level%3;

        switch(contador){
            case 0: {
                this.enemy = new Enemy("Goblin", 10 + (3* level),10 + (3* level),2 + (1 * level));
                break;
            }
            case 1: {
               this.enemy = new Enemy("Lobo Selvagem", 5+ (3* level),5 + (3* level),6 +(1* level));
                break;
            }
            case 2: {
                this.enemy = new Enemy("Troll", 70 + (5* level),70 + (5* level),5 + (1* level));
                break;
            }
            default:{
                this.enemy = new Enemy("Devorador de mundos", 1000,1000,500);
            }
        }
         


    }
    
//    private void initialize(){
//        if(Logic.initialize()){
//            return vc morreu;
//  
//        }
//    
//    }
//    
    
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
        }
        
            if (player.getHealth() > 0 && enemy.getHealth() < 1) {
                player.UPlevel(1);
                //JOptionPane.showMessageDialog(null,"\nParabens  " + this.player.getName() + "! você ganhou!" );
                int selection = JOptionPane.showConfirmDialog(
                                    null
                            , "\n quer ir para a proxima fase?" 
                            , "mensagem "
                            , JOptionPane.YES_NO_OPTION
                            , JOptionPane.INFORMATION_MESSAGE);
                jProgressBar2.setValue(this.enemy.getHealth());
                jProgressBar1.setValue(this.player.getHealth());
                if (selection == JOptionPane.OK_OPTION)
                {
                    // Code to use when OK is PRESSED.
                    level++;
                    Game jogo = new Game(this.player, null);
                    jogo.setLocationRelativeTo(null);
                    jogo.setVisible(true);
                    dispose();
                }
                else if (selection == JOptionPane.NO_OPTION)
                {
                    // Code to use when CANCEL is PRESSED.
                    System.out.println("cancelou");
                    this.enemy.reviver();
                    jProgressBar2.setValue(this.enemy.getHealth());
                    jProgressBar1.setValue(this.player.getHealth());
                }
                
            } else if(player.getHealth() < 1) {
                JOptionPane.showMessageDialog(null,"\n" + this.player.getName() + " perdeu!." );
                System.out.println("\n" + this.player.getName() + " perdeu!.");
                //Mudanca do yan
                mn();
            }
    
    }
    
    private void handleException(Exception ex) {
        ex.printStackTrace(); // Isso pode ser modificado conforme necessário
        JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        jButton5 = new javax.swing.JButton();

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
        jButton3.setText("Recuperação");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Fugir");
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

        jButton5.setText("Sair");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(56, 56, 56))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5))
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
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
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
        try {
            verify(0);
        } catch (Exception ex) {
            handleException(ex);
        }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            verify(1);
        } catch (Exception ex) {
            handleException(ex);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //MUdança do yan : this.player.attack(this.enemy, 0);
        if(this.player.getHealth()>0 && this.player.getHealth()<this.player.getMaxHealth()){
            this.player.Cura();
            jProgressBar1.setValue(this.player.getHealth());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //MUdança do yan : this.player.attack(this.enemy, 1);
        JOptionPane.showMessageDialog(null,"\n" + this.player.getName() + " Fugiu!." );
        System.out.println("\n" + this.player.getName() + " fugiu!.");
        mn();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        Utils.modifySave(getPlayer(),getEnemy(),level,idSave);
        Utils.limpaSave();
        Utils.salvaArquivos();
        //Mudaca yan
        TelaInicio frame = new TelaInicio();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
