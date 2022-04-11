package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.base.R.styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_AUTO = 2;
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private int mColor;
  private int mSize;
  private View zaas;
  private View.OnClickListener zaat = null;
  
  public SignInButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.SignInButton, 0, 0);
    try
    {
      this.mSize = paramContext.getInt(R.styleable.SignInButton_buttonSize, 0);
      this.mColor = paramContext.getInt(R.styleable.SignInButton_colorScheme, 2);
      paramContext.recycle();
      setStyle(this.mSize, this.mColor);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public final void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.zaat;
    if ((localOnClickListener != null) && (paramView == this.zaas)) {
      localOnClickListener.onClick(this);
    }
  }
  
  public final void setColorScheme(int paramInt)
  {
    setStyle(this.mSize, paramInt);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.zaas.setEnabled(paramBoolean);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zaat = paramOnClickListener;
    paramOnClickListener = this.zaas;
    if (paramOnClickListener != null) {
      paramOnClickListener.setOnClickListener(this);
    }
  }
  
  @Deprecated
  public final void setScopes(Scope[] paramArrayOfScope)
  {
    setStyle(this.mSize, this.mColor);
  }
  
  public final void setSize(int paramInt)
  {
    setStyle(paramInt, this.mColor);
  }
  
  public final void setStyle(int paramInt1, int paramInt2)
  {
    this.mSize = paramInt1;
    this.mColor = paramInt2;
    Context localContext = getContext();
    View localView = this.zaas;
    if (localView != null) {
      removeView(localView);
    }
    try
    {
      this.zaas = SignInButtonCreator.createView(localContext, this.mSize, this.mColor);
    }
    catch (RemoteCreator.RemoteCreatorException localRemoteCreatorException)
    {
      Log.w("SignInButton", "Sign in button not found, using placeholder instead");
      paramInt2 = this.mSize;
      paramInt1 = this.mColor;
      SignInButtonImpl localSignInButtonImpl = new SignInButtonImpl(localContext);
      localSignInButtonImpl.configure(localContext.getResources(), paramInt2, paramInt1);
      this.zaas = localSignInButtonImpl;
    }
    addView(this.zaas);
    this.zaas.setEnabled(isEnabled());
    this.zaas.setOnClickListener(this);
  }
  
  @Deprecated
  public final void setStyle(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    setStyle(paramInt1, paramInt2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ButtonSize {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ColorScheme {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\SignInButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */