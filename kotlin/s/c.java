package kotlin.s;

class c
  extends b
{
  public static int a(double paramDouble)
  {
    if (!Double.isNaN(paramDouble))
    {
      int i = Integer.MAX_VALUE;
      if (paramDouble <= Integer.MAX_VALUE) {
        if (paramDouble < Integer.MIN_VALUE) {
          i = Integer.MIN_VALUE;
        } else {
          i = (int)Math.round(paramDouble);
        }
      }
      return i;
    }
    throw new IllegalArgumentException("Cannot round NaN value.");
  }
  
  public static int b(float paramFloat)
  {
    if (!Float.isNaN(paramFloat)) {
      return Math.round(paramFloat);
    }
    throw new IllegalArgumentException("Cannot round NaN value.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\s\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */