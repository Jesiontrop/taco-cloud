package com.jesiontrop.tacocloud.repository;


import com.jesiontrop.tacocloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
