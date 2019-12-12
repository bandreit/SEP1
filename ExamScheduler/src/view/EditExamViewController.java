package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import mediator.ExamListModel;
import model.*;
import persistence.XmlConverterException;

import java.time.LocalDate;

public class EditExamViewController
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
  @FXML private Label editingExam;
  private Region root;
  private ViewHandler viewHandler;
  private ExamListModel model;
  private ClassroomList classroomList;
  private CourseList courseList;
  private ExaminerList examinerList;
  private String editingCourse;

  public EditExamViewController()
  {
  }

  public void reset()
  {
    errorLabel.setText("");
    editingExam.setText("EDIT EXAM");
    supervisor.getItems().removeAll();
    classroom.getItems().removeAll();
    oralOrWritten.setText("ORAL/WRITTEN");
    externalSupervisor.getItems().removeAll();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void editExam()
  {
    try
    {
      LocalDate datePickerValue = datePicker.getValue();
      String startTime = time1.getValue().toString();
      String[] st = startTime.split(":");
      String endTime = time2.getValue().toString();
      String[] et = endTime.split(":");

      MyDate date1 = new MyDate(datePickerValue.getDayOfMonth(), datePickerValue.getMonthValue(), datePickerValue.getYear(), Integer.parseInt(st[0]),  Integer.parseInt(st[1]));
      MyDate date2 = new MyDate(datePickerValue.getDayOfMonth(), datePickerValue.getMonthValue(), datePickerValue.getYear(), Integer.parseInt(et[0]),  Integer.parseInt(et[1]));

      Examiner examiner = examinerList.getExaminer(supervisor.getValue().toString());
      Examiner coExaminer = examinerList.getExaminer(externalSupervisor.getValue().toString());
      Classroom actualClassroom = classroomList.getClassroom(classroom.getValue().toString());

      model.getExamByCourse(editingCourse).setDate1(date1);
      model.getExamByCourse(editingCourse).setDate2(date2);
      model.getExamByCourse(editingCourse).setExaminer(examiner);
      model.getExamByCourse(editingCourse).setCoExaminer(coExaminer);
      model.getExamByCourse(editingCourse).setClassroom(actualClassroom);

      viewHandler.openView("examListView", null);
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void cancelPressed(ActionEvent event)
  {
    viewHandler.openView("examListView", "");
  }

  public void init(ViewHandler viewHandler, ExamListModel model, Region root, String editingCourse)
      throws XmlConverterException
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.editingCourse = editingCourse;

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

    Exam editingActualExam = model.getExamByCourse(editingCourse);

    editingExam.setText(editingExam.getText() + " " + editingCourse);
    supervisor.getSelectionModel().select(courseList.getCourse(editingCourse).getTeacher().getInitials());
    classroom.getSelectionModel().select(editingActualExam.getClassroom().getNumber());
    externalSupervisor.getSelectionModel().select(editingActualExam.getCoExaminer().getInitials());
    time1.getSelectionModel().select(editingActualExam.getDate1().getTimeString());
    time2.getSelectionModel().select(editingActualExam.getDate2().getTimeString());
    datePicker.setValue(LocalDate.of(editingActualExam.getDate1().getYear(), editingActualExam.getDate1().getMonth(), editingActualExam.getDate1().getDay()));

    if (courseList.getCourse(editingCourse).isOral())
    {
      oralOrWritten.setText("ORAL");
      supervisor.setDisable(true);
    }else {
      oralOrWritten.setText("WRITTEN");
    }

  }

}
