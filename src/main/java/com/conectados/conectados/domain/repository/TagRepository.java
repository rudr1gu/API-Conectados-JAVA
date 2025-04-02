package com.conectados.conectados.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.domain.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
    // Custom query methods can be defined here if needed

}
