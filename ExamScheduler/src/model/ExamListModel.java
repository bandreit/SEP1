package model;

public interface ExamListModel
{
  int numberOfExams();
  void addExam(String course, String oralWritten, String date, String time,
      String examiner, String room, int students, String externalExaminer);
  void removeExam(int index);
  Exam getExam(int index);
}
