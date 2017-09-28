SET REFERENTIAL_INTEGRITY FALSE;

INSERT INTO AUTHORITIES (AUTHORITIESID, AUTHORITY, USERNAME)
VALUES
  ('1', 'ROLE_ADMIN', 'admin'),
  ('2', 'ROLE_USER', 'admin'),
  ('3', 'ROLE_USER', 'customer'),
  ('4', 'ROLE_USER', 'user1'),
  ('5', 'ROLE_USER', 'user2'),
  ('6', 'ROLE_USER', 'user3'),
  ('7', 'ROLE_USER', 'user4'),
  ('8', 'ROLE_USER', 'user5');

INSERT INTO BILLINGADDRESS (BILLINGADDRESSID, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, COUNTRY, PINCODE, CUSTOMER_CUSTOMERID)
VALUES
  ('1', 'Address Line 1', 'Address Line 2', 'Delhi', 'Delhi', 'India', '110092', '1'),
  ('2', 'Address2 Line 1', 'Address2 Line 2', 'Delhi', 'Delhi', 'India', '110092', '2');

INSERT INTO CART (CARTID, GRANDTOTAL, CUSTOMERID)
VALUES
  ('1', '0.0', '1'),
  ('2', '65489.0', '2'),
  ('3', '0', '2'),
  ('4', '0', '3'),
  ('5', '0', '4'),
  ('6', '0', '5'),
  ('7', '0', '6'),
  ('8', '0', '7');

INSERT INTO CARTITEM (CARTITEMID, QUANTITY, TOTALPRICE, CARTID, PRODUCTID)
VALUES
  ('1', '1', '48490.0', '2', '6'),
  ('2', '1', '16999.0', '2', '4');

INSERT INTO CUSTOMER (CUSTOMERID, CUSTOMERNAME, CUSTOMEREMAIL, CUSTOMERPHONE, ENABLED, USERNAME, PASSWORD, CARTID, BILLINGADDRESSID, SHIPPINGADDRESSID, CREATIONDATE, SEARCHID)
VALUES
  ('1', 'Administrator', 'admin@gmail.com', '9999999999', 'TRUE', 'admin',
        '$2a$10$PFT6NaqBAxez7LP08QfD6uVhsDYI5YRGvd0PggakZ9j.TB1ZqwLpS', '1', '1', '1', CURRENT_TIMESTAMP(), '1'),
  ('2', 'customer name', 'customer@gmail.com', '9999999999', 'TRUE', 'customer',
        '$2a$10$Kq7R3ciae25xpYcfS/vFYenbkYBgp6Y6UVPDO3tcEuhUssjJKjrVG', '3', '2', '2', CURRENT_TIMESTAMP(), '3'),
  ('3', 'User1', 'user1@gmail.com', '9999999999', 'TRUE', 'user1',
        '$2a$10$43hZQN6X9uiXgUhA48xwn.K07kQJVIh8sSGabaYrAjG4QGIeRZULO', '4', '1', '1', CURRENT_TIMESTAMP(), '4'),
  ('4', 'User2', 'user2@gmail.com', '9999999999', 'TRUE', 'user2',
        '$2a$10$yRNcWzPxBQFHELYT8URGl.clzWfEqtiD3hfcbARbpoXoSBwzJoUQy', '5', '2', '2', CURRENT_TIMESTAMP(), '5'),
  ('5', 'User3', 'user3@gmail.com', '9999999999', 'TRUE', 'user3',
        '$2a$10$LVRXNXk.8V8kcJQrsmmxue.pNc5eIr9ltkgLqVH2fKkj0B9ljl9uq', '6', '1', '1', CURRENT_TIMESTAMP(), '6'),
  ('6', 'User4', 'user4@gmail.com', '9999999999', 'TRUE', 'user4',
        '$2a$10$ofAetkxtiCif/YzjQavmbuDTnoPnClHVTIewxDcNs7e.lejBLOTPW', '7', '2', '2', CURRENT_TIMESTAMP(), '7'),
  ('7', 'User5', 'user5@gmail.com', '9999999999', 'TRUE', 'user5',
        '$2a$10$kne0TZkvx48P7oFrqtOGj.fARCJ4Gt8khnkqLpiC3nJUXd1F/Wja2', '8', '1', '1', CURRENT_TIMESTAMP(), '8');


INSERT INTO CUSTOMERORDER (CUSTOMERORDERID, CREATIONDATE, STATUS, BILLINGADDRESSID, CARTID, CUSTOMERID, SHIPPINGADDRESSID)
VALUES
  ('1', CURRENT_TIMESTAMP(), 'Active', '2', '2', '2', '2');


INSERT INTO SHIPPINGADDRESS (SHIPPINGADDRESSID, ADDRESSLINE1, ADDRESSLINE2, CITY, STATE, COUNTRY, PINCODE, CUSTOMER_CUSTOMERID)
VALUES
  ('1', 'Address Line 1', 'Address Line 2', 'Delhi', 'Delhi', 'India', '110092', '1'),
  ('2', 'Address2 Line 1', 'Address2 Line 2', 'Delhi', 'Delhi', 'India', '110092', '2');

INSERT INTO SMARTSEARCH (SEARCHID, AGE, CONSUMER, GENDER, RELATIONSHIP, SMARTSEARCHINPUT, CARTID, CUSTOMERID, BUDGET)
VALUES
  ('1', '0', '', '', '', '', '1', '1', '0'),
  ('2', '30', 'Gift,', 'Male', 'Friend', 'birthday gift', '2', '2', '25000'),
  ('3', '0', '', '', '', '', '3', '2', '0'),
  ('4', '0', '', '', '', '', '4', '3', '0'),
  ('5', '0', '', '', '', '', '5', '4', '0'),
  ('6', '0', '', '', '', '', '6', '5', '0'),
  ('7', '0', '', '', '', '', '7', '6', '0'),
  ('8', '0', '', '', '', '', '8', '7', '0');


INSERT INTO USERS (USERID, CUSTOMERID, ENABLED, USERNAME, PASSWORD)
VALUES
  ('1', '1', 'TRUE', 'admin', '$2a$10$PFT6NaqBAxez7LP08QfD6uVhsDYI5YRGvd0PggakZ9j.TB1ZqwLpS'),
  ('2', '2', 'TRUE', 'customer', '$2a$10$Kq7R3ciae25xpYcfS/vFYenbkYBgp6Y6UVPDO3tcEuhUssjJKjrVG'),
  ('3', '3', 'TRUE', 'user1', '$2a$10$43hZQN6X9uiXgUhA48xwn.K07kQJVIh8sSGabaYrAjG4QGIeRZULO'),
  ('4', '4', 'TRUE', 'user2', '$2a$10$yRNcWzPxBQFHELYT8URGl.clzWfEqtiD3hfcbARbpoXoSBwzJoUQy'),
  ('5', '5', 'TRUE', 'user3', '$2a$10$LVRXNXk.8V8kcJQrsmmxue.pNc5eIr9ltkgLqVH2fKkj0B9ljl9uq'),
  ('6', '6', 'TRUE', 'user4', '$2a$10$ofAetkxtiCif/YzjQavmbuDTnoPnClHVTIewxDcNs7e.lejBLOTPW'),
  ('7', '7', 'TRUE', 'user5', '$2a$10$kne0TZkvx48P7oFrqtOGj.fARCJ4Gt8khnkqLpiC3nJUXd1F/Wja2');

SET REFERENTIAL_INTEGRITY TRUE;

INSERT INTO PRODUCT (PRODUCTID, ASIN, PRODUCTNAME, PRODUCTCATEGORY, PRODUCTCONDITION, PRODUCTDESCRIPTION, PRODUCTMANUFACTURER, PRODUCTPRICE, PRODUCTSTATUS, UNITINSTOCK, PRODUCTIMAGEURL)
VALUES
  ('1', 'B073M8VF3R', 'Moto E4 Plus', 'Electronics', 'New',
        'Moto brings to you the E4 Plus - a smartphone that is powered by a long-lasting 5000 mAh battery. ' ||
        'Packed with a 13 MP rear camera and a 5 MP front camera, the Moto E4 Plus mobile helps you take flaunt-worthy photos. It runs on Android 7.1 Nougat, and features Google Assistant for a seamless user experience.',
        'Motorola', '9999', 'Active', '10', ''),
  ('2', 'B0745VHYZG', 'Redmi Note 4', 'Electronics', 'New',
        'Upgrade to the Redmi Note 4 and experience power like never before. The Redmi Note 4 mobile offers high-speed performance along with a long battery life.',
        'Redmi', '12999', 'Active', '10', ''),
  ('3', 'B01M7MAM9Y', 'Samsung Galaxy On Nxt', 'Electronics', 'New',
        'Whether you take into account its sleek looks or its innovative features, the Samsung Galaxy On Nxt mobile has been crafted to perfection. With a powerful processor and equally powerful battery, this smartphone is engineered to keep up with your active lifestyle.',
        'Samsung', '15900', 'Active', '10', ''),
  ('4', 'B0756RFBL7', 'Mi Max 2', 'Electronics', 'New',
        'A phone is not just a phone anymore; it is much more than that. With the Mi Max 2 mobile, you can expand your possibilities as it comes with a 16.35 cm (6.44) Full HD display, which allows you to work on Excel sheets conveniently and watch movies in a clarity that you will love.',
        'Mi', '16999', 'Active', '10', ''),
  ('5', 'B06XRKQSY7', 'Moto G5 Plus', 'Electronics', 'New',
        'Your search for a flaunt-worthy, feature-rich smartphone ends with the Moto G5 Plus mobile. With a captivating design and an exceptional camera, this smartphone will change how you look at mobile photography.',
        'Motorola', '14999', 'Active', '10', ''),
  ('6', 'B01LZWFVHL', 'Apple iPhone 7 (Silver, 32GB)', 'Electronics', 'New',
        '12MP primary camera with optical image stabilisation, Quad-LED True Tone flash and Live Photos, 4K video recording at 30 fps and slow-motion video recording in 1080p at 120 fps, 7MP front facing FaceTime HD camera with Retina Flash',
        'Apple', '48490', 'Active', '10', '');