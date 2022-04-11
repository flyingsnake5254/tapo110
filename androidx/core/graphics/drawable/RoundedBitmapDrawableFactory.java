package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory
{
  private static final String TAG = "RoundedBitmapDrawableFa";
  
  @NonNull
  public static RoundedBitmapDrawable create(@NonNull Resources paramResources, @Nullable Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new RoundedBitmapDrawable21(paramResources, paramBitmap);
    }
    return new DefaultRoundedBitmapDrawable(paramResources, paramBitmap);
  }
  
  @NonNull
  public static RoundedBitmapDrawable create(@NonNull Resources paramResources, @NonNull InputStream paramInputStream)
  {
    RoundedBitmapDrawable localRoundedBitmapDrawable = create(paramResources, BitmapFactory.decodeStream(paramInputStream));
    if (localRoundedBitmapDrawable.getBitmap() == null)
    {
      paramResources = new StringBuilder();
      paramResources.append("RoundedBitmapDrawable cannot decode ");
      paramResources.append(paramInputStream);
      Log.w("RoundedBitmapDrawableFa", paramResources.toString());
    }
    return localRoundedBitmapDrawable;
  }
  
  @NonNull
  public static RoundedBitmapDrawable create(@NonNull Resources paramResources, @NonNull String paramString)
  {
    RoundedBitmapDrawable localRoundedBitmapDrawable = create(paramResources, BitmapFactory.decodeFile(paramString));
    if (localRoundedBitmapDrawable.getBitmap() == null)
    {
      paramResources = new StringBuilder();
      paramResources.append("RoundedBitmapDrawable cannot decode ");
      paramResources.append(paramString);
      Log.w("RoundedBitmapDrawableFa", paramResources.toString());
    }
    return localRoundedBitmapDrawable;
  }
  
  private static class DefaultRoundedBitmapDrawable
    extends RoundedBitmapDrawable
  {
    DefaultRoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    void gravityCompatApply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
    {
      GravityCompat.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
    }
    
    public boolean hasMipMap()
    {
      Bitmap localBitmap = this.mBitmap;
      boolean bool;
      if ((localBitmap != null) && (BitmapCompat.hasMipMap(localBitmap))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void setMipMap(boolean paramBoolean)
    {
      Bitmap localBitmap = this.mBitmap;
      if (localBitmap != null)
      {
        BitmapCompat.setHasMipMap(localBitmap, paramBoolean);
        invalidateSelf();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\drawable\RoundedBitmapDrawableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */