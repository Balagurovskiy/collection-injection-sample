package com.sample.customautowiredcollection.ingredients;
import org.springframework.stereotype.Component;

@Component
public class Vanilla implements Ingredient {

	@Override
	public void print() {
		System.out.println(" - 1 teaspoon vanilla extract;");
	}
}
