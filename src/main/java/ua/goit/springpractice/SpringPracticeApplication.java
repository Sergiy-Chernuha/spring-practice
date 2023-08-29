package ua.goit.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPracticeApplication {
    public TestNoteService test;

    @Autowired
    public SpringPracticeApplication(TestNoteService test) {
        this.test = test;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringPracticeApplication.class, args);
    }
}
