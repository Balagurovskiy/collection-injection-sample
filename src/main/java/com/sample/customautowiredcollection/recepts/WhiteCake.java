package com.sample.customautowiredcollection.recepts;

import java.util.Collection;
import java.util.List;

import com.sample.customautowiredcollection.AutowiredCollection;
import com.sample.customautowiredcollection.ingredients.BakingPowder;
import com.sample.customautowiredcollection.ingredients.Eggs;
import com.sample.customautowiredcollection.ingredients.Flour;
import com.sample.customautowiredcollection.ingredients.Ingredient;
import com.sample.customautowiredcollection.ingredients.Sugar;
import com.sample.customautowiredcollection.ingredients.Vanilla;
import com.sample.customautowiredcollection.ingredients.WholeMilk;

import org.springframework.stereotype.Component;

@Component
public class WhiteCake implements Recept{
	@AutowiredCollection({
							BakingPowder.class, 
							Flour.class, 
							Eggs.class, 
							WholeMilk.class, 
							Vanilla.class, 
							Sugar.class
							})
	private List<Ingredient> _ingredients;
	
	@Override
	public void print() {
		System.out.println("\nRecept : White Cake");
		System.out.println("Ingredients :");
		_ingredients.forEach( Ingredient::print );
	}

	@Override
	public Collection<Ingredient> get() {
		return _ingredients;
	}
}
