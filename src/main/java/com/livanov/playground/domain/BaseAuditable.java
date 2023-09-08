package com.livanov.playground.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.UUID;

public abstract class BaseAuditable implements Persistable<UUID> {

    @Id
    private UUID id = UUID.randomUUID();

    @CreatedDate
    private Instant createdAt;

    @Override
    public boolean isNew() {
        return getCreatedAt() == null;
    }

    @NonNull
    @Override
    public UUID getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
