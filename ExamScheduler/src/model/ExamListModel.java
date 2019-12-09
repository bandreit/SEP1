package model;

public interface ExamListModel
{ int numberOfExams();
  void addExam(MyDate date1, MyDate date2, Examiner examiner, Examiner coExaminer, Course course, Classroom classroom);
  void removeExam(int index);
  Exam getExam(int index);
}
