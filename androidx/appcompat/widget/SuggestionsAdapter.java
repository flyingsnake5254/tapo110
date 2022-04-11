package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
class SuggestionsAdapter
  extends ResourceCursorAdapter
  implements View.OnClickListener
{
  private static final boolean DBG = false;
  static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = "SuggestionsAdapter";
  private static final int QUERY_LIMIT = 50;
  static final int REFINE_ALL = 2;
  static final int REFINE_BY_ENTRY = 1;
  static final int REFINE_NONE = 0;
  private boolean mClosed = false;
  private final int mCommitIconResId;
  private int mFlagsCol = -1;
  private int mIconName1Col = -1;
  private int mIconName2Col = -1;
  private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
  private final Context mProviderContext;
  private int mQueryRefinement = 1;
  private final SearchView mSearchView;
  private final SearchableInfo mSearchable;
  private int mText1Col = -1;
  private int mText2Col = -1;
  private int mText2UrlCol = -1;
  private ColorStateList mUrlColor;
  
  public SuggestionsAdapter(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap<String, Drawable.ConstantState> paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    this.mSearchView = paramSearchView;
    this.mSearchable = paramSearchableInfo;
    this.mCommitIconResId = paramSearchView.getSuggestionCommitIconResId();
    this.mProviderContext = paramContext;
    this.mOutsideDrawablesCache = paramWeakHashMap;
  }
  
  private Drawable checkIconCache(String paramString)
  {
    paramString = (Drawable.ConstantState)this.mOutsideDrawablesCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.newDrawable();
  }
  
  private CharSequence formatUrl(CharSequence paramCharSequence)
  {
    if (this.mUrlColor == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, (TypedValue)localObject, true);
      this.mUrlColor = this.mContext.getResources().getColorStateList(((TypedValue)localObject).resourceId);
    }
    Object localObject = new SpannableString(paramCharSequence);
    ((SpannableString)localObject).setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, paramCharSequence.length(), 33);
    return (CharSequence)localObject;
  }
  
  private Drawable getActivityIcon(ComponentName paramComponentName)
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    try
    {
      Object localObject = localPackageManager.getActivityInfo(paramComponentName, 128);
      int i = ((ActivityInfo)localObject).getIconResource();
      if (i == 0) {
        return null;
      }
      localObject = localPackageManager.getDrawable(paramComponentName.getPackageName(), i, ((ActivityInfo)localObject).applicationInfo);
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid icon resource ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" for ");
        ((StringBuilder)localObject).append(paramComponentName.flattenToShortString());
        Log.w("SuggestionsAdapter", ((StringBuilder)localObject).toString());
        return null;
      }
      return (Drawable)localObject;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      Log.w("SuggestionsAdapter", paramComponentName.toString());
    }
    return null;
  }
  
  private Drawable getActivityIconWithCache(ComponentName paramComponentName)
  {
    String str = paramComponentName.flattenToShortString();
    boolean bool = this.mOutsideDrawablesCache.containsKey(str);
    Object localObject = null;
    Drawable localDrawable = null;
    if (bool)
    {
      paramComponentName = (Drawable.ConstantState)this.mOutsideDrawablesCache.get(str);
      if (paramComponentName == null) {
        paramComponentName = localDrawable;
      } else {
        paramComponentName = paramComponentName.newDrawable(this.mProviderContext.getResources());
      }
      return paramComponentName;
    }
    localDrawable = getActivityIcon(paramComponentName);
    if (localDrawable == null) {
      paramComponentName = (ComponentName)localObject;
    } else {
      paramComponentName = localDrawable.getConstantState();
    }
    this.mOutsideDrawablesCache.put(str, paramComponentName);
    return localDrawable;
  }
  
  public static String getColumnString(Cursor paramCursor, String paramString)
  {
    return getStringOrNull(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private Drawable getDefaultIcon1()
  {
    Drawable localDrawable = getActivityIconWithCache(this.mSearchable.getSearchActivity());
    if (localDrawable != null) {
      return localDrawable;
    }
    return this.mContext.getPackageManager().getDefaultActivityIcon();
  }
  
  private Drawable getDrawable(Uri paramUri)
  {
    try
    {
      boolean bool = "android.resource".equals(paramUri.getScheme());
      Object localObject1;
      if (bool) {
        try
        {
          Drawable localDrawable = getDrawableFromResourceUri(paramUri);
          return localDrawable;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          localObject3 = new java/io/FileNotFoundException;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((StringBuilder)localObject1).append("Resource does not exist: ");
          ((StringBuilder)localObject1).append(paramUri);
          ((FileNotFoundException)localObject3).<init>(((StringBuilder)localObject1).toString());
          throw ((Throwable)localObject3);
        }
      }
      Object localObject3 = this.mProviderContext.getContentResolver().openInputStream(paramUri);
      if (localObject3 != null) {
        try
        {
          localObject1 = Drawable.createFromStream((InputStream)localObject3, null);
          try
          {
            ((InputStream)localObject3).close();
          }
          catch (IOException localIOException1)
          {
            localStringBuilder2 = new java/lang/StringBuilder;
            localStringBuilder2.<init>();
            localStringBuilder2.append("Error closing icon stream for ");
            localStringBuilder2.append(paramUri);
            Log.e("SuggestionsAdapter", localStringBuilder2.toString(), localIOException1);
          }
          return (Drawable)localObject1;
        }
        finally
        {
          try
          {
            localIOException1.close();
          }
          catch (IOException localIOException2)
          {
            StringBuilder localStringBuilder2 = new java/lang/StringBuilder;
            localStringBuilder2.<init>();
            localStringBuilder2.append("Error closing icon stream for ");
            localStringBuilder2.append(paramUri);
            Log.e("SuggestionsAdapter", localStringBuilder2.toString(), localIOException2);
          }
        }
      }
      localObject4 = new java/io/FileNotFoundException;
      StringBuilder localStringBuilder1 = new java/lang/StringBuilder;
      localStringBuilder1.<init>();
      localStringBuilder1.append("Failed to open ");
      localStringBuilder1.append(paramUri);
      ((FileNotFoundException)localObject4).<init>(localStringBuilder1.toString());
      throw ((Throwable)localObject4);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("Icon not found: ");
      ((StringBuilder)localObject4).append(paramUri);
      ((StringBuilder)localObject4).append(", ");
      ((StringBuilder)localObject4).append(localFileNotFoundException.getMessage());
      Log.w("SuggestionsAdapter", ((StringBuilder)localObject4).toString());
    }
    return null;
  }
  
  private Drawable getDrawableFromResourceValue(String paramString)
  {
    Drawable localDrawable1 = null;
    Object localObject = localDrawable1;
    Drawable localDrawable2;
    if (paramString != null)
    {
      localObject = localDrawable1;
      if (!paramString.isEmpty()) {
        if ("0".equals(paramString)) {
          localObject = localDrawable1;
        } else {
          try
          {
            int i = Integer.parseInt(paramString);
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            ((StringBuilder)localObject).append("android.resource://");
            ((StringBuilder)localObject).append(this.mProviderContext.getPackageName());
            ((StringBuilder)localObject).append("/");
            ((StringBuilder)localObject).append(i);
            localObject = ((StringBuilder)localObject).toString();
            localDrawable1 = checkIconCache((String)localObject);
            if (localDrawable1 != null) {
              return localDrawable1;
            }
            localDrawable1 = ContextCompat.getDrawable(this.mProviderContext, i);
            storeInIconCache((String)localObject, localDrawable1);
            return localDrawable1;
          }
          catch (Resources.NotFoundException localNotFoundException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Icon resource not found: ");
            localStringBuilder.append(paramString);
            Log.w("SuggestionsAdapter", localStringBuilder.toString());
            return null;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localDrawable2 = checkIconCache(paramString);
            if (localDrawable2 != null) {
              return localDrawable2;
            }
            localDrawable2 = getDrawable(Uri.parse(paramString));
            storeInIconCache(paramString, localDrawable2);
          }
        }
      }
    }
    return localDrawable2;
  }
  
  private Drawable getIcon1(Cursor paramCursor)
  {
    int i = this.mIconName1Col;
    if (i == -1) {
      return null;
    }
    paramCursor = getDrawableFromResourceValue(paramCursor.getString(i));
    if (paramCursor != null) {
      return paramCursor;
    }
    return getDefaultIcon1();
  }
  
  private Drawable getIcon2(Cursor paramCursor)
  {
    int i = this.mIconName2Col;
    if (i == -1) {
      return null;
    }
    return getDrawableFromResourceValue(paramCursor.getString(i));
  }
  
  private static String getStringOrNull(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", paramCursor);
    }
    return null;
  }
  
  private void setViewDrawable(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
    }
    else
    {
      paramImageView.setVisibility(0);
      paramDrawable.setVisible(false, false);
      paramDrawable.setVisible(true, false);
    }
  }
  
  private void setViewText(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence)) {
      paramTextView.setVisibility(8);
    } else {
      paramTextView.setVisibility(0);
    }
  }
  
  private void storeInIconCache(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.mOutsideDrawablesCache.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private void updateSpinnerState(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor = paramCursor.getExtras();
    } else {
      paramCursor = null;
    }
    if ((paramCursor != null) && (paramCursor.getBoolean("in_progress"))) {}
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    paramContext = (ChildViewCache)paramView.getTag();
    int i = this.mFlagsCol;
    if (i != -1) {
      i = paramCursor.getInt(i);
    } else {
      i = 0;
    }
    if (paramContext.mText1 != null)
    {
      paramView = getStringOrNull(paramCursor, this.mText1Col);
      setViewText(paramContext.mText1, paramView);
    }
    if (paramContext.mText2 != null)
    {
      paramView = getStringOrNull(paramCursor, this.mText2UrlCol);
      if (paramView != null) {
        paramView = formatUrl(paramView);
      } else {
        paramView = getStringOrNull(paramCursor, this.mText2Col);
      }
      TextView localTextView;
      if (TextUtils.isEmpty(paramView))
      {
        localTextView = paramContext.mText1;
        if (localTextView != null)
        {
          localTextView.setSingleLine(false);
          paramContext.mText1.setMaxLines(2);
        }
      }
      else
      {
        localTextView = paramContext.mText1;
        if (localTextView != null)
        {
          localTextView.setSingleLine(true);
          paramContext.mText1.setMaxLines(1);
        }
      }
      setViewText(paramContext.mText2, paramView);
    }
    paramView = paramContext.mIcon1;
    if (paramView != null) {
      setViewDrawable(paramView, getIcon1(paramCursor), 4);
    }
    paramView = paramContext.mIcon2;
    if (paramView != null) {
      setViewDrawable(paramView, getIcon2(paramCursor), 8);
    }
    int j = this.mQueryRefinement;
    if ((j != 2) && ((j != 1) || ((i & 0x1) == 0)))
    {
      paramContext.mIconRefine.setVisibility(8);
    }
    else
    {
      paramContext.mIconRefine.setVisibility(0);
      paramContext.mIconRefine.setTag(paramContext.mText1.getText());
      paramContext.mIconRefine.setOnClickListener(this);
    }
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (this.mClosed)
    {
      Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
    }
    try
    {
      super.changeCursor(paramCursor);
      if (paramCursor != null)
      {
        this.mText1Col = paramCursor.getColumnIndex("suggest_text_1");
        this.mText2Col = paramCursor.getColumnIndex("suggest_text_2");
        this.mText2UrlCol = paramCursor.getColumnIndex("suggest_text_2_url");
        this.mIconName1Col = paramCursor.getColumnIndex("suggest_icon_1");
        this.mIconName2Col = paramCursor.getColumnIndex("suggest_icon_2");
        this.mFlagsCol = paramCursor.getColumnIndex("suggest_flags");
      }
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "error changing cursor and caching columns", paramCursor);
    }
  }
  
  public void close()
  {
    changeCursor(null);
    this.mClosed = true;
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    String str = getColumnString(paramCursor, "suggest_intent_query");
    if (str != null) {
      return str;
    }
    if (this.mSearchable.shouldRewriteQueryFromData())
    {
      str = getColumnString(paramCursor, "suggest_intent_data");
      if (str != null) {
        return str;
      }
    }
    if (this.mSearchable.shouldRewriteQueryFromText())
    {
      paramCursor = getColumnString(paramCursor, "suggest_text_1");
      if (paramCursor != null) {
        return paramCursor;
      }
    }
    return null;
  }
  
  Drawable getDrawableFromResourceUri(Uri paramUri)
    throws FileNotFoundException
  {
    String str = paramUri.getAuthority();
    if (!TextUtils.isEmpty(str)) {
      try
      {
        Resources localResources = this.mContext.getPackageManager().getResourcesForApplication(str);
        List localList = paramUri.getPathSegments();
        if (localList != null)
        {
          int i = localList.size();
          if (i == 1)
          {
            try
            {
              i = Integer.parseInt((String)localList.get(0));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("Single path segment is not a resource ID: ");
              localStringBuilder1.append(paramUri);
              throw new FileNotFoundException(localStringBuilder1.toString());
            }
          }
          else
          {
            if (i != 2) {
              break label185;
            }
            i = localStringBuilder1.getIdentifier((String)localList.get(1), (String)localList.get(0), str);
          }
          if (i != 0) {
            return localStringBuilder1.getDrawable(i);
          }
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("No resource found for: ");
          localStringBuilder1.append(paramUri);
          throw new FileNotFoundException(localStringBuilder1.toString());
          label185:
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("More than two path segments: ");
          localStringBuilder1.append(paramUri);
          throw new FileNotFoundException(localStringBuilder1.toString());
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("No path: ");
        localStringBuilder1.append(paramUri);
        throw new FileNotFoundException(localStringBuilder1.toString());
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("No package found for authority: ");
        localStringBuilder2.append(paramUri);
        throw new FileNotFoundException(localStringBuilder2.toString());
      }
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("No authority: ");
    localStringBuilder2.append(paramUri);
    throw new FileNotFoundException(localStringBuilder2.toString());
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = newDropDownView(this.mContext, this.mCursor, paramViewGroup);
      if (paramViewGroup != null) {
        ((ChildViewCache)paramViewGroup.getTag()).mText1.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public int getQueryRefinement()
  {
    return this.mQueryRefinement;
  }
  
  Cursor getSearchManagerSuggestions(SearchableInfo paramSearchableInfo, String paramString, int paramInt)
  {
    Object localObject1 = null;
    if (paramSearchableInfo == null) {
      return null;
    }
    Object localObject2 = paramSearchableInfo.getSuggestAuthority();
    if (localObject2 == null) {
      return null;
    }
    localObject2 = new Uri.Builder().scheme("content").authority((String)localObject2).query("").fragment("");
    String str = paramSearchableInfo.getSuggestPath();
    if (str != null) {
      ((Uri.Builder)localObject2).appendEncodedPath(str);
    }
    ((Uri.Builder)localObject2).appendPath("search_suggest_query");
    str = paramSearchableInfo.getSuggestSelection();
    if (str != null)
    {
      paramSearchableInfo = new String[1];
      paramSearchableInfo[0] = paramString;
    }
    else
    {
      ((Uri.Builder)localObject2).appendPath(paramString);
      paramSearchableInfo = (SearchableInfo)localObject1;
    }
    if (paramInt > 0) {
      ((Uri.Builder)localObject2).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    paramString = ((Uri.Builder)localObject2).build();
    return this.mContext.getContentResolver().query(paramString, null, str, paramSearchableInfo, null);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = newView(this.mContext, this.mCursor, paramViewGroup);
      if (paramViewGroup != null) {
        ((ChildViewCache)paramViewGroup.getTag()).mText1.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = super.newView(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new ChildViewCache(paramContext));
    ((ImageView)paramContext.findViewById(R.id.edit_query)).setImageResource(this.mCommitIconResId);
    return paramContext;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    updateSpinnerState(getCursor());
  }
  
  public void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    updateSpinnerState(getCursor());
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.mSearchView.onQueryRefine((CharSequence)paramView);
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    } else {
      paramCharSequence = paramCharSequence.toString();
    }
    if ((this.mSearchView.getVisibility() == 0) && (this.mSearchView.getWindowVisibility() == 0)) {
      try
      {
        paramCharSequence = getSearchManagerSuggestions(this.mSearchable, paramCharSequence, 50);
        if (paramCharSequence != null)
        {
          paramCharSequence.getCount();
          return paramCharSequence;
        }
      }
      catch (RuntimeException paramCharSequence)
      {
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", paramCharSequence);
      }
    }
    return null;
  }
  
  public void setQueryRefinement(int paramInt)
  {
    this.mQueryRefinement = paramInt;
  }
  
  private static final class ChildViewCache
  {
    public final ImageView mIcon1;
    public final ImageView mIcon2;
    public final ImageView mIconRefine;
    public final TextView mText1;
    public final TextView mText2;
    
    public ChildViewCache(View paramView)
    {
      this.mText1 = ((TextView)paramView.findViewById(16908308));
      this.mText2 = ((TextView)paramView.findViewById(16908309));
      this.mIcon1 = ((ImageView)paramView.findViewById(16908295));
      this.mIcon2 = ((ImageView)paramView.findViewById(16908296));
      this.mIconRefine = ((ImageView)paramView.findViewById(R.id.edit_query));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\SuggestionsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */