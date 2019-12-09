package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExamViewModel
{
  private StringProperty courseProperty;
  private StringProperty oralWrittenProperty;
  private StringProperty dateProperty;
  private StringProperty timeProperty;
  private StringProperty examinersProperty;
  private StringProperty roomProperty;
  private StringProperty externalExaminersProperty;
  private IntegerProperty studentsProperty;

  public ExamViewModel(Exam exam)
  {
    courseProperty = new SimpleStringProperty(exam.getCourse());
    oralWrittenProperty = new SimpleStringProperty(exam.getOralWritten());
    dateProperty = new SimpleStringProperty(exam.getDate());
    timeProperty = new SimpleStringProperty(exam.getTime());
    examinersProperty = new SimpleStringProperty(exam.getExaminer());
    roomProperty = new SimpleStringProperty(exam.getRoom());
    externalExaminersProperty = new SimpleStringProperty(
        exam.getExternalExaminer());
    studentsProperty = new SimpleIntegerProperty(exam.getStudents());
  }

  public StringProperty getCourseProperty()
  {
    return courseProperty;
  }

  public StringProperty getOralWrittenProperty()
  {
    return oralWrittenProperty;
  }

  public StringProperty getDateProperty()
  {
    return dateProperty;
  }

  public StringProperty getTimeProperty()
  {
    return timeProperty;
  }

  public StringProperty getExaminersProperty()
  {
    return examinersProperty;
  }

  public StringProperty getExternalExaminersProperty()
  {
    return externalExaminersProperty;
  }

  public StringProperty getRoomProperty()
  {
    return roomProperty;
  }

  public IntegerProperty getStudentsProperty()
  {
    return studentsProperty;
  }

}
