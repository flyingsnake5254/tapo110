package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel
  extends DataSetObservable
{
  static final String ATTRIBUTE_ACTIVITY = "activity";
  static final String ATTRIBUTE_TIME = "time";
  static final String ATTRIBUTE_WEIGHT = "weight";
  static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  static final String TAG_HISTORICAL_RECORD = "historical-record";
  static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
  private static final Object sRegistryLock = new Object();
  private final List<ActivityResolveInfo> mActivities = new ArrayList();
  private OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivitySorter mActivitySorter = new DefaultSorter();
  boolean mCanReadHistoricalData = true;
  final Context mContext;
  private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  final String mHistoryFileName;
  private int mHistoryMaxSize = 50;
  private final Object mInstanceLock = new Object();
  private Intent mIntent;
  private boolean mReadShareHistoryCalled = false;
  private boolean mReloadActivities = false;
  
  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append(".xml");
      this.mHistoryFileName = paramContext.toString();
    }
    else
    {
      this.mHistoryFileName = paramString;
    }
  }
  
  private boolean addHistoricalRecord(HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = this.mHistoricalRecords.add(paramHistoricalRecord);
    if (bool)
    {
      this.mHistoricalRecordsChanged = true;
      pruneExcessiveHistoricalRecordsIfNeeded();
      persistHistoricalDataIfNeeded();
      sortActivitiesIfNeeded();
      notifyChanged();
    }
    return bool;
  }
  
  private void ensureConsistentState()
  {
    boolean bool1 = loadActivitiesIfNeeded();
    boolean bool2 = readHistoricalDataIfNeeded();
    pruneExcessiveHistoricalRecordsIfNeeded();
    if ((bool1 | bool2))
    {
      sortActivitiesIfNeeded();
      notifyChanged();
    }
  }
  
  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    synchronized (sRegistryLock)
    {
      Map localMap = sDataModelRegistry;
      ActivityChooserModel localActivityChooserModel1 = (ActivityChooserModel)localMap.get(paramString);
      ActivityChooserModel localActivityChooserModel2 = localActivityChooserModel1;
      if (localActivityChooserModel1 == null)
      {
        localActivityChooserModel2 = new androidx/appcompat/widget/ActivityChooserModel;
        localActivityChooserModel2.<init>(paramContext, paramString);
        localMap.put(paramString, localActivityChooserModel2);
      }
      return localActivityChooserModel2;
    }
  }
  
  private boolean loadActivitiesIfNeeded()
  {
    boolean bool = this.mReloadActivities;
    int i = 0;
    if ((bool) && (this.mIntent != null))
    {
      this.mReloadActivities = false;
      this.mActivities.clear();
      List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      int j = localList.size();
      while (i < j)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
        this.mActivities.add(new ActivityResolveInfo(localResolveInfo));
        i++;
      }
      return true;
    }
    return false;
  }
  
  private void persistHistoricalDataIfNeeded()
  {
    if (this.mReadShareHistoryCalled)
    {
      if (!this.mHistoricalRecordsChanged) {
        return;
      }
      this.mHistoricalRecordsChanged = false;
      if (!TextUtils.isEmpty(this.mHistoryFileName)) {
        new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(this.mHistoricalRecords), this.mHistoryFileName });
      }
      return;
    }
    throw new IllegalStateException("No preceding call to #readHistoricalData");
  }
  
  private void pruneExcessiveHistoricalRecordsIfNeeded()
  {
    int i = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
    if (i <= 0) {
      return;
    }
    this.mHistoricalRecordsChanged = true;
    for (int j = 0; j < i; j++) {
      HistoricalRecord localHistoricalRecord = (HistoricalRecord)this.mHistoricalRecords.remove(0);
    }
  }
  
  private boolean readHistoricalDataIfNeeded()
  {
    if ((this.mCanReadHistoricalData) && (this.mHistoricalRecordsChanged) && (!TextUtils.isEmpty(this.mHistoryFileName)))
    {
      this.mCanReadHistoricalData = false;
      this.mReadShareHistoryCalled = true;
      readHistoricalDataImpl();
      return true;
    }
    return false;
  }
  
  /* Error */
  private void readHistoricalDataImpl()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 141	androidx/appcompat/widget/ActivityChooserModel:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 165	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   8: invokevirtual 272	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_1
    //   12: invokestatic 278	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_2
    //   16: aload_2
    //   17: aload_1
    //   18: ldc_w 280
    //   21: invokeinterface 286 3 0
    //   26: iconst_0
    //   27: istore_3
    //   28: iload_3
    //   29: iconst_1
    //   30: if_icmpeq +18 -> 48
    //   33: iload_3
    //   34: iconst_2
    //   35: if_icmpeq +13 -> 48
    //   38: aload_2
    //   39: invokeinterface 289 1 0
    //   44: istore_3
    //   45: goto -17 -> 28
    //   48: ldc 61
    //   50: aload_2
    //   51: invokeinterface 292 1 0
    //   56: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +147 -> 206
    //   62: aload_0
    //   63: getfield 120	androidx/appcompat/widget/ActivityChooserModel:mHistoricalRecords	Ljava/util/List;
    //   66: astore 4
    //   68: aload 4
    //   70: invokeinterface 211 1 0
    //   75: aload_2
    //   76: invokeinterface 289 1 0
    //   81: istore_3
    //   82: iload_3
    //   83: iconst_1
    //   84: if_icmpne +14 -> 98
    //   87: aload_1
    //   88: ifnull +240 -> 328
    //   91: aload_1
    //   92: invokevirtual 300	java/io/FileInputStream:close	()V
    //   95: goto +233 -> 328
    //   98: iload_3
    //   99: iconst_3
    //   100: if_icmpeq -25 -> 75
    //   103: iload_3
    //   104: iconst_4
    //   105: if_icmpne +6 -> 111
    //   108: goto -33 -> 75
    //   111: ldc 58
    //   113: aload_2
    //   114: invokeinterface 292 1 0
    //   119: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifeq +71 -> 193
    //   125: aload_2
    //   126: aconst_null
    //   127: ldc 29
    //   129: invokeinterface 304 3 0
    //   134: astore 5
    //   136: aload_2
    //   137: aconst_null
    //   138: ldc 32
    //   140: invokeinterface 304 3 0
    //   145: invokestatic 310	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   148: lstore 6
    //   150: aload_2
    //   151: aconst_null
    //   152: ldc 35
    //   154: invokeinterface 304 3 0
    //   159: invokestatic 316	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   162: fstore 8
    //   164: new 18	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord
    //   167: astore 9
    //   169: aload 9
    //   171: aload 5
    //   173: lload 6
    //   175: fload 8
    //   177: invokespecial 319	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   180: aload 4
    //   182: aload 9
    //   184: invokeinterface 173 2 0
    //   189: pop
    //   190: goto -115 -> 75
    //   193: new 266	org/xmlpull/v1/XmlPullParserException
    //   196: astore_2
    //   197: aload_2
    //   198: ldc_w 321
    //   201: invokespecial 322	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   204: aload_2
    //   205: athrow
    //   206: new 266	org/xmlpull/v1/XmlPullParserException
    //   209: astore_2
    //   210: aload_2
    //   211: ldc_w 324
    //   214: invokespecial 322	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   217: aload_2
    //   218: athrow
    //   219: astore_2
    //   220: goto +109 -> 329
    //   223: astore 5
    //   225: getstatic 96	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   228: astore_2
    //   229: new 155	java/lang/StringBuilder
    //   232: astore 9
    //   234: aload 9
    //   236: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   239: aload 9
    //   241: ldc_w 326
    //   244: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 9
    //   250: aload_0
    //   251: getfield 165	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   254: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_2
    //   259: aload 9
    //   261: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: aload 5
    //   266: invokestatic 332	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   269: pop
    //   270: aload_1
    //   271: ifnull +57 -> 328
    //   274: goto -183 -> 91
    //   277: astore 9
    //   279: getstatic 96	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   282: astore 5
    //   284: new 155	java/lang/StringBuilder
    //   287: astore_2
    //   288: aload_2
    //   289: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   292: aload_2
    //   293: ldc_w 326
    //   296: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_2
    //   301: aload_0
    //   302: getfield 165	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   305: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 5
    //   311: aload_2
    //   312: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: aload 9
    //   317: invokestatic 332	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   320: pop
    //   321: aload_1
    //   322: ifnull +6 -> 328
    //   325: goto -234 -> 91
    //   328: return
    //   329: aload_1
    //   330: ifnull +7 -> 337
    //   333: aload_1
    //   334: invokevirtual 300	java/io/FileInputStream:close	()V
    //   337: aload_2
    //   338: athrow
    //   339: astore_1
    //   340: return
    //   341: astore_1
    //   342: goto -14 -> 328
    //   345: astore_1
    //   346: goto -9 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	ActivityChooserModel
    //   11	323	1	localFileInputStream	java.io.FileInputStream
    //   339	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   341	1	1	localIOException1	java.io.IOException
    //   345	1	1	localIOException2	java.io.IOException
    //   15	203	2	localObject1	Object
    //   219	1	2	localObject2	Object
    //   228	110	2	localObject3	Object
    //   27	79	3	i	int
    //   66	115	4	localList	List
    //   134	38	5	str1	String
    //   223	42	5	localIOException3	java.io.IOException
    //   282	28	5	str2	String
    //   148	26	6	l	long
    //   162	14	8	f	float
    //   167	93	9	localObject4	Object
    //   277	39	9	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    // Exception table:
    //   from	to	target	type
    //   12	26	219	finally
    //   38	45	219	finally
    //   48	75	219	finally
    //   75	82	219	finally
    //   111	190	219	finally
    //   193	206	219	finally
    //   206	219	219	finally
    //   225	270	219	finally
    //   279	321	219	finally
    //   12	26	223	java/io/IOException
    //   38	45	223	java/io/IOException
    //   48	75	223	java/io/IOException
    //   75	82	223	java/io/IOException
    //   111	190	223	java/io/IOException
    //   193	206	223	java/io/IOException
    //   206	219	223	java/io/IOException
    //   12	26	277	org/xmlpull/v1/XmlPullParserException
    //   38	45	277	org/xmlpull/v1/XmlPullParserException
    //   48	75	277	org/xmlpull/v1/XmlPullParserException
    //   75	82	277	org/xmlpull/v1/XmlPullParserException
    //   111	190	277	org/xmlpull/v1/XmlPullParserException
    //   193	206	277	org/xmlpull/v1/XmlPullParserException
    //   206	219	277	org/xmlpull/v1/XmlPullParserException
    //   0	12	339	java/io/FileNotFoundException
    //   91	95	341	java/io/IOException
    //   333	337	345	java/io/IOException
  }
  
  private boolean sortActivitiesIfNeeded()
  {
    if ((this.mActivitySorter != null) && (this.mIntent != null) && (!this.mActivities.isEmpty()) && (!this.mHistoricalRecords.isEmpty()))
    {
      this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
      return true;
    }
    return false;
  }
  
  public Intent chooseActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == null) {
        return null;
      }
      ensureConsistentState();
      Object localObject2 = (ActivityResolveInfo)this.mActivities.get(paramInt);
      ComponentName localComponentName = new android/content/ComponentName;
      localObject2 = ((ActivityResolveInfo)localObject2).resolveInfo.activityInfo;
      localComponentName.<init>(((ActivityInfo)localObject2).packageName, ((ActivityInfo)localObject2).name);
      localObject2 = new android/content/Intent;
      ((Intent)localObject2).<init>(this.mIntent);
      ((Intent)localObject2).setComponent(localComponentName);
      if (this.mActivityChoserModelPolicy != null)
      {
        localObject4 = new android/content/Intent;
        ((Intent)localObject4).<init>((Intent)localObject2);
        if (this.mActivityChoserModelPolicy.onChooseActivity(this, (Intent)localObject4)) {
          return null;
        }
      }
      Object localObject4 = new androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord;
      ((HistoricalRecord)localObject4).<init>(localComponentName, System.currentTimeMillis(), 1.0F);
      addHistoricalRecord((HistoricalRecord)localObject4);
      return (Intent)localObject2;
    }
  }
  
  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivities.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public int getActivityCount()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mActivities.size();
      return i;
    }
  }
  
  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      List localList = this.mActivities;
      int i = localList.size();
      for (int j = 0; j < i; j++) {
        if (((ActivityResolveInfo)localList.get(j)).resolveInfo == paramResolveInfo) {
          return j;
        }
      }
      return -1;
    }
  }
  
  public ResolveInfo getDefaultActivity()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      if (!this.mActivities.isEmpty())
      {
        ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivities.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public int getHistoryMaxSize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoryMaxSize;
      return i;
    }
  }
  
  public int getHistorySize()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mHistoricalRecords.size();
      return i;
    }
  }
  
  public Intent getIntent()
  {
    synchronized (this.mInstanceLock)
    {
      Intent localIntent = this.mIntent;
      return localIntent;
    }
  }
  
  public void setActivitySorter(ActivitySorter paramActivitySorter)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mActivitySorter == paramActivitySorter) {
        return;
      }
      this.mActivitySorter = paramActivitySorter;
      if (sortActivitiesIfNeeded()) {
        notifyChanged();
      }
      return;
    }
  }
  
  public void setDefaultActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      Object localObject2 = (ActivityResolveInfo)this.mActivities.get(paramInt);
      Object localObject3 = (ActivityResolveInfo)this.mActivities.get(0);
      float f;
      if (localObject3 != null) {
        f = ((ActivityResolveInfo)localObject3).weight - ((ActivityResolveInfo)localObject2).weight + 5.0F;
      } else {
        f = 1.0F;
      }
      localObject3 = new android/content/ComponentName;
      localObject2 = ((ActivityResolveInfo)localObject2).resolveInfo.activityInfo;
      ((ComponentName)localObject3).<init>(((ActivityInfo)localObject2).packageName, ((ActivityInfo)localObject2).name);
      localObject2 = new androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord;
      ((HistoricalRecord)localObject2).<init>((ComponentName)localObject3, System.currentTimeMillis(), f);
      addHistoricalRecord((HistoricalRecord)localObject2);
      return;
    }
  }
  
  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mHistoryMaxSize == paramInt) {
        return;
      }
      this.mHistoryMaxSize = paramInt;
      pruneExcessiveHistoricalRecordsIfNeeded();
      if (sortActivitiesIfNeeded()) {
        notifyChanged();
      }
      return;
    }
  }
  
  public void setIntent(Intent paramIntent)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == paramIntent) {
        return;
      }
      this.mIntent = paramIntent;
      this.mReloadActivities = true;
      ensureConsistentState();
      return;
    }
  }
  
  public void setOnChooseActivityListener(OnChooseActivityListener paramOnChooseActivityListener)
  {
    synchronized (this.mInstanceLock)
    {
      this.mActivityChoserModelPolicy = paramOnChooseActivityListener;
      return;
    }
  }
  
  public static abstract interface ActivityChooserModelClient
  {
    public abstract void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel);
  }
  
  public static final class ActivityResolveInfo
    implements Comparable<ActivityResolveInfo>
  {
    public final ResolveInfo resolveInfo;
    public float weight;
    
    public ActivityResolveInfo(ResolveInfo paramResolveInfo)
    {
      this.resolveInfo = paramResolveInfo;
    }
    
    public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
    {
      return Float.floatToIntBits(paramActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject == null) {
        return false;
      }
      if (ActivityResolveInfo.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (ActivityResolveInfo)paramObject;
      return Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo)paramObject).weight);
    }
    
    public int hashCode()
    {
      return Float.floatToIntBits(this.weight) + 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:");
      localStringBuilder.append(this.resolveInfo.toString());
      localStringBuilder.append("; weight:");
      localStringBuilder.append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface ActivitySorter
  {
    public abstract void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1);
  }
  
  private static final class DefaultSorter
    implements ActivityChooserModel.ActivitySorter
  {
    private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
    private final Map<ComponentName, ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();
    
    public void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1)
    {
      paramIntent = this.mPackageNameToActivityMap;
      paramIntent.clear();
      int i = paramList.size();
      ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo;
      Object localObject;
      for (int j = 0; j < i; j++)
      {
        localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)paramList.get(j);
        localActivityResolveInfo.weight = 0.0F;
        localObject = localActivityResolveInfo.resolveInfo.activityInfo;
        paramIntent.put(new ComponentName(((ActivityInfo)localObject).packageName, ((ActivityInfo)localObject).name), localActivityResolveInfo);
      }
      j = paramList1.size() - 1;
      float f2;
      for (float f1 = 1.0F; j >= 0; f1 = f2)
      {
        localObject = (ActivityChooserModel.HistoricalRecord)paramList1.get(j);
        localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)paramIntent.get(((ActivityChooserModel.HistoricalRecord)localObject).activity);
        f2 = f1;
        if (localActivityResolveInfo != null)
        {
          localActivityResolveInfo.weight += ((ActivityChooserModel.HistoricalRecord)localObject).weight * f1;
          f2 = f1 * 0.95F;
        }
        j--;
      }
      Collections.sort(paramList);
    }
  }
  
  public static final class HistoricalRecord
  {
    public final ComponentName activity;
    public final long time;
    public final float weight;
    
    public HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.activity = paramComponentName;
      this.time = paramLong;
      this.weight = paramFloat;
    }
    
    public HistoricalRecord(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject == null) {
        return false;
      }
      if (HistoricalRecord.class != paramObject.getClass()) {
        return false;
      }
      HistoricalRecord localHistoricalRecord = (HistoricalRecord)paramObject;
      paramObject = this.activity;
      if (paramObject == null)
      {
        if (localHistoricalRecord.activity != null) {
          return false;
        }
      }
      else if (!((ComponentName)paramObject).equals(localHistoricalRecord.activity)) {
        return false;
      }
      if (this.time != localHistoricalRecord.time) {
        return false;
      }
      return Float.floatToIntBits(this.weight) == Float.floatToIntBits(localHistoricalRecord.weight);
    }
    
    public int hashCode()
    {
      ComponentName localComponentName = this.activity;
      int i;
      if (localComponentName == null) {
        i = 0;
      } else {
        i = localComponentName.hashCode();
      }
      long l = this.time;
      return ((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.weight);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:");
      localStringBuilder.append(this.activity);
      localStringBuilder.append("; time:");
      localStringBuilder.append(this.time);
      localStringBuilder.append("; weight:");
      localStringBuilder.append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface OnChooseActivityListener
  {
    public abstract boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent);
  }
  
  private final class PersistHistoryAsyncTask
    extends AsyncTask<Object, Void, Void>
  {
    PersistHistoryAsyncTask() {}
    
    /* Error */
    public Void doInBackground(Object... paramVarArgs)
    {
      // Byte code:
      //   0: aload_1
      //   1: iconst_0
      //   2: aaload
      //   3: checkcast 33	java/util/List
      //   6: astore_2
      //   7: aload_1
      //   8: iconst_1
      //   9: aaload
      //   10: checkcast 35	java/lang/String
      //   13: astore_3
      //   14: aload_0
      //   15: getfield 14	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
      //   18: getfield 39	androidx/appcompat/widget/ActivityChooserModel:mContext	Landroid/content/Context;
      //   21: aload_3
      //   22: iconst_0
      //   23: invokevirtual 45	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   26: astore_1
      //   27: invokestatic 51	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
      //   30: astore 4
      //   32: aload 4
      //   34: aload_1
      //   35: aconst_null
      //   36: invokeinterface 57 3 0
      //   41: aload 4
      //   43: ldc 59
      //   45: getstatic 65	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   48: invokeinterface 69 3 0
      //   53: aload 4
      //   55: aconst_null
      //   56: ldc 71
      //   58: invokeinterface 75 3 0
      //   63: pop
      //   64: aload_2
      //   65: invokeinterface 79 1 0
      //   70: istore 5
      //   72: iconst_0
      //   73: istore 6
      //   75: iload 6
      //   77: iload 5
      //   79: if_icmpge +96 -> 175
      //   82: aload_2
      //   83: iconst_0
      //   84: invokeinterface 83 2 0
      //   89: checkcast 85	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord
      //   92: astore_3
      //   93: aload 4
      //   95: aconst_null
      //   96: ldc 87
      //   98: invokeinterface 75 3 0
      //   103: pop
      //   104: aload 4
      //   106: aconst_null
      //   107: ldc 89
      //   109: aload_3
      //   110: getfield 92	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord:activity	Landroid/content/ComponentName;
      //   113: invokevirtual 98	android/content/ComponentName:flattenToString	()Ljava/lang/String;
      //   116: invokeinterface 102 4 0
      //   121: pop
      //   122: aload 4
      //   124: aconst_null
      //   125: ldc 104
      //   127: aload_3
      //   128: getfield 107	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord:time	J
      //   131: invokestatic 111	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   134: invokeinterface 102 4 0
      //   139: pop
      //   140: aload 4
      //   142: aconst_null
      //   143: ldc 113
      //   145: aload_3
      //   146: getfield 116	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord:weight	F
      //   149: invokestatic 119	java/lang/String:valueOf	(F)Ljava/lang/String;
      //   152: invokeinterface 102 4 0
      //   157: pop
      //   158: aload 4
      //   160: aconst_null
      //   161: ldc 87
      //   163: invokeinterface 122 3 0
      //   168: pop
      //   169: iinc 6 1
      //   172: goto -97 -> 75
      //   175: aload 4
      //   177: aconst_null
      //   178: ldc 71
      //   180: invokeinterface 122 3 0
      //   185: pop
      //   186: aload 4
      //   188: invokeinterface 125 1 0
      //   193: aload_0
      //   194: getfield 14	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
      //   197: iconst_1
      //   198: putfield 129	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   201: aload_1
      //   202: ifnull +191 -> 393
      //   205: aload_1
      //   206: invokevirtual 134	java/io/FileOutputStream:close	()V
      //   209: goto +184 -> 393
      //   212: astore_3
      //   213: goto +182 -> 395
      //   216: astore_2
      //   217: getstatic 138	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
      //   220: astore 4
      //   222: new 140	java/lang/StringBuilder
      //   225: astore_3
      //   226: aload_3
      //   227: invokespecial 141	java/lang/StringBuilder:<init>	()V
      //   230: aload_3
      //   231: ldc -113
      //   233: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   236: pop
      //   237: aload_3
      //   238: aload_0
      //   239: getfield 14	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
      //   242: getfield 150	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
      //   245: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   248: pop
      //   249: aload 4
      //   251: aload_3
      //   252: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   255: aload_2
      //   256: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   259: pop
      //   260: aload_0
      //   261: getfield 14	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
      //   264: iconst_1
      //   265: putfield 129	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   268: aload_1
      //   269: ifnull +124 -> 393
      //   272: goto -67 -> 205
      //   275: astore_3
      //   276: getstatic 138	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
      //   279: astore 4
      //   281: new 140	java/lang/StringBuilder
      //   284: astore_2
      //   285: aload_2
      //   286: invokespecial 141	java/lang/StringBuilder:<init>	()V
      //   289: aload_2
      //   290: ldc -113
      //   292: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   295: pop
      //   296: aload_2
      //   297: aload_0
      //   298: getfield 14	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
      //   301: getfield 150	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
      //   304: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   307: pop
      //   308: aload 4
      //   310: aload_2
      //   311: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   314: aload_3
      //   315: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   318: pop
      //   319: aload_0
      //   320: getfield 14	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
      //   323: iconst_1
      //   324: putfield 129	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   327: aload_1
      //   328: ifnull +65 -> 393
      //   331: goto -126 -> 205
      //   334: astore_2
      //   335: getstatic 138	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
      //   338: astore 4
      //   340: new 140	java/lang/StringBuilder
      //   343: astore_3
      //   344: aload_3
      //   345: invokespecial 141	java/lang/StringBuilder:<init>	()V
      //   348: aload_3
      //   349: ldc -113
      //   351: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   354: pop
      //   355: aload_3
      //   356: aload_0
      //   357: getfield 14	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
      //   360: getfield 150	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
      //   363: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   366: pop
      //   367: aload 4
      //   369: aload_3
      //   370: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   373: aload_2
      //   374: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   377: pop
      //   378: aload_0
      //   379: getfield 14	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
      //   382: iconst_1
      //   383: putfield 129	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   386: aload_1
      //   387: ifnull +6 -> 393
      //   390: goto -185 -> 205
      //   393: aconst_null
      //   394: areturn
      //   395: aload_0
      //   396: getfield 14	androidx/appcompat/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroidx/appcompat/widget/ActivityChooserModel;
      //   399: iconst_1
      //   400: putfield 129	androidx/appcompat/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   403: aload_1
      //   404: ifnull +7 -> 411
      //   407: aload_1
      //   408: invokevirtual 134	java/io/FileOutputStream:close	()V
      //   411: aload_3
      //   412: athrow
      //   413: astore_2
      //   414: getstatic 138	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
      //   417: astore_1
      //   418: new 140	java/lang/StringBuilder
      //   421: dup
      //   422: invokespecial 141	java/lang/StringBuilder:<init>	()V
      //   425: astore 4
      //   427: aload 4
      //   429: ldc -113
      //   431: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   434: pop
      //   435: aload 4
      //   437: aload_3
      //   438: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   441: pop
      //   442: aload_1
      //   443: aload 4
      //   445: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   448: aload_2
      //   449: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   452: pop
      //   453: aconst_null
      //   454: areturn
      //   455: astore_1
      //   456: goto -63 -> 393
      //   459: astore_1
      //   460: goto -49 -> 411
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	463	0	this	PersistHistoryAsyncTask
      //   0	463	1	paramVarArgs	Object[]
      //   6	77	2	localList	List
      //   216	40	2	localIOException	java.io.IOException
      //   284	27	2	localStringBuilder1	StringBuilder
      //   334	40	2	localIllegalArgumentException	IllegalArgumentException
      //   413	36	2	localFileNotFoundException	java.io.FileNotFoundException
      //   13	133	3	localObject1	Object
      //   212	1	3	localObject2	Object
      //   225	27	3	localStringBuilder2	StringBuilder
      //   275	40	3	localIllegalStateException	IllegalStateException
      //   343	95	3	localStringBuilder3	StringBuilder
      //   30	414	4	localObject3	Object
      //   70	10	5	i	int
      //   73	97	6	j	int
      // Exception table:
      //   from	to	target	type
      //   32	72	212	finally
      //   82	169	212	finally
      //   175	193	212	finally
      //   217	260	212	finally
      //   276	319	212	finally
      //   335	378	212	finally
      //   32	72	216	java/io/IOException
      //   82	169	216	java/io/IOException
      //   175	193	216	java/io/IOException
      //   32	72	275	java/lang/IllegalStateException
      //   82	169	275	java/lang/IllegalStateException
      //   175	193	275	java/lang/IllegalStateException
      //   32	72	334	java/lang/IllegalArgumentException
      //   82	169	334	java/lang/IllegalArgumentException
      //   175	193	334	java/lang/IllegalArgumentException
      //   14	27	413	java/io/FileNotFoundException
      //   205	209	455	java/io/IOException
      //   407	411	459	java/io/IOException
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ActivityChooserModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */