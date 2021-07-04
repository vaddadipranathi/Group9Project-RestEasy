create database onlineFoodOrderApp;
use onlineFoodOrderApp;

show tables;
desc cart;
desc menu;
select * from customer;
select * from address;
insert into restuarant(restuarant_id,restuarant_location,restuarant_name) values (1,'bangalore','Adigas');
insert into restuarant(restuarant_id,restuarant_location,restuarant_name) values (2,'Hyderabad','Rotighar');
insert into restuarant(restuarant_id,restuarant_location,restuarant_name) values (3,'Chennai','PunjabiRasoi');
insert into restuarant(restuarant_id,restuarant_location,restuarant_name) values (4,'Bangalore','Udipi');

insert into menu values (2,'Veg','Idly',20,"https://b.zmtcdn.com/data/pictures/3/18625483/456c378717b14f21b255e3a35bdaf4ed_o2_featured_v2.jpg?output-format=webp",1,1);
insert into menu values (6,'Veg','Dosa',150,"https://b.zmtcdn.com/data/pictures/7/18356437/d857fbf2ef1b02d7f1ee6a48c72aa7fa_o2_featured_v2.jpg?output-format=webp",1,1);
insert into menu values (3,'Veg','Lemon Rice',80,"https://b.zmtcdn.com/data/pictures/0/92320/06cce18e7ea33d8d63111e087c2df607_o2_featured_v2.jpg",1,1);
insert into menu values (4,'Veg','Map-Puva',200,"https://th.bing.com/th/id/OIP.ky2nuRP_08o2W3Kf95WXjQHaEP?w=286&h=180&c=7&o=5&dpr=1.5&pid=1.7",1,1);
insert into menu values (5,'Non-Veg','Chicken Curry',180,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSL1RWLyFNq2OOD50RDz7vvCJwLofVVKdWmmg&usqp=CAU",1,1);
insert into menu values (1,'Veg','Veg Meal',250,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrrrGYfofVvEg2tDnc8bbfypfIy9PZW20Ebw&usqp=CAU",1,1);

insert into menu values (7,'Veg','Chapathi',20,"https://b.zmtcdn.com/data/pictures/1/56791/0cdce63fc9633eb489b4568c6a7e1917_o2_featured_v2.jpg",1,2);
insert into menu values (8,'Veg','Dosa',150,"https://th.bing.com/th/id/OIP.D07lLEIGNcpnVKyKnLNH2wHaFu?w=223&h=180&c=7&o=5&dpr=1.5&pid=1.7",1,2);
insert into menu values (9,'Veg','Roti',100,"https://th.bing.com/th/id/OIP.iLERWmqSRk7BIiMAGc-fdwHaFb?w=235&h=180&c=7&o=5&dpr=1.5&pid=1.7",1,2);
insert into menu values (10,'Veg','Thali',200,"https://b.zmtcdn.com/data/pictures/1/19347911/9c4db4192af5c23247a9e284e8567a91_o2_featured_v2.jpg?output-format=webp",1,2);
insert into menu values (11,'Non-Veg','Chicken LegPieces',180,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTJ2iIh0QREIph4i7x8n7oMVZ07LPSXepXqw&usqp=CAU",1,2);
insert into menu values (12,'Non-Veg','Chicken Thali',100,"https://th.bing.com/th/id/OIP.ePm7miG460ItzYr0P-9QnAHaFk?w=208&h=180&c=7&o=5&dpr=1.5&pid=1.7",1,2);

 insert into menu values (13,'Veg','Noodles',50,"https://b.zmtcdn.com/data/pictures/6/19450636/d899d7a0004f048709f38be688444d24_o2_featured_v2.jpg",1,3);
 insert into menu values (14,'Veg','Munchooria',110,"https://b.zmtcdn.com/data/dish_photos/aa6/7048c7ddf05bebb2f374f5f1ec020aa6.jpg?output-format=webp",1,3);
 insert into menu values (15,'Veg','Pasta',100,"https://th.bing.com/th/id/OIP.86Jo_Cr5OOg9wZJgIKeZagHaEK?w=322&h=181&c=7&o=5&dpr=1.5&pid=1.7",1,3);
 insert into menu values (16,'Veg','Mil choclate Shake',20,"https://th.bing.com/th/id/OIP.nNGyFzKJNuik4ZCevPM26wHaGj?w=227&h=201&c=7&o=5&dpr=1.5&pid=1.7",1,3);
 insert into menu values (17,'Veg','Oreo Milk Shake',170,"https://b.zmtcdn.com/data/dish_photos/027/42a48d6a2c34265cbdd307af23d38027.jpg",1,3);
 insert into menu values (18,'Non-Veg','Grilled Fish',30,"https://th.bing.com/th/id/OIP.TRCGKuWtLoW6r0HF9eEbBwHaLH?w=133&h=196&c=7&o=5&dpr=1.5&pid=1.7",1,3);
 
 insert into menu values (19,'Veg','Roti',75,"https://images.eatthismuch.com/site_media/img/476581_Iqr_aaa_2eb16a2a-a818-466a-8a0e-72f7b1bdc4a1.jpg",1,4);
 insert into menu values (20,'Veg','Puri',140,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZqwwjCRa0XtiXKKWFm7J-WInDY9TRXUCByg&usqp=CAU",1,4);
 insert into menu values (21,'Veg','Panner Pizza',200,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQm6Yw0YiSObpPameZouoFYjzOP3NDUhCs4PA&usqp=CAU",1,4);
 insert into menu values (22,'Non-Veg','Egg Birayani',190,"https://b.zmtcdn.com/data/dish_photos/c2a/197cc7a23f09f28440049de835d26c2a.jpg",1,4);
 insert into menu values (23,'Non-Veg','Chicken Munchoorian',250,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYdHE7ZVPBvzlaL_yIN3bnseDWfiazynCp1g&usqp=CAU",1,4);
 insert into menu values (24,'Non-Veg','Egg Burji',80,"https://c.ndtvimg.com/2019-01/js2vgrc8_egg-bhurji-for-weight-loss_625x300_03_January_19.jpg",1,4);

 select * from customer;
select * from address;
 select * from cart;

 select * from order_details;
