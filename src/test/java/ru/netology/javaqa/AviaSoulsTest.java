package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    TicketTimeComparator ticketComparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Екатеринбург", "Москва", 6_000, 12, 13);
    Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 5_000, 14, 15);
    Ticket ticket3 = new Ticket("Казань", "Челябинск", 6_000, 16, 18);
    Ticket ticket4 = new Ticket("Уфа", "Краснодар", 15_000, 19, 23);
    Ticket ticket5 = new Ticket("Сочи", "Калининград", 12_000, 8, 11);
    Ticket ticket6 = new Ticket("Сочи", "Калининград", 11_000, 12, 15);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void SearchForTheOneTicket() {// поиск по одному билету
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.search("Екатеринбург", "Москва");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchAndSortByOneTicket() {//Поиск И Сортировку По Одному Билету
        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchAndSortBy("Казань", "Челябинск", ticketComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchAndSortByNonExistentDestination() {//Поиск И Сортировку по несуществующему направлению
        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Уфа", ticketComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparingTwoIdenticalPrices() {//сравнение двух одинаковых по цене
        int expected = 0;
        int actual = ticket3.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparisonOfTwoIdenticalFlightTimes() {//сравнение двух одинаковых по времени полета
        int expected = 0;
        int actual = ticketComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void CompareAllTicketsWithTheSameFlightDestination() {//Сравнить все билеты с одинаковым направлением полета
        Ticket[] expected = {ticket5, ticket6};
        Ticket[] actual = manager.search("Сочи", "Калининград");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTheTickets() {//Находим все билеты
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForANonExistentTicket() {//поиск по несуществующему билету
        Ticket[] expected = {};
        Ticket[] actual = manager.search("Екатеринбург", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }
}