package com.google.android.gms.internal.firebase_messaging;

import androidx.annotation.NonNull;
import java.io.OutputStream;

final class zzw
  extends OutputStream
{
  private long zza = 0L;
  
  public final void write(int paramInt)
  {
    this.zza += 1L;
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    this.zza += paramArrayOfByte.length;
  }
  
  public final void write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      int i = paramArrayOfByte.length;
      if ((paramInt1 <= i) && (paramInt2 >= 0))
      {
        paramInt1 += paramInt2;
        if ((paramInt1 <= i) && (paramInt1 >= 0))
        {
          this.zza += paramInt2;
          return;
        }
      }
    }
    throw new IndexOutOfBoundsException();
  }
  
  final long zza()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */