package com.example.bt.ex;

import java.io.Serializable;

public class StudientActivity implements Serializable {
    private String Ten;
    private int NS;

    public StudientActivity(String ten, int NS) {
        Ten = ten;
        this.NS = NS;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getNS() {
        return NS;
    }

    public void setNS(int NS) {
        this.NS = NS;
    }
}
