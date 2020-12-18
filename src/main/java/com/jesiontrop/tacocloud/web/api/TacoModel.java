package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Ingredient;
import com.jesiontrop.tacocloud.model.Taco;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

public class TacoModel extends RepresentationModel<TacoModel> {

    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final List<Ingredient> ingredients;

    public TacoModel(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = taco.getIngredients();
    }
}
