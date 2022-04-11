package com.tplink.libtpvideorender.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.ViewGroup;
import b.d.p.d;
import b.d.z.b.b;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;

public class GLSurfaceViewGPU
  extends GLSurfaceView
{
  private final String c = GLSurfaceViewGPU.class.getSimpleName();
  protected b d;
  protected String f;
  
  public GLSurfaceViewGPU(Context paramContext)
  {
    super(paramContext);
  }
  
  public GLSurfaceViewGPU(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    paramViewGroup.removeView(this);
  }
  
  public void b()
  {
    SurfaceHolder localSurfaceHolder = getHolder();
    localSurfaceHolder.addCallback(this);
    localSurfaceHolder.setFormat(-3);
  }
  
  public void setDeviceIdMD5(String paramString)
  {
    this.f = paramString;
  }
  
  public void setGlRenderer(b paramb)
  {
    if (this.d == null)
    {
      this.d = paramb;
      setEGLContextClientVersion(2);
      getHolder().removeCallback(this);
      setRenderer(paramb);
      setPreserveEGLContextOnPause(true);
      setRenderMode(0);
      d.a(this.c, "GLSurfaceViewGPU 调用 setRenderer()");
    }
  }
  
  public void setOutputBuffer(YUVBuffer paramYUVBuffer)
  {
    this.d.m(paramYUVBuffer);
    requestRender();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpvideorender\view\GLSurfaceViewGPU.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */