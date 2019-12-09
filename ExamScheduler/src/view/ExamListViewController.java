package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.ExamListModel;

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

  @FXML private void cancelPressed(ActionEvent event)
  {
    ((Node) (event.getSource())).getScene().getWindow().hide();
  }

}
