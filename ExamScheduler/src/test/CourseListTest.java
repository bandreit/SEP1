package test;

import model.Course;
import model.CourseList;
import model.Examiner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

;import static org.junit.jupiter.api.Assertions.*;

class CourseListTest
{

  private CourseList list;
  private static Course course1;
  private static Course course2;
  private static Course course2Copy;
  private static Course course3;
  private static Course course4Name3;

  @BeforeAll static void init()
  {
    Examiner examiner11 = new Examiner("SVA", false);
    course1 = new Course("SDJ1X", 30, true, "IT-1Y", examiner11);

    Examiner examiner21 = new Examiner("MAN", true);
    course2 = new Course("MSE1Y", 34, false, "IT-1X", examiner21);

    Examiner examiner22 = new Examiner("MAN", true);
    course2Copy = new Course("MSE1Y", 34, false, "IT-1X", examiner22);

    Examiner examiner31 = new Examiner("LLE", true);
    course3 = new Course("RWD1Y", 54, true, "IT-1Y", examiner31);

    Examiner examiner32 = new Examiner("LBE", false);
    course4Name3 = new Course("RWD1Y", 54, true, "IT-1Y", examiner32);

  }

  @org.junit.jupiter.api.BeforeEach void setUp()
  {
    list = new CourseList();
  }

  @org.junit.jupiter.api.AfterEach void tearDown()
  {
  }

  @Test void testGet()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.getCourse(0);
    });

    list.addCourse(course1);
    assertEquals(course1, list.getCourse(0));

    list.addCourse(course2);
    list.addCourse(course3);

    assertEquals(course1, list.getCourse(0));
    assertEquals(course2, list.getCourse(1));
    assertSame(course2Copy, list.getCourse(1));
    assertEquals(course3, list.getCourse(2));
    assertNotEquals(course4Name3, list.getCourse(2));

    assertThrows(IndexOutOfBoundsException.class, () -> {
      list.getCourse(3);
    });
  }

  @Test public void testGetCourseByName()
  {

  }

  @Test public void testGetNumberOfCourses()
  {
    assertEquals(0, list.size());

    list.addCourse(course1);
    assertEquals(1, list.size());

    list.addCourse(course2);
    list.addCourse(course2Copy);
    assertEquals(3, list.size());

    list.addCourse(course3);
    assertEquals(4, list.size());

    list.addCourse(course4Name3);
    assertEquals(5, list.size());
  }

  @Test public void testToString()
  {

  }
}