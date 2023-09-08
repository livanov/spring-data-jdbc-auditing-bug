package com.livanov.playground.domain;

import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "people_educations")
public class Education extends BaseAuditable {

    private String value;

    public Education(String value) {
        this.value = value;
    }
}
