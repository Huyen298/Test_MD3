create database product;
use product;
create table category(
    id int primary key auto_increment not null ,
    category varchar(50)
);
create table product(
    id int auto_increment not null primary key,
    name varchar(50),
    price int ,
    quality int,
    color varchar(50),
    category_id int,
    foreign key (category_id) references category(id)
);
insert into category(category) VALUES ('Phone');
insert into category(category) VALUES ('Television');
select * from category;
insert into product(name, price, quality, color, category_id) VALUES ('iphone11',800,10,'black',1);
insert into product(name, price, quality, color, category_id) VALUES ('iphone12',500,5,'black',1);
insert into product(name, price, quality, color, category_id) VALUES ('smart TV',1500,15,'black',2);
select * from product;
select product.id as id,product.name as name,product.price as price,product.quality as quality,product.color as color,product.category_id,c.category as category from product join product.category c on c.id = product.category_id;
