package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.AutoCompleteTextView.OnDismissListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

class DropdownMenuEndIconDelegate
  extends EndIconDelegate
{
  private static final int ANIMATION_FADE_IN_DURATION = 67;
  private static final int ANIMATION_FADE_OUT_DURATION = 50;
  private static final boolean IS_LOLLIPOP;
  private final TextInputLayout.AccessibilityDelegate accessibilityDelegate = new TextInputLayout.AccessibilityDelegate(this.textInputLayout)
  {
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, @NonNull AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
      if (DropdownMenuEndIconDelegate.this.textInputLayout.getEditText().getKeyListener() == null) {
        paramAnonymousAccessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
      }
      if (paramAnonymousAccessibilityNodeInfoCompat.isShowingHintText()) {
        paramAnonymousAccessibilityNodeInfoCompat.setHintText(null);
      }
    }
    
    public void onPopulateAccessibilityEvent(View paramAnonymousView, @NonNull AccessibilityEvent paramAnonymousAccessibilityEvent)
    {
      super.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      paramAnonymousView = DropdownMenuEndIconDelegate.this;
      paramAnonymousView = paramAnonymousView.castAutoCompleteTextViewOrThrow(paramAnonymousView.textInputLayout.getEditText());
      if ((paramAnonymousAccessibilityEvent.getEventType() == 1) && (DropdownMenuEndIconDelegate.this.accessibilityManager.isTouchExplorationEnabled())) {
        DropdownMenuEndIconDelegate.this.showHideDropdown(paramAnonymousView);
      }
    }
  };
  @Nullable
  private AccessibilityManager accessibilityManager;
  private final TextInputLayout.OnEditTextAttachedListener dropdownMenuOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener()
  {
    public void onEditTextAttached(@NonNull TextInputLayout paramAnonymousTextInputLayout)
    {
      AutoCompleteTextView localAutoCompleteTextView = DropdownMenuEndIconDelegate.this.castAutoCompleteTextViewOrThrow(paramAnonymousTextInputLayout.getEditText());
      DropdownMenuEndIconDelegate.this.setPopupBackground(localAutoCompleteTextView);
      DropdownMenuEndIconDelegate.this.addRippleEffect(localAutoCompleteTextView);
      DropdownMenuEndIconDelegate.this.setUpDropdownShowHideBehavior(localAutoCompleteTextView);
      localAutoCompleteTextView.setThreshold(0);
      localAutoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
      localAutoCompleteTextView.addTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
      paramAnonymousTextInputLayout.setEndIconCheckable(true);
      paramAnonymousTextInputLayout.setErrorIconDrawable(null);
      paramAnonymousTextInputLayout.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.this.accessibilityDelegate);
      paramAnonymousTextInputLayout.setEndIconVisible(true);
    }
  };
  private long dropdownPopupActivatedAt = Long.MAX_VALUE;
  private boolean dropdownPopupDirty = false;
  @SuppressLint({"ClickableViewAccessibility"})
  private final TextInputLayout.OnEndIconChangedListener endIconChangedListener = new TextInputLayout.OnEndIconChangedListener()
  {
    public void onEndIconChanged(@NonNull TextInputLayout paramAnonymousTextInputLayout, int paramAnonymousInt)
    {
      paramAnonymousTextInputLayout = (AutoCompleteTextView)paramAnonymousTextInputLayout.getEditText();
      if ((paramAnonymousTextInputLayout != null) && (paramAnonymousInt == 3))
      {
        paramAnonymousTextInputLayout.removeTextChangedListener(DropdownMenuEndIconDelegate.this.exposedDropdownEndIconTextWatcher);
        if (paramAnonymousTextInputLayout.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.this.onFocusChangeListener) {
          paramAnonymousTextInputLayout.setOnFocusChangeListener(null);
        }
        paramAnonymousTextInputLayout.setOnTouchListener(null);
        if (DropdownMenuEndIconDelegate.IS_LOLLIPOP) {
          paramAnonymousTextInputLayout.setOnDismissListener(null);
        }
      }
    }
  };
  private final TextWatcher exposedDropdownEndIconTextWatcher = new TextWatcher()
  {
    public void afterTextChanged(final Editable paramAnonymousEditable)
    {
      paramAnonymousEditable = DropdownMenuEndIconDelegate.this;
      paramAnonymousEditable = paramAnonymousEditable.castAutoCompleteTextViewOrThrow(paramAnonymousEditable.textInputLayout.getEditText());
      paramAnonymousEditable.post(new Runnable()
      {
        public void run()
        {
          boolean bool = paramAnonymousEditable.isPopupShowing();
          DropdownMenuEndIconDelegate.this.setEndIconChecked(bool);
          DropdownMenuEndIconDelegate.access$202(DropdownMenuEndIconDelegate.this, bool);
        }
      });
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private ValueAnimator fadeInAnim;
  private ValueAnimator fadeOutAnim;
  private StateListDrawable filledPopupBackground;
  private boolean isEndIconChecked = false;
  private final View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener()
  {
    public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      DropdownMenuEndIconDelegate.this.textInputLayout.setEndIconActivated(paramAnonymousBoolean);
      if (!paramAnonymousBoolean)
      {
        DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
        DropdownMenuEndIconDelegate.access$202(DropdownMenuEndIconDelegate.this, false);
      }
    }
  };
  private MaterialShapeDrawable outlinedPopupBackground;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    IS_LOLLIPOP = bool;
  }
  
  DropdownMenuEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  private void addRippleEffect(@NonNull AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (paramAutoCompleteTextView.getKeyListener() != null) {
      return;
    }
    int i = this.textInputLayout.getBoxBackgroundMode();
    MaterialShapeDrawable localMaterialShapeDrawable = this.textInputLayout.getBoxBackground();
    int j = MaterialColors.getColor(paramAutoCompleteTextView, R.attr.colorControlHighlight);
    int[][] arrayOfInt = new int[2][];
    arrayOfInt[0] = { 16842919 };
    arrayOfInt[1] = new int[0];
    if (i == 2) {
      addRippleEffectOnOutlinedLayout(paramAutoCompleteTextView, j, arrayOfInt, localMaterialShapeDrawable);
    } else if (i == 1) {
      addRippleEffectOnFilledLayout(paramAutoCompleteTextView, j, arrayOfInt, localMaterialShapeDrawable);
    }
  }
  
  private void addRippleEffectOnFilledLayout(@NonNull AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfInt, @NonNull MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    int i = this.textInputLayout.getBoxBackgroundColor();
    paramInt = MaterialColors.layer(paramInt, i, 0.1F);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt;
    arrayOfInt[1] = i;
    if (IS_LOLLIPOP)
    {
      ViewCompat.setBackground(paramAutoCompleteTextView, new RippleDrawable(new ColorStateList(paramArrayOfInt, arrayOfInt), paramMaterialShapeDrawable, paramMaterialShapeDrawable));
    }
    else
    {
      MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(paramMaterialShapeDrawable.getShapeAppearanceModel());
      localMaterialShapeDrawable.setFillColor(new ColorStateList(paramArrayOfInt, arrayOfInt));
      paramArrayOfInt = new LayerDrawable(new Drawable[] { paramMaterialShapeDrawable, localMaterialShapeDrawable });
      paramInt = ViewCompat.getPaddingStart(paramAutoCompleteTextView);
      int j = paramAutoCompleteTextView.getPaddingTop();
      i = ViewCompat.getPaddingEnd(paramAutoCompleteTextView);
      int k = paramAutoCompleteTextView.getPaddingBottom();
      ViewCompat.setBackground(paramAutoCompleteTextView, paramArrayOfInt);
      ViewCompat.setPaddingRelative(paramAutoCompleteTextView, paramInt, j, i, k);
    }
  }
  
  private void addRippleEffectOnOutlinedLayout(@NonNull AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfInt, @NonNull MaterialShapeDrawable paramMaterialShapeDrawable)
  {
    int i = MaterialColors.getColor(paramAutoCompleteTextView, R.attr.colorSurface);
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(paramMaterialShapeDrawable.getShapeAppearanceModel());
    paramInt = MaterialColors.layer(paramInt, i, 0.1F);
    localMaterialShapeDrawable.setFillColor(new ColorStateList(paramArrayOfInt, new int[] { paramInt, 0 }));
    if (IS_LOLLIPOP)
    {
      localMaterialShapeDrawable.setTint(i);
      ColorStateList localColorStateList = new ColorStateList(paramArrayOfInt, new int[] { paramInt, i });
      paramArrayOfInt = new MaterialShapeDrawable(paramMaterialShapeDrawable.getShapeAppearanceModel());
      paramArrayOfInt.setTint(-1);
      paramArrayOfInt = new LayerDrawable(new Drawable[] { new RippleDrawable(localColorStateList, localMaterialShapeDrawable, paramArrayOfInt), paramMaterialShapeDrawable });
    }
    else
    {
      paramArrayOfInt = new LayerDrawable(new Drawable[] { localMaterialShapeDrawable, paramMaterialShapeDrawable });
    }
    ViewCompat.setBackground(paramAutoCompleteTextView, paramArrayOfInt);
  }
  
  @NonNull
  private AutoCompleteTextView castAutoCompleteTextViewOrThrow(EditText paramEditText)
  {
    if ((paramEditText instanceof AutoCompleteTextView)) {
      return (AutoCompleteTextView)paramEditText;
    }
    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
  }
  
  private ValueAnimator getAlphaAnimator(int paramInt, float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
    paramVarArgs.setDuration(paramInt);
    paramVarArgs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(@NonNull ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        DropdownMenuEndIconDelegate.this.endIconView.setAlpha(f);
      }
    });
    return paramVarArgs;
  }
  
  private MaterialShapeDrawable getPopUpMaterialShapeDrawable(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    ShapeAppearanceModel localShapeAppearanceModel = ShapeAppearanceModel.builder().setTopLeftCornerSize(paramFloat1).setTopRightCornerSize(paramFloat1).setBottomLeftCornerSize(paramFloat2).setBottomRightCornerSize(paramFloat2).build();
    MaterialShapeDrawable localMaterialShapeDrawable = MaterialShapeDrawable.createWithElevationOverlay(this.context, paramFloat3);
    localMaterialShapeDrawable.setShapeAppearanceModel(localShapeAppearanceModel);
    localMaterialShapeDrawable.setPadding(0, paramInt, 0, paramInt);
    return localMaterialShapeDrawable;
  }
  
  private void initAnimators()
  {
    this.fadeInAnim = getAlphaAnimator(67, new float[] { 0.0F, 1.0F });
    ValueAnimator localValueAnimator = getAlphaAnimator(50, new float[] { 1.0F, 0.0F });
    this.fadeOutAnim = localValueAnimator;
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        paramAnonymousAnimator = DropdownMenuEndIconDelegate.this;
        paramAnonymousAnimator.endIconView.setChecked(paramAnonymousAnimator.isEndIconChecked);
        DropdownMenuEndIconDelegate.this.fadeInAnim.start();
      }
    });
  }
  
  private boolean isDropdownPopupActive()
  {
    long l = System.currentTimeMillis() - this.dropdownPopupActivatedAt;
    boolean bool;
    if ((l >= 0L) && (l <= 300L)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void setEndIconChecked(boolean paramBoolean)
  {
    if (this.isEndIconChecked != paramBoolean)
    {
      this.isEndIconChecked = paramBoolean;
      this.fadeInAnim.cancel();
      this.fadeOutAnim.start();
    }
  }
  
  private void setPopupBackground(@NonNull AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (IS_LOLLIPOP)
    {
      int i = this.textInputLayout.getBoxBackgroundMode();
      if (i == 2) {
        paramAutoCompleteTextView.setDropDownBackgroundDrawable(this.outlinedPopupBackground);
      } else if (i == 1) {
        paramAutoCompleteTextView.setDropDownBackgroundDrawable(this.filledPopupBackground);
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void setUpDropdownShowHideBehavior(@NonNull final AutoCompleteTextView paramAutoCompleteTextView)
  {
    paramAutoCompleteTextView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(@NonNull View paramAnonymousView, @NonNull MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          if (DropdownMenuEndIconDelegate.this.isDropdownPopupActive()) {
            DropdownMenuEndIconDelegate.access$202(DropdownMenuEndIconDelegate.this, false);
          }
          DropdownMenuEndIconDelegate.this.showHideDropdown(paramAutoCompleteTextView);
        }
        return false;
      }
    });
    paramAutoCompleteTextView.setOnFocusChangeListener(this.onFocusChangeListener);
    if (IS_LOLLIPOP) {
      paramAutoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener()
      {
        public void onDismiss()
        {
          DropdownMenuEndIconDelegate.access$202(DropdownMenuEndIconDelegate.this, true);
          DropdownMenuEndIconDelegate.access$1302(DropdownMenuEndIconDelegate.this, System.currentTimeMillis());
          DropdownMenuEndIconDelegate.this.setEndIconChecked(false);
        }
      });
    }
  }
  
  private void showHideDropdown(@Nullable AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (paramAutoCompleteTextView == null) {
      return;
    }
    if (isDropdownPopupActive()) {
      this.dropdownPopupDirty = false;
    }
    if (!this.dropdownPopupDirty)
    {
      if (IS_LOLLIPOP)
      {
        setEndIconChecked(this.isEndIconChecked ^ true);
      }
      else
      {
        this.isEndIconChecked ^= true;
        this.endIconView.toggle();
      }
      if (this.isEndIconChecked)
      {
        paramAutoCompleteTextView.requestFocus();
        paramAutoCompleteTextView.showDropDown();
      }
      else
      {
        paramAutoCompleteTextView.dismissDropDown();
      }
    }
    else
    {
      this.dropdownPopupDirty = false;
    }
  }
  
  void initialize()
  {
    float f1 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
    float f2 = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
    int i = this.context.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
    MaterialShapeDrawable localMaterialShapeDrawable = getPopUpMaterialShapeDrawable(f1, f1, f2, i);
    Object localObject = getPopUpMaterialShapeDrawable(0.0F, f1, f2, i);
    this.outlinedPopupBackground = localMaterialShapeDrawable;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    this.filledPopupBackground = localStateListDrawable;
    localStateListDrawable.addState(new int[] { 16842922 }, localMaterialShapeDrawable);
    this.filledPopupBackground.addState(new int[0], (Drawable)localObject);
    if (IS_LOLLIPOP) {
      i = R.drawable.mtrl_dropdown_arrow;
    } else {
      i = R.drawable.mtrl_ic_arrow_drop_down;
    }
    this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, i));
    localObject = this.textInputLayout;
    ((TextInputLayout)localObject).setEndIconContentDescription(((LinearLayout)localObject).getResources().getText(R.string.exposed_dropdown_menu_content_description));
    this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = (AutoCompleteTextView)DropdownMenuEndIconDelegate.this.textInputLayout.getEditText();
        DropdownMenuEndIconDelegate.this.showHideDropdown(paramAnonymousView);
      }
    });
    this.textInputLayout.addOnEditTextAttachedListener(this.dropdownMenuOnEditTextAttachedListener);
    this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
    initAnimators();
    ViewCompat.setImportantForAccessibility(this.endIconView, 2);
    this.accessibilityManager = ((AccessibilityManager)this.context.getSystemService("accessibility"));
  }
  
  boolean isBoxBackgroundModeSupported(int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean shouldTintIconOnError()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\textfield\DropdownMenuEndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */