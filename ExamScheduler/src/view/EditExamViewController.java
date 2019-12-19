package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import mediator.ExamScheduleModel;
import model.*;
import persistence.XmlConverterException;

import java.time.LocalDate;
import java.util.Optional;

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
  @FXML private TextField oralExamDayNo;
  @FXML private Label daysLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ExamScheduleModel model;
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
    oralExamDayNo.setVisible(false);
    daysLabel.setVisible(false);
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

    MyDate date1 = new MyDate(datePickerValue.getDayOfMonth(),
        datePickerValue.getMonthValue(), datePickerValue.getYear(),
        Integer.parseInt(st[0]), Integer.parseInt(st[1]));

    Examiner examiner = examinerList
        .getExaminer(supervisor.getValue().toString());
    Examiner coExaminer = examinerList
        .getExaminer(externalSupervisor.getValue().toString());
    Course actualCourse = courseList.getCourse(editingCourse);
    Classroom actualClassroom = classroomList
        .getClassroom(classroom.getValue().toString());

    int endDay = 0;

    //setting oral exam date to end after 3 days;
    if (actualCourse.isOral())
    {
      isNumeric(oralExamDayNo.getText());
      endDay = datePickerValue.plusDays(Integer.parseInt(oralExamDayNo.getText())).getDayOfMonth();

      for (int i = 0; i < Integer.parseInt(oralExamDayNo.getText()); i++)
      {
        if (datePickerValue.plusDays(i).getDayOfWeek().toString().equals("FRIDAY"))
        {
          endDay += 1;
        }
      }
    } else {
      endDay = datePickerValue.getDayOfMonth();
    }

    MyDate date2 = new MyDate(endDay,
        datePickerValue.getMonthValue(), datePickerValue.getYear(),
        Integer.parseInt(et[0]), Integer.parseInt(et[1]));

    //Validate Weekend Days
    if (datePickerValue.getDayOfWeek().toString().equals("SATURDAY")
        || (datePickerValue.getDayOfWeek().toString().equals("SUNDAY")))
    {
      throw new IllegalArgumentException(
          "Exam date is set to be in the weekend");
    }

    LocalDate today = LocalDate.now();
    LocalDate firstDayOfExamPeriod = LocalDate.of(2020, 1, 2);

    //validate past dates
    if (datePickerValue.isBefore(today))
    {
      throw new IllegalArgumentException("Exam date is set in the past");
    }

    //Validate not to be on the first day of exam period
    if (datePickerValue.isEqual(firstDayOfExamPeriod))
    {
      if(!confirmation())
      {
        throw new IllegalArgumentException("Exam is set to be on the 2nd of January");
      }
    }

    if (actualClassroom.getMaxCapacity() < actualCourse.getStudents())
    {
      throw new IllegalArgumentException("Classroom is not big enough");
    }

    if (!actualClassroom.isEquiped())
    {
      throw new IllegalArgumentException("Classroom is not equiped");
    }

    //Validate February and June
    validateExamPeriod(date1);
    model.examAlreadyExists(actualCourse.getName());
    model.isExaminerAvailable(date1, date2, examiner.getInitials());
    model.isStudyGroupAvailable(date1, date2, actualCourse.getStudyGroup());
    model.isRoomAvailable(date1, date2, actualClassroom.getNumber());
    model.isClassRested(actualCourse.getStudyGroup(), date1.getDay());
    if (actualCourse.isOral())
    {
      model.areWrittenExamsAfterOral(date1);
    }
    model.addExam(date1, date2, examiner, coExaminer, actualCourse,
        actualClassroom);
    model.loadExamsToFile();

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

  public void init(ViewHandler viewHandler, ExamScheduleModel model, Region root, String editingCourse)
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
      oralExamDayNo.setVisible(true);
      daysLabel.setVisible(true);
      oralExamDayNo.setText(String.valueOf(editingActualExam.getDate2().getDay() - editingActualExam.getDate1().getDay()));
    }else {
      oralOrWritten.setText("WRITTEN");
    }

    model.removeExam(editingCourse);
  }

  public void validateExamPeriod(MyDate date)
  {
    if ((date.getMonth() != 1) && (date.getMonth() != 6))
    {
      throw new IllegalArgumentException(
          "This date is outside the exam period");
    }
  }

  private boolean confirmation()
  {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Setting an exam on the 2nd of January?");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  public void isNumeric(String strNum) {
    if (strNum == null) {
      throw new IllegalArgumentException("Please provide number of exam days to allocate");
    }
    double d = Integer.parseInt(strNum);
  }
}
