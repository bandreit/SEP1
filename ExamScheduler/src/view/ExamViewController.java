package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.LoginModel;

public class ExamViewController
{
  @FXML private TextField usernameField;
  @FXML private PasswordField passwordField;
  @FXML private Label errorLabel;
  @FXML private Button cancelPressed;
  private Region root;
  private LoginModel model;
  private ViewHandler viewHandler;

  public ExamViewController()
  {

  }

  public void init(ViewHandler viewHandler, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public void reset()
  {
    usernameField.setText("");
    passwordField.setText("");
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void keyTyped()
  {
    try
    {
      model.validateLogin(usernameField.getText(), passwordField.getText());
      errorLabel.setText("");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void onEnter(ActionEvent event)
  {
    if (event.getSource() == usernameField)
    {
      passwordField.requestFocus();
    }
    else
    {
      loginPressed();
    }
  }

  @FXML private void loginPressed()
  {
    try
    {
      model.login(usernameField.getText(), passwordField.getText());
      errorLabel.setText("");
//      System.out.println(model.isLoggedIn());
      viewHandler.openView("GradeListView");
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
