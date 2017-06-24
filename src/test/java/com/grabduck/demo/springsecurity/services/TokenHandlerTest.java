package com.grabduck.demo.springsecurity.services;

import org.bson.types.ObjectId;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

public class TokenHandlerTest {
    @Test
    public void generateToken() {
        TokenHandler tokenHandler = new TokenHandler();
        String token = tokenHandler.generateAccessToken(new ObjectId("589742e3e4284e3c76418e2d"), LocalDateTime.now().plusDays(14));
        System.out.println(token);

        Optional<ObjectId> id = tokenHandler.extractUserId(token);
        System.out.println(id.get().toString());
    }

}