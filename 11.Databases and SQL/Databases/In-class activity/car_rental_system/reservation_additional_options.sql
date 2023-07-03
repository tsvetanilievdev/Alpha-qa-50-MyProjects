create table reservation_additional_options
(
    reservation_additional_option_id int auto_increment
        primary key,
    reservation_id                   int not null,
    additional_option_id             int not null,
    constraint additional_options___fk
        foreign key (additional_option_id) references additional_options (additional_option_id),
    constraint reservation___fk
        foreign key (reservation_id) references reservations (reservation_id)
);

