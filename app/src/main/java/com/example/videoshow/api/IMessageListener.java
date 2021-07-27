package com.example.videoshow.api;

public interface IMessageListener <T> {

    public void responseMessage(T responseMessage);
    public void errorResponseMassage(String errorResponceMessage);
}
