package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import f.a.f.a.d;

public class SkinCompatAutoCompleteTextView
  extends AppCompatAutoCompleteTextView
  implements g
{
  private static final int[] c = { 16843126 };
  private int d = 0;
  private h f;
  private a q;
  
  public SkinCompatAutoCompleteTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, f.a.a.autoCompleteTextViewStyle);
  }
  
  public SkinCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, c, paramInt, 0);
    if (paramContext.hasValue(0)) {
      this.d = paramContext.getResourceId(0, 0);
    }
    paramContext.recycle();
    a();
    paramContext = new a(this);
    this.q = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
    paramContext = h.g(this);
    this.f = paramContext;
    paramContext.i(paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int i = c.a(this.d);
    this.d = i;
    if (i != 0)
    {
      Drawable localDrawable = d.d(getContext(), this.d);
      if (localDrawable != null) {
        setDropDownBackgroundDrawable(localDrawable);
      }
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    a locala = this.q;
    if (locala != null) {
      locala.d(paramInt);
    }
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    h localh = this.f;
    if (localh != null) {
      localh.j(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    h localh = this.f;
    if (localh != null) {
      localh.k(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setDropDownBackgroundResource(@DrawableRes int paramInt)
  {
    super.setDropDownBackgroundResource(paramInt);
    this.d = paramInt;
    a();
  }
  
  public void setTextAppearance(int paramInt)
  {
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    h localh = this.f;
    if (localh != null) {
      localh.l(paramContext, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatAutoCompleteTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */