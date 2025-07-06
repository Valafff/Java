package org.OOPexample;
import java.util.Calendar;
import java.time.YearMonth;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CustomDate
{
    private int day;
    private int  month;
    private  int year;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if (day <1 || day > 31)
        {
            this.day =1;
        }
        else
        {
            this.day = day;
        }
    }

    public void setMonth(int month) {

        if (month < 1 || month > 12 )
        {
            this.month = 1;
        }
        else
        {
            this.month = month;
        }

    }

    public void setYear(int year) {
        if (year < 0 || year > 9999)
        {
            year = 1;
        }
        else
        {
            this.year = year;
        }
    }

    CustomDate (int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    CustomDate (int day, int month)
    {
        this.day = day;
        this.month = month;
        year = Calendar.getInstance().get(Calendar.YEAR);
    }

    CustomDate (int day)
    {
        this.day = day;
        this.month = Calendar.getInstance().get(Calendar.MONTH);
        year = Calendar.getInstance().get(Calendar.YEAR);
    }

    CustomDate ()
    {
        this.day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        this.month = Calendar.getInstance().get(Calendar.MONTH);
        this.year = Calendar.getInstance().get(Calendar.YEAR);
    }

    public boolean isValid ()
    {
        int trueDays = YearMonth.of(year, month).lengthOfMonth();
        if (this.day > trueDays)
        {
            return  false;
        }
        return  true;
    }

    public  void next()
    {
        int trueDays = YearMonth.of(year, month).lengthOfMonth();
        if (day < trueDays-1)
        {
            day++;
        } else if (day == trueDays && month <12)
        {
            day =1;
            month++;
        } else if (day == trueDays && year <9999) {
            day =1;
            month = 1;
            this.year++;
        }
    }
    public int toDays() {
        LocalDate currentDate = LocalDate.of(year, month, day);
        LocalDate zeroDate = LocalDate.of(0, 1, 1); // 01.01.0000
        return (int) ChronoUnit.DAYS.between(zeroDate, currentDate);
    }

    public int dateOffset(CustomDate other) {
        LocalDate thirstDate = LocalDate.of(year, month, day);
        LocalDate secondDate = LocalDate.of(other.year, other.month, other.day);
        return Math.abs ((int) ChronoUnit.DAYS.between(secondDate, thirstDate));
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }
}
