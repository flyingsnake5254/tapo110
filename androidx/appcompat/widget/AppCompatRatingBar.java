package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.attr;

public class AppCompatRatingBar
  extends RatingBar
{
  private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;
  
  public AppCompatRatingBar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatRatingBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.ratingBarStyle);
  }
  
  public AppCompatRatingBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(this, getContext());
    paramContext = new AppCompatProgressBarHelper(this);
    this.mAppCompatProgressBarHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      Bitmap localBitmap = this.mAppCompatProgressBarHelper.getSampleTile();
      if (localBitmap != null) {
        setMeasuredDimension(View.resolveSizeAndState(localBitmap.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatRatingBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */