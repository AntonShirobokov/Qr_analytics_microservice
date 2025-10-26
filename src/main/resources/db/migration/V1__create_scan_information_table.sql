create table scan_information(
    scan_id serial primary key,
    qr_code_id uuid,
    ip_address varchar(100),
    scan_at timestamp,
    continent varchar,
    country varchar,
    region varchar,
    city varchar,
    postal_code varchar,
    latitude float,
    longitude float
);
