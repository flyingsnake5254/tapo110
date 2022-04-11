package com.hannesdorfmann.mosby3.mvi.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.hannesdorfmann.mosby3.h;
import com.hannesdorfmann.mosby3.i;
import com.hannesdorfmann.mosby3.j;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;

public abstract class MviLinearLayout<V extends b, P extends d<V, ?>>
  extends LinearLayout
  implements b, i<V, P>
{
  private boolean c = false;
  protected h<V, P> d;
  
  public MviLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MviLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MviLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @NonNull
  protected h<V, P> getMvpDelegate()
  {
    if (this.d == null) {
      this.d = new j(this, this, true);
    }
    return this.d;
  }
  
  public V getMvpView()
  {
    return this;
  }
  
  public final void n0(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getMvpDelegate().onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getMvpDelegate().onDetachedFromWindow();
  }
  
  @SuppressLint({"MissingSuperCall"})
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    getMvpDelegate().onRestoreInstanceState(paramParcelable);
  }
  
  @SuppressLint({"MissingSuperCall"})
  protected Parcelable onSaveInstanceState()
  {
    return getMvpDelegate().onSaveInstanceState();
  }
  
  public final Parcelable r()
  {
    return super.onSaveInstanceState();
  }
  
  public void setRestoringViewState(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\mvi\layout\MviLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */