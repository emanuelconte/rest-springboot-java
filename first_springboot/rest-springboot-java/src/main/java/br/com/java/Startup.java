package br.com.java;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;


@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
		
		
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        
        Pbkdf2PasswordEncoder pbkdf2Encoder =
        		new Pbkdf2PasswordEncoder(
    				"", 8, 185000,
    				SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
        
        encoders.put("pbkdf2", pbkdf2Encoder);
        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
        
        String result1 = passwordEncoder.encode("1231020");
        System.out.println("My hash: " + result1);
        
	}

}
