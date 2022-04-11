package com.tplink.iot.f.a;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.r;
import kotlin.jvm.internal.j;

public final class a
{
  public static final void a(LottieAnimationView paramLottieAnimationView, Context paramContext)
  {
    c(paramLottieAnimationView, paramContext, false, 2, null);
  }
  
  public static final void b(LottieAnimationView paramLottieAnimationView, final Context paramContext, boolean paramBoolean)
  {
    j.e(paramLottieAnimationView, "$this$useFontFamilyRoboto");
    j.e(paramContext, "context");
    paramLottieAnimationView.setTextDelegate(new r(paramLottieAnimationView));
    paramLottieAnimationView.setFontAssetDelegate(new a(paramBoolean, paramContext));
  }
  
  public static final class a
    extends com.airbnb.lottie.a
  {
    a(boolean paramBoolean, Context paramContext) {}
    
    public Typeface a(String paramString)
    {
      int i;
      if (this.a) {
        i = 2131296256;
      } else {
        i = 2131296258;
      }
      return ResourcesCompat.getFont(paramContext, i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */