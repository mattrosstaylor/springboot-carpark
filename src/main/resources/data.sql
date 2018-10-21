insert into driver (name, address, phone_number, date_of_birth) values
  ("Matt R Taylor", "Cornwall, UK", "0525 843713", str_to_date("October 16 1983", "%M %d %Y")),
  ("Peachie Pie", "Henan, China", "0525 134355", str_to_date("November 10 1988", "%M %d %Y")),
  ("Annie Xu", "Henan, China", "0525 962541", str_to_date("October 28 2017", "%M %d %Y"))
;

insert into vehicle(dtype, registration, colour, model) values
  ("car", "E4FA76", "Black", "Mini Cooper"),
  ("bus", "B1PO22", "White", "Lancia Spuddy"),
  ("motorcycle", "J9NT05", "Red", "Toyota 9000"),
  ("car", "X3TE12", "Yellow", "Lamborghini Diablo")
;

insert into driver_vehicle(driver_id, vehicle_id) values
  (1,1),
  (1,2),
  (2,1),
  (2,3)
;