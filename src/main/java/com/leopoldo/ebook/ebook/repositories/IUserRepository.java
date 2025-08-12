package com.leopoldo.ebook.ebook.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leopoldo.ebook.ebook.models.User;

@Repository
public interface IUserRepository extends CrudRepository<User,Long> {

}
