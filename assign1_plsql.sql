create database plsql_assign;
use plsql_assign;

CREATE TABLE Book (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publication_house VARCHAR(100),
    category VARCHAR(50),
    book_count INT,
    status ENUM('IN STOCK', 'OUT_OF_STOCK')
);

INSERT INTO Book (title, price, author, publication_house, category, book_count, status) VALUES
('The Silent Storm', 499.99, 'Amitav Ghosh', 'Mcgraw Hill', 'FICTION', 12, 'IN STOCK'),
('Battlefront', 349.50, 'Tom Clancy', 'Warner Bros', 'WAR', 0, 'OUT_OF_STOCK'),
('Laugh Lines', 199.00, 'Twinkle Khanna', 'DreamFolks', 'COMEDY', 5, 'IN STOCK'),
('Cricket Chronicles', 599.75, 'Rahul Dravid', 'Mcgraw Hill', 'SPORTS', 7, 'IN STOCK'),
('Winds of War', 450.25, 'Jeff Shaara', 'Warner Bros', 'WAR', 2, 'IN STOCK'),
('Fiction Fever', 299.99, 'Chetan Bhagat', 'DreamFolks', 'FICTION', 0, 'OUT_OF_STOCK'),
('The Comic Code', 250.00, 'Rohan Joshi', 'Mcgraw Hill', 'COMEDY', 8, 'IN STOCK'),
('The Last Match', 320.00, 'Sania Mirza', 'DreamFolks', 'SPORTS', 4, 'IN STOCK'),
('Echoes of War', 375.00, 'Stephen Ambrose', 'Warner Bros', 'WAR', 3, 'IN STOCK'),
('Tales Untold', 280.00, 'Ruskin Bond', 'Mcgraw Hill', 'FICTION', 6, 'IN STOCK');

-- 1. Fetch all Books that are "IN STOCK" and price is less than given value. 

DELIMITER $$
CREATE PROCEDURE get_books_instock_underprice(IN max_price DECIMAL(10,2))
BEGIN
    SELECT * 
    FROM Book
    WHERE status = 'IN STOCK' AND price < max_price;
END;
$$

call get_books_instock_underprice(350);

-- 2. Delete books that are from given publication_house. do not activate safe mode. 

DELIMITER $$
CREATE PROCEDURE delete_books_byPublication(IN pub_house VARCHAR(100))
BEGIN
    Declare i int default 0;
    Declare total_rows int default 0;
    Declare ids int;
    
	Select Count(id) into total_rows from Book WHERE publication_house = pub_house;
    
    WHILE i<=total_rows DO
		Select id into ids from Book WHERE publication_house = pub_house LIMIT i,1;
        DELETE From Book Where id = ids;
        SET i = i+1;
	END WHILE;
    
END;
$$

call delete_books_byPublication('DreamFolks');

Select * from Book;

-- 3. Update the price of books by given percent based on given category. do not activate safe mode. 
DELIMITER $$
Create Procedure update_price_bycategory(IN cat varchar(255), IN percent double)
BEGIN 
	Declare i int default 0;
    Declare total_rows int default 0;
    Declare ids int;
    
    Select count(id) into total_rows from Book WHERE category = cat;
    
	WHILE i<=total_rows DO
		Select id into ids from Book WHERE category = cat LIMIT i,1;
        UPDATE Book SET price = price + (price * (percent / 100)) WHERE id = ids;
        SET i = i+1;
	END WHILE;
END;
$$

CALL update_price_bycategory('COMEDY', 5);

Select * from Book;