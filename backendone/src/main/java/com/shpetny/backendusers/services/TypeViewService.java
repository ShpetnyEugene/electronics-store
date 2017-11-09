package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Type;
import com.shpetny.backendusers.persistance.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeViewService {

    private static final long ID = 1L;

    private final TypeRepository typeRepository;

    @Autowired
    public TypeViewService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type getType() {
        return typeRepository.findOne(ID);
    }

    public void updateType(int type) {
        Type type1 = new Type(type);
        type1.setId(ID);
        typeRepository.save(type1);
    }
}
