package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException
  extends Exception
{
  private final Intent mIntent;
  
  public UserRecoverableException(String paramString, Intent paramIntent)
  {
    super(paramString);
    this.mIntent = paramIntent;
  }
  
  public Intent getIntent()
  {
    return new Intent(this.mIntent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\UserRecoverableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */