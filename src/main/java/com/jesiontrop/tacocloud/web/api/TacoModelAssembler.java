package com.jesiontrop.tacocloud.web.api;

import com.jesiontrop.tacocloud.model.Taco;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoModelAssembler
            extends RepresentationModelAssemblerSupport<Taco, TacoModel> {

    public TacoModelAssembler() {
        super(DesignTacoApiController.class, TacoModel.class);
    }

    public TacoModelAssembler(Class<?> controllerClass) {
        super(controllerClass, TacoModel.class);
    }

    @Override
    protected TacoModel instantiateModel(Taco entity) {
        return new TacoModel(entity);
    }

    @Override
    public TacoModel toModel(Taco entity) {
        return createModelWithId(entity.getId(), entity);
    }
}
