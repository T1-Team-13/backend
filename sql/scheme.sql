create table achievements
(
    id          uuid not null
        primary key,
    description varchar(255),
    image_path  varchar(255),
    title       varchar(255)
);

alter table achievements
    owner to postgres;

create table categories
(
    id          uuid not null
        primary key,
    description varchar(255),
    name        varchar(255)
);

alter table categories
    owner to postgres;

create table achievement_category
(
    id             uuid not null
        primary key,
    achievement_id uuid
        constraint fk9wi61sjmcfp8hdc1xp2rpfedg
            references achievements,
    category_id    uuid
        constraint fkr57fbq0plkn57v7n37uyifisn
            references categories
);

alter table achievement_category
    owner to postgres;

create table tasks
(
    id          uuid not null
        primary key,
    description varchar(255),
    name        varchar(255)
);

alter table tasks
    owner to postgres;

create table achievement_task
(
    id                uuid not null
        primary key,
    required_progress integer,
    achievement_id    uuid
        constraint fk57ew6xcapoisy0iib3o9w5xnu
            references achievements,
    task_id           uuid
        constraint fkfm30elejiebhpxa6nsecmsg4h
            references tasks
);

alter table achievement_task
    owner to postgres;

create table users
(
    id                uuid not null
        primary key,
    avatar_path       varchar(255),
    email             varchar(255),
    first_name        varchar(255),
    last_name         varchar(255),
    password          varchar(255),
    patronymic        varchar(255),
    registration_date timestamp(6),
    role              varchar(255)
        constraint users_role_check
            check ((role)::text = ANY
                   ((ARRAY ['ROLE_USER'::character varying, 'ROLE_ADMIN'::character varying])::text[]))
);

alter table users
    owner to postgres;

create table user_achievement
(
    id             uuid not null
        primary key,
    completed_at   timestamp(6),
    achievement_id uuid
        constraint fk7bd14tr3dioj2a091h7ke455b
            references achievements,
    user_id        uuid
        constraint fk5hq4ms9ikrxw18tf1wn12anj6
            references users
);

alter table user_achievement
    owner to postgres;

create table user_task
(
    id               uuid not null
        primary key,
    current_progress integer,
    task_id          uuid
        constraint fkp7b0g1h9lxrklls4s1pw68nj2
            references tasks,
    user_id          uuid
        constraint fkj6lai3y87ttxldkysg1549etg
            references users
);

alter table user_task
    owner to postgres;
