package skin.support.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import f.a.b;

public class h
  extends c
{
  final TextView a;
  private int b = 0;
  private int c = 0;
  protected int d = 0;
  protected int e = 0;
  protected int f = 0;
  protected int g = 0;
  
  public h(TextView paramTextView)
  {
    this.a = paramTextView;
  }
  
  private void e()
  {
    int i = c.a(this.c);
    this.c = i;
    if (i == b.abc_hint_foreground_material_light) {
      return;
    }
    if (i != 0) {}
    try
    {
      ColorStateList localColorStateList = f.a.f.a.d.b(this.a.getContext(), this.c);
      this.a.setHintTextColor(localColorStateList);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void f()
  {
    int i = c.a(this.b);
    this.b = i;
    if ((i != b.abc_primary_text_disable_only_material_light) && (i != b.abc_secondary_text_material_light) && (i != 0)) {}
    try
    {
      ColorStateList localColorStateList = f.a.f.a.d.b(this.a.getContext(), this.b);
      this.a.setTextColor(localColorStateList);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static h g(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new i(paramTextView);
    }
    return new h(paramTextView);
  }
  
  protected void b()
  {
    c();
  }
  
  protected void c()
  {
    int i = c.a(this.e);
    this.e = i;
    Drawable localDrawable1 = null;
    Drawable localDrawable2;
    if (i != 0) {
      localDrawable2 = f.a.f.a.d.d(this.a.getContext(), this.e);
    } else {
      localDrawable2 = null;
    }
    i = c.a(this.g);
    this.g = i;
    Drawable localDrawable3;
    if (i != 0) {
      localDrawable3 = f.a.f.a.d.d(this.a.getContext(), this.g);
    } else {
      localDrawable3 = null;
    }
    i = c.a(this.f);
    this.f = i;
    Drawable localDrawable4;
    if (i != 0) {
      localDrawable4 = f.a.f.a.d.d(this.a.getContext(), this.f);
    } else {
      localDrawable4 = null;
    }
    i = c.a(this.d);
    this.d = i;
    if (i != 0) {
      localDrawable1 = f.a.f.a.d.d(this.a.getContext(), this.d);
    }
    if ((this.e != 0) || (this.g != 0) || (this.f != 0) || (this.d != 0)) {
      this.a.setCompoundDrawablesWithIntrinsicBounds(localDrawable2, localDrawable3, localDrawable4, localDrawable1);
    }
  }
  
  public void d()
  {
    b();
    f();
    e();
  }
  
  public int h()
  {
    return this.b;
  }
  
  public void i(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.a.getContext();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, f.a.d.SkinCompatTextHelper, paramInt, 0);
    int i = localTypedArray.getResourceId(f.a.d.SkinCompatTextHelper_android_textAppearance, 0);
    int j = f.a.d.SkinCompatTextHelper_android_drawableLeft;
    if (localTypedArray.hasValue(j)) {
      this.e = localTypedArray.getResourceId(j, 0);
    }
    j = f.a.d.SkinCompatTextHelper_android_drawableTop;
    if (localTypedArray.hasValue(j)) {
      this.g = localTypedArray.getResourceId(j, 0);
    }
    j = f.a.d.SkinCompatTextHelper_android_drawableRight;
    if (localTypedArray.hasValue(j)) {
      this.f = localTypedArray.getResourceId(j, 0);
    }
    j = f.a.d.SkinCompatTextHelper_android_drawableBottom;
    if (localTypedArray.hasValue(j)) {
      this.d = localTypedArray.getResourceId(j, 0);
    }
    localTypedArray.recycle();
    if (i != 0)
    {
      localTypedArray = localContext.obtainStyledAttributes(i, f.a.d.SkinTextAppearance);
      i = f.a.d.SkinTextAppearance_android_textColor;
      if (localTypedArray.hasValue(i)) {
        this.b = localTypedArray.getResourceId(i, 0);
      }
      i = f.a.d.SkinTextAppearance_android_textColorHint;
      if (localTypedArray.hasValue(i)) {
        this.c = localTypedArray.getResourceId(i, 0);
      }
      localTypedArray.recycle();
    }
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, f.a.d.SkinTextAppearance, paramInt, 0);
    paramInt = f.a.d.SkinTextAppearance_android_textColor;
    if (paramAttributeSet.hasValue(paramInt)) {
      this.b = paramAttributeSet.getResourceId(paramInt, 0);
    }
    paramInt = f.a.d.SkinTextAppearance_android_textColorHint;
    if (paramAttributeSet.hasValue(paramInt)) {
      this.c = paramAttributeSet.getResourceId(paramInt, 0);
    }
    paramAttributeSet.recycle();
    d();
  }
  
  public void j(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    this.e = paramInt1;
    this.g = paramInt2;
    this.f = paramInt3;
    this.d = paramInt4;
    b();
  }
  
  public void k(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    this.e = paramInt1;
    this.g = paramInt2;
    this.f = paramInt3;
    this.d = paramInt4;
    c();
  }
  
  public void l(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, f.a.d.SkinTextAppearance);
    paramInt = f.a.d.SkinTextAppearance_android_textColor;
    if (paramContext.hasValue(paramInt)) {
      this.b = paramContext.getResourceId(paramInt, 0);
    }
    paramInt = f.a.d.SkinTextAppearance_android_textColorHint;
    if (paramContext.hasValue(paramInt)) {
      this.c = paramContext.getResourceId(paramInt, 0);
    }
    paramContext.recycle();
    f();
    e();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */