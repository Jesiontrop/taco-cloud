package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Taco;
import lombok.Getter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TacoModel extends RepresentationModel<TacoModel> {

    private static final IngredientModelAssembler ingredientAssembler =
        new IngredientModelAssembler(IngredientApiController.class);

    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final List<IngredientModel> ingredients;

    public TacoModel(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = new ArrayList<>(ingredientAssembler.toCollectionModel(taco.getIngredients()).getContent());
    }
}
