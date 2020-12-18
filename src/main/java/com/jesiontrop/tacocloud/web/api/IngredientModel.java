package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Ingredient;
import com.jesiontrop.tacocloud.model.Ingredient.Type;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

public class IngredientModel extends RepresentationModel<IngredientModel> {

    @Getter
    private String name;

    @Getter
    private Type type;

    public IngredientModel (Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
