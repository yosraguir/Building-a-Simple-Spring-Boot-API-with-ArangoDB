package net.javaguides.springboot;

import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arangodb.ArangoDB;

@SpringBootApplication
public class SpringbootBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogApplication.class, args);
		
	}
	

	public ArangoDB.Builder arango() { 
	    InputStream in = ArangoDBConfiguration.class.getResourceAsStream ("arangodb.properties"); 
	    ArangoDB.Builder arango = new ArangoDB.Builder ().loadProperties (in); 
	    return arango; 
	}

}
