package model;

public class Exam
{
  private String course;
  private String oralWritten;
  private String date;
  private String time;
  private String examiner;
  private String room;
  private int students;
  private String externalExaminer;

  public Exam(String course, String oralWritten, String date, String time,
      String examiner, String room, int students, String externalExaminer)
  {
    this.course = course;
    this.oralWritten = oralWritten;
    this.date = date;
    this.time = time;
    this.examiner = examiner;
    this.room = room;
    this.students = students;
    this.externalExaminer = externalExaminer;
  }

  public String getCourse()
  {
    return course;
  }

  public void setCourse(String course)
  {
    this.course = course;
  }

  public String getOralWritten()
  {
    return oralWritten;
  }

  public void setOralWritten(String oralWritten)
  {
    this.oralWritten = oralWritten;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(String date)
  {
    this.date = date;
  }

  public String getTime()
  {
    return time;
  }

  public void setTime(String time)
  {
    this.time = time;
  }

  public String getExaminer()
  {
    return examiner;
  }

  public void setExaminer(String examiner)
  {
    this.examiner = examiner;
  }

  public String getRoom()
  {
    return room;
  }

  public void setRoom(String room)
  {
    this.room = room;
  }

  public int getStudents()
  {
    return students;
  }

  public void setStudents(int students)
  {
    this.students = students;
  }

  public String getExternalExaminer()
  {
    return externalExaminer;
  }

  public void setExternalExaminer(String externalExaminer)
  {
    this.externalExaminer = externalExaminer;
  }
}
