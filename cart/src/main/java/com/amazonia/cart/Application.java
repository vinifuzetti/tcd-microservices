package com.amazonia.cart;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableBinding(Source.class)
public class Application {

    private static final Logger LOG= Logger.getLogger( Application.class.getName() );

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Autowired
	private Source source;
	
    @RequestMapping("/hello_cart")
    public String hello() {
        LOG.log(Level.INFO, "requested Service 'cart'");
        Boolean openTicket = true;
		source.output().send(MessageBuilder.withPayload(openTicket).build());
        return "Hello from service 'cart'. Ticket de supporte aberto";
    }
}

