package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Taco;
import com.jesiontrop.tacocloud.repository.TacoRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/design",
    produces="application/json")
@CrossOrigin(origins = "*")
public class DesignTacoApiController {
    private TacoRepository tacoRepository;

    public DesignTacoApiController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping("/recent")
    public CollectionModel<TacoModel> recentTaco() {
        PageRequest page = PageRequest.of(
            0, 12, Sort.by("createdAt").descending());

        List<Taco> tacos = tacoRepository.findAll(page).getContent();

        List<TacoModel> tacoModels = new TacoModelAssembler(DesignTacoApiController.class).toModel(tacos)
        CollectionModel<TacoModel> collectionModel = CollectionModel.of(tacoModels);

        collectionModel.add(
                linkTo(methodOn(DesignTacoApiController.class).recentTaco())
                .withRel("recents"));
        return collectionModel;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> taco = tacoRepository.findById(id);
        if (taco.isPresent())
            return new ResponseEntity<>(taco.get(), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }
}

