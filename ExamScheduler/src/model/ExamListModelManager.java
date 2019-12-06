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

  @Override public void addExam(String course, String oralWritten,
      String date, String time, String examiner, String room, int students,
      String externalExaminer)
  {
    exams.addExam(
        new Exam(course, oralWritten, date, time, examiner, room, students,
            externalExaminer));
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
