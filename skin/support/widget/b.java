package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.widget.CompoundButtonCompat;

public class b
  extends c
{
  private final CompoundButton a;
  private int b = 0;
  private int c = 0;
  
  public b(CompoundButton paramCompoundButton)
  {
    this.a = paramCompoundButton;
  }
  
  public void b()
  {
    int i = c.a(this.b);
    this.b = i;
    CompoundButton localCompoundButton;
    if (i != 0)
    {
      localCompoundButton = this.a;
      localCompoundButton.setButtonDrawable(f.a.f.a.d.d(localCompoundButton.getContext(), this.b));
    }
    i = c.a(this.c);
    this.c = i;
    if (i != 0)
    {
      localCompoundButton = this.a;
      CompoundButtonCompat.setButtonTintList(localCompoundButton, f.a.f.a.d.b(localCompoundButton.getContext(), this.c));
    }
  }
  
  void c(AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = this.a.getContext().obtainStyledAttributes(paramAttributeSet, f.a.d.CompoundButton, paramInt, 0);
    try
    {
      paramInt = f.a.d.CompoundButton_android_button;
      if (localTypedArray.hasValue(paramInt)) {
        this.b = localTypedArray.getResourceId(paramInt, 0);
      }
      paramInt = f.a.d.CompoundButton_buttonTint;
      if (localTypedArray.hasValue(paramInt)) {
        this.c = localTypedArray.getResourceId(paramInt, 0);
      }
      localTypedArray.recycle();
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  public void d(int paramInt)
  {
    this.b = paramInt;
    b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */