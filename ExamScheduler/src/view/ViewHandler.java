package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ExamListModel model;
  private ExamListViewController examListViewController;
  private AddExamViewController addExamViewController;

  public ViewHandler(ExamListModel model)
  {
    this.model = model;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
   this.primaryStage = primaryStage;
   openView("examListView");
  }


  public void openView(String id)
  {
    Region root = null;
    switch (id) {
      case "examListView" : root = loadExamListView("ExamListView.fxml"); break;
      case "addExamView" : root = loadAddExamView("AddExamView.fxml"); break;
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

  private Region loadExamListView(String fxmlFile)
  {
    if (examListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        examListViewController = loader.getController();
        examListViewController.init(this, root, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      examListViewController.reset();
    }
    return examListViewController.getRoot();
  }

  private Region loadAddExamView(String fxmlFile)
  {
    if (addExamViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addExamViewController = loader.getController();
        addExamViewController.init(this, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addExamViewController.reset();
    }
    return addExamViewController.getRoot();
  }

}
