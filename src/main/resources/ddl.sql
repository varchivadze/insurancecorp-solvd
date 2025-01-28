create database if not exists insur_corp_db;
use insur_corp_db;

create table if not exists addresses (
    id serial,
    country varchar(25) not null,
    city varchar(25) not null,
    postal_code varchar(8) not null,
    street varchar(45) not null,
    unit varchar(25) not null,
    primary key (id)
);

create table if not exists insurance_companies (
    id serial,
    name varchar(25) not null,
    address_id bigint unsigned not null,
    primary key (id),
    constraint fk_insurance_companies_address_addresses_id foreign key (address_id) references addresses(id)
        on update no action
        on delete cascade
);

create table if not exists persons (
    id serial,
    name varchar(30) not null,
    surname varchar(30) not null,
    dob date not null,
    telephone_number varchar(15) not null,
    address_id bigint unsigned null,
    primary key (id),
    constraint fk_person_address_addresses_id foreign key (address_id) references addresses(id)
        on update no action
        on delete cascade
);

create table if not exists employees (
    id serial,
    position varchar(45) not null,
    salary bigint unsigned not null,
    bonus decimal unsigned not null,
    passport_id varchar(15) not null,
    person_id bigint unsigned not null,
    insurance_company_id bigint unsigned not null,
    primary key (id),
    unique (person_id),
    constraint fk_employee_insurance_company_insurance_companies_id foreign key (insurance_company_id) references insurance_companies(id)
        on update no action
        on delete cascade,
    constraint fk_employees_person_persons_id foreign key (person_id) references persons(id)
        on update no action
        on delete cascade
);

create table if not exists clients (
    id serial,
    person_id bigint unsigned not null,
    discount decimal not null,
    insurance_company_id bigint unsigned not null,
    primary key (id),
    unique (person_id),
    constraint fk_client_person_persons_id foreign key (person_id) references persons(id)
        on update no action
        on delete cascade,
    constraint fk_clients_insurance_company_insurance_companies_id foreign key (insurance_company_id) references insurance_companies(id)
        on update no action
        on delete cascade
);

create table if not exists vehicles (
    id serial,
    made varchar(45) not null,
    model varchar(45) not null,
    produced year not null,
    plate_number varchar(10) not null,
    vin varchar(30) not null,
    seats int not null,
    owner_id bigint unsigned null,
    primary key (id),
    constraint fk_vehicles_client_clients_id foreign key (owner_id) references clients(id)
        on update no action
        on delete cascade
);

create table if not exists accidents (
    id serial,
    date datetime not null,
    address_id bigint unsigned null,
    culprit_vehicle_id bigint unsigned null,
    appraiser_id bigint unsigned null,
    assistant_id bigint unsigned null,
    notes text null,
    primary key (id),
    constraint fk_accidents_address_addresses_id foreign key (address_id) references addresses(id)
        on update no action
        on delete cascade,
    constraint fk_accidents_culprit_vehicle_vehicles_id foreign key (culprit_vehicle_id) references vehicles(id)
        on update no action
        on delete cascade,
    constraint fk_accidents_appraiser_employees_id foreign key (appraiser_id) references employees(id)
        on update no action
        on delete cascade,
    constraint fk_accidents_assistant_employees_id foreign key (assistant_id) references employees(id)
        on update no action
        on delete cascade
);

create table if not exists accidents_vehicles_damaged (
    accidents_id bigint unsigned not null,
    vehicles_id bigint unsigned not null,
    primary key (accidents_id, vehicles_id),
    constraint fk_accidents_vehicles foreign key (accidents_id) references accidents(id)
        on update no action
        on delete cascade,
    constraint fk_accidents_vehicles_damaged_vehicles1 foreign key (vehicles_id) references vehicles(id)
        on update no action
        on delete cascade
);

create table if not exists insurances (
    id serial,
    police_number varchar(45) not null,
    vehicle_id bigint unsigned not null,
    insurance_company_id bigint unsigned not null,
    insured_from date not null,
    insured_till date not null,
    insurance_coverage decimal not null,
    oc tinyint(1) not null,
    primary key (id),
    constraint fk_insurances_vehicle_vehicles_id foreign key (vehicle_id) references vehicles(id)
        on update no action
        on delete cascade
);

create table if not exists workshops (
    id serial,
    address_id bigint unsigned not null,
    specification text not null,
    primary key (id),
    constraint fk_workshops_address_addresses_id foreign key (address_id) references addresses(id)
        on update no action
        on delete cascade
);

create table if not exists repair_orders (
    id serial,
    order_date date null,
    workshop_id bigint unsigned null,
    cost decimal null,
    description text null,
    paid decimal null,
    complete tinyint(1) null,
    accidents_id bigint unsigned null,
    primary key (id),
    constraint fk_repair_order_workshop_workshops_id foreign key (workshop_id) references workshops(id)
        on update no action
        on delete cascade,
    constraint fk_repair_orders_accident_accidents_id foreign key (accidents_id) references accidents(id)
        on update no action
        on delete cascade
);

