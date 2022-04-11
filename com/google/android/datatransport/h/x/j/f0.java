package com.google.android.datatransport.h.x.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.h.i.a;
import com.google.android.datatransport.runtime.synchronization.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@WorkerThread
public class f0
  implements y, com.google.android.datatransport.runtime.synchronization.a
{
  private static final com.google.android.datatransport.b c = com.google.android.datatransport.b.b("proto");
  private final h0 d;
  private final com.google.android.datatransport.h.y.a f;
  private final com.google.android.datatransport.h.y.a q;
  private final z x;
  
  f0(com.google.android.datatransport.h.y.a parama1, com.google.android.datatransport.h.y.a parama2, z paramz, h0 paramh0)
  {
    this.d = paramh0;
    this.f = parama1;
    this.q = parama2;
    this.x = paramz;
  }
  
  private List<e0> N(SQLiteDatabase paramSQLiteDatabase, com.google.android.datatransport.h.n paramn)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = j(paramSQLiteDatabase, paramn);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((Long)localObject).toString();
    int i = this.x.d();
    U(paramSQLiteDatabase.query("events", new String[] { "_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline" }, "context_id = ?", new String[] { localObject }, null, null, null, String.valueOf(i)), new p(this, localArrayList, paramn));
    return localArrayList;
  }
  
  private Map<Long, Set<c>> O(SQLiteDatabase paramSQLiteDatabase, List<e0> paramList)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder("event_id IN (");
    for (int i = 0; i < paramList.size(); i++)
    {
      localStringBuilder.append(((e0)paramList.get(i)).c());
      if (i < paramList.size() - 1) {
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append(')');
    paramList = localStringBuilder.toString();
    U(paramSQLiteDatabase.query("event_metadata", new String[] { "event_id", "name", "value" }, paramList, null, null, null, null), new l(localHashMap));
    return localHashMap;
  }
  
  private static byte[] P(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.decode(paramString, 0);
  }
  
  private byte[] Q(long paramLong)
  {
    return (byte[])U(g().query("event_payloads", new String[] { "bytes" }, "event_id = ?", new String[] { String.valueOf(paramLong) }, null, null, "sequence_num"), b.a);
  }
  
  private <T> T R(d<T> paramd, b<Throwable, T> paramb)
  {
    long l = this.q.a();
    for (;;)
    {
      try
      {
        Object localObject = paramd.a();
        return (T)localObject;
      }
      catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
      {
        if (this.q.a() >= this.x.b() + l) {
          return (T)paramb.apply(localSQLiteDatabaseLockedException);
        }
        SystemClock.sleep(50L);
      }
    }
  }
  
  private static com.google.android.datatransport.b S(@Nullable String paramString)
  {
    if (paramString == null) {
      return c;
    }
    return com.google.android.datatransport.b.b(paramString);
  }
  
  private static String T(Iterable<e0> paramIterable)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localStringBuilder.append(((e0)paramIterable.next()).c());
      if (paramIterable.hasNext()) {
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  @VisibleForTesting
  static <T> T U(Cursor paramCursor, b<Cursor, T> paramb)
  {
    try
    {
      paramb = paramb.apply(paramCursor);
      return paramb;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    R(new g(paramSQLiteDatabase), d.a);
  }
  
  private long e(SQLiteDatabase paramSQLiteDatabase, com.google.android.datatransport.h.n paramn)
  {
    Object localObject = j(paramSQLiteDatabase, paramn);
    if (localObject != null) {
      return ((Long)localObject).longValue();
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("backend_name", paramn.b());
    ((ContentValues)localObject).put("priority", Integer.valueOf(com.google.android.datatransport.h.z.a.a(paramn.d())));
    ((ContentValues)localObject).put("next_request_ms", Integer.valueOf(0));
    if (paramn.c() != null) {
      ((ContentValues)localObject).put("extras", Base64.encodeToString(paramn.c(), 0));
    }
    return paramSQLiteDatabase.insert("transport_contexts", null, (ContentValues)localObject);
  }
  
  private long getPageSize()
  {
    return g().compileStatement("PRAGMA page_size").simpleQueryForLong();
  }
  
  private long i()
  {
    return g().compileStatement("PRAGMA page_count").simpleQueryForLong();
  }
  
  @Nullable
  private Long j(SQLiteDatabase paramSQLiteDatabase, com.google.android.datatransport.h.n paramn)
  {
    StringBuilder localStringBuilder = new StringBuilder("backend_name = ? and priority = ?");
    Object localObject = new ArrayList(Arrays.asList(new String[] { paramn.b(), String.valueOf(com.google.android.datatransport.h.z.a.a(paramn.d())) }));
    if (paramn.c() != null)
    {
      localStringBuilder.append(" and extras = ?");
      ((ArrayList)localObject).add(Base64.encodeToString(paramn.c(), 0));
    }
    else
    {
      localStringBuilder.append(" and extras is null");
    }
    paramn = localStringBuilder.toString();
    localObject = (String[])((ArrayList)localObject).toArray(new String[0]);
    return (Long)U(paramSQLiteDatabase.query("transport_contexts", new String[] { "_id" }, paramn, (String[])localObject, null, null, null), m.a);
  }
  
  private boolean l()
  {
    boolean bool;
    if (i() * getPageSize() >= this.x.f()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private List<e0> s(List<e0> paramList, Map<Long, Set<c>> paramMap)
  {
    ListIterator localListIterator = paramList.listIterator();
    while (localListIterator.hasNext())
    {
      e0 locale0 = (e0)localListIterator.next();
      if (paramMap.containsKey(Long.valueOf(locale0.c())))
      {
        i.a locala = locale0.b().l();
        Iterator localIterator = ((Set)paramMap.get(Long.valueOf(locale0.c()))).iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          locala.c(localc.a, localc.b);
        }
        localListIterator.set(e0.a(locale0.c(), locale0.d(), locala.d()));
      }
    }
    return paramList;
  }
  
  public <T> T a(a.a<T> parama)
  {
    SQLiteDatabase localSQLiteDatabase = g();
    c(localSQLiteDatabase);
    try
    {
      parama = parama.execute();
      localSQLiteDatabase.setTransactionSuccessful();
      return parama;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public int b()
  {
    return ((Integer)k(new c(this.f.a() - this.x.c()))).intValue();
  }
  
  public void close()
  {
    this.d.close();
  }
  
  public void d(Iterable<e0> paramIterable)
  {
    if (!paramIterable.iterator().hasNext()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DELETE FROM events WHERE _id in ");
    localStringBuilder.append(T(paramIterable));
    paramIterable = localStringBuilder.toString();
    g().compileStatement(paramIterable).execute();
  }
  
  public void f(com.google.android.datatransport.h.n paramn, long paramLong)
  {
    k(new h(paramLong, paramn));
  }
  
  @VisibleForTesting
  SQLiteDatabase g()
  {
    h0 localh0 = this.d;
    Objects.requireNonNull(localh0);
    return (SQLiteDatabase)R(new v(localh0), a.a);
  }
  
  public Iterable<com.google.android.datatransport.h.n> h()
  {
    return (Iterable)k(o.a);
  }
  
  @VisibleForTesting
  <T> T k(b<SQLiteDatabase, T> paramb)
  {
    SQLiteDatabase localSQLiteDatabase = g();
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramb = paramb.apply(localSQLiteDatabase);
      localSQLiteDatabase.setTransactionSuccessful();
      return paramb;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public long m(com.google.android.datatransport.h.n paramn)
  {
    return ((Long)U(g().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[] { paramn.b(), String.valueOf(com.google.android.datatransport.h.z.a.a(paramn.d())) }), n.a)).longValue();
  }
  
  public boolean n(com.google.android.datatransport.h.n paramn)
  {
    return ((Boolean)k(new i(this, paramn))).booleanValue();
  }
  
  public void o(Iterable<e0> paramIterable)
  {
    if (!paramIterable.iterator().hasNext()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
    localStringBuilder.append(T(paramIterable));
    k(new f(localStringBuilder.toString()));
  }
  
  public Iterable<e0> p(com.google.android.datatransport.h.n paramn)
  {
    return (Iterable)k(new k(this, paramn));
  }
  
  @Nullable
  public e0 r(com.google.android.datatransport.h.n paramn, com.google.android.datatransport.h.i parami)
  {
    com.google.android.datatransport.h.v.a.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", new Object[] { paramn.d(), parami.j(), paramn.b() });
    long l = ((Long)k(new e(this, paramn, parami))).longValue();
    if (l < 1L) {
      return null;
    }
    return e0.a(l, paramn, parami);
  }
  
  static abstract interface b<T, U>
  {
    public abstract U apply(T paramT);
  }
  
  private static class c
  {
    final String a;
    final String b;
    
    private c(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
  
  static abstract interface d<T>
  {
    public abstract T a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\j\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */