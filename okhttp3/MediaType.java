package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class MediaType
{
  private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private static final String QUOTED = "\"([^\"]*)\"";
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  @Nullable
  private final String charset;
  private final String mediaType;
  private final String subtype;
  private final String type;
  
  private MediaType(String paramString1, String paramString2, String paramString3, @Nullable String paramString4)
  {
    this.mediaType = paramString1;
    this.type = paramString2;
    this.subtype = paramString3;
    this.charset = paramString4;
  }
  
  public static MediaType get(String paramString)
  {
    Object localObject1 = TYPE_SUBTYPE.matcher(paramString);
    if (((Matcher)localObject1).lookingAt())
    {
      Object localObject2 = ((Matcher)localObject1).group(1);
      Object localObject3 = Locale.US;
      String str1 = ((String)localObject2).toLowerCase((Locale)localObject3);
      String str2 = ((Matcher)localObject1).group(2).toLowerCase((Locale)localObject3);
      localObject3 = null;
      Matcher localMatcher = PARAMETER.matcher(paramString);
      int i = ((Matcher)localObject1).end();
      while (i < paramString.length())
      {
        localMatcher.region(i, paramString.length());
        if (localMatcher.lookingAt())
        {
          localObject2 = localMatcher.group(1);
          localObject1 = localObject3;
          if (localObject2 != null) {
            if (!((String)localObject2).equalsIgnoreCase("charset"))
            {
              localObject1 = localObject3;
            }
            else
            {
              localObject2 = localMatcher.group(2);
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                if (((String)localObject2).startsWith("'"))
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).endsWith("'"))
                  {
                    localObject1 = localObject2;
                    if (((String)localObject2).length() > 2) {
                      localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
                    }
                  }
                }
              }
              else
              {
                localObject1 = localMatcher.group(3);
              }
              if ((localObject3 != null) && (!((String)localObject1).equalsIgnoreCase((String)localObject3)))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Multiple charsets defined: \"");
                ((StringBuilder)localObject2).append((String)localObject3);
                ((StringBuilder)localObject2).append("\" and: \"");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append("\" for: \"");
                ((StringBuilder)localObject2).append(paramString);
                ((StringBuilder)localObject2).append('"');
                throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
              }
            }
          }
          i = localMatcher.end();
          localObject3 = localObject1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Parameter is not formatted correctly: \"");
          ((StringBuilder)localObject1).append(paramString.substring(i));
          ((StringBuilder)localObject1).append("\" for: \"");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append('"');
          throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        }
      }
      return new MediaType(paramString, str1, str2, (String)localObject3);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("No subtype found for: \"");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append('"');
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  @Nullable
  public static MediaType parse(String paramString)
  {
    try
    {
      paramString = get(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  @Nullable
  public Charset charset()
  {
    return charset(null);
  }
  
  @Nullable
  public Charset charset(@Nullable Charset paramCharset)
  {
    try
    {
      String str = this.charset;
      localCharset1 = paramCharset;
      if (str != null) {
        localCharset1 = Charset.forName(str);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Charset localCharset1;
        Charset localCharset2 = paramCharset;
      }
    }
    return localCharset1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof MediaType)) && (((MediaType)paramObject).mediaType.equals(this.mediaType))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.mediaType.hashCode();
  }
  
  public String subtype()
  {
    return this.subtype;
  }
  
  public String toString()
  {
    return this.mediaType;
  }
  
  public String type()
  {
    return this.type;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */