package model;

import java.util.ArrayList;

/**
 * A class representing a list of examiners
 *
 * @author Lelde Norenberga
 * @version 1.2-December 2019
 */
public class ExaminerList
{
  private ArrayList<Examiner> examiners;

  /**
   * Zero-argument constructor initializing array list
   */
  public ExaminerList()
  {
    examiners = new ArrayList<>();
  }

  /**
   * Getter for the size of the list
   * @return how many examiner are in the list
   */
  public int size(){return examiners.size();}

  /**
   * Getter for the examiner by index
   * @param index integer
   * @return examiner type Examiner based on index
   */
  public Examiner getExaminer(int index){return examiners.get(index);}

  /**
   * Getter for the examiner by initials
   * @param initials initials of the examiner
   * @return examiner type Examiner based on initials if the are no examiners with these initials return null
   */
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
