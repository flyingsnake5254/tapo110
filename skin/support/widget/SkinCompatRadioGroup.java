package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

public class SkinCompatRadioGroup
  extends RadioGroup
  implements g
{
  private a c;
  
  public SkinCompatRadioGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new a(this);
    this.c = paramContext;
    paramContext.c(paramAttributeSet, 0);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatRadioGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */