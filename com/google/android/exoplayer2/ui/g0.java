package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import java.util.Locale;

public class g0
  implements z0
{
  private final Resources a;
  
  public g0(Resources paramResources)
  {
    this.a = ((Resources)g.e(paramResources));
  }
  
  private String b(Format paramFormat)
  {
    int i = paramFormat.U3;
    if ((i != -1) && (i >= 1))
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 6) && (i != 7))
          {
            if (i != 8) {
              return this.a.getString(r0.exo_track_surround);
            }
            return this.a.getString(r0.exo_track_surround_7_point_1);
          }
          return this.a.getString(r0.exo_track_surround_5_point_1);
        }
        return this.a.getString(r0.exo_track_stereo);
      }
      return this.a.getString(r0.exo_track_mono);
    }
    return "";
  }
  
  private String c(Format paramFormat)
  {
    int i = paramFormat.p0;
    if (i == -1) {
      paramFormat = "";
    } else {
      paramFormat = this.a.getString(r0.exo_track_bitrate, new Object[] { Float.valueOf(i / 1000000.0F) });
    }
    return paramFormat;
  }
  
  private String d(Format paramFormat)
  {
    if (TextUtils.isEmpty(paramFormat.d)) {
      paramFormat = "";
    } else {
      paramFormat = paramFormat.d;
    }
    return paramFormat;
  }
  
  private String e(Format paramFormat)
  {
    String str1 = j(new String[] { f(paramFormat), h(paramFormat) });
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = d(paramFormat);
    }
    return str2;
  }
  
  private String f(Format paramFormat)
  {
    paramFormat = paramFormat.f;
    if ((!TextUtils.isEmpty(paramFormat)) && (!"und".equals(paramFormat)))
    {
      if (o0.a >= 21) {
        paramFormat = Locale.forLanguageTag(paramFormat);
      } else {
        paramFormat = new Locale(paramFormat);
      }
      return paramFormat.getDisplayName();
    }
    return "";
  }
  
  private String g(Format paramFormat)
  {
    int i = paramFormat.M3;
    int j = paramFormat.N3;
    if ((i != -1) && (j != -1)) {
      paramFormat = this.a.getString(r0.exo_track_resolution, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    } else {
      paramFormat = "";
    }
    return paramFormat;
  }
  
  private String h(Format paramFormat)
  {
    if ((paramFormat.x & 0x2) != 0) {
      localObject1 = this.a.getString(r0.exo_track_role_alternate);
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if ((paramFormat.x & 0x4) != 0) {
      localObject2 = j(new String[] { localObject1, this.a.getString(r0.exo_track_role_supplementary) });
    }
    Object localObject1 = localObject2;
    if ((paramFormat.x & 0x8) != 0) {
      localObject1 = j(new String[] { localObject2, this.a.getString(r0.exo_track_role_commentary) });
    }
    localObject2 = localObject1;
    if ((paramFormat.x & 0x440) != 0) {
      localObject2 = j(new String[] { localObject1, this.a.getString(r0.exo_track_role_closed_captions) });
    }
    return (String)localObject2;
  }
  
  private static int i(Format paramFormat)
  {
    int i = y.k(paramFormat.H3);
    if (i != -1) {
      return i;
    }
    if (y.n(paramFormat.p1) != null) {
      return 2;
    }
    if (y.c(paramFormat.p1) != null) {
      return 1;
    }
    if ((paramFormat.M3 == -1) && (paramFormat.N3 == -1))
    {
      if ((paramFormat.U3 == -1) && (paramFormat.V3 == -1)) {
        return -1;
      }
      return 1;
    }
    return 2;
  }
  
  private String j(String... paramVarArgs)
  {
    int i = paramVarArgs.length;
    Object localObject1 = "";
    int j = 0;
    while (j < i)
    {
      String str = paramVarArgs[j];
      Object localObject2 = localObject1;
      if (str.length() > 0) {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = str;
        } else {
          localObject2 = this.a.getString(r0.exo_item_list, new Object[] { localObject1, str });
        }
      }
      j++;
      localObject1 = localObject2;
    }
    return (String)localObject1;
  }
  
  public String a(Format paramFormat)
  {
    int i = i(paramFormat);
    if (i == 2) {
      paramFormat = j(new String[] { h(paramFormat), g(paramFormat), c(paramFormat) });
    } else if (i == 1) {
      paramFormat = j(new String[] { e(paramFormat), b(paramFormat), c(paramFormat) });
    } else {
      paramFormat = e(paramFormat);
    }
    Object localObject = paramFormat;
    if (paramFormat.length() == 0) {
      localObject = this.a.getString(r0.exo_track_unknown);
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */