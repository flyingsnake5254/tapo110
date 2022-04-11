package androidx.core.telephony.mbms;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public final class MbmsHelper
{
  @SuppressLint({"BanTargetApiAnnotation"})
  @TargetApi(28)
  @Nullable
  public static CharSequence getBestNameForService(@NonNull Context paramContext, @NonNull ServiceInfo paramServiceInfo)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = null;
    if (i < 28) {
      return null;
    }
    LocaleList localLocaleList = paramContext.getResources().getConfiguration().getLocales();
    i = paramServiceInfo.getNamedContentLocales().size();
    if (i == 0) {
      return null;
    }
    paramContext = new String[i];
    i = 0;
    Iterator localIterator = paramServiceInfo.getNamedContentLocales().iterator();
    while (localIterator.hasNext())
    {
      paramContext[i] = ((Locale)localIterator.next()).toLanguageTag();
      i++;
    }
    paramContext = localLocaleList.getFirstMatch(paramContext);
    if (paramContext == null) {
      paramContext = (Context)localObject;
    } else {
      paramContext = paramServiceInfo.getNameForLocale(paramContext);
    }
    return paramContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\telephony\mbms\MbmsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */