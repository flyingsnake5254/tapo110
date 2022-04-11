package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;

abstract interface zzix
{
  public abstract int getTag();
  
  public abstract double readDouble()
    throws IOException;
  
  public abstract float readFloat()
    throws IOException;
  
  public abstract String readString()
    throws IOException;
  
  public abstract void readStringList(List<String> paramList)
    throws IOException;
  
  public abstract <T> T zza(zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException;
  
  public abstract <T> T zza(Class<T> paramClass, zzgi paramzzgi)
    throws IOException;
  
  public abstract void zza(List<Double> paramList)
    throws IOException;
  
  public abstract <T> void zza(List<T> paramList, zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException;
  
  public abstract <K, V> void zza(Map<K, V> paramMap, zzhy<K, V> paramzzhy, zzgi paramzzgi)
    throws IOException;
  
  @Deprecated
  public abstract <T> T zzb(Class<T> paramClass, zzgi paramzzgi)
    throws IOException;
  
  public abstract void zzb(List<Float> paramList)
    throws IOException;
  
  @Deprecated
  public abstract <T> void zzb(List<T> paramList, zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException;
  
  @Deprecated
  public abstract <T> T zzc(zziw<T> paramzziw, zzgi paramzzgi)
    throws IOException;
  
  public abstract void zzc(List<Long> paramList)
    throws IOException;
  
  public abstract void zzd(List<Long> paramList)
    throws IOException;
  
  public abstract int zzdv()
    throws IOException;
  
  public abstract boolean zzdw()
    throws IOException;
  
  public abstract long zzdx()
    throws IOException;
  
  public abstract long zzdy()
    throws IOException;
  
  public abstract int zzdz()
    throws IOException;
  
  public abstract void zze(List<Integer> paramList)
    throws IOException;
  
  public abstract long zzea()
    throws IOException;
  
  public abstract int zzeb()
    throws IOException;
  
  public abstract boolean zzec()
    throws IOException;
  
  public abstract String zzed()
    throws IOException;
  
  public abstract zzfm zzee()
    throws IOException;
  
  public abstract int zzef()
    throws IOException;
  
  public abstract int zzeg()
    throws IOException;
  
  public abstract int zzeh()
    throws IOException;
  
  public abstract long zzei()
    throws IOException;
  
  public abstract int zzej()
    throws IOException;
  
  public abstract long zzek()
    throws IOException;
  
  public abstract void zzf(List<Long> paramList)
    throws IOException;
  
  public abstract void zzg(List<Integer> paramList)
    throws IOException;
  
  public abstract void zzh(List<Boolean> paramList)
    throws IOException;
  
  public abstract void zzi(List<String> paramList)
    throws IOException;
  
  public abstract void zzj(List<zzfm> paramList)
    throws IOException;
  
  public abstract void zzk(List<Integer> paramList)
    throws IOException;
  
  public abstract void zzl(List<Integer> paramList)
    throws IOException;
  
  public abstract void zzm(List<Integer> paramList)
    throws IOException;
  
  public abstract void zzn(List<Long> paramList)
    throws IOException;
  
  public abstract void zzo(List<Integer> paramList)
    throws IOException;
  
  public abstract void zzp(List<Long> paramList)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */