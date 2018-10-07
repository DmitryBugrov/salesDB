package ru.dmitrybugrov.salesDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesDbApplication.class, args);
	}
}


/*TODO


Система хранения информации о продажах.

Дано:
Товар. (Наименование, Цена).
Продажа. Состоит из Даты и нескольких (одна или больше) позиций (Товар, Количество, Скидка).
Раз в час случайным образом выбирается товар, на который следующий час будет действовать скидка. Скидка выбирается случайным образом от 5% до 10%.

Задание:
Нужен веб-сайт отображающий следующие данные:
1. Информация о товарах. Страница должна содержать список товаров с возможностью редактирования
и добавления новых позиций.
По каждому товару должна присутствовать информация о его продажах.
2. Информация о продажах. Страница должна содержать список продаж с возможностью добавления новых позиций.
По каждой продаже должна присутствовать информация о товарах.
3. История скидок.
4. Почасовая статистика содержащая количество чеков, общую стоимость чеков, стоимость среднего чека, сумму скидок, общую стоимость чеков с учётом скидок, стоимость среднего чека с учётом скидок.

Верстка черно-белая без наворотов (формы/таблицы).
Технологии: Spring MVC, Spring Data, Spring Boot, Apache Tomcat, PostgreSQL, JPA (Hibernate)
Желательно (не обязательно): юнит-тесты.

Ссылки на примеры
http://www.baeldung.com/spring-mvc-tutorial
http://www.baeldung.com/intro-to-spring-boot
http://www.baeldung.com/the-persistence-layer-with-spring-data-jpa
 */
