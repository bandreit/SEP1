package model;

public class Examiner
{
  private String initials;
  private boolean isCoExaminer;

  public Examiner(String initials, boolean isCoExaminer)
  {
    this.initials=initials;
    this.isCoExaminer=isCoExaminer;
  }

  public String getInitials()
  {
    return initials;
  }
  public boolean isCoExaminer()
  {
    return isCoExaminer;
  }
}
