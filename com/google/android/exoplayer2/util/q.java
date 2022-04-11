package com.google.android.exoplayer2.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class q
{
  private static void a(int paramInt1, String paramString, int paramInt2)
  {
    paramInt1 = GLES20.glCreateShader(paramInt1);
    GLES20.glShaderSource(paramInt1, paramString);
    GLES20.glCompileShader(paramInt1);
    Object localObject = new int[1];
    localObject[0] = 0;
    GLES20.glGetShaderiv(paramInt1, 35713, (int[])localObject, 0);
    if (localObject[0] != 1)
    {
      String str = GLES20.glGetShaderInfoLog(paramInt1);
      localObject = new StringBuilder(String.valueOf(str).length() + 10 + String.valueOf(paramString).length());
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", source: ");
      ((StringBuilder)localObject).append(paramString);
      j(((StringBuilder)localObject).toString());
    }
    GLES20.glAttachShader(paramInt2, paramInt1);
    GLES20.glDeleteShader(paramInt1);
    b();
  }
  
  public static void b()
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      String str = String.valueOf(GLU.gluErrorString(i));
      if (str.length() != 0) {
        str = "glError ".concat(str);
      } else {
        str = new String("glError ");
      }
      u.c("GlUtil", str);
    }
  }
  
  public static int c(String paramString1, String paramString2)
  {
    int i = GLES20.glCreateProgram();
    b();
    a(35633, paramString1, i);
    a(35632, paramString2, i);
    GLES20.glLinkProgram(i);
    paramString1 = new int[1];
    paramString1[0] = 0;
    GLES20.glGetProgramiv(i, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      paramString1 = String.valueOf(GLES20.glGetProgramInfoLog(i));
      if (paramString1.length() != 0) {
        paramString1 = "Unable to link shader program: \n".concat(paramString1);
      } else {
        paramString1 = new String("Unable to link shader program: \n");
      }
      j(paramString1);
    }
    b();
    return i;
  }
  
  public static int d(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    return c(TextUtils.join("\n", paramArrayOfString1), TextUtils.join("\n", paramArrayOfString2));
  }
  
  public static FloatBuffer e(int paramInt)
  {
    return ByteBuffer.allocateDirect(paramInt * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  }
  
  public static FloatBuffer f(float[] paramArrayOfFloat)
  {
    return (FloatBuffer)e(paramArrayOfFloat.length).put(paramArrayOfFloat).flip();
  }
  
  public static int g()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, IntBuffer.wrap(arrayOfInt));
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameteri(36197, 10241, 9729);
    GLES20.glTexParameteri(36197, 10240, 9729);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    b();
    return arrayOfInt[0];
  }
  
  public static boolean h(Context paramContext)
  {
    int i = o0.a;
    boolean bool1 = false;
    if (i < 24) {
      return false;
    }
    if ((i < 26) && (("samsung".equals(o0.c)) || ("XT1650".equals(o0.d)))) {
      return false;
    }
    if ((i < 26) && (!paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
      return false;
    }
    paramContext = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      bool2 = bool1;
      if (paramContext.contains("EGL_EXT_protected_content")) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static boolean i()
  {
    int i = o0.a;
    boolean bool1 = false;
    if (i < 17) {
      return false;
    }
    String str = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
    boolean bool2 = bool1;
    if (str != null)
    {
      bool2 = bool1;
      if (str.contains("EGL_KHR_surfaceless_context")) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private static void j(String paramString)
  {
    u.c("GlUtil", paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */