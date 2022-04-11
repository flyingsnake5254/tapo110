package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class NavInflater
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
  private static final String TAG_ACTION = "action";
  private static final String TAG_ARGUMENT = "argument";
  private static final String TAG_DEEP_LINK = "deepLink";
  private static final String TAG_INCLUDE = "include";
  private static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal();
  private Context mContext;
  private NavigatorProvider mNavigatorProvider;
  
  public NavInflater(@NonNull Context paramContext, @NonNull NavigatorProvider paramNavigatorProvider)
  {
    this.mContext = paramContext;
    this.mNavigatorProvider = paramNavigatorProvider;
  }
  
  private static NavType checkNavType(TypedValue paramTypedValue, NavType paramNavType1, NavType paramNavType2, String paramString1, String paramString2)
    throws XmlPullParserException
  {
    if ((paramNavType1 != null) && (paramNavType1 != paramNavType2))
    {
      paramNavType1 = new StringBuilder();
      paramNavType1.append("Type is ");
      paramNavType1.append(paramString1);
      paramNavType1.append(" but found ");
      paramNavType1.append(paramString2);
      paramNavType1.append(": ");
      paramNavType1.append(paramTypedValue.data);
      throw new XmlPullParserException(paramNavType1.toString());
    }
    if (paramNavType1 == null) {
      paramNavType1 = paramNavType2;
    }
    return paramNavType1;
  }
  
  @NonNull
  private NavDestination inflate(@NonNull Resources paramResources, @NonNull XmlResourceParser paramXmlResourceParser, @NonNull AttributeSet paramAttributeSet, int paramInt)
    throws XmlPullParserException, IOException
  {
    NavDestination localNavDestination = this.mNavigatorProvider.getNavigator(paramXmlResourceParser.getName()).createDestination();
    localNavDestination.onInflate(this.mContext, paramAttributeSet);
    int i = paramXmlResourceParser.getDepth() + 1;
    for (;;)
    {
      int j = paramXmlResourceParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlResourceParser.getDepth();
      if ((k < i) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i))
      {
        Object localObject = paramXmlResourceParser.getName();
        if ("argument".equals(localObject))
        {
          inflateArgumentForDestination(paramResources, localNavDestination, paramAttributeSet, paramInt);
        }
        else if ("deepLink".equals(localObject))
        {
          inflateDeepLink(paramResources, localNavDestination, paramAttributeSet);
        }
        else if ("action".equals(localObject))
        {
          inflateAction(paramResources, localNavDestination, paramAttributeSet, paramXmlResourceParser, paramInt);
        }
        else if (("include".equals(localObject)) && ((localNavDestination instanceof NavGraph)))
        {
          localObject = paramResources.obtainAttributes(paramAttributeSet, R.styleable.NavInclude);
          j = ((TypedArray)localObject).getResourceId(R.styleable.NavInclude_graph, 0);
          ((NavGraph)localNavDestination).addDestination(inflate(j));
          ((TypedArray)localObject).recycle();
        }
        else if ((localNavDestination instanceof NavGraph))
        {
          ((NavGraph)localNavDestination).addDestination(inflate(paramResources, paramXmlResourceParser, paramAttributeSet, paramInt));
        }
      }
    }
    return localNavDestination;
  }
  
  private void inflateAction(@NonNull Resources paramResources, @NonNull NavDestination paramNavDestination, @NonNull AttributeSet paramAttributeSet, XmlResourceParser paramXmlResourceParser, int paramInt)
    throws IOException, XmlPullParserException
  {
    TypedArray localTypedArray = paramResources.obtainAttributes(paramAttributeSet, androidx.navigation.common.R.styleable.NavAction);
    int i = localTypedArray.getResourceId(androidx.navigation.common.R.styleable.NavAction_android_id, 0);
    NavAction localNavAction = new NavAction(localTypedArray.getResourceId(androidx.navigation.common.R.styleable.NavAction_destination, 0));
    Object localObject = new NavOptions.Builder();
    ((NavOptions.Builder)localObject).setLaunchSingleTop(localTypedArray.getBoolean(androidx.navigation.common.R.styleable.NavAction_launchSingleTop, false));
    ((NavOptions.Builder)localObject).setPopUpTo(localTypedArray.getResourceId(androidx.navigation.common.R.styleable.NavAction_popUpTo, -1), localTypedArray.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToInclusive, false));
    ((NavOptions.Builder)localObject).setEnterAnim(localTypedArray.getResourceId(androidx.navigation.common.R.styleable.NavAction_enterAnim, -1));
    ((NavOptions.Builder)localObject).setExitAnim(localTypedArray.getResourceId(androidx.navigation.common.R.styleable.NavAction_exitAnim, -1));
    ((NavOptions.Builder)localObject).setPopEnterAnim(localTypedArray.getResourceId(androidx.navigation.common.R.styleable.NavAction_popEnterAnim, -1));
    ((NavOptions.Builder)localObject).setPopExitAnim(localTypedArray.getResourceId(androidx.navigation.common.R.styleable.NavAction_popExitAnim, -1));
    localNavAction.setNavOptions(((NavOptions.Builder)localObject).build());
    localObject = new Bundle();
    int j = paramXmlResourceParser.getDepth() + 1;
    for (;;)
    {
      int k = paramXmlResourceParser.next();
      if (k == 1) {
        break;
      }
      int m = paramXmlResourceParser.getDepth();
      if ((m < j) && (k == 3)) {
        break;
      }
      if ((k == 2) && (m <= j) && ("argument".equals(paramXmlResourceParser.getName()))) {
        inflateArgumentForBundle(paramResources, (Bundle)localObject, paramAttributeSet, paramInt);
      }
    }
    if (!((Bundle)localObject).isEmpty()) {
      localNavAction.setDefaultArguments((Bundle)localObject);
    }
    paramNavDestination.putAction(i, localNavAction);
    localTypedArray.recycle();
  }
  
  @NonNull
  private NavArgument inflateArgument(@NonNull TypedArray paramTypedArray, @NonNull Resources paramResources, int paramInt)
    throws XmlPullParserException
  {
    NavArgument.Builder localBuilder = new NavArgument.Builder();
    int i = androidx.navigation.common.R.styleable.NavArgument_nullable;
    boolean bool = false;
    localBuilder.setIsNullable(paramTypedArray.getBoolean(i, false));
    Object localObject1 = sTmpValue;
    Object localObject2 = (TypedValue)((ThreadLocal)localObject1).get();
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = new TypedValue();
      ((ThreadLocal)localObject1).set(localObject3);
    }
    String str = paramTypedArray.getString(androidx.navigation.common.R.styleable.NavArgument_argType);
    localObject2 = null;
    NavType localNavType;
    if (str != null) {
      localNavType = NavType.fromArgType(str, paramResources.getResourcePackageName(paramInt));
    } else {
      localNavType = null;
    }
    paramInt = androidx.navigation.common.R.styleable.NavArgument_android_defaultValue;
    localObject1 = localNavType;
    if (paramTypedArray.getValue(paramInt, (TypedValue)localObject3))
    {
      localObject1 = NavType.ReferenceType;
      if (localNavType == localObject1)
      {
        paramInt = ((TypedValue)localObject3).resourceId;
        if (paramInt != 0)
        {
          localObject2 = Integer.valueOf(paramInt);
          localObject1 = localNavType;
        }
        else if ((((TypedValue)localObject3).type == 16) && (((TypedValue)localObject3).data == 0))
        {
          localObject2 = Integer.valueOf(0);
          localObject1 = localNavType;
        }
        else
        {
          paramTypedArray = new StringBuilder();
          paramTypedArray.append("unsupported value '");
          paramTypedArray.append(((TypedValue)localObject3).string);
          paramTypedArray.append("' for ");
          paramTypedArray.append(localNavType.getName());
          paramTypedArray.append(". Must be a reference to a resource.");
          throw new XmlPullParserException(paramTypedArray.toString());
        }
      }
      else
      {
        i = ((TypedValue)localObject3).resourceId;
        if (i != 0)
        {
          if (localNavType == null)
          {
            localObject2 = Integer.valueOf(i);
          }
          else
          {
            paramTypedArray = new StringBuilder();
            paramTypedArray.append("unsupported value '");
            paramTypedArray.append(((TypedValue)localObject3).string);
            paramTypedArray.append("' for ");
            paramTypedArray.append(localNavType.getName());
            paramTypedArray.append(". You must use a \"");
            paramTypedArray.append(((NavType)localObject1).getName());
            paramTypedArray.append("\" type to reference other resources.");
            throw new XmlPullParserException(paramTypedArray.toString());
          }
        }
        else if (localNavType == NavType.StringType)
        {
          localObject2 = paramTypedArray.getString(paramInt);
          localObject1 = localNavType;
        }
        else
        {
          paramInt = ((TypedValue)localObject3).type;
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                if (paramInt != 18)
                {
                  if ((paramInt >= 16) && (paramInt <= 31))
                  {
                    localObject1 = checkNavType((TypedValue)localObject3, localNavType, NavType.IntType, str, "integer");
                    localObject2 = Integer.valueOf(((TypedValue)localObject3).data);
                  }
                  else
                  {
                    paramTypedArray = new StringBuilder();
                    paramTypedArray.append("unsupported argument type ");
                    paramTypedArray.append(((TypedValue)localObject3).type);
                    throw new XmlPullParserException(paramTypedArray.toString());
                  }
                }
                else
                {
                  localObject1 = checkNavType((TypedValue)localObject3, localNavType, NavType.BoolType, str, "boolean");
                  if (((TypedValue)localObject3).data != 0) {
                    bool = true;
                  }
                  localObject2 = Boolean.valueOf(bool);
                }
              }
              else
              {
                localObject1 = checkNavType((TypedValue)localObject3, localNavType, NavType.IntType, str, "dimension");
                localObject2 = Integer.valueOf((int)((TypedValue)localObject3).getDimension(paramResources.getDisplayMetrics()));
              }
            }
            else
            {
              localObject1 = checkNavType((TypedValue)localObject3, localNavType, NavType.FloatType, str, "float");
              localObject2 = Float.valueOf(((TypedValue)localObject3).getFloat());
            }
          }
          else
          {
            paramTypedArray = ((TypedValue)localObject3).string.toString();
            localObject1 = localNavType;
            if (localNavType == null) {
              localObject1 = NavType.inferFromValue(paramTypedArray);
            }
            localObject2 = ((NavType)localObject1).parseValue(paramTypedArray);
          }
        }
      }
    }
    if (localObject2 != null) {
      localBuilder.setDefaultValue(localObject2);
    }
    if (localObject1 != null) {
      localBuilder.setType((NavType)localObject1);
    }
    return localBuilder.build();
  }
  
  private void inflateArgumentForBundle(@NonNull Resources paramResources, @NonNull Bundle paramBundle, @NonNull AttributeSet paramAttributeSet, int paramInt)
    throws XmlPullParserException
  {
    TypedArray localTypedArray = paramResources.obtainAttributes(paramAttributeSet, androidx.navigation.common.R.styleable.NavArgument);
    paramAttributeSet = localTypedArray.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
    if (paramAttributeSet != null)
    {
      paramResources = inflateArgument(localTypedArray, paramResources, paramInt);
      if (paramResources.isDefaultValuePresent()) {
        paramResources.putDefaultValue(paramAttributeSet, paramBundle);
      }
      localTypedArray.recycle();
      return;
    }
    throw new XmlPullParserException("Arguments must have a name");
  }
  
  private void inflateArgumentForDestination(@NonNull Resources paramResources, @NonNull NavDestination paramNavDestination, @NonNull AttributeSet paramAttributeSet, int paramInt)
    throws XmlPullParserException
  {
    TypedArray localTypedArray = paramResources.obtainAttributes(paramAttributeSet, androidx.navigation.common.R.styleable.NavArgument);
    paramAttributeSet = localTypedArray.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
    if (paramAttributeSet != null)
    {
      paramNavDestination.addArgument(paramAttributeSet, inflateArgument(localTypedArray, paramResources, paramInt));
      localTypedArray.recycle();
      return;
    }
    throw new XmlPullParserException("Arguments must have a name");
  }
  
  private void inflateDeepLink(@NonNull Resources paramResources, @NonNull NavDestination paramNavDestination, @NonNull AttributeSet paramAttributeSet)
    throws XmlPullParserException
  {
    paramResources = paramResources.obtainAttributes(paramAttributeSet, androidx.navigation.common.R.styleable.NavDeepLink);
    paramAttributeSet = paramResources.getString(androidx.navigation.common.R.styleable.NavDeepLink_uri);
    String str1 = paramResources.getString(androidx.navigation.common.R.styleable.NavDeepLink_action);
    String str2 = paramResources.getString(androidx.navigation.common.R.styleable.NavDeepLink_mimeType);
    if ((TextUtils.isEmpty(paramAttributeSet)) && (TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
      throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
    }
    NavDeepLink.Builder localBuilder = new NavDeepLink.Builder();
    if (paramAttributeSet != null) {
      localBuilder.setUriPattern(paramAttributeSet.replace("${applicationId}", this.mContext.getPackageName()));
    }
    if (!TextUtils.isEmpty(str1)) {
      localBuilder.setAction(str1.replace("${applicationId}", this.mContext.getPackageName()));
    }
    if (str2 != null) {
      localBuilder.setMimeType(str2.replace("${applicationId}", this.mContext.getPackageName()));
    }
    paramNavDestination.addDeepLink(localBuilder.build());
    paramResources.recycle();
  }
  
  /* Error */
  @android.annotation.SuppressLint({"ResourceType"})
  @NonNull
  public NavGraph inflate(@androidx.annotation.NavigationRes int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	androidx/navigation/NavInflater:mContext	Landroid/content/Context;
    //   4: invokevirtual 489	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: astore_2
    //   8: aload_2
    //   9: iload_1
    //   10: invokevirtual 493	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   13: astore_3
    //   14: aload_3
    //   15: invokestatic 499	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   18: astore 4
    //   20: aload_3
    //   21: invokeinterface 117 1 0
    //   26: istore 5
    //   28: iload 5
    //   30: iconst_2
    //   31: if_icmpeq +12 -> 43
    //   34: iload 5
    //   36: iconst_1
    //   37: if_icmpeq +6 -> 43
    //   40: goto -20 -> 20
    //   43: iload 5
    //   45: iconst_2
    //   46: if_icmpne +100 -> 146
    //   49: aload_3
    //   50: invokeinterface 92 1 0
    //   55: astore 6
    //   57: aload_0
    //   58: aload_2
    //   59: aload_3
    //   60: aload 4
    //   62: iload_1
    //   63: invokespecial 170	androidx/navigation/NavInflater:inflate	(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;Landroid/util/AttributeSet;I)Landroidx/navigation/NavDestination;
    //   66: astore 4
    //   68: aload 4
    //   70: instanceof 137
    //   73: ifeq +19 -> 92
    //   76: aload 4
    //   78: checkcast 137	androidx/navigation/NavGraph
    //   81: astore 6
    //   83: aload_3
    //   84: invokeinterface 502 1 0
    //   89: aload 6
    //   91: areturn
    //   92: new 504	java/lang/IllegalArgumentException
    //   95: astore 7
    //   97: new 55	java/lang/StringBuilder
    //   100: astore 4
    //   102: aload 4
    //   104: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   107: aload 4
    //   109: ldc_w 506
    //   112: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: aload 6
    //   120: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 4
    //   126: ldc_w 508
    //   129: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 7
    //   135: aload 4
    //   137: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 509	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   143: aload 7
    //   145: athrow
    //   146: new 53	org/xmlpull/v1/XmlPullParserException
    //   149: astore 6
    //   151: aload 6
    //   153: ldc_w 511
    //   156: invokespecial 82	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   159: aload 6
    //   161: athrow
    //   162: astore_2
    //   163: goto +76 -> 239
    //   166: astore 7
    //   168: new 513	java/lang/RuntimeException
    //   171: astore 6
    //   173: new 55	java/lang/StringBuilder
    //   176: astore 4
    //   178: aload 4
    //   180: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   183: aload 4
    //   185: ldc_w 515
    //   188: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 4
    //   194: aload_2
    //   195: iload_1
    //   196: invokevirtual 518	android/content/res/Resources:getResourceName	(I)Ljava/lang/String;
    //   199: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 4
    //   205: ldc_w 520
    //   208: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 4
    //   214: aload_3
    //   215: invokeinterface 523 1 0
    //   220: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 6
    //   226: aload 4
    //   228: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: aload 7
    //   233: invokespecial 526	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload 6
    //   238: athrow
    //   239: aload_3
    //   240: invokeinterface 502 1 0
    //   245: aload_2
    //   246: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	NavInflater
    //   0	247	1	paramInt	int
    //   7	52	2	localResources	Resources
    //   162	84	2	localObject1	Object
    //   13	227	3	localXmlResourceParser	XmlResourceParser
    //   18	209	4	localObject2	Object
    //   26	21	5	i	int
    //   55	182	6	localObject3	Object
    //   95	49	7	localIllegalArgumentException	IllegalArgumentException
    //   166	66	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   20	28	162	finally
    //   49	83	162	finally
    //   92	146	162	finally
    //   146	162	162	finally
    //   168	239	162	finally
    //   20	28	166	java/lang/Exception
    //   49	83	166	java/lang/Exception
    //   92	146	166	java/lang/Exception
    //   146	162	166	java/lang/Exception
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */