create table additional_options
(
    additional_option_id int auto_increment
        primary key,
    name                 char(30)      not null,
    price                int default 0 not null
);

