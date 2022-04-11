package io.netty.handler.codec.http;

import io.netty.handler.codec.DateFormatter;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Deprecated
public final class CookieDecoder
{
  private static final String COMMENT = "Comment";
  private static final String COMMENTURL = "CommentURL";
  private static final String DISCARD = "Discard";
  private static final CookieDecoder LAX = new CookieDecoder(false);
  private static final String PORT = "Port";
  private static final CookieDecoder STRICT = new CookieDecoder(true);
  private static final String VERSION = "Version";
  private final InternalLogger logger = InternalLoggerFactory.getInstance(CookieDecoder.class);
  private final boolean strict;
  
  private CookieDecoder(boolean paramBoolean)
  {
    this.strict = paramBoolean;
  }
  
  public static Set<Cookie> decode(String paramString)
  {
    return decode(paramString, true);
  }
  
  public static Set<Cookie> decode(String paramString, boolean paramBoolean)
  {
    CookieDecoder localCookieDecoder;
    if (paramBoolean) {
      localCookieDecoder = STRICT;
    } else {
      localCookieDecoder = LAX;
    }
    return localCookieDecoder.doDecode(paramString);
  }
  
  private Set<Cookie> doDecode(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList(8);
    ArrayList localArrayList2 = new ArrayList(8);
    extractKeyValuePairs(paramString, localArrayList1, localArrayList2);
    if (localArrayList1.isEmpty()) {
      return Collections.emptySet();
    }
    int i;
    int j;
    if (((String)localArrayList1.get(0)).equalsIgnoreCase("Version"))
    {
      try
      {
        i = Integer.parseInt((String)localArrayList2.get(0));
      }
      catch (NumberFormatException paramString)
      {
        i = 0;
      }
      j = 1;
    }
    else
    {
      i = 0;
      j = 0;
    }
    if (localArrayList1.size() <= j) {
      return Collections.emptySet();
    }
    TreeSet localTreeSet = new TreeSet();
    int k = i;
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      DefaultCookie localDefaultCookie;
      long l1;
      ArrayList localArrayList3;
      String str;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      Object localObject3;
      label229:
      Object localObject4;
      boolean bool4;
      int m;
      boolean bool5;
      boolean bool6;
      long l2;
      Object localObject5;
      Object localObject6;
      int i1;
      if (j < localArrayList1.size())
      {
        localObject1 = (String)localArrayList1.get(j);
        localObject2 = (String)localArrayList2.get(j);
        paramString = (String)localObject2;
        if (localObject2 == null) {
          paramString = "";
        }
        localDefaultCookie = initCookie((String)localObject1, paramString);
        if (localDefaultCookie != null)
        {
          l1 = Long.MIN_VALUE;
          localArrayList3 = new ArrayList(2);
          i = j + 1;
          localObject1 = null;
          str = null;
          paramString = str;
          localObject2 = paramString;
          bool1 = false;
          bool2 = false;
          bool3 = false;
          localObject3 = paramString;
          if (i < localArrayList1.size())
          {
            localObject4 = (String)localArrayList1.get(i);
            paramString = (String)localArrayList2.get(i);
            if ("Discard".equalsIgnoreCase((String)localObject4))
            {
              bool4 = true;
              paramString = str;
              m = k;
              localObject4 = localObject3;
              bool5 = bool1;
              bool6 = bool2;
              l2 = l1;
              localObject5 = localObject1;
              localObject6 = localObject2;
            }
            else if ("Secure".equalsIgnoreCase((String)localObject4))
            {
              bool5 = true;
              paramString = str;
              m = k;
              localObject4 = localObject3;
              bool6 = bool2;
              l2 = l1;
              localObject5 = localObject1;
              bool4 = bool3;
              localObject6 = localObject2;
            }
            else if ("HTTPOnly".equalsIgnoreCase((String)localObject4))
            {
              bool6 = true;
              paramString = str;
              m = k;
              localObject4 = localObject3;
              bool5 = bool1;
              l2 = l1;
              localObject5 = localObject1;
              bool4 = bool3;
              localObject6 = localObject2;
            }
            else if ("Comment".equalsIgnoreCase((String)localObject4))
            {
              localObject5 = paramString;
              paramString = str;
              m = k;
              localObject4 = localObject3;
              bool5 = bool1;
              bool6 = bool2;
              l2 = l1;
              bool4 = bool3;
              localObject6 = localObject2;
            }
            else if ("CommentURL".equalsIgnoreCase((String)localObject4))
            {
              localObject6 = paramString;
              paramString = str;
              m = k;
              localObject4 = localObject3;
              bool5 = bool1;
              bool6 = bool2;
              l2 = l1;
              localObject5 = localObject1;
              bool4 = bool3;
            }
            else if ("Domain".equalsIgnoreCase((String)localObject4))
            {
              m = k;
              localObject4 = localObject3;
              bool5 = bool1;
              bool6 = bool2;
              l2 = l1;
              localObject5 = localObject1;
              bool4 = bool3;
              localObject6 = localObject2;
            }
            else if ("Path".equalsIgnoreCase((String)localObject4))
            {
              localObject4 = paramString;
              paramString = str;
              m = k;
              bool5 = bool1;
              bool6 = bool2;
              l2 = l1;
              localObject5 = localObject1;
              bool4 = bool3;
              localObject6 = localObject2;
            }
            else
            {
              Object localObject7;
              if ("Expires".equalsIgnoreCase((String)localObject4))
              {
                localObject7 = DateFormatter.parseHttpDate(paramString);
                paramString = str;
                m = k;
                localObject4 = localObject3;
                bool5 = bool1;
                bool6 = bool2;
                l2 = l1;
                localObject5 = localObject1;
                bool4 = bool3;
                localObject6 = localObject2;
                if (localObject7 != null)
                {
                  l2 = ((Date)localObject7).getTime() - System.currentTimeMillis();
                  l1 = l2 / 1000L;
                  if (l2 % 1000L != 0L) {
                    m = 1;
                  } else {
                    m = 0;
                  }
                  l2 = l1 + m;
                  paramString = str;
                  m = k;
                  localObject4 = localObject3;
                  bool5 = bool1;
                  bool6 = bool2;
                  localObject5 = localObject1;
                  bool4 = bool3;
                  localObject6 = localObject2;
                }
              }
              else if ("Max-Age".equalsIgnoreCase((String)localObject4))
              {
                l2 = Integer.parseInt(paramString);
                paramString = str;
                m = k;
                localObject4 = localObject3;
                bool5 = bool1;
                bool6 = bool2;
                localObject5 = localObject1;
                bool4 = bool3;
                localObject6 = localObject2;
              }
              else if ("Version".equalsIgnoreCase((String)localObject4))
              {
                m = Integer.parseInt(paramString);
                paramString = str;
                localObject4 = localObject3;
                bool5 = bool1;
                bool6 = bool2;
                l2 = l1;
                localObject5 = localObject1;
                bool4 = bool3;
                localObject6 = localObject2;
              }
              else
              {
                if (!"Port".equalsIgnoreCase((String)localObject4)) {
                  break label966;
                }
                localObject7 = paramString.split(",");
                int n = localObject7.length;
                i1 = 0;
                label856:
                paramString = str;
                m = k;
                localObject4 = localObject3;
                bool5 = bool1;
                bool6 = bool2;
                l2 = l1;
                localObject5 = localObject1;
                bool4 = bool3;
                localObject6 = localObject2;
                if (i1 < n) {
                  paramString = localObject7[i1];
                }
              }
            }
          }
        }
      }
      try
      {
        localArrayList3.add(Integer.valueOf(paramString));
        i1++;
        break label856;
        i++;
        j++;
        str = paramString;
        k = m;
        localObject3 = localObject4;
        bool1 = bool5;
        bool2 = bool6;
        l1 = l2;
        localObject1 = localObject5;
        bool3 = bool4;
        localObject2 = localObject6;
        break label229;
        label966:
        localDefaultCookie.setVersion(k);
        localDefaultCookie.setMaxAge(l1);
        localDefaultCookie.setPath((String)localObject3);
        localDefaultCookie.setDomain(str);
        localDefaultCookie.setSecure(bool1);
        localDefaultCookie.setHttpOnly(bool2);
        if (k > 0) {
          localDefaultCookie.setComment((String)localObject1);
        }
        if (k > 1)
        {
          localDefaultCookie.setCommentUrl((String)localObject2);
          localDefaultCookie.setPorts(localArrayList3);
          localDefaultCookie.setDiscard(bool3);
        }
        localTreeSet.add(localDefaultCookie);
        j++;
        continue;
        return localTreeSet;
      }
      catch (NumberFormatException paramString)
      {
        for (;;) {}
      }
    }
  }
  
  private static void extractKeyValuePairs(String paramString, List<String> paramList1, List<String> paramList2)
  {
    int i = paramString.length();
    int j = 0;
    for (;;)
    {
      int k;
      if (j != i)
      {
        k = paramString.charAt(j);
        if ((k == 32) || (k == 44) || (k == 59)) {
          break label504;
        }
      }
      switch (k)
      {
      default: 
        for (;;)
        {
          if (j == i) {
            return;
          }
          if (paramString.charAt(j) != '$') {
            break;
          }
          j++;
        }
        Object localObject1 = null;
        Object localObject2;
        if (j == i)
        {
          localObject2 = null;
        }
        else
        {
          k = j;
          do
          {
            m = paramString.charAt(k);
            if (m == 59) {
              break label466;
            }
            if (m == 61) {
              break;
            }
            m = k + 1;
            k = m;
          } while (m != i);
          localObject1 = paramString.substring(j);
          k = m;
          break label476;
          String str = paramString.substring(j, k);
          j = k + 1;
          if (j == i) {
            localObject1 = "";
          }
          char c1;
          for (localObject2 = localObject1;; localObject2 = localObject1)
          {
            localObject1 = str;
            break label483;
            c1 = paramString.charAt(j);
            if ((c1 == '"') || (c1 == '\'')) {
              break;
            }
            k = paramString.indexOf(';', j);
            if (k > 0)
            {
              localObject1 = paramString.substring(j, k);
              j = k;
            }
            else
            {
              localObject1 = paramString.substring(j);
              j = i;
            }
          }
          localObject1 = new StringBuilder(paramString.length() - j);
          j++;
          int m = 0;
          for (;;)
          {
            if (j == i)
            {
              localObject1 = ((StringBuilder)localObject1).toString();
              break;
            }
            if (m != 0)
            {
              c2 = paramString.charAt(j);
              if ((c2 != '"') && (c2 != '\'') && (c2 != '\\')) {
                ((StringBuilder)localObject1).append(c2);
              } else {
                ((StringBuilder)localObject1).setCharAt(((StringBuilder)localObject1).length() - 1, c2);
              }
              j++;
              break label311;
            }
            k = j + 1;
            char c2 = paramString.charAt(j);
            if (c2 == c1)
            {
              localObject2 = ((StringBuilder)localObject1).toString();
              localObject1 = str;
              j = k;
              break label483;
            }
            ((StringBuilder)localObject1).append(c2);
            if (c2 == '\\')
            {
              j = k;
              m = 1;
            }
            else
            {
              j = k;
            }
          }
          localObject1 = paramString.substring(j, k);
          localObject2 = null;
          j = k;
        }
        paramList1.add(localObject1);
        paramList2.add(localObject2);
        break;
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
        label311:
        label466:
        label476:
        label483:
        label504:
        j++;
      }
    }
  }
  
  private DefaultCookie initCookie(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      if (paramString2 == null)
      {
        this.logger.debug("Skipping cookie with null value");
        return null;
      }
      CharSequence localCharSequence = CookieUtil.unwrapValue(paramString2);
      if (localCharSequence == null)
      {
        this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", localCharSequence);
        return null;
      }
      int i;
      if (this.strict)
      {
        i = CookieUtil.firstInvalidCookieNameOctet(paramString1);
        if (i >= 0)
        {
          if (this.logger.isDebugEnabled()) {
            this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", paramString1, Character.valueOf(paramString1.charAt(i)));
          }
          return null;
        }
      }
      boolean bool;
      if (localCharSequence.length() != paramString2.length()) {
        bool = true;
      } else {
        bool = false;
      }
      if (this.strict)
      {
        i = CookieUtil.firstInvalidCookieValueOctet(localCharSequence);
        if (i >= 0)
        {
          if (this.logger.isDebugEnabled()) {
            this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", localCharSequence, Character.valueOf(localCharSequence.charAt(i)));
          }
          return null;
        }
      }
      paramString1 = new DefaultCookie(paramString1, localCharSequence.toString());
      paramString1.setWrap(bool);
      return paramString1;
    }
    this.logger.debug("Skipping cookie with null name");
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\CookieDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */