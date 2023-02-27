BEGIN TRANSACTION;

DROP TABLE IF EXISTS customer, employee, departments CASCADE;


CREATE TABLE customer (
                          cust_id serial,
                          first_name varchar(50) NOT NULL,
                          last_name varchar(50) NOT NULL,
                          st_address varchar(100) NOT NULL,
                          zip_code varchar(10) NOT NULL,
                          phone_number varchar(15) NOT NULL,
                          email varchar(100) NOT NULL,
                          date_of_first_job date NOT NULL,
                          pet boolean DEFAULT false,
                          email_alerts boolean DEFAULT false,
                          CONSTRAINT PK_customer PRIMARY KEY(cust_id),
                          UNIQUE(email),
                          UNIQUE(phone_number)
);

CREATE TABLE employee (
                          employ_id serial,
                          first_name varchar(50) NOT NULL,
                          last_name varchar(50) NOT NULL,
                          st_address varchar(100) NOT NULL,
                          zip_code varchar(10) NOT NULL,
                          phone_number varchar(15) NOT NULL,
                          email varchar(100) NOT NULL,
                          date_of_birth date NOT NULL,
                          date_of_hire date NOT NULL,
                          CONSTRAINT PK_employee PRIMARY KEY(employ_id),
                          UNIQUE(email),
                          UNIQUE(phone_number)
);

CREATE TABLE work_order (
                            order_id serial,
                            cust_id int NOT NULL,
                            issue varchar(300) NOT NULL,
                            date_scheduled date NOT NULL,
                            repair varchar(300),
    --ADD MATERIAL AND PRICE, NO CLUE WHAT TO DO RIGHT NOW
                            CONSTRAINT PK_order_id PRIMARY KEY(order_id),
                            CONSTRAINT FK_work_order_cust FOREIGN KEY(cust_id) REFERENCES customer(cust_id)
);

COMMIT;