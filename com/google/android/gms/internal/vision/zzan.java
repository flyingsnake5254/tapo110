package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzan
  extends zzs<zzad>
{
  private final zzam zzen;
  
  public zzan(Context paramContext, zzam paramzzam)
  {
    super(paramContext, "TextNativeHandle", "ocr");
    this.zzen = paramzzam;
    zzq();
  }
  
  public final zzah[] zza(Bitmap paramBitmap, zzu paramzzu, zzaj paramzzaj)
  {
    if (!isOperational()) {
      return new zzah[0];
    }
    try
    {
      paramBitmap = ObjectWrapper.wrap(paramBitmap);
      paramBitmap = ((zzad)zzq()).zza(paramBitmap, paramzzu, paramzzaj);
      return paramBitmap;
    }
    catch (RemoteException paramBitmap)
    {
      Log.e("TextNativeHandle", "Error calling native text recognizer", paramBitmap);
    }
    return new zzah[0];
  }
  
  protected final void zzo()
    throws RemoteException
  {
    ((zzad)zzq()).zzr();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */