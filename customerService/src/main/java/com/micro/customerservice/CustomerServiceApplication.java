package com.micro.customerservice;

import com.micro.customerservice.entities.Customer;
import com.micro.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("Ayman").email("ayman@urm.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Achraf").email("achraf@urm.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Adam").email("adam@urm.com")
                    .build());
            customerRepository.findAll().forEach(c->{
                System.out.println("-------------");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
            });
        };
    }

}
