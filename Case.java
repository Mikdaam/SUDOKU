package com.company;

public class Case
{
    public int num;
    public boolean fixe;

    public Case()
    {
        this.num = 0;
        this.fixe = false;
    }

    public Case(int n)
    {
        this.num = n;
        this.fixe = false;
    }

    public Case(int n, boolean f)
    {
        this.num = 0;
        this.fixe = f;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public int getNum()
    {
        return num;
    }

    public void setFixe(boolean fixe)
    {
        this.fixe = fixe;
    }

    public boolean isFixe()
    {
        return fixe;
    }
}
