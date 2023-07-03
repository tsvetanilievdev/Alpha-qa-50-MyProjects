create table insurances
(
    insurance_id int auto_increment
        primary key,
    name         varchar(30)   not null,
    price        int default 0 not null
);

