package com.yummato.config;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class JwtProvider {
    private SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    public String generateToken(Authentication auth){
        Collections<? extends GrantedAuthority> authorities=auth.getAuthorities();
        String roles = populateAuthority(authorities);
        return null;
    }

    private String populateAuthority(Collections<? extends GrantedAuthority> authorities) {
        Set<String> auths = new HashSet<>();
        for(GrantedAuthority authority: authorities){
            auths.add(authority.getAuthority());
        }
        return String.join(",", auths);
    }
}
