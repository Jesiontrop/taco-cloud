package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Taco;
import com.jesiontrop.tacocloud.repository.TacoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
public class RecentTacoApiController {

    private TacoRepository tacoRepository;

    public RecentTacoApiController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }


    @GetMapping(path="/tacos/recent", produces="application/hal+json")
    public ResponseEntity<CollectionModel<TacoModel>> recentTaco() {
        PageRequest page = PageRequest.of(
            0, 12, Sort.by("createdAt").descending());

        List<Taco> tacos = tacoRepository.findAll(page).getContent();

        CollectionModel<TacoModel> collectionModel = new TacoModelAssembler(getClass()).toCollectionModel(tacos);

        collectionModel.add(
            linkTo(methodOn(DesignTacoApiController.class).recentTaco())
                .withRel("recents"));
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }
}
