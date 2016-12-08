package com.grabduck.demo.springsecurity;

import org.junit.Test;

import java.util.Base64;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void testConfigureGlobal() throws Exception {
        String auth = "dXNlcjpwYXNzd29yZA==";
        System.out.println(new String(Base64.getDecoder().decode(auth)));
    }
}