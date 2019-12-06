package model;

public interface  LoginModel
{
  public void login(String user, String password);
  public void validateLogin(String user, String password);
  public boolean isLoggedIn();
}