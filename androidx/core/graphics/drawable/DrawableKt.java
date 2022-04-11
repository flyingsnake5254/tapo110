package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import kotlin.jvm.internal.j;

public final class DrawableKt
{
  public static final Bitmap toBitmap(Drawable paramDrawable, @Px int paramInt1, @Px int paramInt2, Bitmap.Config paramConfig)
  {
    j.f(paramDrawable, "$this$toBitmap");
    if ((paramDrawable instanceof BitmapDrawable)) {
      if (paramConfig != null)
      {
        localObject = ((BitmapDrawable)paramDrawable).getBitmap();
        j.b(localObject, "bitmap");
        if (((Bitmap)localObject).getConfig() != paramConfig) {}
      }
      else
      {
        paramDrawable = (BitmapDrawable)paramDrawable;
        if ((paramInt1 == paramDrawable.getIntrinsicWidth()) && (paramInt2 == paramDrawable.getIntrinsicHeight()))
        {
          paramDrawable = paramDrawable.getBitmap();
          j.b(paramDrawable, "bitmap");
          return paramDrawable;
        }
        paramDrawable = Bitmap.createScaledBitmap(paramDrawable.getBitmap(), paramInt1, paramInt2, true);
        j.b(paramDrawable, "Bitmap.createScaledBitma…map, width, height, true)");
        return paramDrawable;
      }
    }
    Object localObject = paramDrawable.getBounds();
    int i = ((Rect)localObject).left;
    int j = ((Rect)localObject).top;
    int k = ((Rect)localObject).right;
    int m = ((Rect)localObject).bottom;
    if (paramConfig == null) {
      paramConfig = Bitmap.Config.ARGB_8888;
    }
    paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
    paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
    paramDrawable.draw(new Canvas(paramConfig));
    paramDrawable.setBounds(i, j, k, m);
    j.b(paramConfig, "bitmap");
    return paramConfig;
  }
  
  public static final void updateBounds(Drawable paramDrawable, @Px int paramInt1, @Px int paramInt2, @Px int paramInt3, @Px int paramInt4)
  {
    j.f(paramDrawable, "$this$updateBounds");
    paramDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\drawable\DrawableKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */