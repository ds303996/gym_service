package com.jetrouter.gymservice.service;

public interface ProfileService {
    byte[] getImage(String principalName);

    void updateImage(byte[] image, String principalName);
}
