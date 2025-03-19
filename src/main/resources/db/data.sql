insert into store_tb (name, stock, price) values ('바나나', 40, 3000);
insert into store_tb (name, stock, price) values ('딸기', 45, 2000);
-- 처음 부터 구매고객이 가져간 재고량은 제외하고 
insert into log_tb (store_id, qty, total_price, buyer) values (1, 5, 15000, 'ssar');
insert into log_tb (store_id, qty, total_price, buyer) values (1, 5, 15000, 'ssar');
insert into log_tb (store_id, qty, total_price, buyer) values (2, 5, 10000, 'cos');
