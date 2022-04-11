package com.tplink.libtpmediaother.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class ModeSettingInfoDao
  extends AbstractDao<e, Void>
{
  public static final String TABLENAME = "MODE_SETTING_INFO";
  private final e.c a = new e.c();
  private final e.c b = new e.c();
  private final e.a c = new e.a();
  private final e.b d = new e.b();
  private final e.a e = new e.a();
  
  public ModeSettingInfoDao(DaoConfig paramDaoConfig, b paramb)
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
    localStringBuilder.append("\"MODE_SETTING_INFO\" (\"DEVICE_ID_MD5\" TEXT,\"IN_HOME_MODE\" INTEGER NOT NULL ,\"NOTIFICATION_ENABLE\" INTEGER NOT NULL ,\"DETECTION_ENABLE\" INTEGER NOT NULL ,\"HUMAN_RECOGNITION_ENABLED\" INTEGER NOT NULL ,\"BABY_CRYING_DETECTION_ENABLED\" INTEGER NOT NULL ,\"HUMAN_ENHANCED_ENABLED\" INTEGER NOT NULL ,\"TARGET_TRACK_ENABLED\" INTEGER NOT NULL ,\"BABY_CRYING_DETECTION_SENSITIVITY\" INTEGER NOT NULL ,\"SENSITIVITY\" INTEGER NOT NULL ,\"ALARM_ENABLED\" INTEGER NOT NULL ,\"ALARM_SOUND_ENABLED\" INTEGER NOT NULL ,\"ALARM_LIGHT_ENABLED\" INTEGER NOT NULL ,\"SCHEDULE_ENABLED\" INTEGER NOT NULL ,\"ALARM_SOUND_TYPE\" TEXT,\"ALARM_START_HOUR\" INTEGER NOT NULL ,\"ALARM_START_MINUTE\" INTEGER NOT NULL ,\"ALARM_END_HOUR\" INTEGER NOT NULL ,\"ALARM_END_MINUTE\" INTEGER NOT NULL ,\"ALARM_DAYS\" INTEGER NOT NULL ,\"MSG_PUSH_NOTIFICATION_ENABLED\" INTEGER NOT NULL ,\"MSG_PUSH_RICH_NOTIFICATION_ENABLED\" INTEGER NOT NULL ,\"MSG_PUSH_SCHEDULE_ENABLED\" INTEGER NOT NULL ,\"MSG_PUSH_START_HOUR\" INTEGER NOT NULL ,\"MSG_PUSH_START_MINUTE\" INTEGER NOT NULL ,\"MSG_PUSH_END_HOUR\" INTEGER NOT NULL ,\"MSG_PUSH_END_MINUTE\" INTEGER NOT NULL ,\"MSG_PUSH_DAYS\" INTEGER NOT NULL ,\"REGION_LIST\" TEXT NOT NULL ,\"TAMPER_DETECTION_ENABLED\" INTEGER NOT NULL ,\"AREA_INTRUSION_DETECTION_ENABLED\" INTEGER NOT NULL ,\"LINE_CROSSING_DETECTION_ENABLED\" INTEGER NOT NULL ,\"TAMPER_SENSITIVITY\" TEXT,\"AREA_INTRUSION_REGION_LIST\" TEXT,\"AREA_INTRUSION_ARM_SCHEDULE_INFO\" TEXT,\"LINE_CROSSING_REGION_LIST\" TEXT,\"LINE_CROSSING_ARM_SCHEDULE_INFO\" TEXT);");
    paramDatabase.execSQL(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE UNIQUE INDEX ");
    localStringBuilder.append(str);
    localStringBuilder.append("IDX_MODE_SETTING_INFO_DEVICE_ID_MD5_IN_HOME_MODE ON \"MODE_SETTING_INFO\" (\"DEVICE_ID_MD5\" ASC,\"IN_HOME_MODE\" ASC);");
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
    localStringBuilder.append("\"MODE_SETTING_INFO\"");
    paramDatabase.execSQL(localStringBuilder.toString());
  }
  
  protected final void a(SQLiteStatement paramSQLiteStatement, e parame)
  {
    paramSQLiteStatement.clearBindings();
    Object localObject = parame.q();
    if (localObject != null) {
      paramSQLiteStatement.bindString(1, (String)localObject);
    }
    boolean bool = parame.t();
    long l1 = 1L;
    long l2;
    if (bool) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(2, l2);
    if (parame.G()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(3, l2);
    if (parame.p()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(4, l2);
    if (parame.s()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(5, l2);
    if (parame.n()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(6, l2);
    if (parame.r()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(7, l2);
    if (parame.M()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(8, l2);
    paramSQLiteStatement.bindLong(9, parame.o());
    paramSQLiteStatement.bindLong(10, parame.J());
    if (parame.c()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(11, l2);
    if (parame.g()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(12, l2);
    if (parame.f()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(13, l2);
    if (parame.I()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(14, l2);
    localObject = parame.h();
    if (localObject != null) {
      paramSQLiteStatement.bindString(15, (String)localObject);
    }
    paramSQLiteStatement.bindLong(16, parame.i());
    paramSQLiteStatement.bindLong(17, parame.j());
    paramSQLiteStatement.bindLong(18, parame.d());
    paramSQLiteStatement.bindLong(19, parame.e());
    paramSQLiteStatement.bindLong(20, parame.b());
    if (parame.B()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(21, l2);
    if (parame.C()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(22, l2);
    if (parame.D()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(23, l2);
    paramSQLiteStatement.bindLong(24, parame.E());
    paramSQLiteStatement.bindLong(25, parame.F());
    paramSQLiteStatement.bindLong(26, parame.z());
    paramSQLiteStatement.bindLong(27, parame.A());
    paramSQLiteStatement.bindLong(28, parame.y());
    paramSQLiteStatement.bindString(29, this.a.a(parame.H()));
    if (parame.K()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(30, l2);
    if (parame.l()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(31, l2);
    if (parame.v()) {
      l2 = l1;
    } else {
      l2 = 0L;
    }
    paramSQLiteStatement.bindLong(32, l2);
    localObject = parame.L();
    if (localObject != null) {
      paramSQLiteStatement.bindString(33, (String)localObject);
    }
    localObject = parame.m();
    if (localObject != null) {
      paramSQLiteStatement.bindString(34, this.b.a((List)localObject));
    }
    localObject = parame.k();
    if (localObject != null) {
      paramSQLiteStatement.bindString(35, this.c.a((e.a)localObject));
    }
    localObject = parame.w();
    if (localObject != null) {
      paramSQLiteStatement.bindString(36, this.d.b((List)localObject));
    }
    parame = parame.u();
    if (parame != null) {
      paramSQLiteStatement.bindString(37, this.e.a(parame));
    }
  }
  
  protected final void b(DatabaseStatement paramDatabaseStatement, e parame)
  {
    paramDatabaseStatement.clearBindings();
    Object localObject = parame.q();
    if (localObject != null) {
      paramDatabaseStatement.bindString(1, (String)localObject);
    }
    boolean bool = parame.t();
    long l1 = 1L;
    long l2;
    if (bool) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(2, l2);
    if (parame.G()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(3, l2);
    if (parame.p()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(4, l2);
    if (parame.s()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(5, l2);
    if (parame.n()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(6, l2);
    if (parame.r()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(7, l2);
    if (parame.M()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(8, l2);
    paramDatabaseStatement.bindLong(9, parame.o());
    paramDatabaseStatement.bindLong(10, parame.J());
    if (parame.c()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(11, l2);
    if (parame.g()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(12, l2);
    if (parame.f()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(13, l2);
    if (parame.I()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(14, l2);
    localObject = parame.h();
    if (localObject != null) {
      paramDatabaseStatement.bindString(15, (String)localObject);
    }
    paramDatabaseStatement.bindLong(16, parame.i());
    paramDatabaseStatement.bindLong(17, parame.j());
    paramDatabaseStatement.bindLong(18, parame.d());
    paramDatabaseStatement.bindLong(19, parame.e());
    paramDatabaseStatement.bindLong(20, parame.b());
    if (parame.B()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(21, l2);
    if (parame.C()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(22, l2);
    if (parame.D()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(23, l2);
    paramDatabaseStatement.bindLong(24, parame.E());
    paramDatabaseStatement.bindLong(25, parame.F());
    paramDatabaseStatement.bindLong(26, parame.z());
    paramDatabaseStatement.bindLong(27, parame.A());
    paramDatabaseStatement.bindLong(28, parame.y());
    paramDatabaseStatement.bindString(29, this.a.a(parame.H()));
    if (parame.K()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(30, l2);
    if (parame.l()) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(31, l2);
    if (parame.v()) {
      l2 = l1;
    } else {
      l2 = 0L;
    }
    paramDatabaseStatement.bindLong(32, l2);
    localObject = parame.L();
    if (localObject != null) {
      paramDatabaseStatement.bindString(33, (String)localObject);
    }
    localObject = parame.m();
    if (localObject != null) {
      paramDatabaseStatement.bindString(34, this.b.a((List)localObject));
    }
    localObject = parame.k();
    if (localObject != null) {
      paramDatabaseStatement.bindString(35, this.c.a((e.a)localObject));
    }
    localObject = parame.w();
    if (localObject != null) {
      paramDatabaseStatement.bindString(36, this.d.b((List)localObject));
    }
    parame = parame.u();
    if (parame != null) {
      paramDatabaseStatement.bindString(37, this.e.a(parame));
    }
  }
  
  public Void e(e parame)
  {
    return null;
  }
  
  public boolean f(e parame)
  {
    return false;
  }
  
  public e g(Cursor paramCursor, int paramInt)
  {
    int i = paramInt + 0;
    String str1;
    if (paramCursor.isNull(i)) {
      str1 = null;
    } else {
      str1 = paramCursor.getString(i);
    }
    boolean bool1;
    if (paramCursor.getShort(paramInt + 1) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (paramCursor.getShort(paramInt + 2) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if (paramCursor.getShort(paramInt + 3) != 0) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if (paramCursor.getShort(paramInt + 4) != 0) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool5;
    if (paramCursor.getShort(paramInt + 5) != 0) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    boolean bool6;
    if (paramCursor.getShort(paramInt + 6) != 0) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    boolean bool7;
    if (paramCursor.getShort(paramInt + 7) != 0) {
      bool7 = true;
    } else {
      bool7 = false;
    }
    i = paramCursor.getInt(paramInt + 8);
    int j = paramCursor.getInt(paramInt + 9);
    boolean bool8;
    if (paramCursor.getShort(paramInt + 10) != 0) {
      bool8 = true;
    } else {
      bool8 = false;
    }
    boolean bool9;
    if (paramCursor.getShort(paramInt + 11) != 0) {
      bool9 = true;
    } else {
      bool9 = false;
    }
    boolean bool10;
    if (paramCursor.getShort(paramInt + 12) != 0) {
      bool10 = true;
    } else {
      bool10 = false;
    }
    boolean bool11;
    if (paramCursor.getShort(paramInt + 13) != 0) {
      bool11 = true;
    } else {
      bool11 = false;
    }
    int k = paramInt + 14;
    String str2;
    if (paramCursor.isNull(k)) {
      str2 = null;
    } else {
      str2 = paramCursor.getString(k);
    }
    int m = paramCursor.getInt(paramInt + 15);
    k = paramCursor.getInt(paramInt + 16);
    int n = paramCursor.getInt(paramInt + 17);
    int i1 = paramCursor.getInt(paramInt + 18);
    int i2 = paramCursor.getInt(paramInt + 19);
    boolean bool12;
    if (paramCursor.getShort(paramInt + 20) != 0) {
      bool12 = true;
    } else {
      bool12 = false;
    }
    boolean bool13;
    if (paramCursor.getShort(paramInt + 21) != 0) {
      bool13 = true;
    } else {
      bool13 = false;
    }
    boolean bool14;
    if (paramCursor.getShort(paramInt + 22) != 0) {
      bool14 = true;
    } else {
      bool14 = false;
    }
    int i3 = paramCursor.getInt(paramInt + 23);
    int i4 = paramCursor.getInt(paramInt + 24);
    int i5 = paramCursor.getInt(paramInt + 25);
    int i6 = paramCursor.getInt(paramInt + 26);
    int i7 = paramCursor.getInt(paramInt + 27);
    List localList1 = this.a.b(paramCursor.getString(paramInt + 28));
    boolean bool15;
    if (paramCursor.getShort(paramInt + 29) != 0) {
      bool15 = true;
    } else {
      bool15 = false;
    }
    boolean bool16;
    if (paramCursor.getShort(paramInt + 30) != 0) {
      bool16 = true;
    } else {
      bool16 = false;
    }
    boolean bool17;
    if (paramCursor.getShort(paramInt + 31) != 0) {
      bool17 = true;
    } else {
      bool17 = false;
    }
    int i8 = paramInt + 32;
    String str3;
    if (paramCursor.isNull(i8)) {
      str3 = null;
    } else {
      str3 = paramCursor.getString(i8);
    }
    i8 = paramInt + 33;
    List localList2;
    if (paramCursor.isNull(i8)) {
      localList2 = null;
    } else {
      localList2 = this.b.b(paramCursor.getString(i8));
    }
    i8 = paramInt + 34;
    e.a locala;
    if (paramCursor.isNull(i8)) {
      locala = null;
    } else {
      locala = this.c.b(paramCursor.getString(i8));
    }
    i8 = paramInt + 35;
    List localList3;
    if (paramCursor.isNull(i8)) {
      localList3 = null;
    } else {
      localList3 = this.d.c(paramCursor.getString(i8));
    }
    paramInt += 36;
    if (paramCursor.isNull(paramInt)) {
      paramCursor = null;
    } else {
      paramCursor = this.e.b(paramCursor.getString(paramInt));
    }
    return new e(str1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, i, j, bool8, bool9, bool10, bool11, str2, m, k, n, i1, i2, bool12, bool13, bool14, i3, i4, i5, i6, i7, localList1, bool15, bool16, bool17, str3, localList2, locala, localList3, paramCursor);
  }
  
  public void h(Cursor paramCursor, e parame, int paramInt)
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
    parame.f0((String)localObject2);
    i = paramCursor.getShort(paramInt + 1);
    boolean bool2 = true;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.i0(bool1);
    if (paramCursor.getShort(paramInt + 2) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.u0(bool1);
    if (paramCursor.getShort(paramInt + 3) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.e0(bool1);
    if (paramCursor.getShort(paramInt + 4) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.h0(bool1);
    if (paramCursor.getShort(paramInt + 5) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.c0(bool1);
    if (paramCursor.getShort(paramInt + 6) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.g0(bool1);
    if (paramCursor.getShort(paramInt + 7) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.A0(bool1);
    parame.d0(paramCursor.getInt(paramInt + 8));
    parame.x0(paramCursor.getInt(paramInt + 9));
    if (paramCursor.getShort(paramInt + 10) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.R(bool1);
    if (paramCursor.getShort(paramInt + 11) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.V(bool1);
    if (paramCursor.getShort(paramInt + 12) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.U(bool1);
    if (paramCursor.getShort(paramInt + 13) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.w0(bool1);
    i = paramInt + 14;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    parame.W((String)localObject2);
    parame.X(paramCursor.getInt(paramInt + 15));
    parame.Y(paramCursor.getInt(paramInt + 16));
    parame.S(paramCursor.getInt(paramInt + 17));
    parame.T(paramCursor.getInt(paramInt + 18));
    parame.Q(paramCursor.getInt(paramInt + 19));
    if (paramCursor.getShort(paramInt + 20) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.p0(bool1);
    if (paramCursor.getShort(paramInt + 21) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.q0(bool1);
    if (paramCursor.getShort(paramInt + 22) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.r0(bool1);
    parame.s0(paramCursor.getInt(paramInt + 23));
    parame.t0(paramCursor.getInt(paramInt + 24));
    parame.n0(paramCursor.getInt(paramInt + 25));
    parame.o0(paramCursor.getInt(paramInt + 26));
    parame.m0(paramCursor.getInt(paramInt + 27));
    parame.v0(this.a.b(paramCursor.getString(paramInt + 28)));
    if (paramCursor.getShort(paramInt + 29) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.y0(bool1);
    if (paramCursor.getShort(paramInt + 30) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    parame.a0(bool1);
    if (paramCursor.getShort(paramInt + 31) != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    parame.k0(bool1);
    i = paramInt + 32;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = paramCursor.getString(i);
    }
    parame.z0((String)localObject2);
    i = paramInt + 33;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = this.b.b(paramCursor.getString(i));
    }
    parame.b0((List)localObject2);
    i = paramInt + 34;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = this.c.b(paramCursor.getString(i));
    }
    parame.Z((e.a)localObject2);
    i = paramInt + 35;
    if (paramCursor.isNull(i)) {
      localObject2 = null;
    } else {
      localObject2 = this.d.c(paramCursor.getString(i));
    }
    parame.l0((List)localObject2);
    paramInt += 36;
    if (paramCursor.isNull(paramInt)) {
      paramCursor = (Cursor)localObject1;
    } else {
      paramCursor = this.e.b(paramCursor.getString(paramInt));
    }
    parame.j0(paramCursor);
  }
  
  public Void i(Cursor paramCursor, int paramInt)
  {
    return null;
  }
  
  protected final boolean isEntityUpdateable()
  {
    return true;
  }
  
  protected final Void j(e parame, long paramLong)
  {
    return null;
  }
  
  public static class Properties
  {
    public static final Property A;
    public static final Property B;
    public static final Property C;
    public static final Property D;
    public static final Property E;
    public static final Property F;
    public static final Property G = new Property(32, String.class, "tamperSensitivity", false, "TAMPER_SENSITIVITY");
    public static final Property H = new Property(33, String.class, "areaIntrusionRegionList", false, "AREA_INTRUSION_REGION_LIST");
    public static final Property I = new Property(34, String.class, "areaIntrusionArmScheduleInfo", false, "AREA_INTRUSION_ARM_SCHEDULE_INFO");
    public static final Property J = new Property(35, String.class, "lineCrossingRegionList", false, "LINE_CROSSING_REGION_LIST");
    public static final Property K = new Property(36, String.class, "lineCrossingArmScheduleInfo", false, "LINE_CROSSING_ARM_SCHEDULE_INFO");
    public static final Property a = new Property(0, String.class, "deviceIdMD5", false, "DEVICE_ID_MD5");
    public static final Property b;
    public static final Property c;
    public static final Property d;
    public static final Property e;
    public static final Property f;
    public static final Property g;
    public static final Property h;
    public static final Property i;
    public static final Property j;
    public static final Property k;
    public static final Property l;
    public static final Property m;
    public static final Property n;
    public static final Property o;
    public static final Property p;
    public static final Property q;
    public static final Property r;
    public static final Property s;
    public static final Property t;
    public static final Property u;
    public static final Property v;
    public static final Property w;
    public static final Property x;
    public static final Property y;
    public static final Property z;
    
    static
    {
      Class localClass1 = Boolean.TYPE;
      b = new Property(1, localClass1, "inHomeMode", false, "IN_HOME_MODE");
      c = new Property(2, localClass1, "notificationEnable", false, "NOTIFICATION_ENABLE");
      d = new Property(3, localClass1, "detectionEnable", false, "DETECTION_ENABLE");
      e = new Property(4, localClass1, "humanRecognitionEnabled", false, "HUMAN_RECOGNITION_ENABLED");
      f = new Property(5, localClass1, "babyCryingDetectionEnabled", false, "BABY_CRYING_DETECTION_ENABLED");
      g = new Property(6, localClass1, "humanEnhancedEnabled", false, "HUMAN_ENHANCED_ENABLED");
      h = new Property(7, localClass1, "targetTrackEnabled", false, "TARGET_TRACK_ENABLED");
      Class localClass2 = Integer.TYPE;
      i = new Property(8, localClass2, "babyCryingDetectionSensitivity", false, "BABY_CRYING_DETECTION_SENSITIVITY");
      j = new Property(9, localClass2, "sensitivity", false, "SENSITIVITY");
      k = new Property(10, localClass1, "alarmEnabled", false, "ALARM_ENABLED");
      l = new Property(11, localClass1, "alarmSoundEnabled", false, "ALARM_SOUND_ENABLED");
      m = new Property(12, localClass1, "alarmLightEnabled", false, "ALARM_LIGHT_ENABLED");
      n = new Property(13, localClass1, "scheduleEnabled", false, "SCHEDULE_ENABLED");
      o = new Property(14, String.class, "alarmSoundType", false, "ALARM_SOUND_TYPE");
      p = new Property(15, localClass2, "alarmStartHour", false, "ALARM_START_HOUR");
      q = new Property(16, localClass2, "alarmStartMinute", false, "ALARM_START_MINUTE");
      r = new Property(17, localClass2, "alarmEndHour", false, "ALARM_END_HOUR");
      s = new Property(18, localClass2, "alarmEndMinute", false, "ALARM_END_MINUTE");
      t = new Property(19, localClass2, "alarmDays", false, "ALARM_DAYS");
      u = new Property(20, localClass1, "msgPushNotificationEnabled", false, "MSG_PUSH_NOTIFICATION_ENABLED");
      v = new Property(21, localClass1, "msgPushRichNotificationEnabled", false, "MSG_PUSH_RICH_NOTIFICATION_ENABLED");
      w = new Property(22, localClass1, "msgPushScheduleEnabled", false, "MSG_PUSH_SCHEDULE_ENABLED");
      x = new Property(23, localClass2, "msgPushStartHour", false, "MSG_PUSH_START_HOUR");
      y = new Property(24, localClass2, "msgPushStartMinute", false, "MSG_PUSH_START_MINUTE");
      z = new Property(25, localClass2, "msgPushEndHour", false, "MSG_PUSH_END_HOUR");
      A = new Property(26, localClass2, "msgPushEndMinute", false, "MSG_PUSH_END_MINUTE");
      B = new Property(27, localClass2, "msgPushDays", false, "MSG_PUSH_DAYS");
      C = new Property(28, String.class, "regionList", false, "REGION_LIST");
      D = new Property(29, localClass1, "tamperDetectionEnabled", false, "TAMPER_DETECTION_ENABLED");
      E = new Property(30, localClass1, "areaIntrusionDetectionEnabled", false, "AREA_INTRUSION_DETECTION_ENABLED");
      F = new Property(31, localClass1, "lineCrossingDetectionEnabled", false, "LINE_CROSSING_DETECTION_ENABLED");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediaother\database\model\ModeSettingInfoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */