# create databases;
CREATE database IF NOT EXISTS product;
CREATE database IF NOT EXISTS wishlist;
CREATE database IF NOT EXISTS cart;
# create root user and grant rights;
#CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
GRANT ALL ON *.* TO 'root'@'%';
CREATE USER 'springuser'@'%' IDENTIFIED BY 'timao';
GRANT ALL ON product.* TO 'springuser'@'%';
GRANT ALL ON wishlist.* TO 'springuser'@'%';
GRANT ALL ON cart.* TO 'springuser'@'%';
