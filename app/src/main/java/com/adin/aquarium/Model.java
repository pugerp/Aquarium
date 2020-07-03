package com.adin.aquarium;

public class Model {
    private float suhu;
    private float ph;
    private String status;

    public Model() {
    }

    public Model(float suhu, float ph, String status) {
        this.suhu = suhu;
        this.ph = ph;
        this.status = status;
    }

    public float getSuhu() {
        return suhu;
    }

    public void setSuhu(float suhu) {
        this.suhu = suhu;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Model{" +
                "suhu=" + suhu +
                ", ph=" + ph +
                ", status='" + status + '\'' +
                '}';
    }
}
