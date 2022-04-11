package com.google.firebase.messaging;

import java.util.Locale;

public final class SendException
  extends Exception
{
  public static final int ERROR_INVALID_PARAMETERS = 1;
  public static final int ERROR_SIZE = 2;
  public static final int ERROR_TOO_MANY_MESSAGES = 4;
  public static final int ERROR_TTL_EXCEEDED = 3;
  public static final int ERROR_UNKNOWN = 0;
  private final int errorCode = parseErrorCode(paramString);
  
  SendException(String paramString)
  {
    super(paramString);
  }
  
  private int parseErrorCode(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    paramString = paramString.toLowerCase(Locale.US);
    switch (paramString.hashCode())
    {
    default: 
      break;
    case -95047692: 
      if (paramString.equals("missing_to")) {
        i = 1;
      }
      break;
    case -617027085: 
      if (paramString.equals("messagetoobig")) {
        i = 2;
      }
      break;
    case -920906446: 
      if (paramString.equals("invalid_parameters")) {
        i = 0;
      }
      break;
    case -1290953729: 
      if (paramString.equals("toomanymessages")) {
        i = 4;
      }
      break;
    case -1743242157: 
      if (paramString.equals("service_not_available")) {
        i = 3;
      }
      break;
    }
    int i = -1;
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return 0;
          }
          return 4;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\SendException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */