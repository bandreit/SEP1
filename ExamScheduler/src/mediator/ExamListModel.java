package mediator;

import model.*;
import persistence.XmlConverterException;

public interface ExamListModel
{
  int numberOfExams();
  void addExam(MyDate date1, MyDate date2, Examiner examiner,
      Examiner coExaminer, Course course, Classroom classroom);
  void removeExam(int index);
  void addExam(Exam exam);
  Exam getExam(int index);
  Exam getExamByCourse(String courseName);
  void removeExam(String course);
  ClassroomList loadClassroomList() throws XmlConverterException;
  CourseList loadCourseList() throws XmlConverterException;
  ExaminerList loadExaminerList() throws XmlConverterException;
  ExamList getExams();
  ExamList loadExamList() throws XmlConverterException;

  void isClassRested(String studyGroup, int day);
  boolean isStudyGroupAvailable(MyDate startDate, MyDate endDate, String studyGroup);
  boolean isExaminerAvailable(MyDate startDate, MyDate endDate, String examiner);
  boolean examAlreadyExists(String course);
  boolean isRoomAvailable(MyDate startDate, MyDate endDate, String classroom);
  boolean areWrittenExamsAfterOral(MyDate startDate);
  void loadExamsToFile() throws XmlConverterException;
}
