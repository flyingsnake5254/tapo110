package kotlin.v;

import kotlin.jvm.internal.j;

class f
{
  public static final void a(boolean paramBoolean, Number paramNumber)
  {
    j.e(paramNumber, "step");
    if (paramBoolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Step must be positive, was: ");
    localStringBuilder.append(paramNumber);
    localStringBuilder.append('.');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\v\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */