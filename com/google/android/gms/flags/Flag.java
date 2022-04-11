package com.google.android.gms.flags;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@Deprecated
@KeepForSdk
public abstract class Flag<T>
{
  private final String mKey;
  private final int zze;
  private final T zzf;
  
  private Flag(int paramInt, String paramString, T paramT)
  {
    this.zze = paramInt;
    this.mKey = paramString;
    this.zzf = paramT;
    Singletons.flagRegistry().zza(this);
  }
  
  @Deprecated
  @KeepForSdk
  public static BooleanFlag define(int paramInt, String paramString, Boolean paramBoolean)
  {
    return new BooleanFlag(paramInt, paramString, paramBoolean);
  }
  
  @Deprecated
  @KeepForSdk
  public static IntegerFlag define(int paramInt1, String paramString, int paramInt2)
  {
    return new IntegerFlag(paramInt1, paramString, Integer.valueOf(paramInt2));
  }
  
  @Deprecated
  @KeepForSdk
  public static LongFlag define(int paramInt, String paramString, long paramLong)
  {
    return new LongFlag(paramInt, paramString, Long.valueOf(paramLong));
  }
  
  @Deprecated
  @KeepForSdk
  public static StringFlag define(int paramInt, String paramString1, String paramString2)
  {
    return new StringFlag(paramInt, paramString1, paramString2);
  }
  
  @KeepForSdk
  public T get()
  {
    return (T)Singletons.zzd().zzb(this);
  }
  
  public final String getKey()
  {
    return this.mKey;
  }
  
  @Deprecated
  public final int getSource()
  {
    return this.zze;
  }
  
  protected abstract T zza(zzc paramzzc);
  
  public final T zzb()
  {
    return (T)this.zzf;
  }
  
  @Deprecated
  public static class BooleanFlag
    extends Flag<Boolean>
  {
    public BooleanFlag(int paramInt, String paramString, Boolean paramBoolean)
    {
      super(paramString, paramBoolean, null);
    }
    
    private final Boolean zzb(zzc paramzzc)
    {
      try
      {
        boolean bool = paramzzc.getBooleanFlagValue(getKey(), ((Boolean)zzb()).booleanValue(), getSource());
        return Boolean.valueOf(bool);
      }
      catch (RemoteException paramzzc) {}
      return (Boolean)zzb();
    }
  }
  
  @Deprecated
  @KeepForSdk
  public static class IntegerFlag
    extends Flag<Integer>
  {
    public IntegerFlag(int paramInt, String paramString, Integer paramInteger)
    {
      super(paramString, paramInteger, null);
    }
    
    private final Integer zzc(zzc paramzzc)
    {
      try
      {
        int i = paramzzc.getIntFlagValue(getKey(), ((Integer)zzb()).intValue(), getSource());
        return Integer.valueOf(i);
      }
      catch (RemoteException paramzzc) {}
      return (Integer)zzb();
    }
  }
  
  @Deprecated
  @KeepForSdk
  public static class LongFlag
    extends Flag<Long>
  {
    public LongFlag(int paramInt, String paramString, Long paramLong)
    {
      super(paramString, paramLong, null);
    }
    
    private final Long zzd(zzc paramzzc)
    {
      try
      {
        long l = paramzzc.getLongFlagValue(getKey(), ((Long)zzb()).longValue(), getSource());
        return Long.valueOf(l);
      }
      catch (RemoteException paramzzc) {}
      return (Long)zzb();
    }
  }
  
  @Deprecated
  @KeepForSdk
  public static class StringFlag
    extends Flag<String>
  {
    public StringFlag(int paramInt, String paramString1, String paramString2)
    {
      super(paramString1, paramString2, null);
    }
    
    private final String zze(zzc paramzzc)
    {
      try
      {
        paramzzc = paramzzc.getStringFlagValue(getKey(), (String)zzb(), getSource());
        return paramzzc;
      }
      catch (RemoteException paramzzc) {}
      return (String)zzb();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\flags\Flag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */