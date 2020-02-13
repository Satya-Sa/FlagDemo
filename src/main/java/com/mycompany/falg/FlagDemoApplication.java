package com.mycompany.falg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class FlagDemoApplication.
 */
@SpringBootApplication
public class FlagDemoApplication {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(FlagDemoApplication.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FlagDemoApplication.class, args);
	}

}
