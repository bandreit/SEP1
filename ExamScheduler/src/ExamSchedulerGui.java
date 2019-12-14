import javafx.application.Application;
import javafx.stage.Stage;
import mediator.ExamListModel;
import mediator.ExamListModelManager;
import persistence.XmlConverterException;
import view.ViewHandler;

public class ExamSchedulerGui extends Application
{
  public void start(Stage primaryStage) throws XmlConverterException
  {
    ExamListModel model = new ExamListModelManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
