package model;

import java.util.ArrayList;

public class ExaminerList
{
  private ArrayList<Examiner> examiners;

  public ExaminerList()
  {
    this.examiners = new ArrayList<>();
  }

  public int size()
  {
    return examiners.size();
  }

  public void addExaminer(Examiner name)
  {
    examiners.add(name); // Should we do this with connected with studyGroup?
  }

  public void removeExaminer(int index)
  {
    examiners.remove(index);
  }

  public Examiner getExaminer(int index)
  {
    return examiners.get(index);
  }

  public void changeStatusFromAvailableToUnavailable(String name,
      String status) // check please,thanks :D
  {
    for (int i = 0; i < examiners.size(); i++)
    {
      if (examiners.get(i).getName().equals(name) && examiners.get(i)
          .getStatus().equals(status))
      {
        examiners.get(i).setStatus("Unavailable");
      }
    }
  }

  public void changeStatusFromUnavailableToAvailable(String name,
      String status) // check please,thanks :D
  {
    for (int i = 0; i < examiners.size(); i++)
    {
      if (examiners.get(i).getName().equals(name) && examiners.get(i)
          .getStatus().equals(status))
      {
        examiners.get(i).setStatus("Available");
      }
    }
  }
}
