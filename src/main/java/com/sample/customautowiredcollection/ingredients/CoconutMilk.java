package com.sample.customautowiredcollection.ingredients;
import org.springframework.stereotype.Component;

@Component
public class CoconutMilk implements Ingredient {

	@Override
	public void print() {
		System.out.println(" - 1 cup (240g) coconut milk;");
	}
}
