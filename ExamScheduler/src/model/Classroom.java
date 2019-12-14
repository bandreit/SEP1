package model;

import java.io.Serializable;

public class Classroom implements Serializable
{
  private boolean equiped;
  private String number;
  private int maxCapacity;

  public Classroom(String number, boolean equiped, int maxCapacity)
  {
    this.number = number;
    this.equiped = false;
    this.maxCapacity = 0;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  public void setEquiped()
  {
    this.equiped = true;
  }

  public void setMaxCapacity(int maxCapacity)
  {
    this.maxCapacity = maxCapacity;
  }

  public boolean isEquiped()
  {
    return equiped;
  }

  public String getNumber()
  {
    return number;
  }

  public int getMaxCapacity()
  {
    return maxCapacity;
  }

  public String toString()
  {
    return number + ", is equiped: " + equiped + ", max capacity: " + maxCapacity;
  }
}
