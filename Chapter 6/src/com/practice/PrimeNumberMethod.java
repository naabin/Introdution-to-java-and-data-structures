package com.practice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PrimeNumberMethod {

	public static void main(String[] args) throws IOException {
		Path file = Paths.get("One_hundered_thousand_prime_numbers.txt");
		List<String> primesNumebers = Arrays.asList("One Thousand prime numbers",printPrimeNumbers(100000));
		Files.write(file, primesNumebers, StandardCharsets.UTF_8);
		
	}
	public static String printPrimeNumbers(int numberOfPrimes) {
		final int NUMBER_OF_PRIMES_PER_LINE = 10;
		int count = 0; 
		int number = 2;
		String primeNumbers = "";
		
		while(count < numberOfPrimes) {
			if(isPrime(number)) {
				count++;
				if(count % NUMBER_OF_PRIMES_PER_LINE == 0) {
					primeNumbers += " " + number + "\n";
				}
				else {
					primeNumbers += " " + number;
				}
			}

			number++;
		}
		return primeNumbers;
	}
	private static boolean isPrime(int number) {
		for(int divisor = 2; divisor <= number/2; divisor++) {
			if(number % divisor == 0) {
				return false;
			}
		}
		return true;
	}

}
