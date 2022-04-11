package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public class InvalidationTracker
{
  private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
  private static final String INVALIDATED_COLUMN_NAME = "invalidated";
  @VisibleForTesting
  static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";
  @VisibleForTesting
  static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
  private static final String TABLE_ID_COLUMN_NAME = "table_id";
  private static final String[] TRIGGERS = { "UPDATE", "DELETE", "INSERT" };
  private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
  volatile SupportSQLiteStatement mCleanupStatement;
  final RoomDatabase mDatabase;
  private volatile boolean mInitialized;
  private final InvalidationLiveDataContainer mInvalidationLiveDataContainer;
  private MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
  private ObservedTableTracker mObservedTableTracker;
  @SuppressLint({"RestrictedApi"})
  @VisibleForTesting
  final SafeIterableMap<Observer, ObserverWrapper> mObserverMap;
  AtomicBoolean mPendingRefresh;
  @VisibleForTesting
  Runnable mRefreshRunnable;
  @NonNull
  final HashMap<String, Integer> mTableIdLookup;
  final String[] mTableNames;
  @NonNull
  private Map<String, Set<String>> mViewTables;
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public InvalidationTracker(RoomDatabase paramRoomDatabase, Map<String, String> paramMap, Map<String, Set<String>> paramMap1, String... paramVarArgs)
  {
    int i = 0;
    this.mPendingRefresh = new AtomicBoolean(false);
    this.mInitialized = false;
    this.mObserverMap = new SafeIterableMap();
    this.mRefreshRunnable = new Runnable()
    {
      private Set<Integer> checkUpdatedTable()
      {
        HashSet localHashSet = new HashSet();
        Cursor localCursor = InvalidationTracker.this.mDatabase.query(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
        try
        {
          while (localCursor.moveToNext()) {
            localHashSet.add(Integer.valueOf(localCursor.getInt(0)));
          }
          localCursor.close();
          if (!localHashSet.isEmpty()) {
            InvalidationTracker.this.mCleanupStatement.executeUpdateDelete();
          }
          return localHashSet;
        }
        finally
        {
          localCursor.close();
        }
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 14	androidx/room/InvalidationTracker$1:this$0	Landroidx/room/InvalidationTracker;
        //   4: getfield 27	androidx/room/InvalidationTracker:mDatabase	Landroidx/room/RoomDatabase;
        //   7: invokevirtual 87	androidx/room/RoomDatabase:getCloseLock	()Ljava/util/concurrent/locks/Lock;
        //   10: astore_1
        //   11: aconst_null
        //   12: astore_2
        //   13: aconst_null
        //   14: astore_3
        //   15: aconst_null
        //   16: astore 4
        //   18: aload_2
        //   19: astore 5
        //   21: aload_3
        //   22: astore 6
        //   24: aload_1
        //   25: invokeinterface 92 1 0
        //   30: aload_2
        //   31: astore 5
        //   33: aload_3
        //   34: astore 6
        //   36: aload_0
        //   37: getfield 14	androidx/room/InvalidationTracker$1:this$0	Landroidx/room/InvalidationTracker;
        //   40: invokevirtual 95	androidx/room/InvalidationTracker:ensureInitialization	()Z
        //   43: istore 7
        //   45: iload 7
        //   47: ifne +10 -> 57
        //   50: aload_1
        //   51: invokeinterface 98 1 0
        //   56: return
        //   57: aload_2
        //   58: astore 5
        //   60: aload_3
        //   61: astore 6
        //   63: aload_0
        //   64: getfield 14	androidx/room/InvalidationTracker$1:this$0	Landroidx/room/InvalidationTracker;
        //   67: getfield 102	androidx/room/InvalidationTracker:mPendingRefresh	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   70: iconst_1
        //   71: iconst_0
        //   72: invokevirtual 108	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
        //   75: istore 7
        //   77: iload 7
        //   79: ifne +10 -> 89
        //   82: aload_1
        //   83: invokeinterface 98 1 0
        //   88: return
        //   89: aload_2
        //   90: astore 5
        //   92: aload_3
        //   93: astore 6
        //   95: aload_0
        //   96: getfield 14	androidx/room/InvalidationTracker$1:this$0	Landroidx/room/InvalidationTracker;
        //   99: getfield 27	androidx/room/InvalidationTracker:mDatabase	Landroidx/room/RoomDatabase;
        //   102: invokevirtual 111	androidx/room/RoomDatabase:inTransaction	()Z
        //   105: istore 7
        //   107: iload 7
        //   109: ifeq +10 -> 119
        //   112: aload_1
        //   113: invokeinterface 98 1 0
        //   118: return
        //   119: aload_2
        //   120: astore 5
        //   122: aload_3
        //   123: astore 6
        //   125: aload_0
        //   126: getfield 14	androidx/room/InvalidationTracker$1:this$0	Landroidx/room/InvalidationTracker;
        //   129: getfield 27	androidx/room/InvalidationTracker:mDatabase	Landroidx/room/RoomDatabase;
        //   132: astore 8
        //   134: aload_2
        //   135: astore 5
        //   137: aload_3
        //   138: astore 6
        //   140: aload 8
        //   142: getfield 115	androidx/room/RoomDatabase:mWriteAheadLoggingEnabled	Z
        //   145: ifeq +94 -> 239
        //   148: aload_2
        //   149: astore 5
        //   151: aload_3
        //   152: astore 6
        //   154: aload 8
        //   156: invokevirtual 119	androidx/room/RoomDatabase:getOpenHelper	()Landroidx/sqlite/db/SupportSQLiteOpenHelper;
        //   159: invokeinterface 125 1 0
        //   164: astore 8
        //   166: aload_2
        //   167: astore 5
        //   169: aload_3
        //   170: astore 6
        //   172: aload 8
        //   174: invokeinterface 130 1 0
        //   179: aload_0
        //   180: invokespecial 132	androidx/room/InvalidationTracker$1:checkUpdatedTable	()Ljava/util/Set;
        //   183: astore_2
        //   184: aload_2
        //   185: astore 4
        //   187: aload 8
        //   189: invokeinterface 135 1 0
        //   194: aload_2
        //   195: astore 5
        //   197: aload_2
        //   198: astore 6
        //   200: aload 8
        //   202: invokeinterface 138 1 0
        //   207: aload_2
        //   208: astore 6
        //   210: goto +74 -> 284
        //   213: astore_2
        //   214: aload 4
        //   216: astore 5
        //   218: aload 4
        //   220: astore 6
        //   222: aload 8
        //   224: invokeinterface 138 1 0
        //   229: aload 4
        //   231: astore 5
        //   233: aload 4
        //   235: astore 6
        //   237: aload_2
        //   238: athrow
        //   239: aload_2
        //   240: astore 5
        //   242: aload_3
        //   243: astore 6
        //   245: aload_0
        //   246: invokespecial 132	androidx/room/InvalidationTracker$1:checkUpdatedTable	()Ljava/util/Set;
        //   249: astore 4
        //   251: aload 4
        //   253: astore 6
        //   255: goto +29 -> 284
        //   258: astore 6
        //   260: goto +120 -> 380
        //   263: astore 4
        //   265: aload 5
        //   267: astore 6
        //   269: goto +5 -> 274
        //   272: astore 4
        //   274: ldc -116
        //   276: ldc -114
        //   278: aload 4
        //   280: invokestatic 148	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   283: pop
        //   284: aload_1
        //   285: invokeinterface 98 1 0
        //   290: aload 6
        //   292: ifnull +87 -> 379
        //   295: aload 6
        //   297: invokeinterface 151 1 0
        //   302: ifne +77 -> 379
        //   305: aload_0
        //   306: getfield 14	androidx/room/InvalidationTracker$1:this$0	Landroidx/room/InvalidationTracker;
        //   309: getfield 155	androidx/room/InvalidationTracker:mObserverMap	Landroidx/arch/core/internal/SafeIterableMap;
        //   312: astore 5
        //   314: aload 5
        //   316: monitorenter
        //   317: aload_0
        //   318: getfield 14	androidx/room/InvalidationTracker$1:this$0	Landroidx/room/InvalidationTracker;
        //   321: getfield 155	androidx/room/InvalidationTracker:mObserverMap	Landroidx/arch/core/internal/SafeIterableMap;
        //   324: invokevirtual 161	androidx/arch/core/internal/SafeIterableMap:iterator	()Ljava/util/Iterator;
        //   327: astore 4
        //   329: aload 4
        //   331: invokeinterface 166 1 0
        //   336: ifeq +29 -> 365
        //   339: aload 4
        //   341: invokeinterface 170 1 0
        //   346: checkcast 172	java/util/Map$Entry
        //   349: invokeinterface 175 1 0
        //   354: checkcast 177	androidx/room/InvalidationTracker$ObserverWrapper
        //   357: aload 6
        //   359: invokevirtual 181	androidx/room/InvalidationTracker$ObserverWrapper:notifyByTableInvalidStatus	(Ljava/util/Set;)V
        //   362: goto -33 -> 329
        //   365: aload 5
        //   367: monitorexit
        //   368: goto +11 -> 379
        //   371: astore 6
        //   373: aload 5
        //   375: monitorexit
        //   376: aload 6
        //   378: athrow
        //   379: return
        //   380: aload_1
        //   381: invokeinterface 98 1 0
        //   386: aload 6
        //   388: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	389	0	this	1
        //   10	371	1	localLock	Lock
        //   12	196	2	localSet1	Set
        //   213	27	2	localObject1	Object
        //   14	229	3	localObject2	Object
        //   16	236	4	localSet2	Set
        //   263	1	4	localSQLiteException	SQLiteException
        //   272	7	4	localIllegalStateException	IllegalStateException
        //   327	13	4	localIterator	Iterator
        //   19	355	5	localObject3	Object
        //   22	232	6	localObject4	Object
        //   258	1	6	localObject5	Object
        //   267	91	6	localObject6	Object
        //   371	16	6	localObject7	Object
        //   43	65	7	bool	boolean
        //   132	91	8	localObject8	Object
        // Exception table:
        //   from	to	target	type
        //   179	184	213	finally
        //   187	194	213	finally
        //   24	30	258	finally
        //   36	45	258	finally
        //   63	77	258	finally
        //   95	107	258	finally
        //   125	134	258	finally
        //   140	148	258	finally
        //   154	166	258	finally
        //   172	179	258	finally
        //   200	207	258	finally
        //   222	229	258	finally
        //   237	239	258	finally
        //   245	251	258	finally
        //   274	284	258	finally
        //   24	30	263	android/database/sqlite/SQLiteException
        //   36	45	263	android/database/sqlite/SQLiteException
        //   63	77	263	android/database/sqlite/SQLiteException
        //   95	107	263	android/database/sqlite/SQLiteException
        //   125	134	263	android/database/sqlite/SQLiteException
        //   140	148	263	android/database/sqlite/SQLiteException
        //   154	166	263	android/database/sqlite/SQLiteException
        //   172	179	263	android/database/sqlite/SQLiteException
        //   200	207	263	android/database/sqlite/SQLiteException
        //   222	229	263	android/database/sqlite/SQLiteException
        //   237	239	263	android/database/sqlite/SQLiteException
        //   245	251	263	android/database/sqlite/SQLiteException
        //   24	30	272	java/lang/IllegalStateException
        //   36	45	272	java/lang/IllegalStateException
        //   63	77	272	java/lang/IllegalStateException
        //   95	107	272	java/lang/IllegalStateException
        //   125	134	272	java/lang/IllegalStateException
        //   140	148	272	java/lang/IllegalStateException
        //   154	166	272	java/lang/IllegalStateException
        //   172	179	272	java/lang/IllegalStateException
        //   200	207	272	java/lang/IllegalStateException
        //   222	229	272	java/lang/IllegalStateException
        //   237	239	272	java/lang/IllegalStateException
        //   245	251	272	java/lang/IllegalStateException
        //   317	329	371	finally
        //   329	362	371	finally
        //   365	368	371	finally
        //   373	376	371	finally
      }
    };
    this.mDatabase = paramRoomDatabase;
    this.mObservedTableTracker = new ObservedTableTracker(paramVarArgs.length);
    this.mTableIdLookup = new HashMap();
    this.mViewTables = paramMap1;
    this.mInvalidationLiveDataContainer = new InvalidationLiveDataContainer(paramRoomDatabase);
    int j = paramVarArgs.length;
    this.mTableNames = new String[j];
    while (i < j)
    {
      paramMap1 = paramVarArgs[i];
      paramRoomDatabase = Locale.US;
      String str = paramMap1.toLowerCase(paramRoomDatabase);
      this.mTableIdLookup.put(str, Integer.valueOf(i));
      paramMap1 = (String)paramMap.get(paramVarArgs[i]);
      if (paramMap1 != null) {
        this.mTableNames[i] = paramMap1.toLowerCase(paramRoomDatabase);
      } else {
        this.mTableNames[i] = str;
      }
      i++;
    }
    paramRoomDatabase = paramMap.entrySet().iterator();
    while (paramRoomDatabase.hasNext())
    {
      paramMap1 = (Map.Entry)paramRoomDatabase.next();
      paramMap = (String)paramMap1.getValue();
      paramVarArgs = Locale.US;
      paramMap = paramMap.toLowerCase(paramVarArgs);
      if (this.mTableIdLookup.containsKey(paramMap))
      {
        paramMap1 = ((String)paramMap1.getKey()).toLowerCase(paramVarArgs);
        paramVarArgs = this.mTableIdLookup;
        paramVarArgs.put(paramMap1, paramVarArgs.get(paramMap));
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public InvalidationTracker(RoomDatabase paramRoomDatabase, String... paramVarArgs)
  {
    this(paramRoomDatabase, new HashMap(), Collections.emptyMap(), paramVarArgs);
  }
  
  private static void appendTriggerName(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("`");
    paramStringBuilder.append("room_table_modification_trigger_");
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append("_");
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append("`");
  }
  
  private String[] resolveViews(String[] paramArrayOfString)
  {
    HashSet localHashSet = new HashSet();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str1 = paramArrayOfString[j];
      String str2 = str1.toLowerCase(Locale.US);
      if (this.mViewTables.containsKey(str2)) {
        localHashSet.addAll((Collection)this.mViewTables.get(str2));
      } else {
        localHashSet.add(str1);
      }
    }
    return (String[])localHashSet.toArray(new String[localHashSet.size()]);
  }
  
  private void startTrackingTable(SupportSQLiteDatabase paramSupportSQLiteDatabase, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INSERT OR IGNORE INTO room_table_modification_log VALUES(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", 0)");
    paramSupportSQLiteDatabase.execSQL(localStringBuilder.toString());
    String str1 = this.mTableNames[paramInt];
    localStringBuilder = new StringBuilder();
    for (String str2 : TRIGGERS)
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
      appendTriggerName(localStringBuilder, str1, str2);
      localStringBuilder.append(" AFTER ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" ON `");
      localStringBuilder.append(str1);
      localStringBuilder.append("` BEGIN UPDATE ");
      localStringBuilder.append("room_table_modification_log");
      localStringBuilder.append(" SET ");
      localStringBuilder.append("invalidated");
      localStringBuilder.append(" = 1");
      localStringBuilder.append(" WHERE ");
      localStringBuilder.append("table_id");
      localStringBuilder.append(" = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" AND ");
      localStringBuilder.append("invalidated");
      localStringBuilder.append(" = 0");
      localStringBuilder.append("; END");
      paramSupportSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }
  
  private void stopTrackingTable(SupportSQLiteDatabase paramSupportSQLiteDatabase, int paramInt)
  {
    String str1 = this.mTableNames[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
    for (String str2 : TRIGGERS)
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append("DROP TRIGGER IF EXISTS ");
      appendTriggerName(localStringBuilder, str1, str2);
      paramSupportSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
  }
  
  private String[] validateAndResolveTableNames(String[] paramArrayOfString)
  {
    Object localObject = resolveViews(paramArrayOfString);
    int i = localObject.length;
    int j = 0;
    while (j < i)
    {
      paramArrayOfString = localObject[j];
      if (this.mTableIdLookup.containsKey(paramArrayOfString.toLowerCase(Locale.US)))
      {
        j++;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("There is no table with name ");
        ((StringBuilder)localObject).append(paramArrayOfString);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    return (String[])localObject;
  }
  
  @SuppressLint({"RestrictedApi"})
  @WorkerThread
  public void addObserver(@NonNull Observer paramObserver)
  {
    ??? = resolveViews(paramObserver.mTables);
    int[] arrayOfInt = new int[???.length];
    int i = ???.length;
    int j = 0;
    while (j < i)
    {
      localObject2 = (Integer)this.mTableIdLookup.get(???[j].toLowerCase(Locale.US));
      if (localObject2 != null)
      {
        arrayOfInt[j] = ((Integer)localObject2).intValue();
        j++;
      }
      else
      {
        paramObserver = new StringBuilder();
        paramObserver.append("There is no table with name ");
        paramObserver.append(???[j]);
        throw new IllegalArgumentException(paramObserver.toString());
      }
    }
    Object localObject2 = new ObserverWrapper(paramObserver, arrayOfInt, (String[])???);
    synchronized (this.mObserverMap)
    {
      paramObserver = (ObserverWrapper)this.mObserverMap.putIfAbsent(paramObserver, localObject2);
      if ((paramObserver == null) && (this.mObservedTableTracker.onAdded(arrayOfInt))) {
        syncTriggers();
      }
      return;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void addWeakObserver(Observer paramObserver)
  {
    addObserver(new WeakObserver(this, paramObserver));
  }
  
  @Deprecated
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public <T> LiveData<T> createLiveData(String[] paramArrayOfString, Callable<T> paramCallable)
  {
    return createLiveData(paramArrayOfString, false, paramCallable);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public <T> LiveData<T> createLiveData(String[] paramArrayOfString, boolean paramBoolean, Callable<T> paramCallable)
  {
    return this.mInvalidationLiveDataContainer.create(validateAndResolveTableNames(paramArrayOfString), paramBoolean, paramCallable);
  }
  
  boolean ensureInitialization()
  {
    if (!this.mDatabase.isOpen()) {
      return false;
    }
    if (!this.mInitialized) {
      this.mDatabase.getOpenHelper().getWritableDatabase();
    }
    if (!this.mInitialized)
    {
      Log.e("ROOM", "database is not initialized even though it is open");
      return false;
    }
    return true;
  }
  
  void internalInit(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    try
    {
      if (this.mInitialized)
      {
        Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
        return;
      }
      paramSupportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
      paramSupportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
      paramSupportSQLiteDatabase.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
      syncTriggers(paramSupportSQLiteDatabase);
      this.mCleanupStatement = paramSupportSQLiteDatabase.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
      this.mInitialized = true;
      return;
    }
    finally {}
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  @VisibleForTesting(otherwise=3)
  public void notifyObserversByTableNames(String... paramVarArgs)
  {
    synchronized (this.mObserverMap)
    {
      Iterator localIterator = this.mObserverMap.iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!((Observer)localEntry.getKey()).isRemote()) {
          ((ObserverWrapper)localEntry.getValue()).notifyByTableNames(paramVarArgs);
        }
      }
      return;
    }
  }
  
  public void refreshVersionsAsync()
  {
    if (this.mPendingRefresh.compareAndSet(false, true)) {
      this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @WorkerThread
  public void refreshVersionsSync()
  {
    syncTriggers();
    this.mRefreshRunnable.run();
  }
  
  @SuppressLint({"RestrictedApi"})
  @WorkerThread
  public void removeObserver(@NonNull Observer paramObserver)
  {
    synchronized (this.mObserverMap)
    {
      paramObserver = (ObserverWrapper)this.mObserverMap.remove(paramObserver);
      if ((paramObserver != null) && (this.mObservedTableTracker.onRemoved(paramObserver.mTableIds))) {
        syncTriggers();
      }
      return;
    }
  }
  
  void startMultiInstanceInvalidation(Context paramContext, String paramString)
  {
    this.mMultiInstanceInvalidationClient = new MultiInstanceInvalidationClient(paramContext, paramString, this, this.mDatabase.getQueryExecutor());
  }
  
  void stopMultiInstanceInvalidation()
  {
    MultiInstanceInvalidationClient localMultiInstanceInvalidationClient = this.mMultiInstanceInvalidationClient;
    if (localMultiInstanceInvalidationClient != null)
    {
      localMultiInstanceInvalidationClient.stop();
      this.mMultiInstanceInvalidationClient = null;
    }
  }
  
  void syncTriggers()
  {
    if (!this.mDatabase.isOpen()) {
      return;
    }
    syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
  }
  
  void syncTriggers(SupportSQLiteDatabase paramSupportSQLiteDatabase)
  {
    if (paramSupportSQLiteDatabase.inTransaction()) {
      return;
    }
    try
    {
      for (;;)
      {
        Lock localLock = this.mDatabase.getCloseLock();
        localLock.lock();
        try
        {
          int[] arrayOfInt = this.mObservedTableTracker.getTablesToSync();
          if (arrayOfInt == null) {
            return;
          }
          int i = arrayOfInt.length;
          paramSupportSQLiteDatabase.beginTransaction();
          int j = 0;
          for (;;)
          {
            if (j < i)
            {
              int k = arrayOfInt[j];
              if ((k != 1) && (k != 2)) {}
            }
            try
            {
              stopTrackingTable(paramSupportSQLiteDatabase, j);
              break label101;
              startTrackingTable(paramSupportSQLiteDatabase, j);
              label101:
              j++;
            }
            finally {}
          }
          paramSupportSQLiteDatabase.setTransactionSuccessful();
          paramSupportSQLiteDatabase.endTransaction();
          this.mObservedTableTracker.onSyncCompleted();
          localLock.unlock();
        }
        finally
        {
          localLock.unlock();
        }
      }
      Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", paramSupportSQLiteDatabase);
    }
    catch (SQLiteException paramSupportSQLiteDatabase) {}catch (IllegalStateException paramSupportSQLiteDatabase) {}
  }
  
  static class ObservedTableTracker
  {
    static final int ADD = 1;
    static final int NO_OP = 0;
    static final int REMOVE = 2;
    boolean mNeedsSync;
    boolean mPendingSync;
    final long[] mTableObservers;
    final int[] mTriggerStateChanges;
    final boolean[] mTriggerStates;
    
    ObservedTableTracker(int paramInt)
    {
      long[] arrayOfLong = new long[paramInt];
      this.mTableObservers = arrayOfLong;
      boolean[] arrayOfBoolean = new boolean[paramInt];
      this.mTriggerStates = arrayOfBoolean;
      this.mTriggerStateChanges = new int[paramInt];
      Arrays.fill(arrayOfLong, 0L);
      Arrays.fill(arrayOfBoolean, false);
    }
    
    @Nullable
    int[] getTablesToSync()
    {
      try
      {
        if ((this.mNeedsSync) && (!this.mPendingSync))
        {
          int i = this.mTableObservers.length;
          for (int j = 0;; j++)
          {
            int k = 1;
            if (j >= i) {
              break;
            }
            int m;
            if (this.mTableObservers[j] > 0L) {
              m = 1;
            } else {
              m = 0;
            }
            boolean[] arrayOfBoolean = this.mTriggerStates;
            if (m != arrayOfBoolean[j])
            {
              arrayOfInt = this.mTriggerStateChanges;
              if (m == 0) {
                k = 2;
              }
              arrayOfInt[j] = k;
            }
            else
            {
              this.mTriggerStateChanges[j] = 0;
            }
            arrayOfBoolean[j] = m;
          }
          this.mPendingSync = true;
          this.mNeedsSync = false;
          int[] arrayOfInt = this.mTriggerStateChanges;
          return arrayOfInt;
        }
        return null;
      }
      finally {}
    }
    
    boolean onAdded(int... paramVarArgs)
    {
      try
      {
        int i = paramVarArgs.length;
        int j = 0;
        boolean bool = false;
        while (j < i)
        {
          int k = paramVarArgs[j];
          long[] arrayOfLong = this.mTableObservers;
          long l = arrayOfLong[k];
          arrayOfLong[k] = (1L + l);
          if (l == 0L)
          {
            this.mNeedsSync = true;
            bool = true;
          }
          j++;
        }
        return bool;
      }
      finally {}
    }
    
    boolean onRemoved(int... paramVarArgs)
    {
      try
      {
        int i = paramVarArgs.length;
        int j = 0;
        boolean bool = false;
        while (j < i)
        {
          int k = paramVarArgs[j];
          long[] arrayOfLong = this.mTableObservers;
          long l = arrayOfLong[k];
          arrayOfLong[k] = (l - 1L);
          if (l == 1L)
          {
            this.mNeedsSync = true;
            bool = true;
          }
          j++;
        }
        return bool;
      }
      finally {}
    }
    
    void onSyncCompleted()
    {
      try
      {
        this.mPendingSync = false;
        return;
      }
      finally {}
    }
  }
  
  public static abstract class Observer
  {
    final String[] mTables;
    
    protected Observer(@NonNull String paramString, String... paramVarArgs)
    {
      String[] arrayOfString = (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length + 1);
      this.mTables = arrayOfString;
      arrayOfString[paramVarArgs.length] = paramString;
    }
    
    public Observer(@NonNull String[] paramArrayOfString)
    {
      this.mTables = ((String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length));
    }
    
    boolean isRemote()
    {
      return false;
    }
    
    public abstract void onInvalidated(@NonNull Set<String> paramSet);
  }
  
  static class ObserverWrapper
  {
    final InvalidationTracker.Observer mObserver;
    private final Set<String> mSingleTableSet;
    final int[] mTableIds;
    private final String[] mTableNames;
    
    ObserverWrapper(InvalidationTracker.Observer paramObserver, int[] paramArrayOfInt, String[] paramArrayOfString)
    {
      this.mObserver = paramObserver;
      this.mTableIds = paramArrayOfInt;
      this.mTableNames = paramArrayOfString;
      if (paramArrayOfInt.length == 1)
      {
        paramObserver = new HashSet();
        paramObserver.add(paramArrayOfString[0]);
        this.mSingleTableSet = Collections.unmodifiableSet(paramObserver);
      }
      else
      {
        this.mSingleTableSet = null;
      }
    }
    
    void notifyByTableInvalidStatus(Set<Integer> paramSet)
    {
      int i = this.mTableIds.length;
      Object localObject1 = null;
      int j = 0;
      while (j < i)
      {
        Object localObject2 = localObject1;
        if (paramSet.contains(Integer.valueOf(this.mTableIds[j]))) {
          if (i == 1)
          {
            localObject2 = this.mSingleTableSet;
          }
          else
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new HashSet(i);
            }
            ((Set)localObject2).add(this.mTableNames[j]);
          }
        }
        j++;
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        this.mObserver.onInvalidated((Set)localObject1);
      }
    }
    
    void notifyByTableNames(String[] paramArrayOfString)
    {
      int i = this.mTableNames.length;
      Object localObject1 = null;
      int j;
      if (i == 1)
      {
        j = paramArrayOfString.length;
        for (i = 0;; i++)
        {
          localObject2 = localObject1;
          if (i >= j) {
            break;
          }
          if (paramArrayOfString[i].equalsIgnoreCase(this.mTableNames[0]))
          {
            localObject2 = this.mSingleTableSet;
            break;
          }
        }
      }
      HashSet localHashSet = new HashSet();
      int k = paramArrayOfString.length;
      for (i = 0; i < k; i++)
      {
        String str = paramArrayOfString[i];
        for (localObject2 : this.mTableNames) {
          if (((String)localObject2).equalsIgnoreCase(str))
          {
            localHashSet.add(localObject2);
            break;
          }
        }
      }
      Object localObject2 = localObject1;
      if (localHashSet.size() > 0) {
        localObject2 = localHashSet;
      }
      if (localObject2 != null) {
        this.mObserver.onInvalidated((Set)localObject2);
      }
    }
  }
  
  static class WeakObserver
    extends InvalidationTracker.Observer
  {
    final WeakReference<InvalidationTracker.Observer> mDelegateRef;
    final InvalidationTracker mTracker;
    
    WeakObserver(InvalidationTracker paramInvalidationTracker, InvalidationTracker.Observer paramObserver)
    {
      super();
      this.mTracker = paramInvalidationTracker;
      this.mDelegateRef = new WeakReference(paramObserver);
    }
    
    public void onInvalidated(@NonNull Set<String> paramSet)
    {
      InvalidationTracker.Observer localObserver = (InvalidationTracker.Observer)this.mDelegateRef.get();
      if (localObserver == null) {
        this.mTracker.removeObserver(this);
      } else {
        localObserver.onInvalidated(paramSet);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\InvalidationTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */