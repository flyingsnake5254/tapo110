package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import f.a.a;

public class SkinCompatSeekBar
  extends AppCompatSeekBar
  implements g
{
  private f c;
  
  public SkinCompatSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.seekBarStyle);
  }
  
  public SkinCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new f(this);
    this.c = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */