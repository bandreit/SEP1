package model;

public class Course
{
  private String name;
  private int students;
  private boolean isOral;
  private String studyGroup;
  private Examiner teacher;

  public Course(String name, int students, boolean isOral, String studyGroup, Examiner teacher)
  {
    this.name=name;
    this.students=students;
    this.isOral=isOral;
    this.studyGroup = studyGroup;
    this.teacher = teacher;
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

  public String getStudyGroup()
  {
    return studyGroup;
  }

  public Examiner getTeacher()
  {
    if(!teacher.isCoExaminer())
    {
      return teacher;
    }
    return null;
  }

  public String toString()
  {
    return name + ", students: " + students + ", is Oral: " + isOral + ", teacher: " + teacher.getInitials();
  }
}
