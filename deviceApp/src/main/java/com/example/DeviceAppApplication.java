package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableEurekaClient
public class DeviceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceAppApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(DeviceRepository deviceRepository){
        return strings ->{
         Stream.of("samsung,sku1,123", "dfdgvx,sku2,123", "qqq,sku3,657")
                    .forEach(n -> deviceRepository.save(new Device(n.split(",")[0], n.split(",")[1],Long.parseLong(n.split(",")[2]))));
        };
    }
}
