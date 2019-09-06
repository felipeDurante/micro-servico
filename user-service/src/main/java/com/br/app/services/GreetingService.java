package com.br.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	private final List<String> greetings = Arrays.asList("Hi", "Hello", "Hey");

	public String getGreeting() {

		Random random = new Random();

		int randomIndex = random.nextInt(greetings.size());

		return greetings.get(randomIndex);

	}
}
