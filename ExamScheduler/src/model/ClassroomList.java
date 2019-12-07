package model;

import java.util.ArrayList;

public class ClassroomList
{
  private ArrayList<Classroom> classrooms;

  public ClassroomList()
  {
    classrooms=new ArrayList<>();
  }
  public void addClassroom(Classroom classroom)
  {
    classrooms.add(classroom);
  }
  public void removeClassroom(String number)
  {
    for(int i=0; i<classrooms.size();i++)
    {
      if(classrooms.get(i).getNumber().equals(number))
      {
        classrooms.remove(i);
        break;
      }
    }
  }
  public Classroom getClassroom(String number)
  {
    for(int i=0; i<classrooms.size();i++)
    {
      if(classrooms.get(i).getNumber().equals(number))
      {
        return classrooms.get(i);
      }
    }
    return null;
  }
  public void changeStatus(String number)
  {
    for(int i=0; i<classrooms.size();i++)
    {
      if(classrooms.get(i).getNumber().equals(number))
      {
        classrooms.get(i).changeStatus();
      }
    }
  }
}
