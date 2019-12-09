package model;

import java.util.ArrayList;

public class StudyGroupList
{
  private ArrayList<StudyGroup> StudyGroup;

  public StudyGroupList()
  {
    this.StudyGroup = new ArrayList<>();
  }

  public void addStudyGroup(StudyGroup studyGroup)
  {
    StudyGroup.add(studyGroup);
  }

  public StudyGroup getStudyGroup(int semester, char classLetter)
  {
    for (int i = 0; i < StudyGroup.size(); i++)
    {
      if (StudyGroup.get(i).getSemester() == semester
          && StudyGroup.get(i).getClassLetter() == classLetter)
      {
        return StudyGroup.get(i);
      }
    }
    return null;
  }

  public void remove(int semester, char classLetter)
  {
    for (int i = 0; i < StudyGroup.size(); i++)
    {
      if (StudyGroup.get(i).getSemester() == semester
          && StudyGroup.get(i).getClassLetter() == classLetter)
      {
        StudyGroup.remove(StudyGroup.get(i));
      }
    }
  }

  public void addStudent(int semester, char classLetter,
      int students)// fix this 100%
  {
    for (int i = 0; i < StudyGroup.size(); i++)
    {
      if (StudyGroup.get(i).getSemester() == semester
          && StudyGroup.get(i).getClassLetter() == classLetter)
      {
        StudyGroup.get(i).setStudents(students++);
      }
    }
  }

  public void removeStudent(int semester, char classLetter,
      int students)// fix this 100%
  {
    for (int i = 0; i < StudyGroup.size(); i++)
    {
      if (StudyGroup.get(i).getSemester() == semester
          && StudyGroup.get(i).getClassLetter() == classLetter)
      {
        StudyGroup.get(i).setStudents(students--);
      }
    }
  }
}

