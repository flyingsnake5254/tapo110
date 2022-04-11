package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

public class SkinCompatToolbar
  extends Toolbar
  implements g
{
  private int c = 0;
  private int d = 0;
  private int f = 0;
  private a q;
  
  public SkinCompatToolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatToolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, f.a.a.toolbarStyle);
  }
  
  public SkinCompatToolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = new a(this);
    this.q = ((a)localObject);
    ((a)localObject).c(paramAttributeSet, paramInt);
    localObject = f.a.d.Toolbar;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
    this.f = localTypedArray.getResourceId(f.a.d.Toolbar_navigationIcon, 0);
    int i = localTypedArray.getResourceId(f.a.d.Toolbar_titleTextAppearance, 0);
    int j = localTypedArray.getResourceId(f.a.d.Toolbar_subtitleTextAppearance, 0);
    localTypedArray.recycle();
    if (i != 0)
    {
      localTypedArray = paramContext.obtainStyledAttributes(i, f.a.d.SkinTextAppearance);
      this.c = localTypedArray.getResourceId(f.a.d.SkinTextAppearance_android_textColor, 0);
      localTypedArray.recycle();
    }
    if (j != 0)
    {
      localTypedArray = paramContext.obtainStyledAttributes(j, f.a.d.SkinTextAppearance);
      this.d = localTypedArray.getResourceId(f.a.d.SkinTextAppearance_android_textColor, 0);
      localTypedArray.recycle();
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
    paramInt = f.a.d.Toolbar_titleTextColor;
    if (paramContext.hasValue(paramInt)) {
      this.c = paramContext.getResourceId(paramInt, 0);
    }
    paramInt = f.a.d.Toolbar_subtitleTextColor;
    if (paramContext.hasValue(paramInt)) {
      this.d = paramContext.getResourceId(paramInt, 0);
    }
    paramContext.recycle();
    c();
    b();
    a();
  }
  
  private void a()
  {
    int i = c.a(this.f);
    this.f = i;
    if (i != 0) {
      setNavigationIcon(f.a.f.a.d.d(getContext(), this.f));
    }
  }
  
  private void b()
  {
    int i = c.a(this.d);
    this.d = i;
    if (i != 0) {
      setSubtitleTextColor(f.a.f.a.d.a(getContext(), this.d));
    }
  }
  
  private void c()
  {
    int i = c.a(this.c);
    this.c = i;
    if (i != 0) {
      setTitleTextColor(f.a.f.a.d.a(getContext(), this.c));
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
  
  public void setNavigationIcon(@DrawableRes int paramInt)
  {
    super.setNavigationIcon(paramInt);
    this.f = paramInt;
    a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */