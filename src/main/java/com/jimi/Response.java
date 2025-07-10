package com.jimi;

import lombok.Data;

/**
 * @author Tan Lianwang
 * @title: response
 * @date 2025/7/9 11:47
 */
@Data
public class Response {

    private String requestID;
    private int code;
    private String message;
    private String echoMessage;
    private String randomData;
    private String clientIP;

    // Getters and Setters
    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEchoMessage() {
        return echoMessage;
    }

    public void setEchoMessage(String echoMessage) {
        this.echoMessage = echoMessage;
    }

    public String getRandomData() {
        return randomData;
    }

    public void setRandomData(String randomData) {
        this.randomData = randomData;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    @Override
    public String toString() {
        return "response{" +
                "requestID='" + requestID + '\'' +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", echoMessage='" + echoMessage + '\'' +
                ", randomData='" + randomData + '\'' +
                ", clientIP='" + clientIP + '\'' +
                '}';
    }
}
