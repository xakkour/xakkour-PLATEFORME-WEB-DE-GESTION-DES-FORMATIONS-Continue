/*
package com.pfe.myschool.Session;

import org.apache.commons.math3.random.HaltonSequenceGenerator;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

@Component
public class InMemorySession {
private static final HashMap<String,String> SESSION=new HashMap<>();
public String registerSession(final String username){
    if (username==null) throw new  RuntimeException("User Not Found");
    final String sessionID = generateSession();

    SESSION.put(sessionID,username);
    return sessionID;
}
public String getUsernameForSession(final String sessionID){
    return sessionID;
}

private String generateSession(){
    return new String(
            Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8))
    );

}
}
*/
