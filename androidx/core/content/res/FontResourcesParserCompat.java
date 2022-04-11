package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R.styleable;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FontResourcesParserCompat
{
  private static final int DEFAULT_TIMEOUT_MILLIS = 500;
  public static final int FETCH_STRATEGY_ASYNC = 1;
  public static final int FETCH_STRATEGY_BLOCKING = 0;
  public static final int INFINITE_TIMEOUT_VALUE = -1;
  private static final int ITALIC = 1;
  private static final int NORMAL_WEIGHT = 400;
  
  private static int getType(TypedArray paramTypedArray, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramTypedArray.getType(paramInt);
    }
    TypedValue localTypedValue = new TypedValue();
    paramTypedArray.getValue(paramInt, localTypedValue);
    return localTypedValue.type;
  }
  
  @Nullable
  public static FamilyResourceEntry parse(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return readFamilies(paramXmlPullParser, paramResources);
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  public static List<List<byte[]>> readCerts(Resources paramResources, @ArrayRes int paramInt)
  {
    if (paramInt == 0) {
      return Collections.emptyList();
    }
    TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
    try
    {
      if (localTypedArray.length() == 0)
      {
        paramResources = Collections.emptyList();
        return paramResources;
      }
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      if (getType(localTypedArray, 0) == 1) {
        for (paramInt = 0; paramInt < localTypedArray.length(); paramInt++)
        {
          int i = localTypedArray.getResourceId(paramInt, 0);
          if (i != 0) {
            localArrayList.add(toByteArrayList(paramResources.getStringArray(i)));
          }
        }
      }
      localArrayList.add(toByteArrayList(paramResources.getStringArray(paramInt)));
      return localArrayList;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  @Nullable
  private static FamilyResourceEntry readFamilies(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family")) {
      return readFamily(paramXmlPullParser, paramResources);
    }
    skip(paramXmlPullParser);
    return null;
  }
  
  @Nullable
  private static FamilyResourceEntry readFamily(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamily);
    String str1 = localTypedArray.getString(R.styleable.FontFamily_fontProviderAuthority);
    Object localObject = localTypedArray.getString(R.styleable.FontFamily_fontProviderPackage);
    String str2 = localTypedArray.getString(R.styleable.FontFamily_fontProviderQuery);
    int i = localTypedArray.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
    int j = localTypedArray.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
    int k = localTypedArray.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
    localTypedArray.recycle();
    if ((str1 != null) && (localObject != null) && (str2 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        skip(paramXmlPullParser);
      }
      return new ProviderResourceEntry(new FontRequest(str1, (String)localObject, str2, readCerts(paramResources, i)), j, k);
    }
    localObject = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          ((List)localObject).add(readFont(paramXmlPullParser, paramResources));
        } else {
          skip(paramXmlPullParser);
        }
      }
    }
    if (((List)localObject).isEmpty()) {
      return null;
    }
    return new FontFamilyFilesResourceEntry((FontFileResourceEntry[])((List)localObject).toArray(new FontFileResourceEntry[((List)localObject).size()]));
  }
  
  private static FontFileResourceEntry readFont(XmlPullParser paramXmlPullParser, Resources paramResources)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamilyFont);
    int i = R.styleable.FontFamilyFont_fontWeight;
    if (!localTypedArray.hasValue(i)) {
      i = R.styleable.FontFamilyFont_android_fontWeight;
    }
    int j = localTypedArray.getInt(i, 400);
    i = R.styleable.FontFamilyFont_fontStyle;
    if (!localTypedArray.hasValue(i)) {
      i = R.styleable.FontFamilyFont_android_fontStyle;
    }
    boolean bool;
    if (1 == localTypedArray.getInt(i, 0)) {
      bool = true;
    } else {
      bool = false;
    }
    i = R.styleable.FontFamilyFont_ttcIndex;
    if (!localTypedArray.hasValue(i)) {
      i = R.styleable.FontFamilyFont_android_ttcIndex;
    }
    int k = R.styleable.FontFamilyFont_fontVariationSettings;
    if (!localTypedArray.hasValue(k)) {
      k = R.styleable.FontFamilyFont_android_fontVariationSettings;
    }
    paramResources = localTypedArray.getString(k);
    k = localTypedArray.getInt(i, 0);
    i = R.styleable.FontFamilyFont_font;
    if (!localTypedArray.hasValue(i)) {
      i = R.styleable.FontFamilyFont_android_font;
    }
    int m = localTypedArray.getResourceId(i, 0);
    String str = localTypedArray.getString(i);
    localTypedArray.recycle();
    while (paramXmlPullParser.next() != 3) {
      skip(paramXmlPullParser);
    }
    return new FontFileResourceEntry(str, j, bool, paramResources, k, m);
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = 1;
    while (i > 0)
    {
      int j = paramXmlPullParser.next();
      if (j != 2)
      {
        if (j == 3) {
          i--;
        }
      }
      else {
        i++;
      }
    }
  }
  
  private static List<byte[]> toByteArrayList(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(Base64.decode(paramArrayOfString[j], 0));
    }
    return localArrayList;
  }
  
  public static abstract interface FamilyResourceEntry {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FetchStrategy {}
  
  public static final class FontFamilyFilesResourceEntry
    implements FontResourcesParserCompat.FamilyResourceEntry
  {
    @NonNull
    private final FontResourcesParserCompat.FontFileResourceEntry[] mEntries;
    
    public FontFamilyFilesResourceEntry(@NonNull FontResourcesParserCompat.FontFileResourceEntry[] paramArrayOfFontFileResourceEntry)
    {
      this.mEntries = paramArrayOfFontFileResourceEntry;
    }
    
    @NonNull
    public FontResourcesParserCompat.FontFileResourceEntry[] getEntries()
    {
      return this.mEntries;
    }
  }
  
  public static final class FontFileResourceEntry
  {
    @NonNull
    private final String mFileName;
    private boolean mItalic;
    private int mResourceId;
    private int mTtcIndex;
    private String mVariationSettings;
    private int mWeight;
    
    public FontFileResourceEntry(@NonNull String paramString1, int paramInt1, boolean paramBoolean, @Nullable String paramString2, int paramInt2, int paramInt3)
    {
      this.mFileName = paramString1;
      this.mWeight = paramInt1;
      this.mItalic = paramBoolean;
      this.mVariationSettings = paramString2;
      this.mTtcIndex = paramInt2;
      this.mResourceId = paramInt3;
    }
    
    @NonNull
    public String getFileName()
    {
      return this.mFileName;
    }
    
    public int getResourceId()
    {
      return this.mResourceId;
    }
    
    public int getTtcIndex()
    {
      return this.mTtcIndex;
    }
    
    @Nullable
    public String getVariationSettings()
    {
      return this.mVariationSettings;
    }
    
    public int getWeight()
    {
      return this.mWeight;
    }
    
    public boolean isItalic()
    {
      return this.mItalic;
    }
  }
  
  public static final class ProviderResourceEntry
    implements FontResourcesParserCompat.FamilyResourceEntry
  {
    @NonNull
    private final FontRequest mRequest;
    private final int mStrategy;
    private final int mTimeoutMs;
    
    public ProviderResourceEntry(@NonNull FontRequest paramFontRequest, int paramInt1, int paramInt2)
    {
      this.mRequest = paramFontRequest;
      this.mStrategy = paramInt1;
      this.mTimeoutMs = paramInt2;
    }
    
    public int getFetchStrategy()
    {
      return this.mStrategy;
    }
    
    @NonNull
    public FontRequest getRequest()
    {
      return this.mRequest;
    }
    
    public int getTimeout()
    {
      return this.mTimeoutMs;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\res\FontResourcesParserCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */