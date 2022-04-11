package com.tplink.iot.widget.bottomsheet;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.text.m;

public final class BottomSheetOptions
  implements Serializable
{
  public static final a Companion = new a(null);
  private static final String OPTION_KEY_CANCELABLE = "Cancelable";
  private static final String OPTION_KEY_FULLSCREEN = "Fullscreen";
  private static final String OPTION_KEY_HIDEABLE = "Hideable";
  private static final String OPTION_KEY_NO_DIM = "NoDim";
  private static final String OPTION_KEY_SKIP_COLLAPSED = "SkipCollapsed";
  private static final String OPTION_KEY_TOP_ROUND_CORNER = "TopRoundCorner";
  private static final String OPTION_KEY_TOP_SPACED_PIXELS = "TopSpacedPixels";
  private boolean cancelable = true;
  private boolean fullscreen;
  private boolean hideable = true;
  private boolean noDim;
  private boolean skipCollapsed;
  private boolean topRoundCorner = true;
  private int topSpacedPixels;
  
  public final BottomSheetOptions cancelable(boolean paramBoolean)
  {
    this.cancelable = paramBoolean;
    return this;
  }
  
  public final BottomSheetOptions fullscreen(boolean paramBoolean)
  {
    this.fullscreen = paramBoolean;
    return this;
  }
  
  public final boolean getCancelable()
  {
    return this.cancelable;
  }
  
  public final boolean getFullscreen()
  {
    return this.fullscreen;
  }
  
  public final boolean getHideable()
  {
    return this.hideable;
  }
  
  public final boolean getNoDim()
  {
    return this.noDim;
  }
  
  public final boolean getSkipCollapsed()
  {
    return this.skipCollapsed;
  }
  
  public final boolean getTopRoundCorner()
  {
    return this.topRoundCorner;
  }
  
  public final int getTopSpacedPixels()
  {
    return this.topSpacedPixels;
  }
  
  public final BottomSheetOptions hideable(boolean paramBoolean)
  {
    this.hideable = paramBoolean;
    return this;
  }
  
  public final Bundle mergeBundle(Bundle paramBundle)
  {
    Bundle localBundle = toBundle();
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    return localBundle;
  }
  
  public final BottomSheetOptions noDim(boolean paramBoolean)
  {
    this.noDim = paramBoolean;
    return this;
  }
  
  public final BottomSheetOptions skipCollapsed(boolean paramBoolean)
  {
    this.skipCollapsed = paramBoolean;
    return this;
  }
  
  public final Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("NoDim", this.noDim);
    localBundle.putBoolean("TopRoundCorner", this.topRoundCorner);
    localBundle.putBoolean("Fullscreen", this.fullscreen);
    localBundle.putInt("TopSpacedPixels", this.topSpacedPixels);
    localBundle.putBoolean("Cancelable", this.cancelable);
    localBundle.putBoolean("Hideable", this.hideable);
    localBundle.putBoolean("SkipCollapsed", this.skipCollapsed);
    return localBundle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BottomSheetOptions(\n            |noDim = ");
    localStringBuilder.append(this.noDim);
    localStringBuilder.append(", topRoundCorner = ");
    localStringBuilder.append(this.topRoundCorner);
    localStringBuilder.append(", fullscreen = ");
    localStringBuilder.append(this.fullscreen);
    localStringBuilder.append(", \n            |topSpacedPixels = ");
    localStringBuilder.append(this.topSpacedPixels);
    localStringBuilder.append(", cancelable = ");
    localStringBuilder.append(this.cancelable);
    localStringBuilder.append(", hideable = ");
    localStringBuilder.append(this.hideable);
    localStringBuilder.append(", \n            |skipCollapsed = ");
    localStringBuilder.append(this.skipCollapsed);
    localStringBuilder.append("\n            |)\n        ");
    return m.h(localStringBuilder.toString(), null, 1, null);
  }
  
  public final BottomSheetOptions topRoundCorner(boolean paramBoolean)
  {
    this.topRoundCorner = paramBoolean;
    return this;
  }
  
  public final BottomSheetOptions topSpacedPixels(int paramInt)
  {
    this.topSpacedPixels = paramInt;
    return this;
  }
  
  public static final class a
  {
    public final BottomSheetOptions a(Bundle paramBundle)
    {
      BottomSheetOptions localBottomSheetOptions = new BottomSheetOptions();
      if (paramBundle != null)
      {
        BottomSheetOptions.access$setNoDim$p(localBottomSheetOptions, paramBundle.getBoolean("NoDim", localBottomSheetOptions.getNoDim()));
        BottomSheetOptions.access$setTopRoundCorner$p(localBottomSheetOptions, paramBundle.getBoolean("TopRoundCorner", localBottomSheetOptions.getTopRoundCorner()));
        BottomSheetOptions.access$setFullscreen$p(localBottomSheetOptions, paramBundle.getBoolean("Fullscreen", localBottomSheetOptions.getFullscreen()));
        BottomSheetOptions.access$setTopSpacedPixels$p(localBottomSheetOptions, paramBundle.getInt("TopSpacedPixels", localBottomSheetOptions.getTopSpacedPixels()));
        BottomSheetOptions.access$setCancelable$p(localBottomSheetOptions, paramBundle.getBoolean("Cancelable", localBottomSheetOptions.getCancelable()));
        BottomSheetOptions.access$setHideable$p(localBottomSheetOptions, paramBundle.getBoolean("Hideable", localBottomSheetOptions.getHideable()));
        BottomSheetOptions.access$setSkipCollapsed$p(localBottomSheetOptions, paramBundle.getBoolean("SkipCollapsed", localBottomSheetOptions.getSkipCollapsed()));
      }
      return localBottomSheetOptions;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\bottomsheet\BottomSheetOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */