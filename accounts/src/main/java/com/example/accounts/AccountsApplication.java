package com.example.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@EnableEurekaClient
@SpringBootApplication
@Controller
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	@GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("title", "Docker + Spring Boot");
        model.addAttribute("msg", "Welcome to the docker container!");
        return "index";
    }
}
