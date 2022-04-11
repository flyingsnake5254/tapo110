package com.tplink.iot.Utils.y0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.util.j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class f
  extends com.bumptech.glide.load.resource.bitmap.f
{
  private final float b;
  private final String c = "com. bumptech.glide.transformations.FillSpace";
  private final byte[] d = "com. bumptech.glide.transformations.FillSpace".getBytes(c.a);
  
  public f(int paramInt)
  {
    this.b = (Resources.getSystem().getDisplayMetrics().density * paramInt);
  }
  
  private Bitmap d(e parame, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap = parame.d(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    if (localBitmap == null) {
      return Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }
    parame = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    localPaint.setShader(new BitmapShader(paramBitmap, localTileMode, localTileMode));
    paramBitmap = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    float f = this.b;
    parame.drawRoundRect(paramBitmap, f, f, localPaint);
    return localBitmap;
  }
  
  public void b(@NonNull MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(this.d);
    paramMessageDigest.update(ByteBuffer.allocate(4).putInt((int)this.b).array());
  }
  
  protected Bitmap c(@NonNull e parame, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return d(parame, paramBitmap);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof f;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (f)paramObject;
      bool3 = bool2;
      if (this.b == ((f)paramObject).b) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    return j.o(-853012345, j.l(this.b));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\y0\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */