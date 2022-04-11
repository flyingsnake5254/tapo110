package skin.support.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import f.a.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import skin.support.widget.SkinCompatAutoCompleteTextView;
import skin.support.widget.SkinCompatButton;
import skin.support.widget.SkinCompatCheckBox;
import skin.support.widget.SkinCompatCheckedTextView;
import skin.support.widget.SkinCompatEditText;
import skin.support.widget.SkinCompatFrameLayout;
import skin.support.widget.SkinCompatImageButton;
import skin.support.widget.SkinCompatImageView;
import skin.support.widget.SkinCompatLinearLayout;
import skin.support.widget.SkinCompatMultiAutoCompleteTextView;
import skin.support.widget.SkinCompatProgressBar;
import skin.support.widget.SkinCompatRadioButton;
import skin.support.widget.SkinCompatRadioGroup;
import skin.support.widget.SkinCompatRatingBar;
import skin.support.widget.SkinCompatRelativeLayout;
import skin.support.widget.SkinCompatScrollView;
import skin.support.widget.SkinCompatSeekBar;
import skin.support.widget.SkinCompatSpinner;
import skin.support.widget.SkinCompatTextView;
import skin.support.widget.SkinCompatToolbar;
import skin.support.widget.SkinCompatView;

public class a
{
  private static final Class<?>[] a = { Context.class, AttributeSet.class };
  private static final int[] b = { 16843375 };
  private static final String[] c = { "android.widget.", "android.view.", "android.webkit." };
  private static final Map<String, Constructor<? extends View>> d = new ArrayMap();
  private final Object[] e = new Object[2];
  
  private void a(View paramView, AttributeSet paramAttributeSet)
  {
    Object localObject = paramView.getContext();
    if (((localObject instanceof ContextWrapper)) && ((Build.VERSION.SDK_INT < 15) || (ViewCompat.hasOnClickListeners(paramView))))
    {
      paramAttributeSet = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, b);
      localObject = paramAttributeSet.getString(0);
      if (localObject != null) {
        paramView.setOnClickListener(new a(paramView, (String)localObject));
      }
      paramAttributeSet.recycle();
    }
  }
  
  private View b(Context paramContext, String paramString1, String paramString2)
    throws ClassNotFoundException, InflateException
  {
    Map localMap = d;
    Constructor localConstructor = (Constructor)localMap.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null) {}
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 != null)
      {
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>();
        paramContext.append(paramString2);
        paramContext.append(paramString1);
        paramContext = paramContext.toString();
      }
      else
      {
        paramContext = paramString1;
      }
      localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(a);
      localMap.put(paramString1, localObject);
      ((Constructor)localObject).setAccessible(true);
      paramContext = (View)((Constructor)localObject).newInstance(this.e);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private View d(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    boolean bool = paramString.contains(".");
    Object localObject = null;
    if (bool) {
      return null;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2059813682: 
      if (paramString.equals("ScrollView")) {
        i = 19;
      }
      break;
    case 2001146706: 
      if (paramString.equals("Button")) {
        i = 18;
      }
      break;
    case 1969230692: 
      if (paramString.equals("RadioGroup")) {
        i = 17;
      }
      break;
    case 1666676343: 
      if (paramString.equals("EditText")) {
        i = 16;
      }
      break;
    case 1601505219: 
      if (paramString.equals("CheckBox")) {
        i = 15;
      }
      break;
    case 1413872058: 
      if (paramString.equals("AutoCompleteTextView")) {
        i = 14;
      }
      break;
    case 1310765783: 
      if (paramString.equals("FrameLayout")) {
        i = 13;
      }
      break;
    case 1127291599: 
      if (paramString.equals("LinearLayout")) {
        i = 12;
      }
      break;
    case 1125864064: 
      if (paramString.equals("ImageView")) {
        i = 11;
      }
      break;
    case 776382189: 
      if (paramString.equals("RadioButton")) {
        i = 10;
      }
      break;
    case 2666181: 
      if (paramString.equals("View")) {
        i = 9;
      }
      break;
    case -339785223: 
      if (paramString.equals("Spinner")) {
        i = 8;
      }
      break;
    case -443652810: 
      if (paramString.equals("RelativeLayout")) {
        i = 7;
      }
      break;
    case -658531749: 
      if (paramString.equals("SeekBar")) {
        i = 6;
      }
      break;
    case -937446323: 
      if (paramString.equals("ImageButton")) {
        i = 5;
      }
      break;
    case -938935918: 
      if (paramString.equals("TextView")) {
        i = 4;
      }
      break;
    case -1346021293: 
      if (paramString.equals("MultiAutoCompleteTextView")) {
        i = 3;
      }
      break;
    case -1455429095: 
      if (paramString.equals("CheckedTextView")) {
        i = 2;
      }
      break;
    case -1495589242: 
      if (paramString.equals("ProgressBar")) {
        i = 1;
      }
      break;
    case -1946472170: 
      if (paramString.equals("RatingBar")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      paramContext = (Context)localObject;
      break;
    case 19: 
      paramContext = new SkinCompatScrollView(paramContext, paramAttributeSet);
      break;
    case 18: 
      paramContext = new SkinCompatButton(paramContext, paramAttributeSet);
      break;
    case 17: 
      paramContext = new SkinCompatRadioGroup(paramContext, paramAttributeSet);
      break;
    case 16: 
      paramContext = new SkinCompatEditText(paramContext, paramAttributeSet);
      break;
    case 15: 
      paramContext = new SkinCompatCheckBox(paramContext, paramAttributeSet);
      break;
    case 14: 
      paramContext = new SkinCompatAutoCompleteTextView(paramContext, paramAttributeSet);
      break;
    case 13: 
      paramContext = new SkinCompatFrameLayout(paramContext, paramAttributeSet);
      break;
    case 12: 
      paramContext = new SkinCompatLinearLayout(paramContext, paramAttributeSet);
      break;
    case 11: 
      paramContext = new SkinCompatImageView(paramContext, paramAttributeSet);
      break;
    case 10: 
      paramContext = new SkinCompatRadioButton(paramContext, paramAttributeSet);
      break;
    case 9: 
      paramContext = new SkinCompatView(paramContext, paramAttributeSet);
      break;
    case 8: 
      paramContext = new SkinCompatSpinner(paramContext, paramAttributeSet);
      break;
    case 7: 
      paramContext = new SkinCompatRelativeLayout(paramContext, paramAttributeSet);
      break;
    case 6: 
      paramContext = new SkinCompatSeekBar(paramContext, paramAttributeSet);
      break;
    case 5: 
      paramContext = new SkinCompatImageButton(paramContext, paramAttributeSet);
      break;
    case 4: 
      paramContext = new SkinCompatTextView(paramContext, paramAttributeSet);
      break;
    case 3: 
      paramContext = new SkinCompatMultiAutoCompleteTextView(paramContext, paramAttributeSet);
      break;
    case 2: 
      paramContext = new SkinCompatCheckedTextView(paramContext, paramAttributeSet);
      break;
    case 1: 
      paramContext = new SkinCompatProgressBar(paramContext, paramAttributeSet);
      break;
    case 0: 
      paramContext = new SkinCompatRatingBar(paramContext, paramAttributeSet);
    }
    return paramContext;
  }
  
  private View e(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    e.a();
    throw null;
  }
  
  private View f(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    e.a();
    throw null;
  }
  
  private View h(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    int i;
    if ((paramString.hashCode() == -254446176) && (paramString.equals("androidx.appcompat.widget.Toolbar"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0) {
      paramContext = null;
    } else {
      paramContext = new SkinCompatToolbar(paramContext, paramAttributeSet);
    }
    return paramContext;
  }
  
  private static Context i(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    int i;
    if (paramBoolean1) {
      i = paramAttributeSet.getResourceId(R.styleable.View_android_theme, 0);
    } else {
      i = 0;
    }
    int j = i;
    if (paramBoolean2)
    {
      j = i;
      if (i == 0)
      {
        i = paramAttributeSet.getResourceId(R.styleable.View_theme, 0);
        j = i;
        if (i != 0)
        {
          Log.i("SkinCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
          j = i;
        }
      }
    }
    paramAttributeSet.recycle();
    paramAttributeSet = paramContext;
    if (j != 0) {
      if ((paramContext instanceof ContextThemeWrapper))
      {
        paramAttributeSet = paramContext;
        if (((ContextThemeWrapper)paramContext).getThemeResId() == j) {}
      }
      else
      {
        paramAttributeSet = new ContextThemeWrapper(paramContext, j);
      }
    }
    return paramAttributeSet;
  }
  
  public final View c(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject = paramContext;
    if (paramBoolean1)
    {
      localObject = paramContext;
      if (paramView != null) {
        localObject = paramView.getContext();
      }
    }
    if (!paramBoolean2)
    {
      paramView = (View)localObject;
      if (!paramBoolean3) {}
    }
    else
    {
      paramView = i((Context)localObject, paramAttributeSet, paramBoolean2, paramBoolean3);
    }
    localObject = paramView;
    if (paramBoolean4) {
      localObject = TintContextWrapper.wrap(paramView);
    }
    paramContext = e((Context)localObject, paramString, paramAttributeSet);
    paramView = paramContext;
    if (paramContext == null) {
      paramView = d((Context)localObject, paramString, paramAttributeSet);
    }
    paramContext = paramView;
    if (paramView == null) {
      paramContext = h((Context)localObject, paramString, paramAttributeSet);
    }
    paramView = paramContext;
    if (paramContext == null) {
      paramView = f((Context)localObject, paramString, paramAttributeSet);
    }
    paramContext = paramView;
    if (paramView == null) {
      paramContext = g((Context)localObject, paramString, paramAttributeSet);
    }
    if (paramContext != null) {
      a(paramContext, paramAttributeSet);
    }
    return paramContext;
  }
  
  /* Error */
  public View g(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 4
    //   3: aload_2
    //   4: ldc_w 342
    //   7: invokevirtual 167	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +15 -> 25
    //   13: aload_3
    //   14: aconst_null
    //   15: ldc_w 344
    //   18: invokeinterface 348 3 0
    //   23: astore 4
    //   25: aload_0
    //   26: getfield 52	skin/support/app/a:e	[Ljava/lang/Object;
    //   29: astore_2
    //   30: aload_2
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: aload_2
    //   35: iconst_1
    //   36: aload_3
    //   37: aastore
    //   38: iconst_m1
    //   39: aload 4
    //   41: bipush 46
    //   43: invokevirtual 352	java/lang/String:indexOf	(I)I
    //   46: if_icmpne +69 -> 115
    //   49: iconst_0
    //   50: istore 5
    //   52: getstatic 41	skin/support/app/a:c	[Ljava/lang/String;
    //   55: astore_2
    //   56: iload 5
    //   58: aload_2
    //   59: arraylength
    //   60: if_icmpge +40 -> 100
    //   63: aload_0
    //   64: aload_1
    //   65: aload 4
    //   67: aload_2
    //   68: iload 5
    //   70: aaload
    //   71: invokespecial 354	skin/support/app/a:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +18 -> 94
    //   79: aload_0
    //   80: getfield 52	skin/support/app/a:e	[Ljava/lang/Object;
    //   83: astore_1
    //   84: aload_1
    //   85: iconst_0
    //   86: aconst_null
    //   87: aastore
    //   88: aload_1
    //   89: iconst_1
    //   90: aconst_null
    //   91: aastore
    //   92: aload_2
    //   93: areturn
    //   94: iinc 5 1
    //   97: goto -45 -> 52
    //   100: aload_0
    //   101: getfield 52	skin/support/app/a:e	[Ljava/lang/Object;
    //   104: astore_1
    //   105: aload_1
    //   106: iconst_0
    //   107: aconst_null
    //   108: aastore
    //   109: aload_1
    //   110: iconst_1
    //   111: aconst_null
    //   112: aastore
    //   113: aconst_null
    //   114: areturn
    //   115: aload_0
    //   116: aload_1
    //   117: aload 4
    //   119: aconst_null
    //   120: invokespecial 354	skin/support/app/a:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 52	skin/support/app/a:e	[Ljava/lang/Object;
    //   128: astore_2
    //   129: aload_2
    //   130: iconst_0
    //   131: aconst_null
    //   132: aastore
    //   133: aload_2
    //   134: iconst_1
    //   135: aconst_null
    //   136: aastore
    //   137: aload_1
    //   138: areturn
    //   139: astore_2
    //   140: aload_0
    //   141: getfield 52	skin/support/app/a:e	[Ljava/lang/Object;
    //   144: astore_1
    //   145: aload_1
    //   146: iconst_0
    //   147: aconst_null
    //   148: aastore
    //   149: aload_1
    //   150: iconst_1
    //   151: aconst_null
    //   152: aastore
    //   153: aload_2
    //   154: athrow
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 52	skin/support/app/a:e	[Ljava/lang/Object;
    //   160: astore_1
    //   161: aload_1
    //   162: iconst_0
    //   163: aconst_null
    //   164: aastore
    //   165: aload_1
    //   166: iconst_1
    //   167: aconst_null
    //   168: aastore
    //   169: aconst_null
    //   170: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	a
    //   0	171	1	paramContext	Context
    //   0	171	2	paramString	String
    //   0	171	3	paramAttributeSet	AttributeSet
    //   1	117	4	str	String
    //   50	45	5	i	int
    // Exception table:
    //   from	to	target	type
    //   25	30	139	finally
    //   38	49	139	finally
    //   52	75	139	finally
    //   115	124	139	finally
    //   25	30	155	java/lang/Exception
    //   38	49	155	java/lang/Exception
    //   52	75	155	java/lang/Exception
    //   115	124	155	java/lang/Exception
  }
  
  private static class a
    implements View.OnClickListener
  {
    private final View c;
    private final String d;
    private Method f;
    private Context q;
    
    public a(@NonNull View paramView, @NonNull String paramString)
    {
      this.c = paramView;
      this.d = paramString;
    }
    
    @NonNull
    private void a(@Nullable Context paramContext, @NonNull String paramString)
    {
      while (paramContext != null) {
        try
        {
          if (!paramContext.isRestricted())
          {
            paramString = paramContext.getClass().getMethod(this.d, new Class[] { View.class });
            if (paramString != null)
            {
              this.f = paramString;
              this.q = paramContext;
              return;
            }
          }
        }
        catch (NoSuchMethodException paramString)
        {
          if ((paramContext instanceof ContextWrapper)) {
            paramContext = ((ContextWrapper)paramContext).getBaseContext();
          } else {
            paramContext = null;
          }
        }
      }
      int i = this.c.getId();
      if (i == -1)
      {
        paramContext = "";
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(" with id '");
        paramContext.append(this.c.getContext().getResources().getResourceEntryName(i));
        paramContext.append("'");
        paramContext = paramContext.toString();
      }
      paramString = new StringBuilder();
      paramString.append("Could not find method ");
      paramString.append(this.d);
      paramString.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
      paramString.append(this.c.getClass());
      paramString.append(paramContext);
      throw new IllegalStateException(paramString.toString());
    }
    
    public void onClick(@NonNull View paramView)
    {
      if (this.f == null) {
        a(this.c.getContext(), this.d);
      }
      try
      {
        this.f.invoke(this.q, new Object[] { paramView });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new IllegalStateException("Could not execute method for android:onClick", paramView);
      }
      catch (IllegalAccessException paramView)
      {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\app\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */