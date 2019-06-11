package com.laundry.clothsregisterrest.repository;

import com.laundry.clothsregisterrest.entity.TipoPrenda;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TipoPrendaRepository extends MongoRepository<TipoPrenda, Integer> {

    TipoPrenda findBy_id(ObjectId _id);

}
