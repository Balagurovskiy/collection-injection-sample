package com.sample.customautowiredcollection.ingredients;
import org.springframework.stereotype.Component;

@Component
public class Eggs implements Ingredient {

	@Override
	public void print() {
		System.out.println(" - 5 (200g) eggs;");
	}
}
