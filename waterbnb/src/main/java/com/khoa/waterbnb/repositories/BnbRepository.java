package com.khoa.waterbnb.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khoa.waterbnb.models.Bnb;
import com.khoa.waterbnb.models.User;


@Repository
public interface BnbRepository extends CrudRepository<Bnb, Long> {

}