package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;
import com.google.android.material.animation.AnimationUtils;

class ClearTextEndIconDelegate
  extends EndIconDelegate
{
  private static final int ANIMATION_FADE_DURATION = 100;
  private static final int ANIMATION_SCALE_DURATION = 150;
  private static final float ANIMATION_SCALE_FROM_VALUE = 0.8F;
  private final TextWatcher clearTextEndIconTextWatcher = new TextWatcher()
  {
    public void afterTextChanged(@NonNull Editable paramAnonymousEditable)
    {
      if (ClearTextEndIconDelegate.this.textInputLayout.getSuffixText() != null) {
        return;
      }
      ClearTextEndIconDelegate.this.animateIcon(ClearTextEndIconDelegate.access$000(paramAnonymousEditable));
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener()
  {
    public void onEditTextAttached(@NonNull TextInputLayout paramAnonymousTextInputLayout)
    {
      EditText localEditText = paramAnonymousTextInputLayout.getEditText();
      boolean bool;
      if ((localEditText.hasFocus()) && (ClearTextEndIconDelegate.hasText(localEditText.getText()))) {
        bool = true;
      } else {
        bool = false;
      }
      paramAnonymousTextInputLayout.setEndIconVisible(bool);
      paramAnonymousTextInputLayout.setEndIconCheckable(false);
      localEditText.setOnFocusChangeListener(ClearTextEndIconDelegate.this.onFocusChangeListener);
      localEditText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
      localEditText.addTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
    }
  };
  private final TextInputLayout.OnEndIconChangedListener endIconChangedListener = new TextInputLayout.OnEndIconChangedListener()
  {
    public void onEndIconChanged(@NonNull TextInputLayout paramAnonymousTextInputLayout, int paramAnonymousInt)
    {
      paramAnonymousTextInputLayout = paramAnonymousTextInputLayout.getEditText();
      if ((paramAnonymousTextInputLayout != null) && (paramAnonymousInt == 2))
      {
        paramAnonymousTextInputLayout.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
        if (paramAnonymousTextInputLayout.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.onFocusChangeListener) {
          paramAnonymousTextInputLayout.setOnFocusChangeListener(null);
        }
      }
    }
  };
  private AnimatorSet iconInAnim;
  private ValueAnimator iconOutAnim;
  private final View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener()
  {
    public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      boolean bool1 = TextUtils.isEmpty(((EditText)paramAnonymousView).getText());
      boolean bool2 = true;
      paramAnonymousView = ClearTextEndIconDelegate.this;
      if (((bool1 ^ true)) && (paramAnonymousBoolean)) {
        paramAnonymousBoolean = bool2;
      } else {
        paramAnonymousBoolean = false;
      }
      paramAnonymousView.animateIcon(paramAnonymousBoolean);
    }
  };
  
  ClearTextEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  private void animateIcon(boolean paramBoolean)
  {
    int i;
    if (this.textInputLayout.isEndIconVisible() == paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramBoolean)
    {
      this.iconOutAnim.cancel();
      this.iconInAnim.start();
      if (i != 0) {
        this.iconInAnim.end();
      }
    }
    else
    {
      this.iconInAnim.cancel();
      this.iconOutAnim.start();
      if (i != 0) {
        this.iconOutAnim.end();
      }
    }
  }
  
  private ValueAnimator getAlphaAnimator(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
    paramVarArgs.setDuration(100L);
    paramVarArgs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(@NonNull ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ClearTextEndIconDelegate.this.endIconView.setAlpha(f);
      }
    });
    return paramVarArgs;
  }
  
  private ValueAnimator getScaleAnimator()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.8F, 1.0F });
    localValueAnimator.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    localValueAnimator.setDuration(150L);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(@NonNull ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        ClearTextEndIconDelegate.this.endIconView.setScaleX(f);
        ClearTextEndIconDelegate.this.endIconView.setScaleY(f);
      }
    });
    return localValueAnimator;
  }
  
  private static boolean hasText(@NonNull Editable paramEditable)
  {
    boolean bool;
    if (paramEditable.length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void initAnimators()
  {
    ValueAnimator localValueAnimator1 = getScaleAnimator();
    ValueAnimator localValueAnimator2 = getAlphaAnimator(new float[] { 0.0F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    this.iconInAnim = localAnimatorSet;
    localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.iconInAnim.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
      }
    });
    localValueAnimator2 = getAlphaAnimator(new float[] { 1.0F, 0.0F });
    this.iconOutAnim = localValueAnimator2;
    localValueAnimator2.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
      }
    });
  }
  
  void initialize()
  {
    this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R.drawable.mtrl_ic_cancel));
    TextInputLayout localTextInputLayout = this.textInputLayout;
    localTextInputLayout.setEndIconContentDescription(localTextInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
    this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ClearTextEndIconDelegate.this.textInputLayout.getEditText().getText();
        if (paramAnonymousView != null) {
          paramAnonymousView.clear();
        }
      }
    });
    this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
    this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
    initAnimators();
  }
  
  void onSuffixVisibilityChanged(boolean paramBoolean)
  {
    if (this.textInputLayout.getSuffixText() == null) {
      return;
    }
    animateIcon(paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\textfield\ClearTextEndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */