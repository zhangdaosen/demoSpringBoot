package com.example.demo.http;

public class ResponseBody {
    Integer httpstatus;

    Object data;
    String messages;
    boolean status;


    public Integer getHttpstatus() {
        return httpstatus;
    }

    public void setHttpstatus(Integer httpstatus) {
        this.httpstatus = httpstatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
