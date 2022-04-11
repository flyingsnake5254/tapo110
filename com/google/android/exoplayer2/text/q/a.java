package com.google.android.exoplayer2.text.q;

import android.graphics.PointF;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  extends com.google.android.exoplayer2.text.d
{
  private static final Pattern o = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
  private final boolean p;
  @Nullable
  private final b q;
  private Map<String, c> r;
  private float s = -3.4028235E38F;
  private float t = -3.4028235E38F;
  
  public a(@Nullable List<byte[]> paramList)
  {
    super("SsaDecoder");
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.p = true;
      String str = o0.B((byte[])paramList.get(0));
      g.a(str.startsWith("Format:"));
      this.q = ((b)g.e(b.a(str)));
      G(new d0((byte[])paramList.get(1)));
    }
    else
    {
      this.p = false;
      this.q = null;
    }
  }
  
  private static int B(long paramLong, List<Long> paramList, List<List<com.google.android.exoplayer2.text.c>> paramList1)
  {
    for (int i = paramList.size() - 1; i >= 0; i--)
    {
      if (((Long)paramList.get(i)).longValue() == paramLong) {
        return i;
      }
      if (((Long)paramList.get(i)).longValue() < paramLong)
      {
        i++;
        break label71;
      }
    }
    i = 0;
    label71:
    paramList.add(i, Long.valueOf(paramLong));
    paramList = new java/util/ArrayList;
    if (i == 0) {
      paramList.<init>();
    } else {
      paramList.<init>((Collection)paramList1.get(i - 1));
    }
    paramList1.add(i, paramList);
    return i;
  }
  
  private static float C(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return -3.4028235E38F;
        }
        return 0.95F;
      }
      return 0.5F;
    }
    return 0.05F;
  }
  
  private static com.google.android.exoplayer2.text.c D(String paramString, @Nullable c paramc, c.b paramb, float paramFloat1, float paramFloat2)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    paramString = new com.google.android.exoplayer2.text.c.b().o(localSpannableString);
    if (paramc != null)
    {
      if (paramc.c != null) {
        localSpannableString.setSpan(new ForegroundColorSpan(paramc.c.intValue()), 0, localSpannableString.length(), 33);
      }
      float f = paramc.d;
      if ((f != -3.4028235E38F) && (paramFloat2 != -3.4028235E38F)) {
        paramString.q(f / paramFloat2, 1);
      }
      boolean bool = paramc.e;
      if ((bool) && (paramc.f)) {
        localSpannableString.setSpan(new StyleSpan(3), 0, localSpannableString.length(), 33);
      } else if (bool) {
        localSpannableString.setSpan(new StyleSpan(1), 0, localSpannableString.length(), 33);
      } else if (paramc.f) {
        localSpannableString.setSpan(new StyleSpan(2), 0, localSpannableString.length(), 33);
      }
      if (paramc.g) {
        localSpannableString.setSpan(new UnderlineSpan(), 0, localSpannableString.length(), 33);
      }
      if (paramc.h) {
        localSpannableString.setSpan(new StrikethroughSpan(), 0, localSpannableString.length(), 33);
      }
    }
    int i = paramb.e;
    if (i == -1) {
      if (paramc != null) {
        i = paramc.b;
      } else {
        i = -1;
      }
    }
    paramString.p(M(i)).l(L(i)).i(K(i));
    paramc = paramb.f;
    if ((paramc != null) && (paramFloat2 != -3.4028235E38F) && (paramFloat1 != -3.4028235E38F))
    {
      paramString.k(paramc.x / paramFloat1);
      paramString.h(paramb.f.y / paramFloat2, 0);
    }
    else
    {
      paramString.k(C(paramString.d()));
      paramString.h(C(paramString.c()), 0);
    }
    return paramString.a();
  }
  
  private void E(String paramString, b paramb, List<List<com.google.android.exoplayer2.text.c>> paramList, List<Long> paramList1)
  {
    g.a(paramString.startsWith("Dialogue:"));
    Object localObject = paramString.substring(9).split(",", paramb.e);
    if (localObject.length != paramb.e)
    {
      if (paramString.length() != 0) {
        paramString = "Skipping dialogue line with fewer columns than format: ".concat(paramString);
      } else {
        paramString = new String("Skipping dialogue line with fewer columns than format: ");
      }
      u.h("SsaDecoder", paramString);
      return;
    }
    long l1 = J(localObject[paramb.a]);
    if (l1 == -9223372036854775807L)
    {
      if (paramString.length() != 0) {
        paramString = "Skipping invalid timing: ".concat(paramString);
      } else {
        paramString = new String("Skipping invalid timing: ");
      }
      u.h("SsaDecoder", paramString);
      return;
    }
    long l2 = J(localObject[paramb.b]);
    if (l2 == -9223372036854775807L)
    {
      if (paramString.length() != 0) {
        paramString = "Skipping invalid timing: ".concat(paramString);
      } else {
        paramString = new String("Skipping invalid timing: ");
      }
      u.h("SsaDecoder", paramString);
      return;
    }
    paramString = this.r;
    if (paramString != null)
    {
      i = paramb.c;
      if (i != -1)
      {
        paramString = (c)paramString.get(localObject[i].trim());
        break label231;
      }
    }
    paramString = null;
    label231:
    localObject = localObject[paramb.d];
    paramb = c.b.b((String)localObject);
    paramString = D(c.b.d((String)localObject).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), paramString, paramb, this.s, this.t);
    int i = B(l1, paramList1, paramList);
    int j = B(l2, paramList1, paramList);
    while (i < j)
    {
      ((List)paramList.get(i)).add(paramString);
      i++;
    }
  }
  
  private void F(d0 paramd0, List<List<com.google.android.exoplayer2.text.c>> paramList, List<Long> paramList1)
  {
    b localb;
    if (this.p) {
      localb = this.q;
    } else {
      localb = null;
    }
    for (;;)
    {
      String str = paramd0.p();
      if (str == null) {
        break;
      }
      if (str.startsWith("Format:")) {
        localb = b.a(str);
      } else if (str.startsWith("Dialogue:")) {
        if (localb == null)
        {
          if (str.length() != 0) {
            str = "Skipping dialogue line before complete format: ".concat(str);
          } else {
            str = new String("Skipping dialogue line before complete format: ");
          }
          u.h("SsaDecoder", str);
        }
        else
        {
          E(str, localb, paramList, paramList1);
        }
      }
    }
  }
  
  private void G(d0 paramd0)
  {
    String str;
    do
    {
      for (;;)
      {
        str = paramd0.p();
        if (str == null) {
          return;
        }
        if ("[Script Info]".equalsIgnoreCase(str))
        {
          H(paramd0);
        }
        else if ("[V4+ Styles]".equalsIgnoreCase(str))
        {
          this.r = I(paramd0);
        }
        else
        {
          if (!"[V4 Styles]".equalsIgnoreCase(str)) {
            break;
          }
          u.f("SsaDecoder", "[V4 Styles] are not supported");
        }
      }
    } while (!"[Events]".equalsIgnoreCase(str));
  }
  
  private void H(d0 paramd0)
  {
    for (;;)
    {
      Object localObject = paramd0.p();
      if ((localObject == null) || ((paramd0.a() != 0) && (paramd0.h() == 91))) {
        break;
      }
      localObject = ((String)localObject).split(":");
      if (localObject.length == 2)
      {
        String str = com.google.common.base.c.e(localObject[0].trim());
        str.hashCode();
        if (!str.equals("playresx"))
        {
          if (str.equals("playresy")) {
            try
            {
              this.t = Float.parseFloat(localObject[1].trim());
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        else {
          this.s = Float.parseFloat(localNumberFormatException[1].trim());
        }
      }
    }
  }
  
  private static Map<String, c> I(d0 paramd0)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    c.a locala = null;
    for (;;)
    {
      Object localObject = paramd0.p();
      if ((localObject == null) || ((paramd0.a() != 0) && (paramd0.h() == 91))) {
        break;
      }
      if (((String)localObject).startsWith("Format:")) {
        locala = c.a.a((String)localObject);
      } else if (((String)localObject).startsWith("Style:")) {
        if (locala == null)
        {
          if (((String)localObject).length() != 0) {
            localObject = "Skipping 'Style:' line before 'Format:' line: ".concat((String)localObject);
          } else {
            localObject = new String("Skipping 'Style:' line before 'Format:' line: ");
          }
          u.h("SsaDecoder", (String)localObject);
        }
        else
        {
          localObject = c.b((String)localObject, locala);
          if (localObject != null) {
            localLinkedHashMap.put(((c)localObject).a, localObject);
          }
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private static long J(String paramString)
  {
    paramString = o.matcher(paramString.trim());
    if (!paramString.matches()) {
      return -9223372036854775807L;
    }
    return Long.parseLong((String)o0.i(paramString.group(1))) * 60L * 60L * 1000000L + Long.parseLong((String)o0.i(paramString.group(2))) * 60L * 1000000L + Long.parseLong((String)o0.i(paramString.group(3))) * 1000000L + Long.parseLong((String)o0.i(paramString.group(4))) * 10000L;
  }
  
  private static int K(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder(30);
      localStringBuilder.append("Unknown alignment: ");
      localStringBuilder.append(paramInt);
      u.h("SsaDecoder", localStringBuilder.toString());
      return Integer.MIN_VALUE;
    case 7: 
    case 8: 
    case 9: 
      return 0;
    case 4: 
    case 5: 
    case 6: 
      return 1;
    case 1: 
    case 2: 
    case 3: 
      return 2;
    }
    return Integer.MIN_VALUE;
  }
  
  private static int L(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder(30);
      localStringBuilder.append("Unknown alignment: ");
      localStringBuilder.append(paramInt);
      u.h("SsaDecoder", localStringBuilder.toString());
      return Integer.MIN_VALUE;
    case 3: 
    case 6: 
    case 9: 
      return 2;
    case 2: 
    case 5: 
    case 8: 
      return 1;
    case 1: 
    case 4: 
    case 7: 
      return 0;
    }
    return Integer.MIN_VALUE;
  }
  
  @Nullable
  private static Layout.Alignment M(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder(30);
      localStringBuilder.append("Unknown alignment: ");
      localStringBuilder.append(paramInt);
      u.h("SsaDecoder", localStringBuilder.toString());
      return null;
    case 3: 
    case 6: 
    case 9: 
      return Layout.Alignment.ALIGN_OPPOSITE;
    case 2: 
    case 5: 
    case 8: 
      return Layout.Alignment.ALIGN_CENTER;
    case 1: 
    case 4: 
    case 7: 
      return Layout.Alignment.ALIGN_NORMAL;
    }
    return null;
  }
  
  protected f y(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramArrayOfByte = new d0(paramArrayOfByte, paramInt);
    if (!this.p) {
      G(paramArrayOfByte);
    }
    F(paramArrayOfByte, localArrayList1, localArrayList2);
    return new d(localArrayList1, localArrayList2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\q\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */