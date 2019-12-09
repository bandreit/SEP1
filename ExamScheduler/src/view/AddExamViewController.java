package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

public class AddExamViewController
{
  @FXML private Label oralOrWritten;
  @FXML private ComboBox supervisor;
  @FXML private ComboBox externalSupervisor;
  @FXML private ComboBox course;
  @FXML private DatePicker datePicker;
  @FXML private TextField time1;
  @FXML private TextField time2;
  @FXML private TextField room;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;

  public AddExamViewController()
  {
  }

  public void init(ViewHandler viewHandler, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    reset();
    supervisor.getItems().add("SVA");
  }

  public void reset()
  {
    errorLabel.setText("");
    supervisor.getItems().removeAll();
    course.getItems().removeAll();
    oralOrWritten.setText("ORAL/WRITTEN");
    time1.setText("HH-MM");
    time2.setText("HH-MM");
    room.setText("");
    externalSupervisor.getItems().removeAll();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void createExam()
  {
    try
    {
      errorLabel.setText("");
      viewHandler.openView("examListView");
      System.out.println((String) supervisor.getValue());
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
