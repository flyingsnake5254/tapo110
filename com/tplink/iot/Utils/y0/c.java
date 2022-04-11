package com.tplink.iot.Utils.y0;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.resource.bitmap.f;
import java.security.MessageDigest;

public class c
  extends f
{
  private final String b = c.class.getName();
  
  private static Bitmap d(e parame, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - i) / 2, (paramBitmap.getHeight() - i) / 2, i, i);
    paramBitmap = parame.d(i, i, Bitmap.Config.ARGB_8888);
    parame = paramBitmap;
    if (paramBitmap == null) {
      parame = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    }
    paramBitmap = new Canvas(parame);
    Paint localPaint = new Paint();
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    localPaint.setShader(new BitmapShader(localBitmap, localTileMode, localTileMode));
    localPaint.setAntiAlias(true);
    float f = i / 2.0F;
    paramBitmap.drawCircle(f, f, f, localPaint);
    return parame;
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(this.b.getBytes(com.bumptech.glide.load.c.a));
  }
  
  protected Bitmap c(e parame, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return d(parame, paramBitmap);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\y0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */