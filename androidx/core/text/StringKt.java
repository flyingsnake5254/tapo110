package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.j;

public final class StringKt
{
  public static final String htmlEncode(String paramString)
  {
    j.f(paramString, "$this$htmlEncode");
    paramString = TextUtils.htmlEncode(paramString);
    j.b(paramString, "TextUtils.htmlEncode(this)");
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\text\StringKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */