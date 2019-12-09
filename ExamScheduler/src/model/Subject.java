package model;

public class Subject
{
  private Examiner examiner;
  public Subject(Examiner examiner)
  {
    this.examiner=examiner;
  }

  public void setExaminer(Examiner examiner)
  {
    this.examiner = examiner;
  }

  public Examiner getExaminer()
  {
    return examiner;
  }
}
