package model;

import java.util.ArrayList;

public class ExamList
{
  private ArrayList<Exam> exams;

  public ExamList()
  {
    this.exams = new ArrayList<>();
  }

  public int size()
  {
    return exams.size();
  }

  public void addExam(Exam grade)
  {
    exams.add(grade);
  }

  public void removeExam(int index)
  {
    exams.remove(index);
  }

  public Exam getExam(int index)
  {
    return exams.get(index);
  }
}
