package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import f.a.h.a;

public class e
  extends c
{
  private final ProgressBar a;
  private Bitmap b;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  
  e(ProgressBar paramProgressBar)
  {
    this.a = paramProgressBar;
  }
  
  private int c(int paramInt)
  {
    if (paramInt == f.a.c.abc_ratingbar_material) {
      return 0;
    }
    return c.a(paramInt);
  }
  
  private Shape d()
  {
    return new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null);
  }
  
  private Drawable f(Drawable paramDrawable, boolean paramBoolean)
  {
    Object localObject1;
    if (a.d(paramDrawable))
    {
      localObject1 = a.b(paramDrawable);
      if (localObject1 != null) {
        a.f(paramDrawable, f((Drawable)localObject1, paramBoolean));
      }
    }
    else if (a.c(paramDrawable))
    {
      localObject1 = a.a(paramDrawable);
      if (localObject1 != null) {
        a.e(paramDrawable, f((Drawable)localObject1, paramBoolean));
      }
    }
    else
    {
      Object localObject2;
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
          localObject2[k] = f((Drawable)localObject1, paramBoolean);
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
        if (this.b == null) {
          this.b = ((Bitmap)localObject2);
        }
        localObject1 = new ShapeDrawable(d());
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
  
  private Drawable g(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if ((paramDrawable instanceof AnimationDrawable))
    {
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)paramDrawable;
      int i = localAnimationDrawable.getNumberOfFrames();
      localObject = new AnimationDrawable();
      ((AnimationDrawable)localObject).setOneShot(localAnimationDrawable.isOneShot());
      for (int j = 0; j < i; j++)
      {
        paramDrawable = f(localAnimationDrawable.getFrame(j), true);
        paramDrawable.setLevel(10000);
        ((AnimationDrawable)localObject).addFrame(paramDrawable, localAnimationDrawable.getDuration(j));
      }
      ((AnimationDrawable)localObject).setLevel(10000);
    }
    return (Drawable)localObject;
  }
  
  public void b()
  {
    int i = c.a(this.c);
    this.c = i;
    Object localObject;
    if (i != 0)
    {
      localObject = f.a.f.a.d.d(this.a.getContext(), this.c);
      ((Drawable)localObject).setBounds(this.a.getIndeterminateDrawable().getBounds());
      this.a.setIndeterminateDrawable(g((Drawable)localObject));
    }
    i = c(this.d);
    this.d = i;
    if (i != 0)
    {
      localObject = f.a.f.a.d.d(this.a.getContext(), this.d);
      this.a.setProgressDrawable(f((Drawable)localObject, false));
    }
    if (Build.VERSION.SDK_INT > 21)
    {
      i = c.a(this.e);
      this.e = i;
      if (i != 0)
      {
        localObject = this.a;
        ((ProgressBar)localObject).setIndeterminateTintList(f.a.f.a.d.b(((ProgressBar)localObject).getContext(), this.e));
      }
    }
  }
  
  void e(AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = this.a.getContext().obtainStyledAttributes(paramAttributeSet, f.a.d.SkinCompatProgressBar, paramInt, 0);
    this.c = localTypedArray.getResourceId(f.a.d.SkinCompatProgressBar_android_indeterminateDrawable, 0);
    this.d = localTypedArray.getResourceId(f.a.d.SkinCompatProgressBar_android_progressDrawable, 0);
    localTypedArray.recycle();
    if (Build.VERSION.SDK_INT > 21)
    {
      paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, new int[] { 16843881 }, paramInt, 0);
      this.e = paramAttributeSet.getResourceId(0, 0);
      paramAttributeSet.recycle();
    }
    b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */