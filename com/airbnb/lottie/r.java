package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class r
{
  private final Map<String, String> a = new HashMap();
  @Nullable
  private final LottieAnimationView b;
  @Nullable
  private final f c;
  private boolean d = true;
  
  public r(LottieAnimationView paramLottieAnimationView)
  {
    this.b = paramLottieAnimationView;
    this.c = null;
  }
  
  private String a(String paramString)
  {
    return paramString;
  }
  
  public final String b(String paramString)
  {
    if ((this.d) && (this.a.containsKey(paramString))) {
      return (String)this.a.get(paramString);
    }
    String str = a(paramString);
    if (this.d) {
      this.a.put(paramString, str);
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */