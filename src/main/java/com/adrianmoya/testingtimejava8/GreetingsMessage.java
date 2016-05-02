package com.adrianmoya.testingtimejava8;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GreetingsMessage {

	private Clock clock;
	
	public GreetingsMessage(Clock clock) {
		this.clock = clock;
	}

	public String getMessage(LocalDateTime lastSeen) {
		LocalDateTime currentDateTime = LocalDateTime.now(clock);
		long minutesSinceLastSeen = ChronoUnit.MINUTES.between(lastSeen, currentDateTime);

		// <10 mins
		if(minutesSinceLastSeen < 10){
			return "Hello, I haven't see you since minutes ago!";
		} 
		
		//10 mins - 24 hours
		if(minutesSinceLastSeen >= 10  && minutesSinceLastSeen < 1440){
			return "Hello, I haven't see you since a while!";
		}
	
		//24 hours - 48 hours
		if(minutesSinceLastSeen >= 1440  && minutesSinceLastSeen < 2880){	
			return "Hello, I haven't see you since yesterday!";
		}	
			
		return "Hello, I haven't see you since long time ago!";
	}

}
