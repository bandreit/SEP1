package model;

/**
 * A class representing  a course
 *
 * @author Lelde Norenberga
 * @version 1.2-December 2019
 */
public class Course
{
  private String name;
  private int students;
  private boolean isOral;
  private String studyGroup;
  private Examiner teacher;

  /**
   * Five-argument constructor
   * @param name name of the course
   * @param students student count
   * @param isOral is exam oral
   * @param studyGroup class having the course
   * @param teacher teacher who taught the course
   */
  public Course(String name, int students, boolean isOral, String studyGroup, Examiner teacher)
  {
    this.name=name;
    this.students=students;
    this.isOral=isOral;
    this.studyGroup = studyGroup;
    this.teacher = teacher;
  }

  /**
   * Getter for the name
   * @return name of the course as a string
   */
  public String getName()
  {
    return name;
  }

  /**
   * Getter for the student count
   * @return how many student took the course as an integer
   */
  public int getStudents()
  {
    return students;
  }

  /**
   * Return if the the exam is oral for the course
   * @return true if the exam is oral otherwise return false
   */
  public boolean isOral()
  {
    return isOral;
  }

  /**
   * Getter for the class that took the course
   * @return class as a string
   */
  public String getStudyGroup()
  {
    return studyGroup;
  }

  /**
   * Getter for the teacher that taught the course
   * @return teacher type Examiner if he/she is not a co-examiner otherwise return null
   */
  public Examiner getTeacher()
  {
    if(!teacher.isCoExaminer())
    {
      return teacher;
    }
    return null;
  }

  /**
   * A string representation of instance variables
   * @return name of the course, student count, is exam oral, initials of the teacher as a string
   */
  public String toString()
  {
    return name + ", students: " + students + ", is Oral: " + isOral + ", teacher: " + teacher.getInitials();
  }
}
