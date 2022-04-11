package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SpannableStringBuilderKt
{
  public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder paramSpannableStringBuilder, @ColorInt int paramInt, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$backgroundColor");
    j.f(paraml, "builderAction");
    BackgroundColorSpan localBackgroundColorSpan = new BackgroundColorSpan(paramInt);
    paramInt = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(localBackgroundColorSpan, paramInt, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
  
  public static final SpannableStringBuilder bold(SpannableStringBuilder paramSpannableStringBuilder, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$bold");
    j.f(paraml, "builderAction");
    StyleSpan localStyleSpan = new StyleSpan(1);
    int i = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(localStyleSpan, i, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
  
  public static final SpannedString buildSpannedString(l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paraml, "builderAction");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paraml.invoke(localSpannableStringBuilder);
    return new SpannedString(localSpannableStringBuilder);
  }
  
  public static final SpannableStringBuilder color(SpannableStringBuilder paramSpannableStringBuilder, @ColorInt int paramInt, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$color");
    j.f(paraml, "builderAction");
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(paramInt);
    paramInt = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(localForegroundColorSpan, paramInt, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
  
  public static final SpannableStringBuilder inSpans(SpannableStringBuilder paramSpannableStringBuilder, Object paramObject, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$inSpans");
    j.f(paramObject, "span");
    j.f(paraml, "builderAction");
    int i = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(paramObject, i, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
  
  public static final SpannableStringBuilder inSpans(SpannableStringBuilder paramSpannableStringBuilder, Object[] paramArrayOfObject, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$inSpans");
    j.f(paramArrayOfObject, "spans");
    j.f(paraml, "builderAction");
    int i = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    int j = paramArrayOfObject.length;
    for (int k = 0; k < j; k++) {
      paramSpannableStringBuilder.setSpan(paramArrayOfObject[k], i, paramSpannableStringBuilder.length(), 17);
    }
    return paramSpannableStringBuilder;
  }
  
  public static final SpannableStringBuilder italic(SpannableStringBuilder paramSpannableStringBuilder, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$italic");
    j.f(paraml, "builderAction");
    StyleSpan localStyleSpan = new StyleSpan(2);
    int i = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(localStyleSpan, i, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
  
  public static final SpannableStringBuilder scale(SpannableStringBuilder paramSpannableStringBuilder, float paramFloat, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$scale");
    j.f(paraml, "builderAction");
    RelativeSizeSpan localRelativeSizeSpan = new RelativeSizeSpan(paramFloat);
    int i = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(localRelativeSizeSpan, i, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
  
  public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder paramSpannableStringBuilder, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$strikeThrough");
    j.f(paraml, "builderAction");
    StrikethroughSpan localStrikethroughSpan = new StrikethroughSpan();
    int i = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(localStrikethroughSpan, i, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
  
  public static final SpannableStringBuilder subscript(SpannableStringBuilder paramSpannableStringBuilder, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$subscript");
    j.f(paraml, "builderAction");
    SubscriptSpan localSubscriptSpan = new SubscriptSpan();
    int i = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(localSubscriptSpan, i, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
  
  public static final SpannableStringBuilder superscript(SpannableStringBuilder paramSpannableStringBuilder, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$superscript");
    j.f(paraml, "builderAction");
    SuperscriptSpan localSuperscriptSpan = new SuperscriptSpan();
    int i = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(localSuperscriptSpan, i, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
  
  public static final SpannableStringBuilder underline(SpannableStringBuilder paramSpannableStringBuilder, l<? super SpannableStringBuilder, p> paraml)
  {
    j.f(paramSpannableStringBuilder, "$this$underline");
    j.f(paraml, "builderAction");
    UnderlineSpan localUnderlineSpan = new UnderlineSpan();
    int i = paramSpannableStringBuilder.length();
    paraml.invoke(paramSpannableStringBuilder);
    paramSpannableStringBuilder.setSpan(localUnderlineSpan, i, paramSpannableStringBuilder.length(), 17);
    return paramSpannableStringBuilder;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\text\SpannableStringBuilderKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */