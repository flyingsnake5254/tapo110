package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

public final class zzm
  extends zzs<zzl>
{
  private final zzk zzbs;
  
  public zzm(Context paramContext, zzk paramzzk)
  {
    super(paramContext, "BarcodeNativeHandle", "barcode");
    this.zzbs = paramzzk;
    zzq();
  }
  
  public final Barcode[] zza(Bitmap paramBitmap, zzu paramzzu)
  {
    if (!isOperational()) {
      return new Barcode[0];
    }
    try
    {
      paramBitmap = ObjectWrapper.wrap(paramBitmap);
      paramBitmap = ((zzl)zzq()).zzb(paramBitmap, paramzzu);
      return paramBitmap;
    }
    catch (RemoteException paramBitmap)
    {
      Log.e("BarcodeNativeHandle", "Error calling native barcode detector", paramBitmap);
    }
    return new Barcode[0];
  }
  
  public final Barcode[] zza(ByteBuffer paramByteBuffer, zzu paramzzu)
  {
    if (!isOperational()) {
      return new Barcode[0];
    }
    try
    {
      paramByteBuffer = ObjectWrapper.wrap(paramByteBuffer);
      paramByteBuffer = ((zzl)zzq()).zza(paramByteBuffer, paramzzu);
      return paramByteBuffer;
    }
    catch (RemoteException paramByteBuffer)
    {
      Log.e("BarcodeNativeHandle", "Error calling native barcode detector", paramByteBuffer);
    }
    return new Barcode[0];
  }
  
  protected final void zzo()
    throws RemoteException
  {
    if (isOperational()) {
      ((zzl)zzq()).zzn();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */