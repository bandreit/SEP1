package model;

public class Examiner
{
  private String name;
  private boolean isCoExaminer;

  public Examiner(String name, boolean isCoExaminer)
  {
    this.name=name;
    this.isCoExaminer=isCoExaminer;
  }

  public String getName()
  {
    return name;
  }
  public boolean isCoExaminer()
  {
    return isCoExaminer;
  }
}
