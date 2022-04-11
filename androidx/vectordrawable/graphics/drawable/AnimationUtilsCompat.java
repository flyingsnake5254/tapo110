package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimationUtilsCompat
{
  private static Interpolator createInterpolatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    paramResources = null;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        return paramResources;
      }
      if (j == 2)
      {
        paramTheme = Xml.asAttributeSet(paramXmlPullParser);
        paramResources = paramXmlPullParser.getName();
        if (!paramResources.equals("linearInterpolator")) {
          break;
        }
        paramResources = new LinearInterpolator();
      }
    }
    if (paramResources.equals("accelerateInterpolator")) {
      paramResources = new AccelerateInterpolator(paramContext, paramTheme);
    }
    for (;;)
    {
      break;
      if (paramResources.equals("decelerateInterpolator"))
      {
        paramResources = new DecelerateInterpolator(paramContext, paramTheme);
      }
      else
      {
        if (paramResources.equals("accelerateDecelerateInterpolator"))
        {
          paramResources = new AccelerateDecelerateInterpolator();
          break;
        }
        if (paramResources.equals("cycleInterpolator"))
        {
          paramResources = new CycleInterpolator(paramContext, paramTheme);
        }
        else if (paramResources.equals("anticipateInterpolator"))
        {
          paramResources = new AnticipateInterpolator(paramContext, paramTheme);
        }
        else if (paramResources.equals("overshootInterpolator"))
        {
          paramResources = new OvershootInterpolator(paramContext, paramTheme);
        }
        else if (paramResources.equals("anticipateOvershootInterpolator"))
        {
          paramResources = new AnticipateOvershootInterpolator(paramContext, paramTheme);
        }
        else
        {
          if (paramResources.equals("bounceInterpolator"))
          {
            paramResources = new BounceInterpolator();
            break;
          }
          if (!paramResources.equals("pathInterpolator")) {
            break label277;
          }
          paramResources = new PathInterpolatorCompat(paramContext, paramTheme, paramXmlPullParser);
        }
      }
    }
    label277:
    paramContext = new StringBuilder();
    paramContext.append("Unknown interpolator name: ");
    paramContext.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramContext.toString());
    return paramResources;
  }
  
  /* Error */
  public static Interpolator loadInterpolator(Context paramContext, int paramInt)
    throws android.content.res.Resources.NotFoundException
  {
    // Byte code:
    //   0: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +9 -> 14
    //   8: aload_0
    //   9: iload_1
    //   10: invokestatic 130	android/view/animation/AnimationUtils:loadInterpolator	(Landroid/content/Context;I)Landroid/view/animation/Interpolator;
    //   13: areturn
    //   14: aconst_null
    //   15: astore_2
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore 4
    //   21: iload_1
    //   22: ldc -125
    //   24: if_icmpne +23 -> 47
    //   27: new 133	androidx/interpolator/view/animation/FastOutLinearInInterpolator
    //   30: dup
    //   31: invokespecial 134	androidx/interpolator/view/animation/FastOutLinearInInterpolator:<init>	()V
    //   34: areturn
    //   35: astore_0
    //   36: goto +233 -> 269
    //   39: astore_3
    //   40: goto +84 -> 124
    //   43: astore_0
    //   44: goto +153 -> 197
    //   47: iload_1
    //   48: ldc -121
    //   50: if_icmpne +11 -> 61
    //   53: new 137	androidx/interpolator/view/animation/FastOutSlowInInterpolator
    //   56: dup
    //   57: invokespecial 138	androidx/interpolator/view/animation/FastOutSlowInInterpolator:<init>	()V
    //   60: areturn
    //   61: iload_1
    //   62: ldc -117
    //   64: if_icmpne +11 -> 75
    //   67: new 141	androidx/interpolator/view/animation/LinearOutSlowInInterpolator
    //   70: dup
    //   71: invokespecial 142	androidx/interpolator/view/animation/LinearOutSlowInInterpolator:<init>	()V
    //   74: areturn
    //   75: aload_0
    //   76: invokevirtual 148	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   79: iload_1
    //   80: invokevirtual 154	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   83: astore 5
    //   85: aload 5
    //   87: astore 4
    //   89: aload 5
    //   91: astore_2
    //   92: aload 5
    //   94: astore_3
    //   95: aload_0
    //   96: aload_0
    //   97: invokevirtual 148	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   100: aload_0
    //   101: invokevirtual 158	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   104: aload 5
    //   106: invokestatic 160	androidx/vectordrawable/graphics/drawable/AnimationUtilsCompat:createInterpolatorFromXml	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/Interpolator;
    //   109: astore_0
    //   110: aload 5
    //   112: ifnull +10 -> 122
    //   115: aload 5
    //   117: invokeinterface 165 1 0
    //   122: aload_0
    //   123: areturn
    //   124: aload_2
    //   125: astore 4
    //   127: new 120	android/content/res/Resources$NotFoundException
    //   130: astore_0
    //   131: aload_2
    //   132: astore 4
    //   134: new 100	java/lang/StringBuilder
    //   137: astore 5
    //   139: aload_2
    //   140: astore 4
    //   142: aload 5
    //   144: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   147: aload_2
    //   148: astore 4
    //   150: aload 5
    //   152: ldc -89
    //   154: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_2
    //   159: astore 4
    //   161: aload 5
    //   163: iload_1
    //   164: invokestatic 173	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   167: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_2
    //   172: astore 4
    //   174: aload_0
    //   175: aload 5
    //   177: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokespecial 174	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   183: aload_2
    //   184: astore 4
    //   186: aload_0
    //   187: aload_3
    //   188: invokevirtual 178	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   191: pop
    //   192: aload_2
    //   193: astore 4
    //   195: aload_0
    //   196: athrow
    //   197: aload_3
    //   198: astore 4
    //   200: new 120	android/content/res/Resources$NotFoundException
    //   203: astore 5
    //   205: aload_3
    //   206: astore 4
    //   208: new 100	java/lang/StringBuilder
    //   211: astore_2
    //   212: aload_3
    //   213: astore 4
    //   215: aload_2
    //   216: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   219: aload_3
    //   220: astore 4
    //   222: aload_2
    //   223: ldc -89
    //   225: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_3
    //   230: astore 4
    //   232: aload_2
    //   233: iload_1
    //   234: invokestatic 173	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   237: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_3
    //   242: astore 4
    //   244: aload 5
    //   246: aload_2
    //   247: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokespecial 174	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   253: aload_3
    //   254: astore 4
    //   256: aload 5
    //   258: aload_0
    //   259: invokevirtual 178	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   262: pop
    //   263: aload_3
    //   264: astore 4
    //   266: aload 5
    //   268: athrow
    //   269: aload 4
    //   271: ifnull +10 -> 281
    //   274: aload 4
    //   276: invokeinterface 165 1 0
    //   281: aload_0
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramContext	Context
    //   0	283	1	paramInt	int
    //   15	232	2	localObject1	Object
    //   17	1	3	localObject2	Object
    //   39	1	3	localIOException	IOException
    //   94	170	3	localObject3	Object
    //   19	256	4	localObject4	Object
    //   83	184	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   27	35	35	finally
    //   53	61	35	finally
    //   67	75	35	finally
    //   75	85	35	finally
    //   95	110	35	finally
    //   127	131	35	finally
    //   134	139	35	finally
    //   142	147	35	finally
    //   150	158	35	finally
    //   161	171	35	finally
    //   174	183	35	finally
    //   186	192	35	finally
    //   195	197	35	finally
    //   200	205	35	finally
    //   208	212	35	finally
    //   215	219	35	finally
    //   222	229	35	finally
    //   232	241	35	finally
    //   244	253	35	finally
    //   256	263	35	finally
    //   266	269	35	finally
    //   27	35	39	java/io/IOException
    //   53	61	39	java/io/IOException
    //   67	75	39	java/io/IOException
    //   75	85	39	java/io/IOException
    //   95	110	39	java/io/IOException
    //   27	35	43	org/xmlpull/v1/XmlPullParserException
    //   53	61	43	org/xmlpull/v1/XmlPullParserException
    //   67	75	43	org/xmlpull/v1/XmlPullParserException
    //   75	85	43	org/xmlpull/v1/XmlPullParserException
    //   95	110	43	org/xmlpull/v1/XmlPullParserException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\vectordrawable\graphics\drawable\AnimationUtilsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */