
CREATE SEQUENCE grocery_item_gro_id_seq;

CREATE TABLE helloworld.grocery_item (

 gro_id INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('grocery_item_gro_id_seq'::regclass),
 gro_name CHARACTER VARYING(26) NOT NULL,
 gro_isle INTEGER,
 gro_price NUMERIC,
 gro_cat CHARACTER VARYING(26)
 );
 CREATE UNIQUE INDEX grocery_item_gro_id_uindex ON grocery_item USING BTREE (gro_id);
