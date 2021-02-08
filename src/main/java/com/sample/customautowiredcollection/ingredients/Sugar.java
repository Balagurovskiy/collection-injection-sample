package com.sample.customautowiredcollection.ingredients;
import org.springframework.stereotype.Component;

@Component
public class Sugar implements Ingredient{

	@Override
	public void print() {
		System.out.println(" - 3/4 cups (350g) granulated sugar;");
	}

}
