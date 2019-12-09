package view;

import javafx.beans.property.*;
import model.Course;
import model.Exam;

public class ExamViewModel
{
  private StringProperty date1Property;
  private StringProperty date2Property;
  private StringProperty examinerProperty;
  private StringProperty coExaminerProperty;
  private StringProperty courseProperty;
  private StringProperty classroomProperty;
  private StringProperty oralWrittenProperty;
  private IntegerProperty studentsProperty;

  public ExamViewModel(Exam exam)
  {
    courseProperty = new SimpleStringProperty(exam.getCourse().getName());
    examinerProperty = new SimpleStringProperty(exam.getExaminer().getName());
    coExaminerProperty = new SimpleStringProperty(
        exam.getCoExaminer().getName());
    classroomProperty = new SimpleStringProperty(
        exam.getClassroom().getNumber());
    if (exam.getCourse().isOral())
    {
      oralWrittenProperty = new SimpleStringProperty("Oral");
    }
    else
    {
      oralWrittenProperty = new SimpleStringProperty("Written");
    }
    date1Property = new SimpleStringProperty(exam.getDate1().toString());
    date2Property = new SimpleStringProperty(exam.getDate2().toString());
    studentsProperty = new SimpleIntegerProperty(
        exam.getCourse().getStudents());
  }

  public StringProperty getDate1Property()
  {
    return date1Property;
  }

  public StringProperty getDate2Property()
  {
    return date2Property;
  }

  public StringProperty getExaminerProperty()
  {
    return examinerProperty;
  }

  public StringProperty getCoExaminerProperty()
  {
    return coExaminerProperty;
  }

  public StringProperty getCourseProperty()
  {
    return courseProperty;
  }

  public StringProperty getClassroomProperty()
  {
    return classroomProperty;
  }

  public StringProperty getOralWrittenProperty()
  {
    return oralWrittenProperty;
  }

  public IntegerProperty getStudentsProperty()
  {
    return studentsProperty;
  }
}
