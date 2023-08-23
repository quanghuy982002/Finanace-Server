CREATE TABLE IF NOT EXISTS customer
(
    id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code         VARCHAR(50),
    name         VARCHAR(255),
    status       VARCHAR(50),
    group_name   VARCHAR(50),
    avatar_image VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS customer_detail
(
    id                  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id         INT,
    phone_number        VARCHAR(20),
    tax_id              VARCHAR(20),
    email               VARCHAR(255),
    fax                 VARCHAR(20),
    address             VARCHAR(255),
    bank_account_number VARCHAR(50),
    bank_name           VARCHAR(100),
    bank_branch         VARCHAR(100),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE IF NOT EXISTS representative
(
    id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id  INT,
    name         VARCHAR(255),
    gender       VARCHAR(10),
    phone_number VARCHAR(20),
    position     VARCHAR(100),
    avatar_image VARCHAR(255),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);