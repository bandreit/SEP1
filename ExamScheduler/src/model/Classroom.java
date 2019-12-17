package model;

import java.io.Serializable;

/**
 * A class representing a classroom
 *
 * @author Edvinas Andrijauskas
 * @version 1.2-December 2019
 */
public class Classroom implements Serializable
{
  private boolean equiped;
  private String number;
  private int maxCapacity;

  /**
   * Three-argument constructor.
   * @param number number of the classroom
   * @param equiped is classroom equipped
   * @param maxCapacity how many students can have written exam in the classroom
   */
  public Classroom(String number, boolean equiped, int maxCapacity)
  {
    this.number = number;
    this.equiped = equiped;
    this.maxCapacity = maxCapacity;
  }

  /**
   * Returning if the classroom is equipped
   * @return true if the classroom is equipped otherwise return false
   */
  public boolean isEquiped()
  {
    return equiped;
  }

  /**
   * Getter for the number
   * @return number of the classroom as a string
   */
  public String getNumber()
  {
    return number;
  }

  /**
   * Getter for the capacity
   * @return maximum capacity as an integer
   */
  public int getMaxCapacity()
  {
    return maxCapacity;
  }

  /**
   * A string representation of instance variables
   * @return number of the classroom, is it equipped, capacity as a string
   */
  public String toString()
  {
    return number + ", is equiped: " + equiped + ", max capacity: " + maxCapacity;
  }
}
