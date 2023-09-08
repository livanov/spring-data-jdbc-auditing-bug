package com.livanov.playground.domain;

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface PeopleRepository extends ListCrudRepository<Person, UUID> {
}
