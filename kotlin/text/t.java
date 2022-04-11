package kotlin.text;

import kotlin.jvm.internal.j;

class t
  extends s
{
  public static Double i(String paramString)
  {
    j.e(paramString, "$this$toDoubleOrNull");
    localObject1 = null;
    localObject2 = localObject1;
    try
    {
      if (l.a.matches(paramString))
      {
        double d = Double.parseDouble(paramString);
        localObject2 = Double.valueOf(d);
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
    return (Double)localObject2;
  }
  
  public static Float j(String paramString)
  {
    j.e(paramString, "$this$toFloatOrNull");
    localObject1 = null;
    localObject2 = localObject1;
    try
    {
      if (l.a.matches(paramString))
      {
        float f = Float.parseFloat(paramString);
        localObject2 = Float.valueOf(f);
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        localObject2 = localObject1;
      }
    }
    return (Float)localObject2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */