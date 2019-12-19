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

class ExamTest
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
    MyDate startDate3 = new MyDate(7,1,2020, 8, 0);
    MyDate endDate1 = new MyDate(6,1,2020, 12, 0);
    MyDate endDate3 = new MyDate(7,1,2020, 12, 0);
    Exam exam1 = new Exam(startDate1, endDate1, examinerList.getExaminer(0), examinerList.getExaminer(1), courseList.getCourse(0), classroomList.getClassroom(0));
    Exam exam2SameRoom1 = new Exam(startDate1, endDate1, examinerList.getExaminer(0), examinerList.getExaminer(1), courseList.getCourse(0), classroomList.getClassroom(0));
    Exam exam2 = new Exam(startDate1, endDate1, examinerList.getExaminer(0), examinerList.getExaminer(1), courseList.getCourse(0), classroomList.getClassroom(1));
    Exam exam3 = new Exam(startDate1, endDate1, examinerList.getExaminer(0), examinerList.getExaminer(1), courseList.getCourse(1), classroomList.getClassroom(1));
    Exam exam3OneDayAfterExam1 = new Exam(startDate3, endDate3, examinerList.getExaminer(3), examinerList.getExaminer(1), courseList.getCourse(0), classroomList.getClassroom(0));

    goodExams = new ArrayList<>();
    goodExams.add(exam1);
    goodExams.add(exam2);
    goodExams.add(exam3);

    badExams = new ArrayList<>();
    badExams.add(exam2SameRoom1);
    badExams.add(exam3OneDayAfterExam1);
  }

  @BeforeEach void setUp() throws XmlConverterException
  {
    model = new ExamListModelManager();
  }

  @Test void testGetAndAddExam()
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

  @Test void validateRoomAvailability()
  {
    //room is not free
    model.addExam(goodExams.get(0));
    assertThrows(IllegalArgumentException.class, () -> {model.isRoomAvailable(goodExams.get(0).getDate1(), goodExams.get(0).getDate2(),badExams.get(0).getClassroom().getNumber());});

    //room is free
    assertDoesNotThrow(() -> model.isRoomAvailable(goodExams.get(0).getDate1(), goodExams.get(0).getDate2(), goodExams.get(1).getClassroom().getNumber()));
  }

  @Test void validateExamAlreadyExists()
  {
    //exam already exists
    model.addExam(goodExams.get(0));
    assertThrows(IllegalArgumentException.class, () -> {model.examAlreadyExists(badExams.get(0).getCourse().getName());});

    //exam does not exist
    assertDoesNotThrow(() -> model.examAlreadyExists(goodExams.get(2).getCourse().getName()));
  }

  @Test void validateExaminerIsAvailable()
  {
    //examiner is not available
    model.addExam(goodExams.get(0));
    assertThrows(IllegalArgumentException.class, () -> {model.isExaminerAvailable(goodExams.get(0).getDate1(), goodExams.get(0).getDate2(),badExams.get(0).getExaminer().getInitials());});

    //examiner is available
    assertDoesNotThrow(() -> model.isExaminerAvailable(goodExams.get(2).getDate1(), goodExams.get(2).getDate2(), badExams.get(1).getExaminer().getInitials()));
  }

  @Test void isClassAvailable()
  {
    //class is not available
    model.addExam(goodExams.get(0));
    assertThrows(IllegalArgumentException.class, () -> {model.isStudyGroupAvailable(goodExams.get(0).getDate1(), goodExams.get(0).getDate2(),badExams.get(0).getCourse().getStudyGroup());});

    //class is available
    assertDoesNotThrow(() -> model.isStudyGroupAvailable(goodExams.get(0).getDate1(), goodExams.get(0).getDate2(), goodExams.get(2).getCourse().getStudyGroup()));
  }

  @Test void isClassRested()
  {
    //Class is not rested
    model.addExam(goodExams.get(0));
    assertThrows(IllegalArgumentException.class, () -> {model.isClassRested(badExams.get(1).getCourse().getStudyGroup(), badExams.get(1).getDate1().getDay());});

    //Class is rested
    assertDoesNotThrow(() -> model.isClassRested(badExams.get(1).getCourse().getStudyGroup(), goodExams.get(0).getDate1().getDay()));
  }

  @AfterEach void tearDown()
  {
  }
}