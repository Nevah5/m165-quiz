package net.geeler.m165_quiz.models;

public class QuizQuestion {
    private Integer id;
    private Integer quizId;
    private String q;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String c;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getQuizId() {
        return quizId;
    }
    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }
    public String getQ() {
        return q;
    }
    public void setQ(String q) {
        this.q = q;
    }
    public String getA1() {
        return a1;
    }
    public void setA1(String a1) {
        this.a1 = a1;
    }
    public String getA2() {
        return a2;
    }
    public void setA2(String a2) {
        this.a2 = a2;
    }
    public String getA3() {
        return a3;
    }
    public void setA3(String a3) {
        this.a3 = a3;
    }
    public String getA4() {
        return a4;
    }
    public void setA4(String a4) {
        this.a4 = a4;
    }
    public String getC() {
        return c;
    }
    public void setC(String c) {
        this.c = c;
    }
}
