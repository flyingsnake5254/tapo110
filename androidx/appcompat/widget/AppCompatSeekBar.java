package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.attr;

public class AppCompatSeekBar
  extends SeekBar
{
  private final AppCompatSeekBarHelper mAppCompatSeekBarHelper;
  
  public AppCompatSeekBar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSeekBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.seekBarStyle);
  }
  
  public AppCompatSeekBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(this, getContext());
    paramContext = new AppCompatSeekBarHelper(this);
    this.mAppCompatSeekBarHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.mAppCompatSeekBarHelper.drawableStateChanged();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    this.mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      this.mAppCompatSeekBarHelper.drawTickMarks(paramCanvas);
      return;
    }
    finally
    {
      paramCanvas = finally;
      throw paramCanvas;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */