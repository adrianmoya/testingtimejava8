package com.adrianmoya.testingtimejava8;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingsMessageTest {

	private GreetingsMessage greetingsMessage;
	private final LocalDateTime REFERENCE_DATE_TIME = LocalDateTime.of(2016, 4, 1, 10, 0); //2016-04-01 at 10:00am
	private final ZoneId defaultZone = ZoneId.systemDefault();
	private final Clock FIXED_CLOCK = Clock.fixed(REFERENCE_DATE_TIME.atZone(defaultZone).toInstant(), defaultZone);
	
	@Before
	public void setup(){
		greetingsMessage = new GreetingsMessage(FIXED_CLOCK);
	}
	
	@Test public void testGreetingSinceMinutesAgo(){
		//Given
		LocalDateTime lastSeen = REFERENCE_DATE_TIME.minus(5, ChronoUnit.MINUTES);
		
		//When
		String greeting = greetingsMessage.getMessage(lastSeen);
		
		//Then
		assertEquals("Hello, I haven't see you since minutes ago!", greeting);
	}
	
	@Test public void testGreetingSinceYesterday(){
		//Given
		LocalDateTime lastSeen = REFERENCE_DATE_TIME.minusDays(1);
		
		//When
		String greeting = greetingsMessage.getMessage(lastSeen);
		
		//Then
		assertEquals("Hello, I haven't see you since yesterday!", greeting);
	}
	
	@Test public void testGreetingSinceAWhile(){
		//Given
		LocalDateTime lastSeen = REFERENCE_DATE_TIME.minusHours(4);
		
		//When
		String greeting = greetingsMessage.getMessage(lastSeen);
		
		//Then
		assertEquals("Hello, I haven't see you since a while!", greeting);
	}
	
	@Test public void testGreetingSinceLongTimeAgo(){
		//Given
		LocalDateTime lastSeen = REFERENCE_DATE_TIME.minusDays(2);
		
		//When
		String greeting = greetingsMessage.getMessage(lastSeen);
		
		//Then
		assertEquals("Hello, I haven't see you since long time ago!", greeting);
	}
}
