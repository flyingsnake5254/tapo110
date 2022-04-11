package com.google.android.gms.internal.vision;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzcy
{
  public static void checkArgument(boolean paramBoolean, @NullableDecl Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  @NonNullDecl
  public static <T> T checkNotNull(@NonNullDecl T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  private static String zza(int paramInt1, int paramInt2, @NullableDecl String paramString)
  {
    if (paramInt1 < 0) {
      return zzda.zza("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 >= 0) {
      return zzda.zza("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    paramString = new StringBuilder(26);
    paramString.append("negative size: ");
    paramString.append(paramInt2);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public static void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 <= paramInt3)) {
      return;
    }
    String str;
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt3))
    {
      if ((paramInt2 >= 0) && (paramInt2 <= paramInt3)) {
        str = zzda.zza("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      } else {
        str = zza(paramInt2, paramInt3, "end index");
      }
    }
    else {
      str = zza(paramInt1, paramInt3, "start index");
    }
    throw new IndexOutOfBoundsException(str);
  }
  
  public static int zzd(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < paramInt2)) {
      return paramInt1;
    }
    Object localObject;
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0)
      {
        localObject = new StringBuilder(26);
        ((StringBuilder)localObject).append("negative size: ");
        ((StringBuilder)localObject).append(paramInt2);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      localObject = zzda.zza("%s (%s) must be less than size (%s)", new Object[] { "index", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    else
    {
      localObject = zzda.zza("%s (%s) must not be negative", new Object[] { "index", Integer.valueOf(paramInt1) });
    }
    throw new IndexOutOfBoundsException((String)localObject);
  }
  
  public static int zze(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2)) {
      return paramInt1;
    }
    throw new IndexOutOfBoundsException(zza(paramInt1, paramInt2, "index"));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzcy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */