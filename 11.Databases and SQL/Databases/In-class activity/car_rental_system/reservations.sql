create table reservations
(
    reservation_id       int auto_increment
        primary key,
    start_date           datetime      not null,
    end_date             datetime      not null,
    price                int default 0 not null,
    car_category_id      int           not null,
    pickup_location_id   int           not null,
    drop_off_location_id int           null,
    user_id              int           not null,
    constraint category___fk
        foreign key (car_category_id) references car_categories (car_category_id),
    constraint drop_off_location___fk
        foreign key (drop_off_location_id) references cities_locations (city_location_id),
    constraint pickup_location___fk
        foreign key (pickup_location_id) references cities_locations (city_location_id),
    constraint user___fk
        foreign key (user_id) references users (user_id)
);

