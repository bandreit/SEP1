package model;

public class Classroom
{
  private String status;
  private String equipment;
  private String number;
  private int tableCount;
  private int chairCount;
  public Classroom(String status,String equipment,String number,int tableCount,int chairCount)
  {
    this.status=status;
    this.equipment=equipment;
    this.number=number;
    this.tableCount=tableCount;
    this.chairCount=chairCount;
  }
  public boolean isAvailable()
  {
    if(status.equals("Available") ||status.equals("available") && (equipment.equals("ready") || equipment.equals("Ready") && tableCount >=35 && chairCount>=35 ))
    {
      return true;
    }
    return false;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public void setChairCount(int chairCount)
  {
    this.chairCount = chairCount;
  }

  public void setEquipment(String equipment)
  {
    this.equipment = equipment;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  public void setTableCount(int tableCount)
  {
    this.tableCount = tableCount;
  }

  public String getStatus()
  {
    return status;
  }

  public int getChairCount()
  {
    return chairCount;
  }

  public int getTableCount()
  {
    return tableCount;
  }

  public String getEquipment()
  {
    return equipment;
  }

  public String getNumber()
  {
    return number;
  }
}
