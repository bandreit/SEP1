package model;

import java.time.LocalDate;

public class MyDate
{
  private int day;
  private int month;
  private int year;
  private int hour;
  private int minutes;

  public MyDate(int day, int month, int year, int hour, int minutes)
  {
    this.day=day;
    this.month=month;
    this.year=year;
    if(hour>24||minutes>59)
    {
      throw new IllegalArgumentException("Time is out of bounds");
    }
    this.hour = hour;
    this.minutes = minutes;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public void set(int day, int month, int year)
  {
    if (year < 0)
    {
      year = -year;
    }
    this.year = year;

    if (month < 1)
    {
      month = 1;
    }
    else if (month > 12)
    {
      month = 12;
    }
    this.month = month;

    if (day < 1)
    {
      day = 1;
    }
    else if (day > numberOfDaysInMonth())
    {
      day = numberOfDaysInMonth();
    }
    this.day = day;
  }

  public int numberOfDaysInMonth()
  {
    switch (month)
    {
      case 2:
        if (isLeapYear())
        {
          return 29;
        }
        return 28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
  }

  public boolean isLeapYear()
  {
    return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
  }

  public double getTimeInSeconds()
  {
    double timeInSeconds;
    int days = 0;
    if (month == 1)
    {
      days = year * 365 + numberOfDaysInMonth();
      return timeInSeconds = days * 86.400 + hour * 60 * 60 + minutes * 60;
    }
    if (month == 6)
    {
      if (isLeapYear())
      {
        days = year * 365 + 31 + 29 + 31 + 30 + 31 + day;
      }
      else
      {
        days = year * 365 + 31 + 28 + 31 + 30 + 31 + day;
      }
    }
    return timeInSeconds = day * 86.400 + hour * 60 * 60 + minutes * 60;
  }

  public MyDate copy()
  {
    return new MyDate(day, month, year, hour, minutes);
  }

  public String toString()
  {

    String fh = String.valueOf(hour), fm = String.valueOf(minutes);
    if (hour < 10)
    {
      fh = "0" + hour;
    }
    if (minutes < 10)
    {
      fm = "0" + minutes;
    }

    String s = "";
    if (day < 10)
    {
      s += "0";
    }
    s += day + ".";
    if (month < 10)
    {
      s += "0";
    }
    s += month + ".";
    s += year;

    return s + " " + fh + ":" +fm;
  }

  public String getTimeString()
  {
    String fh = String.valueOf(hour), fm = String.valueOf(minutes);
    if (hour < 10)
    {
      fh = "0" + hour;
    }
    if (minutes < 10)
    {
      fm = "0" + minutes;
    }

    return fh + ":" + fm;
  }

  public String getDateString()
  {
    String s = "";
    if (day < 10)
    {
      s += "0";
    }
    s += day + ".";
    if (month < 10)
    {
      s += "0";
    }
    s += month + ".";
    s += year;

    return s;
  }

  public boolean isBefore(MyDate other)
  {
    if (this.year > other.year)
    {
      return false;
    }
    else if ((this.year == other.year) && (this.month > other.month))
    {
      return false;
    }
    else if ((this.year == other.year) && (this.month == other.month) && (
        this.day > other.day))
    {
      return false;
    }
    else if ((this.year == other.year) && (this.month == other.month) && (
        this.day == other.day) && (this.hour > other.hour))
    {
      return false;
    }
    else if ((this.year == other.year) && (this.month == other.month) && (
        this.day == other.day) && (this.hour == other.hour) && (this.minutes > other.minutes))
    {
      return false;
    }
    else
    {
      return true;
    }
  }


  public boolean isAfter(MyDate other)
  {
    if (this.year < other.year)
    {
      return false;
    }
    else if ((this.year == other.year) && (this.month < other.month))
    {
      return false;
    }
    else if ((this.year == other.year) && (this.month == other.month) && (
        this.day < other.day))
    {
      return false;
    }
    else if ((this.year == other.year) && (this.month == other.month) && (
        this.day == other.day) && (this.hour < other.hour))
    {
      return false;
    }
    else if ((this.year == other.year) && (this.month == other.month) && (
        this.day == other.day) && (this.hour == other.hour) && (this.minutes < other.minutes))
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof MyDate))
      return false;
    MyDate other = (MyDate) obj;
    return day == other.day && month == other.month && year == other.year && hour == other.hour && minutes == other.minutes;
  }

}

