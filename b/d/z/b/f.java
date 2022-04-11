package b.d.z.b;

import android.opengl.GLES20;
import android.opengl.GLU;
import com.google.android.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class f
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(GLES20.glGetShaderInfoLog(paramInt1));
      ((StringBuilder)localObject).append(", source: ");
      ((StringBuilder)localObject).append(paramString);
      f(((StringBuilder)localObject).toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("glError ");
      localStringBuilder.append(GLU.gluErrorString(i));
      u.c("GlUtil", localStringBuilder.toString());
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
      paramString1 = new StringBuilder();
      paramString1.append("Unable to link shader program: \n");
      paramString1.append(GLES20.glGetProgramInfoLog(i));
      f(paramString1.toString());
    }
    b();
    return i;
  }
  
  public static FloatBuffer d(int paramInt)
  {
    return ByteBuffer.allocateDirect(paramInt * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  }
  
  public static FloatBuffer e(float[] paramArrayOfFloat)
  {
    return (FloatBuffer)d(paramArrayOfFloat.length).put(paramArrayOfFloat).flip();
  }
  
  private static void f(String paramString)
  {
    u.c("GlUtil", paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\z\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */