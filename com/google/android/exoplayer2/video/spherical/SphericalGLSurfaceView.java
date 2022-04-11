package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.video.t;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class SphericalGLSurfaceView
  extends GLSurfaceView
{
  private boolean H3;
  private final CopyOnWriteArrayList<b> c = new CopyOnWriteArrayList();
  private final SensorManager d;
  @Nullable
  private final Sensor f;
  @Nullable
  private SurfaceTexture p0;
  @Nullable
  private Surface p1;
  private boolean p2;
  private boolean p3;
  private final g q;
  private final Handler x = new Handler(Looper.getMainLooper());
  private final l y;
  private final k z;
  
  public SphericalGLSurfaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SphericalGLSurfaceView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    SensorManager localSensorManager = (SensorManager)com.google.android.exoplayer2.util.g.e(paramContext.getSystemService("sensor"));
    this.d = localSensorManager;
    if (o0.a >= 18) {
      paramAttributeSet = localSensorManager.getDefaultSensor(15);
    } else {
      paramAttributeSet = null;
    }
    Object localObject = paramAttributeSet;
    if (paramAttributeSet == null) {
      localObject = localSensorManager.getDefaultSensor(11);
    }
    this.f = ((Sensor)localObject);
    paramAttributeSet = new k();
    this.z = paramAttributeSet;
    localObject = new a(paramAttributeSet);
    paramAttributeSet = new l(paramContext, (l.a)localObject, 25.0F);
    this.y = paramAttributeSet;
    this.q = new g(((WindowManager)com.google.android.exoplayer2.util.g.e((WindowManager)paramContext.getSystemService("window"))).getDefaultDisplay(), new g.a[] { paramAttributeSet, localObject });
    this.p2 = true;
    setEGLContextClientVersion(2);
    setRenderer((GLSurfaceView.Renderer)localObject);
    setOnTouchListener(paramAttributeSet);
  }
  
  private void g(SurfaceTexture paramSurfaceTexture)
  {
    this.x.post(new b(this, paramSurfaceTexture));
  }
  
  private static void h(@Nullable SurfaceTexture paramSurfaceTexture, @Nullable Surface paramSurface)
  {
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    if (paramSurface != null) {
      paramSurface.release();
    }
  }
  
  private void j()
  {
    boolean bool;
    if ((this.p2) && (this.p3)) {
      bool = true;
    } else {
      bool = false;
    }
    Sensor localSensor = this.f;
    if ((localSensor != null) && (bool != this.H3))
    {
      if (bool) {
        this.d.registerListener(this.q, localSensor, 0);
      } else {
        this.d.unregisterListener(this.q);
      }
      this.H3 = bool;
    }
  }
  
  public void b(b paramb)
  {
    this.c.add(paramb);
  }
  
  public d getCameraMotionListener()
  {
    return this.z;
  }
  
  public t getVideoFrameMetadataListener()
  {
    return this.z;
  }
  
  @Nullable
  public Surface getVideoSurface()
  {
    return this.p1;
  }
  
  public void i(b paramb)
  {
    this.c.remove(paramb);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.x.post(new c(this));
  }
  
  public void onPause()
  {
    this.p3 = false;
    j();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.p3 = true;
    j();
  }
  
  public void setDefaultStereoMode(int paramInt)
  {
    this.z.h(paramInt);
  }
  
  public void setUseSensorRotation(boolean paramBoolean)
  {
    this.p2 = paramBoolean;
    j();
  }
  
  @VisibleForTesting
  final class a
    implements GLSurfaceView.Renderer, l.a, g.a
  {
    private final k c;
    private final float[] d = new float[16];
    private final float[] f = new float[16];
    private float p0;
    private final float[] p1;
    private final float[] p2;
    private final float[] q;
    private final float[] x;
    private final float[] y;
    private float z;
    
    public a(k paramk)
    {
      float[] arrayOfFloat1 = new float[16];
      this.q = arrayOfFloat1;
      this$1 = new float[16];
      this.x = SphericalGLSurfaceView.this;
      float[] arrayOfFloat2 = new float[16];
      this.y = arrayOfFloat2;
      this.p1 = new float[16];
      this.p2 = new float[16];
      this.c = paramk;
      Matrix.setIdentityM(arrayOfFloat1, 0);
      Matrix.setIdentityM(SphericalGLSurfaceView.this, 0);
      Matrix.setIdentityM(arrayOfFloat2, 0);
      this.p0 = 3.1415927F;
    }
    
    private float c(float paramFloat)
    {
      int i;
      if (paramFloat > 1.0F) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return (float)(Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0D)) / paramFloat)) * 2.0D);
      }
      return 90.0F;
    }
    
    @AnyThread
    private void d()
    {
      Matrix.setRotateM(this.x, 0, -this.z, (float)Math.cos(this.p0), (float)Math.sin(this.p0), 0.0F);
    }
    
    @BinderThread
    public void a(float[] paramArrayOfFloat, float paramFloat)
    {
      try
      {
        float[] arrayOfFloat = this.q;
        System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, arrayOfFloat.length);
        this.p0 = (-paramFloat);
        d();
        return;
      }
      finally
      {
        paramArrayOfFloat = finally;
        throw paramArrayOfFloat;
      }
    }
    
    @UiThread
    public void b(PointF paramPointF)
    {
      try
      {
        this.z = paramPointF.y;
        d();
        Matrix.setRotateM(this.y, 0, -paramPointF.x, 0.0F, 1.0F, 0.0F);
        return;
      }
      finally
      {
        paramPointF = finally;
        throw paramPointF;
      }
    }
    
    public void onDrawFrame(GL10 paramGL10)
    {
      try
      {
        Matrix.multiplyMM(this.p2, 0, this.q, 0, this.y, 0);
        Matrix.multiplyMM(this.p1, 0, this.x, 0, this.p2, 0);
        Matrix.multiplyMM(this.f, 0, this.d, 0, this.p1, 0);
        this.c.b(this.f, false);
        return;
      }
      finally {}
    }
    
    @UiThread
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return SphericalGLSurfaceView.this.performClick();
    }
    
    public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
    {
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      float f1 = paramInt1 / paramInt2;
      float f2 = c(f1);
      Matrix.perspectiveM(this.d, 0, f2, f1, 0.1F, 100.0F);
    }
    
    public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
    {
      try
      {
        SphericalGLSurfaceView.a(SphericalGLSurfaceView.this, this.c.d());
        return;
      }
      finally
      {
        paramGL10 = finally;
        throw paramGL10;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void p(Surface paramSurface);
    
    public abstract void r(Surface paramSurface);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\spherical\SphericalGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */