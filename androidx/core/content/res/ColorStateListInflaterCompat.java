package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.R.attr;
import androidx.core.R.styleable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ColorStateListInflaterCompat
{
  @NonNull
  public static ColorStateList createFromXml(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return createFromXmlInner(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  @NonNull
  public static ColorStateList createFromXmlInner(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    String str = paramXmlPullParser.getName();
    if (str.equals("selector")) {
      return inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": invalid color state list tag ");
    paramResources.append(str);
    throw new XmlPullParserException(paramResources.toString());
  }
  
  @Nullable
  public static ColorStateList inflate(@NonNull Resources paramResources, @XmlRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    try
    {
      paramResources = createFromXml(paramResources, paramResources.getXml(paramInt), paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      Log.e("CSLCompat", "Failed to inflate ColorStateList.", paramResources);
    }
    return null;
  }
  
  private static ColorStateList inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth() + 1;
    int[][] arrayOfInt = new int[20][];
    int[] arrayOfInt1 = new int[20];
    int j = 0;
    for (;;)
    {
      int k = paramXmlPullParser.next();
      if (k == 1) {
        break;
      }
      int m = paramXmlPullParser.getDepth();
      if ((m < i) && (k == 3)) {
        break;
      }
      if ((k == 2) && (m <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        Object localObject = obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.ColorStateListItem);
        int n = ((TypedArray)localObject).getColor(R.styleable.ColorStateListItem_android_color, -65281);
        float f = 1.0F;
        k = R.styleable.ColorStateListItem_android_alpha;
        if (((TypedArray)localObject).hasValue(k))
        {
          f = ((TypedArray)localObject).getFloat(k, 1.0F);
        }
        else
        {
          k = R.styleable.ColorStateListItem_alpha;
          if (((TypedArray)localObject).hasValue(k)) {
            f = ((TypedArray)localObject).getFloat(k, 1.0F);
          }
        }
        ((TypedArray)localObject).recycle();
        int i1 = paramAttributeSet.getAttributeCount();
        localObject = new int[i1];
        k = 0;
        int i3;
        for (m = 0; k < i1; m = i3)
        {
          int i2 = paramAttributeSet.getAttributeNameResource(k);
          i3 = m;
          if (i2 != 16843173)
          {
            i3 = m;
            if (i2 != 16843551)
            {
              i3 = m;
              if (i2 != R.attr.alpha)
              {
                if (paramAttributeSet.getAttributeBooleanValue(k, false)) {
                  i3 = i2;
                } else {
                  i3 = -i2;
                }
                localObject[m] = i3;
                i3 = m + 1;
              }
            }
          }
          k++;
        }
        localObject = StateSet.trimStateSet((int[])localObject, m);
        arrayOfInt1 = GrowingArrayUtils.append(arrayOfInt1, j, modulateColorAlpha(n, f));
        arrayOfInt = (int[][])GrowingArrayUtils.append(arrayOfInt, j, localObject);
        j++;
      }
    }
    paramResources = new int[j];
    paramXmlPullParser = new int[j][];
    System.arraycopy(arrayOfInt1, 0, paramResources, 0, j);
    System.arraycopy(arrayOfInt, 0, paramXmlPullParser, 0, j);
    return new ColorStateList(paramXmlPullParser, paramResources);
  }
  
  @ColorInt
  private static int modulateColorAlpha(@ColorInt int paramInt, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return paramInt & 0xFFFFFF | Math.round(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  private static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      paramResources = paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    } else {
      paramResources = paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
    }
    return paramResources;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\res\ColorStateListInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */