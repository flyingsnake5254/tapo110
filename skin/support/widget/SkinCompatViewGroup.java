package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public abstract class SkinCompatViewGroup
  extends ViewGroup
  implements g
{
  private a c;
  
  public SkinCompatViewGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SkinCompatViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new a(this);
    this.c = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    a locala = this.c;
    if (locala != null) {
      locala.d(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatViewGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */