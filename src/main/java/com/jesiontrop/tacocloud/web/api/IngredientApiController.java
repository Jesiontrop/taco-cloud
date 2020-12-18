package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Ingredient;
import com.jesiontrop.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/ingredients",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientApiController {

    IngredientRepository ingredientRepository;

    @Autowired
    public IngredientApiController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

}
