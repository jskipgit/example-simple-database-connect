CREATE TABLE helloworld.pets
(
    pet_name varchar(26) NOT NULL,
    pet_type varchar(26),
    pet_age integer,
    pet_own_name varchar(26),
    pet_color varchar(26),
    pet_id bigint DEFAULT nextval('pets_pet_id_seq'::regclass) PRIMARY KEY NOT NULL
);
CREATE UNIQUE INDEX pets_pet_name_uindex ON helloworld.pets (pet_name);
INSERT INTO helloworld.pets (pet_name, pet_type, pet_age, pet_own_name, pet_color, pet_id) VALUES ('test', 'test', 3, 'asdf', 'asdf', 115);

