package com.google.android.gms.internal.vision;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzda
{
  public static String zza(@NullableDecl String paramString, @NullableDecl Object... paramVarArgs)
  {
    String str = String.valueOf(paramString);
    int i = 0;
    for (int j = 0; j < paramVarArgs.length; j++) {
      paramVarArgs[j] = zzd(paramVarArgs[j]);
    }
    paramString = new StringBuilder(str.length() + paramVarArgs.length * 16);
    int k = 0;
    for (j = i; j < paramVarArgs.length; j++)
    {
      i = str.indexOf("%s", k);
      if (i == -1) {
        break;
      }
      paramString.append(str, k, i);
      paramString.append(paramVarArgs[j]);
      k = i + 2;
    }
    paramString.append(str, k, str.length());
    if (j < paramVarArgs.length)
    {
      paramString.append(" [");
      k = j + 1;
      paramString.append(paramVarArgs[j]);
      for (j = k; j < paramVarArgs.length; j++)
      {
        paramString.append(", ");
        paramString.append(paramVarArgs[j]);
      }
      paramString.append(']');
    }
    return paramString.toString();
  }
  
  private static String zzd(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    try
    {
      String str1 = paramObject.toString();
      return str1;
    }
    catch (Exception localException)
    {
      String str3 = paramObject.getClass().getName();
      Object localObject = Integer.toHexString(System.identityHashCode(paramObject));
      paramObject = new StringBuilder(str3.length() + 1 + String.valueOf(localObject).length());
      ((StringBuilder)paramObject).append(str3);
      ((StringBuilder)paramObject).append('@');
      ((StringBuilder)paramObject).append((String)localObject);
      str3 = ((StringBuilder)paramObject).toString();
      Logger localLogger = Logger.getLogger("com.google.common.base.Strings");
      localObject = Level.WARNING;
      paramObject = String.valueOf(str3);
      if (((String)paramObject).length() != 0) {
        paramObject = "Exception during lenientFormat for ".concat((String)paramObject);
      } else {
        paramObject = new String("Exception during lenientFormat for ");
      }
      localLogger.logp((Level)localObject, "com.google.common.base.Strings", "lenientToString", (String)paramObject, localException);
      String str2 = localException.getClass().getName();
      paramObject = new StringBuilder(String.valueOf(str3).length() + 9 + str2.length());
      ((StringBuilder)paramObject).append("<");
      ((StringBuilder)paramObject).append(str3);
      ((StringBuilder)paramObject).append(" threw ");
      ((StringBuilder)paramObject).append(str2);
      ((StringBuilder)paramObject).append(">");
    }
    return ((StringBuilder)paramObject).toString();
  }
  
  public static String zzk(@NullableDecl String paramString)
  {
    return zzcu.zzk(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */