package skin.support.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;

@TargetApi(17)
@RequiresApi(17)
public class i
  extends h
{
  private int h = 0;
  private int i = 0;
  
  public i(TextView paramTextView)
  {
    super(paramTextView);
  }
  
  protected void b()
  {
    int j = c.a(this.e);
    this.e = j;
    Object localObject1 = null;
    if (j != 0) {
      localObject2 = f.a.f.a.d.d(this.a.getContext(), this.e);
    } else {
      localObject2 = null;
    }
    j = c.a(this.g);
    this.g = j;
    Drawable localDrawable1;
    if (j != 0) {
      localDrawable1 = f.a.f.a.d.d(this.a.getContext(), this.g);
    } else {
      localDrawable1 = null;
    }
    j = c.a(this.f);
    this.f = j;
    Object localObject3;
    if (j != 0) {
      localObject3 = f.a.f.a.d.d(this.a.getContext(), this.f);
    } else {
      localObject3 = null;
    }
    j = c.a(this.d);
    this.d = j;
    Drawable localDrawable2;
    if (j != 0) {
      localDrawable2 = f.a.f.a.d.d(this.a.getContext(), this.d);
    } else {
      localDrawable2 = null;
    }
    Object localObject4;
    if (this.h != 0) {
      localObject4 = f.a.f.a.d.d(this.a.getContext(), this.h);
    } else {
      localObject4 = null;
    }
    if (localObject4 == null) {
      localObject4 = localObject2;
    }
    Object localObject2 = localObject1;
    if (this.i != 0) {
      localObject2 = f.a.f.a.d.d(this.a.getContext(), this.i);
    }
    if (localObject2 != null) {
      localObject3 = localObject2;
    }
    if ((this.e != 0) || (this.g != 0) || (this.f != 0) || (this.d != 0) || (this.h != 0) || (this.i != 0)) {
      this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject4, localDrawable1, (Drawable)localObject3, localDrawable2);
    }
  }
  
  public void i(AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = this.a.getContext().obtainStyledAttributes(paramAttributeSet, f.a.d.SkinCompatTextHelper, paramInt, 0);
    int j = f.a.d.SkinCompatTextHelper_android_drawableStart;
    if (localTypedArray.hasValue(j))
    {
      j = localTypedArray.getResourceId(j, 0);
      this.h = j;
      this.h = c.a(j);
    }
    j = f.a.d.SkinCompatTextHelper_android_drawableEnd;
    if (localTypedArray.hasValue(j))
    {
      j = localTypedArray.getResourceId(j, 0);
      this.i = j;
      this.i = c.a(j);
    }
    localTypedArray.recycle();
    super.i(paramAttributeSet, paramInt);
  }
  
  public void j(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    this.h = paramInt1;
    this.g = paramInt2;
    this.i = paramInt3;
    this.d = paramInt4;
    b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */