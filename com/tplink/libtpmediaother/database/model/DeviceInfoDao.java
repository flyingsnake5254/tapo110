package com.tplink.libtpmediaother.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class DeviceInfoDao
  extends AbstractDao<c, String>
{
  public static final String TABLENAME = "DEVICE_INFO";
  
  public DeviceInfoDao(DaoConfig paramDaoConfig, b paramb)
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
    localStringBuilder.append("\"DEVICE_INFO\" (\"DEVICE_ID_MD5\" TEXT PRIMARY KEY NOT NULL ,\"DEVICE_ALIAS\" TEXT,\"RESOLUTION\" TEXT,\"IS_LIVE_MUTE_AUDIO\" INTEGER,\"IS_PLAY_BACK_MUTE_AUDIO\" INTEGER,\"PRE_IMAGE_URL\" TEXT,\"RELAY_SERVER_PORT\" INTEGER,\"LOCAL_PASSWORD\" TEXT,\"MOTOR_LAST_RESET_TIME\" INTEGER,\"MOTOR_LAST_CRUISE_VERTICAL_TIME\" INTEGER,\"MOTOR_LAST_CRUISE_HORIZONTAL_TIME\" INTEGER);");
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
    localStringBuilder.append("\"DEVICE_INFO\"");
    paramDatabase.execSQL(localStringBuilder.toString());
  }
  
  protected final void a(SQLiteStatement paramSQLiteStatement, c paramc)
  {
    paramSQLiteStatement.clearBindings();
    Object localObject = paramc.b();
    if (localObject != null) {
      paramSQLiteStatement.bindString(1, (String)localObject);
    }
    localObject = paramc.a();
    if (localObject != null) {
      paramSQLiteStatement.bindString(2, (String)localObject);
    }
    localObject = paramc.k();
    if (localObject != null) {
      paramSQLiteStatement.bindString(3, (String)localObject);
    }
    localObject = paramc.c();
    long l1 = 1L;
    long l2;
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        l2 = 1L;
      } else {
        l2 = 0L;
      }
      paramSQLiteStatement.bindLong(4, l2);
    }
    localObject = paramc.d();
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        l2 = l1;
      } else {
        l2 = 0L;
      }
      paramSQLiteStatement.bindLong(5, l2);
    }
    localObject = paramc.i();
    if (localObject != null) {
      paramSQLiteStatement.bindString(6, (String)localObject);
    }
    localObject = paramc.j();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(7, ((Integer)localObject).intValue());
    }
    localObject = paramc.e();
    if (localObject != null) {
      paramSQLiteStatement.bindString(8, (String)localObject);
    }
    localObject = paramc.h();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(9, ((Long)localObject).longValue());
    }
    localObject = paramc.g();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(10, ((Long)localObject).longValue());
    }
    paramc = paramc.f();
    if (paramc != null) {
      paramSQLiteStatement.bindLong(11, paramc.longValue());
    }
  }
  
  protected final void b(DatabaseStatement paramDatabaseStatement, c paramc)
  {
    paramDatabaseStatement.clearBindings();
    Object localObject = paramc.b();
    if (localObject != null) {
      paramDatabaseStatement.bindString(1, (String)localObject);
    }
    localObject = paramc.a();
    if (localObject != null) {
      paramDatabaseStatement.bindString(2, (String)localObject);
    }
    localObject = paramc.k();
    if (localObject != null) {
      paramDatabaseStatement.bindString(3, (String)localObject);
    }
    localObject = paramc.c();
    long l1 = 1L;
    long l2;
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        l2 = 1L;
      } else {
        l2 = 0L;
      }
      paramDatabaseStatement.bindLong(4, l2);
    }
    localObject = paramc.d();
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        l2 = l1;
      } else {
        l2 = 0L;
      }
      paramDatabaseStatement.bindLong(5, l2);
    }
    localObject = paramc.i();
    if (localObject != null) {
      paramDatabaseStatement.bindString(6, (String)localObject);
    }
    localObject = paramc.j();
    if (localObject != null) {
      paramDatabaseStatement.bindLong(7, ((Integer)localObject).intValue());
    }
    localObject = paramc.e();
    if (localObject != null) {
      paramDatabaseStatement.bindString(8, (String)localObject);
    }
    localObject = paramc.h();
    if (localObject != null) {
      paramDatabaseStatement.bindLong(9, ((Long)localObject).longValue());
    }
    localObject = paramc.g();
    if (localObject != null) {
      paramDatabaseStatement.bindLong(10, ((Long)localObject).longValue());
    }
    paramc = paramc.f();
    if (paramc != null) {
      paramDatabaseStatement.bindLong(11, paramc.longValue());
    }
  }
  
  public String e(c paramc)
  {
    if (paramc != null) {
      return paramc.b();
    }
    return null;
  }
  
  public boolean f(c paramc)
  {
    boolean bool;
    if (paramc.b() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public c g(Cursor paramCursor, int paramInt)
  {
    int i = paramInt + 0;
    String str1;
    if (paramCursor.isNull(i)) {
      str1 = null;
    } else {
      str1 = paramCursor.getString(i);
    }
    i = paramInt + 1;
    String str2;
    if (paramCursor.isNull(i)) {
      str2 = null;
    } else {
      str2 = paramCursor.getString(i);
    }
    i = paramInt + 2;
    String str3;
    if (paramCursor.isNull(i)) {
      str3 = null;
    } else {
      str3 = paramCursor.getString(i);
    }
    i = paramInt + 3;
    boolean bool1 = paramCursor.isNull(i);
    boolean bool2 = true;
    Boolean localBoolean1;
    if (bool1)
    {
      localBoolean1 = null;
    }
    else
    {
      if (paramCursor.getShort(i) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localBoolean1 = Boolean.valueOf(bool1);
    }
    i = paramInt + 4;
    Boolean localBoolean2;
    if (paramCursor.isNull(i))
    {
      localBoolean2 = null;
    }
    else
    {
      if (paramCursor.getShort(i) != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localBoolean2 = Boolean.valueOf(bool1);
    }
    i = paramInt + 5;
    String str4;
    if (paramCursor.isNull(i)) {
      str4 = null;
    } else {
      str4 = paramCursor.getString(i);
    }
    i = paramInt + 6;
    Integer localInteger;
    if (paramCursor.isNull(i)) {
      localInteger = null;
    } else {
      localInteger = Integer.valueOf(paramCursor.getInt(i));
    }
    i = paramInt + 7;
    String str5;
    if (paramCursor.isNull(i)) {
      str5 = null;
    } else {
      str5 = paramCursor.getString(i);
    }
    i = paramInt + 8;
    Long localLong1;
    if (paramCursor.isNull(i)) {
      localLong1 = null;
    } else {
      localLong1 = Long.valueOf(paramCursor.getLong(i));
    }
    i = paramInt + 9;
    Long localLong2;
    if (paramCursor.isNull(i)) {
      localLong2 = null;
    } else {
      localLong2 = Long.valueOf(paramCursor.getLong(i));
    }
    paramInt += 10;
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = Long.valueOf(paramCursor.getLong(paramInt));
    }
    return new c(str1, str2, str3, localBoolean1, localBoolean2, str4, localInteger, str5, localLong1, localLong2, paramCursor);
  }
  
  public void h(Cursor paramCursor, c paramc, int paramInt)
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
    paramc.m((String)localObject2);
    i = paramInt + 1;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramc.l((String)localObject2);
    i = paramInt + 2;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramc.v((String)localObject2);
    i = paramInt + 3;
    bool1 = paramCursor.isNull(i);
    boolean bool2 = true;
    if (bool1)
    {
      localObject2 = null;
    }
    else
    {
      if (paramCursor.getShort(i) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject2 = Boolean.valueOf(bool1);
    }
    paramc.n((Boolean)localObject2);
    i = paramInt + 4;
    if (paramCursor.isNull(i))
    {
      localObject2 = null;
    }
    else
    {
      if (paramCursor.getShort(i) != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localObject2 = Boolean.valueOf(bool1);
    }
    paramc.o((Boolean)localObject2);
    i = paramInt + 5;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramc.t((String)localObject2);
    i = paramInt + 6;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = Integer.valueOf(paramCursor.getInt(i));
    }
    paramc.u((Integer)localObject2);
    i = paramInt + 7;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    paramc.p((String)localObject2);
    i = paramInt + 8;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = Long.valueOf(paramCursor.getLong(i));
    }
    paramc.s((Long)localObject2);
    i = paramInt + 9;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = Long.valueOf(paramCursor.getLong(i));
    }
    paramc.r((Long)localObject2);
    paramInt += 10;
    if (paramCursor.isNull(paramInt)) {
      paramCursor = (Cursor)localObject1;
    } else {
      paramCursor = Long.valueOf(paramCursor.getLong(paramInt));
    }
    paramc.q(paramCursor);
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
  
  protected final String j(c paramc, long paramLong)
  {
    return paramc.b();
  }
  
  public static class Properties
  {
    public static final Property a = new Property(0, String.class, "deviceIdMD5", true, "DEVICE_ID_MD5");
    public static final Property b = new Property(1, String.class, "deviceAlias", false, "DEVICE_ALIAS");
    public static final Property c = new Property(2, String.class, "resolution", false, "RESOLUTION");
    public static final Property d = new Property(3, Boolean.class, "isLiveMuteAudio", false, "IS_LIVE_MUTE_AUDIO");
    public static final Property e = new Property(4, Boolean.class, "isPlayBackMuteAudio", false, "IS_PLAY_BACK_MUTE_AUDIO");
    public static final Property f = new Property(5, String.class, "preImageUrl", false, "PRE_IMAGE_URL");
    public static final Property g = new Property(6, Integer.class, "relayServerPort", false, "RELAY_SERVER_PORT");
    public static final Property h = new Property(7, String.class, "localPassword", false, "LOCAL_PASSWORD");
    public static final Property i = new Property(8, Long.class, "motorLastResetTime", false, "MOTOR_LAST_RESET_TIME");
    public static final Property j = new Property(9, Long.class, "motorLastCruiseVerticalTime", false, "MOTOR_LAST_CRUISE_VERTICAL_TIME");
    public static final Property k = new Property(10, Long.class, "motorLastCruiseHorizontalTime", false, "MOTOR_LAST_CRUISE_HORIZONTAL_TIME");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediaother\database\model\DeviceInfoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */