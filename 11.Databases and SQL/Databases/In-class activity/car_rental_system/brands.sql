create table brands
(
    brand_id int auto_increment
        primary key,
    name     char(20) not null,
    constraint name
        unique (name)
);

