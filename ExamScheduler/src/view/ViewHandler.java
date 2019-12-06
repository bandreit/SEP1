package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ExamViewController examViewController;

  public ViewHandler()
  {
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
   this.primaryStage = primaryStage;
   openView("examView");
  }


  public void openView(String id)
  {
    Region root = null;
    switch (id) {
      case "examView" : root = loadExamView("ExamView.fxml"); break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
      primaryStage.close();
  }

  private Region loadExamView(String fxmlFile)
  {
    if (examViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        examViewController = loader.getController();
        examViewController.init(this, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      examViewController.reset();
    }
    return examViewController.getRoot();
  }

}
