package com.amazonia.support;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableBinding(CustomChannels.class)
public class Application {

    private static final Logger LOG= Logger.getLogger( Application.class.getName() );

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    public Ticket ticket = new Ticket(Boolean.FALSE); 
    
    @RequestMapping("/hello_support")
    public String hello() {
        LOG.log(Level.INFO, "requested Service 'support'");
        String var = ticket.ticketStatus?"ativo": "inativo";
        return "Hello from service 'support'. Status do seu ticket de supporte: " + var;
    }
    
    @StreamListener("inboundSupportTicket")
    public void ticketSink(Boolean ticketStatus) {
    	ticket.ticketStatus = ticketStatus;
    }
    
    public class Ticket
    {
    	
    	public Boolean ticketStatus;
    	
    	public Ticket()
    	{
    		super();
    	}
    	
    	public Ticket(Boolean ticketStatus)
    	{
    		this.ticketStatus = ticketStatus;
    	}
    }
}

