package model;

import java.util.ArrayList;

public class CourseList
{
  private ArrayList<Course> courses;

  public CourseList()
  {
    courses = new ArrayList<>();
  }

  public Course getCourse(int index)
  {
    return courses.get(index);
  }

  public void addCourse(Course course)
  {
    courses.add(course);
  }

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

  public int size()
  {
    return courses.size();
  }

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
