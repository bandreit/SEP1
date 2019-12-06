package model;

public class LoginModelManager implements LoginModel
{
  private boolean loggedIn;

  public LoginModelManager()
  {
    loggedIn = false;
  }

  @Override public void login(String user, String password)
  {
    validateLogin(user, password);
    loggedIn = true;
  }

  @Override public void validateLogin(String user, String password)
  {
    if (user == null || user.isEmpty())
    {
      throw new IllegalArgumentException("Username cannot be empty");
    }
    if (password == null || password.length() < 6)
    {
      throw new IllegalArgumentException(
          "Password must contain at least 6 characters");
    }
  }

  @Override public boolean isLoggedIn()
  {
    return loggedIn;
  }
}
