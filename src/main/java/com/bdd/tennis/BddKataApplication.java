package com.bdd.tennis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author dridi
 *
 */
@SpringBootApplication
public class BddKataApplication {
	
static final String[] scores = { "0", "15", "30", "40", "ADV", "DEUCE" };

	public static void main(String[] args) {
		SpringApplication.run(BddKataApplication.class, args);
				
	}

}
