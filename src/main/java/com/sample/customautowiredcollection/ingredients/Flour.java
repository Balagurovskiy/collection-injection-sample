package com.sample.customautowiredcollection.ingredients;
import org.springframework.stereotype.Component;

@Component
public class Flour implements Ingredient {

	@Override
	public void print() {
		System.out.println(" - 1/4 cups (261g) cake flour;");
	}
}
