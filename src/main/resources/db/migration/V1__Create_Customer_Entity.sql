CREATE TABLE IF NOT EXISTS customer (
    id                      BINARY(16) PRIMARY KEY                          NOT NULL,
    is_active               TINYINT(1)                                      DEFAULT 0,
    username                VARCHAR(64)                                     NOT NULL CHECK (LENGTH(username) >= 8),
    password                VARCHAR(255)                                    NOT NULL,
    first_name              VARCHAR(255)                                    NOT NULL,
    last_name               VARCHAR(255)                                    NOT NULL,
    middle_name             VARCHAR(255),
    nickname                VARCHAR(255),
    email                   VARCHAR(255)                                    NOT NULL UNIQUE,
    gender                  ENUM('MALE', 'FEMALE', 'OTHER')                 NOT NULL,
    phone_prefix_mobile     VARCHAR(10),
    phone_mobile            VARCHAR(20)                                     NOT NULL UNIQUE,
    birth_date              DATE,
    role                    ENUM('USER', 'ADMIN', 'SUPER_ADMIN')            NOT NULL,
    updated_at              TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by              VARCHAR(64)
);
