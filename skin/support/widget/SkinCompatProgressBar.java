package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class SkinCompatProgressBar
  extends ProgressBar
  implements g
{
  private e c;
  
  public SkinCompatProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842871);
  }
  
  public SkinCompatProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new e(this);
    this.c = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */