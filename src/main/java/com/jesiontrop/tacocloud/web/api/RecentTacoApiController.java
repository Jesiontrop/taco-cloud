package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.repository.TacoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class RecentTacoApiController {

    private TacoRepository tacoRepository;

    public RecentTacoApiController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }
}
