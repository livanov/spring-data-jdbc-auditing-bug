package com.livanov.playground.domain;

import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "people_addresses")
public class Address extends BaseAuditable {

    private String value;

    public Address(String value) {
        this.value = value;
    }
}
