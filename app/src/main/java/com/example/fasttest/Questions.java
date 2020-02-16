package com.example.fasttest;

public class Questions {
    private String q;
    private String ans;
    private String a;
    private String b;
    private String c;
    private String d;

    public Questions (){

    }

    public Questions(String q, String ans, String a, String b, String c, String d) {
        this.q = q;
        this.ans = ans;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
