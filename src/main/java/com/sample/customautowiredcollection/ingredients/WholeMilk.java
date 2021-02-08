package com.sample.customautowiredcollection.ingredients;
import org.springframework.stereotype.Component;

@Component
public class WholeMilk implements Ingredient{
	@Override
	public void print() {
		System.out.println(" - 1 cup (245g) whole milk;");
	}
}
