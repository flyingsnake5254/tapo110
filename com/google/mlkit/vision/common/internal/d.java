package com.google.mlkit.vision.common.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.Image.Plane;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import b.b.a.a.a.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.nio.ByteBuffer;

@KeepForSdk
public class d
{
  private static final GmsLogger a = new GmsLogger("MLKitImageUtils", "");
  private static d b = new d();
  
  @KeepForSdk
  public static d a()
  {
    return b;
  }
  
  @KeepForSdk
  public int b(@NonNull a parama)
  {
    return parama.d();
  }
  
  @TargetApi(19)
  @KeepForSdk
  public int c(@NonNull a parama)
  {
    int i = parama.d();
    int j = 0;
    if (i == -1)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        j = parama.b().getAllocationByteCount();
      } else {
        j = parama.b().getByteCount();
      }
    }
    else if ((parama.d() != 17) && (parama.d() != 842094169))
    {
      if (parama.d() == 35) {
        j = parama.f()[0].getBuffer().limit() * 3 / 2;
      }
    }
    else {
      j = parama.c().limit();
    }
    return j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\vision\common\internal\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */