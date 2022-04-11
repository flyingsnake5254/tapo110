package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import f.a.f.a.d;

public class SkinCompatCheckedTextView
  extends AppCompatCheckedTextView
  implements g
{
  private static final int[] c = { 16843016 };
  private int d = 0;
  private h f;
  private a q;
  
  public SkinCompatCheckedTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, f.a.a.checkedTextViewStyle);
  }
  
  public SkinCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = new a(this);
    this.q = ((a)localObject);
    ((a)localObject).c(paramAttributeSet, paramInt);
    localObject = h.g(this);
    this.f = ((h)localObject);
    ((h)localObject).i(paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, c, paramInt, 0);
    this.d = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    a();
  }
  
  private void a()
  {
    int i = c.a(this.d);
    this.d = i;
    if (i != 0) {
      setCheckMarkDrawable(d.d(getContext(), this.d));
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
  
  public void setCheckMarkDrawable(@DrawableRes int paramInt)
  {
    this.d = paramInt;
    a();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatCheckedTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */