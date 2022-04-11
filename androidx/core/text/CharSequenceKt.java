package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.j;

public final class CharSequenceKt
{
  public static final boolean isDigitsOnly(CharSequence paramCharSequence)
  {
    j.f(paramCharSequence, "$this$isDigitsOnly");
    return TextUtils.isDigitsOnly(paramCharSequence);
  }
  
  public static final int trimmedLength(CharSequence paramCharSequence)
  {
    j.f(paramCharSequence, "$this$trimmedLength");
    return TextUtils.getTrimmedLength(paramCharSequence);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\text\CharSequenceKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */