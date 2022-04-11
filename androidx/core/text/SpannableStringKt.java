package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import kotlin.jvm.internal.j;
import kotlin.v.d;

public final class SpannableStringKt
{
  @SuppressLint({"SyntheticAccessor"})
  public static final void clearSpans(Spannable paramSpannable)
  {
    j.f(paramSpannable, "$this$clearSpans");
    int i = paramSpannable.length();
    int j = 0;
    Object[] arrayOfObject = paramSpannable.getSpans(0, i, Object.class);
    j.b(arrayOfObject, "getSpans(start, end, T::class.java)");
    i = arrayOfObject.length;
    while (j < i)
    {
      paramSpannable.removeSpan(arrayOfObject[j]);
      j++;
    }
  }
  
  public static final void set(Spannable paramSpannable, int paramInt1, int paramInt2, Object paramObject)
  {
    j.f(paramSpannable, "$this$set");
    j.f(paramObject, "span");
    paramSpannable.setSpan(paramObject, paramInt1, paramInt2, 17);
  }
  
  public static final void set(Spannable paramSpannable, d paramd, Object paramObject)
  {
    j.f(paramSpannable, "$this$set");
    j.f(paramd, "range");
    j.f(paramObject, "span");
    paramSpannable.setSpan(paramObject, paramd.h().intValue(), paramd.g().intValue(), 17);
  }
  
  public static final Spannable toSpannable(CharSequence paramCharSequence)
  {
    j.f(paramCharSequence, "$this$toSpannable");
    paramCharSequence = SpannableString.valueOf(paramCharSequence);
    j.b(paramCharSequence, "SpannableString.valueOf(this)");
    return paramCharSequence;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\text\SpannableStringKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */