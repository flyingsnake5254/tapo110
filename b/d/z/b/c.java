package b.d.z.b;

import android.opengl.GLES20;
import b.d.p.d;
import com.google.android.exoplayer2.util.g;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public abstract class c
{
  private static final String a = "c";
  private static final float[] b = { 1.164F, 1.164F, 1.164F, 0.0F, -0.213F, 2.112F, 1.793F, -0.533F, 0.0F };
  protected final int c;
  protected final a d;
  protected int e;
  protected final int[] f;
  protected final FloatBuffer[] g;
  protected int h;
  protected int[] i;
  protected int[] j;
  protected int k;
  private boolean l = false;
  
  public c(int paramInt, a parama)
  {
    this.c = paramInt;
    this.d = parama;
    this.f = new int[paramInt];
    this.g = new FloatBuffer[paramInt];
    q();
  }
  
  private void a()
  {
    int m = f.c(l(), e());
    this.e = m;
    GLES20.glUseProgram(m);
    m = GLES20.glGetAttribLocation(this.e, g());
    GLES20.glEnableVertexAttribArray(m);
    GLES20.glVertexAttribPointer(m, 2, 5126, false, 0, j());
    for (m = 0; m < this.c; m++)
    {
      String str = h()[m];
      this.f[m] = GLES20.glGetAttribLocation(this.e, str);
      GLES20.glEnableVertexAttribArray(this.f[m]);
      f.b();
    }
    this.h = GLES20.glGetUniformLocation(this.e, d());
    this.k = GLES20.glGetUniformLocation(this.e, f());
    f.b();
    r();
    f.b();
  }
  
  private void c(YUVBuffer paramYUVBuffer)
  {
    if ((paramYUVBuffer.yuvStrides != null) && (paramYUVBuffer.yuvPlanes != null))
    {
      GLES20.glUniformMatrix3fv(this.h, 1, false, b, 0);
      int[] arrayOfInt = (int[])g.e(paramYUVBuffer.yuvStrides);
      ByteBuffer[] arrayOfByteBuffer = (ByteBuffer[])g.e(paramYUVBuffer.yuvPlanes);
      for (int m = 0; m < this.c; m++)
      {
        int n = k(m, arrayOfInt);
        int i1 = paramYUVBuffer.height;
        if (m != 0) {
          i1 = (i1 + 1) / 2;
        }
        GLES20.glActiveTexture(33984 + m);
        GLES20.glBindTexture(3553, o()[m]);
        GLES20.glPixelStorei(3317, 1);
        GLES20.glTexImage2D(3553, 0, n()[m], n, i1, 0, n()[m], 5121, arrayOfByteBuffer[m]);
      }
      paramYUVBuffer = m(paramYUVBuffer.width);
      for (m = 0; m < this.c; m++) {
        if ((this.i[m] != paramYUVBuffer[m]) || (this.j[m] != arrayOfInt[m]))
        {
          boolean bool;
          if (arrayOfInt[m] != 0) {
            bool = true;
          } else {
            bool = false;
          }
          g.g(bool);
          float f1 = paramYUVBuffer[m] / arrayOfInt[m];
          this.g[m] = f.e(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, f1, 0.0F, f1, 1.0F });
          GLES20.glVertexAttribPointer(this.f[m], 2, 5126, false, 0, this.g[m]);
          this.i[m] = paramYUVBuffer[m];
          this.j[m] = arrayOfInt[m];
        }
      }
      GLES20.glUniformMatrix4fv(this.k, 1, false, this.d.a(), 0);
      GLES20.glClear(16384);
      GLES20.glDrawArrays(5, 0, 4);
      f.b();
    }
  }
  
  private void r()
  {
    int m = this.c;
    int[] arrayOfInt = o();
    int n = 0;
    GLES20.glGenTextures(m, arrayOfInt, 0);
    while (n < this.c)
    {
      GLES20.glUniform1i(GLES20.glGetUniformLocation(this.e, i()[n]), n);
      GLES20.glActiveTexture(33984 + n);
      GLES20.glBindTexture(3553, o()[n]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      n++;
    }
    f.b();
  }
  
  public void b(YUVBuffer paramYUVBuffer)
  {
    if (this.l) {
      try
      {
        c(paramYUVBuffer);
      }
      catch (Exception localException)
      {
        String str = a;
        paramYUVBuffer = new StringBuilder();
        paramYUVBuffer.append("drawTextures:");
        paramYUVBuffer.append(localException.toString());
        d.c(str, paramYUVBuffer.toString());
      }
    }
  }
  
  protected abstract String d();
  
  protected abstract String e();
  
  protected abstract String f();
  
  protected abstract String g();
  
  protected abstract String[] h();
  
  protected abstract String[] i();
  
  protected abstract FloatBuffer j();
  
  protected abstract int k(int paramInt, int[] paramArrayOfInt);
  
  protected abstract String l();
  
  protected abstract int[] m(int paramInt);
  
  protected abstract int[] n();
  
  protected abstract int[] o();
  
  public void p()
  {
    a();
    this.l = true;
  }
  
  public void q()
  {
    int m = this.c;
    this.i = new int[m];
    this.j = new int[m];
    for (m = 0; m < this.c; m++)
    {
      int[] arrayOfInt = this.i;
      this.j[m] = -1;
      arrayOfInt[m] = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract float[] a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\z\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */