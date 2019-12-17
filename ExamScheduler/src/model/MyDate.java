package model;

/**
 * A class representing date and time
 *
 * @author Edvinas Andrijauskas
 * @version 1.2-December 2019
 */
public class MyDate
{
  private int day;
  private int month;
  private int year;
  private int hour;
  private int minutes;

  /**
   * Five-argument constructor throws an exception if hour is bigger than 24 or minutes bigger than 59
   * @param day the day
   * @param month the month
   * @param year the year
   * @param hour the hour 1-24
   * @param minutes the minutes 1-59
   * @throws IllegalArgumentException if time is out of bounds
   */
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

  /**
   * Getter for the day
   * @return day as an integer
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Getter for the month
   * @return month as an integer
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Getter for the year
   * @return year as an integer
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Get a copy of the date and time
   * @return new MyDate object
   */
  public MyDate copy()
  {
    return new MyDate(day, month, year, hour, minutes);
  }

  /**
   * A string representation of date and time
   * @return date and time as a string
   */
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

  /**
   * A string representation as a string
   * @return time as a string
   */
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

  /**
   * Checks if the date is before other date
   * @param other other MyDate object
   * @return true if date is before other date otherwise return false
   */
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

  /**
   * Checks if the date is after other date
   * @param other other MyDate object
   * @return true if date is after other date otherwise return false
   */
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

  /**
   * Compares two date objects
   * @param obj other date object
   * @return true if two objects are equal otherwise return false
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof MyDate))
      return false;
    MyDate other = (MyDate) obj;
    return day == other.day && month == other.month && year == other.year && hour == other.hour && minutes == other.minutes;
  }

}

