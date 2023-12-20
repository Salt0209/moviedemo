CREATE TABLE MOVIES
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    genre VARCHAR(255),
    yearOfRelease INT
);
insert into MOVIES(title,genre,yearOfRelease) values('Spiderman','Sci-fi',2023)
insert into MOVIES(title,genre,yearOfRelease) values('Ironman','Action',2023)
insert into MOVIES(title,genre,yearOfRelease) values('Superman','Sci-fi',2022)

delete from MOVIES where id= 

update MOVIES
set title=?,genre=?,yearOfRelease=?
where id=? 

select * from MOVIES
"CREATE TABLE IF NOT EXISTS MOVIES (" +
                    "id INTEGER AUTO_INCREMENT PRIMARY KEY," +
                    "title VARCHAR(255)," +
                    "genre VARCHAR(255)," +
                    "yearOfRelease INTEGER)"