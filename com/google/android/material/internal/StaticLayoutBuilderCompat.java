package com.google.android.material.internal;

import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat
{
  private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
  private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
  private static final String TEXT_DIR_CLASS_LTR = "LTR";
  private static final String TEXT_DIR_CLASS_RTL = "RTL";
  @Nullable
  private static Constructor<StaticLayout> constructor;
  private static boolean initialized;
  @Nullable
  private static Object textDirection;
  private Layout.Alignment alignment;
  @Nullable
  private TextUtils.TruncateAt ellipsize;
  private int end;
  private boolean includePad;
  private boolean isRtl;
  private int maxLines;
  private final TextPaint paint;
  private CharSequence source;
  private int start;
  private final int width;
  
  private StaticLayoutBuilderCompat(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    this.source = paramCharSequence;
    this.paint = paramTextPaint;
    this.width = paramInt;
    this.start = 0;
    this.end = paramCharSequence.length();
    this.alignment = Layout.Alignment.ALIGN_NORMAL;
    this.maxLines = Integer.MAX_VALUE;
    this.includePad = true;
    this.ellipsize = null;
  }
  
  private void createConstructorWithReflection()
    throws StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException
  {
    if (initialized) {
      return;
    }
    try
    {
      int i;
      if ((this.isRtl) && (Build.VERSION.SDK_INT >= 23)) {
        i = 1;
      } else {
        i = 0;
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        localClass = TextDirectionHeuristic.class;
        if (i != 0) {
          localObject1 = TextDirectionHeuristics.RTL;
        } else {
          localObject1 = TextDirectionHeuristics.LTR;
        }
        textDirection = localObject1;
        localObject1 = localClass;
      }
      else
      {
        localObject2 = StaticLayoutBuilderCompat.class.getClassLoader();
        if (this.isRtl) {
          localObject1 = "RTL";
        } else {
          localObject1 = "LTR";
        }
        localClass = ((ClassLoader)localObject2).loadClass("android.text.TextDirectionHeuristic");
        localObject2 = ((ClassLoader)localObject2).loadClass("android.text.TextDirectionHeuristics");
        textDirection = ((Class)localObject2).getField((String)localObject1).get(localObject2);
        localObject1 = localClass;
      }
      Class localClass = Integer.TYPE;
      Object localObject2 = Float.TYPE;
      Object localObject1 = StaticLayout.class.getDeclaredConstructor(new Class[] { CharSequence.class, localClass, localClass, TextPaint.class, localClass, Layout.Alignment.class, localObject1, localObject2, localObject2, Boolean.TYPE, TextUtils.TruncateAt.class, localClass, localClass });
      constructor = (Constructor)localObject1;
      ((Constructor)localObject1).setAccessible(true);
      initialized = true;
      return;
    }
    catch (Exception localException)
    {
      throw new StaticLayoutBuilderCompatException(localException);
    }
  }
  
  @NonNull
  public static StaticLayoutBuilderCompat obtain(@NonNull CharSequence paramCharSequence, @NonNull TextPaint paramTextPaint, @IntRange(from=0L) int paramInt)
  {
    return new StaticLayoutBuilderCompat(paramCharSequence, paramTextPaint, paramInt);
  }
  
  public StaticLayout build()
    throws StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException
  {
    if (this.source == null) {
      this.source = "";
    }
    int i = Math.max(0, this.width);
    Object localObject1 = this.source;
    Object localObject2 = localObject1;
    if (this.maxLines == 1) {
      localObject2 = TextUtils.ellipsize((CharSequence)localObject1, this.paint, i, this.ellipsize);
    }
    int j = Math.min(((CharSequence)localObject2).length(), this.end);
    this.end = j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.isRtl) {
        this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
      }
      localObject1 = StaticLayout.Builder.obtain((CharSequence)localObject2, this.start, j, this.paint, i);
      ((StaticLayout.Builder)localObject1).setAlignment(this.alignment);
      ((StaticLayout.Builder)localObject1).setIncludePad(this.includePad);
      if (this.isRtl) {
        localObject2 = TextDirectionHeuristics.RTL;
      } else {
        localObject2 = TextDirectionHeuristics.LTR;
      }
      ((StaticLayout.Builder)localObject1).setTextDirection((TextDirectionHeuristic)localObject2);
      localObject2 = this.ellipsize;
      if (localObject2 != null) {
        ((StaticLayout.Builder)localObject1).setEllipsize((TextUtils.TruncateAt)localObject2);
      }
      ((StaticLayout.Builder)localObject1).setMaxLines(this.maxLines);
      return ((StaticLayout.Builder)localObject1).build();
    }
    createConstructorWithReflection();
    try
    {
      localObject2 = (StaticLayout)((Constructor)Preconditions.checkNotNull(constructor)).newInstance(new Object[] { localObject2, Integer.valueOf(this.start), Integer.valueOf(this.end), this.paint, Integer.valueOf(i), this.alignment, Preconditions.checkNotNull(textDirection), Float.valueOf(1.0F), Float.valueOf(0.0F), Boolean.valueOf(this.includePad), null, Integer.valueOf(i), Integer.valueOf(this.maxLines) });
      return (StaticLayout)localObject2;
    }
    catch (Exception localException)
    {
      throw new StaticLayoutBuilderCompatException(localException);
    }
  }
  
  @NonNull
  public StaticLayoutBuilderCompat setAlignment(@NonNull Layout.Alignment paramAlignment)
  {
    this.alignment = paramAlignment;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat setEllipsize(@Nullable TextUtils.TruncateAt paramTruncateAt)
  {
    this.ellipsize = paramTruncateAt;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat setEnd(@IntRange(from=0L) int paramInt)
  {
    this.end = paramInt;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat setIncludePad(boolean paramBoolean)
  {
    this.includePad = paramBoolean;
    return this;
  }
  
  public StaticLayoutBuilderCompat setIsRtl(boolean paramBoolean)
  {
    this.isRtl = paramBoolean;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat setMaxLines(@IntRange(from=0L) int paramInt)
  {
    this.maxLines = paramInt;
    return this;
  }
  
  @NonNull
  public StaticLayoutBuilderCompat setStart(@IntRange(from=0L) int paramInt)
  {
    this.start = paramInt;
    return this;
  }
  
  static class StaticLayoutBuilderCompatException
    extends Exception
  {
    StaticLayoutBuilderCompatException(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\StaticLayoutBuilderCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */