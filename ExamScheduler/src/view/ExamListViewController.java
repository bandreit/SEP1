package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Exam;
import model.ExamListModel;

import java.util.Optional;

public class ExamListViewController
{
  @FXML private TableView<ExamViewModel> examListTable;
  @FXML private TableColumn<ExamViewModel, String> courseColumn;
  @FXML private TableColumn<ExamViewModel, String> oralWrittenColumn;
  @FXML private TableColumn<ExamViewModel, String> dateColumn;
  @FXML private TableColumn<ExamViewModel, String> timeColumn;
  @FXML private TableColumn<ExamViewModel, String> examinersColumn;
  @FXML private TableColumn<ExamViewModel, String> roomColumn;
  @FXML private TableColumn<ExamViewModel, String> externalExaminerColumn;
  @FXML private TableColumn<ExamViewModel, Number> studentsColumn;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ExamListModel model;
  private ExamListViewModel viewModel;

  public ExamListViewController()
  {

  }

  public void init(ViewHandler viewHandler, Region root, ExamListModel model)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.viewModel = new ExamListViewModel(model);
    model.addExam("SDJ1X", "O", "14-01-2020","09:00", "SVA", "E-301A", 34, "SVV");
    courseColumn.setCellValueFactory(cellData -> cellData.getValue().getCourseProperty());
    oralWrittenColumn.setCellValueFactory(
        cellData -> cellData.getValue().getOralWrittenProperty());
    dateColumn
        .setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
    timeColumn
        .setCellValueFactory(cellData -> cellData.getValue().getTimeProperty());
    examinersColumn.setCellValueFactory(
        cellData -> cellData.getValue().getExaminersProperty());
    roomColumn
        .setCellValueFactory(cellData -> cellData.getValue().getRoomProperty());
    externalExaminerColumn.setCellValueFactory(
        cellData -> cellData.getValue().getExternalExaminersProperty());
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

  @FXML private void removeExamButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      ExamViewModel selectedItem = examListTable.getSelectionModel()
          .getSelectedItem();
      boolean remove = confirmation();
      if (remove)
      {
        Exam exam = new Exam(selectedItem.getCourseProperty().get(),
            selectedItem.getOralWrittenProperty().get(),selectedItem.getDateProperty().get(),selectedItem.getTimeProperty().get(),selectedItem.getExaminersProperty().get(),selectedItem.getRoomProperty().get(),selectedItem.getStudentsProperty().get(),selectedItem.getExternalExaminersProperty().get());
        //        model.removeGrade(grade);
//        viewModel.remove(exam);
        examListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  private boolean confirmation()
  {
    int index = examListTable.getSelectionModel().getSelectedIndex();
    ExamViewModel selectedItem = examListTable.getItems().get(index);
    if (index < 0 || index >= examListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Removing exam {" + selectedItem.getCourseProperty().get() + "on "
            + selectedItem.getDateProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  @FXML private void cancelPressed(ActionEvent event)
  {
    ((Node) (event.getSource())).getScene().getWindow().hide();
  }

}
