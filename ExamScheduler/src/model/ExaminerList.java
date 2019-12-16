package model;

import java.util.ArrayList;

public class ExaminerList
{
  private ArrayList<Examiner> examiners;

  public ExaminerList()
  {
    examiners = new ArrayList<>();
  }

  public void addExaminer(Examiner examiner)
  {
    examiners.add(examiner);
  }

  public int size(){return examiners.size();}

  public Examiner getExaminer(int index){return examiners.get(index);}

  public void removeExaminer(String initials)
  {
    for (int i = 0; i < examiners.size(); i++)
    {
        if (examiners.get(i).getInitials().equals(initials))
        {
          examiners.remove(i);
          break;
        }
    }
  }

  public Examiner getExaminer(String initials)
  {
    for (int i = 0; i < examiners.size(); i++)
    {
        if (examiners.get(i).getInitials().equals(initials))
        {
          return examiners.get(i);
        }
      }
    return null;
  }
}
