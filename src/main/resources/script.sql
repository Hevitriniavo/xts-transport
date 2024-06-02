CREATE TABLE cabin (
    id SERIAL PRIMARY KEY,
    number INT NOT NULL,
    type VARCHAR(150) NOT NULL,
    capacity INT,
    deck INT,
    price DECIMAL(15,2)
);

CREATE TABLE company (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    headquarters VARCHAR(150)
);

CREATE TABLE country (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE port (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    city VARCHAR(50),
    country_id INT REFERENCES country(id) ON DELETE CASCADE
);

CREATE TABLE route (
    id SERIAL PRIMARY KEY,
    departure_date TIMESTAMP,
    arrival_date TIMESTAMP
);

CREATE TABLE ship (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    capacity INT,
    type VARCHAR(50),
    cabin_id INT REFERENCES cabin(id) ON DELETE CASCADE
);

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    last_name VARCHAR(250) NOT NULL,
    first_name VARCHAR(250),
    salary DECIMAL(15,2)
);

CREATE TABLE passenger (
    id SERIAL PRIMARY KEY,
    last_name VARCHAR(250) NOT NULL,
    first_name VARCHAR(250)
);

CREATE TABLE ship_company (
    ship_id INT REFERENCES ship(id) ON DELETE CASCADE,
    company_id INT REFERENCES company(id) ON DELETE CASCADE,
    PRIMARY KEY (ship_id, company_id)
);

CREATE TABLE port_route (
    port_id INT REFERENCES port(id) ON DELETE CASCADE,
    route_id INT REFERENCES route(id) ON DELETE CASCADE,
    PRIMARY KEY (port_id, route_id)
);

CREATE TABLE route_ship (
    route_id INT REFERENCES route(id) ON DELETE CASCADE,
    ship_id INT REFERENCES ship(id) ON DELETE CASCADE,
    PRIMARY KEY (route_id, ship_id)
);

CREATE TABLE ship_employee (
    ship_id INT REFERENCES ship(id) ON DELETE CASCADE,
    employee_id INT REFERENCES employee(id) ON DELETE CASCADE,
    PRIMARY KEY (ship_id, employee_id)
);

CREATE TABLE ship_passenger (
    ship_id INT REFERENCES ship(id) ON DELETE CASCADE,
    passenger_id INT REFERENCES passenger(id) ON DELETE CASCADE,
    PRIMARY KEY (ship_id, passenger_id)
);

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    passenger_id INT REFERENCES passenger(id) ON DELETE CASCADE,
    ship_id INT REFERENCES ship(id) ON DELETE CASCADE,
    cabin_id INT REFERENCES cabin(id) ON DELETE CASCADE,
    route_id INT REFERENCES route(id) ON DELETE CASCADE,
    reservation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    fee DECIMAL(15,2)
);

CREATE TABLE payment
(
    id             SERIAL PRIMARY KEY,
    reservation_id INT REFERENCES reservation (id) ON DELETE CASCADE,
    amount         DECIMAL(15, 2),
    payment_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    payment_method VARCHAR(50) NOT NULL,
    payment_status VARCHAR(50) NOT NULL
)