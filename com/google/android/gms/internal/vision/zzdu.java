package com.google.android.gms.internal.vision;

final class zzdu
  extends zzdk<Object>
{
  private final transient int offset;
  private final transient int size;
  private final transient Object[] zzmk;
  
  zzdu(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    this.zzmk = paramArrayOfObject;
    this.offset = paramInt1;
    this.size = paramInt2;
  }
  
  public final Object get(int paramInt)
  {
    zzcy.zzd(paramInt, this.size);
    return this.zzmk[(paramInt * 2 + this.offset)];
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */