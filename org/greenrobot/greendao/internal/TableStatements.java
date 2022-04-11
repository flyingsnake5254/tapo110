package org.greenrobot.greendao.internal;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

public class TableStatements
{
  private final String[] allColumns;
  private DatabaseStatement countStatement;
  private final Database db;
  private DatabaseStatement deleteStatement;
  private DatabaseStatement insertOrReplaceStatement;
  private DatabaseStatement insertStatement;
  private final String[] pkColumns;
  private volatile String selectAll;
  private volatile String selectByKey;
  private volatile String selectByRowId;
  private volatile String selectKeys;
  private final String tablename;
  private DatabaseStatement updateStatement;
  
  public TableStatements(Database paramDatabase, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.db = paramDatabase;
    this.tablename = paramString;
    this.allColumns = paramArrayOfString1;
    this.pkColumns = paramArrayOfString2;
  }
  
  public DatabaseStatement getCountStatement()
  {
    if (this.countStatement == null)
    {
      String str = SqlUtils.createSqlCount(this.tablename);
      this.countStatement = this.db.compileStatement(str);
    }
    return this.countStatement;
  }
  
  public DatabaseStatement getDeleteStatement()
  {
    if (this.deleteStatement == null)
    {
      Object localObject1 = SqlUtils.createSqlDelete(this.tablename, this.pkColumns);
      localObject1 = this.db.compileStatement((String)localObject1);
      try
      {
        if (this.deleteStatement == null) {
          this.deleteStatement = ((DatabaseStatement)localObject1);
        }
        if (this.deleteStatement != localObject1) {
          ((DatabaseStatement)localObject1).close();
        }
      }
      finally {}
    }
    return this.deleteStatement;
  }
  
  public DatabaseStatement getInsertOrReplaceStatement()
  {
    if (this.insertOrReplaceStatement == null)
    {
      Object localObject1 = SqlUtils.createSqlInsert("INSERT OR REPLACE INTO ", this.tablename, this.allColumns);
      localObject1 = this.db.compileStatement((String)localObject1);
      try
      {
        if (this.insertOrReplaceStatement == null) {
          this.insertOrReplaceStatement = ((DatabaseStatement)localObject1);
        }
        if (this.insertOrReplaceStatement != localObject1) {
          ((DatabaseStatement)localObject1).close();
        }
      }
      finally {}
    }
    return this.insertOrReplaceStatement;
  }
  
  public DatabaseStatement getInsertStatement()
  {
    if (this.insertStatement == null)
    {
      Object localObject1 = SqlUtils.createSqlInsert("INSERT INTO ", this.tablename, this.allColumns);
      localObject1 = this.db.compileStatement((String)localObject1);
      try
      {
        if (this.insertStatement == null) {
          this.insertStatement = ((DatabaseStatement)localObject1);
        }
        if (this.insertStatement != localObject1) {
          ((DatabaseStatement)localObject1).close();
        }
      }
      finally {}
    }
    return this.insertStatement;
  }
  
  public String getSelectAll()
  {
    if (this.selectAll == null) {
      this.selectAll = SqlUtils.createSqlSelect(this.tablename, "T", this.allColumns, false);
    }
    return this.selectAll;
  }
  
  public String getSelectByKey()
  {
    if (this.selectByKey == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(getSelectAll());
      localStringBuilder.append("WHERE ");
      SqlUtils.appendColumnsEqValue(localStringBuilder, "T", this.pkColumns);
      this.selectByKey = localStringBuilder.toString();
    }
    return this.selectByKey;
  }
  
  public String getSelectByRowId()
  {
    if (this.selectByRowId == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getSelectAll());
      localStringBuilder.append("WHERE ROWID=?");
      this.selectByRowId = localStringBuilder.toString();
    }
    return this.selectByRowId;
  }
  
  public String getSelectKeys()
  {
    if (this.selectKeys == null) {
      this.selectKeys = SqlUtils.createSqlSelect(this.tablename, "T", this.pkColumns, false);
    }
    return this.selectKeys;
  }
  
  public DatabaseStatement getUpdateStatement()
  {
    if (this.updateStatement == null)
    {
      Object localObject1 = SqlUtils.createSqlUpdate(this.tablename, this.allColumns, this.pkColumns);
      localObject1 = this.db.compileStatement((String)localObject1);
      try
      {
        if (this.updateStatement == null) {
          this.updateStatement = ((DatabaseStatement)localObject1);
        }
        if (this.updateStatement != localObject1) {
          ((DatabaseStatement)localObject1).close();
        }
      }
      finally {}
    }
    return this.updateStatement;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\internal\TableStatements.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */