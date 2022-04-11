package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AppCompatToggleButton
  extends ToggleButton
{
  private final AppCompatTextHelper mTextHelper;
  
  public AppCompatToggleButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatToggleButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842827);
  }
  
  public AppCompatToggleButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(this, getContext());
    paramContext = new AppCompatTextHelper(this);
    this.mTextHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatToggleButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */