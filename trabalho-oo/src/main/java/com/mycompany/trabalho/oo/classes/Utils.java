/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho.oo.classes;

import java.io.*;
import java.util.*;

/**
 *
 * @author jv
 */
public class Utils {

    private static List<Save> saves;

    public static List<Save> getSaves() {

        return saves;
    }

    public static Save getSave(int id) {

        return saves.get(id);
    }

    public static void setNewSave(Save save) {

        saves.add(save);
    }
    public static void modifySave(Character jogador, Enemy inimigo, int level, int id){
        saves.get(id).setPersonagem(jogador);
        saves.get(id).setInimigo(inimigo);
        saves.get(id).setLevel(level);
    
    }
    
    public static void limpaSave(){
    
        for(int i = saves.size()-1; i > -1; i--){
            if(getSave(i).getPersonagem().getHealth() == 0){
                saves.remove(getSave(i));
            }
        }
    } 

    public static String[] getNameSaves() {
        String[] names = new String[saves.size()];
        int i = 0;

        for (Save save : saves) {

            names[i] = (save.getPersonagem().getName() + "    | " + save.getPersonagem().classe() + 
                    "    | Level:" + save.getPersonagem().getLevel() + "  | " + save.getPersonagem().getHealth() + 
                    "/" + save.getPersonagem().getMaxHealth());
            i++;
        }

        return names;
    }

    public static void readArchive(String referencia, String arrayAlvo) throws IOException {
        BufferedReader bufferLeitura = new BufferedReader(new FileReader(referencia));
        saves = new ArrayList<>();

        String linha = "";
        String linhaArray[];

        while (true) {

            linha = bufferLeitura.readLine();
            if (linha != null) {

                linhaArray = linha.split("/&&/");
                switch (arrayAlvo) {
                    case "saves":
                        addSave(linhaArray);
                        break;
                    case "placar":
                        //addPlacar(linhaArray);
                        break;
                }
            } else {
                break;
            }

        }

        bufferLeitura.close();
    }

    private static void escreveArquivo(String referencia, String conteudo) throws IOException {
        BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(referencia));

        bufferEscrita.write(conteudo);

        bufferEscrita.flush();

        bufferEscrita.close();
    }

    public static void salvaArquivos() {
        String savesConteudo = "";

        for (Save save : saves) {
            if (!save.getPersonagem().getName().isBlank()) {
                savesConteudo += save.getPersonagem().getName() + "/&&/" + save.getPersonagem().idClasse() + 
                        "/&&/" + save.getPersonagem().getHealth() + "/&&/" + save.getPersonagem().getMaxHealth() + 
                        "/&&/" + save.getPersonagem().getAttackPower() + "/&&/" + save.getPersonagem().getLevel() + 
                        "/&&/" + save.getInimigo().getName() + "/&&/" + save.getInimigo().getHealth() + 
                        "/&&/" + save.getInimigo().getMaxHealth() + "/&&/" + save.getInimigo().getDamage() +
                        "/&&/"+save.getLevel();
                savesConteudo += "\n";
            }
        }

        try{
        escreveArquivo("./src/main/java/com/mycompany/trabalho/oo/arquivos/saves.txt", savesConteudo);
        }catch (IOException e ){
            System.out.println("erro");
        }   
    }

    private static void addSave(String linhaArray[]) {

        String name = "";
        int character = 0;
        int health = 0;
        int maxHealth = 0;
        int attackPower = 0;
        int level = 0;

        String enemy = "";
        int healthEnemy = 0;
        int maxHealthEnemy = 0;
        int attackPowerEnemy = 0;

        int levelGame = 0;

        Character personagem;
        Enemy inimigo;
        Save save;

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
                    attackPower = Integer.parseInt(linhaArray[i]);
                    break;
                case 5:
                    level = Integer.parseInt(linhaArray[i]);
                    break;
                case 6:
                    enemy = linhaArray[i];
                    break;
                case 7:
                    healthEnemy = Integer.parseInt(linhaArray[i]);
                    break;
                case 8:
                    maxHealthEnemy = Integer.parseInt(linhaArray[i]);
                    break;
                case 9:
                    attackPowerEnemy = Integer.parseInt(linhaArray[i]);
                    break;
                case 10:
                    levelGame = Integer.parseInt(linhaArray[i]);

            }
        }

        switch (character) {
            case 0: {
                personagem = new Warrior(name, health, maxHealth, attackPower);
                inimigo = new Enemy(enemy, healthEnemy, maxHealthEnemy, attackPowerEnemy);
                save = new Save(personagem, inimigo, levelGame);
                saves.add(save);
                break;
            }
            case 1: {
                personagem = new Mage(name, health, maxHealth, attackPower);
                inimigo = new Enemy(enemy, healthEnemy, maxHealthEnemy, attackPowerEnemy);
                save = new Save(personagem, inimigo, levelGame);
                saves.add(save);
                break;
            }
            case 2: {
                personagem = new Thief(name, health, maxHealth, attackPower);
                inimigo = new Enemy(enemy, healthEnemy, maxHealthEnemy, attackPowerEnemy);
                save = new Save(personagem, inimigo, levelGame);
                saves.add(save);

                break;
            }

        }

    }

}
