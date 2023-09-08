package com.livanov.playground.domain;

import lombok.Getter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Getter
@Table(name = "people")
public class Person extends BaseAuditable {

    private String name;

    @Column("person_id")
    private Address address;

    @MappedCollection(idColumn = "person_id")
    private Set<Education> educations = new HashSet<>();

    public Person(String name) {
        this.name = name;
    }

    public void setAddress(String value) {
        this.address = new Address(value);
    }

    public void addEducation(String value) {
        this.educations.add(new Education(value));
    }
}
