package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzg
  extends zze
{
  private static final WeakReference<byte[]> zzw = new WeakReference(null);
  private WeakReference<byte[]> zzv = zzw;
  
  zzg(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  final byte[] getBytes()
  {
    try
    {
      Object localObject1 = (byte[])this.zzv.get();
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = zzd();
        localObject1 = new java/lang/ref/WeakReference;
        ((WeakReference)localObject1).<init>(localObject2);
        this.zzv = ((WeakReference)localObject1);
      }
      return (byte[])localObject2;
    }
    finally {}
  }
  
  protected abstract byte[] zzd();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */