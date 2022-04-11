package com.google.android.gms.internal.mlkit_common;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzh
{
  private static String zza(@NullableDecl Object paramObject)
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
      String str2 = paramObject.getClass().getName();
      paramObject = Integer.toHexString(System.identityHashCode(paramObject));
      Object localObject = new StringBuilder(str2.length() + 1 + String.valueOf(paramObject).length());
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append('@');
      ((StringBuilder)localObject).append((String)paramObject);
      str2 = ((StringBuilder)localObject).toString();
      Logger localLogger = Logger.getLogger("com.google.common.base.Strings");
      localObject = Level.WARNING;
      paramObject = String.valueOf(str2);
      if (((String)paramObject).length() != 0) {
        paramObject = "Exception during lenientFormat for ".concat((String)paramObject);
      } else {
        paramObject = new String("Exception during lenientFormat for ");
      }
      localLogger.logp((Level)localObject, "com.google.common.base.Strings", "lenientToString", (String)paramObject, localException);
      paramObject = localException.getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str2).length() + 9 + ((String)paramObject).length());
      localStringBuilder.append("<");
      localStringBuilder.append(str2);
      localStringBuilder.append(" threw ");
      localStringBuilder.append((String)paramObject);
      localStringBuilder.append(">");
      return localStringBuilder.toString();
    }
  }
  
  public static String zza(@NullableDecl String paramString)
  {
    return zze.zza(paramString);
  }
  
  public static String zza(@NullableDecl String paramString, @NullableDecl Object... paramVarArgs)
  {
    paramString = String.valueOf(paramString);
    int i = 0;
    for (int j = 0; j < paramVarArgs.length; j++) {
      paramVarArgs[j] = zza(paramVarArgs[j]);
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramVarArgs.length * 16);
    int k = 0;
    for (j = i; j < paramVarArgs.length; j++)
    {
      i = paramString.indexOf("%s", k);
      if (i == -1) {
        break;
      }
      localStringBuilder.append(paramString, k, i);
      localStringBuilder.append(paramVarArgs[j]);
      k = i + 2;
    }
    localStringBuilder.append(paramString, k, paramString.length());
    if (j < paramVarArgs.length)
    {
      localStringBuilder.append(" [");
      k = j + 1;
      localStringBuilder.append(paramVarArgs[j]);
      for (j = k; j < paramVarArgs.length; j++)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(paramVarArgs[j]);
      }
      localStringBuilder.append(']');
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\mlkit_common\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */