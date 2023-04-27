CREATE TABLE mini_user
(
    user_id     BIGINT       NOT NULL,
    create_by   VARCHAR(255) NULL,
    create_time datetime     NULL,
    update_by   VARCHAR(255) NULL,
    update_time datetime     NULL,
    is_delete   INT          NULL,
    username    VARCHAR(255) NULL,
    password    VARCHAR(255) NULL,
    phone       VARCHAR(255) NULL,
    email       VARCHAR(255) NULL,
    salt        VARCHAR(255) NULL,
    CONSTRAINT pk_mini_user PRIMARY KEY (user_id)
);