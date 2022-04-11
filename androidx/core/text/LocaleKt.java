package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import kotlin.jvm.internal.j;

public final class LocaleKt
{
  @RequiresApi(17)
  public static final int getLayoutDirection(Locale paramLocale)
  {
    j.f(paramLocale, "$this$layoutDirection");
    return TextUtils.getLayoutDirectionFromLocale(paramLocale);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\text\LocaleKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */