package com.tplink.iot.g.b.c;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class a
  implements InputFilter
{
  private final Pattern c;
  
  public a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("^\\d{0,");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("}((\\.\\d{0,");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("})|(\\.)?)$");
    this.c = Pattern.compile(localStringBuilder.toString());
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    boolean bool = j.a(".", paramCharSequence);
    paramInt2 = 0;
    if (bool)
    {
      if ((paramSpanned != null) && (paramSpanned.length() != 0)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      if (paramInt1 != 0) {
        return "0.";
      }
    }
    if (j.a(",", paramCharSequence))
    {
      if (paramSpanned != null)
      {
        paramInt1 = paramInt2;
        if (paramSpanned.length() != 0) {}
      }
      else
      {
        paramInt1 = 1;
      }
      if (paramInt1 != 0) {
        return "0,";
      }
    }
    String str = "";
    if (paramSpanned == null) {
      paramSpanned = "";
    }
    paramSpanned = new StringBuilder(paramSpanned);
    if (j.a("", paramCharSequence)) {
      paramSpanned.replace(paramInt3, paramInt4, "");
    } else {
      paramSpanned.insert(paramInt3, paramCharSequence);
    }
    paramCharSequence = paramSpanned.toString();
    j.d(paramCharSequence, "builder.toString()");
    paramCharSequence = m.v(paramCharSequence, ',', '.', false, 4, null);
    if (!this.c.matcher(paramCharSequence).matches()) {
      paramCharSequence = str;
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */