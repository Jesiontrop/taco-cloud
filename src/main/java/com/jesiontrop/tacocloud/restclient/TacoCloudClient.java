package com.jesiontrop.tacocloud.restclient;

import com.jesiontrop.tacocloud.model.Ingredient;
import com.jesiontrop.tacocloud.model.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class TacoCloudClient {

    private RestTemplate restTemplate;
    private Traverson traverson;

    @Autowired
    public TacoCloudClient(RestTemplate restTemplate, Traverson traverson) {
        this.restTemplate = restTemplate;
        this.traverson = traverson;
    }

    public Ingredient getIngredientById(String ingredientId) {
        return restTemplate.getForObject("http://localhost:8080/ingredients/{id}",
                                            Ingredient.class, ingredientId);
    }
    
    public List<Ingredient> getAllIngredients() {
        return restTemplate.exchange("http://localhost:8080/ingredients",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>() {})
            .getBody();
    }

    public void updateIngredient(Ingredient ingredient) {
        restTemplate.put("http://localhost:8080/ingredients/{id}",
            ingredient, ingredient.getId());
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return restTemplate.postForObject("http://localhost:8080/ingredients",
            ingredient, Ingredient.class);
    }

    public void deleteIngredient(Ingredient ingredient) {
        restTemplate.delete("http://localhost:8080/ingredients/{id}",
            ingredient.getId());
    }

    public Iterable<Ingredient> getAllIngredientsWithTraverson() {
        ParameterizedTypeReference<CollectionModel<Ingredient>> ingredientType =
            new ParameterizedTypeReference<CollectionModel<Ingredient>>() {};

        CollectionModel<Ingredient> ingredientRes =
            traverson
                .follow("ingredients")
                .toObject(ingredientType);

        return ingredientRes.getContent();
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        String ingredientsUrl = traverson
            .follow("ingredients")
            .asLink()
            .getHref();
        return restTemplate.postForObject(ingredientsUrl,
            ingredient,
            Ingredient.class);
    }

    public Iterable<Taco> getRecentTacosWithTraverson() {
        ParameterizedTypeReference<CollectionModel<Taco>> tacoType =
            new ParameterizedTypeReference<CollectionModel<Taco>>() {};

        CollectionModel<Taco> tacoCollectionModel =
            traverson
                .follow("tacos")
                .follow("recents")
                .toObject(tacoType);

        return tacoCollectionModel.getContent();
    }
}
