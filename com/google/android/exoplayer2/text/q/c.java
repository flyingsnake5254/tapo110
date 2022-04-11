package com.google.android.exoplayer2.text.q;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.common.primitives.d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class c
{
  public final String a;
  public final int b;
  @ColorInt
  @Nullable
  public final Integer c;
  public final float d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  
  private c(String paramString, int paramInt, @ColorInt @Nullable Integer paramInteger, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramInteger;
    this.d = paramFloat;
    this.e = paramBoolean1;
    this.f = paramBoolean2;
    this.g = paramBoolean3;
    this.h = paramBoolean4;
  }
  
  @Nullable
  public static c b(String paramString, a parama)
  {
    g.a(paramString.startsWith("Style:"));
    String[] arrayOfString = TextUtils.split(paramString.substring(6), ",");
    int i = arrayOfString.length;
    int j = parama.i;
    if (i != j)
    {
      u.h("SsaStyle", o0.A("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", new Object[] { Integer.valueOf(j), Integer.valueOf(arrayOfString.length), paramString }));
      return null;
    }
    try
    {
      String str = arrayOfString[parama.a].trim();
      j = parama.b;
      if (j != -1) {
        j = d(arrayOfString[j].trim());
      } else {
        j = -1;
      }
      i = parama.c;
      if (i != -1) {
        localObject = f(arrayOfString[i].trim());
      } else {
        localObject = null;
      }
      i = parama.d;
      float f1;
      if (i != -1) {
        f1 = g(arrayOfString[i].trim());
      } else {
        f1 = -3.4028235E38F;
      }
      i = parama.e;
      boolean bool1;
      if ((i != -1) && (e(arrayOfString[i].trim()))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      i = parama.f;
      boolean bool2;
      if ((i != -1) && (e(arrayOfString[i].trim()))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      i = parama.g;
      boolean bool3;
      if ((i != -1) && (e(arrayOfString[i].trim()))) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      i = parama.h;
      boolean bool4;
      if ((i != -1) && (e(arrayOfString[i].trim()))) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      parama = new c(str, j, (Integer)localObject, f1, bool1, bool2, bool3, bool4);
      return parama;
    }
    catch (RuntimeException parama)
    {
      Object localObject = new StringBuilder(paramString.length() + 36);
      ((StringBuilder)localObject).append("Skipping malformed 'Style:' line: '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'");
      u.i("SsaStyle", ((StringBuilder)localObject).toString(), parama);
    }
    return null;
  }
  
  private static boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static int d(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString.trim());
      boolean bool = c(i);
      if (bool) {
        return i;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Ignoring unknown alignment: ".concat(paramString);
      } else {
        paramString = new String("Ignoring unknown alignment: ");
      }
      u.h("SsaStyle", paramString);
    }
    return -1;
  }
  
  private static boolean e(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = Integer.parseInt(paramString);
      if ((i == 1) || (i == -1)) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 33);
      localStringBuilder.append("Failed to parse boolean value: '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'");
      u.i("SsaStyle", localStringBuilder.toString(), localNumberFormatException);
    }
    return false;
  }
  
  @ColorInt
  @Nullable
  public static Integer f(String paramString)
  {
    try
    {
      long l;
      if (paramString.startsWith("&H")) {
        l = Long.parseLong(paramString.substring(2), 16);
      } else {
        l = Long.parseLong(paramString);
      }
      boolean bool;
      if (l <= 4294967295L) {
        bool = true;
      } else {
        bool = false;
      }
      g.a(bool);
      int i = d.c(l >> 24 & 0xFF ^ 0xFF);
      int j = d.c(l >> 16 & 0xFF);
      int k = d.c(l >> 8 & 0xFF);
      return Integer.valueOf(Color.argb(i, d.c(l & 0xFF), k, j));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 36);
      localStringBuilder.append("Failed to parse color expression: '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'");
      u.i("SsaStyle", localStringBuilder.toString(), localIllegalArgumentException);
    }
    return null;
  }
  
  private static float g(String paramString)
  {
    try
    {
      float f1 = Float.parseFloat(paramString);
      return f1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 29);
      localStringBuilder.append("Failed to parse font size: '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'");
      u.i("SsaStyle", localStringBuilder.toString(), localNumberFormatException);
    }
    return -3.4028235E38F;
  }
  
  static final class a
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
      this.g = paramInt7;
      this.h = paramInt8;
      this.i = paramInt9;
    }
    
    @Nullable
    public static a a(String paramString)
    {
      paramString = TextUtils.split(paramString.substring(7), ",");
      int j = 0;
      int k = -1;
      int m = -1;
      int n = -1;
      int i1 = -1;
      int i2 = -1;
      int i3 = -1;
      int i4 = -1;
      int i5 = -1;
      while (j < paramString.length)
      {
        String str = com.google.common.base.c.e(paramString[j].trim());
        str.hashCode();
        switch (str.hashCode())
        {
        }
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        i6 = -1;
                        break;
                      } while (!str.equals("alignment"));
                      i6 = 7;
                      break;
                    } while (!str.equals("fontsize"));
                    i6 = 6;
                    break;
                  } while (!str.equals("name"));
                  i6 = 5;
                  break;
                } while (!str.equals("bold"));
                i6 = 4;
                break;
              } while (!str.equals("primarycolour"));
              i6 = 3;
              break;
            } while (!str.equals("strikeout"));
            i6 = 2;
            break;
          } while (!str.equals("underline"));
          i6 = 1;
          break;
        } while (!str.equals("italic"));
        int i6 = 0;
        switch (i6)
        {
        default: 
          break;
        case 7: 
          m = j;
          break;
        case 6: 
          i1 = j;
          break;
        case 5: 
          k = j;
          break;
        case 4: 
          i2 = j;
          break;
        case 3: 
          n = j;
          break;
        case 2: 
          i5 = j;
          break;
        case 1: 
          i4 = j;
          break;
        case 0: 
          i3 = j;
        }
        j++;
      }
      if (k != -1) {
        paramString = new a(k, m, n, i1, i2, i3, i4, i5, paramString.length);
      } else {
        paramString = null;
      }
      return paramString;
    }
  }
  
  static final class b
  {
    private static final Pattern a = Pattern.compile("\\{([^}]*)\\}");
    private static final Pattern b = Pattern.compile(o0.A("\\\\pos\\((%1$s),(%1$s)\\)", new Object[] { "\\s*\\d+(?:\\.\\d+)?\\s*" }));
    private static final Pattern c = Pattern.compile(o0.A("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", new Object[] { "\\s*\\d+(?:\\.\\d+)?\\s*" }));
    private static final Pattern d = Pattern.compile("\\\\an(\\d+)");
    public final int e;
    @Nullable
    public final PointF f;
    
    private b(int paramInt, @Nullable PointF paramPointF)
    {
      this.e = paramInt;
      this.f = paramPointF;
    }
    
    private static int a(String paramString)
    {
      paramString = d.matcher(paramString);
      int i;
      if (paramString.find()) {
        i = c.a((String)g.e(paramString.group(1)));
      } else {
        i = -1;
      }
      return i;
    }
    
    public static b b(String paramString)
    {
      Matcher localMatcher = a.matcher(paramString);
      String str1 = null;
      int i = -1;
      while (localMatcher.find())
      {
        String str3 = (String)g.e(localMatcher.group(1));
        try
        {
          PointF localPointF = c(str3);
          paramString = str1;
          if (localPointF != null) {
            paramString = localPointF;
          }
        }
        catch (RuntimeException paramString)
        {
          for (;;)
          {
            int j;
            String str2;
            paramString = str2;
          }
        }
        try
        {
          j = a(str3);
          str1 = paramString;
          if (j != -1)
          {
            i = j;
            str1 = paramString;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          str2 = paramString;
        }
      }
      return new b(i, str2);
    }
    
    @Nullable
    private static PointF c(String paramString)
    {
      Matcher localMatcher1 = b.matcher(paramString);
      Matcher localMatcher2 = c.matcher(paramString);
      boolean bool1 = localMatcher1.find();
      boolean bool2 = localMatcher2.find();
      Object localObject;
      if (bool1)
      {
        if (bool2)
        {
          localObject = new StringBuilder(String.valueOf(paramString).length() + 82);
          ((StringBuilder)localObject).append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("'");
          u.f("SsaStyle.Overrides", ((StringBuilder)localObject).toString());
        }
        localObject = localMatcher1.group(1);
        paramString = localMatcher1.group(2);
      }
      else
      {
        if (!bool2) {
          break label157;
        }
        localObject = localMatcher2.group(1);
        paramString = localMatcher2.group(2);
      }
      return new PointF(Float.parseFloat(((String)g.e(localObject)).trim()), Float.parseFloat(((String)g.e(paramString)).trim()));
      label157:
      return null;
    }
    
    public static String d(String paramString)
    {
      return a.matcher(paramString).replaceAll("");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\q\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */