package mediator;

import model.*;
import persistence.MyXmlConverter;
import persistence.XmlConverterException;

import java.io.File;
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

  @Override public boolean areWrittenExamsAfterOral(MyDate startDate)
  {
    for (int i = 0; i < exams.size(); i++)
    {
      if (exams.getExam(i).getDate1().isBefore(startDate))
      {
        throw new IllegalArgumentException("There are written exams after this oral one");
      }
    }
    return false;
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

  @Override public boolean isStudyGroupAvailable(MyDate startDate, MyDate endDate,
      String studyGroup)
  {
    if (exams.size() < 1)
      return true;

    for (int i = 0; i < exams.size(); i++)
    {

        if (exams.getExam(i).getCourse().getStudyGroup().equals(studyGroup))
        {
          Exam exam = exams.getExam(i);

          if (startDate.equals(exam.getDate1()) && endDate.equals(exam.getDate2()))
          {
            throw new IllegalArgumentException("Class" + studyGroup + " is not available on that day");
          }
          else if (startDate.isAfter(exam.getDate1()) && startDate.isBefore(exam.getDate2()))
          {
            throw new IllegalArgumentException("Class" + studyGroup + " is not available on that day");
          }
          else if (endDate.isAfter(exam.getDate1()) && endDate.isBefore(exam.getDate2()))
          {
            throw new IllegalArgumentException("Class" + studyGroup + " is not available on that day");
          }
          else if (startDate.getMonth() == exam.getDate1().getMonth() && startDate.getDay() == exam.getDate1().getDay())
          {
            throw new IllegalArgumentException("Class" + studyGroup + " is not available on that day");
          }
          else if (startDate.isBefore(exam.getDate1()) && endDate.isAfter(exam.getDate2()))
          {
            throw new IllegalArgumentException("Class" + studyGroup + " is not available on that day");
          }
        }
    }
    return true;
  }

  @Override public boolean isExaminerAvailable(MyDate startDate, MyDate endDate,
      String examiner)
  {
    if (exams.size() < 1)
      return true;

    for (int i = 0; i < exams.size(); i++)
    {

      if (exams.getExam(i).getExaminer().getInitials().equals(examiner))
      {
        Exam exam = exams.getExam(i);

        if (startDate.equals(exam.getDate1()) && endDate.equals(exam.getDate2()))
        {
          throw new IllegalArgumentException("Examiner " + examiner + " is not available on that day");
        }
        else if (startDate.isAfter(exam.getDate1()) && startDate.isBefore(exam.getDate2()))
        {
          throw new IllegalArgumentException("Examiner " + examiner + " is not available on that day");
        }
        else if (endDate.isAfter(exam.getDate1()) && endDate.isBefore(exam.getDate2()))
        {
          throw new IllegalArgumentException("Examiner " + examiner + " is not available on that day");
        }
        else if (startDate.getMonth() == exam.getDate1().getMonth() && startDate.getDay() == exam.getDate1().getDay())
        {
          throw new IllegalArgumentException("Examiner " + examiner + " is not available on that day");
        }
        else if (startDate.isBefore(exam.getDate1()) && endDate.isAfter(exam.getDate2()))
        {
          throw new IllegalArgumentException("Examiner " + examiner + " is not available on that day");
        }
      }
    }
    return true;
  }

  @Override public boolean isRoomAvailable(MyDate startDate, MyDate endDate,
      String classroom)
  {
    if (exams.size() < 1)
      return true;

    for (int i = 0; i < exams.size(); i++)
    {

      if (exams.getExam(i).getClassroom().getNumber().equals(classroom))
      {
        Exam exam = exams.getExam(i);

        if (startDate.equals(exam.getDate1()) && endDate.equals(exam.getDate2()))
        {
          throw new IllegalArgumentException("Classroom " + classroom + " is not available on that day");
        }
        else if (startDate.isAfter(exam.getDate1()) && startDate.isBefore(exam.getDate2()))
        {
          throw new IllegalArgumentException("Classroom " + classroom + " is not available on that day");
        }
        else if (endDate.isAfter(exam.getDate1()) && endDate.isBefore(exam.getDate2()))
        {
          throw new IllegalArgumentException("Classroom " + classroom + " is not available on that day");
        }
        else if (startDate.getMonth() == exam.getDate1().getMonth() && startDate.getDay() == exam.getDate1().getDay())
        {
          throw new IllegalArgumentException("Classroom " + classroom + " is not available on that day");
        }
        else if (startDate.isBefore(exam.getDate1()) && endDate.isAfter(exam.getDate2()))
        {
          throw new IllegalArgumentException("Classroom " + classroom + " is not available on that day");
        }
      }
    }
    return true;
  }

  @Override public boolean examAlreadyExists(String course)
  {
    for (int i = 0; i < exams.size(); i++)
    {
        if (exams.getExam(i).getCourse().getName().equals(course))
        {
          throw new IllegalArgumentException("Exam " + course + " already exists");
        }
    }
    return false;
  }

  @Override public void loadExamsToFile() throws XmlConverterException
  {
    MyXmlConverter converter = new MyXmlConverter();
    File file = converter.toXml(exams,"ExamScheduler/src/mediator/Exams.xml");
  }

}

