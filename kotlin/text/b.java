package kotlin.text;

import kotlin.v.d;

class b
{
  public static int a(int paramInt)
  {
    if ((2 <= paramInt) && (36 >= paramInt)) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("radix ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" was not in valid range ");
    localStringBuilder.append(new d(2, 36));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static final int b(char paramChar, int paramInt)
  {
    return Character.digit(paramChar, paramInt);
  }
  
  public static final boolean c(char paramChar)
  {
    boolean bool;
    if ((!Character.isWhitespace(paramChar)) && (!Character.isSpaceChar(paramChar))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */