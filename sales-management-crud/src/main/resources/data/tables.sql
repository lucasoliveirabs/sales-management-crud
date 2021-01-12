create table sales (
sale_id int not null auto_increment,
product_id int not null,
lead_id int not null,
sale_date datetime not null,
sale_delivery_date datetime not null,
sale_delivery_adress varchar(50) not null,
sale_observation varchar(50) null,
sale_status char not null,
sale_cancel_date datetime null, 
sale_cancel_reason varchar(50) null,
primary key (sale_id),
foreign key (product_id) references products (product_id),
foreign key (lead_id) references leads (lead_id)
);

create table users (
user_id int not null auto_increment,
user_username varchar(20) not null,
user_password varchar(15) not null,
user_first_name varchar(15) not null,
user_last_name varchar(50) not null,
primary key (user_id)
);

create table leads(
lead_id int not null auto_increment,
lead_first_name varchar(20) not null,
lead_last_name varchar(50) not null,
lead_main_channel varchar(15) not null,
lead_whatsapp varchar(20) not null,
lead_facebook varchar(50) not null,
lead_instagram varchar(30) not null,
lead_email varchar(50) not null,
primary key (lead_id)
);

create table products (
product_id int not null auto_increment,
product_class varchar(20) not null,
product_name varchar(30) not null,
primary key (product_id)
);