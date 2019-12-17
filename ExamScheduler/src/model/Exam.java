package model;

import java.io.Serializable;

/**
 * A representing an exam
 *
 * @author Lelde Norenberga and Edvinas Andrijauskas
 * @version 1.2-December 2019
 */
public class Exam implements Serializable
{
  private MyDate date1;
  private MyDate date2;
  private Examiner examiner;
  private Examiner coExaminer;
  private Course course;
  private Classroom classroom;

  /**
   * Six-argument constructor.
   * @param date1 copy of the first date of the exam
   * @param date2 copy of the second date of the exam
   * @param examiner the examiner
   * @param coExaminer the co-examiner
   * @param course the course
   * @param classroom the classroom
   */
  public Exam(MyDate date1, MyDate date2, Examiner examiner, Examiner coExaminer, Course course, Classroom classroom)
  {
    this.date1=date1.copy();
    this.date2=date2.copy();
    this.examiner=examiner;
    this.coExaminer=coExaminer;
    this.course=course;
    this.classroom=classroom;
  }

  /**
   * Getter for the first date
   * @return copy of the first date type MyDate
   */
  public MyDate getDate1()
  {
    return date1.copy();
  }

  /**
   * Getter for the second date
   * @return copy of the second date type MyDate
   */
  public MyDate getDate2()
  {
    return date2.copy();
  }

  /**
   * Getter for the examiner
   * @return examiner type Examiner
   */
  public Examiner getExaminer()
  {
    return examiner;
  }

  /**
   * Getter for the co-examiner
   * @return co-examiner type Examiner
   */
  public Examiner getCoExaminer()
  {
    return coExaminer;
  }

  public Course getCourse()
  {
    return course;
  }

  /**
   * Getter for the classroom
   * @return classroom type classroom
   */
  public Classroom getClassroom()
  {
    return classroom;
  }

  /**
   * Setter of the examiner
   * @param examiner examiner of the exam
   */
  public void setExaminer(Examiner examiner)
  {
    this.examiner = examiner;
  }

  /**
   * Setter of the course
   * @param course course of the exam
   */
  public void setCourse(Course course)
  {
    this.course = course;
  }
}
