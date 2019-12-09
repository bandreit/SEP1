package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;

import java.util.Optional;

public class ExamListViewController
{
  @FXML private TableView<ExamViewModel> examListTable;
  @FXML private TableColumn<ExamViewModel, String> courseColumn;
  @FXML private TableColumn<ExamViewModel, String> oralWrittenColumn;
  @FXML private TableColumn<ExamViewModel, String> dateColumn;
  @FXML private TableColumn<ExamViewModel, String> date2Column;
  @FXML private TableColumn<ExamViewModel, String> examinersColumn;
  @FXML private TableColumn<ExamViewModel, String> roomColumn;
  @FXML private TableColumn<ExamViewModel, String> externalExaminerColumn;
  @FXML private TableColumn<ExamViewModel, Number> studentsColumn;
  @FXML private Label errorLabel;
  private Region root;
  private ExamListModel model;
  private ViewHandler viewHandler;
  private ExamListViewModel viewModel;

  public ExamListViewController()
  {

  }

  public void init(ViewHandler viewHandler, ExamListModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.viewModel = new ExamListViewModel(model);

    MyDate date1 = new MyDate(2,1,2020,10,20);
    MyDate date2 = new MyDate(5,1,2020,14,20);
    Examiner examiner = new Examiner("SVA", false);
    Examiner coExaminer = new Examiner("MNA", true);
    Course course = new Course("SEP1Y",34, true);
    Classroom classroom = new Classroom("301B", true, 36);

    model.addExam(date1,date2,examiner,coExaminer,course,classroom);

    courseColumn.setCellValueFactory(cellData -> cellData.getValue().getCourseProperty());
    oralWrittenColumn.setCellValueFactory(
        cellData -> cellData.getValue().getOralWrittenProperty());
    dateColumn
        .setCellValueFactory(cellData -> cellData.getValue().getDate1Property());
    date2Column
        .setCellValueFactory(cellData -> cellData.getValue().getDate2Property());
    examinersColumn.setCellValueFactory(
        cellData -> cellData.getValue().getExaminerProperty());
    roomColumn
        .setCellValueFactory(cellData -> cellData.getValue().getClassroomProperty());
    externalExaminerColumn.setCellValueFactory(
        cellData -> cellData.getValue().getCoExaminerProperty());
    studentsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getStudentsProperty());
    reset();
  }

  public void reset()
  {
    errorLabel.setText("");
    examListTable.setItems(viewModel.update());
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addExamButtonPressed()
  {
    try
    {
      viewHandler.openView("addExamView");
      System.out.println("aici");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

//  @FXML private void removeExamButtonPressed()
//  {
//    errorLabel.setText("");
//    try
//    {
//      ExamViewModel selectedItem = examListTable.getSelectionModel()
//          .getSelectedItem();
//      boolean remove = confirmation();
//      if (remove)
//      {
//        Exam exam = new Exam(selectedItem.getCourseProperty().get(),
//            selectedItem.getOralWrittenProperty().get(),selectedItem.getDateProperty().get(),selectedItem.getTimeProperty().get(),selectedItem.getExaminersProperty().get(),selectedItem.getRoomProperty().get(),selectedItem.getStudentsProperty().get(),selectedItem.getExternalExaminersProperty().get());
//        //        model.removeGrade(grade);
////        viewModel.remove(exam);
//        examListTable.getSelectionModel().clearSelection();
//      }
//    }
//    catch (Exception e)
//    {
//      errorLabel.setText("Item not found: " + e.getMessage());
//    }
//  }

//  private boolean confirmation()
//  {
//    int index = examListTable.getSelectionModel().getSelectedIndex();
//    ExamViewModel selectedItem = examListTable.getItems().get(index);
//    if (index < 0 || index >= examListTable.getItems().size())
//    {
//      return false;
//    }
//    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//    alert.setTitle("Confirmation");
//    alert.setHeaderText(
//        "Removing exam {" + selectedItem.getCourseProperty().get() + "on "
//            + selectedItem.getDateProperty().get() + "}");
//    Optional<ButtonType> result = alert.showAndWait();
//    return (result.isPresent()) && (result.get() == ButtonType.OK);
//  }

  @FXML private void cancelPressed(ActionEvent event)
  {
    ((Node) (event.getSource())).getScene().getWindow().hide();
  }

}
