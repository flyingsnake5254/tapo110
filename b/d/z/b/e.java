package b.d.z.b;

import java.nio.FloatBuffer;

public class e
  extends c
{
  private static final String[] m = { "y_tex", "uv_tex" };
  private static final String[] n = { "in_tc_y", "in_tc_uv" };
  private static final FloatBuffer o = f.e(new float[] { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
  private static final int[] p = { 6409, 6410 };
  private final int[] q = new int[2];
  
  public e(c.a parama)
  {
    super(2, parama);
  }
  
  protected String d()
  {
    return "mColorConversion";
  }
  
  protected String e()
  {
    return "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_uv;\nuniform sampler2D y_tex;\nuniform sampler2D uv_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).x;\n  yuv.y = texture2D(uv_tex, interp_tc_uv).x - 0.5;\n  yuv.z = texture2D(uv_tex, interp_tc_uv).w - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";
  }
  
  protected String f()
  {
    return "uMVPMatrix";
  }
  
  protected String g()
  {
    return "in_pos";
  }
  
  protected String[] h()
  {
    return n;
  }
  
  protected String[] i()
  {
    return m;
  }
  
  protected FloatBuffer j()
  {
    return o;
  }
  
  protected int k(int paramInt, int[] paramArrayOfInt)
  {
    if ((paramInt >= 0) && (paramInt < this.c))
    {
      if (paramInt == 0) {
        paramInt = paramArrayOfInt[paramInt];
      } else {
        paramInt = (paramArrayOfInt[paramInt] + 1) / 2;
      }
      return paramInt;
    }
    return 0;
  }
  
  protected String l()
  {
    return "varying vec2 interp_tc_y;\nvarying vec2 interp_tc_uv;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_uv;\nuniform mat4 uMVPMatrix;\nvoid main() {\n  gl_Position = uMVPMatrix * in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_uv = in_tc_uv;\n}\n";
  }
  
  protected int[] m(int paramInt)
  {
    int[] arrayOfInt = new int[this.c];
    for (int i = 0; i < this.c; i++) {
      arrayOfInt[i] = paramInt;
    }
    return arrayOfInt;
  }
  
  protected int[] n()
  {
    return p;
  }
  
  protected int[] o()
  {
    return this.q;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\z\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */