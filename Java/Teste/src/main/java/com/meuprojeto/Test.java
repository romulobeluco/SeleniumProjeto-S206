package com.meuprojeto;

public class Test {
    private String name;
    private String status;
    private String details;

    public Test(String name) {
        this.name = name;
        this.status = "Not Run";
        this.details = "";
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
