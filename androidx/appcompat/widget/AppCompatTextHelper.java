package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.styleable;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper
{
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
  private boolean mAsyncFontPending;
  @NonNull
  private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
  private TintInfo mDrawableBottomTint;
  private TintInfo mDrawableEndTint;
  private TintInfo mDrawableLeftTint;
  private TintInfo mDrawableRightTint;
  private TintInfo mDrawableStartTint;
  private TintInfo mDrawableTint;
  private TintInfo mDrawableTopTint;
  private Typeface mFontTypeface;
  private int mFontWeight = -1;
  private int mStyle = 0;
  @NonNull
  private final TextView mView;
  
  AppCompatTextHelper(@NonNull TextView paramTextView)
  {
    this.mView = paramTextView;
    this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(paramTextView);
  }
  
  private void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramDrawable != null) && (paramTintInfo != null)) {
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState());
    }
  }
  
  private static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt)
  {
    paramContext = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (paramContext != null)
    {
      paramAppCompatDrawableManager = new TintInfo();
      paramAppCompatDrawableManager.mHasTintList = true;
      paramAppCompatDrawableManager.mTintList = paramContext;
      return paramAppCompatDrawableManager;
    }
    return null;
  }
  
  private void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, Drawable paramDrawable5, Drawable paramDrawable6)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 17) && ((paramDrawable5 != null) || (paramDrawable6 != null)))
    {
      paramDrawable3 = this.mView.getCompoundDrawablesRelative();
      paramDrawable1 = this.mView;
      if (paramDrawable5 == null) {
        paramDrawable5 = paramDrawable3[0];
      }
      if (paramDrawable2 == null) {
        paramDrawable2 = paramDrawable3[1];
      }
      if (paramDrawable6 == null) {
        paramDrawable6 = paramDrawable3[2];
      }
      if (paramDrawable4 == null) {
        paramDrawable4 = paramDrawable3[3];
      }
      paramDrawable1.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable5, paramDrawable2, paramDrawable6, paramDrawable4);
    }
    else if ((paramDrawable1 != null) || (paramDrawable2 != null) || (paramDrawable3 != null) || (paramDrawable4 != null))
    {
      if (i >= 17)
      {
        paramDrawable5 = this.mView.getCompoundDrawablesRelative();
        if ((paramDrawable5[0] != null) || (paramDrawable5[2] != null))
        {
          paramDrawable3 = this.mView;
          paramDrawable1 = paramDrawable5[0];
          if (paramDrawable2 == null) {
            paramDrawable2 = paramDrawable5[1];
          }
          paramDrawable6 = paramDrawable5[2];
          if (paramDrawable4 == null) {
            paramDrawable4 = paramDrawable5[3];
          }
          paramDrawable3.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable6, paramDrawable4);
          return;
        }
      }
      paramDrawable6 = this.mView.getCompoundDrawables();
      paramDrawable5 = this.mView;
      if (paramDrawable1 == null) {
        paramDrawable1 = paramDrawable6[0];
      }
      if (paramDrawable2 == null) {
        paramDrawable2 = paramDrawable6[1];
      }
      if (paramDrawable3 == null) {
        paramDrawable3 = paramDrawable6[2];
      }
      if (paramDrawable4 == null) {
        paramDrawable4 = paramDrawable6[3];
      }
      paramDrawable5.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    }
  }
  
  private void setCompoundTints()
  {
    TintInfo localTintInfo = this.mDrawableTint;
    this.mDrawableLeftTint = localTintInfo;
    this.mDrawableTopTint = localTintInfo;
    this.mDrawableRightTint = localTintInfo;
    this.mDrawableBottomTint = localTintInfo;
    this.mDrawableStartTint = localTintInfo;
    this.mDrawableEndTint = localTintInfo;
  }
  
  private void setTextSizeInternal(int paramInt, float paramFloat)
  {
    this.mAutoSizeTextHelper.setTextSizeInternal(paramInt, paramFloat);
  }
  
  private void updateTypefaceAndStyle(Context paramContext, TintTypedArray paramTintTypedArray)
  {
    this.mStyle = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    if (i >= 28)
    {
      j = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
      this.mFontWeight = j;
      if (j != -1) {
        this.mStyle = (this.mStyle & 0x2 | 0x0);
      }
    }
    int j = R.styleable.TextAppearance_android_fontFamily;
    if ((!paramTintTypedArray.hasValue(j)) && (!paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)))
    {
      j = R.styleable.TextAppearance_android_typeface;
      if (paramTintTypedArray.hasValue(j))
      {
        this.mAsyncFontPending = false;
        j = paramTintTypedArray.getInt(j, 1);
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3) {
              this.mFontTypeface = Typeface.MONOSPACE;
            }
          }
          else {
            this.mFontTypeface = Typeface.SERIF;
          }
        }
        else {
          this.mFontTypeface = Typeface.SANS_SERIF;
        }
      }
      return;
    }
    this.mFontTypeface = null;
    final int k = R.styleable.TextAppearance_fontFamily;
    if (paramTintTypedArray.hasValue(k)) {
      j = k;
    }
    k = this.mFontWeight;
    final int m = this.mStyle;
    boolean bool2;
    if (!paramContext.isRestricted())
    {
      paramContext = new ResourcesCompat.FontCallback()
      {
        public void onFontRetrievalFailed(int paramAnonymousInt) {}
        
        public void onFontRetrieved(@NonNull Typeface paramAnonymousTypeface)
        {
          Typeface localTypeface = paramAnonymousTypeface;
          if (Build.VERSION.SDK_INT >= 28)
          {
            int i = k;
            localTypeface = paramAnonymousTypeface;
            if (i != -1)
            {
              boolean bool;
              if ((m & 0x2) != 0) {
                bool = true;
              } else {
                bool = false;
              }
              localTypeface = Typeface.create(paramAnonymousTypeface, i, bool);
            }
          }
          AppCompatTextHelper.this.onAsyncTypefaceReceived(this.val$textViewWeak, localTypeface);
        }
      };
      try
      {
        paramContext = paramTintTypedArray.getFont(j, this.mStyle, paramContext);
        if (paramContext != null) {
          if ((i >= 28) && (this.mFontWeight != -1))
          {
            paramContext = Typeface.create(paramContext, 0);
            k = this.mFontWeight;
            if ((this.mStyle & 0x2) != 0) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            this.mFontTypeface = Typeface.create(paramContext, k, bool2);
          }
          else
          {
            this.mFontTypeface = paramContext;
          }
        }
        if (this.mFontTypeface == null) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        this.mAsyncFontPending = bool2;
      }
      catch (UnsupportedOperationException|Resources.NotFoundException paramContext) {}
    }
    if (this.mFontTypeface == null)
    {
      paramContext = paramTintTypedArray.getString(j);
      if (paramContext != null) {
        if ((Build.VERSION.SDK_INT >= 28) && (this.mFontWeight != -1))
        {
          paramContext = Typeface.create(paramContext, 0);
          j = this.mFontWeight;
          bool2 = bool1;
          if ((this.mStyle & 0x2) != 0) {
            bool2 = true;
          }
          this.mFontTypeface = Typeface.create(paramContext, j, bool2);
        }
        else
        {
          this.mFontTypeface = Typeface.create(paramContext, this.mStyle);
        }
      }
    }
  }
  
  void applyCompoundDrawablesTints()
  {
    Drawable[] arrayOfDrawable;
    if ((this.mDrawableLeftTint != null) || (this.mDrawableTopTint != null) || (this.mDrawableRightTint != null) || (this.mDrawableBottomTint != null))
    {
      arrayOfDrawable = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], this.mDrawableBottomTint);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.mDrawableStartTint != null) || (this.mDrawableEndTint != null)))
    {
      arrayOfDrawable = this.mView.getCompoundDrawablesRelative();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableStartTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableEndTint);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void autoSizeText()
  {
    this.mAutoSizeTextHelper.autoSizeText();
  }
  
  int getAutoSizeMaxTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
  }
  
  int getAutoSizeMinTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
  }
  
  int getAutoSizeStepGranularity()
  {
    return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
  }
  
  int[] getAutoSizeTextAvailableSizes()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
  }
  
  int getAutoSizeTextType()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextType();
  }
  
  @Nullable
  ColorStateList getCompoundDrawableTintList()
  {
    Object localObject = this.mDrawableTint;
    if (localObject != null) {
      localObject = ((TintInfo)localObject).mTintList;
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  @Nullable
  PorterDuff.Mode getCompoundDrawableTintMode()
  {
    Object localObject = this.mDrawableTint;
    if (localObject != null) {
      localObject = ((TintInfo)localObject).mTintMode;
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  boolean isAutoSizeEnabled()
  {
    return this.mAutoSizeTextHelper.isAutoSizeEnabled();
  }
  
  @SuppressLint({"NewApi"})
  void loadFromAttributes(@Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.mView.getContext();
    AppCompatDrawableManager localAppCompatDrawableManager = AppCompatDrawableManager.get();
    Object localObject1 = R.styleable.AppCompatTextHelper;
    Object localObject2 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, (int[])localObject1, paramInt, 0);
    Object localObject3 = this.mView;
    ViewCompat.saveAttributeDataForStyleable((View)localObject3, ((TextView)localObject3).getContext(), (int[])localObject1, paramAttributeSet, ((TintTypedArray)localObject2).getWrappedTypeArray(), paramInt, 0);
    int i = ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    int j = R.styleable.AppCompatTextHelper_android_drawableLeft;
    if (((TintTypedArray)localObject2).hasValue(j)) {
      this.mDrawableLeftTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject2).getResourceId(j, 0));
    }
    j = R.styleable.AppCompatTextHelper_android_drawableTop;
    if (((TintTypedArray)localObject2).hasValue(j)) {
      this.mDrawableTopTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject2).getResourceId(j, 0));
    }
    j = R.styleable.AppCompatTextHelper_android_drawableRight;
    if (((TintTypedArray)localObject2).hasValue(j)) {
      this.mDrawableRightTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject2).getResourceId(j, 0));
    }
    j = R.styleable.AppCompatTextHelper_android_drawableBottom;
    if (((TintTypedArray)localObject2).hasValue(j)) {
      this.mDrawableBottomTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject2).getResourceId(j, 0));
    }
    j = Build.VERSION.SDK_INT;
    if (j >= 17)
    {
      k = R.styleable.AppCompatTextHelper_android_drawableStart;
      if (((TintTypedArray)localObject2).hasValue(k)) {
        this.mDrawableStartTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject2).getResourceId(k, 0));
      }
      k = R.styleable.AppCompatTextHelper_android_drawableEnd;
      if (((TintTypedArray)localObject2).hasValue(k)) {
        this.mDrawableEndTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject2).getResourceId(k, 0));
      }
    }
    ((TintTypedArray)localObject2).recycle();
    boolean bool1 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
    boolean bool2;
    label352:
    Object localObject5;
    Object localObject6;
    if (i != -1)
    {
      localObject4 = TintTypedArray.obtainStyledAttributes(localContext, i, R.styleable.TextAppearance);
      if (!bool1)
      {
        i = R.styleable.TextAppearance_textAllCaps;
        if (((TintTypedArray)localObject4).hasValue(i))
        {
          bool2 = ((TintTypedArray)localObject4).getBoolean(i, false);
          i = 1;
          break label352;
        }
      }
      bool2 = false;
      i = 0;
      updateTypefaceAndStyle(localContext, (TintTypedArray)localObject4);
      if (j < 23)
      {
        k = R.styleable.TextAppearance_android_textColor;
        if (((TintTypedArray)localObject4).hasValue(k)) {
          localObject1 = ((TintTypedArray)localObject4).getColorStateList(k);
        } else {
          localObject1 = null;
        }
        k = R.styleable.TextAppearance_android_textColorHint;
        if (((TintTypedArray)localObject4).hasValue(k)) {
          localObject3 = ((TintTypedArray)localObject4).getColorStateList(k);
        } else {
          localObject3 = null;
        }
        k = R.styleable.TextAppearance_android_textColorLink;
        localObject5 = localObject1;
        localObject2 = localObject3;
        if (((TintTypedArray)localObject4).hasValue(k))
        {
          localObject6 = ((TintTypedArray)localObject4).getColorStateList(k);
          localObject5 = localObject1;
          localObject1 = localObject3;
          break label482;
        }
      }
      else
      {
        localObject5 = null;
        localObject2 = null;
      }
      localObject6 = null;
      localObject1 = localObject2;
      label482:
      k = R.styleable.TextAppearance_textLocale;
      if (((TintTypedArray)localObject4).hasValue(k)) {
        localObject7 = ((TintTypedArray)localObject4).getString(k);
      } else {
        localObject7 = null;
      }
      if (j >= 26)
      {
        k = R.styleable.TextAppearance_fontVariationSettings;
        if (((TintTypedArray)localObject4).hasValue(k))
        {
          localObject2 = ((TintTypedArray)localObject4).getString(k);
          break label549;
        }
      }
      localObject2 = null;
      label549:
      ((TintTypedArray)localObject4).recycle();
      localObject3 = localObject5;
      localObject5 = localObject7;
    }
    else
    {
      localObject2 = null;
      localObject3 = null;
      localObject5 = null;
      bool2 = false;
      localObject1 = null;
      localObject6 = null;
      i = 0;
    }
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
    if (!bool1)
    {
      k = R.styleable.TextAppearance_textAllCaps;
      if (localTintTypedArray.hasValue(k))
      {
        bool2 = localTintTypedArray.getBoolean(k, false);
        i = 1;
      }
    }
    Object localObject4 = localObject3;
    Object localObject7 = localObject1;
    Object localObject8 = localObject6;
    if (j < 23)
    {
      k = R.styleable.TextAppearance_android_textColor;
      if (localTintTypedArray.hasValue(k)) {
        localObject3 = localTintTypedArray.getColorStateList(k);
      }
      k = R.styleable.TextAppearance_android_textColorHint;
      if (localTintTypedArray.hasValue(k)) {
        localObject1 = localTintTypedArray.getColorStateList(k);
      }
      k = R.styleable.TextAppearance_android_textColorLink;
      localObject4 = localObject3;
      localObject7 = localObject1;
      localObject8 = localObject6;
      if (localTintTypedArray.hasValue(k))
      {
        localObject8 = localTintTypedArray.getColorStateList(k);
        localObject7 = localObject1;
        localObject4 = localObject3;
      }
    }
    int k = R.styleable.TextAppearance_textLocale;
    if (localTintTypedArray.hasValue(k)) {
      localObject5 = localTintTypedArray.getString(k);
    }
    if (j >= 26)
    {
      k = R.styleable.TextAppearance_fontVariationSettings;
      if (localTintTypedArray.hasValue(k))
      {
        localObject1 = localTintTypedArray.getString(k);
        break label807;
      }
    }
    localObject1 = localObject2;
    label807:
    if (j >= 28)
    {
      k = R.styleable.TextAppearance_android_textSize;
      if ((localTintTypedArray.hasValue(k)) && (localTintTypedArray.getDimensionPixelSize(k, -1) == 0)) {
        this.mView.setTextSize(0, 0.0F);
      }
    }
    updateTypefaceAndStyle(localContext, localTintTypedArray);
    localTintTypedArray.recycle();
    if (localObject4 != null) {
      this.mView.setTextColor((ColorStateList)localObject4);
    }
    if (localObject7 != null) {
      this.mView.setHintTextColor((ColorStateList)localObject7);
    }
    if (localObject8 != null) {
      this.mView.setLinkTextColor((ColorStateList)localObject8);
    }
    if ((!bool1) && (i != 0)) {
      setAllCaps(bool2);
    }
    localObject3 = this.mFontTypeface;
    if (localObject3 != null) {
      if (this.mFontWeight == -1) {
        this.mView.setTypeface((Typeface)localObject3, this.mStyle);
      } else {
        this.mView.setTypeface((Typeface)localObject3);
      }
    }
    if (localObject1 != null) {
      this.mView.setFontVariationSettings((String)localObject1);
    }
    if (localObject5 != null) {
      if (j >= 24)
      {
        this.mView.setTextLocales(LocaleList.forLanguageTags((String)localObject5));
      }
      else if (j >= 21)
      {
        localObject1 = ((String)localObject5).substring(0, ((String)localObject5).indexOf(','));
        this.mView.setTextLocale(Locale.forLanguageTag((String)localObject1));
      }
    }
    this.mAutoSizeTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    if ((AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (this.mAutoSizeTextHelper.getAutoSizeTextType() != 0))
    {
      localObject1 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
      if (localObject1.length > 0) {
        if (this.mView.getAutoSizeStepGranularity() != -1.0F) {
          this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        } else {
          this.mView.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
        }
      }
    }
    localObject7 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.AppCompatTextView);
    paramInt = ((TintTypedArray)localObject7).getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
    if (paramInt != -1) {
      paramAttributeSet = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      paramAttributeSet = null;
    }
    paramInt = ((TintTypedArray)localObject7).getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
    if (paramInt != -1) {
      localObject1 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject1 = null;
    }
    paramInt = ((TintTypedArray)localObject7).getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
    if (paramInt != -1) {
      localObject3 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject3 = null;
    }
    paramInt = ((TintTypedArray)localObject7).getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
    if (paramInt != -1) {
      localObject2 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject2 = null;
    }
    paramInt = ((TintTypedArray)localObject7).getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
    if (paramInt != -1) {
      localObject5 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject5 = null;
    }
    paramInt = ((TintTypedArray)localObject7).getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
    if (paramInt != -1) {
      localObject6 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
    } else {
      localObject6 = null;
    }
    setCompoundDrawables(paramAttributeSet, (Drawable)localObject1, (Drawable)localObject3, (Drawable)localObject2, (Drawable)localObject5, (Drawable)localObject6);
    paramInt = R.styleable.AppCompatTextView_drawableTint;
    if (((TintTypedArray)localObject7).hasValue(paramInt))
    {
      paramAttributeSet = ((TintTypedArray)localObject7).getColorStateList(paramInt);
      TextViewCompat.setCompoundDrawableTintList(this.mView, paramAttributeSet);
    }
    paramInt = R.styleable.AppCompatTextView_drawableTintMode;
    if (((TintTypedArray)localObject7).hasValue(paramInt))
    {
      paramAttributeSet = DrawableUtils.parseTintMode(((TintTypedArray)localObject7).getInt(paramInt, -1), null);
      TextViewCompat.setCompoundDrawableTintMode(this.mView, paramAttributeSet);
    }
    paramInt = ((TintTypedArray)localObject7).getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
    j = ((TintTypedArray)localObject7).getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
    i = ((TintTypedArray)localObject7).getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
    ((TintTypedArray)localObject7).recycle();
    if (paramInt != -1) {
      TextViewCompat.setFirstBaselineToTopHeight(this.mView, paramInt);
    }
    if (j != -1) {
      TextViewCompat.setLastBaselineToBottomHeight(this.mView, j);
    }
    if (i != -1) {
      TextViewCompat.setLineHeight(this.mView, i);
    }
  }
  
  void onAsyncTypefaceReceived(WeakReference<TextView> paramWeakReference, Typeface paramTypeface)
  {
    if (this.mAsyncFontPending)
    {
      this.mFontTypeface = paramTypeface;
      paramWeakReference = (TextView)paramWeakReference.get();
      if (paramWeakReference != null) {
        paramWeakReference.setTypeface(paramTypeface, this.mStyle);
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
      autoSizeText();
    }
  }
  
  void onSetCompoundDrawables()
  {
    applyCompoundDrawablesTints();
  }
  
  void onSetTextAppearance(Context paramContext, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    paramInt = R.styleable.TextAppearance_textAllCaps;
    if (localTintTypedArray.hasValue(paramInt)) {
      setAllCaps(localTintTypedArray.getBoolean(paramInt, false));
    }
    paramInt = Build.VERSION.SDK_INT;
    if (paramInt < 23)
    {
      i = R.styleable.TextAppearance_android_textColor;
      if (localTintTypedArray.hasValue(i))
      {
        ColorStateList localColorStateList = localTintTypedArray.getColorStateList(i);
        if (localColorStateList != null) {
          this.mView.setTextColor(localColorStateList);
        }
      }
    }
    int i = R.styleable.TextAppearance_android_textSize;
    if ((localTintTypedArray.hasValue(i)) && (localTintTypedArray.getDimensionPixelSize(i, -1) == 0)) {
      this.mView.setTextSize(0, 0.0F);
    }
    updateTypefaceAndStyle(paramContext, localTintTypedArray);
    if (paramInt >= 26)
    {
      paramInt = R.styleable.TextAppearance_fontVariationSettings;
      if (localTintTypedArray.hasValue(paramInt))
      {
        paramContext = localTintTypedArray.getString(paramInt);
        if (paramContext != null) {
          this.mView.setFontVariationSettings(paramContext);
        }
      }
    }
    localTintTypedArray.recycle();
    paramContext = this.mFontTypeface;
    if (paramContext != null) {
      this.mView.setTypeface(paramContext, this.mStyle);
    }
  }
  
  void setAllCaps(boolean paramBoolean)
  {
    this.mView.setAllCaps(paramBoolean);
  }
  
  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  void setCompoundDrawableTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mDrawableTint == null) {
      this.mDrawableTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mDrawableTint;
    localTintInfo.mTintList = paramColorStateList;
    boolean bool;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    localTintInfo.mHasTintList = bool;
    setCompoundTints();
  }
  
  void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mDrawableTint == null) {
      this.mDrawableTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mDrawableTint;
    localTintInfo.mTintMode = paramMode;
    boolean bool;
    if (paramMode != null) {
      bool = true;
    } else {
      bool = false;
    }
    localTintInfo.mHasTintMode = bool;
    setCompoundTints();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setTextSize(int paramInt, float paramFloat)
  {
    if ((!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (!isAutoSizeEnabled())) {
      setTextSizeInternal(paramInt, paramFloat);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatTextHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */