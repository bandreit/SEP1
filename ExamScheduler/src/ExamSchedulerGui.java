import javafx.application.Application;
import javafx.stage.Stage;
import model.ExamListModel;
import model.ExamListModelManager;
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
