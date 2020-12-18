package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Ingredient;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class IngredientModelAssembler
            extends RepresentationModelAssemblerSupport<Ingredient, IngredientModel> {


    public IngredientModelAssembler(Class<?> controllerClass) {
        super(controllerClass, IngredientModel.class);
    }

    @Override
    protected IngredientModel instantiateModel(Ingredient entity) {
        return createModelWithId(entity.getId(), entity);
    }

    @Override
    public IngredientModel toModel(Ingredient entity) {
        return new IngredientModel(entity);
    }
}
