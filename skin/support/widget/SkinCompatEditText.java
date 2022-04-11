package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.appcompat.R.attr;
import androidx.appcompat.widget.AppCompatEditText;

public class SkinCompatEditText
  extends AppCompatEditText
  implements g
{
  private h c;
  private a d;
  
  public SkinCompatEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.editTextStyle);
  }
  
  public SkinCompatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new a(this);
    this.d = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
    paramContext = h.g(this);
    this.c = paramContext;
    paramContext.i(paramAttributeSet, paramInt);
  }
  
  public int getTextColorResId()
  {
    h localh = this.c;
    int i;
    if (localh != null) {
      i = localh.h();
    } else {
      i = 0;
    }
    return i;
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    a locala = this.d;
    if (locala != null) {
      locala.d(paramInt);
    }
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    h localh = this.c;
    if (localh != null) {
      localh.j(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    h localh = this.c;
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
    h localh = this.c;
    if (localh != null) {
      localh.l(paramContext, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */