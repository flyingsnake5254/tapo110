package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatCheckBox;

public class SkinCompatCheckBox
  extends AppCompatCheckBox
  implements g
{
  private b c;
  private h d;
  private a f;
  
  public SkinCompatCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, f.a.a.checkboxStyle);
  }
  
  public SkinCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new b(this);
    this.c = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
    paramContext = new a(this);
    this.f = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
    paramContext = h.g(this);
    this.d = paramContext;
    paramContext.i(paramAttributeSet, paramInt);
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    a locala = this.f;
    if (locala != null) {
      locala.d(paramInt);
    }
  }
  
  public void setButtonDrawable(@DrawableRes int paramInt)
  {
    super.setButtonDrawable(paramInt);
    b localb = this.c;
    if (localb != null) {
      localb.d(paramInt);
    }
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    h localh = this.d;
    if (localh != null) {
      localh.j(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    h localh = this.d;
    if (localh != null) {
      localh.k(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTextAppearance(int paramInt)
  {
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    h localh = this.d;
    if (localh != null) {
      localh.l(paramContext, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */