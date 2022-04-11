package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class f
  extends e
{
  private final SeekBar f;
  private int g = 0;
  
  public f(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    this.f = paramSeekBar;
  }
  
  public void b()
  {
    super.b();
    int i = c.a(this.g);
    this.g = i;
    if (i != 0)
    {
      SeekBar localSeekBar = this.f;
      localSeekBar.setThumb(f.a.f.a.d.d(localSeekBar.getContext(), this.g));
    }
  }
  
  void e(AttributeSet paramAttributeSet, int paramInt)
  {
    super.e(paramAttributeSet, paramInt);
    paramAttributeSet = this.f.getContext().obtainStyledAttributes(paramAttributeSet, f.a.d.AppCompatSeekBar, paramInt, 0);
    this.g = paramAttributeSet.getResourceId(f.a.d.AppCompatSeekBar_android_thumb, 0);
    paramAttributeSet.recycle();
    b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */