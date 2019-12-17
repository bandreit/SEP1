package model;

import java.util.ArrayList;
/**
 * A class representing list of courses
 *
 * @author Lelde Norenberga
 * @version 1.2-December 2019
 */
public class CourseList
{
  private ArrayList<Course> courses;
  /**
   * Zero-argument constructor initializing array list
   */
  public CourseList()
  {
    courses = new ArrayList<>();
  }

  /**
   * Getter for course by index
   * @param index integer
   * @return course type Course based on integer
   */
  public Course getCourse(int index)
  {
    return courses.get(index);
  }

  /**
   * Getter for course by name
   * @param name name of the course
   * @return course type Course from the list based on name if there are no courses with this name return null
   */
  public Course getCourse(String name)
  {
    for (int i = 0; i < courses.size(); i++)
    {
      if (courses.get(i).getName().equals(name))
      {
        return courses.get(i);
      }
    }
    return null;
  }

  /**
   * Getter for the size of the list
   * @return how many courses are in the list
   */
  public int size(){return courses.size();}

  /**
   * A string representation of the list
   * @return list of the courses as a string
   */
  public String toString()
  {
    String text = " ";

    for (int i = 0; i < courses.size(); i++)
    {
      text += courses.get(i).toString();
      text += "\n";
    }
    return text;
  }
}
