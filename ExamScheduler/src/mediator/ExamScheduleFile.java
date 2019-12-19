package mediator;

import model.*;
import persistence.MyXmlConverter;
import persistence.XmlConverterException;

import java.io.File;
import java.util.ArrayList;

public class ExamScheduleFile
{
  public static ClassroomList loadClassroomList() throws XmlConverterException
  {
    MyXmlConverter converter = new MyXmlConverter();
    ClassroomList classroomList = converter.fromXml("ExamScheduler/src/mediator/ClassRooms.xml", ClassroomList.class);
    return classroomList;
  }

  public static CourseList loadCourseList() throws XmlConverterException
  {
    MyXmlConverter converter = new MyXmlConverter();
    CourseList courseList = converter.fromXml("ExamScheduler/src/mediator/Courses.xml", CourseList.class);
    return courseList;
  }

  public static ExaminerList loadExaminerList() throws XmlConverterException
  {
    MyXmlConverter converter = new MyXmlConverter();
    ExaminerList examinerList = converter.fromXml("ExamScheduler/src/mediator/Examiners.xml", ExaminerList.class);
    return examinerList;
  }

  public static ExamList loadExamList() throws XmlConverterException
  {
    MyXmlConverter converter = new MyXmlConverter();
    ExamList examList = converter.fromXml("ExamScheduler/src/mediator/Exams.xml", ExamList.class);
    return examList;
  }

}
