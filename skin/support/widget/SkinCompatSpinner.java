package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatSpinner;
import f.a.f.a.d;

public class SkinCompatSpinner
  extends AppCompatSpinner
  implements g
{
  private static final String c = SkinCompatSpinner.class.getSimpleName();
  private static final int[] d = { 16843505 };
  private a f;
  private int q;
  
  public SkinCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SkinCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, f.a.a.spinnerStyle);
  }
  
  public SkinCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public SkinCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public SkinCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, android.content.res.Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: iload 4
    //   6: aload 5
    //   8: invokespecial 50	androidx/appcompat/widget/AppCompatSpinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;IILandroid/content/res/Resources$Theme;)V
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 52	skin/support/widget/SkinCompatSpinner:q	I
    //   16: aload_1
    //   17: aload_2
    //   18: getstatic 57	f/a/d:Spinner	[I
    //   21: iload_3
    //   22: iconst_0
    //   23: invokevirtual 63	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   26: astore 6
    //   28: aload_0
    //   29: invokevirtual 67	androidx/appcompat/widget/AppCompatSpinner:getPopupContext	()Landroid/content/Context;
    //   32: ifnull +174 -> 206
    //   35: iload 4
    //   37: istore 7
    //   39: iload 4
    //   41: iconst_m1
    //   42: if_icmpne +128 -> 170
    //   45: getstatic 72	android/os/Build$VERSION:SDK_INT	I
    //   48: bipush 11
    //   50: if_icmplt +117 -> 167
    //   53: aconst_null
    //   54: astore 5
    //   56: aconst_null
    //   57: astore 8
    //   59: aload_1
    //   60: aload_2
    //   61: getstatic 27	skin/support/widget/SkinCompatSpinner:d	[I
    //   64: iload_3
    //   65: iconst_0
    //   66: invokevirtual 63	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   69: astore_1
    //   70: aload_1
    //   71: astore 9
    //   73: iload 4
    //   75: istore 7
    //   77: aload_1
    //   78: astore 8
    //   80: aload_1
    //   81: astore 5
    //   83: aload_1
    //   84: iconst_0
    //   85: invokevirtual 78	android/content/res/TypedArray:hasValue	(I)Z
    //   88: ifeq +20 -> 108
    //   91: aload_1
    //   92: astore 8
    //   94: aload_1
    //   95: astore 5
    //   97: aload_1
    //   98: iconst_0
    //   99: iconst_0
    //   100: invokevirtual 82	android/content/res/TypedArray:getInt	(II)I
    //   103: istore 7
    //   105: aload_1
    //   106: astore 9
    //   108: aload 9
    //   110: invokevirtual 85	android/content/res/TypedArray:recycle	()V
    //   113: goto +57 -> 170
    //   116: astore_1
    //   117: goto +38 -> 155
    //   120: astore_1
    //   121: aload 5
    //   123: astore 8
    //   125: getstatic 24	skin/support/widget/SkinCompatSpinner:c	Ljava/lang/String;
    //   128: ldc 87
    //   130: aload_1
    //   131: invokestatic 93	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   134: pop
    //   135: iload 4
    //   137: istore 7
    //   139: aload 5
    //   141: ifnull +29 -> 170
    //   144: aload 5
    //   146: astore 9
    //   148: iload 4
    //   150: istore 7
    //   152: goto -44 -> 108
    //   155: aload 8
    //   157: ifnull +8 -> 165
    //   160: aload 8
    //   162: invokevirtual 85	android/content/res/TypedArray:recycle	()V
    //   165: aload_1
    //   166: athrow
    //   167: iconst_1
    //   168: istore 7
    //   170: iload 7
    //   172: iconst_1
    //   173: if_icmpne +33 -> 206
    //   176: aload_0
    //   177: invokevirtual 67	androidx/appcompat/widget/AppCompatSpinner:getPopupContext	()Landroid/content/Context;
    //   180: aload_2
    //   181: getstatic 57	f/a/d:Spinner	[I
    //   184: iload_3
    //   185: iconst_0
    //   186: invokevirtual 63	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   189: astore_1
    //   190: aload_0
    //   191: aload_1
    //   192: getstatic 96	f/a/d:Spinner_android_popupBackground	I
    //   195: iconst_0
    //   196: invokevirtual 99	android/content/res/TypedArray:getResourceId	(II)I
    //   199: putfield 52	skin/support/widget/SkinCompatSpinner:q	I
    //   202: aload_1
    //   203: invokevirtual 85	android/content/res/TypedArray:recycle	()V
    //   206: aload 6
    //   208: invokevirtual 85	android/content/res/TypedArray:recycle	()V
    //   211: new 101	skin/support/widget/a
    //   214: dup
    //   215: aload_0
    //   216: invokespecial 104	skin/support/widget/a:<init>	(Landroid/view/View;)V
    //   219: astore_1
    //   220: aload_0
    //   221: aload_1
    //   222: putfield 106	skin/support/widget/SkinCompatSpinner:f	Lskin/support/widget/a;
    //   225: aload_1
    //   226: aload_2
    //   227: iload_3
    //   228: invokevirtual 109	skin/support/widget/a:c	(Landroid/util/AttributeSet;I)V
    //   231: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	SkinCompatSpinner
    //   0	232	1	paramContext	Context
    //   0	232	2	paramAttributeSet	AttributeSet
    //   0	232	3	paramInt1	int
    //   0	232	4	paramInt2	int
    //   0	232	5	paramTheme	android.content.res.Resources.Theme
    //   26	181	6	localTypedArray	android.content.res.TypedArray
    //   37	137	7	i	int
    //   57	104	8	localObject1	Object
    //   71	76	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	70	116	finally
    //   83	91	116	finally
    //   97	105	116	finally
    //   125	135	116	finally
    //   59	70	120	java/lang/Exception
    //   83	91	120	java/lang/Exception
    //   97	105	120	java/lang/Exception
  }
  
  private void a()
  {
    int i = c.a(this.q);
    this.q = i;
    if (i != 0) {
      setPopupBackgroundDrawable(d.d(getContext(), this.q));
    }
  }
  
  public void setPopupBackgroundResource(@DrawableRes int paramInt)
  {
    super.setPopupBackgroundResource(paramInt);
    this.q = paramInt;
    a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\SkinCompatSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */