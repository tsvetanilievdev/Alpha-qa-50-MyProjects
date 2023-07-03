create table cities_locations
(
    city_location_id int auto_increment
        primary key,
    city_id          int null,
    location_id      int null,
    constraint city_id
        foreign key (city_id) references cities (city_id),
    constraint location_id
        foreign key (location_id) references locations (location_id)
);

