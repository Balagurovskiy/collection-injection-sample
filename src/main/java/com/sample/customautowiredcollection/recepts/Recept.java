package com.sample.customautowiredcollection.recepts;

import java.util.Collection;

import com.sample.customautowiredcollection.ingredients.Ingredient;

public interface Recept {
	public void print();
	public Collection<Ingredient> get();
}
