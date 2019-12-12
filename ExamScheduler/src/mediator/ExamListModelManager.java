package mediator;

import model.*;
import persistence.XmlConverterException;

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

  @Override public ClassroomList loadClassroomList() throws XmlConverterException
  {
    return examListFile.loadClassroomList();
  }

  @Override public CourseList loadCourseList() throws XmlConverterException
  {
    return examListFile.loadCourseList();
  }

  @Override public ExaminerList loadExaminerList() throws XmlConverterException
  {
    return examListFile.loadExaminerList();
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
}

