package model;

import java.util.ArrayList;

/**
 * A class representing list of exams
 *
 * @author Lelde Norenberga and Edvinas Andrijauskas
 * @versin 1.2-December 2019
 */
public class ExamList
{
  private ArrayList<Exam> exams;

  /**
   * Zero-argument constructor initializing array list
   */
  public ExamList()
  {
    exams = new ArrayList<>();
  }

  /**
   * Getter for the size of the list
   * @return how many exams are in the list
   */
  public int size()
  {
    return exams.size();
  }

  /**
   * Adds an exam to the list
   * @param exam new exam type Exam
   */
  public void addExam(Exam exam)
  {
    exams.add(exam);
  }

  /**
   * Removes an exam from the list by index
   * @param index which exam to remove
   */
  public void removeExam(int index)
  {
    exams.remove(index);
  }

  /**
   * Removes exam from the list by course
   * @param course which exam to remove
   */
  public void removeExam(String course)
  {
    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.get(i).getCourse().getName().equals(course)){
        exams.remove(i);
      }
    }
  }

  /**
   * Getter for the exam by index
   * @param index which exam to return
   * @return exam based on integer
   */
  public Exam getExam(int index)
  {
    return exams.get(index);
  }

  /**
   * Return list of exams by end date
   * @param day the end date
   * @return an array list of exams based on end date
   */
  public ArrayList<Exam> getExamsByEndDate(int day)
  {
    ArrayList<Exam> examsByDate = new ArrayList<>();

    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.get(i).getDate2().getDay() == day){
        examsByDate.add(exams.get(i));
      }
    }

    return examsByDate;
  }
}
