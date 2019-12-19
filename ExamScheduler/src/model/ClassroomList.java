package model;

import java.util.ArrayList;

/**
 * A class representing list of classrooms
 *
 * @author Edvinas Andrijauskas
 * @version 1.2-December 2019
 */
public class ClassroomList
{
  private ArrayList<Classroom> classrooms;

  /**
   * Zero-argument constructor initializing array list
   */
  public ClassroomList()
  {
    classrooms = new ArrayList<>();
  }

  /**
   * Getter for classroom by number
   * @param number number of the classroom
   * @return classroom type Classroom from the list based on number if there are no classrooms with this number return null
   */
  public Classroom getClassroom(String number)
  {
    for (int i = 0; i < classrooms.size(); i++)
    {
      if (classrooms.get(i).getNumber().equals(number))
      {
        return classrooms.get(i);
      }
    }
    return null;
  }

  /**
   * Getter for classroom by index
   * @param index integer
   * @return classroom type Classroom based on integer
   */
  public Classroom getClassroom(int index){return classrooms.get(index);}

  /**
   * Getter for the size of the list
   * @return how many classrooms are in the list
   */
  public int size()
  {
    return classrooms.size();
  }

  /**
   * A string representation of the list
   * @return list of the classrooms as a string
   */
  public String toString()
  {
    String text = " ";

    for (int i = 0; i < classrooms.size(); i++)
    {
      text += classrooms.get(i).toString();
      text += "\n";
    }
    return text;
  }
}
