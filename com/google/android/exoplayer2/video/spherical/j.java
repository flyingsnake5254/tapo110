package com.google.android.exoplayer2.video.spherical;

import android.opengl.GLES20;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.q;
import java.nio.FloatBuffer;

final class j
{
  private static final String[] a = { "uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}" };
  private static final String[] b = { "#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}" };
  private static final float[] c = { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F };
  private static final float[] d = { 1.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 1.0F };
  private static final float[] e = { 1.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 1.0F };
  private static final float[] f = { 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F };
  private static final float[] g = { 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.5F, 1.0F, 1.0F };
  private int h;
  @Nullable
  private a i;
  @Nullable
  private a j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  
  public static boolean c(h paramh)
  {
    h.a locala = paramh.a;
    paramh = paramh.b;
    int i1 = locala.b();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i1 == 1)
    {
      bool2 = bool1;
      if (locala.a(0).a == 0)
      {
        bool2 = bool1;
        if (paramh.b() == 1)
        {
          bool2 = bool1;
          if (paramh.a(0).a == 0) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  void a(int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    a locala;
    if (paramBoolean) {
      locala = this.j;
    } else {
      locala = this.i;
    }
    if (locala == null) {
      return;
    }
    GLES20.glUseProgram(this.k);
    q.b();
    GLES20.glEnableVertexAttribArray(this.n);
    GLES20.glEnableVertexAttribArray(this.o);
    q.b();
    int i1 = this.h;
    float[] arrayOfFloat;
    if (i1 == 1)
    {
      if (paramBoolean) {
        arrayOfFloat = e;
      } else {
        arrayOfFloat = d;
      }
    }
    else if (i1 == 2)
    {
      if (paramBoolean) {
        arrayOfFloat = g;
      } else {
        arrayOfFloat = f;
      }
    }
    else {
      arrayOfFloat = c;
    }
    GLES20.glUniformMatrix3fv(this.m, 1, false, arrayOfFloat, 0);
    GLES20.glUniformMatrix4fv(this.l, 1, false, paramArrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt);
    GLES20.glUniform1i(this.p, 0);
    q.b();
    GLES20.glVertexAttribPointer(this.n, 3, 5126, false, 12, a.a(locala));
    q.b();
    GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 8, a.b(locala));
    q.b();
    GLES20.glDrawArrays(a.c(locala), 0, a.d(locala));
    q.b();
    GLES20.glDisableVertexAttribArray(this.n);
    GLES20.glDisableVertexAttribArray(this.o);
  }
  
  void b()
  {
    int i1 = q.d(a, b);
    this.k = i1;
    this.l = GLES20.glGetUniformLocation(i1, "uMvpMatrix");
    this.m = GLES20.glGetUniformLocation(this.k, "uTexMatrix");
    this.n = GLES20.glGetAttribLocation(this.k, "aPosition");
    this.o = GLES20.glGetAttribLocation(this.k, "aTexCoords");
    this.p = GLES20.glGetUniformLocation(this.k, "uTexture");
  }
  
  public void d(h paramh)
  {
    if (!c(paramh)) {
      return;
    }
    this.h = paramh.c;
    a locala = new a(paramh.a.a(0));
    this.i = locala;
    if (paramh.d) {
      paramh = locala;
    } else {
      paramh = new a(paramh.b.a(0));
    }
    this.j = paramh;
  }
  
  private static class a
  {
    private final int a;
    private final FloatBuffer b;
    private final FloatBuffer c;
    private final int d;
    
    public a(h.b paramb)
    {
      this.a = paramb.a();
      this.b = q.f(paramb.c);
      this.c = q.f(paramb.d);
      int i = paramb.b;
      if (i != 1)
      {
        if (i != 2) {
          this.d = 4;
        } else {
          this.d = 6;
        }
      }
      else {
        this.d = 5;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\spherical\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */