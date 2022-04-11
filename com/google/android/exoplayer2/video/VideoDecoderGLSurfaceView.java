package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.q;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class VideoDecoderGLSurfaceView
  extends GLSurfaceView
  implements s
{
  private final a c;
  
  public VideoDecoderGLSurfaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoDecoderGLSurfaceView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new a(this);
    this.c = paramContext;
    setPreserveEGLContextOnPause(true);
    setEGLContextClientVersion(2);
    setRenderer(paramContext);
    setRenderMode(0);
  }
  
  @Deprecated
  public s getVideoDecoderOutputBufferRenderer()
  {
    return this;
  }
  
  public void setOutputBuffer(r paramr)
  {
    this.c.a(paramr);
  }
  
  private static final class a
    implements GLSurfaceView.Renderer
  {
    private static final float[] c = { 1.164F, 1.164F, 1.164F, 0.0F, -0.392F, 2.017F, 1.596F, -0.813F, 0.0F };
    private static final float[] d = { 1.164F, 1.164F, 1.164F, 0.0F, -0.213F, 2.112F, 1.793F, -0.533F, 0.0F };
    private static final float[] f = { 1.168F, 1.168F, 1.168F, 0.0F, -0.188F, 2.148F, 1.683F, -0.652F, 0.0F };
    private static final String[] q = { "y_tex", "u_tex", "v_tex" };
    private static final FloatBuffer x = q.f(new float[] { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
    private final FloatBuffer[] H3;
    private int I3;
    private int J3;
    private r K3;
    private final int[] p0;
    private final int[] p1;
    private final int[] p2;
    private final AtomicReference<r> p3;
    private final GLSurfaceView y;
    private final int[] z;
    
    public a(GLSurfaceView paramGLSurfaceView)
    {
      this.y = paramGLSurfaceView;
      this.z = new int[3];
      this.p0 = new int[3];
      this.p1 = new int[3];
      this.p2 = new int[3];
      this.p3 = new AtomicReference();
      this.H3 = new FloatBuffer[3];
      for (int i = 0; i < 3; i++)
      {
        paramGLSurfaceView = this.p1;
        this.p2[i] = -1;
        paramGLSurfaceView[i] = -1;
      }
    }
    
    private void b()
    {
      int[] arrayOfInt = this.z;
      int i = 0;
      GLES20.glGenTextures(3, arrayOfInt, 0);
      while (i < 3)
      {
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.I3, q[i]), i);
        GLES20.glActiveTexture(33984 + i);
        GLES20.glBindTexture(3553, this.z[i]);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        i++;
      }
      q.b();
    }
    
    public void a(r paramr)
    {
      paramr = (r)this.p3.getAndSet(paramr);
      if (paramr != null) {
        paramr.n();
      }
      this.y.requestRender();
    }
    
    public void onDrawFrame(GL10 paramGL10)
    {
      r localr = (r)this.p3.getAndSet(null);
      if ((localr == null) && (this.K3 == null)) {
        return;
      }
      if (localr != null)
      {
        paramGL10 = this.K3;
        if (paramGL10 != null) {
          paramGL10.n();
        }
        this.K3 = localr;
      }
      localr = (r)g.e(this.K3);
      paramGL10 = d;
      int i = localr.p0;
      if (i != 1)
      {
        if (i == 3) {
          paramGL10 = f;
        }
      }
      else {
        paramGL10 = c;
      }
      GLES20.glUniformMatrix3fv(this.J3, 1, false, paramGL10, 0);
      paramGL10 = (int[])g.e(localr.z);
      Object localObject = (ByteBuffer[])g.e(localr.y);
      for (i = 0; i < 3; i++)
      {
        int j;
        if (i == 0) {
          j = localr.x;
        } else {
          j = (localr.x + 1) / 2;
        }
        GLES20.glActiveTexture(33984 + i);
        GLES20.glBindTexture(3553, this.z[i]);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glTexImage2D(3553, 0, 6409, paramGL10[i], j, 0, 6409, 5121, localObject[i]);
      }
      localObject = new int[3];
      localObject[0] = localr.q;
      i = (localObject[0] + 1) / 2;
      localObject[2] = i;
      localObject[1] = i;
      for (i = 0; i < 3; i++) {
        if ((this.p1[i] != localObject[i]) || (this.p2[i] != paramGL10[i]))
        {
          boolean bool;
          if (paramGL10[i] != 0) {
            bool = true;
          } else {
            bool = false;
          }
          g.g(bool);
          float f1 = localObject[i] / paramGL10[i];
          this.H3[i] = q.f(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, f1, 0.0F, f1, 1.0F });
          GLES20.glVertexAttribPointer(this.p0[i], 2, 5126, false, 0, this.H3[i]);
          this.p1[i] = localObject[i];
          this.p2[i] = paramGL10[i];
        }
      }
      GLES20.glClear(16384);
      GLES20.glDrawArrays(5, 0, 4);
      q.b();
    }
    
    public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
    {
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
    }
    
    public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
    {
      int i = q.c("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
      this.I3 = i;
      GLES20.glUseProgram(i);
      i = GLES20.glGetAttribLocation(this.I3, "in_pos");
      GLES20.glEnableVertexAttribArray(i);
      GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, x);
      this.p0[0] = GLES20.glGetAttribLocation(this.I3, "in_tc_y");
      GLES20.glEnableVertexAttribArray(this.p0[0]);
      this.p0[1] = GLES20.glGetAttribLocation(this.I3, "in_tc_u");
      GLES20.glEnableVertexAttribArray(this.p0[1]);
      this.p0[2] = GLES20.glGetAttribLocation(this.I3, "in_tc_v");
      GLES20.glEnableVertexAttribArray(this.p0[2]);
      q.b();
      this.J3 = GLES20.glGetUniformLocation(this.I3, "mColorConversion");
      q.b();
      b();
      q.b();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\VideoDecoderGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */