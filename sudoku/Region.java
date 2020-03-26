package com.company;

public class Region {
    public Case[][] region;
    public Region () {
        region = new Case[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                region[i][j] = new Case();
            }
        }
    }

    public Case getCase(int i, int j) {
        return region[i][j];
    }
    public void setCase(int i, int j, Case c) {
        (region[i][j]).setNum(c.getNum());
    }
    public int getCaseNum(int i, int j) {
        return (region[i][j]).getNum();
    }
    public void setCaseNum(int i, int j, int val) {
        (region[i][j]).setNum(val);
    }
    public boolean getCaseFixe(int i, int j) {
        return (region[i][j]).isFixe();
    }
    public void setCaseFixe(int i, int j, boolean f) {
        (region[i][j]).setFixe(f);
    }
    public boolean regionCompte() {
        boolean un = false;
        boolean deux = false;
        boolean trois = false;
        boolean quatre = false;
        boolean cinq = false;
        boolean six = false;
        boolean sept = false;
        boolean huit = false;
        boolean neuf = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch ((region[i][j]).getNum()) {
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
        }
        if (un && deux && trois && quatre && cinq && six && sept && huit && neuf) {
            return true;
        }else
            return false;
    }
    public boolean regionBon(int i, int j, int val) {
        if (val == 0)
            return false;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++){
                if (this.getCaseNum(l,k) == val)
                    return false;
            }
        }
        return true;
    }
}
