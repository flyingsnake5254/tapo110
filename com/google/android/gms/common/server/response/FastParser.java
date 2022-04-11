package com.google.android.gms.common.server.response;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@KeepForSdk
@ShowFirstParty
public class FastParser<T extends FastJsonResponse>
{
  private static final char[] zaqg = { 117, 108, 108 };
  private static final char[] zaqh = { 114, 117, 101 };
  private static final char[] zaqi = { 114, 117, 101, 34 };
  private static final char[] zaqj = { 97, 108, 115, 101 };
  private static final char[] zaqk = { 97, 108, 115, 101, 34 };
  private static final char[] zaql = { '\n' };
  private static final zaa<Integer> zaqn = new zaa();
  private static final zaa<Long> zaqo = new zab();
  private static final zaa<Float> zaqp = new zac();
  private static final zaa<Double> zaqq = new zad();
  private static final zaa<Boolean> zaqr = new zae();
  private static final zaa<String> zaqs = new zaf();
  private static final zaa<BigInteger> zaqt = new zag();
  private static final zaa<BigDecimal> zaqu = new zah();
  private final char[] zaqb = new char[1];
  private final char[] zaqc = new char[32];
  private final char[] zaqd = new char['Ѐ'];
  private final StringBuilder zaqe = new StringBuilder(32);
  private final StringBuilder zaqf = new StringBuilder(1024);
  private final Stack<Integer> zaqm = new Stack();
  
  private final int zaa(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    int i = zaj(paramBufferedReader);
    if (i != 0)
    {
      if (i != 44)
      {
        if (i == 110)
        {
          zab(paramBufferedReader, zaqg);
          return 0;
        }
        paramBufferedReader.mark(1024);
        int k;
        if (i == 34)
        {
          i = 0;
          int j = 0;
          for (;;)
          {
            k = i;
            if (i >= paramArrayOfChar.length) {
              break label240;
            }
            k = i;
            if (paramBufferedReader.read(paramArrayOfChar, i, 1) == -1) {
              break label240;
            }
            char c = paramArrayOfChar[i];
            if (Character.isISOControl(c)) {
              break;
            }
            if ((c == '"') && (j == 0))
            {
              paramBufferedReader.reset();
              paramBufferedReader.skip(i + 1);
              return i;
            }
            if (c == '\\') {
              j ^= 0x1;
            } else {
              j = 0;
            }
            i++;
          }
          throw new ParseException("Unexpected control character while reading string");
        }
        paramArrayOfChar[0] = ((char)i);
        for (i = 1;; i++)
        {
          k = i;
          if (i >= paramArrayOfChar.length) {
            break label240;
          }
          k = i;
          if (paramBufferedReader.read(paramArrayOfChar, i, 1) == -1) {
            break label240;
          }
          if ((paramArrayOfChar[i] == '}') || (paramArrayOfChar[i] == ',') || (Character.isWhitespace(paramArrayOfChar[i])) || (paramArrayOfChar[i] == ']')) {
            break;
          }
        }
        paramBufferedReader.reset();
        paramBufferedReader.skip(i - 1);
        paramArrayOfChar[i] = ((char)0);
        return i;
        label240:
        if (k == paramArrayOfChar.length) {
          throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
      }
      throw new ParseException("Missing value");
    }
    throw new ParseException("Unexpected EOF");
  }
  
  private final String zaa(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    this.zaqm.push(Integer.valueOf(2));
    char c = zaj(paramBufferedReader);
    if (c != '"')
    {
      if (c != ']')
      {
        if (c == '}')
        {
          zak(2);
          return null;
        }
        paramBufferedReader = new StringBuilder(19);
        paramBufferedReader.append("Unexpected token: ");
        paramBufferedReader.append(c);
        throw new ParseException(paramBufferedReader.toString());
      }
      zak(2);
      zak(1);
      zak(5);
      return null;
    }
    this.zaqm.push(Integer.valueOf(3));
    String str = zab(paramBufferedReader, this.zaqc, this.zaqe, null);
    zak(3);
    if (zaj(paramBufferedReader) == ':') {
      return str;
    }
    throw new ParseException("Expected key/value separator");
  }
  
  private final String zaa(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    int i = zaj(paramBufferedReader);
    if (i != 34)
    {
      if (i == 110)
      {
        zab(paramBufferedReader, zaqg);
        return null;
      }
      throw new ParseException("Expected string");
    }
    return zab(paramBufferedReader, paramArrayOfChar1, paramStringBuilder, paramArrayOfChar2);
  }
  
  private final <T extends FastJsonResponse> ArrayList<T> zaa(BufferedReader paramBufferedReader, FastJsonResponse.Field<?, ?> paramField)
    throws FastParser.ParseException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    char c = zaj(paramBufferedReader);
    if (c != ']')
    {
      if (c != 'n')
      {
        if (c == '{')
        {
          this.zaqm.push(Integer.valueOf(1));
          try
          {
            for (;;)
            {
              FastJsonResponse localFastJsonResponse = paramField.zacp();
              if (!zaa(paramBufferedReader, localFastJsonResponse)) {
                break label170;
              }
              localArrayList.add(localFastJsonResponse);
              c = zaj(paramBufferedReader);
              if (c != ',')
              {
                if (c == ']')
                {
                  zak(5);
                  return localArrayList;
                }
                paramBufferedReader = new StringBuilder(19);
                paramBufferedReader.append("Unexpected token: ");
                paramBufferedReader.append(c);
                throw new ParseException(paramBufferedReader.toString());
              }
              if (zaj(paramBufferedReader) != '{') {
                break;
              }
              this.zaqm.push(Integer.valueOf(1));
            }
            throw new ParseException("Expected start of next object in array");
            label170:
            return localArrayList;
          }
          catch (IllegalAccessException paramBufferedReader)
          {
            throw new ParseException("Error instantiating inner object", paramBufferedReader);
          }
          catch (InstantiationException paramBufferedReader)
          {
            throw new ParseException("Error instantiating inner object", paramBufferedReader);
          }
        }
        paramBufferedReader = new StringBuilder(19);
        paramBufferedReader.append("Unexpected token: ");
        paramBufferedReader.append(c);
        throw new ParseException(paramBufferedReader.toString());
      }
      zab(paramBufferedReader, zaqg);
      zak(5);
      return null;
    }
    zak(5);
    return localArrayList;
  }
  
  private final <O> ArrayList<O> zaa(BufferedReader paramBufferedReader, zaa<O> paramzaa)
    throws FastParser.ParseException, IOException
  {
    int i = zaj(paramBufferedReader);
    if (i == 110)
    {
      zab(paramBufferedReader, zaqg);
      return null;
    }
    if (i == 91)
    {
      this.zaqm.push(Integer.valueOf(5));
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        paramBufferedReader.mark(1024);
        i = zaj(paramBufferedReader);
        if (i == 0) {
          break label107;
        }
        if (i != 44)
        {
          if (i == 93) {
            break;
          }
          paramBufferedReader.reset();
          localArrayList.add(paramzaa.zah(this, paramBufferedReader));
        }
      }
      zak(5);
      return localArrayList;
      label107:
      throw new ParseException("Unexpected EOF");
    }
    throw new ParseException("Expected start of array");
  }
  
  private final boolean zaa(BufferedReader paramBufferedReader, FastJsonResponse paramFastJsonResponse)
    throws FastParser.ParseException, IOException
  {
    Map localMap = paramFastJsonResponse.getFieldMappings();
    Object localObject = zaa(paramBufferedReader);
    Integer localInteger = Integer.valueOf(1);
    if (localObject == null)
    {
      zak(1);
      return false;
    }
    while (localObject != null)
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localMap.get(localObject);
      if (localField == null)
      {
        localObject = zab(paramBufferedReader);
      }
      else
      {
        this.zaqm.push(Integer.valueOf(4));
        int i;
        switch (localField.zapr)
        {
        default: 
          i = localField.zapr;
          paramBufferedReader = new StringBuilder(30);
          paramBufferedReader.append("Invalid field type ");
          paramBufferedReader.append(i);
          throw new ParseException(paramBufferedReader.toString());
        case 11: 
          if (localField.zaps)
          {
            i = zaj(paramBufferedReader);
            if (i == 110)
            {
              zab(paramBufferedReader, zaqg);
              paramFastJsonResponse.addConcreteTypeArrayInternal(localField, localField.zapv, null);
              break;
            }
            this.zaqm.push(Integer.valueOf(5));
            if (i == 91)
            {
              paramFastJsonResponse.addConcreteTypeArrayInternal(localField, localField.zapv, zaa(paramBufferedReader, localField));
              break;
            }
            throw new ParseException("Expected array start");
          }
          i = zaj(paramBufferedReader);
          if (i == 110)
          {
            zab(paramBufferedReader, zaqg);
            paramFastJsonResponse.addConcreteTypeInternal(localField, localField.zapv, null);
            break;
          }
          this.zaqm.push(localInteger);
          if (i == 123) {
            try
            {
              localObject = localField.zacp();
              zaa(paramBufferedReader, (FastJsonResponse)localObject);
              paramFastJsonResponse.addConcreteTypeInternal(localField, localField.zapv, (FastJsonResponse)localObject);
            }
            catch (IllegalAccessException paramBufferedReader)
            {
              throw new ParseException("Error instantiating inner object", paramBufferedReader);
            }
            catch (InstantiationException paramBufferedReader)
            {
              throw new ParseException("Error instantiating inner object", paramBufferedReader);
            }
          }
          throw new ParseException("Expected start of object");
        case 10: 
          i = zaj(paramBufferedReader);
          if (i == 110)
          {
            zab(paramBufferedReader, zaqg);
            localObject = null;
          }
          else
          {
            if (i != 123) {
              break label726;
            }
            this.zaqm.push(localInteger);
            localObject = new HashMap();
          }
          for (;;)
          {
            i = zaj(paramBufferedReader);
            if (i == 0) {
              break;
            }
            if (i != 34)
            {
              if (i != 125) {
                break label713;
              }
              zak(1);
            }
            else
            {
              String str = zab(paramBufferedReader, this.zaqc, this.zaqe, null);
              if (zaj(paramBufferedReader) != ':')
              {
                paramBufferedReader = String.valueOf(str);
                if (paramBufferedReader.length() != 0) {
                  paramBufferedReader = "No map value found for key ".concat(paramBufferedReader);
                } else {
                  paramBufferedReader = new String("No map value found for key ");
                }
                throw new ParseException(paramBufferedReader);
              }
              if (zaj(paramBufferedReader) != '"')
              {
                paramBufferedReader = String.valueOf(str);
                if (paramBufferedReader.length() != 0) {
                  paramBufferedReader = "Expected String value for key ".concat(paramBufferedReader);
                } else {
                  paramBufferedReader = new String("Expected String value for key ");
                }
                throw new ParseException(paramBufferedReader);
              }
              ((HashMap)localObject).put(str, zab(paramBufferedReader, this.zaqc, this.zaqe, null));
              c = zaj(paramBufferedReader);
              if (c == ',') {
                break label713;
              }
              if (c != '}') {
                break label676;
              }
              zak(1);
            }
            paramFastJsonResponse.zaa(localField, (Map)localObject);
            break label790;
            paramBufferedReader = new StringBuilder(48);
            paramBufferedReader.append("Unexpected character while parsing string map: ");
            paramBufferedReader.append(c);
            throw new ParseException(paramBufferedReader.toString());
          }
          throw new ParseException("Unexpected EOF");
          throw new ParseException("Expected start of a map object");
        case 9: 
          paramFastJsonResponse.zaa(localField, Base64Utils.decodeUrlSafe(zaa(paramBufferedReader, this.zaqd, this.zaqf, zaql)));
          break;
        case 8: 
          label676:
          label713:
          label726:
          paramFastJsonResponse.zaa(localField, Base64Utils.decode(zaa(paramBufferedReader, this.zaqd, this.zaqf, zaql)));
        }
        for (;;)
        {
          label790:
          break;
          if (localField.zaps)
          {
            paramFastJsonResponse.zah(localField, zaa(paramBufferedReader, zaqs));
          }
          else
          {
            paramFastJsonResponse.zaa(localField, zac(paramBufferedReader));
            continue;
            if (localField.zaps)
            {
              paramFastJsonResponse.zag(localField, zaa(paramBufferedReader, zaqr));
            }
            else
            {
              paramFastJsonResponse.zaa(localField, zaa(paramBufferedReader, false));
              break;
              if (localField.zaps)
              {
                paramFastJsonResponse.zaf(localField, zaa(paramBufferedReader, zaqu));
              }
              else
              {
                paramFastJsonResponse.zaa(localField, zai(paramBufferedReader));
                break;
                if (localField.zaps)
                {
                  paramFastJsonResponse.zae(localField, zaa(paramBufferedReader, zaqq));
                }
                else
                {
                  paramFastJsonResponse.zaa(localField, zah(paramBufferedReader));
                  break;
                  if (localField.zaps)
                  {
                    paramFastJsonResponse.zad(localField, zaa(paramBufferedReader, zaqp));
                  }
                  else
                  {
                    paramFastJsonResponse.zaa(localField, zag(paramBufferedReader));
                    break;
                    if (localField.zaps)
                    {
                      paramFastJsonResponse.zac(localField, zaa(paramBufferedReader, zaqo));
                    }
                    else
                    {
                      paramFastJsonResponse.zaa(localField, zae(paramBufferedReader));
                      break;
                      if (localField.zaps)
                      {
                        paramFastJsonResponse.zab(localField, zaa(paramBufferedReader, zaqt));
                      }
                      else
                      {
                        paramFastJsonResponse.zaa(localField, zaf(paramBufferedReader));
                        break;
                        if (localField.zaps) {
                          paramFastJsonResponse.zaa(localField, zaa(paramBufferedReader, zaqn));
                        } else {
                          paramFastJsonResponse.zaa(localField, zad(paramBufferedReader));
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        zak(4);
        zak(2);
        char c = zaj(paramBufferedReader);
        if (c != ',')
        {
          if (c == '}')
          {
            localObject = null;
          }
          else
          {
            paramBufferedReader = new StringBuilder(55);
            paramBufferedReader.append("Expected end of object or field separator, but found: ");
            paramBufferedReader.append(c);
            throw new ParseException(paramBufferedReader.toString());
          }
        }
        else {
          localObject = zaa(paramBufferedReader);
        }
      }
    }
    zak(1);
    return true;
  }
  
  private final boolean zaa(BufferedReader paramBufferedReader, boolean paramBoolean)
    throws FastParser.ParseException, IOException
  {
    for (;;)
    {
      char c = zaj(paramBufferedReader);
      if (c != '"')
      {
        char[] arrayOfChar;
        if (c != 'f')
        {
          if (c != 'n')
          {
            if (c == 't')
            {
              if (paramBoolean) {
                arrayOfChar = zaqi;
              } else {
                arrayOfChar = zaqh;
              }
              zab(paramBufferedReader, arrayOfChar);
              return true;
            }
            paramBufferedReader = new StringBuilder(19);
            paramBufferedReader.append("Unexpected token: ");
            paramBufferedReader.append(c);
            throw new ParseException(paramBufferedReader.toString());
          }
          zab(paramBufferedReader, zaqg);
          return false;
        }
        if (paramBoolean) {
          arrayOfChar = zaqk;
        } else {
          arrayOfChar = zaqj;
        }
        zab(paramBufferedReader, arrayOfChar);
        return false;
      }
      if (paramBoolean) {
        break;
      }
      paramBoolean = true;
    }
    throw new ParseException("No boolean value found in string");
  }
  
  private final String zab(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    paramBufferedReader.mark(1024);
    int i = zaj(paramBufferedReader);
    int j;
    int k;
    if (i != 34)
    {
      if (i != 44)
      {
        j = 1;
        if (i != 91)
        {
          if (i != 123)
          {
            paramBufferedReader.reset();
            zaa(paramBufferedReader, this.zaqd);
          }
          else
          {
            this.zaqm.push(Integer.valueOf(1));
            paramBufferedReader.mark(32);
            k = zaj(paramBufferedReader);
            if (k == 125)
            {
              zak(1);
            }
            else if (k == 34)
            {
              paramBufferedReader.reset();
              zaa(paramBufferedReader);
              while (zab(paramBufferedReader) != null) {}
              zak(1);
            }
            else
            {
              paramBufferedReader = new StringBuilder(18);
              paramBufferedReader.append("Unexpected token ");
              paramBufferedReader.append(k);
              throw new ParseException(paramBufferedReader.toString());
            }
          }
        }
        else
        {
          this.zaqm.push(Integer.valueOf(5));
          paramBufferedReader.mark(32);
          if (zaj(paramBufferedReader) == ']')
          {
            zak(5);
          }
          else
          {
            paramBufferedReader.reset();
            i = 0;
            int m = 0;
            while (j > 0)
            {
              k = zaj(paramBufferedReader);
              if (k != 0)
              {
                if (!Character.isISOControl(k))
                {
                  int n = m;
                  if (k == 34)
                  {
                    n = m;
                    if (i == 0) {
                      n = m ^ 0x1;
                    }
                  }
                  m = j;
                  if (k == 91)
                  {
                    m = j;
                    if (n == 0) {
                      m = j + 1;
                    }
                  }
                  j = m;
                  if (k == 93)
                  {
                    j = m;
                    if (n == 0) {
                      j = m - 1;
                    }
                  }
                  if ((k == 92) && (n != 0))
                  {
                    i ^= 0x1;
                    m = n;
                  }
                  else
                  {
                    i = 0;
                    m = n;
                  }
                }
                else
                {
                  throw new ParseException("Unexpected control character while reading array");
                }
              }
              else {
                throw new ParseException("Unexpected EOF while parsing array");
              }
            }
            zak(5);
          }
        }
      }
      else
      {
        throw new ParseException("Missing value");
      }
    }
    else
    {
      if (paramBufferedReader.read(this.zaqb) == -1) {
        break label558;
      }
      j = this.zaqb[0];
      i = 0;
    }
    for (;;)
    {
      if ((j == 34) && (i == 0))
      {
        k = zaj(paramBufferedReader);
        if (k != 44)
        {
          if (k == 125)
          {
            zak(2);
            return null;
          }
          paramBufferedReader = new StringBuilder(18);
          paramBufferedReader.append("Unexpected token ");
          paramBufferedReader.append(k);
          throw new ParseException(paramBufferedReader.toString());
        }
        zak(2);
        return zaa(paramBufferedReader);
      }
      if (j == 92) {
        i ^= 0x1;
      } else {
        i = 0;
      }
      if (paramBufferedReader.read(this.zaqb) == -1) {
        break label547;
      }
      k = this.zaqb[0];
      if (Character.isISOControl(k)) {
        break;
      }
      j = k;
    }
    throw new ParseException("Unexpected control character while reading string");
    label547:
    throw new ParseException("Unexpected EOF while parsing string");
    label558:
    throw new ParseException("Unexpected EOF while parsing string");
  }
  
  private static String zab(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
    throws FastParser.ParseException, IOException
  {
    paramStringBuilder.setLength(0);
    paramBufferedReader.mark(paramArrayOfChar1.length);
    int i = 0;
    int j = 0;
    for (;;)
    {
      int k = paramBufferedReader.read(paramArrayOfChar1);
      if (k == -1) {
        break;
      }
      int m = 0;
      while (m < k)
      {
        char c = paramArrayOfChar1[m];
        int n;
        if (Character.isISOControl(c))
        {
          if (paramArrayOfChar2 != null) {
            for (n = 0; n < paramArrayOfChar2.length; n++) {
              if (paramArrayOfChar2[n] == c)
              {
                n = 1;
                break label92;
              }
            }
          }
          n = 0;
          label92:
          if (n == 0) {
            throw new ParseException("Unexpected control character while reading string");
          }
        }
        if ((c == '"') && (i == 0))
        {
          paramStringBuilder.append(paramArrayOfChar1, 0, m);
          paramBufferedReader.reset();
          paramBufferedReader.skip(m + 1);
          if (j != 0) {
            return JsonUtils.unescapeString(paramStringBuilder.toString());
          }
          return paramStringBuilder.toString();
        }
        if (c == '\\')
        {
          j = i ^ 0x1;
          n = 1;
        }
        else
        {
          i = 0;
          n = j;
          j = i;
        }
        m++;
        i = j;
        j = n;
      }
      paramStringBuilder.append(paramArrayOfChar1, 0, k);
      paramBufferedReader.mark(paramArrayOfChar1.length);
    }
    throw new ParseException("Unexpected EOF while parsing string");
  }
  
  private final void zab(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
    throws FastParser.ParseException, IOException
  {
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      int j = paramBufferedReader.read(this.zaqc, 0, paramArrayOfChar.length - i);
      if (j != -1)
      {
        int k = 0;
        while (k < j) {
          if (paramArrayOfChar[(k + i)] == this.zaqc[k]) {
            k++;
          } else {
            throw new ParseException("Unexpected character");
          }
        }
        i += j;
      }
      else
      {
        throw new ParseException("Unexpected EOF");
      }
    }
  }
  
  private final String zac(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    return zaa(paramBufferedReader, this.zaqc, this.zaqe, null);
  }
  
  private final int zad(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    int j = 0;
    if (i == 0) {
      return 0;
    }
    paramBufferedReader = this.zaqd;
    if (i > 0)
    {
      int k;
      int m;
      int n;
      if (paramBufferedReader[0] == '-')
      {
        k = Integer.MIN_VALUE;
        m = 1;
        n = 1;
      }
      else
      {
        k = -2147483647;
        m = 0;
        n = 0;
      }
      int i1 = m;
      if (m < i)
      {
        i1 = Character.digit(paramBufferedReader[m], 10);
        if (i1 >= 0)
        {
          j = -i1;
          i1 = m + 1;
        }
        else
        {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      while (i1 < i)
      {
        m = Character.digit(paramBufferedReader[i1], 10);
        if (m >= 0)
        {
          if (j >= -214748364)
          {
            j *= 10;
            if (j >= k + m)
            {
              j -= m;
              i1++;
            }
            else
            {
              throw new ParseException("Number too large");
            }
          }
          else
          {
            throw new ParseException("Number too large");
          }
        }
        else {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      if (n != 0)
      {
        if (i1 > 1) {
          return j;
        }
        throw new ParseException("No digits to parse");
      }
      return -j;
    }
    throw new ParseException("No number to parse");
  }
  
  private final long zae(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    long l1 = 0L;
    if (i == 0) {
      return 0L;
    }
    paramBufferedReader = this.zaqd;
    if (i > 0)
    {
      int j = 0;
      long l2;
      int k;
      if (paramBufferedReader[0] == '-')
      {
        l2 = Long.MIN_VALUE;
        j = 1;
        k = 1;
      }
      else
      {
        l2 = -9223372036854775807L;
        k = 0;
      }
      int m = j;
      if (j < i)
      {
        m = Character.digit(paramBufferedReader[j], 10);
        if (m >= 0)
        {
          l1 = -m;
          m = j + 1;
        }
        else
        {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      while (m < i)
      {
        j = Character.digit(paramBufferedReader[m], 10);
        if (j >= 0)
        {
          if (l1 >= -922337203685477580L)
          {
            l1 *= 10L;
            long l3 = j;
            if (l1 >= l2 + l3)
            {
              l1 -= l3;
              m++;
            }
            else
            {
              throw new ParseException("Number too large");
            }
          }
          else
          {
            throw new ParseException("Number too large");
          }
        }
        else {
          throw new ParseException("Unexpected non-digit character");
        }
      }
      if (k != 0)
      {
        if (m > 1) {
          return l1;
        }
        throw new ParseException("No digits to parse");
      }
      return -l1;
    }
    throw new ParseException("No number to parse");
  }
  
  private final BigInteger zaf(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    if (i == 0) {
      return null;
    }
    return new BigInteger(new String(this.zaqd, 0, i));
  }
  
  private final float zag(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    if (i == 0) {
      return 0.0F;
    }
    return Float.parseFloat(new String(this.zaqd, 0, i));
  }
  
  private final double zah(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    if (i == 0) {
      return 0.0D;
    }
    return Double.parseDouble(new String(this.zaqd, 0, i));
  }
  
  private final BigDecimal zai(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    int i = zaa(paramBufferedReader, this.zaqd);
    if (i == 0) {
      return null;
    }
    return new BigDecimal(new String(this.zaqd, 0, i));
  }
  
  private final char zaj(BufferedReader paramBufferedReader)
    throws FastParser.ParseException, IOException
  {
    if (paramBufferedReader.read(this.zaqb) == -1) {
      return '\000';
    }
    while (Character.isWhitespace(this.zaqb[0])) {
      if (paramBufferedReader.read(this.zaqb) == -1) {
        return '\000';
      }
    }
    return this.zaqb[0];
  }
  
  private final void zak(int paramInt)
    throws FastParser.ParseException
  {
    if (!this.zaqm.isEmpty())
    {
      int i = ((Integer)this.zaqm.pop()).intValue();
      if (i == paramInt) {
        return;
      }
      localStringBuilder = new StringBuilder(46);
      localStringBuilder.append("Expected state ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" but had ");
      localStringBuilder.append(i);
      throw new ParseException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder(46);
    localStringBuilder.append("Expected state ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" but had empty stack");
    throw new ParseException(localStringBuilder.toString());
  }
  
  /* Error */
  @KeepForSdk
  public void parse(java.io.InputStream paramInputStream, T paramT)
    throws FastParser.ParseException
  {
    // Byte code:
    //   0: new 150	java/io/BufferedReader
    //   3: dup
    //   4: new 518	java/io/InputStreamReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 521	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: sipush 1024
    //   15: invokespecial 524	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 131	com/google/android/gms/common/server/response/FastParser:zaqm	Ljava/util/Stack;
    //   23: iconst_0
    //   24: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokevirtual 195	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload_0
    //   32: aload_1
    //   33: invokespecial 144	com/google/android/gms/common/server/response/FastParser:zaj	(Ljava/io/BufferedReader;)C
    //   36: istore_3
    //   37: iload_3
    //   38: ifeq +193 -> 231
    //   41: iload_3
    //   42: bipush 91
    //   44: if_icmpeq +71 -> 115
    //   47: iload_3
    //   48: bipush 123
    //   50: if_icmpne +25 -> 75
    //   53: aload_0
    //   54: getfield 131	com/google/android/gms/common/server/response/FastParser:zaqm	Ljava/util/Stack;
    //   57: iconst_1
    //   58: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 195	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: aload_0
    //   66: aload_1
    //   67: aload_2
    //   68: invokespecial 235	com/google/android/gms/common/server/response/FastParser:zaa	(Ljava/io/BufferedReader;Lcom/google/android/gms/common/server/response/FastJsonResponse;)Z
    //   71: pop
    //   72: goto +124 -> 196
    //   75: new 7	com/google/android/gms/common/server/response/FastParser$ParseException
    //   78: astore 4
    //   80: new 119	java/lang/StringBuilder
    //   83: astore_2
    //   84: aload_2
    //   85: bipush 19
    //   87: invokespecial 122	java/lang/StringBuilder:<init>	(I)V
    //   90: aload_2
    //   91: ldc -56
    //   93: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_2
    //   98: iload_3
    //   99: invokevirtual 207	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 4
    //   105: aload_2
    //   106: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 175	com/google/android/gms/common/server/response/FastParser$ParseException:<init>	(Ljava/lang/String;)V
    //   112: aload 4
    //   114: athrow
    //   115: aload_0
    //   116: getfield 131	com/google/android/gms/common/server/response/FastParser:zaqm	Ljava/util/Stack;
    //   119: iconst_5
    //   120: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: invokevirtual 195	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: aload_2
    //   128: invokevirtual 266	com/google/android/gms/common/server/response/FastJsonResponse:getFieldMappings	()Ljava/util/Map;
    //   131: astore 4
    //   133: aload 4
    //   135: invokeinterface 527 1 0
    //   140: iconst_1
    //   141: if_icmpne +77 -> 218
    //   144: aload 4
    //   146: invokeinterface 531 1 0
    //   151: invokeinterface 537 1 0
    //   156: invokeinterface 542 1 0
    //   161: checkcast 544	java/util/Map$Entry
    //   164: invokeinterface 547 1 0
    //   169: checkcast 228	com/google/android/gms/common/server/response/FastJsonResponse$Field
    //   172: astore 4
    //   174: aload_0
    //   175: aload_1
    //   176: aload 4
    //   178: invokespecial 298	com/google/android/gms/common/server/response/FastParser:zaa	(Ljava/io/BufferedReader;Lcom/google/android/gms/common/server/response/FastJsonResponse$Field;)Ljava/util/ArrayList;
    //   181: astore 5
    //   183: aload_2
    //   184: aload 4
    //   186: aload 4
    //   188: getfield 292	com/google/android/gms/common/server/response/FastJsonResponse$Field:zapv	Ljava/lang/String;
    //   191: aload 5
    //   193: invokevirtual 296	com/google/android/gms/common/server/response/FastJsonResponse:addConcreteTypeArrayInternal	(Lcom/google/android/gms/common/server/response/FastJsonResponse$Field;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   196: aload_0
    //   197: iconst_0
    //   198: invokespecial 198	com/google/android/gms/common/server/response/FastParser:zak	(I)V
    //   201: aload_1
    //   202: invokevirtual 550	java/io/BufferedReader:close	()V
    //   205: return
    //   206: astore_1
    //   207: ldc_w 552
    //   210: ldc_w 554
    //   213: invokestatic 560	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   216: pop
    //   217: return
    //   218: new 7	com/google/android/gms/common/server/response/FastParser$ParseException
    //   221: astore_2
    //   222: aload_2
    //   223: ldc_w 562
    //   226: invokespecial 175	com/google/android/gms/common/server/response/FastParser$ParseException:<init>	(Ljava/lang/String;)V
    //   229: aload_2
    //   230: athrow
    //   231: new 7	com/google/android/gms/common/server/response/FastParser$ParseException
    //   234: astore_2
    //   235: aload_2
    //   236: ldc_w 564
    //   239: invokespecial 175	com/google/android/gms/common/server/response/FastParser$ParseException:<init>	(Ljava/lang/String;)V
    //   242: aload_2
    //   243: athrow
    //   244: astore_2
    //   245: goto +18 -> 263
    //   248: astore_2
    //   249: new 7	com/google/android/gms/common/server/response/FastParser$ParseException
    //   252: astore 4
    //   254: aload 4
    //   256: aload_2
    //   257: invokespecial 567	com/google/android/gms/common/server/response/FastParser$ParseException:<init>	(Ljava/lang/Throwable;)V
    //   260: aload 4
    //   262: athrow
    //   263: aload_1
    //   264: invokevirtual 550	java/io/BufferedReader:close	()V
    //   267: goto +14 -> 281
    //   270: astore_1
    //   271: ldc_w 552
    //   274: ldc_w 554
    //   277: invokestatic 560	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   280: pop
    //   281: aload_2
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	FastParser
    //   0	283	1	paramInputStream	java.io.InputStream
    //   0	283	2	paramT	T
    //   36	63	3	c	char
    //   78	183	4	localObject	Object
    //   181	11	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   201	205	206	java/io/IOException
    //   19	37	244	finally
    //   53	72	244	finally
    //   75	115	244	finally
    //   115	196	244	finally
    //   196	201	244	finally
    //   218	231	244	finally
    //   231	244	244	finally
    //   249	263	244	finally
    //   19	37	248	java/io/IOException
    //   53	72	248	java/io/IOException
    //   75	115	248	java/io/IOException
    //   115	196	248	java/io/IOException
    //   196	201	248	java/io/IOException
    //   218	231	248	java/io/IOException
    //   231	244	248	java/io/IOException
    //   263	267	270	java/io/IOException
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static class ParseException
    extends Exception
  {
    public ParseException(String paramString)
    {
      super();
    }
    
    public ParseException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public ParseException(Throwable paramThrowable)
    {
      super();
    }
  }
  
  private static abstract interface zaa<O>
  {
    public abstract O zah(FastParser paramFastParser, BufferedReader paramBufferedReader)
      throws FastParser.ParseException, IOException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\server\response\FastParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */