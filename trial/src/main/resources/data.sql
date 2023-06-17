create sequence if not exists brand_seq start with 1;
CREATE TABLE if not exists brand (
    id int8 not null default next value for brand_seq primary key,
    name varchar(255)
);
insert into brand values (1, 'Zara');

create sequence if not exists product_seq start with 1;
CREATE TABLE if not exists product (
    id int8 not null default next value for product_seq primary key,
    name varchar(255),
    description varchar(255)
);
insert into product values (35455, 'Camiseta Oversize', 'Camiseta de color blanco de un tamaño mayor.');

CREATE TABLE if not exists prices (
    brand_id int8 not null,
    start_date timestamp,
    end_date timestamp,
    price_list int8,
    product_id int8 not null,
    priority int8,
    price decimal(15,2),
    curr varchar(3),
    primary key (brand_id, product_id, price),
    CONSTRAINT brand_fk FOREIGN KEY (brand_id) REFERENCES brand(id),
    CONSTRAINT product_fk FOREIGN KEY (product_id) REFERENCES product(id)
);
insert into prices(brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
values (1, '2020-06-14T00:00:00', '2020-12-31T23:59:59', 1, 35455, 0, 35.50, 'EUR');
insert into prices(brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
values (1, '2020-06-14T15:00:00', '2020-12-31T23:59:59', 2, 35455, 1, 25.45, 'EUR');
insert into prices(brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
values (1, '2020-06-15T00:00:00', '2020-12-31T23:59:59', 3, 35455, 1, 30.50, 'EUR');
insert into prices(brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
values (1, '2020-06-15T16:00:00', '2020-12-31T23:59:59', 4, 35455, 1, 38.95, 'EUR');
