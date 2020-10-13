package com.jesiontrop.tacocloud.repository;

import com.jesiontrop.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
