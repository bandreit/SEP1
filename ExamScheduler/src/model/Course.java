package model;

public class Course
{
  private String name;
  private int students;
  private boolean isOral;
  private Examiner teacher;

  public Course(String name, int students, boolean isOral)
  {
    this.name=name;
    this.students=students;
    this.isOral=isOral;
  }

  public String getName()
  {
    return name;
  }

  public int getStudents()
  {
    return students;
  }

  public boolean isOral()
  {
    return isOral;
  }

  public Examiner getTeacher()
  {
    if(!teacher.isCoExaminer())
    {
      return teacher;
    }
    return null;
  }
}
