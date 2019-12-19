package test;

import mediator.ExamListModel;
import mediator.ExamListModelManager;
import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.MyXmlConverter;
import persistence.XmlConverterException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ExamListTest
{
  private ExamList examList;
  private static CourseList courseList;
  private static ExaminerList examinerList;
  private static ClassroomList classroomList;
  private static ExamListModel model;
  private static ArrayList<Exam> goodExams;
  private static ArrayList<Exam> badExams;

  @BeforeAll static void init() throws XmlConverterException
  {
    MyXmlConverter converter = new MyXmlConverter();
    courseList = converter.fromXml("src/mediator/Courses.xml", CourseList.class);
    examinerList = converter.fromXml("src/mediator/Examiners.xml", ExaminerList.class);
    classroomList = converter.fromXml("src/mediator/ClassRooms.xml", ClassroomList.class);


    MyDate startDate1 = new MyDate(6,1,2020, 8, 0);
    MyDate endDate1 = new MyDate(6,1,2020, 12, 0);
    Exam exam1 = new Exam(startDate1, endDate1, examinerList.getExaminer(0), examinerList.getExaminer(1), courseList.getCourse(0), classroomList.getClassroom(0));
    Exam exam2SameRoom1 = new Exam(startDate1, endDate1, examinerList.getExaminer(0), examinerList.getExaminer(1), courseList.getCourse(0), classroomList.getClassroom(0));
    Exam exam2 = new Exam(startDate1, endDate1, examinerList.getExaminer(0), examinerList.getExaminer(1), courseList.getCourse(0), classroomList.getClassroom(1));

    goodExams = new ArrayList<>();
    goodExams.add(exam1);
    goodExams.add(exam2);

    badExams = new ArrayList<>();
    badExams.add(exam2SameRoom1);
  }

  @BeforeEach void setUp() throws XmlConverterException
  {
    model = new ExamListModelManager();
  }

  @Test void testGetAndGetExam()
  {
    //zero
    assertThrows(IndexOutOfBoundsException.class, () -> {model.getExam(0);});

    //one
    model.addExam(goodExams.get(0));
    assertEquals(goodExams.get(0), model.getExam(0));

    //more
    model.addExam(goodExams.get(1));
    assertEquals(goodExams.get(0), model.getExam(0));
    assertEquals(goodExams.get(1), model.getExam(1));
    assertNotEquals(goodExams.get(0), model.getExam(1));

    //after upper limit
    assertThrows(IndexOutOfBoundsException.class, () -> {model.getExam(3);});

  }

  @Test void validateExams()
  {
  }

  @AfterEach void tearDown()
  {
  }
}