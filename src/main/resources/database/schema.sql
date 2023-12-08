-- Database Schema

--Role table
CREATE TABLE IF NOT EXISTS "role" (
    role_id     SERIAL PRIMARY KEY,
    role_name   VARCHAR(50)     NOT NULL
);

-- User_Account Table
CREATE TABLE IF NOT EXISTS "user_account" (
    user_id         UUID PRIMARY KEY            DEFAULT gen_random_uuid(),
    first_name      VARCHAR(255)                NOT NULL,
    last_name       VARCHAR(255)                NOT NULL,
    password_hash   VARCHAR(512)                NOT NULL,
    email           VARCHAR(255)                NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS "user_role" (
    user_id UUID NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user_account ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "income_type" (
    income_type_id      SERIAL PRIMARY KEY,
    income_type_name    VARCHAR(255)            NOT NULL
);

CREATE TABLE IF NOT EXISTS "income" (
    income_id       UUID PRIMARY KEY        DEFAULT gen_random_uuid(),
    income_name     VARCHAR(255)            NOT NULL,
    user_id         UUID REFERENCES         user_account(user_id),
    income_type_id  INTEGER REFERENCES      income_type(income_type_id),
    income_date     DATE                    NOT NULL
);

CREATE TABLE IF NOT EXISTS "expense_type" (
    expense_type_id     SERIAL PRIMARY KEY,
    expense_type_name   VARCHAR(255)        NOT NULL
);

CREATE TABLE IF NOT EXISTS "expense" (
    expense_id          UUID PRIMARY KEY    DEFAULT gen_random_uuid(),
    expense_name        VARCHAR(255)        NOT NULL,
    user_id             UUID REFERENCES     user_account(user_id),
    expense_type_id     INTEGER REFERENCES  expense_type(expense_type_id),
    expense_date        DATE                NOT NULL
);

