use truyum;
insert into menu_item (me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery) values("Sandwich",99.00,"Yes","2017-03-15","Main Course","Yes");
insert into menu_item (me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery)  values("Burger",129.00,"Yes","2017-12-23","Main Course","No");
insert into menu_item (me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery)  values("Pizza",149.00,"Yes","2017-08-21","Main Course","No");
insert into menu_item (me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery) values("French Fries",57.00,"No","2017-07-02","Starters","Yes");
insert into menu_item (me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery)  values("Chocolate Brownie",32.00,"Yes","2022-11-02","Dessert","Yes");
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from menu_item;
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from menu_item where me_date_of_launch<=curdate() and me_active="Yes";
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from menu_item where me_id=3;
update menu_item set me_name="Potato Wedges",me_price=60.00,me_active="Yes",me_date_of_launch="2017-05-07",me_category="Starters",me_free_delivery="No" where me_id=4; 
insert into user (us_name) values("Priya");
insert into user (us_name) values("Krishna");
insert into cart (ct_us_id,ct_pr_id) values(2,2);
insert into cart (ct_us_id,ct_pr_id) values(2,3);
insert into cart (ct_us_id,ct_pr_id) values(2,5);
select m.me_name,m.me_price,m.me_free_delivery from menu_item m join cart c on m.me_id=c.ct_pr_id join user u on u.us_id=ct_us_id where u.us_id=2;
select sum(m.me_price) as total from menu_item m join cart c on m.me_id=c.ct_pr_id join user u on u.us_id=ct_us_id where u.us_id=2;
delete from cart where ct_us_id=2 and ct_pr_id=5;


