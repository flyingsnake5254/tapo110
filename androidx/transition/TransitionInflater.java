package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TransitionInflater
{
  private static final ArrayMap<String, Constructor<?>> CONSTRUCTORS = new ArrayMap();
  private static final Class<?>[] CONSTRUCTOR_SIGNATURE = { Context.class, AttributeSet.class };
  private final Context mContext;
  
  private TransitionInflater(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Object createCustom(AttributeSet paramAttributeSet, Class<?> paramClass, String paramString)
  {
    String str = paramAttributeSet.getAttributeValue(null, "class");
    if (str != null) {
      try
      {
        synchronized (CONSTRUCTORS)
        {
          Constructor localConstructor = (Constructor)???.get(str);
          paramString = localConstructor;
          if (localConstructor == null)
          {
            Class localClass = Class.forName(str, false, this.mContext.getClassLoader()).asSubclass(paramClass);
            paramString = localConstructor;
            if (localClass != null)
            {
              paramString = localClass.getConstructor(CONSTRUCTOR_SIGNATURE);
              paramString.setAccessible(true);
              ???.put(str, paramString);
            }
          }
          paramAttributeSet = paramString.newInstance(new Object[] { this.mContext, paramAttributeSet });
          return paramAttributeSet;
        }
        paramAttributeSet = new StringBuilder();
      }
      catch (Exception paramAttributeSet)
      {
        paramString = new StringBuilder();
        paramString.append("Could not instantiate ");
        paramString.append(paramClass);
        paramString.append(" class ");
        paramString.append(str);
        throw new InflateException(paramString.toString(), paramAttributeSet);
      }
    }
    paramAttributeSet.append(paramString);
    paramAttributeSet.append(" tag must have a 'class' attribute");
    throw new InflateException(paramAttributeSet.toString());
  }
  
  private Transition createTransitionFromXml(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    TransitionSet localTransitionSet;
    if ((paramTransition instanceof TransitionSet)) {
      localTransitionSet = (TransitionSet)paramTransition;
    } else {
      localTransitionSet = null;
    }
    Object localObject1 = null;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label639;
      }
      if (j == 2)
      {
        Object localObject2 = paramXmlPullParser.getName();
        if ("fade".equals(localObject2))
        {
          localObject2 = new Fade(this.mContext, paramAttributeSet);
        }
        else if ("changeBounds".equals(localObject2))
        {
          localObject2 = new ChangeBounds(this.mContext, paramAttributeSet);
        }
        else if ("slide".equals(localObject2))
        {
          localObject2 = new Slide(this.mContext, paramAttributeSet);
        }
        else if ("explode".equals(localObject2))
        {
          localObject2 = new Explode(this.mContext, paramAttributeSet);
        }
        else if ("changeImageTransform".equals(localObject2))
        {
          localObject2 = new ChangeImageTransform(this.mContext, paramAttributeSet);
        }
        else if ("changeTransform".equals(localObject2))
        {
          localObject2 = new ChangeTransform(this.mContext, paramAttributeSet);
        }
        else if ("changeClipBounds".equals(localObject2))
        {
          localObject2 = new ChangeClipBounds(this.mContext, paramAttributeSet);
        }
        else if ("autoTransition".equals(localObject2))
        {
          localObject2 = new AutoTransition(this.mContext, paramAttributeSet);
        }
        else if ("changeScroll".equals(localObject2))
        {
          localObject2 = new ChangeScroll(this.mContext, paramAttributeSet);
        }
        else if ("transitionSet".equals(localObject2))
        {
          localObject2 = new TransitionSet(this.mContext, paramAttributeSet);
        }
        else if ("transition".equals(localObject2))
        {
          localObject2 = (Transition)createCustom(paramAttributeSet, Transition.class, "transition");
        }
        else if ("targets".equals(localObject2))
        {
          getTargetIds(paramXmlPullParser, paramAttributeSet, paramTransition);
          localObject2 = localObject1;
        }
        else if ("arcMotion".equals(localObject2))
        {
          if (paramTransition != null)
          {
            paramTransition.setPathMotion(new ArcMotion(this.mContext, paramAttributeSet));
            localObject2 = localObject1;
          }
          else
          {
            throw new RuntimeException("Invalid use of arcMotion element");
          }
        }
        else if ("pathMotion".equals(localObject2))
        {
          if (paramTransition != null)
          {
            paramTransition.setPathMotion((PathMotion)createCustom(paramAttributeSet, PathMotion.class, "pathMotion"));
            localObject2 = localObject1;
          }
          else
          {
            throw new RuntimeException("Invalid use of pathMotion element");
          }
        }
        else
        {
          if (!"patternPathMotion".equals(localObject2)) {
            break label601;
          }
          if (paramTransition == null) {
            break label591;
          }
          paramTransition.setPathMotion(new PatternPathMotion(this.mContext, paramAttributeSet));
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          if (!paramXmlPullParser.isEmptyElementTag()) {
            createTransitionFromXml(paramXmlPullParser, paramAttributeSet, (Transition)localObject2);
          }
          if (localTransitionSet != null)
          {
            localTransitionSet.addTransition((Transition)localObject2);
            break;
          }
          if (paramTransition != null) {
            break label581;
          }
          localObject1 = localObject2;
        }
      }
    }
    label581:
    throw new InflateException("Could not add transition to another transition.");
    label591:
    throw new RuntimeException("Invalid use of patternPathMotion element");
    label601:
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("Unknown scene name: ");
    paramAttributeSet.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramAttributeSet.toString());
    label639:
    return (Transition)localObject1;
  }
  
  private TransitionManager createTransitionManagerFromXml(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, ViewGroup paramViewGroup)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    TransitionManager localTransitionManager = null;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        break label146;
      }
      if (j == 2)
      {
        String str = paramXmlPullParser.getName();
        if (str.equals("transitionManager"))
        {
          localTransitionManager = new TransitionManager();
        }
        else
        {
          if ((!str.equals("transition")) || (localTransitionManager == null)) {
            break;
          }
          loadTransition(paramAttributeSet, paramXmlPullParser, paramViewGroup, localTransitionManager);
        }
      }
    }
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("Unknown scene name: ");
    paramAttributeSet.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramAttributeSet.toString());
    label146:
    return localTransitionManager;
  }
  
  public static TransitionInflater from(Context paramContext)
  {
    return new TransitionInflater(paramContext);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void getTargetIds(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        return;
      }
      if (j == 2) {
        if (paramXmlPullParser.getName().equals("target"))
        {
          TypedArray localTypedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, Styleable.TRANSITION_TARGET);
          j = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "targetId", 1, 0);
          Object localObject;
          String str;
          if (j != 0)
          {
            paramTransition.addTarget(j);
          }
          else
          {
            j = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "excludeId", 2, 0);
            if (j != 0)
            {
              paramTransition.excludeTarget(j, true);
            }
            else
            {
              localObject = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "targetName", 4);
              if (localObject != null)
              {
                paramTransition.addTarget((String)localObject);
              }
              else
              {
                localObject = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "excludeName", 5);
                if (localObject != null)
                {
                  paramTransition.excludeTarget((String)localObject, true);
                }
                else
                {
                  str = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "excludeClass", 3);
                  if (str != null) {
                    localObject = str;
                  }
                }
              }
            }
          }
          try
          {
            paramTransition.excludeTarget(Class.forName(str), true);
            break label258;
            localObject = str;
            str = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "targetClass", 0);
            if (str != null)
            {
              localObject = str;
              paramTransition.addTarget(Class.forName(str));
            }
            label258:
            localTypedArray.recycle();
          }
          catch (ClassNotFoundException paramXmlPullParser)
          {
            localTypedArray.recycle();
            paramAttributeSet = new StringBuilder();
            paramAttributeSet.append("Could not create ");
            paramAttributeSet.append((String)localObject);
            throw new RuntimeException(paramAttributeSet.toString(), paramXmlPullParser);
          }
        }
      }
    }
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("Unknown scene name: ");
    paramAttributeSet.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramAttributeSet.toString());
  }
  
  @SuppressLint({"RestrictedApi"})
  private void loadTransition(AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser, ViewGroup paramViewGroup, TransitionManager paramTransitionManager)
    throws Resources.NotFoundException
  {
    TypedArray localTypedArray = this.mContext.obtainStyledAttributes(paramAttributeSet, Styleable.TRANSITION_MANAGER);
    int i = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "transition", 2, -1);
    int j = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "fromScene", 0, -1);
    Object localObject = null;
    if (j < 0) {
      paramAttributeSet = null;
    } else {
      paramAttributeSet = Scene.getSceneForLayout(paramViewGroup, j, this.mContext);
    }
    j = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "toScene", 1, -1);
    if (j < 0) {
      paramXmlPullParser = (XmlPullParser)localObject;
    } else {
      paramXmlPullParser = Scene.getSceneForLayout(paramViewGroup, j, this.mContext);
    }
    if (i >= 0)
    {
      paramViewGroup = inflateTransition(i);
      if (paramViewGroup != null) {
        if (paramXmlPullParser != null)
        {
          if (paramAttributeSet == null) {
            paramTransitionManager.setTransition(paramXmlPullParser, paramViewGroup);
          } else {
            paramTransitionManager.setTransition(paramAttributeSet, paramXmlPullParser, paramViewGroup);
          }
        }
        else
        {
          paramAttributeSet = new StringBuilder();
          paramAttributeSet.append("No toScene for transition ID ");
          paramAttributeSet.append(i);
          throw new RuntimeException(paramAttributeSet.toString());
        }
      }
    }
    localTypedArray.recycle();
  }
  
  /* Error */
  public Transition inflateTransition(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	androidx/transition/TransitionInflater:mContext	Landroid/content/Context;
    //   4: invokevirtual 362	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: iload_1
    //   8: invokevirtual 368	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   11: astore_2
    //   12: aload_0
    //   13: aload_2
    //   14: aload_2
    //   15: invokestatic 374	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   18: aconst_null
    //   19: invokespecial 231	androidx/transition/TransitionInflater:createTransitionFromXml	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroidx/transition/Transition;)Landroidx/transition/Transition;
    //   22: astore_3
    //   23: aload_2
    //   24: invokeinterface 379 1 0
    //   29: aload_3
    //   30: areturn
    //   31: astore_3
    //   32: goto +80 -> 112
    //   35: astore 4
    //   37: new 98	android/view/InflateException
    //   40: astore 5
    //   42: new 84	java/lang/StringBuilder
    //   45: astore_3
    //   46: aload_3
    //   47: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   50: aload_3
    //   51: aload_2
    //   52: invokeinterface 382 1 0
    //   57: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: ldc_w 384
    //   65: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: aload 4
    //   72: invokevirtual 387	java/io/IOException:getMessage	()Ljava/lang/String;
    //   75: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: aload_3
    //   82: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aload 4
    //   87: invokespecial 105	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload 5
    //   92: athrow
    //   93: astore_3
    //   94: new 98	android/view/InflateException
    //   97: astore 5
    //   99: aload 5
    //   101: aload_3
    //   102: invokevirtual 388	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   105: aload_3
    //   106: invokespecial 105	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload 5
    //   111: athrow
    //   112: aload_2
    //   113: invokeinterface 379 1 0
    //   118: aload_3
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	TransitionInflater
    //   0	120	1	paramInt	int
    //   11	102	2	localXmlResourceParser	android.content.res.XmlResourceParser
    //   22	8	3	localTransition	Transition
    //   31	1	3	localObject	Object
    //   45	37	3	localStringBuilder	StringBuilder
    //   93	26	3	localXmlPullParserException	XmlPullParserException
    //   35	51	4	localIOException	IOException
    //   40	70	5	localInflateException	InflateException
    // Exception table:
    //   from	to	target	type
    //   12	23	31	finally
    //   37	93	31	finally
    //   94	112	31	finally
    //   12	23	35	java/io/IOException
    //   12	23	93	org/xmlpull/v1/XmlPullParserException
  }
  
  /* Error */
  public TransitionManager inflateTransitionManager(int paramInt, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	androidx/transition/TransitionInflater:mContext	Landroid/content/Context;
    //   4: invokevirtual 362	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: iload_1
    //   8: invokevirtual 368	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   11: astore_3
    //   12: aload_0
    //   13: aload_3
    //   14: aload_3
    //   15: invokestatic 374	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   18: aload_2
    //   19: invokespecial 392	androidx/transition/TransitionInflater:createTransitionManagerFromXml	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/ViewGroup;)Landroidx/transition/TransitionManager;
    //   22: astore_2
    //   23: aload_3
    //   24: invokeinterface 379 1 0
    //   29: aload_2
    //   30: areturn
    //   31: astore_2
    //   32: goto +92 -> 124
    //   35: astore 4
    //   37: new 98	android/view/InflateException
    //   40: astore 5
    //   42: new 84	java/lang/StringBuilder
    //   45: astore_2
    //   46: aload_2
    //   47: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   50: aload_2
    //   51: aload_3
    //   52: invokeinterface 382 1 0
    //   57: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_2
    //   62: ldc_w 384
    //   65: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: aload 4
    //   72: invokevirtual 387	java/io/IOException:getMessage	()Ljava/lang/String;
    //   75: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: aload_2
    //   82: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 110	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   88: aload 5
    //   90: aload 4
    //   92: invokevirtual 396	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   95: pop
    //   96: aload 5
    //   98: athrow
    //   99: astore_2
    //   100: new 98	android/view/InflateException
    //   103: astore 4
    //   105: aload 4
    //   107: aload_2
    //   108: invokevirtual 388	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   111: invokespecial 110	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   114: aload 4
    //   116: aload_2
    //   117: invokevirtual 396	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   120: pop
    //   121: aload 4
    //   123: athrow
    //   124: aload_3
    //   125: invokeinterface 379 1 0
    //   130: aload_2
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	TransitionInflater
    //   0	132	1	paramInt	int
    //   0	132	2	paramViewGroup	ViewGroup
    //   11	114	3	localXmlResourceParser	android.content.res.XmlResourceParser
    //   35	56	4	localIOException	IOException
    //   103	19	4	localInflateException1	InflateException
    //   40	57	5	localInflateException2	InflateException
    // Exception table:
    //   from	to	target	type
    //   12	23	31	finally
    //   37	99	31	finally
    //   100	124	31	finally
    //   12	23	35	java/io/IOException
    //   12	23	99	org/xmlpull/v1/XmlPullParserException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\TransitionInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */