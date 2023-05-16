use furama;
insert into customer_type 
values 
  (1, 'Diamond'), 
  (2, 'Platinium'), 
  (3, 'Gold'), 
  (4, 'Silver'), 
  (5, 'Member');
  
insert into customer (customer_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id,delete_status)
values  
  (
    1, 'Nguyễn Thị Hào', '1970-11-07', 
    0, '643431213', '0945423362', 'thihao07@gmail.com', 
    '23 Nguyễn Hoàng, Đà Nẵng', 
    5,0
  ),
  (
    2, 'Phạm Xuân Diệu', '1992-08-08', 
    1, '865342123', '0954333333', 'xuandieu92@gmail.com', 
    'K77/22 Thái Phiên, Quảng Trị', 
    3,0
  ), 
  (
    3, 'Trương Đình Nghệ', '1990-02-27', 
    1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 
    'K323/12 Ông Ích Khiêm, Vinh', 
    1,0
  ), 
  (
    4, 'Dương Văn Quan', '1981-07-08', 
    1, '543432111', '0490039241', 'duongquan@gmail.com', 
    'K453/12 Lê Lợi, Đà Nẵng', 
    1,0
  ), 
  (
    5, 'Hoàng Trần Nhi Nhi', '1995-12-09', 
    0, '795453345', '0312345678', 'nhinhi123@gmail.com', 
    '224 Lý Thái Tổ, Gia Lai', 
    4,0
  ), 
  (
    6, 'Tôn Nữ Mộc Châu', '2005-12-06', 
    0, '732434215', '0988888844', 'tonnuchau@gmail.com', 
    '37 Yên Thế, Đà Nẵng', 4,0
  ), 
  (
    7, 'Nguyễn Mỹ Kim', '1984-04-08', 
    0, '856453123', '0912345698', 'kimcuong84@gmail.com', 
    'K123/45 Lê Lợi, Hồ Chí Minh', 
    1,0
  ), 
  (
    8, 'Nguyễn Thị Hào', '1999-04-08', 
    0, '965656433', '0763212345', 'haohao99@gmail.com', 
    '55 Nguyễn Văn Linh, Kon Tum', 
    3,0
  ), 
  (
    9, 'Trần Đại Danh', '1994-07-01', 
    1, '432341235', '0643343433', 'danhhai99@gmail.com', 
    '24 Lý Thường Kiệt, Quảng Ngãi', 
    1,0
  ), 
  (
    10, 'Nguyễn Tâm Đắc', '1989-07-01', 
    1, '344343432', '0987654321', 'dactam@gmail.com', 
    '22 Ngô Quyền, Đà Nẵng', 
    2,0
  );
  insert into facility_type 
values 
  (1, 'year'), 
  (2, 'month'), 
  (3, 'day'), 
  (4, 'hour');
  
insert into rent_type 
values 
  (1, 'Villa'), 
  (2, 'House'), 
  (3, 'Room');
  
insert into facility (facility_id,facility_name,facility_area,rent_cost,max_people,standard_room,
description_other_convenience,pool_area,number_of_floors,facility_free,rent_type_id,facility_type_id,delete_status)
values 
  (
    1, 'Villa Beach Front', 25000, 1000000, 
    10, 'vip', 'Có hồ bơi', 500, 4, 
    null, 3, 1,0
  ), 
  (
    2, 'House Princess 01', 14000, 5000000, 
    7, 'vip', 'Có thêm bếp nướng', 
    0, 3, null, 2, 2,0
  ), 
  (
    3, 'Room Twin 01', 5000, 1000000, 2, 
    'normal', 'Có tivi', 0, 0, 
    '1 Xe máy, 1 Xe đạp', 3, 3,0
  ), 
  (
    4, 'Villa No Beach Front', 22000, 
    9000000, 8, 'normal', 'Có hồ bơi', 
    300, 3, null, 3, 1,0
  ), 
  (
    5, 'House Princess 02', 10000, 4000000, 
    5, 'normal', 'Có thêm bếp nướng', 
    0, 2, null, 3, 2,0
  ), 
  (
    6, 'Room Twin 02', 3000, 900000, 2, 
    'normal', 'Có tivi', 0, 0, 
    '1 Xe máy', 2, 3,0employee
  );
  
  insert into position 
values 
  (1, 'Quản Lý'), 
  (2, 'Nhân Viên');
  
  insert into education_degree 
values 
  (1, 'Trung Cấp'), 
  (2, 'Cao Đẳng'), 
  (3, 'Đại Học'), 
  (4, 'Sau Đại Học');
  
insert into divisions
values 
  (1, 'Sale-Marketing'), 
  (2, 'Hành chính'), 
  (3, 'Phục vụ'), 
  (4, 'Quản lý');
  
 INSERT INTO employee (employee_id, `employee_name`, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id,delete_status) VALUES
	('1', 'Nguyễn Văn An', '1970-11-07', '456231786', '10000000', '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', '1', '3', '1',0),
	('2', 'Lê Văn Bình', '1997-04-09', '654231234', '7000000', '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', '1', '2', '2',0),
	('3', 'Hồ Thị Yến', '1995-12-12', '999231723', '14000000', '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', '1', '3', '2',0),
	('4', 'Võ Công Toản', '1980-04-04', '123231365', '17000000', '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', '1', '4', '4',0),
	('5', 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', '6000000', '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', '2', '1', '1',0),
	('6', 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', '7000000', '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', '2', '2', '3',0),
	('7', 'Nguyễn Hữu Hà', '1993-01-01', '534323231', '8000000', '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', '2', '3', '2',0),
	('8', 'Nguyễn Hà Đông', '1989-09-03', '234414123', '9000000', '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', '2', '4', '4',0),
	('9', 'Tòng Hoang', '1982-09-03', '256781231', '6000000', '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', '2', '4', '4',0),
	('10', 'Nguyễn Công Đạo', '1994-01-08', '755434343', '8000000', '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', '2', '3', '2',0);
    
       INSERT INTO attach_facility (attach_facility_id, `attach_facility_name`, attach_facility_cost, attach_facility_unit, `attach_facility_status`) VALUES
	('1', 'Karaoke', '10000', 'giờ', 'tiện nghi, hiện tại'),
	('2', 'Thuê xe máy', '10000', 'chiếc', 'hỏng 1 xcontracte'),
	('3', 'Thuê xe đạp', '20000', 'chiếc', 'tốt'),
	('4', 'Buffet buổi sáng', '15000', 'suất', 'đầy đủ đồ ăn, tráng miệng'),
	('5', 'Buffet buổi trưa', '90000', 'suất', 'đầy đủ đồ ăn, tráng miệng'),
	('6', 'Buffet buổi tối', '16000', 'suất', 'đầy đủ đồ ăn, tráng miệng');
    INSERT INTO contract (contract_id, start_date, end_date, deposit, employee_id, customer_id, facility_id,delete_status) VALUES
	('1', '2020-12-08', '2020-12-08', '0', '3', '1', '3',0),
	('2', '2020-07-14', '2020-07-21', '200000', '7', '3', '1',0),
	('3', '2021-03-15', '2021-03-17', '50000', '3', '4', '2',0),
	('4', '2021-01-14', '2021-01-18', '100000', '7', '5', '5',0),
	('5', '2021-07-14', '2021-07-15', '0', '7', '2', '6',0),
	('6', '2021-06-01', '2021-06-03', '0', '7', '7', '6',0),
	('7', '2021-09-02', '2021-09-05', '100000', '7', '4', '4',0),
	('8', '2021-06-17', '2021-06-18', '150000', '3', '4', '1',0),
	('9', '2020-11-19', '2020-11-19', '0', '3', '4', '3',0),
	('10', '2021-04-12', '2021-04-14', '0', '10', '3', '5',0),
	('11', '2021-04-25', '2021-04-25', '0', '2', '2', '1',0),
	('12', '2021-05-25', '2021-05-27', '0', '7', '10', '1',0);
    INSERT INTO contract_detail (contract_id, attach_facility_id, quantity) VALUES
	(2, 2, 32),
	(1, 3, 32),
	(2, 4, 32);
     select * from  contract c where c.contract_id=1;
   
 
 
 select c.contract_id as contractId, c.start_date as startDate,c.end_date as endDate, c.deposit as deposit, f.facility_name as facilityName,
 e.employee_name as employeeName, ct.customer_name as customerName,f.rent_cost + c.deposit + 
sum(ifnull(cd.quantity, 0) * ifnull(af.attach_facility_cost, 0)) as totalMoney
 from contract c 
left join facility f on f.facility_id=c.facility_id
left join employee e on e.employee_id=c.employee_id
left join customer ct on ct.customer_id=c.customer_id
left join contract_detail cd on cd.contract_id=c.contract_id
left join attach_facility af on cd.attach_facility_id=af.attach_facility_id
where c.delete_status = false 
group by c.contract_id;






--     
--  select contract.contract_id as contractId, contract.start_date as startDate, " +
--             "contract.end_date as endDate, contract.deposit as deposit, facility.facility_name as facilityName, " +
--             "employee.employee_name as employeeName, customer.customer_name as customerName, " +
--             "(facility.rent_cost + contract.deposit + " +
--             "sum(ifnull(contract_detail.quantity, 0) * ifnull(attach_facility.attach_facility_cost, 0))) " +
--             "as totalMoney " +
--             "from contract " +
--             "left join facility on contract.facility_id = facility.facility_id " +
--             "left join employee on contract.employee_id = employee.employee_id " +
--             "left join customer on contract.customer_id = customer.customer_id " +
--             "left join contract_detail on contract_detail.contract_id = contract.contract_id " +
--             "left join attach_facility on attach_facility.attach_facility_id = contract_detail.attach_facility_id " +
--             "where contract.delete_status = false " +
--             "group by contract.contract_id;",



            
		
