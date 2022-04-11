package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzaf
{
  public static final zzaf zza = new zzaf(null, null);
  private final Boolean zzb;
  private final Boolean zzc;
  
  public zzaf(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    this.zzb = paramBoolean1;
    this.zzc = paramBoolean2;
  }
  
  public static String zza(Bundle paramBundle)
  {
    String str = paramBundle.getString("ad_storage");
    if ((str != null) && (zzo(str) == null)) {
      return str;
    }
    paramBundle = paramBundle.getString("analytics_storage");
    if ((paramBundle != null) && (zzo(paramBundle) == null)) {
      return paramBundle;
    }
    return null;
  }
  
  public static zzaf zzb(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return zza;
    }
    return new zzaf(zzo(paramBundle.getString("ad_storage")), zzo(paramBundle.getString("analytics_storage")));
  }
  
  public static zzaf zzc(String paramString)
  {
    Boolean localBoolean1 = null;
    Boolean localBoolean2 = null;
    if (paramString != null)
    {
      if (paramString.length() >= 3) {
        localBoolean1 = zzp(paramString.charAt(2));
      } else {
        localBoolean1 = null;
      }
      if (paramString.length() >= 4) {
        localBoolean2 = zzp(paramString.charAt(3));
      }
      paramString = localBoolean1;
    }
    else
    {
      localBoolean2 = null;
      paramString = localBoolean1;
    }
    return new zzaf(paramString, localBoolean2);
  }
  
  static Boolean zzj(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if (paramBoolean1 == null) {
      return paramBoolean2;
    }
    if (paramBoolean2 == null) {
      return paramBoolean1;
    }
    boolean bool1 = paramBoolean1.booleanValue();
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      bool3 = bool2;
      if (paramBoolean2.booleanValue()) {
        bool3 = true;
      }
    }
    return Boolean.valueOf(bool3);
  }
  
  public static boolean zzm(int paramInt1, int paramInt2)
  {
    return paramInt1 <= paramInt2;
  }
  
  static final int zzn(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return 0;
    }
    if (paramBoolean.booleanValue()) {
      return 1;
    }
    return 2;
  }
  
  private static Boolean zzo(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.equals("granted")) {
      return Boolean.TRUE;
    }
    if (paramString.equals("denied")) {
      return Boolean.FALSE;
    }
    return null;
  }
  
  private static Boolean zzp(char paramChar)
  {
    if (paramChar != '0')
    {
      if (paramChar != '1') {
        return null;
      }
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  private static final char zzq(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return '-';
    }
    if (paramBoolean.booleanValue()) {
      return '1';
    }
    return '0';
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzaf)) {
      return false;
    }
    paramObject = (zzaf)paramObject;
    return (zzn(this.zzb) == zzn(((zzaf)paramObject).zzb)) && (zzn(this.zzc) == zzn(((zzaf)paramObject).zzc));
  }
  
  public final int hashCode()
  {
    return (zzn(this.zzb) + 527) * 31 + zzn(this.zzc);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConsentSettings: ");
    localStringBuilder.append("adStorage=");
    Object localObject = this.zzb;
    String str = "denied";
    if (localObject == null)
    {
      localStringBuilder.append("uninitialized");
    }
    else
    {
      if (true != ((Boolean)localObject).booleanValue()) {
        localObject = "denied";
      } else {
        localObject = "granted";
      }
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append(", analyticsStorage=");
    localObject = this.zzc;
    if (localObject == null)
    {
      localStringBuilder.append("uninitialized");
    }
    else
    {
      if (true != ((Boolean)localObject).booleanValue()) {
        localObject = str;
      } else {
        localObject = "granted";
      }
      localStringBuilder.append((String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public final String zzd()
  {
    StringBuilder localStringBuilder = new StringBuilder("G1");
    localStringBuilder.append(zzq(this.zzb));
    localStringBuilder.append(zzq(this.zzc));
    return localStringBuilder.toString();
  }
  
  public final Boolean zze()
  {
    return this.zzb;
  }
  
  public final boolean zzf()
  {
    Boolean localBoolean = this.zzb;
    return (localBoolean == null) || (localBoolean.booleanValue());
  }
  
  public final Boolean zzg()
  {
    return this.zzc;
  }
  
  public final boolean zzh()
  {
    Boolean localBoolean = this.zzc;
    return (localBoolean == null) || (localBoolean.booleanValue());
  }
  
  public final boolean zzi(zzaf paramzzaf)
  {
    Boolean localBoolean1 = this.zzb;
    Boolean localBoolean2 = Boolean.FALSE;
    boolean bool1 = true;
    boolean bool2;
    if (localBoolean1 == localBoolean2)
    {
      bool2 = bool1;
      if (paramzzaf.zzb != localBoolean2) {}
    }
    else if (this.zzc == localBoolean2)
    {
      if (paramzzaf.zzc != localBoolean2) {
        bool2 = bool1;
      } else {
        return false;
      }
    }
    else
    {
      bool2 = false;
    }
    return bool2;
  }
  
  public final zzaf zzk(zzaf paramzzaf)
  {
    return new zzaf(zzj(this.zzb, paramzzaf.zzb), zzj(this.zzc, paramzzaf.zzc));
  }
  
  public final zzaf zzl(zzaf paramzzaf)
  {
    Object localObject1 = this.zzb;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramzzaf.zzb;
    }
    Boolean localBoolean = this.zzc;
    localObject1 = localBoolean;
    if (localBoolean == null) {
      localObject1 = paramzzaf.zzc;
    }
    return new zzaf((Boolean)localObject2, (Boolean)localObject1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */