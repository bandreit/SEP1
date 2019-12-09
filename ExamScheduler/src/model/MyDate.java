package  model;
import java.time.LocalDate;

public class MyDate
{
  private int day;
  private int month;
  private int year;
  private double timeInSeconds;

  public MyDate(int day, int month, int year)
  {
    set(day, month, year);
  }

  public MyDate()
  {
    LocalDate today = LocalDate.now();

    this.day = today.getDayOfMonth();
    this.month = today.getMonthValue();
    this.year = today.getYear();

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
    int days=0;
    if (month == 1 )
    {
      days=year*365+numberOfDaysInMonth();
      return timeInSeconds=days*86.400;
    }
    if (month == 6 )
    {
      if(isLeapYear())
      {
        days = year * 365 + 31 + 29 + 31 +30 + 31 + day;
      }
      else
      {
        days = year * 365 + 31 + 28 + 31 +30 + 31 + day;
      }
    }
    return timeInSeconds=day*86.400;
  }
}

