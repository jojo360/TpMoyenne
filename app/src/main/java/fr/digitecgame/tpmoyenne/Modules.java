package fr.digitecgame.tpmoyenne;

/**
 * Created by Digitec Game on 11/03/2018.
 */

public class Modules {
    private String m_name;
    private int m_coef;

    public Modules(String m_name,int m_coef){
        this.m_coef=m_coef;
        this.m_name=m_name;
    }

    public String GetName(){
        return m_name;
    }

    public int GetCoef(){
        return m_coef;
    }

}
