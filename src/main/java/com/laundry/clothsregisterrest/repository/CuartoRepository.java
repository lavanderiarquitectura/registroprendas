package com.laundry.clothsregisterrest.repository;

import com.laundry.clothsregisterrest.entity.Cuarto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CuartoRepository extends MongoRepository<Cuarto, Integer>{

    List<Cuarto> findAll();
    Cuarto findBy_id(ObjectId _id);

    @Query("{id_cuarto : ?0}")
    List<Cuarto> findById_Cuarto(Integer id_cuarto);

}
