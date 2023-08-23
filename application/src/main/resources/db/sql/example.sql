CREATE TABLE IF NOT EXISTS `example`
(
    id INT
(
    11
) NOT NULL,
    name VARCHAR
(
    100
) NULL,
    description VARCHAR
(
    100
) NULL,
    is_deleted TINYINT
(
    4
) NOT NULL DEFAULT 0,
    created_by VARCHAR
(
    255
) DEFAULT NULL,
    created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
(
),
    updated_by VARCHAR
(
    255
) DEFAULT NULL,
    updated_time DATETIME DEFAULT NULL,
    deleted_by VARCHAR
(
    255
) DEFAULT NULL,
    deleted_time DATETIME DEFAULT NULL,
    PRIMARY KEY
(
    id
)
    );
