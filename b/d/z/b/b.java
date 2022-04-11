package b.d.z.b;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import javax.microedition.khronos.opengles.GL10;

public abstract class b
  implements GLSurfaceView.Renderer
{
  protected int H3 = 16;
  protected int I3 = 9;
  private boolean J3 = false;
  private boolean K3 = false;
  private final float[] L3 = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private final float[] M3 = new float[16];
  private final float[] N3 = new float[16];
  protected int O3;
  protected h P3;
  protected g c;
  protected boolean d;
  protected boolean f = false;
  private float p0 = 0.0F;
  private float p1 = 0.0F;
  protected int p2;
  protected int p3;
  protected String q = null;
  private float x = 1.0F;
  protected float y = 1.0F;
  protected float z = 1.0F;
  
  private void j()
  {
    Matrix.setIdentityM(this.L3, 0);
    int i = this.p2;
    int j = this.I3;
    int k = this.p3;
    int m = this.H3;
    int n;
    if (i * j >= k * m) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0)
    {
      this.y = (k * m / (i * j));
      this.z = 1.0F;
    }
    else
    {
      this.y = 1.0F;
      this.z = (i * j / (k * m));
    }
    if ((this.J3) && (Math.abs(this.p0) > g()))
    {
      if (this.p0 > 0.0F) {
        f1 = g();
      } else {
        f1 = -g();
      }
      this.p0 = f1;
    }
    if ((this.K3) && (Math.abs(this.p1) > d()))
    {
      if (this.p1 > 0.0F) {
        f1 = d();
      } else {
        f1 = -d();
      }
      this.p1 = f1;
    }
    Matrix.translateM(this.L3, 0, this.p0, this.p1, 0.0F);
    Matrix.scaleM(this.L3, 0, this.y, this.z, 1.0F);
    float[] arrayOfFloat = this.L3;
    float f1 = this.x;
    Matrix.scaleM(arrayOfFloat, 0, f1, f1, 0.0F);
  }
  
  protected abstract void b();
  
  public void c(String paramString)
  {
    this.d = true;
    this.q = paramString;
    b();
  }
  
  public float d()
  {
    float f1 = this.x - 1.0F - (1.0F - e()) * this.x;
    float f2 = f1;
    if (f1 < 0.0F) {
      f2 = 0.0F;
    }
    return f2;
  }
  
  public float e()
  {
    return this.z;
  }
  
  protected float[] f()
  {
    float[] arrayOfFloat = new float[16];
    Matrix.multiplyMM(arrayOfFloat, 0, this.N3, 0, this.L3, 0);
    Matrix.multiplyMM(arrayOfFloat, 0, this.M3, 0, arrayOfFloat, 0);
    return arrayOfFloat;
  }
  
  public float g()
  {
    float f1 = this.x - 1.0F - (1.0F - h()) * this.x;
    float f2 = f1;
    if (f1 < 0.0F) {
      f2 = 0.0F;
    }
    return f2;
  }
  
  public float h()
  {
    return this.y;
  }
  
  public void i()
  {
    k(1.0F);
  }
  
  public void k(float paramFloat)
  {
    this.x = paramFloat;
    this.p0 = 0.0F;
    this.p1 = 0.0F;
    j();
  }
  
  public void l(g paramg)
  {
    this.c = paramg;
  }
  
  public abstract void m(YUVBuffer paramYUVBuffer);
  
  public void n(h paramh)
  {
    this.P3 = paramh;
  }
  
  public void o(String paramString)
  {
    this.f = true;
    this.q = paramString;
    b();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if ((this.p2 != paramInt1) && (this.p3 != paramInt2))
    {
      int i = this.I3;
      int j = this.H3;
      boolean bool1 = true;
      boolean bool2;
      if (paramInt1 * i > paramInt2 * j) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.J3 = bool2;
      if (i * paramInt1 < paramInt2 * j) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      this.K3 = bool2;
    }
    this.p2 = paramInt1;
    this.p3 = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    Matrix.frustumM(this.M3, 0, -1.0F, 1.0F, -1.0F, 1.0F, 80.0F, 90.0F);
    Matrix.setLookAtM(this.N3, 0, 0.0F, 0.0F, 80.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    j();
  }
  
  public void p(float paramFloat1, float paramFloat2)
  {
    this.p0 = paramFloat1;
    this.p1 = paramFloat2;
    j();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\z\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */