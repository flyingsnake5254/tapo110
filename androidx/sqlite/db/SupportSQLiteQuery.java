package androidx.sqlite.db;

public abstract interface SupportSQLiteQuery
{
  public abstract void bindTo(SupportSQLiteProgram paramSupportSQLiteProgram);
  
  public abstract int getArgCount();
  
  public abstract String getSql();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\sqlite\db\SupportSQLiteQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */