package com.sample.customautowiredcollection.ingredients;

import org.springframework.stereotype.Component;

@Component
public class BakingPowder implements Ingredient {

	@Override
	public void print() {
		System.out.println(" - 4 teaspoons of baking powder;");
	}

}
