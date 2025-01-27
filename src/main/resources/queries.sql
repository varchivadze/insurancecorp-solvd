SELECT
    a.id AS addresses_id,
    a.country, a.city, a.postal_code,
    p.id AS person_id,
    p.name, p.surname,
    c.id AS client_id,
    c.discount,
    ic.id AS insurance_company_id,
    ic.name,
    v.id AS vehicle_id,
    v.made,
    v.model,
    isc.police_number,
    isc.insured_from,
    isc.insured_till

FROM addresses a
LEFT JOIN persons p ON a.id = p.address_id
LEFT JOIN clients c ON p.id = c.person_id
LEFT JOIN insurance_companies ic ON c.insurance_company_id = ic.id
LEFT JOIN vehicles v ON v.owner_id = c.id
LEFT JOIN insurances isc ON isc.id = v.id;

SELECT
    p.id AS person_id,
    p.name,
    p.surname,
	a.id AS address_id,
    a.country
FROM persons p
LEFT JOIN addresses a ON p.id = a.id;

SELECT
	a.id AS addresses_id,
    a.country,
    p.id AS person_id,
    p.name
FROM persons p
RIGHT JOIN addresses a on p.id = a.id;

SELECT
	a.id AS addresses_id,
    a.country,
    p.id AS person_id,
    p.name
FROM persons p
INNER JOIN addresses a on p.id = a.id;

SELECT
	p.id AS person_id,
    p.name, p.surname,
    c.discount AS discount
FROM persons p
INNER JOIN clients c ON c.id = p.id;

SELECT
    a.id AS addresses_id,
    a.country,
    p.id AS person_id,
    p.name,
    p.surname
FROM addresses a
LEFT JOIN persons p ON a.id = p.address_id
UNION
SELECT
    a.id AS addresses_id,
    a.country,
    p.id AS person_id,
    p.name,
    p.surname
FROM addresses a
RIGHT JOIN persons p ON a.id = p.address_id;

SELECT COUNT(distinct country) AS total_countries
FROM addresses;

SELECT
	country,
    COUNT(*) AS tot_country
FROM addresses
GROUP BY country;


SELECT
	city,
    COUNT(*) AS tot_cities
FROM addresses
GROUP BY city
HAVING CHAR_LENGTH(city) > 6;


SELECT
	culprit_vehicle_id,
    COUNT(*) as number_of_accidents,
    v.plate_number,
    v.made,
    v.model
FROM accidents ac
LEFT JOIN vehicles v ON v.id = ac.culprit_vehicle_id
GROUP BY ac.culprit_vehicle_id;

SELECT
	culprit_vehicle_id,
    v.plate_number,
    v.made,
    v.model
FROM accidents ac
LEFT JOIN vehicles v ON v.id = ac.culprit_vehicle_id;

SELECT
	p.name,
    p.surname,
    c.discount,
    COUNT(v.id) AS all_vehicles_by_owner
FROM clients c
LEFT JOIN persons p ON p.id = c.person_id
LEFT JOIN vehicles v ON v.owner_id = c.id
GROUP BY c.id;

SELECT
	p.name,
    p.surname,
    COUNT(a.id) AS total_accidents
FROM employees e
LEFT JOIN accidents a ON e.id = a.assistant_id
LEFT JOIN persons p ON e.person_id = p.id
GROUP BY e.id;