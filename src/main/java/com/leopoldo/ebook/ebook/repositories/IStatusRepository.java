package com.leopoldo.ebook.ebook.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.leopoldo.ebook.ebook.models.Status;

@Repository
public interface IStatusRepository extends CrudRepository<Status,Long>{
    Optional<Status> findByName(String name);
}
