package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R.styleable;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class AppCompatTextViewAutoSizeHelper
{
  private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
  private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
  private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
  private static final String TAG = "ACTVAutoSizeHelper";
  private static final RectF TEMP_RECTF = new RectF();
  static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0F;
  private static final int VERY_WIDE = 1048576;
  private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap();
  private float mAutoSizeMaxTextSizeInPx = -1.0F;
  private float mAutoSizeMinTextSizeInPx = -1.0F;
  private float mAutoSizeStepGranularityInPx = -1.0F;
  private int[] mAutoSizeTextSizesInPx = new int[0];
  private int mAutoSizeTextType = 0;
  private final Context mContext;
  private boolean mHasPresetAutoSizeValues = false;
  private final Impl mImpl;
  private boolean mNeedsAutoSizeText = false;
  private TextPaint mTempTextPaint;
  @NonNull
  private final TextView mTextView;
  
  AppCompatTextViewAutoSizeHelper(@NonNull TextView paramTextView)
  {
    this.mTextView = paramTextView;
    this.mContext = paramTextView.getContext();
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      this.mImpl = new Impl29();
    } else if (i >= 23) {
      this.mImpl = new Impl23();
    } else {
      this.mImpl = new Impl();
    }
  }
  
  private static <T> T accessAndReturnWithDefault(@NonNull Object paramObject, @NonNull String paramString, @NonNull T paramT)
  {
    try
    {
      Field localField = getTextViewField(paramString);
      if (localField == null) {
        return paramT;
      }
      paramObject = localField.get(paramObject);
      return (T)paramObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("Failed to access TextView#");
      ((StringBuilder)paramObject).append(paramString);
      ((StringBuilder)paramObject).append(" member");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)paramObject).toString(), localIllegalAccessException);
    }
    return paramT;
  }
  
  private int[] cleanupAutoSizePresetSizes(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    if (i == 0) {
      return paramArrayOfInt;
    }
    Arrays.sort(paramArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      int m = paramArrayOfInt[k];
      if ((m > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(m)) < 0)) {
        localArrayList.add(Integer.valueOf(m));
      }
    }
    if (i == localArrayList.size()) {
      return paramArrayOfInt;
    }
    i = localArrayList.size();
    paramArrayOfInt = new int[i];
    for (k = j; k < i; k++) {
      paramArrayOfInt[k] = ((Integer)localArrayList.get(k)).intValue();
    }
    return paramArrayOfInt;
  }
  
  private void clearAutoSizeConfiguration()
  {
    this.mAutoSizeTextType = 0;
    this.mAutoSizeMinTextSizeInPx = -1.0F;
    this.mAutoSizeMaxTextSizeInPx = -1.0F;
    this.mAutoSizeStepGranularityInPx = -1.0F;
    this.mAutoSizeTextSizesInPx = new int[0];
    this.mNeedsAutoSizeText = false;
  }
  
  @RequiresApi(23)
  private StaticLayout createStaticLayoutForMeasuring(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.mTempTextPaint, paramInt1);
    paramAlignment = paramCharSequence.setAlignment(paramAlignment).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = Integer.MAX_VALUE;
    }
    paramAlignment.setMaxLines(paramInt1);
    try
    {
      this.mImpl.computeAndSetTextDirection(paramCharSequence, this.mTextView);
    }
    catch (ClassCastException paramAlignment)
    {
      Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
    }
    return paramCharSequence.build();
  }
  
  private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1 = ((Float)accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0F))).floatValue();
    float f2 = ((Float)accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0F))).floatValue();
    boolean bool = ((Boolean)accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.TRUE)).booleanValue();
    return new StaticLayout(paramCharSequence, this.mTempTextPaint, paramInt, paramAlignment, f1, f2, bool);
  }
  
  @RequiresApi(16)
  private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1 = this.mTextView.getLineSpacingMultiplier();
    float f2 = this.mTextView.getLineSpacingExtra();
    boolean bool = this.mTextView.getIncludeFontPadding();
    return new StaticLayout(paramCharSequence, this.mTempTextPaint, paramInt, paramAlignment, f1, f2, bool);
  }
  
  private int findLargestTextSizeWhichFits(RectF paramRectF)
  {
    int i = this.mAutoSizeTextSizesInPx.length;
    if (i != 0)
    {
      int j = i - 1;
      i = 1;
      int k = 0;
      while (i <= j)
      {
        int m = (i + j) / 2;
        if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[m], paramRectF))
        {
          k = i;
          i = m + 1;
        }
        else
        {
          k = m - 1;
          j = k;
        }
      }
      return this.mAutoSizeTextSizesInPx[k];
    }
    throw new IllegalStateException("No available text sizes to choose from.");
  }
  
  @Nullable
  private static Field getTextViewField(@NonNull String paramString)
  {
    try
    {
      Field localField = (Field)sTextViewFieldByNameCache.get(paramString);
      localObject = localField;
      if (localField == null)
      {
        localField = TextView.class.getDeclaredField(paramString);
        localObject = localField;
        if (localField != null)
        {
          localField.setAccessible(true);
          sTextViewFieldByNameCache.put(paramString, localField);
          localObject = localField;
        }
      }
      return (Field)localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to access TextView#");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" member");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject).toString(), localNoSuchFieldException);
    }
    return null;
  }
  
  @Nullable
  private static Method getTextViewMethod(@NonNull String paramString)
  {
    try
    {
      localObject1 = (Method)sTextViewMethodByNameCache.get(paramString);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          ((Method)localObject1).setAccessible(true);
          sTextViewMethodByNameCache.put(paramString, localObject1);
          localObject2 = localObject1;
        }
      }
      return (Method)localObject2;
    }
    catch (Exception localException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to retrieve TextView#");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("() method");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject1).toString(), localException);
    }
    return null;
  }
  
  /* Error */
  static <T> T invokeAndReturnWithDefault(@NonNull Object paramObject, @NonNull String paramString, @NonNull T paramT)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 341	androidx/appcompat/widget/AppCompatTextViewAutoSizeHelper:getTextViewMethod	(Ljava/lang/String;)Ljava/lang/reflect/Method;
    //   4: aload_0
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokevirtual 345	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   12: astore_0
    //   13: aload_0
    //   14: astore_2
    //   15: goto +49 -> 64
    //   18: astore_0
    //   19: goto +47 -> 66
    //   22: astore_0
    //   23: new 124	java/lang/StringBuilder
    //   26: astore_3
    //   27: aload_3
    //   28: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   31: aload_3
    //   32: ldc_w 347
    //   35: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: aload_1
    //   41: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: ldc_w 338
    //   49: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 24
    //   55: aload_3
    //   56: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: aload_0
    //   60: invokestatic 143	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   63: pop
    //   64: aload_2
    //   65: areturn
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramObject	Object
    //   0	68	1	paramString	String
    //   0	68	2	paramT	T
    //   26	30	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	13	18	finally
    //   23	64	18	finally
    //   0	13	22	java/lang/Exception
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.mTextView.getPaint().getTextSize())
    {
      this.mTextView.getPaint().setTextSize(paramFloat);
      boolean bool;
      if (Build.VERSION.SDK_INT >= 18) {
        bool = this.mTextView.isInLayout();
      } else {
        bool = false;
      }
      if (this.mTextView.getLayout() != null)
      {
        this.mNeedsAutoSizeText = false;
        try
        {
          Method localMethod = getTextViewMethod("nullLayouts");
          if (localMethod != null) {
            localMethod.invoke(this.mTextView, new Object[0]);
          }
        }
        catch (Exception localException)
        {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", localException);
        }
        if (!bool) {
          this.mTextView.requestLayout();
        } else {
          this.mTextView.forceLayout();
        }
        this.mTextView.invalidate();
      }
    }
  }
  
  private boolean setupAutoSizeText()
  {
    boolean bool = supportsAutoSizeText();
    int i = 0;
    if ((bool) && (this.mAutoSizeTextType == 1))
    {
      if ((!this.mHasPresetAutoSizeValues) || (this.mAutoSizeTextSizesInPx.length == 0))
      {
        int j = (int)Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx) + 1;
        int[] arrayOfInt = new int[j];
        while (i < j)
        {
          arrayOfInt[i] = Math.round(this.mAutoSizeMinTextSizeInPx + i * this.mAutoSizeStepGranularityInPx);
          i++;
        }
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      }
      this.mNeedsAutoSizeText = true;
    }
    else
    {
      this.mNeedsAutoSizeText = false;
    }
    return this.mNeedsAutoSizeText;
  }
  
  private void setupAutoSizeUniformPresetSizes(TypedArray paramTypedArray)
  {
    int i = paramTypedArray.length();
    int[] arrayOfInt = new int[i];
    if (i > 0)
    {
      for (int j = 0; j < i; j++) {
        arrayOfInt[j] = paramTypedArray.getDimensionPixelSize(j, -1);
      }
      this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      setupAutoSizeUniformPresetSizesConfiguration();
    }
  }
  
  private boolean setupAutoSizeUniformPresetSizesConfiguration()
  {
    int[] arrayOfInt = this.mAutoSizeTextSizesInPx;
    int i = arrayOfInt.length;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.mHasPresetAutoSizeValues = bool;
    if (bool)
    {
      this.mAutoSizeTextType = 1;
      this.mAutoSizeMinTextSizeInPx = arrayOfInt[0];
      this.mAutoSizeMaxTextSizeInPx = arrayOfInt[(i - 1)];
      this.mAutoSizeStepGranularityInPx = -1.0F;
    }
    return bool;
  }
  
  private boolean suggestedSizeFitsInSpace(int paramInt, RectF paramRectF)
  {
    Object localObject1 = this.mTextView.getText();
    Object localObject2 = this.mTextView.getTransformationMethod();
    Object localObject3 = localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((TransformationMethod)localObject2).getTransformation((CharSequence)localObject1, this.mTextView);
      localObject3 = localObject1;
      if (localObject2 != null) {
        localObject3 = localObject2;
      }
    }
    int i;
    if (Build.VERSION.SDK_INT >= 16) {
      i = this.mTextView.getMaxLines();
    } else {
      i = -1;
    }
    initTempTextPaint(paramInt);
    localObject1 = createLayout((CharSequence)localObject3, (Layout.Alignment)invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(paramRectF.right), i);
    if ((i != -1) && ((((StaticLayout)localObject1).getLineCount() > i) || (((StaticLayout)localObject1).getLineEnd(((StaticLayout)localObject1).getLineCount() - 1) != ((CharSequence)localObject3).length()))) {
      return false;
    }
    return ((StaticLayout)localObject1).getHeight() <= paramRectF.bottom;
  }
  
  private boolean supportsAutoSizeText()
  {
    return this.mTextView instanceof AppCompatEditText ^ true;
  }
  
  private void validateAndSetAutoSizeTextTypeUniformConfiguration(float paramFloat1, float paramFloat2, float paramFloat3)
    throws IllegalArgumentException
  {
    if (paramFloat1 > 0.0F)
    {
      if (paramFloat2 > paramFloat1)
      {
        if (paramFloat3 > 0.0F)
        {
          this.mAutoSizeTextType = 1;
          this.mAutoSizeMinTextSizeInPx = paramFloat1;
          this.mAutoSizeMaxTextSizeInPx = paramFloat2;
          this.mAutoSizeStepGranularityInPx = paramFloat3;
          this.mHasPresetAutoSizeValues = false;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("The auto-size step granularity (");
        localStringBuilder.append(paramFloat3);
        localStringBuilder.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Maximum auto-size text size (");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("px) is less or equal to minimum auto-size text size (");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append("px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Minimum auto-size text size (");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append("px) is less or equal to (0px)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void autoSizeText()
  {
    if (!isAutoSizeEnabled()) {
      return;
    }
    if (this.mNeedsAutoSizeText)
    {
      if ((this.mTextView.getMeasuredHeight() > 0) && (this.mTextView.getMeasuredWidth() > 0))
      {
        int i;
        if (this.mImpl.isHorizontallyScrollable(this.mTextView)) {
          i = 1048576;
        } else {
          i = this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft() - this.mTextView.getTotalPaddingRight();
        }
        int j = this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom() - this.mTextView.getCompoundPaddingTop();
        if ((i > 0) && (j > 0)) {
          synchronized (TEMP_RECTF)
          {
            ???.setEmpty();
            ???.right = i;
            ???.bottom = j;
            float f = findLargestTextSizeWhichFits(???);
            if (f != this.mTextView.getTextSize()) {
              setTextSizeInternal(0, f);
            }
          }
        }
      }
      return;
    }
    this.mNeedsAutoSizeText = true;
  }
  
  @VisibleForTesting
  StaticLayout createLayout(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return createStaticLayoutForMeasuring(paramCharSequence, paramAlignment, paramInt1, paramInt2);
    }
    if (i >= 16) {
      return createStaticLayoutForMeasuringPre23(paramCharSequence, paramAlignment, paramInt1);
    }
    return createStaticLayoutForMeasuringPre16(paramCharSequence, paramAlignment, paramInt1);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int getAutoSizeMaxTextSize()
  {
    return Math.round(this.mAutoSizeMaxTextSizeInPx);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int getAutoSizeMinTextSize()
  {
    return Math.round(this.mAutoSizeMinTextSizeInPx);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int getAutoSizeStepGranularity()
  {
    return Math.round(this.mAutoSizeStepGranularityInPx);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int[] getAutoSizeTextAvailableSizes()
  {
    return this.mAutoSizeTextSizesInPx;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int getAutoSizeTextType()
  {
    return this.mAutoSizeTextType;
  }
  
  @VisibleForTesting
  void initTempTextPaint(int paramInt)
  {
    TextPaint localTextPaint = this.mTempTextPaint;
    if (localTextPaint == null) {
      this.mTempTextPaint = new TextPaint();
    } else {
      localTextPaint.reset();
    }
    this.mTempTextPaint.set(this.mTextView.getPaint());
    this.mTempTextPaint.setTextSize(paramInt);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  boolean isAutoSizeEnabled()
  {
    boolean bool;
    if ((supportsAutoSizeText()) && (this.mAutoSizeTextType != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void loadFromAttributes(@Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject = this.mContext;
    int[] arrayOfInt = R.styleable.AppCompatTextView;
    localObject = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, arrayOfInt, paramInt, 0);
    TextView localTextView = this.mTextView;
    ViewCompat.saveAttributeDataForStyleable(localTextView, localTextView.getContext(), arrayOfInt, paramAttributeSet, (TypedArray)localObject, paramInt, 0);
    paramInt = R.styleable.AppCompatTextView_autoSizeTextType;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      this.mAutoSizeTextType = ((TypedArray)localObject).getInt(paramInt, 0);
    }
    paramInt = R.styleable.AppCompatTextView_autoSizeStepGranularity;
    float f1;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      f1 = ((TypedArray)localObject).getDimension(paramInt, -1.0F);
    } else {
      f1 = -1.0F;
    }
    paramInt = R.styleable.AppCompatTextView_autoSizeMinTextSize;
    float f2;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      f2 = ((TypedArray)localObject).getDimension(paramInt, -1.0F);
    } else {
      f2 = -1.0F;
    }
    paramInt = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
    float f3;
    if (((TypedArray)localObject).hasValue(paramInt)) {
      f3 = ((TypedArray)localObject).getDimension(paramInt, -1.0F);
    } else {
      f3 = -1.0F;
    }
    paramInt = R.styleable.AppCompatTextView_autoSizePresetSizes;
    if (((TypedArray)localObject).hasValue(paramInt))
    {
      paramInt = ((TypedArray)localObject).getResourceId(paramInt, 0);
      if (paramInt > 0)
      {
        paramAttributeSet = ((TypedArray)localObject).getResources().obtainTypedArray(paramInt);
        setupAutoSizeUniformPresetSizes(paramAttributeSet);
        paramAttributeSet.recycle();
      }
    }
    ((TypedArray)localObject).recycle();
    if (supportsAutoSizeText())
    {
      if (this.mAutoSizeTextType == 1)
      {
        if (!this.mHasPresetAutoSizeValues)
        {
          paramAttributeSet = this.mContext.getResources().getDisplayMetrics();
          float f4 = f2;
          if (f2 == -1.0F) {
            f4 = TypedValue.applyDimension(2, 12.0F, paramAttributeSet);
          }
          f2 = f3;
          if (f3 == -1.0F) {
            f2 = TypedValue.applyDimension(2, 112.0F, paramAttributeSet);
          }
          f3 = f1;
          if (f1 == -1.0F) {
            f3 = 1.0F;
          }
          validateAndSetAutoSizeTextTypeUniformConfiguration(f4, f2, f3);
        }
        setupAutoSizeText();
      }
    }
    else {
      this.mAutoSizeTextType = 0;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (supportsAutoSizeText())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (setupAutoSizeText()) {
        autoSizeText();
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (supportsAutoSizeText())
    {
      int i = paramArrayOfInt.length;
      int j = 0;
      if (i > 0)
      {
        int[] arrayOfInt = new int[i];
        Object localObject;
        if (paramInt == 0)
        {
          localObject = Arrays.copyOf(paramArrayOfInt, i);
        }
        else
        {
          DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
          for (;;)
          {
            localObject = arrayOfInt;
            if (j >= i) {
              break;
            }
            arrayOfInt[j] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[j], localDisplayMetrics));
            j++;
          }
        }
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes((int[])localObject);
        if (!setupAutoSizeUniformPresetSizesConfiguration())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("None of the preset sizes is valid: ");
          ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfInt));
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.mHasPresetAutoSizeValues = false;
      }
      if (setupAutoSizeText()) {
        autoSizeText();
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (supportsAutoSizeText()) {
      if (paramInt != 0)
      {
        Object localObject;
        if (paramInt == 1)
        {
          localObject = this.mContext.getResources().getDisplayMetrics();
          validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0F, (DisplayMetrics)localObject), TypedValue.applyDimension(2, 112.0F, (DisplayMetrics)localObject), 1.0F);
          if (setupAutoSizeText()) {
            autoSizeText();
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unknown auto-size text type: ");
          ((StringBuilder)localObject).append(paramInt);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        clearAutoSizeConfiguration();
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setTextSizeInternal(int paramInt, float paramFloat)
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
  }
  
  private static class Impl
  {
    void computeAndSetTextDirection(StaticLayout.Builder paramBuilder, TextView paramTextView) {}
    
    boolean isHorizontallyScrollable(TextView paramTextView)
    {
      return ((Boolean)AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(paramTextView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
    }
  }
  
  @RequiresApi(23)
  private static class Impl23
    extends AppCompatTextViewAutoSizeHelper.Impl
  {
    void computeAndSetTextDirection(StaticLayout.Builder paramBuilder, TextView paramTextView)
    {
      paramBuilder.setTextDirection((TextDirectionHeuristic)AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(paramTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
    }
  }
  
  @RequiresApi(29)
  private static class Impl29
    extends AppCompatTextViewAutoSizeHelper.Impl23
  {
    void computeAndSetTextDirection(StaticLayout.Builder paramBuilder, TextView paramTextView)
    {
      paramBuilder.setTextDirection(paramTextView.getTextDirectionHeuristic());
    }
    
    boolean isHorizontallyScrollable(TextView paramTextView)
    {
      return paramTextView.isHorizontallyScrollable();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatTextViewAutoSizeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */