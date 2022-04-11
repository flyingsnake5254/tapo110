package com.jcraft.jsch;

public abstract interface UserInfo
{
  public abstract String getPassphrase();
  
  public abstract String getPassword();
  
  public abstract boolean promptPassphrase(String paramString);
  
  public abstract boolean promptPassword(String paramString);
  
  public abstract boolean promptYesNo(String paramString);
  
  public abstract void showMessage(String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */