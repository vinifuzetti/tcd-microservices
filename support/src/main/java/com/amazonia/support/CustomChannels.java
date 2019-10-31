package com.amazonia.support;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomChannels {
	@Input("inboundSupportTicket")
	SubscribableChannel orgs();
}
