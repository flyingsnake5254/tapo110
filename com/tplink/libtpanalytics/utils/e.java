package com.tplink.libtpanalytics.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class e
{
  private static final List<String> a = Arrays.asList(new String[] { "ar_SA", "bg_BG", "cs_CZ", "da_DK", "de_DE", "el_GR", "en_US", "es_ES", "es_MX", "fi_FI", "fr_FR", "he_IL", "hu_HU", "it_IT", "ja_JP", "ko_KR", "ms_MY", "nb_NO", "nl_NL", "pl_PL", "pt_BR", "pt_PT", "ro_RO", "ru_RU", "sk_SK", "sv_SE", "th_TH", "tr_TR", "uk_UA", "vi_VN", "zh_TW" });
  private static final List<String> b = Arrays.asList(new String[] { "en_US", "da_DK", "de_DE", "ru_RU", "fr_FR", "zh_TW", "fi_FI", "ko_KR", "nl_NL", "nb_NO", "pt_BR", "pt_PT", "ja_JP", "sv_SE", "es_ES", "it_IT" });
  
  public static String a(Locale paramLocale)
  {
    String str = "en_US";
    if (paramLocale == null) {
      return "en_US";
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramLocale.getLanguage());
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramLocale.getCountry());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = paramLocale.getLanguage();
    Object localObject3 = a;
    int i = ((List)localObject3).indexOf(localObject2);
    if ((i >= 0) && (i < ((List)localObject3).size()))
    {
      paramLocale = (String)((List)localObject3).get(i);
    }
    else
    {
      paramLocale = str;
      if (localObject1 != null)
      {
        localObject2 = ((List)localObject3).iterator();
        do
        {
          paramLocale = str;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramLocale = (String)((Iterator)localObject2).next();
          localObject3 = paramLocale.substring(0, 2);
          if ("pt".equalsIgnoreCase((String)localObject1))
          {
            paramLocale = "pt_PT";
            break;
          }
          if ("es".equalsIgnoreCase((String)localObject1))
          {
            paramLocale = "es_ES";
            break;
          }
        } while (!((String)localObject3).equalsIgnoreCase((String)localObject1));
      }
    }
    return paramLocale;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */