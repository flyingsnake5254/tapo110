package com.tplink.libtpstreamconnectionsocket;

public class UserEncryptException
  extends Exception
{
  public static final String EMPTY_EXCEPTION = "psw is error";
  
  public UserEncryptException(String paramString)
  {
    super(paramString);
  }
  
  public UserEncryptException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UserEncryptException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreamconnectionsocket\UserEncryptException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */