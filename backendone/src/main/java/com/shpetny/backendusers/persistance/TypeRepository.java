package com.shpetny.backendusers.persistance;

import com.shpetny.backendusers.models.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type,Long>{
}
