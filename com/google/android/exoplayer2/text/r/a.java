package com.google.android.exoplayer2.text.r;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.v;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends d
{
  private static final Pattern o = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
  private static final Pattern p = Pattern.compile("\\{\\\\.*?\\}");
  private final StringBuilder q = new StringBuilder();
  private final ArrayList<String> r = new ArrayList();
  
  public a()
  {
    super("SubripDecoder");
  }
  
  private c B(Spanned paramSpanned, @Nullable String paramString)
  {
    paramSpanned = new c.b().o(paramSpanned);
    if (paramString == null) {
      return paramSpanned.a();
    }
    switch (paramString.hashCode())
    {
    default: 
      break;
    case -685620462: 
      if (paramString.equals("{\\an9}")) {
        i = 5;
      }
      break;
    case -685620493: 
      if (paramString.equals("{\\an8}")) {
        i = 8;
      }
      break;
    case -685620524: 
      if (paramString.equals("{\\an7}")) {
        i = 2;
      }
      break;
    case -685620555: 
      if (paramString.equals("{\\an6}")) {
        i = 4;
      }
      break;
    case -685620586: 
      if (paramString.equals("{\\an5}")) {
        i = 7;
      }
      break;
    case -685620617: 
      if (paramString.equals("{\\an4}")) {
        i = 1;
      }
      break;
    case -685620648: 
      if (paramString.equals("{\\an3}")) {
        i = 3;
      }
      break;
    case -685620679: 
      if (paramString.equals("{\\an2}")) {
        i = 6;
      }
      break;
    case -685620710: 
      if (paramString.equals("{\\an1}")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    if ((i != 0) && (i != 1) && (i != 2))
    {
      if ((i != 3) && (i != 4) && (i != 5)) {
        paramSpanned.l(1);
      } else {
        paramSpanned.l(2);
      }
    }
    else {
      paramSpanned.l(0);
    }
    switch (paramString.hashCode())
    {
    default: 
      break;
    case -685620462: 
      if (paramString.equals("{\\an9}")) {
        i = 5;
      }
      break;
    case -685620493: 
      if (paramString.equals("{\\an8}")) {
        i = 4;
      }
      break;
    case -685620524: 
      if (paramString.equals("{\\an7}")) {
        i = 3;
      }
      break;
    case -685620555: 
      if (paramString.equals("{\\an6}")) {
        i = 8;
      }
      break;
    case -685620586: 
      if (paramString.equals("{\\an5}")) {
        i = 7;
      }
      break;
    case -685620617: 
      if (paramString.equals("{\\an4}")) {
        i = 6;
      }
      break;
    case -685620648: 
      if (paramString.equals("{\\an3}")) {
        i = 2;
      }
      break;
    case -685620679: 
      if (paramString.equals("{\\an2}")) {
        i = 1;
      }
      break;
    case -685620710: 
      if (paramString.equals("{\\an1}")) {
        i = 0;
      }
      break;
    }
    i = -1;
    if ((i != 0) && (i != 1) && (i != 2))
    {
      if ((i != 3) && (i != 4) && (i != 5)) {
        paramSpanned.i(1);
      } else {
        paramSpanned.i(0);
      }
    }
    else {
      paramSpanned.i(2);
    }
    return paramSpanned.k(C(paramSpanned.d())).h(C(paramSpanned.c()), 0).a();
  }
  
  static float C(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return 0.92F;
        }
        throw new IllegalArgumentException();
      }
      return 0.5F;
    }
    return 0.08F;
  }
  
  private static long D(Matcher paramMatcher, int paramInt)
  {
    String str = paramMatcher.group(paramInt + 1);
    if (str != null) {
      l1 = Long.parseLong(str) * 60L * 60L * 1000L;
    } else {
      l1 = 0L;
    }
    long l2 = l1 + Long.parseLong((String)g.e(paramMatcher.group(paramInt + 2))) * 60L * 1000L + Long.parseLong((String)g.e(paramMatcher.group(paramInt + 3))) * 1000L;
    paramMatcher = paramMatcher.group(paramInt + 4);
    long l1 = l2;
    if (paramMatcher != null) {
      l1 = l2 + Long.parseLong(paramMatcher);
    }
    return l1 * 1000L;
  }
  
  private String E(String paramString, ArrayList<String> paramArrayList)
  {
    String str = paramString.trim();
    paramString = new StringBuilder(str);
    Matcher localMatcher = p.matcher(str);
    int i = 0;
    while (localMatcher.find())
    {
      str = localMatcher.group();
      paramArrayList.add(str);
      int j = localMatcher.start() - i;
      int k = str.length();
      paramString.replace(j, j + k, "");
      i += k;
    }
    return paramString.toString();
  }
  
  protected f y(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    v localv = new v();
    d0 locald0 = new d0(paramArrayOfByte, paramInt);
    for (;;)
    {
      paramArrayOfByte = locald0.p();
      paramInt = 0;
      if (paramArrayOfByte == null) {
        break;
      }
      if (paramArrayOfByte.length() != 0) {
        try
        {
          Integer.parseInt(paramArrayOfByte);
          paramArrayOfByte = locald0.p();
          if (paramArrayOfByte == null)
          {
            u.h("SubripDecoder", "Unexpected end");
            break;
          }
          Matcher localMatcher = o.matcher(paramArrayOfByte);
          if (localMatcher.matches())
          {
            localv.a(D(localMatcher, 1));
            localv.a(D(localMatcher, 6));
            this.q.setLength(0);
            this.r.clear();
            for (paramArrayOfByte = locald0.p(); !TextUtils.isEmpty(paramArrayOfByte); paramArrayOfByte = locald0.p())
            {
              if (this.q.length() > 0) {
                this.q.append("<br>");
              }
              this.q.append(E(paramArrayOfByte, this.r));
            }
            Spanned localSpanned = Html.fromHtml(this.q.toString());
            localMatcher = null;
            for (;;)
            {
              paramArrayOfByte = localMatcher;
              if (paramInt >= this.r.size()) {
                break;
              }
              paramArrayOfByte = (String)this.r.get(paramInt);
              if (paramArrayOfByte.matches("\\{\\\\an[1-9]\\}")) {
                break;
              }
              paramInt++;
            }
            localArrayList.add(B(localSpanned, paramArrayOfByte));
            localArrayList.add(c.a);
          }
          else
          {
            if (paramArrayOfByte.length() != 0) {
              paramArrayOfByte = "Skipping invalid timing: ".concat(paramArrayOfByte);
            } else {
              paramArrayOfByte = new String("Skipping invalid timing: ");
            }
            u.h("SubripDecoder", paramArrayOfByte);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (paramArrayOfByte.length() != 0) {
            paramArrayOfByte = "Skipping invalid index: ".concat(paramArrayOfByte);
          } else {
            paramArrayOfByte = new String("Skipping invalid index: ");
          }
          u.h("SubripDecoder", paramArrayOfByte);
        }
      }
    }
    return new b((c[])localArrayList.toArray(new c[0]), localv.d());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\r\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */