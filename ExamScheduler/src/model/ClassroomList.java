package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassroomList implements Serializable
{
  private ArrayList<Classroom> classrooms;

  public ClassroomList()
  {
    classrooms = new ArrayList<>();
  }

  public void addClassroom(Classroom classroom)
  {
    classrooms.add(classroom);
  }

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

  public Classroom getClassroom(int index){return classrooms.get(index);}

  public int size()
  {
    return classrooms.size();
  }

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
