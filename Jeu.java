package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jeu {
    public Region[][] jeu;
    public Jeu() {
        jeu = new Region[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jeu[i][j] = new Region();
            }
        }
    }

    public Jeu(File fichier){
        int m = 0;
        jeu = new Region[3][3];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                jeu[i][j] = new Region();
            }
        }
        try{
            //on parcourt le fichier avec un scanner qui lit dans le fichier
            Scanner sc = new Scanner(fichier);
            //sc.useDelimiter(Pattern.compile(" "));
            String s;
            int courant;
            int fixe;
            boolean b;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    courant = sc.nextInt();
                    this.setCaseNum(i,j,courant);
                    fixe = sc.nextInt();
                    if(fixe == 0)
                        b =false;
                    else
                        b = true;
                    this.setCaseFixe(i,j,b);
                }
                s = sc.nextLine();
            }
        }catch(FileNotFoundException e){
            System.out.println("Erreur : le fichier n'est pas au bon emplacement !");
        }
    }


    public Region getRegion(int i, int j) {
        return jeu[i][j];
    }

    public Region getRegionDeCase(int i, int j){
        return (jeu[(int)(i/3)][(int)(j/3)]);
    }

    public void setRegion(Region[][] r){
        jeu = r;
    }

    public int getCaseNum(int i, int j) {
        return (jeu[(int)(i/3)][(int)(j/3)]).getCaseNum(i%3, j%3);
    }

    public void setCaseNum(int i, int j, int c) {
        (jeu[(int)(i/3)][(int)(j/3)]).setCaseNum(i%3, j%3, c);
    }

    public boolean getCaseFixe(int i, int j) {
        return (jeu[(int)(i/3)][(int)(j/3)]).getCaseFixe(i%3, j%3);
    }

    public void setCaseFixe(int i, int j, boolean f){
        (jeu[(int)(i/3)][(int)(j/3)]).setCaseFixe(i%3,j%3,f);
    }

    public int getCaseFixeInt(int i, int j) {
        if( (jeu[(int)(i/3)][(int)(j/3)]).getCaseFixe(i%3,j%3) )
            return 1;
        else
            return 0;
    }

    public boolean ligneCompte(int i) {
        boolean un = false;
        boolean deux = false;
        boolean trois = false;
        boolean quatre = false;
        boolean cinq = false;
        boolean six = false;
        boolean sept = false;
        boolean huit = false;
        boolean neuf = false;

        for (int j = 0; j < 9; j++) {
            switch (this.getCaseNum(i, j)) {
                case 1 : un = true; break;
                case 2 : deux = true; break;
                case 3 : trois = true; break;
                case 4 : quatre = true; break;
                case 5 : cinq = true; break;
                case 6 : six = true; break;
                case 7 : sept = true; break;
                case 8 : huit = true; break;
                case 9 : neuf = true; break;
            }
        }
        if (un && deux && trois && quatre && cinq && six && sept && huit && neuf) {
            return true;
        }else
            return false;
    }

    public boolean ligneBon(int i, int j, int val) {
        if (val == 0)
            return false;
        for (int k = 0; k < 9; k++) {
            if (val == this.getCaseNum(i, k))
                return false;
        }
        return true;
    }

    public boolean coloneCompte(int j) {
        boolean un = false;
        boolean deux = false;
        boolean trois = false;
        boolean quatre = false;
        boolean cinq = false;
        boolean six = false;
        boolean sept = false;
        boolean huit = false;
        boolean neuf = false;

        for (int i = 0; i < 9; i++) {
            switch (this.getCaseNum(i, j)) {
                case 1 : un = true; break;
                case 2 : deux = true; break;
                case 3 : trois = true; break;
                case 4 : quatre = true; break;
                case 5 : cinq = true; break;
                case 6 : six = true; break;
                case 7 : sept = true; break;
                case 8 : huit = true; break;
                case 9 : neuf = true; break;
            }
        }
        if (un && deux && trois && quatre && cinq && six && sept && huit && neuf) {
            return true;
        }else
            return false;
    }

    public boolean coloneBon (int i, int j, int val) {
        if (val == 0)
            return false;
        for (int k = 0; k < 9; k++) {
            if (val == this.getCaseNum(k, j))
                return false;
        }
        return true;
    }

    public boolean gagne() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (!(jeu[i][j]).regionCompte())
                    return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (!coloneCompte(i) || !ligneCompte(i))
                return false;
        }
        return true;
    }

    public boolean resoudre(int i, int j) {
        if (j == 9){
            j = 0;
            if (i++ == 9)
                return true;
        }
        if (this.getCaseFixe(i, j))
            return resoudre(i, j+1);
        for (int val = 1; val <= 9; val++) {
            if ((this.getRegionDeCase(i, j).regionBon(i, j, val)) && this.ligneBon(i, j, val) && this.coloneBon(i, j, val)) {
                this.setCaseNum(i, j, val);
                if (resoudre(i, j+1))
                    return true;
            }
        }
        setCaseNum(i, j, 0);
        return false;
    }
}
