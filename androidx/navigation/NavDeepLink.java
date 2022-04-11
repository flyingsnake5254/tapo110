package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NavDeepLink
{
  private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
  private final String mAction;
  private final ArrayList<String> mArguments = new ArrayList();
  private boolean mExactDeepLink = false;
  private boolean mIsParameterizedQuery = false;
  private final String mMimeType;
  private Pattern mMimeTypePattern = null;
  private final Map<String, ParamQuery> mParamArgMap = new HashMap();
  private Pattern mPattern = null;
  private final String mUri;
  
  NavDeepLink(@NonNull String paramString)
  {
    this(paramString, null, null);
  }
  
  NavDeepLink(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    this.mUri = paramString1;
    this.mAction = paramString2;
    this.mMimeType = paramString3;
    if (paramString1 != null)
    {
      Uri localUri = Uri.parse(paramString1);
      boolean bool;
      if (localUri.getQuery() != null) {
        bool = true;
      } else {
        bool = false;
      }
      this.mIsParameterizedQuery = bool;
      StringBuilder localStringBuilder1 = new StringBuilder("^");
      if (!SCHEME_PATTERN.matcher(paramString1).find()) {
        localStringBuilder1.append("http[s]?://");
      }
      paramString2 = Pattern.compile("\\{(.+?)\\}");
      if (this.mIsParameterizedQuery)
      {
        Object localObject = Pattern.compile("(\\?)").matcher(paramString1);
        if (((Matcher)localObject).find()) {
          buildPathRegex(paramString1.substring(0, ((Matcher)localObject).start()), localStringBuilder1, paramString2);
        }
        this.mExactDeepLink = false;
        localObject = localUri.getQueryParameterNames().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          StringBuilder localStringBuilder2 = new StringBuilder();
          String str2 = localUri.getQueryParameter(str1);
          Matcher localMatcher = paramString2.matcher(str2);
          paramString1 = new ParamQuery();
          for (int i = 0; localMatcher.find(); i = localMatcher.end())
          {
            paramString1.addArgumentName(localMatcher.group(1));
            localStringBuilder2.append(Pattern.quote(str2.substring(i, localMatcher.start())));
            localStringBuilder2.append("(.+?)?");
          }
          if (i < str2.length()) {
            localStringBuilder2.append(Pattern.quote(str2.substring(i)));
          }
          paramString1.setParamRegex(localStringBuilder2.toString().replace(".*", "\\E.*\\Q"));
          this.mParamArgMap.put(str1, paramString1);
        }
      }
      this.mExactDeepLink = buildPathRegex(paramString1, localStringBuilder1, paramString2);
      this.mPattern = Pattern.compile(localStringBuilder1.toString().replace(".*", "\\E.*\\Q"));
    }
    if (paramString3 != null) {
      if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(paramString3).matches())
      {
        paramString1 = new MimeType(paramString3);
        paramString2 = new StringBuilder();
        paramString2.append("^(");
        paramString2.append(paramString1.mType);
        paramString2.append("|[*]+)/(");
        paramString2.append(paramString1.mSubType);
        paramString2.append("|[*]+)$");
        this.mMimeTypePattern = Pattern.compile(paramString2.toString().replace("*|[*]", "[\\s\\S]"));
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("The given mimeType ");
        paramString1.append(paramString3);
        paramString1.append(" does not match to required \"type/subtype\" format");
        throw new IllegalArgumentException(paramString1.toString());
      }
    }
  }
  
  private boolean buildPathRegex(@NonNull String paramString, StringBuilder paramStringBuilder, Pattern paramPattern)
  {
    Matcher localMatcher = paramPattern.matcher(paramString);
    boolean bool = paramString.contains(".*") ^ true;
    int i = 0;
    while (localMatcher.find())
    {
      paramPattern = localMatcher.group(1);
      this.mArguments.add(paramPattern);
      paramStringBuilder.append(Pattern.quote(paramString.substring(i, localMatcher.start())));
      paramStringBuilder.append("(.+?)");
      i = localMatcher.end();
      bool = false;
    }
    if (i < paramString.length()) {
      paramStringBuilder.append(Pattern.quote(paramString.substring(i)));
    }
    paramStringBuilder.append("($|(\\?(.)*))");
    return bool;
  }
  
  private boolean matchAction(String paramString)
  {
    boolean bool1 = true;
    int i;
    if (paramString == null) {
      i = 1;
    } else {
      i = 0;
    }
    String str = this.mAction;
    int j;
    if (str != null) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == j) {
      return false;
    }
    boolean bool2 = bool1;
    if (paramString != null) {
      if (str.equals(paramString)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  private boolean matchMimeType(String paramString)
  {
    boolean bool1 = true;
    int i;
    if (paramString == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.mMimeType != null) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == j) {
      return false;
    }
    boolean bool2 = bool1;
    if (paramString != null) {
      if (this.mMimeTypePattern.matcher(paramString).matches()) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  private boolean matchUri(Uri paramUri)
  {
    boolean bool1 = true;
    int i;
    if (paramUri == null) {
      i = 1;
    } else {
      i = 0;
    }
    Pattern localPattern = this.mPattern;
    int j;
    if (localPattern != null) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == j) {
      return false;
    }
    boolean bool2 = bool1;
    if (paramUri != null) {
      if (localPattern.matcher(paramUri.toString()).matches()) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  private boolean parseArgument(Bundle paramBundle, String paramString1, String paramString2, NavArgument paramNavArgument)
  {
    if (paramNavArgument != null)
    {
      paramNavArgument = paramNavArgument.getType();
      try
      {
        paramNavArgument.parseAndPut(paramBundle, paramString1, paramString2);
      }
      catch (IllegalArgumentException paramBundle)
      {
        return true;
      }
    }
    else
    {
      paramBundle.putString(paramString1, paramString2);
    }
    return false;
  }
  
  @Nullable
  public String getAction()
  {
    return this.mAction;
  }
  
  @Nullable
  Bundle getMatchingArguments(@NonNull Uri paramUri, @NonNull Map<String, NavArgument> paramMap)
  {
    Object localObject1 = this.mPattern.matcher(paramUri.toString());
    if (!((Matcher)localObject1).matches()) {
      return null;
    }
    Bundle localBundle = new Bundle();
    int i = this.mArguments.size();
    int j = 0;
    Object localObject2;
    while (j < i)
    {
      localObject2 = (String)this.mArguments.get(j);
      int k = j + 1;
      j = k;
      if (parseArgument(localBundle, (String)localObject2, Uri.decode(((Matcher)localObject1).group(k)), (NavArgument)paramMap.get(localObject2))) {
        return null;
      }
    }
    if (this.mIsParameterizedQuery)
    {
      Iterator localIterator = this.mParamArgMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        ParamQuery localParamQuery = (ParamQuery)this.mParamArgMap.get(localObject2);
        localObject2 = paramUri.getQueryParameter((String)localObject2);
        if (localObject2 != null)
        {
          localObject1 = Pattern.compile(localParamQuery.getParamRegex()).matcher((CharSequence)localObject2);
          localObject2 = localObject1;
          if (!((Matcher)localObject1).matches()) {
            return null;
          }
        }
        else
        {
          localObject2 = null;
        }
        for (j = 0; j < localParamQuery.size(); j++)
        {
          if (localObject2 != null) {
            localObject1 = Uri.decode(((Matcher)localObject2).group(j + 1));
          } else {
            localObject1 = null;
          }
          String str = localParamQuery.getArgumentName(j);
          NavArgument localNavArgument = (NavArgument)paramMap.get(str);
          if ((localObject1 != null) && (!((String)localObject1).replaceAll("[{}]", "").equals(str)) && (parseArgument(localBundle, str, (String)localObject1, localNavArgument))) {
            return null;
          }
        }
      }
    }
    return localBundle;
  }
  
  @Nullable
  public String getMimeType()
  {
    return this.mMimeType;
  }
  
  int getMimeTypeMatchRating(@NonNull String paramString)
  {
    if ((this.mMimeType != null) && (this.mMimeTypePattern.matcher(paramString).matches())) {
      return new MimeType(this.mMimeType).compareTo(new MimeType(paramString));
    }
    return -1;
  }
  
  @Nullable
  public String getUriPattern()
  {
    return this.mUri;
  }
  
  boolean isExactDeepLink()
  {
    return this.mExactDeepLink;
  }
  
  boolean matches(@NonNull Uri paramUri)
  {
    return matches(new NavDeepLinkRequest(paramUri, null, null));
  }
  
  boolean matches(@NonNull NavDeepLinkRequest paramNavDeepLinkRequest)
  {
    if (!matchUri(paramNavDeepLinkRequest.getUri())) {
      return false;
    }
    if (!matchAction(paramNavDeepLinkRequest.getAction())) {
      return false;
    }
    return matchMimeType(paramNavDeepLinkRequest.getMimeType());
  }
  
  public static final class Builder
  {
    private String mAction;
    private String mMimeType;
    private String mUriPattern;
    
    @NonNull
    public static Builder fromAction(@NonNull String paramString)
    {
      if (!paramString.isEmpty())
      {
        Builder localBuilder = new Builder();
        localBuilder.setAction(paramString);
        return localBuilder;
      }
      throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
    }
    
    @NonNull
    public static Builder fromMimeType(@NonNull String paramString)
    {
      Builder localBuilder = new Builder();
      localBuilder.setMimeType(paramString);
      return localBuilder;
    }
    
    @NonNull
    public static Builder fromUriPattern(@NonNull String paramString)
    {
      Builder localBuilder = new Builder();
      localBuilder.setUriPattern(paramString);
      return localBuilder;
    }
    
    @NonNull
    public NavDeepLink build()
    {
      return new NavDeepLink(this.mUriPattern, this.mAction, this.mMimeType);
    }
    
    @NonNull
    public Builder setAction(@NonNull String paramString)
    {
      if (!paramString.isEmpty())
      {
        this.mAction = paramString;
        return this;
      }
      throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
    }
    
    @NonNull
    public Builder setMimeType(@NonNull String paramString)
    {
      this.mMimeType = paramString;
      return this;
    }
    
    @NonNull
    public Builder setUriPattern(@NonNull String paramString)
    {
      this.mUriPattern = paramString;
      return this;
    }
  }
  
  private static class MimeType
    implements Comparable<MimeType>
  {
    String mSubType;
    String mType;
    
    MimeType(@NonNull String paramString)
    {
      paramString = paramString.split("/", -1);
      this.mType = paramString[0];
      this.mSubType = paramString[1];
    }
    
    public int compareTo(@NonNull MimeType paramMimeType)
    {
      int i;
      if (this.mType.equals(paramMimeType.mType)) {
        i = 2;
      } else {
        i = 0;
      }
      int j = i;
      if (this.mSubType.equals(paramMimeType.mSubType)) {
        j = i + 1;
      }
      return j;
    }
  }
  
  private static class ParamQuery
  {
    private ArrayList<String> mArguments = new ArrayList();
    private String mParamRegex;
    
    void addArgumentName(String paramString)
    {
      this.mArguments.add(paramString);
    }
    
    String getArgumentName(int paramInt)
    {
      return (String)this.mArguments.get(paramInt);
    }
    
    String getParamRegex()
    {
      return this.mParamRegex;
    }
    
    void setParamRegex(String paramString)
    {
      this.mParamRegex = paramString;
    }
    
    public int size()
    {
      return this.mArguments.size();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavDeepLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */