INSERT INTO add_services(services, services_allowance, food, food_allowance, entertainments, entertainments_allowance)
values('Ежедневная уборка номера, прачечная, химчистка','100','Ресторан "Лес", кафе "Океан", бар "Море", бар "Прибой"','100','Бассейн, сауна, бильярд, кинотеатр, аниматоры','400');
INSERT INTO add_services(services, services_allowance, food, food_allowance, entertainments, entertainments_allowance)
values('Ежедневная уборка номера, прачечная, химчистка','100','Ресторан "Лес", кафе "Океан", бар "Море"','70','Бассейн, сауна, бильярд, аниматоры','200');
INSERT INTO add_services(services, services_allowance, food, food_allowance, entertainments, entertainments_allowance)
values('Ежедневная уборка номера, прачечная','70','кафе "Океан", бар "Море"','50','Бассейн, сауна, бильярд','100');
INSERT INTO add_services(services, services_allowance, food, food_allowance, entertainments, entertainments_allowance)
values('Ежедневная уборка номера','50','бар "Море"','10','Cауна, бильярд','10');
INSERT INTO add_services(services, services_allowance, food, food_allowance, entertainments, entertainments_allowance)
values('Ежедневная уборка номера','50','бар "Море"','10','Cауна, бильярд','10');

INSERT INTO buildings(stars_number, floors_number, rooms_per_floor_number, rooms_number, building_min_price, id_add_services)
values('5','5','10','50','5000','1');
INSERT INTO buildings(stars_number, floors_number, rooms_per_floor_number, rooms_number, building_min_price, id_add_services)
values('4','5','10','50','3000','2');
INSERT INTO buildings(stars_number, floors_number, rooms_per_floor_number, rooms_number, building_min_price, id_add_services)
values('3','5','10','50','1000','3');
INSERT INTO buildings(stars_number, floors_number, rooms_per_floor_number, rooms_number, building_min_price, id_add_services)
values('2','5','10','50','500','4');
INSERT INTO buildings(stars_number, floors_number, rooms_per_floor_number, rooms_number, building_min_price, id_add_services)
values('2','5','10','50','500','5');


INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('5','1','200','300');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('5','2','200','300');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('4','2','200','300');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('3','3','200','300');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('3','2','200','300');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('2','4','200','300');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('1','3','200','300');

INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('5','2','100','200');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('4','3','100','200');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('4','1','100','200');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('3','3','100','200');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('2','4','100','200');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('1','2','100','200');

INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('5','3','100','100');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('5','2','100','100');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('4','1','100','100');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('3','3','100','100');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('2','2','100','100');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('1','1','100','100');

INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('5','5','50','60');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('4','4','50','60');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('3','3','50','60');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('2','2','50','60');
INSERT INTO room_types(floor, people_number, service_cost_per_day, min_price
values('1','3','50','60');



INSERT INTO rooms(id_building, id_room_types) values('1','1');
INSERT INTO rooms(id_building, id_room_types) values('1','1');
INSERT INTO rooms(id_building, id_room_types) values('1','1');
INSERT INTO rooms(id_building, id_room_types) values('1','1');
INSERT INTO rooms(id_building, id_room_types) values('1','1');
INSERT INTO rooms(id_building, id_room_types) values('1','2');
INSERT INTO rooms(id_building, id_room_types) values('1','2');
INSERT INTO rooms(id_building, id_room_types) values('1','2');
INSERT INTO rooms(id_building, id_room_types) values('1','2');
INSERT INTO rooms(id_building, id_room_types) values('1','2');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','3');
INSERT INTO rooms(id_building, id_room_types) values('1','4');
INSERT INTO rooms(id_building, id_room_types) values('1','4');
INSERT INTO rooms(id_building, id_room_types) values('1','4');
INSERT INTO rooms(id_building, id_room_types) values('1','4');
INSERT INTO rooms(id_building, id_room_types) values('1','4');
INSERT INTO rooms(id_building, id_room_types) values('1','5');
INSERT INTO rooms(id_building, id_room_types) values('1','5');
INSERT INTO rooms(id_building, id_room_types) values('1','5');
INSERT INTO rooms(id_building, id_room_types) values('1','5');
INSERT INTO rooms(id_building, id_room_types) values('1','5');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','6');
INSERT INTO rooms(id_building, id_room_types) values('1','7');
INSERT INTO rooms(id_building, id_room_types) values('1','7');
INSERT INTO rooms(id_building, id_room_types) values('1','7');
INSERT INTO rooms(id_building, id_room_types) values('1','7');
INSERT INTO rooms(id_building, id_room_types) values('1','7');
INSERT INTO rooms(id_building, id_room_types) values('1','7');
INSERT INTO rooms(id_building, id_room_types) values('1','7');
INSERT INTO rooms(id_building, id_room_types) values('1','7');
INSERT INTO rooms(id_building, id_room_types) values('1','7');
INSERT INTO rooms(id_building, id_room_types) values('1','7');

INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','8');
INSERT INTO rooms(id_building, id_room_types) values('2','9');
INSERT INTO rooms(id_building, id_room_types) values('2','9');
INSERT INTO rooms(id_building, id_room_types) values('2','9');
INSERT INTO rooms(id_building, id_room_types) values('2','9');
INSERT INTO rooms(id_building, id_room_types) values('2','9');
INSERT INTO rooms(id_building, id_room_types) values('2','10');
INSERT INTO rooms(id_building, id_room_types) values('2','10');
INSERT INTO rooms(id_building, id_room_types) values('2','10');
INSERT INTO rooms(id_building, id_room_types) values('2','10');
INSERT INTO rooms(id_building, id_room_types) values('2','10');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','11');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','12');
INSERT INTO rooms(id_building, id_room_types) values('2','13');
INSERT INTO rooms(id_building, id_room_types) values('2','13');
INSERT INTO rooms(id_building, id_room_types) values('2','13');
INSERT INTO rooms(id_building, id_room_types) values('2','13');
INSERT INTO rooms(id_building, id_room_types) values('2','13');
INSERT INTO rooms(id_building, id_room_types) values('2','13');
INSERT INTO rooms(id_building, id_room_types) values('2','13');
INSERT INTO rooms(id_building, id_room_types) values('2','13');
INSERT INTO rooms(id_building, id_room_types) values('2','13');
INSERT INTO rooms(id_building, id_room_types) values('2','13');

INSERT INTO rooms(id_building, id_room_types) values('3','14');
INSERT INTO rooms(id_building, id_room_types) values('3','14');
INSERT INTO rooms(id_building, id_room_types) values('3','14');
INSERT INTO rooms(id_building, id_room_types) values('3','14');
INSERT INTO rooms(id_building, id_room_types) values('3','14');
INSERT INTO rooms(id_building, id_room_types) values('3','15');
INSERT INTO rooms(id_building, id_room_types) values('3','15');
INSERT INTO rooms(id_building, id_room_types) values('3','15');
INSERT INTO rooms(id_building, id_room_types) values('3','15');
INSERT INTO rooms(id_building, id_room_types) values('3','15');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','16');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','17');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','18');
INSERT INTO rooms(id_building, id_room_types) values('3','19');
INSERT INTO rooms(id_building, id_room_types) values('3','19');
INSERT INTO rooms(id_building, id_room_types) values('3','19');
INSERT INTO rooms(id_building, id_room_types) values('3','19');
INSERT INTO rooms(id_building, id_room_types) values('3','19');
INSERT INTO rooms(id_building, id_room_types) values('3','19');
INSERT INTO rooms(id_building, id_room_types) values('3','19');
INSERT INTO rooms(id_building, id_room_types) values('3','19');
INSERT INTO rooms(id_building, id_room_types) values('3','19');
INSERT INTO rooms(id_building, id_room_types) values('3','19');

INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','20');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','21');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','22');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','23');
INSERT INTO rooms(id_building, id_room_types) values('4','24');
INSERT INTO rooms(id_building, id_room_types) values('4','24');
INSERT INTO rooms(id_building, id_room_types) values('4','24');
INSERT INTO rooms(id_building, id_room_types) values('4','24');
INSERT INTO rooms(id_building, id_room_types) values('4','24');
INSERT INTO rooms(id_building, id_room_types) values('4','24');
INSERT INTO rooms(id_building, id_room_types) values('4','24');
INSERT INTO rooms(id_building, id_room_types) values('4','24');
INSERT INTO rooms(id_building, id_room_types) values('4','24');
INSERT INTO rooms(id_building, id_room_types) values('4','24');

INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','20');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','21');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','22');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','23');
INSERT INTO rooms(id_building, id_room_types) values('5','24');
INSERT INTO rooms(id_building, id_room_types) values('5','24');
INSERT INTO rooms(id_building, id_room_types) values('5','24');
INSERT INTO rooms(id_building, id_room_types) values('5','24');
INSERT INTO rooms(id_building, id_room_types) values('5','24');
INSERT INTO rooms(id_building, id_room_types) values('5','24');
INSERT INTO rooms(id_building, id_room_types) values('5','24');
INSERT INTO rooms(id_building, id_room_types) values('5','24');
INSERT INTO rooms(id_building, id_room_types) values('5','24');
INSERT INTO rooms(id_building, id_room_types) values('5','24');


INSERT INTO partners(information, cooperation_date_start, cooperation_date_end)
values('ООО "Калибри"','2007-10-20','2021-10-20');
INSERT INTO partners(information, cooperation_date_start, cooperation_date_end)
values('ИП "Иванов"','2019-3-5','2022-5-6');
INSERT INTO partners(information, cooperation_date_start, cooperation_date_end)
values('ООО "Вокруг света"','2015-4-7','2023-10-11');
INSERT INTO partners(information, cooperation_date_start, cooperation_date_end)
values('ТК "Каникулы"','2010-11-4','2025-7-18');
INSERT INTO partners(information, cooperation_date_start, cooperation_date_end)
values('ООО "Море"','2011-4-9','2030-4-22');

INSERT INTO reservations(res_partner, stars_number, floor_number, res_date_start, res_date_end, discount)
values('1','5','5','2019-3-4','2019-3-24','40');
INSERT INTO reservations(res_partner, stars_number, floor_number, res_date_start, res_date_end, discount)
values('2','2','3','2020-6-10','2020-6-27','20');
INSERT INTO reservations(res_partner, stars_number, floor_number, res_date_start, res_date_end, discount)
values('3','3','4','2020-10-1','2020-11-1','10');
INSERT INTO reservations(res_partner, stars_number, floor_number, res_date_start, res_date_end, discount)
values('4','2','2','2019-1-7','2019-1-24','12');
INSERT INTO reservations(res_partner, stars_number, floor_number, res_date_start, res_date_end, discount)
values('5','4','1','2020-9-4','2020-9-24','18');

INSERT INTO res_rooms values('1','1');
INSERT INTO res_rooms values('2','1');
INSERT INTO res_rooms values('3','1');
INSERT INTO res_rooms values('4','1');

INSERT INTO res_rooms values('171','2');
INSERT INTO res_rooms values('172','2');

INSERT INTO res_rooms values('111','3');
INSERT INTO res_rooms values('112','3');
INSERT INTO res_rooms values('113','3');
INSERT INTO res_rooms values('114','3');

INSERT INTO res_rooms values('231','4');
INSERT INTO res_rooms values('232','4');

INSERT INTO res_rooms values('141','5');
INSERT INTO res_rooms values('142','5');
INSERT INTO res_rooms values('143','5');

INSERT INTO clients(fio, phone_number) values('Иванов Николай Алексеевич','89991234455');
INSERT INTO clients(fio, phone_number) values('Алексеев Владимир Юрьевич','89235467788');
INSERT INTO clients(fio, phone_number) values('Кравцова Василиса Ивановна','89342221145');
INSERT INTO clients(fio, phone_number) values('Краснова Юлия Юрьевна','89456667894');
INSERT INTO clients(fio, phone_number) values('Белых Кирилл Андреевич','89452346677');
INSERT INTO clients(fio, phone_number) values('Белых Татьяна Викторовна','89452340077');
INSERT INTO clients(fio, phone_number) values('Шестаков Андрей Николаевич','83456667387');
INSERT INTO clients(fio, phone_number) values('Вольнов Владислав Констатинович','89483456378');
INSERT INTO clients(fio, phone_number) values('Красных Валерия Дмитриевна','89456723123');
INSERT INTO clients(fio, phone_number) values('Елисеева Мария Викторовна','89453672123');
INSERT INTO clients(fio, phone_number) values('Дорогих Борис Павлович','89345672908');
INSERT INTO clients(fio, phone_number) values('Павлов Владимир Александрович','89054346789');
INSERT INTO clients(fio, phone_number) values('Павлова Алена Владиславовна','89345678923');
INSERT INTO clients(fio, phone_number) values('Павлов Константин Владимирович','89435671234');
INSERT INTO clients(fio, phone_number) values('Ангархаева Евгения Олеговна','89456783456');
INSERT INTO clients(fio, phone_number) values('Аксенова Кристина Викторовна','89345678234');
INSERT INTO clients(fio, phone_number) values('Куприянов Роман Дмитриевич','89431235647');
INSERT INTO clients(fio, phone_number) values('Егоров Павел Владмириович','89345678345');
INSERT INTO clients(fio, phone_number) values('Егорова Маргарита Александровна','89435671243');
INSERT INTO clients(fio, phone_number) values('Егорова Юлия Александровна','89430671243');

INSERT INTO clients(fio, phone_number) values('','');
INSERT INTO clients(fio, phone_number) values('','');

INSERT INTO res_clients values('1','1');
INSERT INTO res_clients values('2','1');
INSERT INTO res_clients values('3','1');
INSERT INTO res_clients values('4','1');
INSERT INTO res_clients values('18','2');
INSERT INTO res_clients values('19','2');
INSERT INTO res_clients values('20','2');
INSERT INTO res_clients values('12','2');
INSERT INTO res_clients values('13','2');
INSERT INTO res_clients values('14','2');
INSERT INTO res_clients values('7','3');
INSERT INTO res_clients values('8','3');
INSERT INTO res_clients values('9','3');
INSERT INTO res_clients values('10','3');
INSERT INTO res_clients values('5','4');
INSERT INTO res_clients values('6','4');
INSERT INTO res_clients values('11','4');
INSERT INTO res_clients values('15','4');
INSERT INTO res_clients values('16','5');
INSERT INTO res_clients values('17','5');
INSERT INTO res_clients values('3','5');

INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('1','1','2019-3-4','2019-3-24','1');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('2','2','2019-3-4','2019-3-24','1');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('3','3','2019-3-4','2019-3-24','1');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('4','4','2019-3-4','2019-3-24','1');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('18','171','2020-6-10','2020-6-27','2');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('19','171','2020-6-10','2020-6-27','2');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('20','171','2020-6-10','2020-6-27','2');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('12','172','2020-6-10','2020-6-27','2');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('13','172','2020-6-10','2020-6-27','2');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('14','172','2020-6-10','2020-6-27','2');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('7','111','2020-10-1','2020-11-1','3');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('8','112','2020-10-1','2020-11-1','3');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('9','113','2020-10-1','2020-11-1','3');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('10','114','2020-10-1','2020-11-1','3');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('5','231','2019-1-7','2019-1-24','4');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('6','231','2019-1-7','2019-1-24','4');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('11','232','2019-1-7','2019-1-24','4');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('15','232','2019-1-7','2019-1-24','4');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('16','141','2020-9-4','2020-9-24','5');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('17','142','2020-9-4','2020-9-24','5');
INSERT INTO contracts(id_client, id_room, living_start, living_end, id_reservation) values('3','143','2020-9-4','2020-9-24','5');


INSERT INTO reviews values('1','1','4','Все норм');
INSERT INTO reviews values('18','171','5','Шикарно');
INSERT INTO reviews values('5','231','3','Плохо убрали номер');
INSERT INTO reviews values('3','3','5','Стоит своих денег');
INSERT INTO reviews values('142','17','2','Ужасно');


INSERT INTO bills(id_contract, bill) values('1','5900');
INSERT INTO bills(id_contract, bill) values('2','5900');
INSERT INTO bills(id_contract, bill) values('3','5900');
INSERT INTO bills(id_contract, bill) values('4','5900');
INSERT INTO bills(id_contract, bill) values('5','630');
INSERT INTO bills(id_contract, bill) values('6','630');
INSERT INTO bills(id_contract, bill) values('7','630');
INSERT INTO bills(id_contract, bill) values('8','630');
INSERT INTO bills(id_contract, bill) values('9','630');
INSERT INTO bills(id_contract, bill) values('10','630');
INSERT INTO bills(id_contract, bill) values('11','1320');
INSERT INTO bills(id_contract, bill) values('12','1320');
INSERT INTO bills(id_contract, bill) values('13','1320');
INSERT INTO bills(id_contract, bill) values('14','1320');
INSERT INTO bills(id_contract, bill) values('15','630');
INSERT INTO bills(id_contract, bill) values('16','630');
INSERT INTO bills(id_contract, bill) values('17','630');
INSERT INTO bills(id_contract, bill) values('18','630');
INSERT INTO bills(id_contract, bill) values('19','1320');
INSERT INTO bills(id_contract, bill) values('20','1320');
INSERT INTO bills(id_contract, bill) values('21','1320');


INSERT INTO added_services(bill_number, add_service, service_bill) values('1','Химчистка','5');
INSERT INTO added_services(bill_number, add_service, service_bill) values('1','Кинотеатр','8');
INSERT INTO added_services(bill_number, add_service, service_bill) values('2','Химчистка','5');
INSERT INTO added_services(bill_number, add_service, service_bill) values('2','Ресторан "Лес"','50');
INSERT INTO added_services(bill_number, add_service, service_bill) values('3','Бар "Прибой"','12');
