package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class s
{
  public static boolean a(@NullableDecl String paramString)
  {
    return m.b(paramString);
  }
  
  public static String b(@NullableDecl String paramString, @NullableDecl Object... paramVarArgs)
  {
    String str = String.valueOf(paramString);
    int i = 0;
    if (paramVarArgs == null)
    {
      paramString = new Object[1];
      paramString[0] = "(Object[])null";
    }
    else
    {
      for (j = 0;; j++)
      {
        paramString = paramVarArgs;
        if (j >= paramVarArgs.length) {
          break;
        }
        paramVarArgs[j] = c(paramVarArgs[j]);
      }
    }
    paramVarArgs = new StringBuilder(str.length() + paramString.length * 16);
    int k = 0;
    for (int j = i; j < paramString.length; j++)
    {
      i = str.indexOf("%s", k);
      if (i == -1) {
        break;
      }
      paramVarArgs.append(str, k, i);
      paramVarArgs.append(paramString[j]);
      k = i + 2;
    }
    paramVarArgs.append(str, k, str.length());
    if (j < paramString.length)
    {
      paramVarArgs.append(" [");
      k = j + 1;
      paramVarArgs.append(paramString[j]);
      for (j = k; j < paramString.length; j++)
      {
        paramVarArgs.append(", ");
        paramVarArgs.append(paramString[j]);
      }
      paramVarArgs.append(']');
    }
    return paramVarArgs.toString();
  }
  
  private static String c(@NullableDecl Object paramObject)
  {
    try
    {
      String str = String.valueOf(paramObject);
      return str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramObject.getClass().getName());
      localStringBuilder.append('@');
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramObject)));
      paramObject = localStringBuilder.toString();
      Logger localLogger = Logger.getLogger("com.google.common.base.Strings");
      Level localLevel = Level.WARNING;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception during lenientFormat for ");
      localStringBuilder.append((String)paramObject);
      localLogger.log(localLevel, localStringBuilder.toString(), localException);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<");
      localStringBuilder.append((String)paramObject);
      localStringBuilder.append(" threw ");
      localStringBuilder.append(localException.getClass().getName());
      localStringBuilder.append(">");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */