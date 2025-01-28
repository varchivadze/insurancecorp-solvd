USE insur_corp_db;
ALTER TABLE addresses AUTO_INCREMENT = 1;
ALTER TABLE insurance_companies AUTO_INCREMENT = 1;
ALTER TABLE persons AUTO_INCREMENT = 1;
ALTER TABLE employees AUTO_INCREMENT = 1;
ALTER TABLE clients AUTO_INCREMENT = 1;
ALTER TABLE vehicles AUTO_INCREMENT = 1;
ALTER TABLE accidents AUTO_INCREMENT = 1;
ALTER TABLE accidents_vehicles_damaged AUTO_INCREMENT = 1;
ALTER TABLE insurances AUTO_INCREMENT = 1;
ALTER TABLE workshops AUTO_INCREMENT = 1;
ALTER TABLE repair_orders AUTO_INCREMENT = 1;

INSERT INTO addresses (country, city, postal_code, street, unit)
VALUES     
	("Poland", "Warsaw", "05-000", "Falencka", "1B"),
    ("Germany", "Baden-Baden", "00-000", "Mannheimer Str.", "15"),
    ("France", "Strasbourg", "00-000", "FreMan", "30"),
    ("Italy", "Rome", "00100", "Via Roma", "12"),
    ("Spain", "Madrid", "28001", "Gran Via", "45"),
    ("Netherlands", "Amsterdam", "1011AB", "Damrak", "8"),
    ("Belgium", "Brussels", "1000", "Rue de la Loi", "16"),
    ("Switzerland", "Zurich", "8001", "Bahnhofstrasse", "25"),
    ("Austria", "Vienna", "1010", "Kärntner Straße", "10"),
    ("Czech Republic", "Prague", "11000", "Náměstí Republiky", "3"),
    ("Portugal", "Lisbon", "1200-001", "Rua Augusta", "50"),
	("Norway", "Oslo", "0150", "Karl Johans Gate", "10"),
	("Sweden", "Stockholm", "11120", "Drottninggatan", "12"),
	("Denmark", "Copenhagen", "1050", "Nyhavn", "17"),
	("Finland", "Helsinki", "00100", "Mannerheimintie", "1"),
	("Ireland", "Dublin", "D02", "Grafton Street", "22"),
	("Hungary", "Budapest", "1011", "Clark Ádám tér", "5"),
	("Poland", "Krakow", "31-000", "Floriańska", "14"),
	("Greece", "Athens", "10552", "Ermou", "23"),
	("Turkey", "Istanbul", "34110", "Istiklal Caddesi", "48");
    
    
INSERT INTO workshops (address_id, specification)
VALUES 
	(2, "Engine"),
	(3, "carcass, paint"),
	(4, "wheels"),
	(5, "petrol system");
	
INSERT INTO persons (name, surname, dob, telephone_number, address_id)
VALUES 
	("John", "Doe", "1990-04-20", "+1234567890", 6),
    ("Jane", "Jane", "1990-04-20", "+1234567890", 7),
    ("Local", "Johnson", "1990-04-20", "+1234567890", 8),
    ("Bob", "Brown", "1990-04-20", "+1234567890", 9),
    ("Charlie", "Dan", "1990-04-20", "+1234567890", 1),
    ("Alice", "Unknown", "1990-04-20", "+1234567890", 1),
    ("Pupa", "loopa", "1990-04-20", "+1234567890", 1);

INSERT INTO insurance_companies (name, address_id)
VALUES ("PZU", 10);

INSERT INTO employees (position, salary, bonus, passport_id, person_id, insurance_company_id)
VALUES     
	("assistant", 7500, 500.00, "AA1234567", 4, 1),
    ("appraiser", 6000, 300.50, "BB9876543", 5, 1);

INSERT INTO clients (person_id, discount, insurance_company_id)
VALUES 
	(1, 0, 1),
    (2, 5, 1),
    (3, 10, 1);

INSERT INTO vehicles (made, model, produced, plate_number, vin, seats, owner_id)
VALUES     
	("Toyota", "Corolla", 2015, "AB123CD", "VIN123456789001", 5, 1),
    ("Ford", "Focus", 2018, "XY456ZT", "VIN123456789002", 5, 2),
    ("Volkswagen", "Golf", 2020, "KL789MN", "VIN123456789003", 5, 3);


INSERT INTO accidents (date, address_id, culprit_vehicle_id, appraiser_id, assistant_id, notes)
VALUES ("2025-01-22 05:45:00", 1, 1, 2, 1, "");
SET @accident_id = LAST_INSERT_ID();
INSERT INTO accidents_vehicles_damaged (accidents_id, vehicles_id)
VALUES 
	(@accident_id, 2),
	(@accident_id, 3);

INSERT INTO accidents (date)
VALUES ("2025-01-25 21:45:00");
SET @accident_id = LAST_INSERT_ID();

INSERT INTO accidents_vehicles_damaged (accidents_id, vehicles_id)
VALUES 
	(@accident_id, 3);

INSERT INTO addresses (country, city, postal_code, street, unit)
VALUES ("Poland", "Warsaw", "05-000", "Falencka", "33");
SET @address_id = LAST_INSERT_ID();

INSERT INTO vehicles (made, model, produced, plate_number, vin, seats, owner_id)
VALUES ("Toyota", "Camry", 2018, "AB123CD", "VIN123456789001", 5, 1);
SET @vehicles_id = LAST_INSERT_ID();

UPDATE accidents
SET address_id = @address_id, culprit_vehicle_id = @vehicles_id, appraiser_id = 2, assistant_id = 1, notes = "New accident"
where id = @accident_id;

INSERT INTO repair_orders (order_date, workshop_id, cost, description, paid, complete, accidents_id)
VALUES("2025-01-23", 1, 500, "Broken window", 0, 0, 1);

INSERT INTO insurances (police_number, vehicle_id, insured_from, insured_till, insurance_coverage, oc)
VALUES 
	("INS-1234", 1, "2025-01-01", "2026-01-01", 50000.00, 1),
    ("INS-5678", 2, "2025-01-10", "2026-01-10", 40000.00, 1),
    ("INS-9101", 3, "2025-02-01", "2026-02-01", 60000.00, 1),
    ("INS-1122", 4, "2025-03-01", "2026-03-01", 70000.00, 1);

INSERT INTO addresses (country, city, postal_code, street, unit)
VALUES ('for_delete', 'for_delete', '00000', 'Temp Street', 'Temp 1');
DELETE FROM addresses WHERE postal_code = '00000';

INSERT INTO persons (name, surname, dob, telephone_number, address_id)
VALUES ('for_delete', 'for_delete', '2000-01-01', '+000000000', 1);
DELETE FROM persons WHERE name = 'for_delete';

INSERT INTO employees (position, salary, bonus, passport_id, person_id, insurance_company_id)
VALUES ('for_delete', 1, 1, 'for_delete0000', 8, 1);
DELETE FROM employees WHERE position = 'for_delete';

INSERT INTO vehicles (made, model, produced, plate_number, vin, seats, owner_id)
VALUES ('temp', 'temp', 2000, 'TEMP000', 'TEMP000VIN', 3, 1);
DELETE FROM vehicles WHERE made = 'Temp';

INSERT INTO accidents (date, address_id, culprit_vehicle_id, appraiser_id, assistant_id, notes)
VALUES ('2000-01-01 00:00:00', 1, 1, 1, 1, 'Temp');
DELETE FROM accidents WHERE notes = 'Temp';

INSERT INTO clients (person_id, discount, insurance_company_id)
VALUES (7, 15, 1);
DELETE FROM clients WHERE discount = 15;

INSERT INTO workshops (address_id, specification)
VALUES (1, 'delete');
DELETE FROM workshops WHERE specification = 'delete';

DELETE FROM repair_orders WHERE description = 'Broken window';

DELETE FROM insurances WHERE police_number = 'INS-1234';

INSERT INTO accidents_vehicles_damaged (accidents_id, vehicles_id)
VALUES (2, 2);
DELETE FROM accidents_vehicles_damaged WHERE accidents_id = 1 AND vehicles_id = 1;

UPDATE addresses SET street = 'Updated Street' WHERE id = 1;
UPDATE persons SET telephone_number = '+999999999' WHERE id = 1;
UPDATE employees SET salary = 8000 WHERE id = 1;
UPDATE vehicles SET model = 'Updated Model' WHERE id = 1;
UPDATE accidents SET notes = 'Updated Note' WHERE id = 1;
UPDATE workshops SET specification = 'Updated Specification' WHERE id = 1;
UPDATE repair_orders SET cost = 1000 WHERE id = 1;
UPDATE clients SET discount = 20 WHERE id = 1;
UPDATE insurances SET insurance_coverage = 90000 WHERE id = 1;
UPDATE accidents_vehicles_damaged SET vehicles_id = 1 WHERE accidents_id = 2 AND vehicles_id = 3;

ALTER TABLE persons MODIFY COLUMN telephone_number VARCHAR(20);
ALTER TABLE employees DROP INDEX unique_passport;
ALTER TABLE employees ADD UNIQUE INDEX unique_passport (passport_id);
-- ALTER TABLE insurances RENAME COLUMN policeNumber TO police_number;



INSERT INTO addresses (country, city, postal_code, street, unit)
VALUES     
	("Land", "Big_length_country", "05-000", "Falencka", "1B"),
    ("another_land", "Big_length_country", "00-000", "Mannheimer Str.", "15");


INSERT INTO accidents (date, address_id, culprit_vehicle_id, appraiser_id, assistant_id, notes)
VALUES
    ("2025-01-23 05:45:00", 1, 1, 2, 1, "");


