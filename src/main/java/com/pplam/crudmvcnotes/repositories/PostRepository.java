package com.pplam.crudmvcnotes.repositories;

import com.pplam.crudmvcnotes.entities.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> { }
