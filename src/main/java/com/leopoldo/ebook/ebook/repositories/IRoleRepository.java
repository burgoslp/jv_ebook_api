package com.leopoldo.ebook.ebook.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.leopoldo.ebook.ebook.models.Role;


@Repository
public interface IRoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
