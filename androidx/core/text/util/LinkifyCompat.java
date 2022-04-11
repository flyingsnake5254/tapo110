package androidx.core.text.util;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat
{
  private static final Comparator<LinkSpec> COMPARATOR = new Comparator()
  {
    public int compare(LinkifyCompat.LinkSpec paramAnonymousLinkSpec1, LinkifyCompat.LinkSpec paramAnonymousLinkSpec2)
    {
      int i = paramAnonymousLinkSpec1.start;
      int j = paramAnonymousLinkSpec2.start;
      if (i < j) {
        return -1;
      }
      if (i > j) {
        return 1;
      }
      i = paramAnonymousLinkSpec1.end;
      j = paramAnonymousLinkSpec2.end;
      if (i < j) {
        return 1;
      }
      if (i > j) {
        return -1;
      }
      return 0;
    }
  };
  private static final String[] EMPTY_STRING = new String[0];
  
  private static void addLinkMovementMethod(@NonNull TextView paramTextView)
  {
    if ((!(paramTextView.getMovementMethod() instanceof LinkMovementMethod)) && (paramTextView.getLinksClickable())) {
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public static void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString)
  {
    if (shouldAddLinksFallbackToFramework())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, null, null);
  }
  
  public static void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  @SuppressLint({"NewApi"})
  public static void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
      return;
    }
    SpannableString localSpannableString = SpannableString.valueOf(paramTextView.getText());
    if (addLinks(localSpannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter))
    {
      paramTextView.setText(localSpannableString);
      addLinkMovementMethod(paramTextView);
    }
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, int paramInt)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramSpannable, paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    Object localObject1 = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    for (int i = localObject1.length - 1; i >= 0; i--) {
      paramSpannable.removeSpan(localObject1[i]);
    }
    if ((paramInt & 0x4) != 0) {
      Linkify.addLinks(paramSpannable, 4);
    }
    localObject1 = new ArrayList();
    Object localObject2;
    if ((paramInt & 0x1) != 0)
    {
      localObject2 = PatternsCompat.AUTOLINK_WEB_URL;
      Linkify.MatchFilter localMatchFilter = Linkify.sUrlMatchFilter;
      gatherLinks((ArrayList)localObject1, paramSpannable, (Pattern)localObject2, new String[] { "http://", "https://", "rtsp://" }, localMatchFilter, null);
    }
    if ((paramInt & 0x2) != 0) {
      gatherLinks((ArrayList)localObject1, paramSpannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[] { "mailto:" }, null, null);
    }
    if ((paramInt & 0x8) != 0) {
      gatherMapLinks((ArrayList)localObject1, paramSpannable);
    }
    pruneOverlaps((ArrayList)localObject1, paramSpannable);
    if (((ArrayList)localObject1).size() == 0) {
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LinkSpec)((Iterator)localObject1).next();
      if (((LinkSpec)localObject2).frameworkAddedSpan == null) {
        applyLink(((LinkSpec)localObject2).url, ((LinkSpec)localObject2).start, ((LinkSpec)localObject2).end, paramSpannable);
      }
    }
    return true;
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString);
    }
    return addLinks(paramSpannable, paramPattern, paramString, null, null, null);
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
    }
    return addLinks(paramSpannable, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  @SuppressLint({"NewApi"})
  public static boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramArrayOfString != null)
    {
      paramString = paramArrayOfString;
      if (paramArrayOfString.length >= 1) {}
    }
    else
    {
      paramString = EMPTY_STRING;
    }
    String[] arrayOfString = new String[paramString.length + 1];
    arrayOfString[0] = str.toLowerCase(Locale.ROOT);
    int i = 0;
    while (i < paramString.length)
    {
      paramArrayOfString = paramString[i];
      i++;
      if (paramArrayOfString == null) {
        paramArrayOfString = "";
      } else {
        paramArrayOfString = paramArrayOfString.toLowerCase(Locale.ROOT);
      }
      arrayOfString[i] = paramArrayOfString;
    }
    paramPattern = paramPattern.matcher(paramSpannable);
    boolean bool1 = false;
    while (paramPattern.find())
    {
      int j = paramPattern.start();
      i = paramPattern.end();
      boolean bool2;
      if (paramMatchFilter != null) {
        bool2 = paramMatchFilter.acceptMatch(paramSpannable, j, i);
      } else {
        bool2 = true;
      }
      if (bool2)
      {
        applyLink(makeUrl(paramPattern.group(0), arrayOfString, paramPattern, paramTransformFilter), j, i, paramSpannable);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean addLinks(@NonNull TextView paramTextView, int paramInt)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramTextView, paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    Object localObject = paramTextView.getText();
    if ((localObject instanceof Spannable))
    {
      if (addLinks((Spannable)localObject, paramInt))
      {
        addLinkMovementMethod(paramTextView);
        return true;
      }
      return false;
    }
    localObject = SpannableString.valueOf((CharSequence)localObject);
    if (addLinks((Spannable)localObject, paramInt))
    {
      addLinkMovementMethod(paramTextView);
      paramTextView.setText((CharSequence)localObject);
      return true;
    }
    return false;
  }
  
  private static void applyLink(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable)
  {
    paramSpannable.setSpan(new URLSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  private static String findAddress(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return WebView.findAddress(paramString);
    }
    return FindAddress.findAddress(paramString);
  }
  
  private static void gatherLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    Matcher localMatcher = paramPattern.matcher(paramSpannable);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((paramMatchFilter == null) || (paramMatchFilter.acceptMatch(paramSpannable, i, j)))
      {
        paramPattern = new LinkSpec();
        paramPattern.url = makeUrl(localMatcher.group(0), paramArrayOfString, localMatcher, paramTransformFilter);
        paramPattern.start = i;
        paramPattern.end = j;
        paramArrayList.add(paramPattern);
      }
    }
  }
  
  private static void gatherMapLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    paramSpannable = paramSpannable.toString();
    int i = 0;
    for (;;)
    {
      try
      {
        str = findAddress(paramSpannable);
        if (str != null)
        {
          int j = paramSpannable.indexOf(str);
          if (j >= 0)
          {
            localLinkSpec = new androidx/core/text/util/LinkifyCompat$LinkSpec;
            localLinkSpec.<init>();
            int k = str.length() + j;
            localLinkSpec.start = (j + i);
            i += k;
            localLinkSpec.end = i;
            paramSpannable = paramSpannable.substring(k);
          }
        }
      }
      catch (UnsupportedOperationException paramArrayList)
      {
        String str;
        LinkSpec localLinkSpec;
        StringBuilder localStringBuilder;
        continue;
      }
      try
      {
        str = URLEncoder.encode(str, "UTF-8");
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("geo:0,0?q=");
        localStringBuilder.append(str);
        localLinkSpec.url = localStringBuilder.toString();
        paramArrayList.add(localLinkSpec);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      return;
    }
  }
  
  private static String makeUrl(@NonNull String paramString, @NonNull String[] paramArrayOfString, Matcher paramMatcher, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    String str = paramString;
    if (paramTransformFilter != null) {
      str = paramTransformFilter.transformUrl(paramMatcher, paramString);
    }
    for (int i = 0;; i++)
    {
      j = paramArrayOfString.length;
      int k = 1;
      if (i >= j) {
        break;
      }
      if (str.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
      {
        j = k;
        paramString = str;
        if (str.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
          break label143;
        }
        paramString = new StringBuilder();
        paramString.append(paramArrayOfString[i]);
        paramString.append(str.substring(paramArrayOfString[i].length()));
        paramString = paramString.toString();
        j = k;
        break label143;
      }
    }
    int j = 0;
    paramString = str;
    label143:
    paramMatcher = paramString;
    if (j == 0)
    {
      paramMatcher = paramString;
      if (paramArrayOfString.length > 0)
      {
        paramMatcher = new StringBuilder();
        paramMatcher.append(paramArrayOfString[0]);
        paramMatcher.append(paramString);
        paramMatcher = paramMatcher.toString();
      }
    }
    return paramMatcher;
  }
  
  private static void pruneOverlaps(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    int i = paramSpannable.length();
    int j = 0;
    Object localObject1 = (URLSpan[])paramSpannable.getSpans(0, i, URLSpan.class);
    Object localObject2;
    for (i = 0; i < localObject1.length; i++)
    {
      localObject2 = new LinkSpec();
      ((LinkSpec)localObject2).frameworkAddedSpan = localObject1[i];
      ((LinkSpec)localObject2).start = paramSpannable.getSpanStart(localObject1[i]);
      ((LinkSpec)localObject2).end = paramSpannable.getSpanEnd(localObject1[i]);
      paramArrayList.add(localObject2);
    }
    Collections.sort(paramArrayList, COMPARATOR);
    int k = paramArrayList.size();
    i = j;
    while (i < k - 1)
    {
      localObject1 = (LinkSpec)paramArrayList.get(i);
      int m = i + 1;
      localObject2 = (LinkSpec)paramArrayList.get(m);
      int n = ((LinkSpec)localObject1).start;
      j = ((LinkSpec)localObject2).start;
      if (n <= j)
      {
        int i1 = ((LinkSpec)localObject1).end;
        if (i1 > j)
        {
          int i2 = ((LinkSpec)localObject2).end;
          if (i2 <= i1) {}
          while (i1 - n > i2 - j)
          {
            j = m;
            break;
          }
          if (i1 - n < i2 - j) {
            j = i;
          } else {
            j = -1;
          }
          if (j != -1)
          {
            localObject2 = ((LinkSpec)paramArrayList.get(j)).frameworkAddedSpan;
            if (localObject2 != null) {
              paramSpannable.removeSpan(localObject2);
            }
            paramArrayList.remove(j);
            k--;
            continue;
          }
        }
      }
      i = m;
    }
  }
  
  private static boolean shouldAddLinksFallbackToFramework()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 28) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static class LinkSpec
  {
    int end;
    URLSpan frameworkAddedSpan;
    int start;
    String url;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static @interface LinkifyMask {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\text\util\LinkifyCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */