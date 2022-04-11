package com.tplink.libtpmediaother.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class FileMemoryInfoDao
  extends AbstractDao<d, String>
{
  public static final String TABLENAME = "FILE_MEMORY_INFO";
  
  public FileMemoryInfoDao(DaoConfig paramDaoConfig, b paramb)
  {
    super(paramDaoConfig, paramb);
  }
  
  public static void c(Database paramDatabase, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "IF NOT EXISTS ";
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE ");
    localStringBuilder.append(str);
    localStringBuilder.append("\"FILE_MEMORY_INFO\" (\"UTC_TIMESTAMP\" TEXT PRIMARY KEY NOT NULL ,\"DEVICE_ALIAS\" TEXT,\"DEVICE_MODEL\" TEXT,\"DEVICE_ID_MD5\" TEXT,\"LOCATION_URL\" TEXT,\"LOCATION_NAME\" TEXT,\"ASSOCIATED_ACCOUNT\" TEXT,\"FILE_ABSOLUTE_PATH\" TEXT,\"IS_FAVORITE\" INTEGER NOT NULL ,\"IS_DELETED_BY_USER\" INTEGER NOT NULL ,\"SNAPSHOT_IMAGE_PATH\" TEXT,\"VIDEO_LENGTH\" INTEGER NOT NULL );");
    paramDatabase.execSQL(localStringBuilder.toString());
  }
  
  public static void d(Database paramDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE ");
    String str;
    if (paramBoolean) {
      str = "IF EXISTS ";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("\"FILE_MEMORY_INFO\"");
    paramDatabase.execSQL(localStringBuilder.toString());
  }
  
  protected final void a(SQLiteStatement paramSQLiteStatement, d paramd)
  {
    paramSQLiteStatement.clearBindings();
    String str = paramd.k();
    if (str != null) {
      paramSQLiteStatement.bindString(1, str);
    }
    str = paramd.b();
    if (str != null) {
      paramSQLiteStatement.bindString(2, str);
    }
    str = paramd.d();
    if (str != null) {
      paramSQLiteStatement.bindString(3, str);
    }
    str = paramd.c();
    if (str != null) {
      paramSQLiteStatement.bindString(4, str);
    }
    str = paramd.i();
    if (str != null) {
      paramSQLiteStatement.bindString(5, str);
    }
    str = paramd.h();
    if (str != null) {
      paramSQLiteStatement.bindString(6, str);
    }
    str = paramd.a();
    if (str != null) {
      paramSQLiteStatement.bindString(7, str);
    }
    str = paramd.e();
    if (str != null) {
      paramSQLiteStatement.bindString(8, str);
    }
    boolean bool = paramd.g();
    long l1 = 1L;
    long l2;
    if (bool) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(9, l2);
    if (paramd.f()) {
      l2 = l1;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(10, l2);
    str = paramd.j();
    if (str != null) {
      paramSQLiteStatement.bindString(11, str);
    }
    paramSQLiteStatement.bindLong(12, paramd.l());
  }
  
  protected final void b(DatabaseStatement paramDatabaseStatement, d paramd)
  {
    paramDatabaseStatement.clearBindings();
    String str = paramd.k();
    if (str != null) {
      paramDatabaseStatement.bindString(1, str);
    }
    str = paramd.b();
    if (str != null) {
      paramDatabaseStatement.bindString(2, str);
    }
    str = paramd.d();
    if (str != null) {
      paramDatabaseStatement.bindString(3, str);
    }
    str = paramd.c();
    if (str != null) {
      paramDatabaseStatement.bindString(4, str);
    }
    str = paramd.i();
    if (str != null) {
      paramDatabaseStatement.bindString(5, str);
    }
    str = paramd.h();
    if (str != null) {
      paramDatabaseStatement.bindString(6, str);
    }
    str = paramd.a();
    if (str != null) {
      paramDatabaseStatement.bindString(7, str);
    }
    str = paramd.e();
    if (str != null) {
      paramDatabaseStatement.bindString(8, str);
    }
    boolean bool = paramd.g();
    long l1 = 1L;
    long l2;
    if (bool) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(9, l2);
    if (paramd.f()) {
      l2 = l1;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(10, l2);
    str = paramd.j();
    if (str != null) {
      paramDatabaseStatement.bindString(11, str);
    }
    paramDatabaseStatement.bindLong(12, paramd.l());
  }
  
  public String e(d paramd)
  {
    if (paramd != null) {
      return paramd.k();
    }
    return null;
  }
  
  public boolean f(d paramd)
  {
    boolean bool;
    if (paramd.k() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public d g(Cursor paramCursor, int paramInt)
  {
    int i = paramInt + 0;
    boolean bool1 = paramCursor.isNull(i);
    String str1 = null;
    String str2;
    if (bool1) {
      str2 = null;
    } else {
      str2 = paramCursor.getString(i);
    }
    i = paramInt + 1;
    String str3;
    if (paramCursor.isNull(i)) {
      str3 = null;
    } else {
      str3 = paramCursor.getString(i);
    }
    i = paramInt + 2;
    String str4;
    if (paramCursor.isNull(i)) {
      str4 = null;
    } else {
      str4 = paramCursor.getString(i);
    }
    i = paramInt + 3;
    String str5;
    if (paramCursor.isNull(i)) {
      str5 = null;
    } else {
      str5 = paramCursor.getString(i);
    }
    i = paramInt + 4;
    String str6;
    if (paramCursor.isNull(i)) {
      str6 = null;
    } else {
      str6 = paramCursor.getString(i);
    }
    i = paramInt + 5;
    String str7;
    if (paramCursor.isNull(i)) {
      str7 = null;
    } else {
      str7 = paramCursor.getString(i);
    }
    i = paramInt + 6;
    String str8;
    if (paramCursor.isNull(i)) {
      str8 = null;
    } else {
      str8 = paramCursor.getString(i);
    }
    i = paramInt + 7;
    String str9;
    if (paramCursor.isNull(i)) {
      str9 = null;
    } else {
      str9 = paramCursor.getString(i);
    }
    i = paramCursor.getShort(paramInt + 8);
    boolean bool2 = true;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramCursor.getShort(paramInt + 9) == 0) {
      bool2 = false;
    }
    i = paramInt + 10;
    if (!paramCursor.isNull(i)) {
      str1 = paramCursor.getString(i);
    }
    return new d(str2, str3, str4, str5, str6, str7, str8, str9, bool1, bool2, str1, paramCursor.getInt(paramInt + 11));
  }
  
  public void h(Cursor paramCursor, d paramd, int paramInt)
  {
    int i = paramInt + 0;
    boolean bool1 = paramCursor.isNull(i);
    Object localObject1 = null;
    Object localObject2;
    if (bool1) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramd.w((String)localObject2);
    i = paramInt + 1;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramd.n((String)localObject2);
    i = paramInt + 2;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramd.p((String)localObject2);
    i = paramInt + 3;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramd.o((String)localObject2);
    i = paramInt + 4;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramd.u((String)localObject2);
    i = paramInt + 5;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramd.t((String)localObject2);
    i = paramInt + 6;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramd.m((String)localObject2);
    i = paramInt + 7;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramd.q((String)localObject2);
    i = paramCursor.getShort(paramInt + 8);
    boolean bool2 = true;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramd.s(bool1);
    if (paramCursor.getShort(paramInt + 9) != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramd.r(bool1);
    i = paramInt + 10;
    if (paramCursor.isNull(i)) {
      localObject2 = localObject1;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramd.v((String)localObject2);
    paramd.x(paramCursor.getInt(paramInt + 11));
  }
  
  public String i(Cursor paramCursor, int paramInt)
  {
    
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = paramCursor.getString(paramInt);
    }
    return paramCursor;
  }
  
  protected final boolean isEntityUpdateable()
  {
    return true;
  }
  
  protected final String j(d paramd, long paramLong)
  {
    return paramd.k();
  }
  
  public static class Properties
  {
    public static final Property a = new Property(0, String.class, "utcTimestamp", true, "UTC_TIMESTAMP");
    public static final Property b = new Property(1, String.class, "deviceAlias", false, "DEVICE_ALIAS");
    public static final Property c = new Property(2, String.class, "deviceModel", false, "DEVICE_MODEL");
    public static final Property d = new Property(3, String.class, "deviceIdMD5", false, "DEVICE_ID_MD5");
    public static final Property e = new Property(4, String.class, "locationUrl", false, "LOCATION_URL");
    public static final Property f = new Property(5, String.class, "locationName", false, "LOCATION_NAME");
    public static final Property g = new Property(6, String.class, "associatedAccount", false, "ASSOCIATED_ACCOUNT");
    public static final Property h = new Property(7, String.class, "fileAbsolutePath", false, "FILE_ABSOLUTE_PATH");
    public static final Property i;
    public static final Property j;
    public static final Property k = new Property(10, String.class, "snapshotImagePath", false, "SNAPSHOT_IMAGE_PATH");
    public static final Property l = new Property(11, Integer.TYPE, "videoLength", false, "VIDEO_LENGTH");
    
    static
    {
      Class localClass = Boolean.TYPE;
      i = new Property(8, localClass, "isFavorite", false, "IS_FAVORITE");
      j = new Property(9, localClass, "isDeletedByUser", false, "IS_DELETED_BY_USER");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediaother\database\model\FileMemoryInfoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */