package com.sample.customautowiredcollection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.customautowiredcollection.ingredients.BakingPowder;
import com.sample.customautowiredcollection.ingredients.CoconutMilk;
import com.sample.customautowiredcollection.ingredients.Eggs;
import com.sample.customautowiredcollection.ingredients.Flour;
import com.sample.customautowiredcollection.ingredients.Sugar;
import com.sample.customautowiredcollection.ingredients.Vanilla;
import com.sample.customautowiredcollection.ingredients.WholeMilk;
import com.sample.customautowiredcollection.recepts.Recept;

@SpringBootTest
class CustomAutowiredCollectionApplicationTests {
	@Autowired 
	private Recept whiteCake;
	@Autowired 
	private Recept coconutCake;
	
	@Test
	public void whiteCake_ingredientsTnjectionTest() {
		List<Class> igredientClasses = whiteCake.get().stream()
														.map(i -> i.getClass())
														.collect(Collectors.toList());
		
		assertThat(igredientClasses).containsExactly(	
														BakingPowder.class, 
														Flour.class, 
														Eggs.class, 
														WholeMilk.class, 
														Vanilla.class, 
														Sugar.class
													);
	}
	
	@Test
	public void coconatCake_ingredientsTnjectionTest() {
		List<Class> igredientClasses = coconutCake.get().stream()
															.map(i -> i.getClass())
															.collect(Collectors.toList());
		
		assertThat(igredientClasses).containsExactly(	
														BakingPowder.class, 
														Flour.class, 
														Eggs.class, 
														CoconutMilk.class, 
														Sugar.class
													);
	}
}
