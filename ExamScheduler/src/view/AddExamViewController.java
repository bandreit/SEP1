package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

public class AddExamViewController
{
  @FXML private MenuButton oralOrWritten;
  @FXML private MenuButton supervisor;
  @FXML private MenuButton externalSupervisor;
  @FXML private MenuButton course;
  @FXML private DatePicker datePicker;
  @FXML private TextField time;
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
  }

  public void reset()
  {
    room.setText("");
    errorLabel.setText("");
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
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void cancelPressed(ActionEvent event)
{
  ((Node)(event.getSource())).getScene().getWindow().hide();
}

}
