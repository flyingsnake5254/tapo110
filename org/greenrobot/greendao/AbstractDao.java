package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.FastCursor;
import org.greenrobot.greendao.internal.TableStatements;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxDao;
import rx.schedulers.Schedulers;

public abstract class AbstractDao<T, K>
{
  protected final DaoConfig config;
  protected final Database db;
  protected final IdentityScope<K, T> identityScope;
  protected final IdentityScopeLong<T> identityScopeLong;
  protected final boolean isStandardSQLite;
  protected final int pkOrdinal;
  private volatile RxDao<T, K> rxDao;
  private volatile RxDao<T, K> rxDaoPlain;
  protected final AbstractDaoSession session;
  protected final TableStatements statements;
  
  public AbstractDao(DaoConfig paramDaoConfig)
  {
    this(paramDaoConfig, null);
  }
  
  public AbstractDao(DaoConfig paramDaoConfig, AbstractDaoSession paramAbstractDaoSession)
  {
    this.config = paramDaoConfig;
    this.session = paramAbstractDaoSession;
    paramAbstractDaoSession = paramDaoConfig.db;
    this.db = paramAbstractDaoSession;
    this.isStandardSQLite = (paramAbstractDaoSession.getRawDatabase() instanceof SQLiteDatabase);
    paramAbstractDaoSession = paramDaoConfig.getIdentityScope();
    this.identityScope = paramAbstractDaoSession;
    if ((paramAbstractDaoSession instanceof IdentityScopeLong)) {
      this.identityScopeLong = ((IdentityScopeLong)paramAbstractDaoSession);
    } else {
      this.identityScopeLong = null;
    }
    this.statements = paramDaoConfig.statements;
    paramDaoConfig = paramDaoConfig.pkProperty;
    int i;
    if (paramDaoConfig != null) {
      i = paramDaoConfig.ordinal;
    } else {
      i = -1;
    }
    this.pkOrdinal = i;
  }
  
  private void deleteByKeyInsideSynchronized(K paramK, DatabaseStatement paramDatabaseStatement)
  {
    if ((paramK instanceof Long))
    {
      paramDatabaseStatement.bindLong(1, ((Long)paramK).longValue());
    }
    else
    {
      if (paramK == null) {
        break label46;
      }
      paramDatabaseStatement.bindString(1, paramK.toString());
    }
    paramDatabaseStatement.execute();
    return;
    label46:
    throw new DaoException("Cannot delete entity, key is null");
  }
  
  /* Error */
  private void deleteInTxInternal(Iterable<T> paramIterable, Iterable<K> paramIterable1)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 118	org/greenrobot/greendao/AbstractDao:assertSinglePk	()V
    //   4: aload_0
    //   5: getfield 68	org/greenrobot/greendao/AbstractDao:statements	Lorg/greenrobot/greendao/internal/TableStatements;
    //   8: invokevirtual 124	org/greenrobot/greendao/internal/TableStatements:getDeleteStatement	()Lorg/greenrobot/greendao/database/DatabaseStatement;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   16: invokeinterface 127 1 0
    //   21: aload_3
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +23 -> 54
    //   34: aload 4
    //   36: invokeinterface 132 1 0
    //   41: new 134	java/util/ArrayList
    //   44: astore 4
    //   46: aload 4
    //   48: invokespecial 135	java/util/ArrayList:<init>	()V
    //   51: goto +6 -> 57
    //   54: aconst_null
    //   55: astore 4
    //   57: aload_1
    //   58: ifnull +60 -> 118
    //   61: aload_1
    //   62: invokeinterface 141 1 0
    //   67: astore 5
    //   69: aload 5
    //   71: invokeinterface 147 1 0
    //   76: ifeq +42 -> 118
    //   79: aload_0
    //   80: aload 5
    //   82: invokeinterface 150 1 0
    //   87: invokevirtual 154	org/greenrobot/greendao/AbstractDao:getKeyVerified	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: astore_1
    //   91: aload_0
    //   92: aload_1
    //   93: aload_3
    //   94: invokespecial 156	org/greenrobot/greendao/AbstractDao:deleteByKeyInsideSynchronized	(Ljava/lang/Object;Lorg/greenrobot/greendao/database/DatabaseStatement;)V
    //   97: aload 4
    //   99: ifnull -30 -> 69
    //   102: aload 4
    //   104: aload_1
    //   105: invokeinterface 162 2 0
    //   110: pop
    //   111: goto -42 -> 69
    //   114: astore_1
    //   115: goto +53 -> 168
    //   118: aload_2
    //   119: ifnull +66 -> 185
    //   122: aload_2
    //   123: invokeinterface 141 1 0
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface 147 1 0
    //   135: ifeq +50 -> 185
    //   138: aload_2
    //   139: invokeinterface 150 1 0
    //   144: astore_1
    //   145: aload_0
    //   146: aload_1
    //   147: aload_3
    //   148: invokespecial 156	org/greenrobot/greendao/AbstractDao:deleteByKeyInsideSynchronized	(Ljava/lang/Object;Lorg/greenrobot/greendao/database/DatabaseStatement;)V
    //   151: aload 4
    //   153: ifnull -24 -> 129
    //   156: aload 4
    //   158: aload_1
    //   159: invokeinterface 162 2 0
    //   164: pop
    //   165: goto -36 -> 129
    //   168: aload_0
    //   169: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   172: astore_2
    //   173: aload_2
    //   174: ifnull +9 -> 183
    //   177: aload_2
    //   178: invokeinterface 165 1 0
    //   183: aload_1
    //   184: athrow
    //   185: aload_0
    //   186: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   189: astore_1
    //   190: aload_1
    //   191: ifnull +9 -> 200
    //   194: aload_1
    //   195: invokeinterface 165 1 0
    //   200: aload_3
    //   201: monitorexit
    //   202: aload_0
    //   203: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   206: invokeinterface 168 1 0
    //   211: aload 4
    //   213: ifnull +20 -> 233
    //   216: aload_0
    //   217: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   220: astore_1
    //   221: aload_1
    //   222: ifnull +11 -> 233
    //   225: aload_1
    //   226: aload 4
    //   228: invokeinterface 172 2 0
    //   233: aload_0
    //   234: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   237: invokeinterface 175 1 0
    //   242: return
    //   243: astore_1
    //   244: aload_3
    //   245: monitorexit
    //   246: aload_1
    //   247: athrow
    //   248: astore_1
    //   249: aload_0
    //   250: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   253: invokeinterface 175 1 0
    //   258: aload_1
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	AbstractDao
    //   0	260	1	paramIterable	Iterable<T>
    //   0	260	2	paramIterable1	Iterable<K>
    //   11	234	3	localDatabaseStatement	DatabaseStatement
    //   27	200	4	localObject	Object
    //   67	14	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   61	69	114	finally
    //   69	97	114	finally
    //   102	111	114	finally
    //   122	129	114	finally
    //   129	151	114	finally
    //   156	165	114	finally
    //   23	29	243	finally
    //   34	51	243	finally
    //   168	173	243	finally
    //   177	183	243	finally
    //   183	185	243	finally
    //   185	190	243	finally
    //   194	200	243	finally
    //   200	202	243	finally
    //   244	246	243	finally
    //   21	23	248	finally
    //   202	211	248	finally
    //   216	221	248	finally
    //   225	233	248	finally
    //   246	248	248	finally
  }
  
  private long executeInsert(T paramT, DatabaseStatement paramDatabaseStatement, boolean paramBoolean)
  {
    long l;
    if (this.db.isDbLockedByCurrentThread()) {
      l = insertInsideTx(paramT, paramDatabaseStatement);
    } else {
      this.db.beginTransaction();
    }
    try
    {
      l = insertInsideTx(paramT, paramDatabaseStatement);
      this.db.setTransactionSuccessful();
      this.db.endTransaction();
      if (paramBoolean) {
        updateKeyAfterInsertAndAttach(paramT, l, true);
      }
      return l;
    }
    finally
    {
      this.db.endTransaction();
    }
  }
  
  /* Error */
  private void executeInsertInTx(DatabaseStatement paramDatabaseStatement, Iterable<T> paramIterable, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   4: invokeinterface 127 1 0
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +10 -> 29
    //   22: aload 4
    //   24: invokeinterface 132 1 0
    //   29: aload_0
    //   30: getfield 55	org/greenrobot/greendao/AbstractDao:isStandardSQLite	Z
    //   33: ifeq +73 -> 106
    //   36: aload_1
    //   37: invokeinterface 195 1 0
    //   42: checkcast 197	android/database/sqlite/SQLiteStatement
    //   45: astore 4
    //   47: aload_2
    //   48: invokeinterface 141 1 0
    //   53: astore 5
    //   55: aload 5
    //   57: invokeinterface 147 1 0
    //   62: ifeq +104 -> 166
    //   65: aload 5
    //   67: invokeinterface 150 1 0
    //   72: astore_2
    //   73: aload_0
    //   74: aload 4
    //   76: aload_2
    //   77: invokevirtual 201	org/greenrobot/greendao/AbstractDao:bindValues	(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/Object;)V
    //   80: iload_3
    //   81: ifeq +17 -> 98
    //   84: aload_0
    //   85: aload_2
    //   86: aload 4
    //   88: invokevirtual 203	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   91: iconst_0
    //   92: invokevirtual 189	org/greenrobot/greendao/AbstractDao:updateKeyAfterInsertAndAttach	(Ljava/lang/Object;JZ)V
    //   95: goto -40 -> 55
    //   98: aload 4
    //   100: invokevirtual 204	android/database/sqlite/SQLiteStatement:execute	()V
    //   103: goto -48 -> 55
    //   106: aload_2
    //   107: invokeinterface 141 1 0
    //   112: astore 4
    //   114: aload 4
    //   116: invokeinterface 147 1 0
    //   121: ifeq +45 -> 166
    //   124: aload 4
    //   126: invokeinterface 150 1 0
    //   131: astore_2
    //   132: aload_0
    //   133: aload_1
    //   134: aload_2
    //   135: invokevirtual 207	org/greenrobot/greendao/AbstractDao:bindValues	(Lorg/greenrobot/greendao/database/DatabaseStatement;Ljava/lang/Object;)V
    //   138: iload_3
    //   139: ifeq +18 -> 157
    //   142: aload_0
    //   143: aload_2
    //   144: aload_1
    //   145: invokeinterface 208 1 0
    //   150: iconst_0
    //   151: invokevirtual 189	org/greenrobot/greendao/AbstractDao:updateKeyAfterInsertAndAttach	(Ljava/lang/Object;JZ)V
    //   154: goto -40 -> 114
    //   157: aload_1
    //   158: invokeinterface 104 1 0
    //   163: goto -49 -> 114
    //   166: aload_0
    //   167: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   170: astore_2
    //   171: aload_2
    //   172: ifnull +9 -> 181
    //   175: aload_2
    //   176: invokeinterface 165 1 0
    //   181: aload_1
    //   182: monitorexit
    //   183: aload_0
    //   184: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   187: invokeinterface 168 1 0
    //   192: aload_0
    //   193: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   196: invokeinterface 175 1 0
    //   201: return
    //   202: astore_2
    //   203: aload_0
    //   204: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   207: astore 4
    //   209: aload 4
    //   211: ifnull +10 -> 221
    //   214: aload 4
    //   216: invokeinterface 165 1 0
    //   221: aload_2
    //   222: athrow
    //   223: astore_2
    //   224: aload_1
    //   225: monitorexit
    //   226: aload_2
    //   227: athrow
    //   228: astore_1
    //   229: aload_0
    //   230: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   233: invokeinterface 175 1 0
    //   238: aload_1
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	AbstractDao
    //   0	240	1	paramDatabaseStatement	DatabaseStatement
    //   0	240	2	paramIterable	Iterable<T>
    //   0	240	3	paramBoolean	boolean
    //   15	200	4	localObject	Object
    //   53	13	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   29	55	202	finally
    //   55	80	202	finally
    //   84	95	202	finally
    //   98	103	202	finally
    //   106	114	202	finally
    //   114	138	202	finally
    //   142	154	202	finally
    //   157	163	202	finally
    //   11	17	223	finally
    //   22	29	223	finally
    //   166	171	223	finally
    //   175	181	223	finally
    //   181	183	223	finally
    //   203	209	223	finally
    //   214	221	223	finally
    //   221	223	223	finally
    //   224	226	223	finally
    //   9	11	228	finally
    //   183	192	228	finally
    //   226	228	228	finally
  }
  
  private long insertInsideTx(T paramT, DatabaseStatement paramDatabaseStatement)
  {
    try
    {
      if (this.isStandardSQLite)
      {
        SQLiteStatement localSQLiteStatement = (SQLiteStatement)paramDatabaseStatement.getRawStatement();
        bindValues(localSQLiteStatement, paramT);
        l = localSQLiteStatement.executeInsert();
        return l;
      }
      bindValues(paramDatabaseStatement, paramT);
      long l = paramDatabaseStatement.executeInsert();
      return l;
    }
    finally {}
  }
  
  private void loadAllUnlockOnWindowBounds(Cursor paramCursor, CursorWindow paramCursorWindow, List<T> paramList)
  {
    int i = paramCursorWindow.getStartPosition() + paramCursorWindow.getNumRows();
    for (int j = 0;; j++)
    {
      paramList.add(loadCurrent(paramCursor, 0, false));
      j++;
      if (j >= i)
      {
        paramCursorWindow = moveToNextUnlocked(paramCursor);
        if (paramCursorWindow != null)
        {
          i = paramCursorWindow.getStartPosition() + paramCursorWindow.getNumRows();
          continue;
        }
      }
      else
      {
        if (paramCursor.moveToNext()) {
          continue;
        }
      }
      return;
    }
  }
  
  /* Error */
  private CursorWindow moveToNextUnlocked(Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   4: invokeinterface 165 1 0
    //   9: aload_1
    //   10: invokeinterface 234 1 0
    //   15: ifeq +24 -> 39
    //   18: aload_1
    //   19: checkcast 237	android/database/CrossProcessCursor
    //   22: invokeinterface 241 1 0
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   32: invokeinterface 132 1 0
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -13 -> 28
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   49: invokeinterface 132 1 0
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	AbstractDao
    //   0	56	1	paramCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   9	28	44	finally
  }
  
  protected void assertSinglePk()
  {
    if (this.config.pkColumns.length == 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append(" (");
    localStringBuilder.append(this.config.tablename);
    localStringBuilder.append(") does not have a single-column primary key");
    throw new DaoException(localStringBuilder.toString());
  }
  
  protected void attachEntity(T paramT) {}
  
  protected final void attachEntity(K paramK, T paramT, boolean paramBoolean)
  {
    attachEntity(paramT);
    IdentityScope localIdentityScope = this.identityScope;
    if ((localIdentityScope != null) && (paramK != null)) {
      if (paramBoolean) {
        localIdentityScope.put(paramK, paramT);
      } else {
        localIdentityScope.putNoLock(paramK, paramT);
      }
    }
  }
  
  protected abstract void bindValues(SQLiteStatement paramSQLiteStatement, T paramT);
  
  protected abstract void bindValues(DatabaseStatement paramDatabaseStatement, T paramT);
  
  public long count()
  {
    return this.statements.getCountStatement().simpleQueryForLong();
  }
  
  public void delete(T paramT)
  {
    assertSinglePk();
    deleteByKey(getKeyVerified(paramT));
  }
  
  public void deleteAll()
  {
    Object localObject = this.db;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DELETE FROM '");
    localStringBuilder.append(this.config.tablename);
    localStringBuilder.append("'");
    ((Database)localObject).execSQL(localStringBuilder.toString());
    localObject = this.identityScope;
    if (localObject != null) {
      ((IdentityScope)localObject).clear();
    }
  }
  
  /* Error */
  public void deleteByKey(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 118	org/greenrobot/greendao/AbstractDao:assertSinglePk	()V
    //   4: aload_0
    //   5: getfield 68	org/greenrobot/greendao/AbstractDao:statements	Lorg/greenrobot/greendao/internal/TableStatements;
    //   8: invokevirtual 124	org/greenrobot/greendao/internal/TableStatements:getDeleteStatement	()Lorg/greenrobot/greendao/database/DatabaseStatement;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   16: invokeinterface 181 1 0
    //   21: ifeq +21 -> 42
    //   24: aload_2
    //   25: monitorenter
    //   26: aload_0
    //   27: aload_1
    //   28: aload_2
    //   29: invokespecial 156	org/greenrobot/greendao/AbstractDao:deleteByKeyInsideSynchronized	(Ljava/lang/Object;Lorg/greenrobot/greendao/database/DatabaseStatement;)V
    //   32: aload_2
    //   33: monitorexit
    //   34: goto +45 -> 79
    //   37: astore_1
    //   38: aload_2
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: aload_0
    //   43: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   46: invokeinterface 127 1 0
    //   51: aload_2
    //   52: monitorenter
    //   53: aload_0
    //   54: aload_1
    //   55: aload_2
    //   56: invokespecial 156	org/greenrobot/greendao/AbstractDao:deleteByKeyInsideSynchronized	(Ljava/lang/Object;Lorg/greenrobot/greendao/database/DatabaseStatement;)V
    //   59: aload_2
    //   60: monitorexit
    //   61: aload_0
    //   62: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   65: invokeinterface 168 1 0
    //   70: aload_0
    //   71: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   74: invokeinterface 175 1 0
    //   79: aload_0
    //   80: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +10 -> 95
    //   88: aload_2
    //   89: aload_1
    //   90: invokeinterface 302 2 0
    //   95: return
    //   96: astore_1
    //   97: aload_2
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: aload_0
    //   103: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   106: invokeinterface 175 1 0
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	AbstractDao
    //   0	113	1	paramK	K
    //   11	87	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	34	37	finally
    //   38	40	37	finally
    //   53	61	96	finally
    //   97	99	96	finally
    //   51	53	101	finally
    //   61	70	101	finally
    //   99	101	101	finally
  }
  
  public void deleteByKeyInTx(Iterable<K> paramIterable)
  {
    deleteInTxInternal(null, paramIterable);
  }
  
  public void deleteByKeyInTx(K... paramVarArgs)
  {
    deleteInTxInternal(null, Arrays.asList(paramVarArgs));
  }
  
  public void deleteInTx(Iterable<T> paramIterable)
  {
    deleteInTxInternal(paramIterable, null);
  }
  
  public void deleteInTx(T... paramVarArgs)
  {
    deleteInTxInternal(Arrays.asList(paramVarArgs), null);
  }
  
  public boolean detach(T paramT)
  {
    if (this.identityScope != null)
    {
      Object localObject = getKeyVerified(paramT);
      return this.identityScope.detach(localObject, paramT);
    }
    return false;
  }
  
  public void detachAll()
  {
    IdentityScope localIdentityScope = this.identityScope;
    if (localIdentityScope != null) {
      localIdentityScope.clear();
    }
  }
  
  public String[] getAllColumns()
  {
    return this.config.allColumns;
  }
  
  public Database getDatabase()
  {
    return this.db;
  }
  
  protected abstract K getKey(T paramT);
  
  protected K getKeyVerified(T paramT)
  {
    Object localObject = getKey(paramT);
    if (localObject == null)
    {
      Objects.requireNonNull(paramT, "Entity may not be null");
      throw new DaoException("Entity has no key");
    }
    return (K)localObject;
  }
  
  public String[] getNonPkColumns()
  {
    return this.config.nonPkColumns;
  }
  
  public String[] getPkColumns()
  {
    return this.config.pkColumns;
  }
  
  public Property getPkProperty()
  {
    return this.config.pkProperty;
  }
  
  public Property[] getProperties()
  {
    return this.config.properties;
  }
  
  public AbstractDaoSession getSession()
  {
    return this.session;
  }
  
  TableStatements getStatements()
  {
    return this.config.statements;
  }
  
  public String getTablename()
  {
    return this.config.tablename;
  }
  
  protected abstract boolean hasKey(T paramT);
  
  public long insert(T paramT)
  {
    return executeInsert(paramT, this.statements.getInsertStatement(), true);
  }
  
  public void insertInTx(Iterable<T> paramIterable)
  {
    insertInTx(paramIterable, isEntityUpdateable());
  }
  
  public void insertInTx(Iterable<T> paramIterable, boolean paramBoolean)
  {
    executeInsertInTx(this.statements.getInsertStatement(), paramIterable, paramBoolean);
  }
  
  public void insertInTx(T... paramVarArgs)
  {
    insertInTx(Arrays.asList(paramVarArgs), isEntityUpdateable());
  }
  
  public long insertOrReplace(T paramT)
  {
    return executeInsert(paramT, this.statements.getInsertOrReplaceStatement(), true);
  }
  
  public void insertOrReplaceInTx(Iterable<T> paramIterable)
  {
    insertOrReplaceInTx(paramIterable, isEntityUpdateable());
  }
  
  public void insertOrReplaceInTx(Iterable<T> paramIterable, boolean paramBoolean)
  {
    executeInsertInTx(this.statements.getInsertOrReplaceStatement(), paramIterable, paramBoolean);
  }
  
  public void insertOrReplaceInTx(T... paramVarArgs)
  {
    insertOrReplaceInTx(Arrays.asList(paramVarArgs), isEntityUpdateable());
  }
  
  public long insertWithoutSettingPk(T paramT)
  {
    return executeInsert(paramT, this.statements.getInsertOrReplaceStatement(), false);
  }
  
  protected abstract boolean isEntityUpdateable();
  
  public T load(K paramK)
  {
    assertSinglePk();
    if (paramK == null) {
      return null;
    }
    Object localObject = this.identityScope;
    if (localObject != null)
    {
      localObject = ((IdentityScope)localObject).get(paramK);
      if (localObject != null) {
        return (T)localObject;
      }
    }
    localObject = this.statements.getSelectByKey();
    paramK = paramK.toString();
    return (T)loadUniqueAndCloseCursor(this.db.rawQuery((String)localObject, new String[] { paramK }));
  }
  
  public List<T> loadAll()
  {
    return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll(), null));
  }
  
  protected List<T> loadAllAndCloseCursor(Cursor paramCursor)
  {
    try
    {
      List localList = loadAllFromCursor(paramCursor);
      return localList;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  protected List<T> loadAllFromCursor(Cursor paramCursor)
  {
    int i = paramCursor.getCount();
    if (i == 0) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList(i);
    Object localObject1 = null;
    Object localObject3;
    if ((paramCursor instanceof CrossProcessCursor))
    {
      localObject3 = ((CrossProcessCursor)paramCursor).getWindow();
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        if (((CursorWindow)localObject3).getNumRows() == i)
        {
          paramCursor = new FastCursor((CursorWindow)localObject3);
          j = 1;
          localObject1 = localObject3;
          break label148;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Window vs. result size: ");
        ((StringBuilder)localObject1).append(((CursorWindow)localObject3).getNumRows());
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(i);
        DaoLog.d(((StringBuilder)localObject1).toString());
        localObject1 = localObject3;
      }
    }
    int j = 0;
    label148:
    if (paramCursor.moveToFirst())
    {
      localObject3 = this.identityScope;
      if (localObject3 != null)
      {
        ((IdentityScope)localObject3).lock();
        this.identityScope.reserveRoom(i);
      }
      if ((j == 0) && (localObject1 != null)) {}
      try
      {
        if (this.identityScope != null)
        {
          loadAllUnlockOnWindowBounds(paramCursor, (CursorWindow)localObject1, localArrayList);
        }
        else
        {
          boolean bool;
          do
          {
            localArrayList.add(loadCurrent(paramCursor, 0, false));
            bool = paramCursor.moveToNext();
          } while (bool);
        }
      }
      finally
      {
        paramCursor = this.identityScope;
        if (paramCursor != null) {
          paramCursor.unlock();
        }
      }
    }
    return localArrayList;
  }
  
  public T loadByRowId(long paramLong)
  {
    String str = Long.toString(paramLong);
    return (T)loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByRowId(), new String[] { str }));
  }
  
  protected final T loadCurrent(Cursor paramCursor, int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    if (this.identityScopeLong != null)
    {
      if ((paramInt != 0) && (paramCursor.isNull(this.pkOrdinal + paramInt))) {
        return null;
      }
      long l = paramCursor.getLong(this.pkOrdinal + paramInt);
      localObject1 = this.identityScopeLong;
      if (paramBoolean) {
        localObject1 = ((IdentityScopeLong)localObject1).get2(l);
      } else {
        localObject1 = ((IdentityScopeLong)localObject1).get2NoLock(l);
      }
      if (localObject1 != null) {
        return (T)localObject1;
      }
      paramCursor = readEntity(paramCursor, paramInt);
      attachEntity(paramCursor);
      if (paramBoolean) {
        this.identityScopeLong.put2(l, paramCursor);
      } else {
        this.identityScopeLong.put2NoLock(l, paramCursor);
      }
      return paramCursor;
    }
    if (this.identityScope != null)
    {
      Object localObject2 = readKey(paramCursor, paramInt);
      if ((paramInt != 0) && (localObject2 == null)) {
        return null;
      }
      localObject1 = this.identityScope;
      if (paramBoolean) {
        localObject1 = ((IdentityScope)localObject1).get(localObject2);
      } else {
        localObject1 = ((IdentityScope)localObject1).getNoLock(localObject2);
      }
      if (localObject1 != null) {
        return (T)localObject1;
      }
      paramCursor = readEntity(paramCursor, paramInt);
      attachEntity(localObject2, paramCursor, paramBoolean);
      return paramCursor;
    }
    if ((paramInt != 0) && (readKey(paramCursor, paramInt) == null)) {
      return null;
    }
    paramCursor = readEntity(paramCursor, paramInt);
    attachEntity(paramCursor);
    return paramCursor;
  }
  
  protected final <O> O loadCurrentOther(AbstractDao<O, ?> paramAbstractDao, Cursor paramCursor, int paramInt)
  {
    return (O)paramAbstractDao.loadCurrent(paramCursor, paramInt, true);
  }
  
  protected T loadUnique(Cursor paramCursor)
  {
    if (!paramCursor.moveToFirst()) {
      return null;
    }
    if (paramCursor.isLast()) {
      return (T)loadCurrent(paramCursor, 0, true);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected unique result, but count was ");
    localStringBuilder.append(paramCursor.getCount());
    throw new DaoException(localStringBuilder.toString());
  }
  
  protected T loadUniqueAndCloseCursor(Cursor paramCursor)
  {
    try
    {
      Object localObject1 = loadUnique(paramCursor);
      return (T)localObject1;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public QueryBuilder<T> queryBuilder()
  {
    return QueryBuilder.internalCreate(this);
  }
  
  public List<T> queryRaw(String paramString, String... paramVarArgs)
  {
    Database localDatabase = this.db;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.statements.getSelectAll());
    localStringBuilder.append(paramString);
    return loadAllAndCloseCursor(localDatabase.rawQuery(localStringBuilder.toString(), paramVarArgs));
  }
  
  public Query<T> queryRawCreate(String paramString, Object... paramVarArgs)
  {
    return queryRawCreateListArgs(paramString, Arrays.asList(paramVarArgs));
  }
  
  public Query<T> queryRawCreateListArgs(String paramString, Collection<Object> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.statements.getSelectAll());
    localStringBuilder.append(paramString);
    return Query.internalCreate(this, localStringBuilder.toString(), paramCollection.toArray());
  }
  
  protected abstract T readEntity(Cursor paramCursor, int paramInt);
  
  protected abstract void readEntity(Cursor paramCursor, T paramT, int paramInt);
  
  protected abstract K readKey(Cursor paramCursor, int paramInt);
  
  public void refresh(T paramT)
  {
    assertSinglePk();
    Object localObject1 = getKeyVerified(paramT);
    Object localObject2 = this.statements.getSelectByKey();
    Object localObject3 = localObject1.toString();
    localObject2 = this.db.rawQuery((String)localObject2, new String[] { localObject3 });
    try
    {
      if (((Cursor)localObject2).moveToFirst())
      {
        if (((Cursor)localObject2).isLast())
        {
          readEntity((Cursor)localObject2, paramT, 0);
          attachEntity(localObject1, paramT, true);
          return;
        }
        paramT = new org/greenrobot/greendao/DaoException;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("Expected unique result, but count was ");
        ((StringBuilder)localObject1).append(((Cursor)localObject2).getCount());
        paramT.<init>(((StringBuilder)localObject1).toString());
        throw paramT;
      }
      localObject3 = new org/greenrobot/greendao/DaoException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Entity does not exist in the database anymore: ");
      localStringBuilder.append(paramT.getClass());
      localStringBuilder.append(" with key ");
      localStringBuilder.append(localObject1);
      ((DaoException)localObject3).<init>(localStringBuilder.toString());
      throw ((Throwable)localObject3);
    }
    finally
    {
      ((Cursor)localObject2).close();
    }
  }
  
  @Experimental
  public RxDao<T, K> rx()
  {
    if (this.rxDao == null) {
      this.rxDao = new RxDao(this, Schedulers.io());
    }
    return this.rxDao;
  }
  
  @Experimental
  public RxDao<T, K> rxPlain()
  {
    if (this.rxDaoPlain == null) {
      this.rxDaoPlain = new RxDao(this);
    }
    return this.rxDaoPlain;
  }
  
  public void save(T paramT)
  {
    if (hasKey(paramT)) {
      update(paramT);
    } else {
      insert(paramT);
    }
  }
  
  public void saveInTx(Iterable<T> paramIterable)
  {
    Object localObject1 = paramIterable.iterator();
    int i = 0;
    int j = 0;
    while (((Iterator)localObject1).hasNext()) {
      if (hasKey(((Iterator)localObject1).next())) {
        i++;
      } else {
        j++;
      }
    }
    ArrayList localArrayList;
    if ((i > 0) && (j > 0))
    {
      localObject1 = new ArrayList(i);
      localArrayList = new ArrayList(j);
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject2 = paramIterable.next();
        if (hasKey(localObject2)) {
          ((List)localObject1).add(localObject2);
        } else {
          localArrayList.add(localObject2);
        }
      }
      this.db.beginTransaction();
    }
    try
    {
      updateInTx((Iterable)localObject1);
      insertInTx(localArrayList);
      this.db.setTransactionSuccessful();
      this.db.endTransaction();
    }
    finally
    {
      this.db.endTransaction();
    }
    insertInTx(paramIterable);
    return;
    if (i > 0) {
      updateInTx(paramIterable);
    }
  }
  
  public void saveInTx(T... paramVarArgs)
  {
    saveInTx(Arrays.asList(paramVarArgs));
  }
  
  /* Error */
  public void update(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 118	org/greenrobot/greendao/AbstractDao:assertSinglePk	()V
    //   4: aload_0
    //   5: getfield 68	org/greenrobot/greendao/AbstractDao:statements	Lorg/greenrobot/greendao/internal/TableStatements;
    //   8: invokevirtual 598	org/greenrobot/greendao/internal/TableStatements:getUpdateStatement	()Lorg/greenrobot/greendao/database/DatabaseStatement;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   16: invokeinterface 181 1 0
    //   21: ifeq +47 -> 68
    //   24: aload_2
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 55	org/greenrobot/greendao/AbstractDao:isStandardSQLite	Z
    //   30: ifeq +21 -> 51
    //   33: aload_0
    //   34: aload_1
    //   35: aload_2
    //   36: invokeinterface 195 1 0
    //   41: checkcast 197	android/database/sqlite/SQLiteStatement
    //   44: iconst_1
    //   45: invokevirtual 602	org/greenrobot/greendao/AbstractDao:updateInsideSynchronized	(Ljava/lang/Object;Landroid/database/sqlite/SQLiteStatement;Z)V
    //   48: goto +10 -> 58
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: iconst_1
    //   55: invokevirtual 605	org/greenrobot/greendao/AbstractDao:updateInsideSynchronized	(Ljava/lang/Object;Lorg/greenrobot/greendao/database/DatabaseStatement;Z)V
    //   58: aload_2
    //   59: monitorexit
    //   60: goto +46 -> 106
    //   63: astore_1
    //   64: aload_2
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: aload_0
    //   69: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   72: invokeinterface 127 1 0
    //   77: aload_2
    //   78: monitorenter
    //   79: aload_0
    //   80: aload_1
    //   81: aload_2
    //   82: iconst_1
    //   83: invokevirtual 605	org/greenrobot/greendao/AbstractDao:updateInsideSynchronized	(Ljava/lang/Object;Lorg/greenrobot/greendao/database/DatabaseStatement;Z)V
    //   86: aload_2
    //   87: monitorexit
    //   88: aload_0
    //   89: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   92: invokeinterface 168 1 0
    //   97: aload_0
    //   98: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   101: invokeinterface 175 1 0
    //   106: return
    //   107: astore_1
    //   108: aload_2
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: aload_0
    //   114: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   117: invokeinterface 175 1 0
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	AbstractDao
    //   0	124	1	paramT	T
    //   11	98	2	localDatabaseStatement	DatabaseStatement
    // Exception table:
    //   from	to	target	type
    //   26	48	63	finally
    //   51	58	63	finally
    //   58	60	63	finally
    //   64	66	63	finally
    //   79	88	107	finally
    //   108	110	107	finally
    //   77	79	112	finally
    //   88	97	112	finally
    //   110	112	112	finally
  }
  
  /* Error */
  public void updateInTx(Iterable<T> paramIterable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	org/greenrobot/greendao/AbstractDao:statements	Lorg/greenrobot/greendao/internal/TableStatements;
    //   4: invokevirtual 598	org/greenrobot/greendao/internal/TableStatements:getUpdateStatement	()Lorg/greenrobot/greendao/database/DatabaseStatement;
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   12: invokeinterface 127 1 0
    //   17: aload_2
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +9 -> 34
    //   28: aload_3
    //   29: invokeinterface 132 1 0
    //   34: aload_0
    //   35: getfield 55	org/greenrobot/greendao/AbstractDao:isStandardSQLite	Z
    //   38: ifeq +44 -> 82
    //   41: aload_2
    //   42: invokeinterface 195 1 0
    //   47: checkcast 197	android/database/sqlite/SQLiteStatement
    //   50: astore_3
    //   51: aload_1
    //   52: invokeinterface 141 1 0
    //   57: astore_1
    //   58: aload_1
    //   59: invokeinterface 147 1 0
    //   64: ifeq +49 -> 113
    //   67: aload_0
    //   68: aload_1
    //   69: invokeinterface 150 1 0
    //   74: aload_3
    //   75: iconst_0
    //   76: invokevirtual 602	org/greenrobot/greendao/AbstractDao:updateInsideSynchronized	(Ljava/lang/Object;Landroid/database/sqlite/SQLiteStatement;Z)V
    //   79: goto -21 -> 58
    //   82: aload_1
    //   83: invokeinterface 141 1 0
    //   88: astore_1
    //   89: aload_1
    //   90: invokeinterface 147 1 0
    //   95: ifeq +18 -> 113
    //   98: aload_0
    //   99: aload_1
    //   100: invokeinterface 150 1 0
    //   105: aload_2
    //   106: iconst_0
    //   107: invokevirtual 605	org/greenrobot/greendao/AbstractDao:updateInsideSynchronized	(Ljava/lang/Object;Lorg/greenrobot/greendao/database/DatabaseStatement;Z)V
    //   110: goto -21 -> 89
    //   113: aload_0
    //   114: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull +9 -> 128
    //   122: aload_1
    //   123: invokeinterface 165 1 0
    //   128: aload_2
    //   129: monitorexit
    //   130: aload_0
    //   131: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   134: invokeinterface 168 1 0
    //   139: aload_0
    //   140: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   143: invokeinterface 175 1 0
    //   148: aconst_null
    //   149: astore_1
    //   150: goto +54 -> 204
    //   153: astore_1
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: aload_0
    //   158: getfield 61	org/greenrobot/greendao/AbstractDao:identityScope	Lorg/greenrobot/greendao/identityscope/IdentityScope;
    //   161: astore_3
    //   162: aload_3
    //   163: ifnull +9 -> 172
    //   166: aload_3
    //   167: invokeinterface 165 1 0
    //   172: aload_1
    //   173: athrow
    //   174: astore_1
    //   175: aload_2
    //   176: monitorexit
    //   177: aload_1
    //   178: athrow
    //   179: astore_1
    //   180: aload_0
    //   181: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   184: invokeinterface 175 1 0
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_0
    //   196: getfield 45	org/greenrobot/greendao/AbstractDao:db	Lorg/greenrobot/greendao/database/Database;
    //   199: invokeinterface 175 1 0
    //   204: aload_1
    //   205: ifnonnull +4 -> 209
    //   208: return
    //   209: aload_1
    //   210: athrow
    //   211: astore_2
    //   212: ldc_w 609
    //   215: aload_2
    //   216: invokestatic 613	org/greenrobot/greendao/DaoLog:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   219: pop
    //   220: aload_1
    //   221: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	AbstractDao
    //   0	222	1	paramIterable	Iterable<T>
    //   7	169	2	localDatabaseStatement	DatabaseStatement
    //   211	5	2	localRuntimeException	RuntimeException
    //   23	144	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   139	148	153	java/lang/RuntimeException
    //   34	58	156	finally
    //   58	79	156	finally
    //   82	89	156	finally
    //   89	110	156	finally
    //   19	24	174	finally
    //   28	34	174	finally
    //   113	118	174	finally
    //   122	128	174	finally
    //   128	130	174	finally
    //   157	162	174	finally
    //   166	172	174	finally
    //   172	174	174	finally
    //   175	177	174	finally
    //   17	19	179	finally
    //   130	139	179	finally
    //   177	179	179	finally
    //   180	189	191	java/lang/RuntimeException
    //   17	19	194	java/lang/RuntimeException
    //   130	139	194	java/lang/RuntimeException
    //   177	179	194	java/lang/RuntimeException
    //   195	204	211	java/lang/RuntimeException
  }
  
  public void updateInTx(T... paramVarArgs)
  {
    updateInTx(Arrays.asList(paramVarArgs));
  }
  
  protected void updateInsideSynchronized(T paramT, SQLiteStatement paramSQLiteStatement, boolean paramBoolean)
  {
    bindValues(paramSQLiteStatement, paramT);
    int i = this.config.allColumns.length + 1;
    Object localObject = getKey(paramT);
    if ((localObject instanceof Long))
    {
      paramSQLiteStatement.bindLong(i, ((Long)localObject).longValue());
    }
    else
    {
      if (localObject == null) {
        break label79;
      }
      paramSQLiteStatement.bindString(i, localObject.toString());
    }
    paramSQLiteStatement.execute();
    attachEntity(localObject, paramT, paramBoolean);
    return;
    label79:
    throw new DaoException("Cannot update entity without key - was it inserted before?");
  }
  
  protected void updateInsideSynchronized(T paramT, DatabaseStatement paramDatabaseStatement, boolean paramBoolean)
  {
    bindValues(paramDatabaseStatement, paramT);
    int i = this.config.allColumns.length + 1;
    Object localObject = getKey(paramT);
    if ((localObject instanceof Long))
    {
      paramDatabaseStatement.bindLong(i, ((Long)localObject).longValue());
    }
    else
    {
      if (localObject == null) {
        break label85;
      }
      paramDatabaseStatement.bindString(i, localObject.toString());
    }
    paramDatabaseStatement.execute();
    attachEntity(localObject, paramT, paramBoolean);
    return;
    label85:
    throw new DaoException("Cannot update entity without key - was it inserted before?");
  }
  
  protected abstract K updateKeyAfterInsert(T paramT, long paramLong);
  
  protected void updateKeyAfterInsertAndAttach(T paramT, long paramLong, boolean paramBoolean)
  {
    if (paramLong != -1L) {
      attachEntity(updateKeyAfterInsert(paramT, paramLong), paramT, paramBoolean);
    } else {
      DaoLog.w("Could not insert row (executeInsert returned -1)");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\AbstractDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */