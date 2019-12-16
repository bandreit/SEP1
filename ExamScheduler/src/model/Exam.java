package model;

import java.io.Serializable;

public class Exam implements Serializable
{
  private MyDate date1;
  private MyDate date2;
  private Examiner examiner;
  private Examiner coExaminer;
  private Course course;
  private Classroom classroom;

  public Exam(MyDate date1, MyDate date2, Examiner examiner, Examiner coExaminer, Course course, Classroom classroom)
  {
    this.date1=date1;
    this.date2=date2;
    this.examiner=examiner;
    this.coExaminer=coExaminer;
    this.course=course;
    this.classroom=classroom;
  }

  public MyDate getDate1()
  {
    return date1;
  }

  public MyDate getDate2()
  {
    return date2;
  }

  public Examiner getExaminer()
  {
    return examiner;
  }

  public Examiner getCoExaminer()
  {
    return coExaminer;
  }

  public Course getCourse()
  {
    return course;
  }

  public Classroom getClassroom()
  {
    return classroom;
  }

  public void setDate1(MyDate date1)
  {
    this.date1 = date1;
  }

  public void setDate2(MyDate date2)
  {
    this.date2 = date2;
  }

  public void setExaminer(Examiner examiner)
  {
    this.examiner = examiner;
  }

  public void setCoExaminer(Examiner coExaminer)
  {
    this.coExaminer = coExaminer;
  }

  public void setCourse(Course course)
  {
    this.course = course;
  }

  public void setClassroom(Classroom classroom)
  {
    this.classroom = classroom;
  }
}
