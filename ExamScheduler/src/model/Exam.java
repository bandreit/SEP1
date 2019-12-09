package model;

public class Exam
{
  private MyDate date1;
  private MyDate date2;
  private Examiner examiner;
  private Examiner coExaminer;
  private Course course;
  private Classroom classroom;
  private int id;

  public Exam(MyDate date1, MyDate date2, Examiner examiner, Examiner coExaminer, Course course, Classroom classroom)
  {
    this.date1=date1;
    this.date2=date2;
    this.examiner=examiner;
    this.coExaminer=coExaminer;
    this.course=course;
    this.classroom=classroom;
  }
}
