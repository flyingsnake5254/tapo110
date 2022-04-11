package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

public final class DisplayManagerCompat
{
  public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
  private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap();
  private final Context mContext;
  
  private DisplayManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @NonNull
  public static DisplayManagerCompat getInstance(@NonNull Context paramContext)
  {
    synchronized (sInstances)
    {
      DisplayManagerCompat localDisplayManagerCompat1 = (DisplayManagerCompat)???.get(paramContext);
      DisplayManagerCompat localDisplayManagerCompat2 = localDisplayManagerCompat1;
      if (localDisplayManagerCompat1 == null)
      {
        localDisplayManagerCompat2 = new androidx/core/hardware/display/DisplayManagerCompat;
        localDisplayManagerCompat2.<init>(paramContext);
        ???.put(paramContext, localDisplayManagerCompat2);
      }
      return localDisplayManagerCompat2;
    }
  }
  
  @Nullable
  public Display getDisplay(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return ((DisplayManager)this.mContext.getSystemService("display")).getDisplay(paramInt);
    }
    Display localDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getDisplayId() == paramInt) {
      return localDisplay;
    }
    return null;
  }
  
  @NonNull
  public Display[] getDisplays()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return ((DisplayManager)this.mContext.getSystemService("display")).getDisplays();
    }
    return new Display[] { ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay() };
  }
  
  @NonNull
  public Display[] getDisplays(@Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return ((DisplayManager)this.mContext.getSystemService("display")).getDisplays(paramString);
    }
    if (paramString == null) {
      return new Display[0];
    }
    return new Display[] { ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay() };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\hardware\display\DisplayManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */