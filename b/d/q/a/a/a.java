package b.d.q.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tplink.libtpmediaother.database.model.DeviceInfoDao;
import com.tplink.libtpmediaother.database.model.FileMemoryInfoDao;
import com.tplink.libtpmediaother.database.model.ModeSettingInfoDao;
import com.tplink.libtpmediaother.database.model.a.a;
import org.greenrobot.greendao.database.Database;

public class a
  extends a.a
{
  private static com.tplink.libtpmediaother.database.model.a c;
  private static com.tplink.libtpmediaother.database.model.b d;
  
  public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    super(paramContext, paramString, paramCursorFactory);
  }
  
  public static com.tplink.libtpmediaother.database.model.a a(Context paramContext)
  {
    if (c == null) {
      c = new com.tplink.libtpmediaother.database.model.a(new a(paramContext, "tpCamera-db", null).getWritableDatabase());
    }
    return c;
  }
  
  public static com.tplink.libtpmediaother.database.model.b c(Context paramContext)
  {
    if (d == null)
    {
      if (c == null) {
        c = a(paramContext);
      }
      d = c.c();
    }
    return d;
  }
  
  public void onUpgrade(Database paramDatabase, int paramInt1, int paramInt2)
  {
    b.d.w.c.a.e("DaoHelper", "onUpGrade");
    b.d().g(paramDatabase, new Class[] { DeviceInfoDao.class, FileMemoryInfoDao.class, ModeSettingInfoDao.class });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\q\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */