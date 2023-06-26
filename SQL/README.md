<br>
<br>


 ![Image](https://r.resimlink.com/QvqbJzUg.png)

<br>

> #### Bu repo'da [Patika](https://academy.patika.dev/) SQL eğitiminde yapmış oldugum bütün ödevler bulunmaktadır.


<br>

 - **SQL Ödev 01 | WHERE and Comparison & Logical Operations - <a href="#sql-ödev-01--where-ve-karşılaştırma--mantıksal-operatörler">Tıklayın. </a>**

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