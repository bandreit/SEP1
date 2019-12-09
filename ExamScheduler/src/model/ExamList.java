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
<<<<<<< HEAD

  public void addExam(Exam exam)
=======
  public void add(Exam exam)
>>>>>>> 50ed1581058d2ef35eab3abbe74bd3a20b913133
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
