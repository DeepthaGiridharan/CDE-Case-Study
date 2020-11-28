create database truyum;
use truyum;
create table user (us_id INT auto_increment primary key,us_name varchar(60));
create table menu_item (me_id INT auto_increment primary key,me_name varchar(100),me_price numeric(8,2),me_active varchar(3),me_date_of_launch date,me_category varchar(45),me_free_delivery varchar(3));
create table cart (ct_id INT not null,ct_us_id INT not null, ct_pr_id INT not null,FOREIGN KEY(ct_us_id) references user(us_id),FOREIGN KEY(ct_pr_id) references menu_item(me_id));
ALTER TABLE cart
ADD CONSTRAINT PRIMARY KEY (ct_id,ct_us_id);




