package model;

/**
 * A class representing an examiner
 */
public class Examiner
{
  private String initials;
  private boolean isCoExaminer;

  /**
   * Two-argument constructor.
   * @param initials initials of the examiner
   * @param isCoExaminer is the examiner a co-examiner
   */
  public Examiner(String initials, boolean isCoExaminer)
  {
    this.initials=initials;
    this.isCoExaminer=isCoExaminer;
  }

  /**
   * Getter of the initials
   * @return examiners initials as a string
   */
  public String getInitials()
  {
    return initials;
  }

  /**
   * Return is examiner a co-examiner
   * @return true if examiner is a co-examiner otherwise return false
   */
  public boolean isCoExaminer()
  {
    return isCoExaminer;
  }
}
