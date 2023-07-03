create table reservation_insurances
(
    reservation_insurance_id int auto_increment
        primary key,
    reservation_id           int not null,
    insurance_id             int not null,
    constraint insurances___fk
        foreign key (insurance_id) references insurances (insurance_id),
    constraint reservation__fk
        foreign key (reservation_id) references reservations (reservation_id)
);

