package com.laundry.clothsregisterrest.repository;

import com.laundry.clothsregisterrest.entity.Prenda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface PrendaRepository extends MongoRepository<Prenda, Integer>{

    List<Prenda> findAll();
    Prenda findBy_id(ObjectId _id);

    @Query("{id_lote : ?0}")
    List<Prenda> findById_Lote(Integer id_lote);

    @Query("{id_cuarto : ?0}")
    List<Prenda> findById_cuarto(Integer id_cuarto);

    @Query("{ tipo_operacion_id_tipo_operacion: { $in: ?0 } }")
    List<Prenda> findByIDIipoOpIn(List<Integer> ids);
}
