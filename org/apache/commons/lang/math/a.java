package org.apache.commons.lang.math;

public class a
{
  public static final Long a = new Long(0L);
  public static final Long b = new Long(1L);
  public static final Long c = new Long(-1L);
  public static final Integer d = new Integer(0);
  public static final Integer e = new Integer(1);
  public static final Integer f = new Integer(-1);
  public static final Short g = new Short((short)0);
  public static final Short h = new Short((short)1);
  public static final Short i = new Short((short)-1);
  public static final Byte j = new Byte((byte)0);
  public static final Byte k = new Byte((byte)1);
  public static final Byte l = new Byte((byte)-1);
  public static final Double m = new Double(0.0D);
  public static final Double n = new Double(1.0D);
  public static final Double o = new Double(-1.0D);
  public static final Float p = new Float(0.0F);
  public static final Float q = new Float(1.0F);
  public static final Float r = new Float(-1.0F);
  
  public static int a(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 < paramDouble2) {
      return -1;
    }
    if (paramDouble1 > paramDouble2) {
      return 1;
    }
    boolean bool = Double.doubleToLongBits(paramDouble1) < Double.doubleToLongBits(paramDouble2);
    if (!bool) {
      return 0;
    }
    if (bool) {
      return -1;
    }
    return 1;
  }
  
  public static int b(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return -1;
    }
    if (paramFloat1 > paramFloat2) {
      return 1;
    }
    int i1 = Float.floatToIntBits(paramFloat1);
    int i2 = Float.floatToIntBits(paramFloat2);
    if (i1 == i2) {
      return 0;
    }
    if (i1 < i2) {
      return -1;
    }
    return 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\math\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */