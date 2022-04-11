package com.handmark.pulltorefresh.library.internal;

import android.util.Log;

public class b
{
  public static void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("You're using the deprecated ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" attr, please switch over to ");
    localStringBuilder.append(paramString2);
    Log.w("PullToRefresh", localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */