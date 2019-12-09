import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewHandler;

public class ExamSchedulerGui extends Application
{
  public void start(Stage primaryStage)
  {
    ExamListModel model = new ExamListModelManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
