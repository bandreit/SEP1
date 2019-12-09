package model;

import java.util.ArrayList;

public class ExamList
{
  private ArrayList<Exam> exams;

  public ExamList()
  {
    exams = new ArrayList<>();
  }

  public int size()
  {
    return exams.size();
  }

  public void addExam(Exam exam)

  {
    exams.add(exam);
  }
  public void remove(Exam exam)
  {
    exams.remove(exam);
  }
  public Exam get(int index)
  {
    return exams.get(index);
  }
}
