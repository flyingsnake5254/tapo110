package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ViewUtils
{
  @KeepForSdk
  public static String getXmlAttributeString(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if (paramAttributeSet == null) {
      paramString1 = null;
    } else {
      paramString1 = paramAttributeSet.getAttributeValue(paramString1, paramString2);
    }
    paramAttributeSet = paramString1;
    if (paramString1 != null)
    {
      paramAttributeSet = paramString1;
      if (paramString1.startsWith("@string/"))
      {
        paramAttributeSet = paramString1;
        if (paramBoolean1)
        {
          String str1 = paramString1.substring(8);
          String str2 = paramContext.getPackageName();
          paramAttributeSet = new TypedValue();
          try
          {
            Resources localResources = paramContext.getResources();
            int i = String.valueOf(str2).length();
            int j = String.valueOf(str1).length();
            paramContext = new java/lang/StringBuilder;
            paramContext.<init>(i + 8 + j);
            paramContext.append(str2);
            paramContext.append(":string/");
            paramContext.append(str1);
            localResources.getValue(paramContext.toString(), paramAttributeSet, true);
          }
          catch (Resources.NotFoundException paramContext)
          {
            paramContext = new StringBuilder(String.valueOf(paramString2).length() + 30 + paramString1.length());
            paramContext.append("Could not find resource for ");
            paramContext.append(paramString2);
            paramContext.append(": ");
            paramContext.append(paramString1);
            Log.w(paramString3, paramContext.toString());
          }
          paramContext = paramAttributeSet.string;
          if (paramContext != null)
          {
            paramAttributeSet = paramContext.toString();
          }
          else
          {
            paramAttributeSet = String.valueOf(paramAttributeSet);
            paramContext = new StringBuilder(String.valueOf(paramString2).length() + 28 + paramAttributeSet.length());
            paramContext.append("Resource ");
            paramContext.append(paramString2);
            paramContext.append(" was not a string: ");
            paramContext.append(paramAttributeSet);
            Log.w(paramString3, paramContext.toString());
            paramAttributeSet = paramString1;
          }
        }
      }
    }
    if ((paramBoolean2) && (paramAttributeSet == null))
    {
      paramString1 = new StringBuilder(String.valueOf(paramString2).length() + 33);
      paramString1.append("Required XML attribute \"");
      paramString1.append(paramString2);
      paramString1.append("\" missing");
      Log.w(paramString3, paramString1.toString());
    }
    return paramAttributeSet;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */