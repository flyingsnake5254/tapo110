package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.R.drawable;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal
{
  private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
  private static final boolean DEBUG = false;
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private static ResourceManagerInternal INSTANCE;
  private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
  private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
  private static final String TAG = "ResourceManagerInternal";
  private SimpleArrayMap<String, InflateDelegate> mDelegates;
  private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
  private boolean mHasCheckedVectorDrawableSetup;
  private ResourceManagerHooks mHooks;
  private SparseArrayCompat<String> mKnownDrawableIdTags;
  private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
  private TypedValue mTypedValue;
  
  private void addDelegate(@NonNull String paramString, @NonNull InflateDelegate paramInflateDelegate)
  {
    if (this.mDelegates == null) {
      this.mDelegates = new SimpleArrayMap();
    }
    this.mDelegates.put(paramString, paramInflateDelegate);
  }
  
  private boolean addDrawableToCache(@NonNull Context paramContext, long paramLong, @NonNull Drawable paramDrawable)
  {
    try
    {
      Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
      if (localConstantState != null)
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
        paramDrawable = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          paramDrawable = new androidx/collection/LongSparseArray;
          paramDrawable.<init>();
          this.mDrawableCaches.put(paramContext, paramDrawable);
        }
        paramContext = new java/lang/ref/WeakReference;
        paramContext.<init>(localConstantState);
        paramDrawable.put(paramLong, paramContext);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  private void addTintListToCache(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull ColorStateList paramColorStateList)
  {
    if (this.mTintLists == null) {
      this.mTintLists = new WeakHashMap();
    }
    SparseArrayCompat localSparseArrayCompat1 = (SparseArrayCompat)this.mTintLists.get(paramContext);
    SparseArrayCompat localSparseArrayCompat2 = localSparseArrayCompat1;
    if (localSparseArrayCompat1 == null)
    {
      localSparseArrayCompat2 = new SparseArrayCompat();
      this.mTintLists.put(paramContext, localSparseArrayCompat2);
    }
    localSparseArrayCompat2.append(paramInt, paramColorStateList);
  }
  
  private void checkVectorDrawableSetup(@NonNull Context paramContext)
  {
    if (this.mHasCheckedVectorDrawableSetup) {
      return;
    }
    this.mHasCheckedVectorDrawableSetup = true;
    paramContext = getDrawable(paramContext, R.drawable.abc_vector_test);
    if ((paramContext != null) && (isVectorDrawable(paramContext))) {
      return;
    }
    this.mHasCheckedVectorDrawableSetup = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  private static long createCacheKey(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  private Drawable createDrawableIfNeeded(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (this.mTypedValue == null) {
      this.mTypedValue = new TypedValue();
    }
    TypedValue localTypedValue = this.mTypedValue;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l = createCacheKey(localTypedValue);
    Object localObject = getCachedDrawable(paramContext, l);
    if (localObject != null) {
      return (Drawable)localObject;
    }
    localObject = this.mHooks;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ResourceManagerHooks)localObject).createDrawableFor(this, paramContext, paramInt);
    }
    if (localObject != null)
    {
      ((Drawable)localObject).setChangingConfigurations(localTypedValue.changingConfigurations);
      addDrawableToCache(paramContext, l, (Drawable)localObject);
    }
    return (Drawable)localObject;
  }
  
  private static PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return getPorterDuffColorFilter(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode);
    }
    return null;
  }
  
  public static ResourceManagerInternal get()
  {
    try
    {
      if (INSTANCE == null)
      {
        localResourceManagerInternal = new androidx/appcompat/widget/ResourceManagerInternal;
        localResourceManagerInternal.<init>();
        INSTANCE = localResourceManagerInternal;
        installDefaultInflateDelegates(localResourceManagerInternal);
      }
      ResourceManagerInternal localResourceManagerInternal = INSTANCE;
      return localResourceManagerInternal;
    }
    finally {}
  }
  
  private Drawable getCachedDrawable(@NonNull Context paramContext, long paramLong)
  {
    try
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)this.mDrawableCaches.get(paramContext);
      if (localLongSparseArray == null) {
        return null;
      }
      Object localObject = (WeakReference)localLongSparseArray.get(paramLong);
      if (localObject != null)
      {
        localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
        if (localObject != null)
        {
          paramContext = ((Drawable.ConstantState)localObject).newDrawable(paramContext.getResources());
          return paramContext;
        }
        localLongSparseArray.remove(paramLong);
      }
      return null;
    }
    finally {}
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      ColorFilterLruCache localColorFilterLruCache = COLOR_FILTER_CACHE;
      PorterDuffColorFilter localPorterDuffColorFilter1 = localColorFilterLruCache.get(paramInt, paramMode);
      PorterDuffColorFilter localPorterDuffColorFilter2 = localPorterDuffColorFilter1;
      if (localPorterDuffColorFilter1 == null)
      {
        localPorterDuffColorFilter2 = new android/graphics/PorterDuffColorFilter;
        localPorterDuffColorFilter2.<init>(paramInt, paramMode);
        localColorFilterLruCache.put(paramInt, paramMode, localPorterDuffColorFilter2);
      }
      return localPorterDuffColorFilter2;
    }
    finally {}
  }
  
  private ColorStateList getTintListFromCache(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    WeakHashMap localWeakHashMap = this.mTintLists;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localWeakHashMap != null)
    {
      paramContext = (SparseArrayCompat)localWeakHashMap.get(paramContext);
      localObject2 = localObject1;
      if (paramContext != null) {
        localObject2 = (ColorStateList)paramContext.get(paramInt);
      }
    }
    return (ColorStateList)localObject2;
  }
  
  private static void installDefaultInflateDelegates(@NonNull ResourceManagerInternal paramResourceManagerInternal)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      paramResourceManagerInternal.addDelegate("vector", new VdcInflateDelegate());
      paramResourceManagerInternal.addDelegate("animated-vector", new AvdcInflateDelegate());
      paramResourceManagerInternal.addDelegate("animated-selector", new AsldcInflateDelegate());
    }
  }
  
  private static boolean isVectorDrawable(@NonNull Drawable paramDrawable)
  {
    boolean bool;
    if ((!(paramDrawable instanceof VectorDrawableCompat)) && (!"android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private Drawable loadDrawableFromDelegates(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    Object localObject1 = this.mDelegates;
    if ((localObject1 != null) && (!((SimpleArrayMap)localObject1).isEmpty()))
    {
      localObject1 = this.mKnownDrawableIdTags;
      if (localObject1 != null)
      {
        localObject1 = (String)((SparseArrayCompat)localObject1).get(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.mDelegates.get(localObject1) == null))) {
          return null;
        }
      }
      else
      {
        this.mKnownDrawableIdTags = new SparseArrayCompat();
      }
      if (this.mTypedValue == null) {
        this.mTypedValue = new TypedValue();
      }
      TypedValue localTypedValue = this.mTypedValue;
      localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l = createCacheKey(localTypedValue);
      Drawable localDrawable = getCachedDrawable(paramContext, l);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject2 = localTypedValue.string;
      Object localObject3 = localDrawable;
      if (localObject2 != null)
      {
        localObject3 = localDrawable;
        if (((CharSequence)localObject2).toString().endsWith(".xml"))
        {
          localObject3 = localDrawable;
          try
          {
            localObject2 = ((Resources)localObject1).getXml(paramInt);
            localObject3 = localDrawable;
            AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject2);
            int i;
            do
            {
              localObject3 = localDrawable;
              i = ((XmlPullParser)localObject2).next();
            } while ((i != 2) && (i != 1));
            if (i == 2)
            {
              localObject3 = localDrawable;
              localObject1 = ((XmlPullParser)localObject2).getName();
              localObject3 = localDrawable;
              this.mKnownDrawableIdTags.append(paramInt, localObject1);
              localObject3 = localDrawable;
              InflateDelegate localInflateDelegate = (InflateDelegate)this.mDelegates.get(localObject1);
              localObject1 = localDrawable;
              if (localInflateDelegate != null)
              {
                localObject3 = localDrawable;
                localObject1 = localInflateDelegate.createFromXmlInner(paramContext, (XmlPullParser)localObject2, localAttributeSet, paramContext.getTheme());
              }
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                localObject3 = localObject1;
                ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
                localObject3 = localObject1;
                addDrawableToCache(paramContext, l, (Drawable)localObject1);
                localObject3 = localObject1;
              }
            }
            else
            {
              localObject3 = localDrawable;
              paramContext = new org/xmlpull/v1/XmlPullParserException;
              localObject3 = localDrawable;
              paramContext.<init>("No start tag found");
              localObject3 = localDrawable;
              throw paramContext;
            }
          }
          catch (Exception paramContext)
          {
            Log.e("ResourceManagerInternal", "Exception while inflating drawable", paramContext);
          }
        }
      }
      if (localObject3 == null) {
        this.mKnownDrawableIdTags.append(paramInt, "appcompat_skip_skip");
      }
      return (Drawable)localObject3;
    }
    return null;
  }
  
  private Drawable tintDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean, @NonNull Drawable paramDrawable)
  {
    Object localObject = getTintList(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = DrawableCompat.wrap(paramContext);
      DrawableCompat.setTintList(paramContext, (ColorStateList)localObject);
      paramDrawable = getTintMode(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        DrawableCompat.setTintMode(paramContext, paramDrawable);
        localObject = paramContext;
      }
    }
    else
    {
      localObject = this.mHooks;
      if ((localObject != null) && (((ResourceManagerHooks)localObject).tintDrawable(paramContext, paramInt, paramDrawable)))
      {
        localObject = paramDrawable;
      }
      else
      {
        localObject = paramDrawable;
        if (!tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable))
        {
          localObject = paramDrawable;
          if (paramBoolean) {
            localObject = null;
          }
        }
      }
    }
    return (Drawable)localObject;
  }
  
  static void tintDrawable(Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfInt)
  {
    if ((DrawableUtils.canSafelyMutateDrawable(paramDrawable)) && (paramDrawable.mutate() != paramDrawable))
    {
      Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
      return;
    }
    boolean bool = paramTintInfo.mHasTintList;
    if ((!bool) && (!paramTintInfo.mHasTintMode))
    {
      paramDrawable.clearColorFilter();
    }
    else
    {
      ColorStateList localColorStateList;
      if (bool) {
        localColorStateList = paramTintInfo.mTintList;
      } else {
        localColorStateList = null;
      }
      if (paramTintInfo.mHasTintMode) {
        paramTintInfo = paramTintInfo.mTintMode;
      } else {
        paramTintInfo = DEFAULT_MODE;
      }
      paramDrawable.setColorFilter(createTintFilter(localColorStateList, paramTintInfo, paramArrayOfInt));
    }
    if (Build.VERSION.SDK_INT <= 23) {
      paramDrawable.invalidateSelf();
    }
  }
  
  public Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    try
    {
      paramContext = getDrawable(paramContext, paramInt, false);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean)
  {
    try
    {
      checkVectorDrawableSetup(paramContext);
      Object localObject1 = loadDrawableFromDelegates(paramContext, paramInt);
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = createDrawableIfNeeded(paramContext, paramInt);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ContextCompat.getDrawable(paramContext, paramInt);
      }
      localObject2 = localObject1;
      if (localObject1 != null) {
        localObject2 = tintDrawable(paramContext, paramInt, paramBoolean, (Drawable)localObject1);
      }
      if (localObject2 != null) {
        DrawableUtils.fixDrawable((Drawable)localObject2);
      }
      return (Drawable)localObject2;
    }
    finally {}
  }
  
  ColorStateList getTintList(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    try
    {
      Object localObject1 = getTintListFromCache(paramContext, paramInt);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = this.mHooks;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((ResourceManagerHooks)localObject1).getTintListForDrawableRes(paramContext, paramInt);
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          addTintListToCache(paramContext, paramInt, (ColorStateList)localObject1);
          localObject2 = localObject1;
        }
      }
      return (ColorStateList)localObject2;
    }
    finally {}
  }
  
  PorterDuff.Mode getTintMode(int paramInt)
  {
    Object localObject = this.mHooks;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ResourceManagerHooks)localObject).getTintModeForDrawableRes(paramInt);
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public void onConfigurationChanged(@NonNull Context paramContext)
  {
    try
    {
      paramContext = (LongSparseArray)this.mDrawableCaches.get(paramContext);
      if (paramContext != null) {
        paramContext.clear();
      }
      return;
    }
    finally {}
  }
  
  Drawable onDrawableLoadedFromResources(@NonNull Context paramContext, @NonNull VectorEnabledTintResources paramVectorEnabledTintResources, @DrawableRes int paramInt)
  {
    try
    {
      Drawable localDrawable1 = loadDrawableFromDelegates(paramContext, paramInt);
      Drawable localDrawable2 = localDrawable1;
      if (localDrawable1 == null) {
        localDrawable2 = paramVectorEnabledTintResources.superGetDrawable(paramInt);
      }
      if (localDrawable2 != null)
      {
        paramContext = tintDrawable(paramContext, paramInt, false, localDrawable2);
        return paramContext;
      }
      return null;
    }
    finally {}
  }
  
  public void setHooks(ResourceManagerHooks paramResourceManagerHooks)
  {
    try
    {
      this.mHooks = paramResourceManagerHooks;
      return;
    }
    finally
    {
      paramResourceManagerHooks = finally;
      throw paramResourceManagerHooks;
    }
  }
  
  boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable)
  {
    ResourceManagerHooks localResourceManagerHooks = this.mHooks;
    boolean bool;
    if ((localResourceManagerHooks != null) && (localResourceManagerHooks.tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(11)
  static class AsldcInflateDelegate
    implements ResourceManagerInternal.InflateDelegate
  {
    public Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    {
      try
      {
        paramContext = AnimatedStateListDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", paramContext);
      }
      return null;
    }
  }
  
  private static class AvdcInflateDelegate
    implements ResourceManagerInternal.InflateDelegate
  {
    public Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    {
      try
      {
        paramContext = AnimatedVectorDrawableCompat.createFromXmlInner(paramContext, paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", paramContext);
      }
      return null;
    }
  }
  
  private static class ColorFilterLruCache
    extends LruCache<Integer, PorterDuffColorFilter>
  {
    public ColorFilterLruCache(int paramInt)
    {
      super();
    }
    
    private static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
    {
      return (paramInt + 31) * 31 + paramMode.hashCode();
    }
    
    PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)get(Integer.valueOf(generateCacheKey(paramInt, paramMode)));
    }
    
    PorterDuffColorFilter put(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)put(Integer.valueOf(generateCacheKey(paramInt, paramMode)), paramPorterDuffColorFilter);
    }
  }
  
  private static abstract interface InflateDelegate
  {
    public abstract Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  static abstract interface ResourceManagerHooks
  {
    public abstract Drawable createDrawableFor(@NonNull ResourceManagerInternal paramResourceManagerInternal, @NonNull Context paramContext, @DrawableRes int paramInt);
    
    public abstract ColorStateList getTintListForDrawableRes(@NonNull Context paramContext, @DrawableRes int paramInt);
    
    public abstract PorterDuff.Mode getTintModeForDrawableRes(int paramInt);
    
    public abstract boolean tintDrawable(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable);
    
    public abstract boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable);
  }
  
  private static class VdcInflateDelegate
    implements ResourceManagerInternal.InflateDelegate
  {
    public Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    {
      try
      {
        paramContext = VectorDrawableCompat.createFromXmlInner(paramContext.getResources(), paramXmlPullParser, paramAttributeSet, paramTheme);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", paramContext);
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ResourceManagerInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */