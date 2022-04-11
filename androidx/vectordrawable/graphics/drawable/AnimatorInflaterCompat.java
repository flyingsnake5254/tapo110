package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.AnimatorRes;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser.PathDataNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimatorInflaterCompat
{
  private static final boolean DBG_ANIMATOR_INFLATER = false;
  private static final int MAX_NUM_POINTS = 100;
  private static final String TAG = "AnimatorInflater";
  private static final int TOGETHER = 0;
  private static final int VALUE_TYPE_COLOR = 3;
  private static final int VALUE_TYPE_FLOAT = 0;
  private static final int VALUE_TYPE_INT = 1;
  private static final int VALUE_TYPE_PATH = 2;
  private static final int VALUE_TYPE_UNDEFINED = 4;
  
  private static Animator createAnimatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, float paramFloat)
    throws XmlPullParserException, IOException
  {
    return createAnimatorFromXml(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0, paramFloat);
  }
  
  private static Animator createAnimatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    Object localObject1 = null;
    Object localObject2 = null;
    int k;
    int m;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      k = 0;
      m = 0;
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label330;
      }
      if (j == 2)
      {
        Object localObject3 = paramXmlPullParser.getName();
        if (((String)localObject3).equals("objectAnimator")) {
          localObject3 = loadObjectAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, paramFloat, paramXmlPullParser);
        }
        for (;;)
        {
          break;
          if (((String)localObject3).equals("animator"))
          {
            localObject3 = loadAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
          }
          else if (((String)localObject3).equals("set"))
          {
            localObject3 = new AnimatorSet();
            localObject1 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
            createAnimatorFromXml(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject3, TypedArrayUtils.getNamedInt((TypedArray)localObject1, paramXmlPullParser, "ordering", 0, 0), paramFloat);
            ((TypedArray)localObject1).recycle();
          }
          else
          {
            if (!((String)localObject3).equals("propertyValuesHolder")) {
              break label292;
            }
            localObject3 = loadValues(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
            if ((localObject3 != null) && ((localObject1 instanceof ValueAnimator))) {
              ((ValueAnimator)localObject1).setValues((PropertyValuesHolder[])localObject3);
            }
            m = 1;
            localObject3 = localObject1;
          }
        }
        localObject1 = localObject3;
        if (paramAnimatorSet != null)
        {
          localObject1 = localObject3;
          if (m == 0)
          {
            Object localObject4 = localObject2;
            if (localObject2 == null) {
              localObject4 = new ArrayList();
            }
            ((ArrayList)localObject4).add(localObject3);
            localObject1 = localObject3;
            localObject2 = localObject4;
          }
        }
      }
    }
    label292:
    paramContext = new StringBuilder();
    paramContext.append("Unknown animator name: ");
    paramContext.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramContext.toString());
    label330:
    if ((paramAnimatorSet != null) && (localObject2 != null))
    {
      paramContext = new Animator[((ArrayList)localObject2).size()];
      paramResources = ((ArrayList)localObject2).iterator();
      for (m = k; paramResources.hasNext(); m++) {
        paramContext[m] = ((Animator)paramResources.next());
      }
      if (paramInt == 0) {
        paramAnimatorSet.playTogether(paramContext);
      } else {
        paramAnimatorSet.playSequentially(paramContext);
      }
    }
    return (Animator)localObject1;
  }
  
  private static Keyframe createNewKeyframe(Keyframe paramKeyframe, float paramFloat)
  {
    if (paramKeyframe.getType() == Float.TYPE) {
      paramKeyframe = Keyframe.ofFloat(paramFloat);
    } else if (paramKeyframe.getType() == Integer.TYPE) {
      paramKeyframe = Keyframe.ofInt(paramFloat);
    } else {
      paramKeyframe = Keyframe.ofObject(paramFloat);
    }
    return paramKeyframe;
  }
  
  private static void distributeKeyframes(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2)
  {
    paramFloat /= (paramInt2 - paramInt1 + 2);
    while (paramInt1 <= paramInt2)
    {
      paramArrayOfKeyframe[paramInt1].setFraction(paramArrayOfKeyframe[(paramInt1 - 1)].getFraction() + paramFloat);
      paramInt1++;
    }
  }
  
  private static void dumpKeyframes(Object[] paramArrayOfObject, String paramString)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length != 0))
    {
      Log.d("AnimatorInflater", paramString);
      int i = paramArrayOfObject.length;
      for (int j = 0; j < i; j++)
      {
        Keyframe localKeyframe = (Keyframe)paramArrayOfObject[j];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Keyframe ");
        localStringBuilder.append(j);
        localStringBuilder.append(": fraction ");
        float f = localKeyframe.getFraction();
        String str = "null";
        if (f < 0.0F) {
          paramString = "null";
        } else {
          paramString = Float.valueOf(localKeyframe.getFraction());
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append(", , value : ");
        paramString = str;
        if (localKeyframe.hasValue()) {
          paramString = localKeyframe.getValue();
        }
        localStringBuilder.append(paramString);
        Log.d("AnimatorInflater", localStringBuilder.toString());
      }
    }
  }
  
  private static PropertyValuesHolder getPVH(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject1 = paramTypedArray.peekValue(paramInt2);
    int i;
    if (localObject1 != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = ((TypedValue)localObject1).type;
    } else {
      j = 0;
    }
    localObject1 = paramTypedArray.peekValue(paramInt3);
    int k;
    if (localObject1 != null) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (k != 0) {
      m = ((TypedValue)localObject1).type;
    } else {
      m = 0;
    }
    int n = paramInt1;
    if (paramInt1 == 4) {
      if (((i != 0) && (isColorType(j))) || ((k != 0) && (isColorType(m)))) {
        n = 3;
      } else {
        n = 0;
      }
    }
    if (n == 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    localObject1 = null;
    String str = null;
    Object localObject2;
    if (n == 2)
    {
      localObject2 = paramTypedArray.getString(paramInt2);
      str = paramTypedArray.getString(paramInt3);
      PathParser.PathDataNode[] arrayOfPathDataNode1 = PathParser.createNodesFromPathData((String)localObject2);
      PathParser.PathDataNode[] arrayOfPathDataNode2 = PathParser.createNodesFromPathData(str);
      if (arrayOfPathDataNode1 == null)
      {
        paramTypedArray = (TypedArray)localObject1;
        if (arrayOfPathDataNode2 == null) {}
      }
      else if (arrayOfPathDataNode1 != null)
      {
        paramTypedArray = new PathDataEvaluator();
        if (arrayOfPathDataNode2 != null)
        {
          if (PathParser.canMorph(arrayOfPathDataNode1, arrayOfPathDataNode2))
          {
            paramTypedArray = PropertyValuesHolder.ofObject(paramString, paramTypedArray, new Object[] { arrayOfPathDataNode1, arrayOfPathDataNode2 });
          }
          else
          {
            paramTypedArray = new StringBuilder();
            paramTypedArray.append(" Can't morph from ");
            paramTypedArray.append((String)localObject2);
            paramTypedArray.append(" to ");
            paramTypedArray.append(str);
            throw new InflateException(paramTypedArray.toString());
          }
        }
        else {
          paramTypedArray = PropertyValuesHolder.ofObject(paramString, paramTypedArray, new Object[] { arrayOfPathDataNode1 });
        }
      }
      else
      {
        paramTypedArray = (TypedArray)localObject1;
        if (arrayOfPathDataNode2 != null) {
          paramTypedArray = PropertyValuesHolder.ofObject(paramString, new PathDataEvaluator(), new Object[] { arrayOfPathDataNode2 });
        }
      }
    }
    else
    {
      if (n == 3) {
        localObject2 = ArgbEvaluator.getInstance();
      } else {
        localObject2 = null;
      }
      if (paramInt1 != 0)
      {
        float f1;
        if (i != 0)
        {
          if (j == 5) {
            f1 = paramTypedArray.getDimension(paramInt2, 0.0F);
          } else {
            f1 = paramTypedArray.getFloat(paramInt2, 0.0F);
          }
          if (k != 0)
          {
            float f2;
            if (m == 5) {
              f2 = paramTypedArray.getDimension(paramInt3, 0.0F);
            } else {
              f2 = paramTypedArray.getFloat(paramInt3, 0.0F);
            }
            paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1, f2 });
          }
          else
          {
            paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
          }
        }
        else
        {
          if (m == 5) {
            f1 = paramTypedArray.getDimension(paramInt3, 0.0F);
          } else {
            f1 = paramTypedArray.getFloat(paramInt3, 0.0F);
          }
          paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
        }
        localObject1 = paramTypedArray;
      }
      else if (i != 0)
      {
        if (j == 5) {
          paramInt1 = (int)paramTypedArray.getDimension(paramInt2, 0.0F);
        } else if (isColorType(j)) {
          paramInt1 = paramTypedArray.getColor(paramInt2, 0);
        } else {
          paramInt1 = paramTypedArray.getInt(paramInt2, 0);
        }
        if (k != 0)
        {
          if (m == 5) {
            paramInt2 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
          } else if (isColorType(m)) {
            paramInt2 = paramTypedArray.getColor(paramInt3, 0);
          } else {
            paramInt2 = paramTypedArray.getInt(paramInt3, 0);
          }
          localObject1 = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1, paramInt2 });
        }
        else
        {
          localObject1 = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
        }
      }
      else
      {
        localObject1 = str;
        if (k != 0)
        {
          if (m == 5) {
            paramInt1 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
          } else if (isColorType(m)) {
            paramInt1 = paramTypedArray.getColor(paramInt3, 0);
          } else {
            paramInt1 = paramTypedArray.getInt(paramInt3, 0);
          }
          localObject1 = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
        }
      }
      paramTypedArray = (TypedArray)localObject1;
      if (localObject1 != null)
      {
        paramTypedArray = (TypedArray)localObject1;
        if (localObject2 != null)
        {
          ((PropertyValuesHolder)localObject1).setEvaluator((TypeEvaluator)localObject2);
          paramTypedArray = (TypedArray)localObject1;
        }
      }
    }
    return paramTypedArray;
  }
  
  private static int inferValueTypeFromValues(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = paramTypedArray.peekValue(paramInt1);
    int i = 1;
    int j = 0;
    if (localTypedValue != null) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int k;
    if (paramInt1 != 0) {
      k = localTypedValue.type;
    } else {
      k = 0;
    }
    paramTypedArray = paramTypedArray.peekValue(paramInt2);
    if (paramTypedArray != null) {
      paramInt2 = i;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0) {
      i = paramTypedArray.type;
    } else {
      i = 0;
    }
    if ((paramInt1 == 0) || (!isColorType(k)))
    {
      paramInt1 = j;
      if (paramInt2 != 0)
      {
        paramInt1 = j;
        if (!isColorType(i)) {}
      }
    }
    else
    {
      paramInt1 = 3;
    }
    return paramInt1;
  }
  
  private static int inferValueTypeOfKeyframe(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_KEYFRAME);
    int i = 0;
    paramTheme = TypedArrayUtils.peekNamedValue(paramResources, paramXmlPullParser, "value", 0);
    int j;
    if (paramTheme != null) {
      j = 1;
    } else {
      j = 0;
    }
    int k = i;
    if (j != 0)
    {
      k = i;
      if (isColorType(paramTheme.type)) {
        k = 3;
      }
    }
    paramResources.recycle();
    return k;
  }
  
  private static boolean isColorType(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 28) && (paramInt <= 31)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static Animator loadAnimator(Context paramContext, @AnimatorRes int paramInt)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramContext = AnimatorInflater.loadAnimator(paramContext, paramInt);
    } else {
      paramContext = loadAnimator(paramContext, paramContext.getResources(), paramContext.getTheme(), paramInt);
    }
    return paramContext;
  }
  
  public static Animator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, @AnimatorRes int paramInt)
    throws Resources.NotFoundException
  {
    return loadAnimator(paramContext, paramResources, paramTheme, paramInt, 1.0F);
  }
  
  /* Error */
  public static Animator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, @AnimatorRes int paramInt, float paramFloat)
    throws Resources.NotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: iload_3
    //   11: invokevirtual 360	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 8
    //   16: aload 8
    //   18: astore 7
    //   20: aload 8
    //   22: astore 5
    //   24: aload 8
    //   26: astore 6
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: aload 8
    //   33: fload 4
    //   35: invokestatic 362	androidx/vectordrawable/graphics/drawable/AnimatorInflaterCompat:createAnimatorFromXml	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;F)Landroid/animation/Animator;
    //   38: astore_0
    //   39: aload 8
    //   41: ifnull +10 -> 51
    //   44: aload 8
    //   46: invokeinterface 367 1 0
    //   51: aload_0
    //   52: areturn
    //   53: astore_0
    //   54: goto +159 -> 213
    //   57: astore_0
    //   58: aload 5
    //   60: astore 7
    //   62: new 327	android/content/res/Resources$NotFoundException
    //   65: astore_1
    //   66: aload 5
    //   68: astore 7
    //   70: new 131	java/lang/StringBuilder
    //   73: astore_2
    //   74: aload 5
    //   76: astore 7
    //   78: aload_2
    //   79: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   82: aload 5
    //   84: astore 7
    //   86: aload_2
    //   87: ldc_w 369
    //   90: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 5
    //   96: astore 7
    //   98: aload_2
    //   99: iload_3
    //   100: invokestatic 372	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   103: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 5
    //   109: astore 7
    //   111: aload_1
    //   112: aload_2
    //   113: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 373	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   119: aload 5
    //   121: astore 7
    //   123: aload_1
    //   124: aload_0
    //   125: invokevirtual 377	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   128: pop
    //   129: aload 5
    //   131: astore 7
    //   133: aload_1
    //   134: athrow
    //   135: astore_0
    //   136: aload 6
    //   138: astore 7
    //   140: new 327	android/content/res/Resources$NotFoundException
    //   143: astore_2
    //   144: aload 6
    //   146: astore 7
    //   148: new 131	java/lang/StringBuilder
    //   151: astore_1
    //   152: aload 6
    //   154: astore 7
    //   156: aload_1
    //   157: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   160: aload 6
    //   162: astore 7
    //   164: aload_1
    //   165: ldc_w 369
    //   168: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 6
    //   174: astore 7
    //   176: aload_1
    //   177: iload_3
    //   178: invokestatic 372	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   181: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 6
    //   187: astore 7
    //   189: aload_2
    //   190: aload_1
    //   191: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokespecial 373	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   197: aload 6
    //   199: astore 7
    //   201: aload_2
    //   202: aload_0
    //   203: invokevirtual 377	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   206: pop
    //   207: aload 6
    //   209: astore 7
    //   211: aload_2
    //   212: athrow
    //   213: aload 7
    //   215: ifnull +10 -> 225
    //   218: aload 7
    //   220: invokeinterface 367 1 0
    //   225: aload_0
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramContext	Context
    //   0	227	1	paramResources	Resources
    //   0	227	2	paramTheme	Resources.Theme
    //   0	227	3	paramInt	int
    //   0	227	4	paramFloat	float
    //   1	129	5	localObject1	Object
    //   4	204	6	localObject2	Object
    //   7	212	7	localObject3	Object
    //   14	31	8	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   9	16	53	finally
    //   28	39	53	finally
    //   62	66	53	finally
    //   70	74	53	finally
    //   78	82	53	finally
    //   86	94	53	finally
    //   98	107	53	finally
    //   111	119	53	finally
    //   123	129	53	finally
    //   133	135	53	finally
    //   140	144	53	finally
    //   148	152	53	finally
    //   156	160	53	finally
    //   164	172	53	finally
    //   176	185	53	finally
    //   189	197	53	finally
    //   201	207	53	finally
    //   211	213	53	finally
    //   9	16	57	java/io/IOException
    //   28	39	57	java/io/IOException
    //   9	16	135	org/xmlpull/v1/XmlPullParserException
    //   28	39	135	org/xmlpull/v1/XmlPullParserException
  }
  
  private static ValueAnimator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser)
    throws Resources.NotFoundException
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR);
    paramTheme = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
    paramResources = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramResources = new ValueAnimator();
    }
    parseAnimatorFromTypeArray(paramResources, localTypedArray, paramTheme, paramFloat, paramXmlPullParser);
    int i = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "interpolator", 0, 0);
    if (i > 0) {
      paramResources.setInterpolator(AnimationUtilsCompat.loadInterpolator(paramContext, i));
    }
    localTypedArray.recycle();
    if (paramTheme != null) {
      paramTheme.recycle();
    }
    return paramResources;
  }
  
  private static Keyframe loadKeyframe(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    paramTheme = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_KEYFRAME);
    float f = TypedArrayUtils.getNamedFloat(paramTheme, paramXmlPullParser, "fraction", 3, -1.0F);
    paramResources = TypedArrayUtils.peekNamedValue(paramTheme, paramXmlPullParser, "value", 0);
    int i;
    if (paramResources != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramInt;
    if (paramInt == 4) {
      if ((i != 0) && (isColorType(paramResources.type))) {
        j = 3;
      } else {
        j = 0;
      }
    }
    if (i != 0)
    {
      if (j != 0)
      {
        if ((j != 1) && (j != 3)) {
          paramResources = null;
        } else {
          paramResources = Keyframe.ofInt(f, TypedArrayUtils.getNamedInt(paramTheme, paramXmlPullParser, "value", 0, 0));
        }
      }
      else {
        paramResources = Keyframe.ofFloat(f, TypedArrayUtils.getNamedFloat(paramTheme, paramXmlPullParser, "value", 0, 0.0F));
      }
    }
    else if (j == 0) {
      paramResources = Keyframe.ofFloat(f);
    } else {
      paramResources = Keyframe.ofInt(f);
    }
    paramInt = TypedArrayUtils.getNamedResourceId(paramTheme, paramXmlPullParser, "interpolator", 1, 0);
    if (paramInt > 0) {
      paramResources.setInterpolator(AnimationUtilsCompat.loadInterpolator(paramContext, paramInt));
    }
    paramTheme.recycle();
    return paramResources;
  }
  
  private static ObjectAnimator loadObjectAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, float paramFloat, XmlPullParser paramXmlPullParser)
    throws Resources.NotFoundException
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    loadAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, localObjectAnimator, paramFloat, paramXmlPullParser);
    return localObjectAnimator;
  }
  
  private static PropertyValuesHolder loadPvh(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
    throws XmlPullParserException, IOException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = paramInt;
    for (;;)
    {
      paramInt = paramXmlPullParser.next();
      if ((paramInt == 3) || (paramInt == 1)) {
        break;
      }
      if (paramXmlPullParser.getName().equals("keyframe"))
      {
        paramInt = i;
        if (i == 4) {
          paramInt = inferValueTypeOfKeyframe(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramXmlPullParser);
        }
        Keyframe localKeyframe = loadKeyframe(paramContext, paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramInt, paramXmlPullParser);
        Object localObject3 = localObject2;
        if (localKeyframe != null)
        {
          localObject3 = localObject2;
          if (localObject2 == null) {
            localObject3 = new ArrayList();
          }
          ((ArrayList)localObject3).add(localKeyframe);
        }
        paramXmlPullParser.next();
        localObject2 = localObject3;
        i = paramInt;
      }
    }
    paramContext = (Context)localObject1;
    if (localObject2 != null)
    {
      int j = ((ArrayList)localObject2).size();
      paramContext = (Context)localObject1;
      if (j > 0)
      {
        int k = 0;
        paramResources = (Keyframe)((ArrayList)localObject2).get(0);
        paramContext = (Keyframe)((ArrayList)localObject2).get(j - 1);
        float f = paramContext.getFraction();
        paramInt = j;
        if (f < 1.0F) {
          if (f < 0.0F)
          {
            paramContext.setFraction(1.0F);
            paramInt = j;
          }
          else
          {
            ((ArrayList)localObject2).add(((ArrayList)localObject2).size(), createNewKeyframe(paramContext, 1.0F));
            paramInt = j + 1;
          }
        }
        f = paramResources.getFraction();
        j = paramInt;
        if (f != 0.0F) {
          if (f < 0.0F)
          {
            paramResources.setFraction(0.0F);
            j = paramInt;
          }
          else
          {
            ((ArrayList)localObject2).add(0, createNewKeyframe(paramResources, 0.0F));
            j = paramInt + 1;
          }
        }
        paramContext = new Keyframe[j];
        ((ArrayList)localObject2).toArray(paramContext);
        for (paramInt = k; paramInt < j; paramInt++)
        {
          paramResources = paramContext[paramInt];
          if (paramResources.getFraction() < 0.0F) {
            if (paramInt == 0)
            {
              paramResources.setFraction(0.0F);
            }
            else
            {
              int m = j - 1;
              if (paramInt == m)
              {
                paramResources.setFraction(1.0F);
              }
              else
              {
                k = paramInt + 1;
                int n = paramInt;
                while ((k < m) && (paramContext[k].getFraction() < 0.0F))
                {
                  n = k;
                  k++;
                }
                distributeKeyframes(paramContext, paramContext[(n + 1)].getFraction() - paramContext[(paramInt - 1)].getFraction(), paramInt, n);
              }
            }
          }
        }
        paramResources = PropertyValuesHolder.ofKeyframe(paramString, paramContext);
        paramContext = paramResources;
        if (i == 3)
        {
          paramResources.setEvaluator(ArgbEvaluator.getInstance());
          paramContext = paramResources;
        }
      }
    }
    return paramContext;
  }
  
  private static PropertyValuesHolder[] loadValues(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i;
    int j;
    for (;;)
    {
      i = paramXmlPullParser.getEventType();
      j = 0;
      if ((i == 3) || (i == 1)) {
        break;
      }
      if (i != 2)
      {
        paramXmlPullParser.next();
      }
      else
      {
        if (paramXmlPullParser.getName().equals("propertyValuesHolder"))
        {
          TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
          String str = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "propertyName", 3);
          j = TypedArrayUtils.getNamedInt(localTypedArray, paramXmlPullParser, "valueType", 2, 4);
          Object localObject3 = loadPvh(paramContext, paramResources, paramTheme, paramXmlPullParser, str, j);
          Object localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = getPVH(localTypedArray, j, 0, 1, str);
          }
          localObject3 = localObject2;
          if (localObject4 != null)
          {
            localObject3 = localObject2;
            if (localObject2 == null) {
              localObject3 = new ArrayList();
            }
            ((ArrayList)localObject3).add(localObject4);
          }
          localTypedArray.recycle();
          localObject2 = localObject3;
        }
        paramXmlPullParser.next();
      }
    }
    paramContext = (Context)localObject1;
    if (localObject2 != null)
    {
      i = ((ArrayList)localObject2).size();
      paramResources = new PropertyValuesHolder[i];
      for (;;)
      {
        paramContext = paramResources;
        if (j >= i) {
          break;
        }
        paramResources[j] = ((PropertyValuesHolder)((ArrayList)localObject2).get(j));
        j++;
      }
    }
    return paramContext;
  }
  
  private static void parseAnimatorFromTypeArray(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    long l1 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int i = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    int j = i;
    if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueFrom"))
    {
      j = i;
      if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueTo"))
      {
        int k = i;
        if (i == 4) {
          k = inferValueTypeFromValues(paramTypedArray1, 5, 6);
        }
        PropertyValuesHolder localPropertyValuesHolder = getPVH(paramTypedArray1, k, 5, 6, "");
        j = k;
        if (localPropertyValuesHolder != null)
        {
          paramValueAnimator.setValues(new PropertyValuesHolder[] { localPropertyValuesHolder });
          j = k;
        }
      }
    }
    paramValueAnimator.setDuration(l1);
    paramValueAnimator.setStartDelay(l2);
    paramValueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
    paramValueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
    if (paramTypedArray2 != null) {
      setupObjectAnimator(paramValueAnimator, paramTypedArray2, j, paramFloat, paramXmlPullParser);
    }
  }
  
  private static void setupObjectAnimator(ValueAnimator paramValueAnimator, TypedArray paramTypedArray, int paramInt, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    paramValueAnimator = (ObjectAnimator)paramValueAnimator;
    String str1 = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "pathData", 1);
    if (str1 != null)
    {
      String str2 = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "propertyXName", 2);
      paramXmlPullParser = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "propertyYName", 3);
      if ((paramInt == 2) || ((str2 == null) && (paramXmlPullParser == null)))
      {
        paramValueAnimator = new StringBuilder();
        paramValueAnimator.append(paramTypedArray.getPositionDescription());
        paramValueAnimator.append(" propertyXName or propertyYName is needed for PathData");
        throw new InflateException(paramValueAnimator.toString());
      }
      setupPathMotion(PathParser.createPathFromPathData(str1), paramValueAnimator, paramFloat * 0.5F, str2, paramXmlPullParser);
    }
    else
    {
      paramValueAnimator.setPropertyName(TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "propertyName", 0));
    }
  }
  
  private static void setupPathMotion(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    ArrayList localArrayList = new ArrayList();
    float f1 = 0.0F;
    localArrayList.add(Float.valueOf(0.0F));
    float f2 = 0.0F;
    float f3;
    do
    {
      f3 = f2 + localPathMeasure.getLength();
      localArrayList.add(Float.valueOf(f3));
      f2 = f3;
    } while (localPathMeasure.nextContour());
    paramPath = new PathMeasure(paramPath, false);
    int i = Math.min(100, (int)(f3 / paramFloat) + 1);
    float[] arrayOfFloat1 = new float[i];
    float[] arrayOfFloat2 = new float[i];
    float[] arrayOfFloat3 = new float[2];
    f2 = f3 / (i - 1);
    int j = 0;
    int k = 0;
    paramFloat = f1;
    for (;;)
    {
      localPathMeasure = null;
      if (j >= i) {
        break;
      }
      paramPath.getPosTan(paramFloat - ((Float)localArrayList.get(k)).floatValue(), arrayOfFloat3, null);
      arrayOfFloat1[j] = arrayOfFloat3[0];
      arrayOfFloat2[j] = arrayOfFloat3[1];
      paramFloat += f2;
      int m = k + 1;
      int n = k;
      if (m < localArrayList.size())
      {
        n = k;
        if (paramFloat > ((Float)localArrayList.get(m)).floatValue())
        {
          paramPath.nextContour();
          n = m;
        }
      }
      j++;
      k = n;
    }
    if (paramString1 != null) {
      paramPath = PropertyValuesHolder.ofFloat(paramString1, arrayOfFloat1);
    } else {
      paramPath = null;
    }
    paramString1 = localPathMeasure;
    if (paramString2 != null) {
      paramString1 = PropertyValuesHolder.ofFloat(paramString2, arrayOfFloat2);
    }
    if (paramPath == null) {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramString1 });
    } else if (paramString1 == null) {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath });
    } else {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath, paramString1 });
    }
  }
  
  private static class PathDataEvaluator
    implements TypeEvaluator<PathParser.PathDataNode[]>
  {
    private PathParser.PathDataNode[] mNodeArray;
    
    PathDataEvaluator() {}
    
    PathDataEvaluator(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      this.mNodeArray = paramArrayOfPathDataNode;
    }
    
    public PathParser.PathDataNode[] evaluate(float paramFloat, PathParser.PathDataNode[] paramArrayOfPathDataNode1, PathParser.PathDataNode[] paramArrayOfPathDataNode2)
    {
      if (PathParser.canMorph(paramArrayOfPathDataNode1, paramArrayOfPathDataNode2))
      {
        if (!PathParser.canMorph(this.mNodeArray, paramArrayOfPathDataNode1)) {
          this.mNodeArray = PathParser.deepCopyNodes(paramArrayOfPathDataNode1);
        }
        for (int i = 0; i < paramArrayOfPathDataNode1.length; i++) {
          this.mNodeArray[i].interpolatePathDataNode(paramArrayOfPathDataNode1[i], paramArrayOfPathDataNode2[i], paramFloat);
        }
        return this.mNodeArray;
      }
      throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\vectordrawable\graphics\drawable\AnimatorInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */