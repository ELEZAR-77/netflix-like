package com.elezar.netflixlike;

import org.springframework.boot.SpringApplication;

public class TestNetflixLikeApplication {

    public static void main(String[] args) {
        SpringApplication.from(NetflixLikeApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
