##Hibernate Demo
Hibernate persistence using Spring framework. Spring provides a datasource
for the application, as well as transaction management. The benefit of 
Spring's transaction management is that propogation is handled automatically, 
in this case, through annotations, while still allowing access to Hibernate's 
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
 │       │			       	   │   └───ServiceApi.java
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

```

   ~Spring Hibernate Demo~ 
   
Creating product...
Product created: Rake

Creating vendor...
Vendor created: WYX Distributors

Updating product...
Product updated: Rake

Getting all vendors...
Printing vendors and products...
Vendor ID: 13255
 vendor_name=Brookings, vendor_contact=Harry Potuski
* Product ID: 31524
  prod_name=Spade, prod_price=19.99, prod_qoh=3
* Product ID: 31528
  prod_name=Hoe, prod_price=10.99, prod_qoh=7
* Product ID: 31525
  prod_name=Bucket, prod_price=5.77, prod_qoh=12
Vendor ID: 13256
 vendor_name=Trinity Dist., vendor_contact=Terry York
* Product ID: 31526
  prod_name=Shovel, prod_price=23.99, prod_qoh=2
Vendor ID: 13254
 vendor_name=ZTZ Distributors, vendor_contact=Bob Gross
* Product ID: 31529
  prod_name=Barbed Wire, prod_price=99.99, prod_qoh=3
* Product ID: 31527
  prod_name=Grass Seed, prod_price=9.99, prod_qoh=18
Vendor ID: 13270
 vendor_name=WYX Distributors, vendor_contact=Sarah Bleach
* Product ID: 31541
  prod_name=Rake, prod_price=20.0, prod_qoh=10

Deleting product...
Product deleted. 

~End

```


