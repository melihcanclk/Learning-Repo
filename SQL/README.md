<br>
<br>


 ![Image](https://r.resimlink.com/QvqbJzUg.png)

<br>

> #### Bu repo'da [Patika](https://academy.patika.dev/) [SQL Egitimi](https://academy.patika.dev/tr/courses/sql)nde yapmış oldugum bütün ödevler bulunmaktadır.


<br>

 - **SQL Ödev 01 | WHERE and Comparison & Logical Operations - <a href="#sql-ödev-01--where-ve-karşılaştırma--mantıksal-operatörler">Tıklayın. </a>**
 - **SQL Ödev 02 | BETWEEN ve IN - <a href="#sql-ödev-02--between-ve-in">Tıklayın</a>**
 - **SQL Ödev 03 | LIKE and ILIKE Operators - <a href="#sql-ödev-03--like-and-ilike-operators">Tıklayın</a>**
 - **SQL Ödev 04 | Aggregation Functions - <a href="#sql-ödev-04--distinct-and-count">Tıklayın</a>**
 - **SQL Ödev 05 | ORDER BY | LIMIT | OFFSET - <a href="#sql-ödev-05--order-by--limit--offset">Tıklayın</a>**

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


