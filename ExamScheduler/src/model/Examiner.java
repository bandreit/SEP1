package model;

public class Examiner
{
  private String subject;
  private String status;
  private String name;
  public Examiner (String subject,String status,String name)
  {
    this.subject=subject;
    this.status=status;
    this.name=name;
  }

  public String getName()
  {
    return name;
  }

  public String getStatus()
  {
    return status;
  }

  public String getSubject()
  {
    return subject;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public void setSubject(String subject)
  {
    this.subject = subject;
  }
  public boolean isAvailable()
  {
    if(status.equals("Available") || status.equals("available"))
    {
      return true;
    }
    return false;
  }
}
