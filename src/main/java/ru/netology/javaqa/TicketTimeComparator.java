package ru.netology.javaqa;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {

        int flightTime1;
        int flightTime2;
        if ((t1.getTimeTo() - t1.getTimeFrom()) < 0) {
            flightTime1 = 24 - Math.abs(t1.getTimeTo() - t1.getTimeFrom());
        } else {
            flightTime1 = t1.getTimeTo() - t1.getTimeFrom();
        }

        if ((t2.getTimeTo() - t2.getTimeFrom()) < 0) {
            flightTime2 = 24 - Math.abs(t2.getTimeTo() - t2.getTimeFrom());
        } else {
            flightTime2 = t2.getTimeTo() - t2.getTimeFrom();
        }

        if (flightTime1 < flightTime2) {
            return -1;
        } else if (flightTime1 > flightTime2) {
            return 1;
        } else {
            return 0;
        }
    }
}
