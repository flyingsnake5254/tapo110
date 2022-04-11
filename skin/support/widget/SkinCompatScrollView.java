package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import androidx.annotation.DrawableRes;

public class SkinCompatScrollView
  extends ScrollView
  implements g
{
  private a c;
  
  public SkinCompatScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SkinCompatScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new a(this);
    this.c = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    a locala = this.c;
    if (locala != null) {
      locala.d(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */