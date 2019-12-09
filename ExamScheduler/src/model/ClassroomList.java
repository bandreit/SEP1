package model;

import java.util.ArrayList;

public class ClassroomList
{
  private ArrayList<Classroom> classrooms;

  public ClassroomList()
  {
    this.classrooms = new ArrayList<>();
  }

  public void addClassroom(Classroom classroom)
  {
    classrooms.add(classroom);
  }

  public Classroom getClassroom(String number)
  {
    return classrooms.get(Integer.parseInt(number));//does it work like that?
  }

  public void removeClassroom(String number)
  {
    classrooms.remove(number);
  }

  public void changeStatusFromUnavailableToAvailable(String number,
      String status) // check please,thanks :D
  {
    for (int i = 0; i < classrooms.size(); i++)
    {
      if (classrooms.get(i).getNumber().equals(number) && classrooms.get(i)
          .getStatus().equals(status))
      {
        classrooms.get(i).setStatus("Available");
      }
    }
  }

  public void changeStatusFromAvailableToUnavailable(String number,
      String status) // check please,thanks :D
  {
    for (int i = 0; i < classrooms.size(); i++)
    {
      if (classrooms.get(i).getNumber().equals(number) && classrooms.get(i)
          .getStatus().equals(status))
      {
        classrooms.get(i).setStatus("Unavailable");
      }
    }
  }

}
