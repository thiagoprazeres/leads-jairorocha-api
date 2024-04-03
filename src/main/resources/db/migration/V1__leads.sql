-- Criação da tabela lead
CREATE TABLE lead (
    id SERIAL PRIMARY KEY,
    source VARCHAR(255) NOT NULL,
    ad_id VARCHAR(255),
    list_id VARCHAR(255) NOT NULL,
    link_ad VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255),
    message TEXT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    external_id VARCHAR(255)
);

-- Criação da tabela ads_info
CREATE TABLE ads_info (
    id_ad_data INT PRIMARY KEY REFERENCES lead(id) ON DELETE CASCADE ON UPDATE CASCADE,
    category INT,
    subject VARCHAR(255),
    body TEXT,
    type VARCHAR(50),
    price VARCHAR(50),
    zipcode VARCHAR(50),
    regdate VARCHAR(50),
    mileage VARCHAR(50),
    carcolor VARCHAR(50),
    fuel VARCHAR(50),
    car_steering VARCHAR(50),
    exchange VARCHAR(50),
    owner VARCHAR(50),
    financial VARCHAR(255),
    financial_status VARCHAR(50),
    vehicle_brand VARCHAR(50),
    vehicle_model VARCHAR(50),
    vehicle_version VARCHAR(50),
    cubiccms VARCHAR(50),
    moto_features VARCHAR(255)
);