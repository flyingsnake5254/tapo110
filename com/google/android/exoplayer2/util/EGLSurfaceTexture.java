package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(17)
public final class EGLSurfaceTexture
  implements SurfaceTexture.OnFrameAvailableListener, Runnable
{
  private static final int[] c = { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344 };
  private final Handler d;
  private final int[] f;
  @Nullable
  private SurfaceTexture p0;
  @Nullable
  private final b q;
  @Nullable
  private EGLDisplay x;
  @Nullable
  private EGLContext y;
  @Nullable
  private EGLSurface z;
  
  public EGLSurfaceTexture(Handler paramHandler)
  {
    this(paramHandler, null);
  }
  
  public EGLSurfaceTexture(Handler paramHandler, @Nullable b paramb)
  {
    this.d = paramHandler;
    this.q = paramb;
    this.f = new int[1];
  }
  
  private static EGLConfig a(EGLDisplay paramEGLDisplay)
  {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    boolean bool = EGL14.eglChooseConfig(paramEGLDisplay, c, 0, arrayOfEGLConfig, 0, 1, arrayOfInt, 0);
    if ((bool) && (arrayOfInt[0] > 0) && (arrayOfEGLConfig[0] != null)) {
      return arrayOfEGLConfig[0];
    }
    throw new GlException(o0.A("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(arrayOfInt[0]), arrayOfEGLConfig[0] }), null);
  }
  
  private static EGLContext b(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
  {
    int[] arrayOfInt;
    if (paramInt == 0)
    {
      arrayOfInt = new int[3];
      int[] tmp9_8 = arrayOfInt;
      tmp9_8[0] = '゘';
      int[] tmp15_9 = tmp9_8;
      tmp15_9[1] = 2;
      int[] tmp19_15 = tmp15_9;
      tmp19_15[2] = '〸';
      tmp19_15;
    }
    else
    {
      arrayOfInt = new int[5];
      int[] tmp34_33 = arrayOfInt;
      tmp34_33[0] = '゘';
      int[] tmp40_34 = tmp34_33;
      tmp40_34[1] = 2;
      int[] tmp44_40 = tmp40_34;
      tmp44_40[2] = '㋀';
      int[] tmp50_44 = tmp44_40;
      tmp50_44[3] = 1;
      int[] tmp54_50 = tmp50_44;
      tmp54_50[4] = '〸';
      tmp54_50;
    }
    paramEGLDisplay = EGL14.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL14.EGL_NO_CONTEXT, arrayOfInt, 0);
    if (paramEGLDisplay != null) {
      return paramEGLDisplay;
    }
    throw new GlException("eglCreateContext failed", null);
  }
  
  private static EGLSurface c(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, int paramInt)
  {
    if (paramInt == 1)
    {
      paramEGLConfig = EGL14.EGL_NO_SURFACE;
    }
    else
    {
      int[] arrayOfInt;
      if (paramInt == 2)
      {
        arrayOfInt = new int[7];
        int[] tmp25_23 = arrayOfInt;
        tmp25_23[0] = 'し';
        int[] tmp31_25 = tmp25_23;
        tmp31_25[1] = 1;
        int[] tmp35_31 = tmp31_25;
        tmp35_31[2] = 'ざ';
        int[] tmp41_35 = tmp35_31;
        tmp41_35[3] = 1;
        int[] tmp45_41 = tmp41_35;
        tmp45_41[4] = '㋀';
        int[] tmp51_45 = tmp45_41;
        tmp51_45[5] = 1;
        int[] tmp55_51 = tmp51_45;
        tmp55_51[6] = '〸';
        tmp55_51;
      }
      else
      {
        arrayOfInt = new int[5];
        int[] tmp73_71 = arrayOfInt;
        tmp73_71[0] = 'し';
        int[] tmp79_73 = tmp73_71;
        tmp79_73[1] = 1;
        int[] tmp83_79 = tmp79_73;
        tmp83_79[2] = 'ざ';
        int[] tmp89_83 = tmp83_79;
        tmp89_83[3] = 1;
        int[] tmp93_89 = tmp89_83;
        tmp93_89[4] = '〸';
        tmp93_89;
      }
      paramEGLConfig = EGL14.eglCreatePbufferSurface(paramEGLDisplay, paramEGLConfig, arrayOfInt, 0);
      if (paramEGLConfig == null) {
        break label136;
      }
    }
    if (EGL14.eglMakeCurrent(paramEGLDisplay, paramEGLConfig, paramEGLConfig, paramEGLContext)) {
      return paramEGLConfig;
    }
    throw new GlException("eglMakeCurrent failed", null);
    label136:
    throw new GlException("eglCreatePbufferSurface failed", null);
  }
  
  private void d()
  {
    b localb = this.q;
    if (localb != null) {
      localb.a();
    }
  }
  
  private static void e(int[] paramArrayOfInt)
  {
    GLES20.glGenTextures(1, paramArrayOfInt, 0);
    q.b();
  }
  
  private static EGLDisplay f()
  {
    EGLDisplay localEGLDisplay = EGL14.eglGetDisplay(0);
    if (localEGLDisplay != null)
    {
      int[] arrayOfInt = new int[2];
      if (EGL14.eglInitialize(localEGLDisplay, arrayOfInt, 0, arrayOfInt, 1)) {
        return localEGLDisplay;
      }
      throw new GlException("eglInitialize failed", null);
    }
    throw new GlException("eglGetDisplay failed", null);
  }
  
  public SurfaceTexture g()
  {
    return (SurfaceTexture)g.e(this.p0);
  }
  
  public void h(int paramInt)
  {
    Object localObject = f();
    this.x = ((EGLDisplay)localObject);
    localObject = a((EGLDisplay)localObject);
    EGLContext localEGLContext = b(this.x, (EGLConfig)localObject, paramInt);
    this.y = localEGLContext;
    this.z = c(this.x, (EGLConfig)localObject, localEGLContext, paramInt);
    e(this.f);
    localObject = new SurfaceTexture(this.f[0]);
    this.p0 = ((SurfaceTexture)localObject);
    ((SurfaceTexture)localObject).setOnFrameAvailableListener(this);
  }
  
  public void i()
  {
    this.d.removeCallbacks(this);
    try
    {
      Object localObject1 = this.p0;
      if (localObject1 != null)
      {
        ((SurfaceTexture)localObject1).release();
        GLES20.glDeleteTextures(1, this.f, 0);
      }
      return;
    }
    finally
    {
      Object localObject3 = this.x;
      if ((localObject3 != null) && (!((EGLDisplay)localObject3).equals(EGL14.EGL_NO_DISPLAY)))
      {
        localObject3 = this.x;
        EGLSurface localEGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent((EGLDisplay)localObject3, localEGLSurface, localEGLSurface, EGL14.EGL_NO_CONTEXT);
      }
      localObject3 = this.z;
      if ((localObject3 != null) && (!((EGLSurface)localObject3).equals(EGL14.EGL_NO_SURFACE))) {
        EGL14.eglDestroySurface(this.x, this.z);
      }
      localObject3 = this.y;
      if (localObject3 != null) {
        EGL14.eglDestroyContext(this.x, (EGLContext)localObject3);
      }
      if (o0.a >= 19) {
        EGL14.eglReleaseThread();
      }
      localObject3 = this.x;
      if ((localObject3 != null) && (!((EGLDisplay)localObject3).equals(EGL14.EGL_NO_DISPLAY))) {
        EGL14.eglTerminate(this.x);
      }
      this.x = null;
      this.y = null;
      this.z = null;
      this.p0 = null;
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.d.post(this);
  }
  
  public void run()
  {
    d();
    SurfaceTexture localSurfaceTexture = this.p0;
    if (localSurfaceTexture != null) {}
    try
    {
      localSurfaceTexture.updateTexImage();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;) {}
    }
  }
  
  public static final class GlException
    extends RuntimeException
  {
    private GlException(String paramString)
    {
      super();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\EGLSurfaceTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */