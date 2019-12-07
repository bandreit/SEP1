package model;

<<<<<<< HEAD
import java.util.ArrayList;

public class StudyGroupList
{
  private ArrayList<StudyGroup> studyGroups;

  public StudyGroupList()
  {
    studyGroups=new ArrayList<>();
  }
  public void addStudyGroup(StudyGroup studyGroup)
  {
    studyGroups.add(studyGroup);
  }
  public void removeStudyGroup(int semester, char classLetter)
  {
    for(int i=0;i<studyGroups.size();i++)
    {
      if(semester==studyGroups.get(i).getSemester()&&classLetter==studyGroups.get(i).getClassLetter())
      {
        studyGroups.remove(i);
        break;
      }
    }
  }
  public StudyGroup getStudyGroup(int semester, char classLetter)
  {
    for(int i=0;i<studyGroups.size();i++)
    {
      if(semester==studyGroups.get(i).getSemester()&&classLetter==studyGroups.get(i).getClassLetter())
      {
        return studyGroups.get(i);
      }
    }
    return null;
  }
  public void addStudent(int semester, char classLetter)
  {
    for(int i=0;i<studyGroups.size();i++)
    {
      if(semester==studyGroups.get(i).getSemester()&&classLetter==studyGroups.get(i).getClassLetter())
      {
        studyGroups.get(i).addStudent();
      }
    }
  }
  public void removeStudent(int semester, char classLetter)
  {
    for(int i=0;i<studyGroups.size();i++)
    {
      if(semester==studyGroups.get(i).getSemester()&&classLetter==studyGroups.get(i).getClassLetter())
      {
        studyGroups.get(i).removeStudent();
      }
    }
  }
=======
public class StudyGroupList
{
>>>>>>> 1593870bfefeb8a9778e9cc497cc5ee51539497c
}
