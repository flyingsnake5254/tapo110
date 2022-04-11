package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;

class AppCompatProgressBarHelper
{
  private static final int[] TINT_ATTRS = { 16843067, 16843068 };
  private Bitmap mSampleTile;
  private final ProgressBar mView;
  
  AppCompatProgressBarHelper(ProgressBar paramProgressBar)
  {
    this.mView = paramProgressBar;
  }
  
  private Shape getDrawableShape()
  {
    return new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null);
  }
  
  private Drawable tileify(Drawable paramDrawable, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if ((paramDrawable instanceof WrappedDrawable))
    {
      localObject1 = (WrappedDrawable)paramDrawable;
      localObject2 = ((WrappedDrawable)localObject1).getWrappedDrawable();
      if (localObject2 != null) {
        ((WrappedDrawable)localObject1).setWrappedDrawable(tileify((Drawable)localObject2, paramBoolean));
      }
    }
    else
    {
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int i = paramDrawable.getNumberOfLayers();
        localObject2 = new Drawable[i];
        int j = 0;
        for (int k = 0; k < i; k++)
        {
          int m = paramDrawable.getId(k);
          localObject1 = paramDrawable.getDrawable(k);
          if ((m != 16908301) && (m != 16908303)) {
            paramBoolean = false;
          } else {
            paramBoolean = true;
          }
          localObject2[k] = tileify((Drawable)localObject1, paramBoolean);
        }
        localObject1 = new LayerDrawable((Drawable[])localObject2);
        for (k = j; k < i; k++) {
          ((LayerDrawable)localObject1).setId(k, paramDrawable.getId(k));
        }
        return (Drawable)localObject1;
      }
      if ((paramDrawable instanceof BitmapDrawable))
      {
        paramDrawable = (BitmapDrawable)paramDrawable;
        localObject2 = paramDrawable.getBitmap();
        if (this.mSampleTile == null) {
          this.mSampleTile = ((Bitmap)localObject2);
        }
        localObject1 = new ShapeDrawable(getDrawableShape());
        localObject2 = new BitmapShader((Bitmap)localObject2, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
        ((ShapeDrawable)localObject1).getPaint().setShader((Shader)localObject2);
        ((ShapeDrawable)localObject1).getPaint().setColorFilter(paramDrawable.getPaint().getColorFilter());
        paramDrawable = (Drawable)localObject1;
        if (paramBoolean) {
          paramDrawable = new ClipDrawable((Drawable)localObject1, 3, 1);
        }
        return paramDrawable;
      }
    }
    return paramDrawable;
  }
  
  private Drawable tileifyIndeterminate(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if ((paramDrawable instanceof AnimationDrawable))
    {
      paramDrawable = (AnimationDrawable)paramDrawable;
      int i = paramDrawable.getNumberOfFrames();
      localObject = new AnimationDrawable();
      ((AnimationDrawable)localObject).setOneShot(paramDrawable.isOneShot());
      for (int j = 0; j < i; j++)
      {
        Drawable localDrawable = tileify(paramDrawable.getFrame(j), true);
        localDrawable.setLevel(10000);
        ((AnimationDrawable)localObject).addFrame(localDrawable, paramDrawable.getDuration(j));
      }
      ((AnimationDrawable)localObject).setLevel(10000);
    }
    return (Drawable)localObject;
  }
  
  Bitmap getSampleTile()
  {
    return this.mSampleTile;
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, TINT_ATTRS, paramInt, 0);
    Drawable localDrawable = paramAttributeSet.getDrawableIfKnown(0);
    if (localDrawable != null) {
      this.mView.setIndeterminateDrawable(tileifyIndeterminate(localDrawable));
    }
    localDrawable = paramAttributeSet.getDrawableIfKnown(1);
    if (localDrawable != null) {
      this.mView.setProgressDrawable(tileify(localDrawable, false));
    }
    paramAttributeSet.recycle();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatProgressBarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */