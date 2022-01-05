INSERT INTO departments(name) VALUES ('Gestão');
INSERT INTO departments(name) VALUES ('Informática');

INSERT INTO users(fk_department_id, email, password) VALUES (1, 'maria@gmail.com', '123456');
INSERT INTO users(fk_department_id, email, password) VALUES (1, 'bob@gmail.com', '654987');
INSERT INTO users(fk_department_id, email, password) VALUES (2, 'alex@gmail.com', 'aaa123');
INSERT INTO users(fk_department_id, email, password) VALUES (2, 'ana@gmail.com', '321kjh');