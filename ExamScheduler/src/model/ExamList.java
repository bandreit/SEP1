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

  public void removeExam(int index)
  {
    exams.remove(index);
  }

  public void removeExam(String course)
  {
    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.get(i).getCourse().getName().equals(course)){
        exams.remove(i);
      }
    }
  }

  public Exam getExam(int index)
  {
    return exams.get(index);
  }

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
