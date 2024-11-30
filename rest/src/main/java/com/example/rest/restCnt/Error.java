package com.example.rest.restCnt;

public class Error {
    private int Status;
    private String message;

    public Error(String message, int Status) {
        this.message = message;
        this.Status = Status;
    }
    public Error(String message) {
        this.message = message;
    }
    public Error(){ }

    public int getId() {
        return Status;
    }

    public void setStatus(int Statu) {
        Status = Statu;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
