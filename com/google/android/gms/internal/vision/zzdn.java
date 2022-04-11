package com.google.android.gms.internal.vision;

final class zzdn<E>
  extends zzdk<E>
{
  static final zzdk<Object> zzmg = new zzdn(new Object[0], 0);
  private final transient int size;
  private final transient Object[] zzmh;
  
  zzdn(Object[] paramArrayOfObject, int paramInt)
  {
    this.zzmh = paramArrayOfObject;
    this.size = paramInt;
  }
  
  public final E get(int paramInt)
  {
    zzcy.zzd(paramInt, this.size);
    return (E)this.zzmh[paramInt];
  }
  
  public final int size()
  {
    return this.size;
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(this.zzmh, 0, paramArrayOfObject, paramInt, this.size);
    return paramInt + this.size;
  }
  
  final Object[] zzca()
  {
    return this.zzmh;
  }
  
  final int zzcb()
  {
    return 0;
  }
  
  final int zzcc()
  {
    return this.size;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */