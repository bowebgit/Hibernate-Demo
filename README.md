##Hibernate Demo
Hibernate persistence using Spring framework. Spring provides a datasource
for the application, as well as transaction management. The benefit of 
Springs transaction management is that propogation is handled automatically, 
in this case, through annotations, while still allowing access to Hibernates 
sessionFactory methods. 


###Software Environment
* Maven3
* Spring4 
* Hibernate4 
* Postgres9


###Java Project File Structure
```
Hibernate-Demo
 └───src.main.java.jedpayt.demo
 │       │                 ├───dao
 │       │                 │   ├───api
 │       │                 │   │   ├───ProductDAO.java
 │	   │			       │   │   └───VendorDAO.java
 │       │                 │   ├───ProductDAOImpl.java
 │       │                 │   └───VendorDAOImpl.java
 │       │                 ├───entity
 │	   │			       │   ├───Product.java
 │	   │			       │   └───Vendor.java
 │       │                 ├───main
 │       │			       │   └───Main.java
 │       │                 └───service
 │       │                     ├───api
 │       │			       	   │   └───Service.java
 │       │		               └───ServiceImpl.java
 │	   └───spring.xml
 └───pom.xml
```
 

###Database
```
-- Sequences
CREATE SEQUENCE vendor_seq;
CREATE SEQUENCE product_seq;

-- Vendor Table
CREATE TABLE vendor (
  vendor_id INTEGER PRIMARY KEY DEFAULT nextval('vendor_seq'),
  vendor_name TEXT,
  vendor_address TEXT,
  vendor_city TEXT,
  vendor_state CHAR(2),
  vendor_zip CHAR(10),
  vendor_contact TEXT,
  vendor_phone TEXT
);

-- Product Table
CREATE TABLE product (
  prod_id INTEGER PRIMARY KEY DEFAULT nextval('product_seq'),
  vendor_id INTEGER REFERENCES vendor(vendor_id),
  prod_name TEXT,
  prod_description TEXT,
  prod_price NUMERIC(12,2),
  prod_qoh INTEGER
);
```

###Output
Test with main.java


