package com.google.android.gms.internal.measurement;

final class zzls
  implements zzlf
{
  private final zzli zza;
  private final String zzb;
  private final Object[] zzc;
  private final int zzd;
  
  zzls(zzli paramzzli, String paramString, Object[] paramArrayOfObject)
  {
    this.zza = paramzzli;
    this.zzb = paramString;
    this.zzc = paramArrayOfObject;
    int i = 1;
    int j;
    char[] arrayOfChar;
    try
    {
      j = paramString.charAt(0);
    }
    catch (StringIndexOutOfBoundsException paramzzli)
    {
      arrayOfChar = paramString.toCharArray();
      paramArrayOfObject = new String(arrayOfChar);
      try
      {
        j = paramArrayOfObject.charAt(0);
        paramString = paramArrayOfObject;
      }
      catch (StringIndexOutOfBoundsException paramzzli) {}
    }
    try
    {
      paramzzli = new char[paramArrayOfObject.length()];
      paramArrayOfObject.getChars(0, paramArrayOfObject.length(), paramzzli, 0);
      paramString = new java/lang/String;
      paramString.<init>(paramzzli);
      try
      {
        j = paramString.charAt(0);
        if (j < 55296)
        {
          this.zzd = j;
          return;
        }
        int k = j & 0x1FFF;
        int m = 13;
        j = i;
        i = m;
        for (;;)
        {
          m = paramString.charAt(j);
          if (m < 55296) {
            break;
          }
          k |= (m & 0x1FFF) << i;
          i += 13;
          j++;
        }
        this.zzd = (m << i | k);
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramzzli) {}catch (StringIndexOutOfBoundsException paramzzli) {}
      paramArrayOfObject = paramString;
    }
    catch (ArrayIndexOutOfBoundsException paramzzli) {}catch (StringIndexOutOfBoundsException paramzzli) {}
    throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", new Object[] { paramArrayOfObject, Integer.valueOf(arrayOfChar.length) }), paramzzli);
  }
  
  public final boolean zza()
  {
    return (this.zzd & 0x2) == 2;
  }
  
  public final zzli zzb()
  {
    return this.zza;
  }
  
  public final int zzc()
  {
    if ((this.zzd & 0x1) == 1) {
      return 1;
    }
    return 2;
  }
  
  final String zzd()
  {
    return this.zzb;
  }
  
  final Object[] zze()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */