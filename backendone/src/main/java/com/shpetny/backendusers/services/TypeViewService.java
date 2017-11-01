package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Type;
import com.shpetny.backendusers.persistance.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeViewService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeViewService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type getType() {
        return typeRepository.findOne(1L);
    }

    public void updateType(int type){
        Type type1 = new Type(type);
        type1.setId(1);
        typeRepository.save(type1);
    }
}
