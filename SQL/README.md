<br>
<br>


 ![Image](https://r.resimlink.com/QvqbJzUg.png)

<br>

> #### Bu repo'da [Patika](https://academy.patika.dev/) [SQL Egitimi](https://academy.patika.dev/tr/courses/sql)nde yapmış oldugum bütün ödevler bulunmaktadır.


<br>

 - **SQL Ödev 01 | WHERE and Comparison & Logical Operations - <a href="#sql-ödev-01--where-ve-karşılaştırma--mantıksal-operatörler">Click Here. </a>**
 - **SQL Ödev 02 | BETWEEN ve IN - <a href="#sql-ödev-02--between-ve-in">Click Here</a>**
 - **SQL Ödev 03 | LIKE and ILIKE Operators - <a href="#sql-ödev-03--like-and-ilike-operators">Click Here</a>**
 - **SQL Ödev 04 | Aggregation Functions - <a href="#sql-ödev-04--distinct-and-count">Click Here</a>**
 - **SQL Ödev 05 | ORDER BY | LIMIT | OFFSET - <a href="#sql-ödev-05--order-by--limit--offset">Click Here</a>**
 - **SQL Ödev 06 | Aggregation Functions - <a href="#sql-ödev-06--aggregation-functions">Click Here</a>**
 - **SQL Ödev 07 | GROUP BY | HAVING - <a href="#sql-ödev-07--group-by--having">Click Here</a>**
 - **SQL Ödev 08 | CREATE TABLE | UPDATE DATAS - <a href="#sql-ödev-08--create-table--update-datas">Click Here</a>**
 - **SQL Ödev 09 | INNER JOIN - <a href="#sql-ödev-09--inner-join">Click Here</a>**
 - **SQL Ödev 10 | LEFT JOIN | RIGHT JOIN | FULL JOIN - <a href="#sql-ödev-10--left-join--right-join--full-join">Click Here</a>**
 - **SQL Ödev 11 | UNION | INTERSECT | EXCEPT - <a href="#sql-ödev-11--union--intersect--except">Click Here</a>**
 - **SQL Ödev 12 | Query Scenarios - <a href="#sql-ödev-12--query-scenarios">Click Here</a>**    

<br>

## SQL Ödev 01 | WHERE ve Karşılaştırma & Mantıksal Operatörler 

<br>

> **1.** film tablosunda bulunan title ve description sütunlarındaki verileri sıralayınız.

```sql
SELECT title, description FROM film;
```

<br>

> **2.** film tablosunda bulunan tüm sütunlardaki verileri film uzunluğu (length) 60 dan büyük **VE** 75 ten küçük olma koşullarıyla sıralayınız.

```sql
SELECT * FROM film
WHERE length > 60 AND length < 75;
```

<br>

> **3.** film tablosunda bulunan tüm sütunlardaki verileri rental_rate 0.99 **VE** replacement_cost 12.99 **VEYA** 28.99 olma koşullarıyla sıralayınız.

```sql
SELECT * FROM film
WHERE rental_rate = 0.99 AND replacement_cost = 12.99 OR replacement_cost = 28.99;
```

<br>

> **4.** customer tablosunda bulunan first_name sütunundaki değeri 'Mary' olan müşterinin last_name sütunundaki değeri nedir?

```sql
SELECT last_name FROM customer
WHERE first_name = 'Mary';
```

<br>

> **5.** film tablosundaki uzunluğu(length) 50 ten büyük **OLMAYIP** aynı zamanda rental_rate değeri 2.99 veya 4.99 **OLMAYAN** verileri sıralayınız.

```sql
SELECT * FROM film
WHERE NOT length > 50 AND NOT rental_rate = 2.99 OR rental_rate = 4.99;
```

<br>

## SQL Ödev 02 | BETWEEN ve IN

<br>

> **1.** film tablosunda bulunan tum sütunlardaki verileri replacement_cost degeri 12.99'dan buyuk 16.99'dan küçük olma kosuluyla sıralayınız. (BETWEEN - AND yapısını kullanınız.)

```sql
SELECT * FROM film
WHERE replacement_cost BETWEEN 12.99 AND 16.99;
```

<br>

> **2.** actor tablosunda bulunan **first_name** ve **last_name** sütunlardaki verileri **first_name** 'Penelope' **VE** last_name 'Guiness' olma koşuluyla sıralayınız. (IN operatörünü kullanınız.)

```sql
SELECT first_name, last_name FROM actor
WHERE first_name IN ('Penelope') AND last_name IN ('Guiness');
```

<br>

> **3.** film tablosunda bulunan tüm sütunlardaki verileri **rental_rate** 0.99, 2.99, 4.99 **VE** **replacement_cost** 12.99, 15.99, 28.99 olma koşullarıyla sıralayınız.

```sql
SELECT * FROM film
WHERE rental_rate IN (0.99, 2.99, 4.99) AND replacement_cost IN (12.99, 15.99, 28.99);
```

<br>

## SQL Ödev 03 | LIKE and ILIKE Operators

<br>

> **1.** country tablosunda bulunan **country** sütunundaki ülke isimlerinden **'A'** veya **'a'** karakteri ile başlayıp **'n'** karakteri ile sonlananları sıralayınız.

```sql
SELECT country FROM country
WHERE country LIKE 'A%n';
```

<br>

> **2.** country tablosunda bulunan **country** sütunundaki ülke isimlerinden en az 6 karakterden oluşan ve son karakteri **'n'** karakteri ile sonlananları sıralayınız.

```sql
SELECT country FROM country
WHERE country LIKE '_____%n';
```

<br>

> **3.** film tablosunda bulunan **title** sütunundaki film isimlerinden en az 4 adet buyuk ya da kucuk harf farketmeksizin **'T'** karakteri ile başlayanları sıralayınız.

```sql
SELECT title FROM film
WHERE title ILIKE 'T%T%T%T%';
```

<br>

> **4.** film tablosunda bulunan tüm sütunlardaki verilerden **title** 'C' karakteri ile başlayan ve **uzunluğu** (length) 90 dan büyük olan ve **rental_rate** 2.99 olan verileri sıralayınız.

```sql
SELECT * FROM film
WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;
```

<br>

## SQL Ödev 04 | DISTINCT and COUNT

<br>

> **1.** film tablosunda bulunan **replacement_cost** sütununda bulunan birbirinden farklı değerleri sıralayınız.

```sql
SELECT DISTINCT replacement_cost FROM film;
```

<br>

> **2.** film tablosunda bulunan **replacement_cost** sütununda birbirinden farklı kaç tane veri vardır?

```sql
SELECT COUNT(DISTINCT replacement_cost) FROM film;
```

<br>

> **3.** film tablosunda bulunan film isimlerinde (title) kaç tanesini **'T'** karakteri ile başlar ve rating değeri **'G'**'dir?

```sql
SELECT COUNT(*) FROM film
WHERE title LIKE 'T%' AND rating = 'G';
```

<br>

> **4.** country tablosunda bulunan ülke isimlerinden (country) kaç tanesi 5 karakterden oluşmaktadır?

```sql
SELECT COUNT(DISTINCT country) FROM country
WHERE country LIKE '_____';
```

<br>

> **5.** city tablosundaki şehir isimlerinin kaçtanesi **'R'** veya **r** karakteri ile biter?

```sql
SELECT COUNT(*) FROM city
WHERE city ILIKE '%r';
```

<br>

## SQL Ödev 05 | ORDER BY | LIMIT | OFFSET

<br>

> **1.** film tablosunda bulunan ve film ismi **(title)** 'n' karakteri ile **biten** en uzun **(length)** 5 filmi sıralayınız.

```sql
SELECT * FROM film
WHERE title LIKE '%n'
ORDER BY length DESC
LIMIT 5;
```

<br>

> **2.** film tablosunda bulunan ve film ismi **(title)** 'n' karakteri ile **biten** en kısa **(length)** ikinci 5 filmi sıralayınız.

```sql
SELECT * FROM film
WHERE title LIKE '%n'
ORDER BY length ASC
OFFSET 5
LIMIT 5;
```

<br>

> **3.** customer tablosunda bulunan **last_name** sütununa göre azalan şekilde yapilan siralamada store_id 1 olmak koşuluyla ilk 4 veriyi sıralayınız.

```sql
SELECT * FROM customer
WHERE store_id = 1
ORDER BY last_name DESC
LIMIT 4;
```

<br>

## SQL Ödev 06 | Aggregation Functions

<br>

> **1.** film tablosunda bulunan **rental_rate** sütunundaki değerlerin ortalaması nedir?

```sql
SELECT ROUND(AVG(rental_rate), 3) FROM film;
```

<br>

> **2.** film tablosunda bulunan filmlerden kaçtanesi **'C'** karekteri ile başlar?

```sql
SELECT COUNT(*) FROM film
WHERE title LIKE 'C%';
```

<br>

> **3.** film tablosunda bulunan filmlerden **rental_rate** değeri **0.99** a eşit olan en uzun **(length)** film kaç dakikadır?

```sql
SELECT MAX(length) FROM film
WHERE rental_rate = 0.99;
```

<br>

> **4.** film tablosunda bulunan filmlerin uzunluğu **(length)** 150 dakikadan büyük olanlarına ait kaç farklı **replacement_cost** değeri vardır?

```sql
SELECT COUNT(DISTINCT replacement_cost) FROM film
WHERE length > 150;
```

<br>


## SQL Ödev 07 | GROUP BY | HAVING

<br>

> **1.** film tablosunda bulunan filmleri **rating** değerlerine göre gruplayınız.

```sql
SELECT rating FROM film
GROUP BY rating;
```

<br>

> **2.** film tablosunda bulunan filmleri **replacement_cost** sütununa göre grupladığımızda film sayısı **(COUNT)** 50 den fazla olan **replacement_cost** değerini ve karşılık gelen film sayısını sıralayınız. (Bu kisimda HAVING ile WHERE arasindaki farka dikkat ediniz, WHERE'de daha önce belirlediğimiz kosullara göre sorgulama yaparken HAVING'de GROUP BY ile belirlediğimiz kosullara göre sorgulama yaparız.)

```sql
SELECT replacement_cost, COUNT(*) FROM film
GROUP BY replacement_cost
HAVING COUNT(*) > 50;
```

<br>

> **3.** customer tablosunda bulunan **store_id** değerlerine karşılık gelen müşteri sayılarını nelerdir?

```sql
SELECT store_id, COUNT(*) FROM customer
GROUP BY store_id;
```

<br>

> **4.** city tablosunda bulunan şehir verilerini **country_id** sütununa göre gruplandırdıktan sonra en fazla şehir sayısı barındıran **country_id** bilgisini ve şehir sayısını paylaşınız.

```sql
SELECT country_id, COUNT(*) FROM city
GROUP BY country_id
ORDER BY COUNT(*) DESC
LIMIT 1;
```

<br>

## SQL Ödev 08 | CREATE TABLE | UPDATE DATAS

<br>

> **1.** test veritabaninizda **employee** isminde bir tablo oluşturunuz ve bu tablonun sütunları **id(INTEGER), name(VARCHAR(50)), birth_date(DATE) ve email(VARCHAR(100))** olsun.

```sql
CREATE TABLE employee (
    id INTEGER,
    name VARCHAR(50),
    birth_date DATE,
    email VARCHAR(100)
);
```

> **2.** Oluşturduğunuz **employee** tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyiniz.

```sql
insert into employee (name, birthday, email) values ('Maris', '2000-09-30', 'mferrieres0@scribd.com');
insert into employee (name, birthday, email) values ('Whit', '1960-01-22', 'wvayne1@delicious.com');
insert into employee (name, birthday, email) values ('Bren', '1939-11-21', 'bviney2@woothemes.com');
insert into employee (name, birthday, email) values ('Carlin', '2017-06-20', 'caugustine3@usatoday.com');
insert into employee (name, birthday, email) values ('Jabez', '1903-03-17', 'jbensen4@walmart.com');
insert into employee (name, birthday, email) values ('Othilie', '1927-12-01', 'obrunelli5@issuu.com');
insert into employee (name, birthday, email) values ('Rosaline', '1967-12-14', 'rheinlein6@netvibes.com');
insert into employee (name, birthday, email) values ('Larine', '1939-09-14', 'lissard7@shop-pro.jp');
insert into employee (name, birthday, email) values ('Darnall', null, 'dmaccrossan8@prnewswire.com');
insert into employee (name, birthday, email) values ('Niccolo', '1946-11-06', 'ncoatham9@java.com');
insert into employee (name, birthday, email) values ('Wilhelm', '1950-08-15', 'wflowitha@bbb.org');
insert into employee (name, birthday, email) values ('Estel', '2002-10-05', 'emummb@de.vu');
insert into employee (name, birthday, email) values ('Tallie', '2007-06-10', 'tmarietc@ning.com');
insert into employee (name, birthday, email) values ('Dorena', null, 'dbarbarad@cafepress.com');
insert into employee (name, birthday, email) values ('Cam', '1963-07-04', 'chargiee@devhub.com');
insert into employee (name, birthday, email) values ('Marin', null, 'mromagnosif@parallels.com');
insert into employee (name, birthday, email) values ('Odilia', null, 'oelwellg@cnbc.com');
insert into employee (name, birthday, email) values ('King', '1959-02-08', 'kyettsh@hp.com');
insert into employee (name, birthday, email) values ('Serene', '1931-10-12', 'smacclintoni@altervista.org');
insert into employee (name, birthday, email) values ('Saloma', null, 'skilpinj@paypal.com');
insert into employee (name, birthday, email) values ('Monah', '1915-03-23', 'mbonnark@apache.org');
insert into employee (name, birthday, email) values ('Arie', '1957-05-13', 'askeggsl@pcworld.com');
insert into employee (name, birthday, email) values ('Kevina', null, 'kkirsteinm@weebly.com');
insert into employee (name, birthday, email) values ('Georgie', null, 'gkimmittn@privacy.gov.au');
insert into employee (name, birthday, email) values ('Rhoda', '1992-06-14', 'rbloiso@hp.com');
insert into employee (name, birthday, email) values ('Sacha', '1913-03-21', 'stwelvep@zimbio.com');
insert into employee (name, birthday, email) values ('Janeen', '1961-10-01', 'jyeandelq@thetimes.co.uk');
insert into employee (name, birthday, email) values ('Karla', '1918-06-15', 'kstrattanr@cornell.edu');
insert into employee (name, birthday, email) values ('Alison', null, 'aindgss@stumbleupon.com');
insert into employee (name, birthday, email) values ('Aloysia', '1997-11-13', 'akewleyt@ft.com');
insert into employee (name, birthday, email) values ('Toddy', '1988-08-10', 'tbelleeu@un.org');
insert into employee (name, birthday, email) values ('Leigh', '2001-10-04', 'lhaggethv@cmu.edu');
insert into employee (name, birthday, email) values ('Esma', '1969-01-13', 'emcalindonw@skyrock.com');
insert into employee (name, birthday, email) values ('Lucita', '2016-06-24', 'lbrockhurstx@weibo.com');
insert into employee (name, birthday, email) values ('Freida', '1980-12-29', 'fjereatty@mail.ru');
insert into employee (name, birthday, email) values ('Randy', '1911-04-10', 'rcollissonz@webeden.co.uk');
insert into employee (name, birthday, email) values ('Nathalie', '2017-09-06', 'ndalgarnowch10@washingtonpost.com');
insert into employee (name, birthday, email) values ('Vinnie', '1901-01-20', 'vgoulbourne11@cargocollective.com');
insert into employee (name, birthday, email) values ('Ethelda', '1984-01-14', 'eburch12@blogspot.com');
insert into employee (name, birthday, email) values ('Nicolis', '1931-03-24', 'nortiga13@ocn.ne.jp');
insert into employee (name, birthday, email) values ('Diann', '1933-04-24', 'dmulvy14@army.mil');
insert into employee (name, birthday, email) values ('Albert', '1907-05-19', 'arosengren15@github.io');
insert into employee (name, birthday, email) values ('Carlen', '1984-04-19', 'cpaskin16@house.gov');
insert into employee (name, birthday, email) values ('Ashley', null, 'asperrett17@qq.com');
insert into employee (name, birthday, email) values ('Godwin', '2022-08-04', 'gflecknoe18@apple.com');
insert into employee (name, birthday, email) values ('Shalna', '1940-09-20', 'smaunder19@nytimes.com');
insert into employee (name, birthday, email) values ('Kristen', '1931-12-03', 'kcullerne1a@hugedomains.com');
insert into employee (name, birthday, email) values ('Vally', '1911-04-07', 'vfitzsymons1b@ow.ly');
insert into employee (name, birthday, email) values ('Willyt', '1958-04-27', 'wferenczy1c@ifeng.com');
insert into employee (name, birthday, email) values ('Cal', '1954-07-08', 'csimpkin1d@google.ru');
insert into employee (name, birthday, email) values ('Brian', '1999-09-07', 'bcathro1e@nhs.uk');
insert into employee (name, birthday, email) values ('Rafaellle', '1944-03-18', 'rhanscomb1f@php.net');
insert into employee (name, birthday, email) values ('Leroi', '2003-04-12', 'landers1g@wufoo.com');
insert into employee (name, birthday, email) values ('Myer', '1919-12-17', 'mshilleto1h@vkontakte.ru');
insert into employee (name, birthday, email) values ('Farr', '2009-10-24', 'frushmer1i@tuttocitta.it');
insert into employee (name, birthday, email) values ('Eydie', '2000-09-06', 'erattery1j@hud.gov');
insert into employee (name, birthday, email) values ('Amble', '1902-06-13', 'aterrans1k@last.fm');
insert into employee (name, birthday, email) values ('Gino', '1919-08-04', 'gstenhouse1l@yolasite.com');
insert into employee (name, birthday, email) values ('Ritchie', '2004-06-04', 'rpettinger1m@auda.org.au');
insert into employee (name, birthday, email) values ('Chev', '1905-09-12', 'caleksidze1n@naver.com');
insert into employee (name, birthday, email) values ('Byrann', '1905-02-03', 'bbridson1o@purevolume.com');
insert into employee (name, birthday, email) values ('Brigid', '1940-04-27', 'bfaichney1p@amazon.de');
insert into employee (name, birthday, email) values ('Marabel', '1950-08-10', 'mgrimsdike1q@about.me');
insert into employee (name, birthday, email) values ('Goldarina', '1992-02-19', 'gbristo1r@is.gd');
insert into employee (name, birthday, email) values ('Lana', '2019-06-11', 'lrubenchik1s@lulu.com');
insert into employee (name, birthday, email) values ('Gannie', '2008-06-14', 'gmawhinney1t@theatlantic.com');
insert into employee (name, birthday, email) values ('Rebe', '1943-01-02', 'rmullin1u@europa.eu');
insert into employee (name, birthday, email) values ('Analiese', '1911-04-13', 'asuett1v@wikispaces.com');
insert into employee (name, birthday, email) values ('Lydie', '2005-01-02', 'ldevall1w@psu.edu');
insert into employee (name, birthday, email) values ('Paige', '1939-05-25', 'pspracklin1x@mayoclinic.com');
insert into employee (name, birthday, email) values ('Keslie', '1922-12-13', 'kpeizer1y@umich.edu');
insert into employee (name, birthday, email) values ('Quinton', '1994-06-26', 'qkelf1z@shareasale.com');
insert into employee (name, birthday, email) values ('Durand', '1996-08-14', 'dnesfield20@opensource.org');
insert into employee (name, birthday, email) values ('Jermaine', '1917-12-02', 'jnye21@prweb.com');
insert into employee (name, birthday, email) values ('Hedi', '2019-03-23', 'hdearl22@sciencedirect.com');
insert into employee (name, birthday, email) values ('Taylor', '1990-08-15', 'tdykas23@princeton.edu');
insert into employee (name, birthday, email) values ('Pietra', '1961-10-11', 'pdeetlefs24@who.int');
insert into employee (name, birthday, email) values ('Tine', '1934-05-07', 'tdoone25@google.ru');
insert into employee (name, birthday, email) values ('Aggi', '1930-05-23', 'amacgilrewy26@ihg.com');
insert into employee (name, birthday, email) values ('Cory', '1980-03-12', 'clestrange27@google.pl');
insert into employee (name, birthday, email) values ('Saba', '1919-11-19', 'smahady28@uol.com.br');
insert into employee (name, birthday, email) values ('Joete', '1959-06-30', 'jdeport29@cocolog-nifty.com');
insert into employee (name, birthday, email) values ('Glynis', '1963-08-31', 'gdarbyshire2a@fda.gov');
insert into employee (name, birthday, email) values ('Hy', null, 'hjenson2b@apple.com');
insert into employee (name, birthday, email) values ('Yvonne', '1917-12-26', 'ycrevy2c@ucsd.edu');
insert into employee (name, birthday, email) values ('Ileane', '2015-02-21', 'ibrucker2d@facebook.com');
insert into employee (name, birthday, email) values ('Aloysius', '1974-05-13', 'asweedland2e@hexun.com');
insert into employee (name, birthday, email) values ('Janel', '1917-07-20', 'jackerley2f@rakuten.co.jp');
insert into employee (name, birthday, email) values ('Karrie', '1943-06-25', 'kofihillie2g@house.gov');
insert into employee (name, birthday, email) values ('Pasquale', '2006-02-08', 'pizzard2h@google.com.br');
insert into employee (name, birthday, email) values ('Alexina', '1949-06-25', 'alightollers2i@nifty.com');
insert into employee (name, birthday, email) values ('Lee', '1918-12-20', 'lorford2j@surveymonkey.com');
insert into employee (name, birthday, email) values ('Daniel', '2009-03-27', 'dlafoy2k@wikispaces.com');
insert into employee (name, birthday, email) values ('Patrice', '1976-07-10', 'pgyurko2l@vk.com');
insert into employee (name, birthday, email) values ('Pierrette', null, 'pbrennand2m@delicious.com');
insert into employee (name, birthday, email) values ('Allyn', '2012-04-01', 'amccombe2n@wordpress.com');
insert into employee (name, birthday, email) values ('Alasdair', '1959-11-12', 'amacdonell2o@fc2.com');
insert into employee (name, birthday, email) values ('Merrili', '2010-06-02', 'mhalm2p@addthis.com');
insert into employee (name, birthday, email) values ('Chaddy', '1974-06-04', 'cetock2q@ucsd.edu');
insert into employee (name, birthday, email) values ('Timmy', '1905-10-01', 'tselbach2r@shop-pro.jp');
```

<br>

> **3.** Sutunlarin her birine gore diger sutunlari guncelleyecek 5 tane **UPDATE** islemi yapiniz.

```sql
UPDATE employee
SET name = 'Maris Ferrieres'
WHERE id = 1;

UPDATE employee
SET name = 'Whit Wayne'
WHERE id = 2;

UPDATE employee
SET name = 'Bren Viney'
WHERE id = 3;

UPDATE employee
SET name = 'Carlin Augustine'
WHERE id = 4;

UPDATE employee
SET name = 'Jabez Benson'
WHERE id = 5;
```

<br>

> **4.** Sutunlarin her birine gore ilgili satiri silecek 5 tane **DELETE** islemi yapiniz.

```sql

DELETE FROM employee
WHERE id = 1;

DELETE FROM employee
WHERE id = 2;

DELETE FROM employee
WHERE id = 3;

DELETE FROM employee
WHERE id = 4;

DELETE FROM employee
WHERE id = 5;
```

<br>

## SQL Ödev 09 | INNER JOIN

<br>

> **1.** city tablosu ile country tablosunda bulunan **şehir** (**city**) ve **ülke** (**country**) isimlerini **INNER JOIN** kullanarak sorgulayınız.

```sql
SELECT city, country FROM city
INNER JOIN country ON city.country_id = country.country_id;
```

<br>

> **2.** customer tablosu ile payment tablosunda bulunan **payment** ve **amount** sütunlarını **INNER JOIN** kullanarak sorgulayınız.

```sql
SELECT payment, amount FROM customer
INNER JOIN payment ON customer.customer_id = payment.customer_id;
```

<br>

> **3.** customer tablosu ile rental tablosunda bulunan **rental_id** ile customer tablosundaki **first_name** ve **last_name** isimlerini birlikte görebileceğimiz **INNER JOIN** sorgusunu yazınız.

```sql
SELECT rental.rental_id, customer.first_name, customer.last_name
FROM customer
INNER JOIN rental ON customer.customer_id = rental.customer_id;
```

<br>


## SQL Ödev 10 | LEFT JOIN | RIGHT JOIN | FULL JOIN

<br>

> **1.** city tablosu ile country tablosunda bulunan **şehir** (**city**) ve **ülke** (**country**) isimlerini **LEFT JOIN** kullanarak sorgulayınız.

```sql
SELECT city, country FROM city
LEFT JOIN country ON city.country_id = country.country_id;
```

<br>

> **2.** customer tablosu ile payment tablosunda bulunan **payment_id** ile customer tablosundaki **first_name** ve **last_name** isimlerini birlikte görebileceğimiz **RIGHT JOIN** sorgusunu yazınız.

```sql
SELECT payment.payment_id, customer.first_name, customer.last_name
FROM customer
RIGHT JOIN payment ON customer.customer_id = payment.customer_id;
```

<br>

> **3.** customer tablosu ile rental tablosunda bulunan **rental_id** ile customer tablosundaki **first_name** ve **last_name** isimlerini birlikte görebileceğimiz **FULL JOIN** sorgusunu yazınız.

```sql
SELECT rental.rental_id, customer.first_name, customer.last_name
FROM customer
FULL JOIN rental ON customer.customer_id = rental.customer_id;
```

<br>

## SQL Ödev 11 | UNION | INTERSECT | EXCEPT 

<br>

> **1.** actor ve customer tablolarında bulunan **first_name** sütunları için tum verileri sıralayalım.

```sql
(SELECT first_name FROM actor)
UNION
(SELECT first_name FROM customer);
```

<br>

> **2.** actor ve customer tablolarında bulunan **first_name** sütunları için kesişen verileri sıralayalım.

```sql
(SELECT first_name FROM actor)
INTERSECT
(SELECT first_name FROM customer);
```

<br>

> **3.** actor ve customer tablolarında bulunan **first_name** sütunları için ilk tabloda bulunan ancak ikinci tabloda bulunmayan verileri sıralayalım.

```sql
(SELECT first_name FROM actor)
EXCEPT
(SELECT first_name FROM customer);
```

<br>

> **4.** İlk 3 sorguyu tekrar eden veriler için de yapalım.

```sql

(SELECT first_name FROM actor)
UNION ALL
(SELECT first_name FROM customer);
```

```sql
(SELECT first_name FROM actor)
INTERSECT ALL
(SELECT first_name FROM customer);
```

```sql
(SELECT first_name FROM actor)
EXCEPT ALL
(SELECT first_name FROM customer);
```

<br>

## SQL Ödev 12 | Query Scenarios

<br>

> **1.** film tablosunda film uzunlugu **(length)** sutununda gosterilmektedir. Uzunlugu ortalama film uzunlugundan **(length)** fazla olan kac film vardir?

```sql
SELECT COUNT(*) FROM film
WHERE length > (SELECT AVG(length) FROM film);
```

<br>

> **2.** film tablosunda en yuksek rental_rate degerine sahip kac tane film vardir?

```sql
SELECT COUNT(*) FROM film
WHERE rental_rate = (SELECT MAX(rental_rate) FROM film);
```

<br>


> **3.** film tablosunda en yuksek rental_rate ve en dusuk replacement_cost degerine sahip filmleri sorgulayiniz.

```sql
SELECT * FROM film
WHERE rental_rate = (SELECT MAX(rental_rate) FROM film)
AND replacement_cost = (SELECT MIN(replacement_cost) FROM film);
```

<br>

> **4.** payment tablosunda en fazla sayida odeme yapan musteri kimdir?

```sql
SELECT customer_id, COUNT(*) as transaction_count FROM payment
GROUP BY customer_id
ORDER BY transaction_count DESC
LIMIT 1;
```

<br>
