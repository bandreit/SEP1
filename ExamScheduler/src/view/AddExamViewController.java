package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import mediator.ExamListModel;
import model.*;
import persistence.XmlConverterException;

import java.time.LocalDate;

public class AddExamViewController
{
  @FXML private Label oralOrWritten;
  @FXML private ComboBox supervisor;
  @FXML private ComboBox externalSupervisor;
  @FXML private ComboBox course;
  @FXML private DatePicker datePicker;
  @FXML private ComboBox classroom;
  @FXML private ComboBox time1;
  @FXML private ComboBox time2;
  @FXML private TextField room;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ExamListModel model;
  private ClassroomList classroomList;
  private CourseList courseList;
  private ExaminerList examinerList;

  public AddExamViewController()
  {

  }

  public void init(ViewHandler viewHandler, ExamListModel model, Region root)
      throws XmlConverterException
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    reset();

    //loads data from XML
    classroomList = model.loadClassroomList();
    courseList = model.loadCourseList();
    examinerList = model.loadExaminerList();

    for (int i = 8; i < 10; i++)
    {
      time1.getItems().add("0"+i+":00");
      time1.getItems().add("0"+i+":15");
      time1.getItems().add("0"+i+":30");
      time1.getItems().add("0"+i+":45");
    }
    for (int i = 10; i < 14; i++)
    {
      time1.getItems().add(i+":00");
      time1.getItems().add(i+":15");
      time1.getItems().add(i+":30");
      time1.getItems().add(i+":45");
    }
    time1.getItems().add("14:00");


    for (int i = 10; i < 14; i++)
    {
      time2.getItems().add(i+":00");
      time2.getItems().add(i+":15");
      time2.getItems().add(i+":30");
      time2.getItems().add(i+":45");
    }
    time2.getItems().add("14:00");

    //Puts data in the combo boxes
    for (int i = 0; i < classroomList.size(); i++)
    {
      classroom.getItems().add(classroomList.getClassroom(i).getNumber());
    }

    for (int i = 0; i < courseList.size(); i++)
    {
      course.getItems().add(courseList.getCourse(i).getName());
    }

    for (int i = 0; i < examinerList.size(); i++)
    {
      if (examinerList.getExaminer(i).isCoExaminer())
      {
        externalSupervisor.getItems()
            .add(examinerList.getExaminer(i).getInitials());
      }
      else
      {
        supervisor.getItems().add(examinerList.getExaminer(i).getInitials());
      }
    }

  }

  public void reset()
  {
    errorLabel.setText("");
    supervisor.getItems().removeAll();
    course.getItems().removeAll();
    classroom.getItems().removeAll();
    oralOrWritten.setText("ORAL/WRITTEN");
    externalSupervisor.getItems().removeAll();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void courseAction()
  {
    supervisor.setDisable(false);
    for (int i = 0; i < courseList.size(); i++)
    {
      if (courseList.getCourse(i).getName().equals(course.getValue())){
        if (courseList.getCourse(i).isOral()){
          oralOrWritten.setText("ORAL");
          supervisor.setDisable(true);
        }else {
          oralOrWritten.setText("Written");
        }
        supervisor.setValue(courseList.getCourse(i).getTeacher().getInitials());

      }
    }
  }

  @FXML private void createExam()
  {
    try
    {
      errorLabel.setText("");
//      MyDate date1 = new MyDate(2,1,2020,10,20);
//      MyDate date2 = new MyDate(5,1,2020,14,20);
//      Examiner examiner = new Examiner("SVA", false);
//      Examiner coExaminer = new Examiner("MNA", true);
//      Course course = new Course("SEP1Y",34, true, examiner);
//      Classroom classroom = new Classroom("301B", true, 36);

//      model.addExam(date1,date2,examiner,coExaminer,course,classroom);


      LocalDate datePickerValue = datePicker.getValue();
      String startTime = time1.getValue().toString();
      String[] st = startTime.split(":");
      String endTime = time2.getValue().toString();
      String[] et = endTime.split(":");

      MyDate date1 = new MyDate(datePickerValue.getDayOfMonth(), datePickerValue.getMonthValue(), datePickerValue.getYear(), Integer.parseInt(st[0]),  Integer.parseInt(st[1]));
      MyDate date2 = new MyDate(datePickerValue.getDayOfMonth(), datePickerValue.getMonthValue(), datePickerValue.getYear(), Integer.parseInt(et[0]),  Integer.parseInt(et[1]));

      Examiner examiner = examinerList.getExaminer(supervisor.getValue().toString());
      Examiner coExaminer = examinerList.getExaminer(externalSupervisor.getValue().toString());
      Course actualCourse = courseList.getCourse(course.getValue().toString());
      Classroom actualClassroom = classroomList.getClassroom(classroom.getValue().toString());

      model.addExam(date1,date2,examiner,coExaminer,actualCourse,actualClassroom);

      viewHandler.openView("examListView");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void cancelPressed(ActionEvent event)
  {
    viewHandler.openView("examListView");
  }

}
