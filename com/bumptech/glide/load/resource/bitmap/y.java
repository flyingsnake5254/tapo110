package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.util.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class y
{
  private static final Paint a = new Paint(6);
  private static final Paint b = new Paint(7);
  private static final Paint c;
  private static final Set<String> d;
  private static final Lock e;
  
  static
  {
    Object localObject = new HashSet(Arrays.asList(new String[] { "XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079" }));
    d = (Set)localObject;
    if (((Set)localObject).contains(Build.MODEL)) {
      localObject = new ReentrantLock();
    } else {
      localObject = new c();
    }
    e = (Lock)localObject;
    localObject = new Paint(7);
    c = (Paint)localObject;
    ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
  }
  
  private static void a(@NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2, Matrix paramMatrix)
  {
    Lock localLock = e;
    localLock.lock();
    try
    {
      Canvas localCanvas = new android/graphics/Canvas;
      localCanvas.<init>(paramBitmap2);
      localCanvas.drawBitmap(paramBitmap1, paramMatrix, a);
      d(localCanvas);
      localLock.unlock();
      return;
    }
    finally
    {
      e.unlock();
    }
  }
  
  public static Bitmap b(@NonNull e parame, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2)) {
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = 0.0F;
    float f2;
    float f3;
    if (i * paramInt2 > j * paramInt1)
    {
      f2 = paramInt2 / paramBitmap.getHeight();
      f1 = (paramInt1 - paramBitmap.getWidth() * f2) * 0.5F;
      f3 = 0.0F;
    }
    else
    {
      f2 = paramInt1 / paramBitmap.getWidth();
      f3 = (paramInt2 - paramBitmap.getHeight() * f2) * 0.5F;
    }
    localMatrix.setScale(f2, f2);
    localMatrix.postTranslate((int)(f1 + 0.5F), (int)(f3 + 0.5F));
    parame = parame.d(paramInt1, paramInt2, j(paramBitmap));
    p(paramBitmap, parame);
    a(paramBitmap, parame, localMatrix);
    return parame;
  }
  
  public static Bitmap c(@NonNull e parame, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() <= paramInt1) && (paramBitmap.getHeight() <= paramInt2))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
      }
      return paramBitmap;
    }
    if (Log.isLoggable("TransformationUtils", 2)) {
      Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
    }
    return e(parame, paramBitmap, paramInt1, paramInt2);
  }
  
  private static void d(Canvas paramCanvas)
  {
    paramCanvas.setBitmap(null);
  }
  
  public static Bitmap e(@NonNull e parame, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "requested target size matches input, returning input");
      }
      return paramBitmap;
    }
    float f = Math.min(paramInt1 / paramBitmap.getWidth(), paramInt2 / paramBitmap.getHeight());
    int i = Math.round(paramBitmap.getWidth() * f);
    int j = Math.round(paramBitmap.getHeight() * f);
    if ((paramBitmap.getWidth() == i) && (paramBitmap.getHeight() == j))
    {
      if (Log.isLoggable("TransformationUtils", 2)) {
        Log.v("TransformationUtils", "adjusted target size matches input, returning input");
      }
      return paramBitmap;
    }
    parame = parame.d((int)(paramBitmap.getWidth() * f), (int)(paramBitmap.getHeight() * f), j(paramBitmap));
    p(paramBitmap, parame);
    if (Log.isLoggable("TransformationUtils", 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramInt2);
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toFit:   ");
      ((StringBuilder)localObject).append(paramBitmap.getWidth());
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramBitmap.getHeight());
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toReuse: ");
      ((StringBuilder)localObject).append(parame.getWidth());
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(parame.getHeight());
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("minPct:   ");
      ((StringBuilder)localObject).append(f);
      Log.v("TransformationUtils", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(f, f);
    a(paramBitmap, parame, (Matrix)localObject);
    return parame;
  }
  
  private static Bitmap f(@NonNull e parame, @NonNull Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = g(paramBitmap);
    if (localConfig.equals(paramBitmap.getConfig())) {
      return paramBitmap;
    }
    parame = parame.d(paramBitmap.getWidth(), paramBitmap.getHeight(), localConfig);
    new Canvas(parame).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    return parame;
  }
  
  @NonNull
  private static Bitmap.Config g(@NonNull Bitmap paramBitmap)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Bitmap.Config.RGBA_F16.equals(paramBitmap.getConfig()))) {
      return Bitmap.Config.RGBA_F16;
    }
    return Bitmap.Config.ARGB_8888;
  }
  
  public static Lock h()
  {
    return e;
  }
  
  public static int i(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 0;
      break;
    case 7: 
    case 8: 
      paramInt = 270;
      break;
    case 5: 
    case 6: 
      paramInt = 90;
      break;
    case 3: 
    case 4: 
      paramInt = 180;
    }
    return paramInt;
  }
  
  @NonNull
  private static Bitmap.Config j(@NonNull Bitmap paramBitmap)
  {
    if (paramBitmap.getConfig() != null) {
      paramBitmap = paramBitmap.getConfig();
    } else {
      paramBitmap = Bitmap.Config.ARGB_8888;
    }
    return paramBitmap;
  }
  
  @VisibleForTesting
  static void k(int paramInt, Matrix paramMatrix)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 8: 
      paramMatrix.setRotate(-90.0F);
      break;
    case 7: 
      paramMatrix.setRotate(-90.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      break;
    case 6: 
      paramMatrix.setRotate(90.0F);
      break;
    case 5: 
      paramMatrix.setRotate(90.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      break;
    case 4: 
      paramMatrix.setRotate(180.0F);
      paramMatrix.postScale(-1.0F, 1.0F);
      break;
    case 3: 
      paramMatrix.setRotate(180.0F);
      break;
    case 2: 
      paramMatrix.setScale(-1.0F, 1.0F);
    }
  }
  
  public static boolean l(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static Bitmap m(@NonNull e parame, @NonNull Bitmap paramBitmap, int paramInt)
  {
    if (!l(paramInt)) {
      return paramBitmap;
    }
    Matrix localMatrix = new Matrix();
    k(paramInt, localMatrix);
    RectF localRectF = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    localMatrix.mapRect(localRectF);
    parame = parame.d(Math.round(localRectF.width()), Math.round(localRectF.height()), j(paramBitmap));
    localMatrix.postTranslate(-localRectF.left, -localRectF.top);
    parame.setHasAlpha(paramBitmap.hasAlpha());
    a(paramBitmap, parame, localMatrix);
    return parame;
  }
  
  public static Bitmap n(@NonNull e parame, @NonNull Bitmap paramBitmap, int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    i.a(bool, "roundingRadius must be greater than 0.");
    return o(parame, paramBitmap, new a(paramInt));
  }
  
  private static Bitmap o(@NonNull e parame, @NonNull Bitmap paramBitmap, b paramb)
  {
    Object localObject1 = g(paramBitmap);
    Bitmap localBitmap = f(parame, paramBitmap);
    localObject1 = parame.d(localBitmap.getWidth(), localBitmap.getHeight(), (Bitmap.Config)localObject1);
    ((Bitmap)localObject1).setHasAlpha(true);
    Object localObject2 = Shader.TileMode.CLAMP;
    Object localObject3 = new BitmapShader(localBitmap, (Shader.TileMode)localObject2, (Shader.TileMode)localObject2);
    localObject2 = new Paint();
    ((Paint)localObject2).setAntiAlias(true);
    ((Paint)localObject2).setShader((Shader)localObject3);
    RectF localRectF = new RectF(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
    Lock localLock = e;
    localLock.lock();
    try
    {
      localObject3 = new android/graphics/Canvas;
      ((Canvas)localObject3).<init>((Bitmap)localObject1);
      ((Canvas)localObject3).drawColor(0, PorterDuff.Mode.CLEAR);
      paramb.a((Canvas)localObject3, (Paint)localObject2, localRectF);
      d((Canvas)localObject3);
      localLock.unlock();
      if (!localBitmap.equals(paramBitmap)) {
        parame.c(localBitmap);
      }
      return (Bitmap)localObject1;
    }
    finally
    {
      e.unlock();
    }
  }
  
  public static void p(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    paramBitmap2.setHasAlpha(paramBitmap1.hasAlpha());
  }
  
  class a
    implements y.b
  {
    a() {}
    
    public void a(Canvas paramCanvas, Paint paramPaint, RectF paramRectF)
    {
      int i = this.a;
      paramCanvas.drawRoundRect(paramRectF, i, i, paramPaint);
    }
  }
  
  private static abstract interface b
  {
    public abstract void a(Canvas paramCanvas, Paint paramPaint, RectF paramRectF);
  }
  
  private static final class c
    implements Lock
  {
    public void lock() {}
    
    public void lockInterruptibly()
      throws InterruptedException
    {}
    
    @NonNull
    public Condition newCondition()
    {
      throw new UnsupportedOperationException("Should not be called");
    }
    
    public boolean tryLock()
    {
      return true;
    }
    
    public boolean tryLock(long paramLong, @NonNull TimeUnit paramTimeUnit)
      throws InterruptedException
    {
      return true;
    }
    
    public void unlock() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\resource\bitmap\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */