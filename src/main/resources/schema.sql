CREATE TABLE CATEGORY (id BIGINT AUTO_INCREMENT  PRIMARY KEY, name_category VARCHAR(255));

CREATE TABLE PRODUCT (id BIGINT AUTO_INCREMENT  PRIMARY KEY, name VARCHAR(255), price DOUBLE, description
                         VARCHAR(255), category_id BIGINT, foreign key (category_id) references CATEGORY(id));

CREATE TABLE ROLES(id BIGINT PRIMARY KEY, name VARCHAR(20));

CREATE TABLE USERS(id BIGINT AUTO_INCREMENT  PRIMARY KEY,  username VARCHAR(20) , enabled bool,
                   password VARCHAR(250));

CREATE TABLE ROLES_USERS (id BIGINT PRIMARY KEY, id_roles BIGINT, id_user VARCHAR(20),
                          foreign key (id_roles) references ROLES(id),
                          foreign key (id_user) references USERS(id));