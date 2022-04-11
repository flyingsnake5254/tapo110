package com.tplink.libtpstreamconnectionsocket;

public class EncryptException
  extends Exception
{
  public static final String EMPTY_EXCEPTION = "psw is error";
  
  public EncryptException(String paramString)
  {
    super(paramString);
  }
  
  public EncryptException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public EncryptException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreamconnectionsocket\EncryptException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */