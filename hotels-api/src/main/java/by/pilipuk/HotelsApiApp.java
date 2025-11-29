package by.pilipuk;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class HotelsApiApp {

    public static void main(String[] args) {
        SpringApplication.run(HotelsApiApp.class, args);
    }
}