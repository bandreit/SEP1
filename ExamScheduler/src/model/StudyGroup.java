package model;

public class StudyGroup
{
  private int semester;
  private char classLetter;
  private int students;

  public StudyGroup(int semester,char classLetter,int students)
  {
    this.semester=semester;
    this.classLetter=classLetter;
    this.students=students;
  }

  public char getClassLetter()
  {
    return classLetter;
  }

  public int getSemester()
  {
    return semester;
  }

  public int getStudentCount()
  {
    return students;
  }

  public void setClassLetter(char classLetter)
  {
    this.classLetter = classLetter;
  }

  public void setSemester(int semester)
  {
    this.semester = semester;
  }

  public void setStudents(int students)
  {
    this.students = students;
  }

}
