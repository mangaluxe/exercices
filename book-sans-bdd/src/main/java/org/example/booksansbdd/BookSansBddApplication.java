package org.example.booksansbdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BookSansBddApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSansBddApplication.class, args);
    }

}
