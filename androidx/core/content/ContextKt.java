package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ContextKt
{
  public static final void withStyledAttributes(Context paramContext, @StyleRes int paramInt, int[] paramArrayOfInt, l<? super TypedArray, p> paraml)
  {
    j.f(paramContext, "$this$withStyledAttributes");
    j.f(paramArrayOfInt, "attrs");
    j.f(paraml, "block");
    paramContext = paramContext.obtainStyledAttributes(paramInt, paramArrayOfInt);
    paraml.invoke(paramContext);
    paramContext.recycle();
  }
  
  public static final void withStyledAttributes(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, @AttrRes int paramInt1, @StyleRes int paramInt2, l<? super TypedArray, p> paraml)
  {
    j.f(paramContext, "$this$withStyledAttributes");
    j.f(paramArrayOfInt, "attrs");
    j.f(paraml, "block");
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt1, paramInt2);
    paraml.invoke(paramContext);
    paramContext.recycle();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\ContextKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */