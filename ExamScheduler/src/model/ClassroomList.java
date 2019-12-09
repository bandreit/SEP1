package model;

import java.util.ArrayList;

public class ClassroomList
{
  private ArrayList<Classroom> classrooms;

  public ClassroomList()
  {
    classrooms = new ArrayList<>();
  }

  public Classroom getClassrooms(String number)
  {
    for (int i = 0; i <classrooms.size() ; i++)
    {
      if(classrooms.get(i).getNumber().equals(number))
      {
        return classrooms.get(i);
      }
    }
    return null;
  }
}
