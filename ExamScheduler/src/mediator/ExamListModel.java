package mediator;

import model.*;
import persistence.XmlConverterException;

public interface ExamListModel
{
  int numberOfExams();
  void addExam(MyDate date1, MyDate date2, Examiner examiner,
      Examiner coExaminer, Course course, Classroom classroom);
  void removeExam(int index);
  Exam getExam(int index);
  Exam getExamByCourse(String courseName);
  void removeExam(String course);
  ClassroomList loadClassroomList() throws XmlConverterException;
  CourseList loadCourseList() throws XmlConverterException;
  ExaminerList loadExaminerList() throws XmlConverterException;
  ExamList getExams();

  void isClassRested(String studyGroup, int day);
  boolean isDateAvailable(MyDate startDate, MyDate endDate, String classroom);
}
