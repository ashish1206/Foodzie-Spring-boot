
CREATE TABLE "user"(
	username VARCHAR(50) NOT null UNIQUE,
	email VARCHAR(50) NOT null UNIQUE,
	password VARCHAR(70) NOT NULL,
	phone_number VARCHAR(10) NOT NULL UNIQUE,
	constraint user_email_PK primary key ( email )
);

CREATE TABLE "address"(
	add_id SERIAL NOT null,
	add_line_1 VARCHAR(50) NOT null,
	add_line_2 VARCHAR(50),
	city VARCHAR(70) NOT NULL,
	state VARCHAR(10) NOT NULL,
	pin VARCHAR(10) not null,
	email VARCHAR(50) unique,
	constraint address_add_id_PK primary key ( add_id )
);

ALTER TABLE address 
ADD CONSTRAINT address_email_fk FOREIGN KEY ( email ) 
REFERENCES "user"( email );

CREATE TABLE "seller"(
	s_name VARCHAR(50) NOT null UNIQUE,
	email VARCHAR(50) NOT null UNIQUE,
	password VARCHAR(70) NOT NULL,
	phone_number VARCHAR(10) NOT NULL UNIQUE,
	add_id INT unique,
	constraint seller_email_PK primary key ( email )
);

CREATE TABLE "menu"(
	d_id SERIAL NOT null,
	dish_name VARCHAR(50) NOT null,
	description VARCHAR(100),
	price decimal NOT NULL,
	email VARCHAR(50),
	constraint menu_d_id_PK primary key ( d_id )
);

ALTER TABLE menu 
ADD CONSTRAINT address_email_fk FOREIGN KEY ( email ) 
REFERENCES "seller"( email );

CREATE TABLE "cart"(
	cart_id SERIAL not null,
	quantity INT NOT null,
	d_id INT,
	email VARCHAR(50) ,
	constraint cart_cart_id_PK primary key ( cart_id )
);

ALTER TABLE cart 
ADD CONSTRAINT cart_email_fk FOREIGN KEY ( email ) 
REFERENCES "user"( email );

ALTER TABLE cart 
ADD CONSTRAINT cart_d_id_fk FOREIGN KEY ( d_id ) 
REFERENCES "menu"( d_id );

CREATE TABLE "order_user_mapping"(
	order_id serial not null,
	user_email VARCHAR(50),
	seller_email varchar(50),
	address varchar(150) not null,
	constraint order_user_mapping_order_id_PK primary key ( order_id )
);

ALTER TABLE order_user_mapping 
ADD CONSTRAINT order_user_mapping_user_email_fk FOREIGN KEY ( user_email ) 
REFERENCES "user"( email );

ALTER TABLE order_user_mapping 
ADD CONSTRAINT order_user_mapping_seller_email_fk FOREIGN KEY ( seller_email ) 
REFERENCES "seller"( email );

CREATE TABLE "order_menu_mapping"(
	id serial,
	order_id int,
	d_id int,
	quantity int not null,
	total_price decimal not null,
	constraint order_menu_mapping_id_PK primary key ( id )
);

ALTER TABLE order_menu_mapping 
ADD CONSTRAINT order_menu_mapping_order_id_fk FOREIGN KEY ( order_id ) 
REFERENCES "order_user_mapping"( order_id);

ALTER TABLE order_menu_mapping 
ADD CONSTRAINT order_menu_mapping_d_id_fk FOREIGN KEY ( d_id ) 
REFERENCES "menu"( d_id );

commit;