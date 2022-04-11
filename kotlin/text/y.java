package kotlin.text;

import kotlin.jvm.internal.j;
import kotlin.v.e;

class y
  extends x
{
  public static final String u0(String paramString, int paramInt)
  {
    j.e(paramString, "$this$drop");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramString = paramString.substring(e.d(paramInt, paramString.length()));
      j.d(paramString, "(this as java.lang.String).substring(startIndex)");
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("Requested character count ");
    paramString.append(paramInt);
    paramString.append(" is less than zero.");
    throw new IllegalArgumentException(paramString.toString().toString());
  }
  
  public static String v0(String paramString, int paramInt)
  {
    j.e(paramString, "$this$dropLast");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return w0(paramString, e.b(paramString.length() - paramInt, 0));
    }
    paramString = new StringBuilder();
    paramString.append("Requested character count ");
    paramString.append(paramInt);
    paramString.append(" is less than zero.");
    throw new IllegalArgumentException(paramString.toString().toString());
  }
  
  public static final String w0(String paramString, int paramInt)
  {
    j.e(paramString, "$this$take");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramString = paramString.substring(0, e.d(paramInt, paramString.length()));
      j.d(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("Requested character count ");
    paramString.append(paramInt);
    paramString.append(" is less than zero.");
    throw new IllegalArgumentException(paramString.toString().toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */