package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Exam;
import mediator.ExamScheduleModel;

import java.util.ArrayList;

public class ExamListViewModel
{
  private ObservableList<ExamViewModel> list;
  private ExamScheduleModel model;

  public ExamListViewModel(ExamScheduleModel model)
  {
    this.model = model;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<ExamViewModel> getList()
  {
    return list;
  }

  public ObservableList<ExamViewModel> update()
  {
    ArrayList<Exam> exams = new ArrayList<>();
    for (int i = 0; i < model.numberOfExams(); i++)
    {
      exams.add(model.getExam(i));
    }
    list.clear();
    for (int i = 0; i < exams.size(); i++)
    {
      list.add(new ExamViewModel(exams.get(i)));
    }
    return list;
  }

  public void add(Exam exam)
  {
    list.add(new ExamViewModel(exam));
  }

  public void remove(Exam exam)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getCourseProperty().get().equals(exam.getCourse()))
      {
        list.remove(i);
        break;
      }
    }
  }

  public void remove(String course)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getCourseProperty().get().equals(course))
      {
        list.remove(i);
        break;
      }
    }
  }
}
