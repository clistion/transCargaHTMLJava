package br.com.transcarga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //isso é necessário para detectar o @WebFilter

public class TransCargaApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransCargaApplication.class, args);             
    }
}
