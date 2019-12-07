package model;

import java.util.ArrayList;

public class ExaminerList
{
  private ArrayList<Examiner> examiners;

  public ExaminerList()
  {
    examiners=new ArrayList<>();
  }
  public void addExaminer(Examiner examiner)
  {
    examiners.add(examiner);
  }
  public void removeExaminer(String name)
  {
    for(int i=0;i<examiners.size();i++)
    {
      if(examiners.get(i).getName().equals(name))
      {
        examiners.remove(i);
        break;
      }
    }
  }
  public Examiner getExaminer(String name)
  {
    for(int i=0;i<examiners.size();i++)
    {
      if(examiners.get(i).getName().equals(name))
      {
        return examiners.get(i);
      }
    }
    return null;
  }
  public void changeStatus(String name)
  {
    for(int i=0; i<examiners.size();i++)
    {
      if(examiners.get(i).getName().equals(name))
      {
        examiners.get(i).changeStatus();
      }
    }
  }
}
