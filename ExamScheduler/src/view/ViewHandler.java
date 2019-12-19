package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import mediator.ExamScheduleModel;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ExamScheduleModel model;
  private ExamListViewController examListViewController;
  private AddExamViewController addExamViewController;
  private EditExamViewController editExamViewController;

  public ViewHandler(ExamScheduleModel model)
  {
    this.model = model;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("examListView", null);
  }

  public void openView(String id, String course)
  {
    Region root = null;
    switch (id)
    {
      case "examListView":
        root = loadExamListView("ExamListView.fxml");
        break;
      case "addExamView":
        root = loadAddExamView("AddExamView.fxml");
        break;
      case "editExamView":
        root = loadEditExamView("EditExamView.fxml", course);
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
        examListViewController.init(this, model, root);
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
        addExamViewController.init(this, model, root);
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

  private Region loadEditExamView(String fxmlFile, String course)
  {
    editExamViewController = null;
    if (editExamViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        editExamViewController = loader.getController();
        editExamViewController.init(this, model, root, course);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      editExamViewController.reset();
    }
    return editExamViewController.getRoot();
  }

}
