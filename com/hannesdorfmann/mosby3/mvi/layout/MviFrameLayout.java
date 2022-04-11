package com.hannesdorfmann.mosby3.mvi.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.hannesdorfmann.mosby3.h;
import com.hannesdorfmann.mosby3.i;
import com.hannesdorfmann.mosby3.j;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;

public abstract class MviFrameLayout<V extends b, P extends d<V, ?>>
  extends FrameLayout
  implements i<V, P>, b
{
  private boolean c = false;
  protected h<V, P> d;
  
  public MviFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MviFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MviFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @NonNull
  protected h<V, P> getMviDelegate()
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
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getMviDelegate().onAttachedToWindow();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getMviDelegate().onDetachedFromWindow();
  }
  
  @SuppressLint({"MissingSuperCall"})
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    getMviDelegate().onRestoreInstanceState(paramParcelable);
  }
  
  @SuppressLint({"MissingSuperCall"})
  public Parcelable onSaveInstanceState()
  {
    return getMviDelegate().onSaveInstanceState();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\mvi\layout\MviFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */