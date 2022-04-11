package com.tplink.ssh2;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class f0
  implements UserInfo, UIKeyboardInteractive
{
  private String a = "";
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String getPassphrase()
  {
    return null;
  }
  
  public String getPassword()
  {
    return this.a;
  }
  
  public String[] promptKeyboardInteractive(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    return null;
  }
  
  public boolean promptPassphrase(String paramString)
  {
    return true;
  }
  
  public boolean promptPassword(String paramString)
  {
    return true;
  }
  
  public boolean promptYesNo(String paramString)
  {
    return true;
  }
  
  public void showMessage(String paramString) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ssh2\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */