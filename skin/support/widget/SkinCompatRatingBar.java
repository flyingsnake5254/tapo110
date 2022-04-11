package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRatingBar;
import f.a.a;

public class SkinCompatRatingBar
  extends AppCompatRatingBar
  implements g
{
  private e c;
  
  public SkinCompatRatingBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.ratingBarStyle);
  }
  
  public SkinCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new e(this);
    this.c = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatRatingBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */