import javafx.application.Application;
import javafx.stage.Stage;
import mediator.ExamScheduleModel;
import mediator.ExamSchedule;
import persistence.XmlConverterException;
import view.ViewHandler;

public class ExamSchedulerGui extends Application
{
  public void start(Stage primaryStage) throws XmlConverterException
  {
    ExamScheduleModel model = new ExamSchedule();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
