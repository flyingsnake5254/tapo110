package f.a.f.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.color;
import androidx.appcompat.R.drawable;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class b
{
  private static final String a = "b";
  private static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
  private static b c;
  private static final b d = new b(6);
  private static final int[] e = { R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha };
  private static final int[] f = { R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha };
  private static final int[] g = { R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light };
  private static final int[] h = { R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult };
  private static final int[] i = { R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material };
  private static final int[] j = { R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material };
  private WeakHashMap<Context, SparseArray<ColorStateList>> k;
  private ArrayMap<String, c> l;
  private SparseArray<String> m;
  private final Object n = new Object();
  private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> o = new WeakHashMap(0);
  private TypedValue p;
  private boolean q;
  
  private void a(@NonNull String paramString, @NonNull c paramc)
  {
    if (this.l == null) {
      this.l = new ArrayMap();
    }
    this.l.put(paramString, paramc);
  }
  
  private boolean b(@NonNull Context paramContext, long paramLong, @NonNull Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
    if (localConstantState != null) {
      synchronized (this.n)
      {
        LongSparseArray localLongSparseArray = (LongSparseArray)this.o.get(paramContext);
        paramDrawable = localLongSparseArray;
        if (localLongSparseArray == null)
        {
          paramDrawable = new androidx/collection/LongSparseArray;
          paramDrawable.<init>();
          this.o.put(paramContext, paramDrawable);
        }
        paramContext = new java/lang/ref/WeakReference;
        paramContext.<init>(localConstantState);
        paramDrawable.put(paramLong, paramContext);
        return true;
      }
    }
    return false;
  }
  
  private void c(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull ColorStateList paramColorStateList)
  {
    if (this.k == null) {
      this.k = new WeakHashMap();
    }
    SparseArray localSparseArray1 = (SparseArray)this.k.get(paramContext);
    SparseArray localSparseArray2 = localSparseArray1;
    if (localSparseArray1 == null)
    {
      localSparseArray2 = new SparseArray();
      this.k.put(paramContext, localSparseArray2);
    }
    localSparseArray2.append(paramInt, paramColorStateList);
  }
  
  private static boolean d(int[] paramArrayOfInt, int paramInt)
  {
    int i1 = paramArrayOfInt.length;
    for (int i2 = 0; i2 < i1; i2++) {
      if (paramArrayOfInt[i2] == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  private void e(@NonNull Context paramContext)
  {
    if (this.q) {
      return;
    }
    this.q = true;
    paramContext = o(paramContext, R.drawable.abc_vector_test);
    if ((paramContext != null) && (v(paramContext))) {
      return;
    }
    this.q = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  private ColorStateList f(@NonNull Context paramContext)
  {
    return g(paramContext, 0);
  }
  
  private ColorStateList g(@NonNull Context paramContext, @ColorInt int paramInt)
  {
    int i1 = e.e(paramContext, R.attr.colorControlHighlight);
    int i2 = e.b(paramContext, R.attr.colorButtonNormal);
    int[] arrayOfInt1 = e.b;
    paramContext = e.k;
    int i3 = ColorUtils.compositeColors(i1, paramInt);
    int[] arrayOfInt2 = e.e;
    i1 = ColorUtils.compositeColors(i1, paramInt);
    return new ColorStateList(new int[][] { arrayOfInt1, paramContext, arrayOfInt2, e.o }, new int[] { i2, i3, i1, paramInt });
  }
  
  private static long h(TypedValue paramTypedValue)
  {
    return paramTypedValue.assetCookie << 32 | paramTypedValue.data;
  }
  
  private ColorStateList i(@NonNull Context paramContext)
  {
    return g(paramContext, e.e(paramContext, R.attr.colorAccent));
  }
  
  private ColorStateList j(@NonNull Context paramContext)
  {
    return g(paramContext, e.e(paramContext, R.attr.colorButtonNormal));
  }
  
  private Drawable k(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (this.p == null) {
      this.p = new TypedValue();
    }
    TypedValue localTypedValue = this.p;
    d.m(paramContext, paramInt, localTypedValue, true);
    long l1 = h(localTypedValue);
    Object localObject = n(paramContext, l1);
    if (localObject != null) {
      return (Drawable)localObject;
    }
    if (paramInt == R.drawable.abc_cab_background_top_material) {
      localObject = new LayerDrawable(new Drawable[] { o(paramContext, R.drawable.abc_cab_background_internal_bg), o(paramContext, R.drawable.abc_cab_background_top_mtrl_alpha) });
    }
    if (localObject != null)
    {
      ((Drawable)localObject).setChangingConfigurations(localTypedValue.changingConfigurations);
      b(paramContext, l1, (Drawable)localObject);
    }
    return (Drawable)localObject;
  }
  
  private ColorStateList l(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    int i1 = R.attr.colorSwitchThumbNormal;
    ColorStateList localColorStateList = e.g(paramContext, i1);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = e.b;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = e.l;
      arrayOfInt1[1] = e.e(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = e.o;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    else
    {
      arrayOfInt[0] = e.b;
      arrayOfInt1[0] = e.b(paramContext, i1);
      arrayOfInt[1] = e.l;
      arrayOfInt1[1] = e.e(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = e.o;
      arrayOfInt1[2] = e.e(paramContext, i1);
    }
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }
  
  public static b m()
  {
    if (c == null)
    {
      b localb = new b();
      c = localb;
      u(localb);
    }
    return c;
  }
  
  private Drawable n(@NonNull Context paramContext, long paramLong)
  {
    synchronized (this.n)
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)this.o.get(paramContext);
      if (localLongSparseArray == null) {
        return null;
      }
      Object localObject2 = (WeakReference)localLongSparseArray.get(paramLong);
      if (localObject2 != null)
      {
        localObject2 = (Drawable.ConstantState)((WeakReference)localObject2).get();
        if (localObject2 != null)
        {
          paramContext = ((Drawable.ConstantState)localObject2).newDrawable(paramContext.getResources());
          return paramContext;
        }
        localLongSparseArray.delete(paramLong);
      }
      return null;
    }
  }
  
  public static PorterDuffColorFilter q(int paramInt, PorterDuff.Mode paramMode)
  {
    b localb = d;
    PorterDuffColorFilter localPorterDuffColorFilter1 = localb.get(paramInt, paramMode);
    PorterDuffColorFilter localPorterDuffColorFilter2 = localPorterDuffColorFilter1;
    if (localPorterDuffColorFilter1 == null)
    {
      localPorterDuffColorFilter2 = new PorterDuffColorFilter(paramInt, paramMode);
      localb.put(paramInt, paramMode, localPorterDuffColorFilter2);
    }
    return localPorterDuffColorFilter2;
  }
  
  private ColorStateList s(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    WeakHashMap localWeakHashMap = this.k;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localWeakHashMap != null)
    {
      paramContext = (SparseArray)localWeakHashMap.get(paramContext);
      localObject2 = localObject1;
      if (paramContext != null) {
        localObject2 = (ColorStateList)paramContext.get(paramInt);
      }
    }
    return (ColorStateList)localObject2;
  }
  
  static PorterDuff.Mode t(int paramInt)
  {
    PorterDuff.Mode localMode;
    if (paramInt == R.drawable.abc_switch_thumb_material) {
      localMode = PorterDuff.Mode.MULTIPLY;
    } else {
      localMode = null;
    }
    return localMode;
  }
  
  private static void u(@NonNull b paramb)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      paramb.a("vector", new d());
      paramb.a("animated-vector", new a());
    }
  }
  
  private static boolean v(@NonNull Drawable paramDrawable)
  {
    boolean bool;
    if ((!(paramDrawable instanceof VectorDrawableCompat)) && (!"android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private Drawable w(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    Object localObject1 = this.l;
    if ((localObject1 != null) && (!((SimpleArrayMap)localObject1).isEmpty()))
    {
      localObject1 = this.m;
      if (localObject1 != null)
      {
        localObject1 = (String)((SparseArray)localObject1).get(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (this.l.get(localObject1) == null))) {
          return null;
        }
      }
      else
      {
        this.m = new SparseArray();
      }
      if (this.p == null) {
        this.p = new TypedValue();
      }
      TypedValue localTypedValue = this.p;
      d.m(paramContext, paramInt, localTypedValue, true);
      long l1 = h(localTypedValue);
      Drawable localDrawable = n(paramContext, l1);
      if (localDrawable != null) {
        return localDrawable;
      }
      localObject1 = localTypedValue.string;
      Object localObject2 = localDrawable;
      if (localObject1 != null)
      {
        localObject2 = localDrawable;
        if (((CharSequence)localObject1).toString().endsWith(".xml"))
        {
          localObject2 = localDrawable;
          try
          {
            XmlResourceParser localXmlResourceParser = d.n(paramContext, paramInt);
            localObject2 = localDrawable;
            AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
            int i1;
            do
            {
              localObject2 = localDrawable;
              i1 = localXmlResourceParser.next();
            } while ((i1 != 2) && (i1 != 1));
            if (i1 == 2)
            {
              localObject2 = localDrawable;
              localObject1 = localXmlResourceParser.getName();
              localObject2 = localDrawable;
              this.m.append(paramInt, localObject1);
              localObject2 = localDrawable;
              c localc = (c)this.l.get(localObject1);
              localObject1 = localDrawable;
              if (localc != null)
              {
                localObject2 = localDrawable;
                localObject1 = localc.createFromXmlInner(paramContext, localXmlResourceParser, localAttributeSet, null);
              }
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                ((Drawable)localObject1).setChangingConfigurations(localTypedValue.changingConfigurations);
                localObject2 = localObject1;
                b(paramContext, l1, (Drawable)localObject1);
                localObject2 = localObject1;
              }
            }
            else
            {
              localObject2 = localDrawable;
              paramContext = new org/xmlpull/v1/XmlPullParserException;
              localObject2 = localDrawable;
              paramContext.<init>("No start tag found");
              localObject2 = localDrawable;
              throw paramContext;
            }
          }
          catch (Exception paramContext)
          {
            Log.e(a, "Exception while inflating drawable", paramContext);
          }
        }
      }
      if (localObject2 == null) {
        this.m.append(paramInt, "appcompat_skip_skip");
      }
      return (Drawable)localObject2;
    }
    return null;
  }
  
  private static void x(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (c.a(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = b;
    }
    localDrawable.setColorFilter(q(paramInt, paramDrawable));
  }
  
  private Drawable y(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean, @NonNull Drawable paramDrawable)
  {
    Object localObject1 = r(paramContext, paramInt);
    if (localObject1 != null)
    {
      paramContext = paramDrawable;
      if (c.a(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = DrawableCompat.wrap(paramContext);
      DrawableCompat.setTintList(paramContext, (ColorStateList)localObject1);
      paramDrawable = t(paramInt);
      localObject1 = paramContext;
      if (paramDrawable != null)
      {
        DrawableCompat.setTintMode(paramContext, paramDrawable);
        localObject1 = paramContext;
      }
    }
    else
    {
      Object localObject2;
      Object localObject3;
      if (paramInt == R.drawable.abc_seekbar_track_material)
      {
        localObject2 = (LayerDrawable)paramDrawable;
        localObject3 = ((LayerDrawable)localObject2).findDrawableByLayerId(16908288);
        int i1 = R.attr.colorControlNormal;
        paramInt = e.e(paramContext, i1);
        localObject1 = b;
        x((Drawable)localObject3, paramInt, (PorterDuff.Mode)localObject1);
        x(((LayerDrawable)localObject2).findDrawableByLayerId(16908303), e.e(paramContext, i1), (PorterDuff.Mode)localObject1);
        x(((LayerDrawable)localObject2).findDrawableByLayerId(16908301), e.e(paramContext, R.attr.colorControlActivated), (PorterDuff.Mode)localObject1);
        localObject1 = paramDrawable;
      }
      else if ((paramInt != R.drawable.abc_ratingbar_material) && (paramInt != R.drawable.abc_ratingbar_indicator_material) && (paramInt != R.drawable.abc_ratingbar_small_material))
      {
        localObject1 = paramDrawable;
        if (!z(paramContext, paramInt, paramDrawable))
        {
          localObject1 = paramDrawable;
          if (paramBoolean) {
            localObject1 = null;
          }
        }
      }
      else
      {
        localObject3 = (LayerDrawable)paramDrawable;
        localObject2 = ((LayerDrawable)localObject3).findDrawableByLayerId(16908288);
        paramInt = e.b(paramContext, R.attr.colorControlNormal);
        localObject1 = b;
        x((Drawable)localObject2, paramInt, (PorterDuff.Mode)localObject1);
        localObject2 = ((LayerDrawable)localObject3).findDrawableByLayerId(16908303);
        paramInt = R.attr.colorControlActivated;
        x((Drawable)localObject2, e.e(paramContext, paramInt), (PorterDuff.Mode)localObject1);
        x(((LayerDrawable)localObject3).findDrawableByLayerId(16908301), e.e(paramContext, paramInt), (PorterDuff.Mode)localObject1);
        localObject1 = paramDrawable;
      }
    }
    return (Drawable)localObject1;
  }
  
  static boolean z(@NonNull Context paramContext, @DrawableRes int paramInt, @NonNull Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = b;
    boolean bool = d(e, paramInt);
    int i1 = 16842801;
    if (bool) {
      paramInt = R.attr.colorControlNormal;
    }
    for (;;)
    {
      for (i1 = -1;; i1 = Math.round(40.8F))
      {
        i2 = 1;
        break label116;
        if (d(g, paramInt))
        {
          paramInt = R.attr.colorControlActivated;
          break;
        }
        if (d(h, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          paramInt = i1;
          break;
        }
        if (paramInt != R.drawable.abc_list_divider_mtrl_alpha) {
          break label95;
        }
        paramInt = 16842800;
      }
      label95:
      if (paramInt != R.drawable.abc_dialog_material_background) {
        break;
      }
      paramInt = i1;
    }
    i1 = -1;
    int i2 = 0;
    paramInt = 0;
    label116:
    if (i2 != 0)
    {
      Drawable localDrawable = paramDrawable;
      if (c.a(paramDrawable)) {
        localDrawable = paramDrawable.mutate();
      }
      localDrawable.setColorFilter(q(e.e(paramContext, paramInt), localMode));
      if (i1 != -1) {
        localDrawable.setAlpha(i1);
      }
      return true;
    }
    return false;
  }
  
  public Drawable o(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    return p(paramContext, paramInt, false);
  }
  
  Drawable p(@NonNull Context paramContext, @DrawableRes int paramInt, boolean paramBoolean)
  {
    e(paramContext);
    Object localObject1 = w(paramContext, paramInt);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = k(paramContext, paramInt);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = d.c(paramContext, paramInt);
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = y(paramContext, paramInt, paramBoolean, (Drawable)localObject1);
    }
    if (localObject2 != null) {
      c.b((Drawable)localObject2);
    }
    return (Drawable)localObject2;
  }
  
  ColorStateList r(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    ColorStateList localColorStateList1 = s(paramContext, paramInt);
    ColorStateList localColorStateList2 = localColorStateList1;
    if (localColorStateList1 == null)
    {
      if (paramInt == R.drawable.abc_edit_text_material) {
        localColorStateList1 = d.b(paramContext, R.color.abc_tint_edittext);
      } else if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
        localColorStateList1 = d.b(paramContext, R.color.abc_tint_switch_track);
      } else if (paramInt == R.drawable.abc_switch_thumb_material) {
        localColorStateList1 = l(paramContext);
      } else if (paramInt == R.drawable.abc_btn_default_mtrl_shape) {
        localColorStateList1 = j(paramContext);
      } else if (paramInt == R.drawable.abc_btn_borderless_material) {
        localColorStateList1 = f(paramContext);
      } else if (paramInt == R.drawable.abc_btn_colored_material) {
        localColorStateList1 = i(paramContext);
      } else if ((paramInt != R.drawable.abc_spinner_mtrl_am_alpha) && (paramInt != R.drawable.abc_spinner_textfield_background_material))
      {
        if (d(f, paramInt)) {
          localColorStateList1 = e.g(paramContext, R.attr.colorControlNormal);
        } else if (d(i, paramInt)) {
          localColorStateList1 = d.b(paramContext, R.color.abc_tint_default);
        } else if (d(j, paramInt)) {
          localColorStateList1 = d.b(paramContext, R.color.abc_tint_btn_checkable);
        } else if (paramInt == R.drawable.abc_seekbar_thumb_material) {
          localColorStateList1 = d.b(paramContext, R.color.abc_tint_seek_thumb);
        }
      }
      else {
        localColorStateList1 = d.b(paramContext, R.color.abc_tint_spinner);
      }
      localColorStateList2 = localColorStateList1;
      if (localColorStateList1 != null)
      {
        c(paramContext, paramInt, localColorStateList1);
        localColorStateList2 = localColorStateList1;
      }
    }
    return localColorStateList2;
  }
  
  @TargetApi(11)
  @RequiresApi(11)
  private static class a
    implements b.c
  {
    @SuppressLint({"NewApi"})
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
  
  private static class b
    extends LruCache<Integer, PorterDuffColorFilter>
  {
    public b(int paramInt)
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
  
  private static abstract interface c
  {
    public abstract Drawable createFromXmlInner(@NonNull Context paramContext, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme);
  }
  
  private static class d
    implements b.c
  {
    @SuppressLint({"NewApi"})
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\f\a\f\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */