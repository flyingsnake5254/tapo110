package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.R.attr;
import androidx.appcompat.widget.AppCompatImageButton;

public class SkinCompatImageButton
  extends AppCompatImageButton
  implements g
{
  private a c;
  private d d;
  
  public SkinCompatImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public SkinCompatImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new a(this);
    this.c = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
    paramContext = new d(this);
    this.d = paramContext;
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
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    d locald = this.d;
    if (locald != null) {
      locald.d(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */