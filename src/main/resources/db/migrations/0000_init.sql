create table people
(
    id         uuid primary key,
    name       text not null,
    created_at timestamp with time zone
);

create table people_addresses
(
    id         uuid primary key,
    person_id  uuid not null references people (id),
    value      text not null,
    created_at timestamp with time zone
);

create table people_educations
(
    id         uuid primary key,
    person_id  uuid not null references people (id),
    value      text not null,
    created_at timestamp with time zone
);
