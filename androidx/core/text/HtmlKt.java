package androidx.core.text;

import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spanned;
import kotlin.jvm.internal.j;

public final class HtmlKt
{
  public static final Spanned parseAsHtml(String paramString, int paramInt, Html.ImageGetter paramImageGetter, Html.TagHandler paramTagHandler)
  {
    j.f(paramString, "$this$parseAsHtml");
    paramString = HtmlCompat.fromHtml(paramString, paramInt, paramImageGetter, paramTagHandler);
    j.b(paramString, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
    return paramString;
  }
  
  public static final String toHtml(Spanned paramSpanned, int paramInt)
  {
    j.f(paramSpanned, "$this$toHtml");
    paramSpanned = HtmlCompat.toHtml(paramSpanned, paramInt);
    j.b(paramSpanned, "HtmlCompat.toHtml(this, option)");
    return paramSpanned;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\text\HtmlKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */