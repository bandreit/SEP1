package model;

import java.util.ArrayList;

public class CourseList
{
  private ArrayList<Course> courses;

  public CourseList()
  {
    courses=new ArrayList<>();
  }
  public void addCourse(Course course)
  {
    courses.add(course);
  }
  public void removeCourse(String name)
  {
    for(int i=0;i<courses.size();i++)
    {
      if(courses.get(i).getName().equals(name))
      {
        courses.remove(i);
        break;
      }
    }
  }
  public ArrayList<Course> getAllCourses()
  {
    return courses;
  }
}
