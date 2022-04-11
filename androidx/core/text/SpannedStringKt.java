package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.jvm.internal.j;

public final class SpannedStringKt
{
  public static final Spanned toSpanned(CharSequence paramCharSequence)
  {
    j.f(paramCharSequence, "$this$toSpanned");
    paramCharSequence = SpannedString.valueOf(paramCharSequence);
    j.b(paramCharSequence, "SpannedString.valueOf(this)");
    return paramCharSequence;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\text\SpannedStringKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */