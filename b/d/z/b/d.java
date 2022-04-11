package b.d.z.b;

import java.nio.FloatBuffer;

public class d
  extends c
{
  private static final String[] m = { "y_tex", "u_tex", "v_tex" };
  private static final String[] n = { "in_tc_y", "in_tc_u", "in_tc_v" };
  private static final FloatBuffer o = f.e(new float[] { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
  private static final int[] p = { 6409, 6409, 6409 };
  protected final int[] q = new int[3];
  
  public d(c.a parama)
  {
    super(3, parama);
  }
  
  protected String d()
  {
    return "mColorConversion";
  }
  
  protected String e()
  {
    return "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).x - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).x - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).x - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";
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
    if ((paramInt >= 0) && (paramInt < this.c)) {
      return paramArrayOfInt[paramInt];
    }
    return 0;
  }
  
  protected String l()
  {
    return "varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nuniform mat4 uMVPMatrix;\nvoid main() {\n  gl_Position = uMVPMatrix * in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n";
  }
  
  protected int[] m(int paramInt)
  {
    int[] arrayOfInt = new int[this.c];
    for (int i = 0; i < this.c; i++) {
      if (i == 0) {
        arrayOfInt[i] = paramInt;
      } else {
        arrayOfInt[i] = ((paramInt + 1) / 2);
      }
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\z\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */