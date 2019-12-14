package mediator;

import model.*;
import persistence.XmlConverterException;

import java.util.ArrayList;

public class ExamListModelManager implements ExamListModel
{
  private ExamList exams;
  private ExamListFile examListFile;

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

  @Override public ClassroomList loadClassroomList()
      throws XmlConverterException
  {
    return ExamListFile.loadClassroomList();
  }

  @Override public CourseList loadCourseList() throws XmlConverterException
  {
    return ExamListFile.loadCourseList();
  }

  @Override public ExaminerList loadExaminerList() throws XmlConverterException
  {
    return ExamListFile.loadExaminerList();
  }

  @Override public void removeExam(String course)
  {
    exams.removeExam(course);
  }

  @Override public Exam getExamByCourse(String courseName)
  {
    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.getExam(i).getCourse().getName().equals(courseName))
      {
        return exams.getExam(i);
      }
    }
    return null;
  }

  @Override public ExamList getExams()
  {
    return exams;
  }

  @Override public void isClassRested(String studyGroup, int day)
  {
    ArrayList<Exam> examsToEndOnDay = exams.getExamsByEndDate(day-1);
    for (int i = 0; i < examsToEndOnDay.size(); i++)
    {
      if (examsToEndOnDay.get(i).getCourse().getStudyGroup().equals(studyGroup))
      {
        throw new IllegalArgumentException("This class has an exam the day before");
      }
    }
  }

  @Override public boolean isDateAvailable(MyDate startDate, MyDate endDate,
      String classroom)
  {
    if (exams.size() < 1)
      return true;

    for (int i = 0; i < exams.size(); i++)
    {
      Exam exam = exams.getExam(i);

      boolean validStartDate =
          startDate.getTimeInSeconds() - exam.getDate1().getTimeInSeconds()
              > 0;

      boolean validEndDate =
          endDate.getTimeInSeconds() - exam.getDate2().getTimeInSeconds() > 0;

      if (validStartDate && validEndDate && exam.getClassroom().getNumber().equals(classroom))
      {
        return true;
      }
    }

    throw new IllegalArgumentException("Date is not available");

  }
}

