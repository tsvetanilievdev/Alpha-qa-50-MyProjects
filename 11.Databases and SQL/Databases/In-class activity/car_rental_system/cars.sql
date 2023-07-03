create table cars
(
    car_id          int auto_increment
        primary key,
    brand_id        int           not null,
    model_name      char(20)      not null,
    production_year date          not null,
    mileage         int default 0 not null,
    color_id        int           not null,
    category_id     int           null,
    constraint brands___fk
        foreign key (brand_id) references brands (brand_id),
    constraint car_category_id
        foreign key (category_id) references car_categories (car_category_id),
    constraint color_id
        foreign key (color_id) references colors (color_id)
);

