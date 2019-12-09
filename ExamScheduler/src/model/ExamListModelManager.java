package model;

public class ExamListModelManager implements ExamListModel
{
  private ExamList exams;

  public ExamListModelManager()
  {
    this.exams = new ExamList();
  }

  @Override public int numberOfExams()
  {
    return exams.size();
  }

  @Override public void addExam(MyDate date1, MyDate date2, Examiner examiner,
      Examiner coExaminer, Course course, Classroom classroom)
  {
    exams.addExam(
        new Exam(date1, date2, examiner, coExaminer, course, classroom));
  }

  @Override public void removeExam(int index)
  {
    exams.removeExam(index);
  }

  @Override public Exam getExam(int index)
  {
    return exams.getExam(index);
  }
}
