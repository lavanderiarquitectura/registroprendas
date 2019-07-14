package com.laundry.clothsregisterrest.repository;

import com.laundry.clothsregisterrest.entity.Peticion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface PeticionRepository extends MongoRepository<Peticion, Integer>{

    List<Peticion> findAll();
    Peticion findBy_id(ObjectId _id);

    @Query("{id_room : ?0}")
    List<Peticion> findById_Room(Integer id_room);

}
