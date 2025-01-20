create database if not exists insur_corp_db;
use insur_corp_db;

create table if not exists addresses (
    id serial,
    country varchar(45) null,
    city varchar(45) null,
    postalcode varchar(7) null,
    street varchar(45) null,
    unit varchar(45) null,
    primary key (id)
);

create table if not exists persons (
    id serial,
    name varchar(30) not null,
    surname varchar(30) not null,
    dob date not null,
    telephone_number varchar(15) not null,
    address bigint unsigned not null,
    primary key (id),
    constraint fk_person_address_addresses_id foreign key (address) references address(id)
    on update no action
    on delete cascade
);

create table if not exists clients (
    id serial,
    discount decimal null,
    person bigint not null,
    primary key (id),
    constraint fk_client_person_persons_id foreign key (person) references persons(id)
    on update no action
    on delete cascade
);

create table if not exists vehicles (
    id serial,
    made varchar(45) not null,
    model varchar(45) not null,
    produced year not null,
    plate_number varchar(10) not null,
    vin varchar(25) not null,
    seats int not null,
    client bigint unsigned not null,
    primary key (id),
    constraint fk_vehicles_client_clients_id foreign key (client) references clients(id)
    on update no action
    on delete cascade
);

create table if not exists insurance_companies (
    id serial,
    name varchar(45) not null,
    address bigint not null,
    primary key (id),
    constraint fk_insurance_companies_address_addresses_id foreign key (address) references addresses(id)
    on update no action
    on delete cascade
);

create table if not exists employees (
    id serial,
    person bigint unsigned not null,
    insurance_company bigint unsigned not null,
    salary decimal unsigned not null,
    bonus decimal unsigned not null,
    primary key (id),
    constraint fk_employees_person_persons_id foreign key (person) references persons(id)
    on update no action
    on delete cascade,
    constraint fk_employee_insurance_company_insurance_companies_id foreign key (insurance_company) references insurance_companies(id)
    on update no action
    on delete cascade
);

create table if not exists accidents (
    id serial,
    date_time datetime not null,
    notes text not null,
    address bigint unsigned not null,
    culprit_vehicle bigint unsigned not null,
    insurance_company bigint unsigned not null,
    client bigint unsigned not null,
    appraiser bigint unsigned not null,
    assistant bigint unsigned not null,
    primary key (id),
    constraint fk_accidents_address_addresses_id foreign key (address) references addresses(id),
    on update no action
    on delete cascade,
    constraint fk_accidents_culprit_vehicle_vehicles_id foreign key (culprit_vehicle) references vehicles(id)
    on update no action
    on delete cascade,
    constraint fk_accidents_insurance_company_insurance_companies_id foreign key (insurance_company) references insurance_companies(id)
    on update no action
    on delete cascade,
    constraint fk_accidents_client_clients_id foreign key (client) references clients(id)
    on update no action
    on delete cascade,
    constraint fk_accidents_appraiser_employees_id foreign key (appraiser) references employees(id)
    on update no action
    on delete cascade,
    constraint fk_accidents_assistant_employees_id foreign key (assistant) references employees(id)
    on update no action
    on delete cascade
);

create table if not exists insurances (
    id serial,
    police_number varchar(45) not null,
    vehicle bigint unsigned not null,
    insured_from date not null,
    insured_till date not null,
    insurance_coverage  decimal not null,
    is_oc tinyint(1) not null,
    insurance_company bigint unsigned not null,
    primary key (id),
    constraint fk_insurances_vehicle_vehicles_id foreign key (vehicle) references vehicles(id)
    on update no action
    on delete cascade,
    constraint fk_insurances_insurance_company_insurance_companies_id foreign key (insurance_company) references insurance_companies(id)
    on update no action
    on delete cascade,
);

create table if not exists accidents_vehicles_damaged (
    accidents_id bigint unsigned not null,
    vehicles_id bigint unsigned not null,
    primary key (accidents_id, vehicles_id),
    constraint fk_accidents_vehicles foreign key (accidents_id) references accidents(id)
    on update no action
    on delete no action,
    constraint fk_vehicles_accidents foreign key (vehicles_id) references vehicles(id)
    on update no action
    on delete no action
);

create table if not exists workshops (
    id serial,
    address bigint unsigned not null,
    specification text null,
    primary key (id),
    constraint fk_workshops_address_addresses_id foreign key (address) references addresses(id)
    on update no action
    on delete cascade
);

create table if not exists repair_orders (
    id serial,
    accident bigint unsigned not null,
    date_report date not null,
    manager bigint unsigned not null,
    cost decimal not null,
    description text null,
    paid decimal null,
    complete tinyint(1) not null,
    workshop bigint unsigned not null,
    primary key (id),
    constraint fk_repair_orders_accident_accidents_id foreign key (accident) references accidents(id)
    on update no action
    on delete cascade,
    constraint fk_repair_orders_employee_employees_id foreign key (manager) references employees(id)
    on update no action
    on delete cascade,
    constraint fk_repair_order_workshop_workshops_id foreign key (workshop) references workshops(id)
    on update no action
    on delete cascade
);

