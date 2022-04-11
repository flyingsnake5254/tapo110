package org.greenrobot.greendao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.test.AndroidTestCase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.InternalUnitTestDaoAccess;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.SqlUtils;

public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K>
  extends AbstractDaoTest<D, T, K>
{
  private Property pkColumn;
  protected Set<K> usedPks = new HashSet();
  
  public AbstractDaoTestSinglePk(Class<D> paramClass)
  {
    super(paramClass);
  }
  
  protected boolean checkKeyIsNullable()
  {
    if (createEntity(null) == null)
    {
      DaoLog.d("Test is not available for entities with non-null keys");
      return false;
    }
    return true;
  }
  
  protected abstract T createEntity(K paramK);
  
  protected T createEntityWithRandomPk()
  {
    return (T)createEntity(nextPk());
  }
  
  protected abstract K createRandomPk();
  
  protected K nextPk()
  {
    for (int i = 0; i < 100000; i++)
    {
      Object localObject = createRandomPk();
      if (this.usedPks.add(localObject)) {
        return (K)localObject;
      }
    }
    throw new IllegalStateException("Could not find a new PK");
  }
  
  protected Cursor queryWithDummyColumnsInFront(int paramInt, String paramString, K paramK)
  {
    Object localObject = new StringBuilder("SELECT ");
    int i = 0;
    for (int j = 0; j < paramInt; j++)
    {
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
    }
    SqlUtils.appendColumns((StringBuilder)localObject, "T", this.dao.getAllColumns()).append(" FROM ");
    ((StringBuilder)localObject).append('"');
    ((StringBuilder)localObject).append(this.dao.getTablename());
    ((StringBuilder)localObject).append('"');
    ((StringBuilder)localObject).append(" T");
    if (paramK != null)
    {
      ((StringBuilder)localObject).append(" WHERE ");
      AndroidTestCase.assertEquals(1, this.dao.getPkColumns().length);
      ((StringBuilder)localObject).append(this.dao.getPkColumns()[0]);
      ((StringBuilder)localObject).append("=");
      DatabaseUtils.appendValueToSql((StringBuilder)localObject, paramK);
    }
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.db.rawQuery((String)localObject, null);
    AndroidTestCase.assertTrue(((Cursor)localObject).moveToFirst());
    j = i;
    for (;;)
    {
      if (j < paramInt) {
        try
        {
          AndroidTestCase.assertEquals(paramString, ((Cursor)localObject).getString(j));
          j++;
        }
        catch (RuntimeException paramString)
        {
          break label236;
        }
      }
    }
    if (paramK != null)
    {
      AndroidTestCase.assertEquals(1, ((Cursor)localObject).getCount());
      break label245;
      label236:
      ((Cursor)localObject).close();
      throw paramString;
    }
    label245:
    return (Cursor)localObject;
  }
  
  protected void runLoadPkTest(int paramInt)
  {
    Object localObject1 = nextPk();
    Object localObject3 = createEntity(localObject1);
    this.dao.insert(localObject3);
    localObject3 = queryWithDummyColumnsInFront(paramInt, "42", localObject1);
    try
    {
      AndroidTestCase.assertEquals(localObject1, this.daoAccess.readKey((Cursor)localObject3, paramInt));
      return;
    }
    finally
    {
      ((Cursor)localObject3).close();
    }
  }
  
  protected void setUp()
    throws Exception
  {
    super.setUp();
    for (Property localProperty : this.daoAccess.getProperties()) {
      if (localProperty.primaryKey) {
        if (this.pkColumn == null) {
          this.pkColumn = localProperty;
        } else {
          throw new RuntimeException("Test does not work with multiple PK columns");
        }
      }
    }
    if (this.pkColumn != null) {
      return;
    }
    throw new RuntimeException("Test does not work without a PK column");
  }
  
  public void testCount()
  {
    this.dao.deleteAll();
    AndroidTestCase.assertEquals(0L, this.dao.count());
    this.dao.insert(createEntityWithRandomPk());
    AndroidTestCase.assertEquals(1L, this.dao.count());
    this.dao.insert(createEntityWithRandomPk());
    AndroidTestCase.assertEquals(2L, this.dao.count());
  }
  
  public void testDelete()
  {
    Object localObject1 = nextPk();
    this.dao.deleteByKey(localObject1);
    Object localObject2 = createEntity(localObject1);
    this.dao.insert(localObject2);
    AndroidTestCase.assertNotNull(this.dao.load(localObject1));
    this.dao.deleteByKey(localObject1);
    AndroidTestCase.assertNull(this.dao.load(localObject1));
  }
  
  public void testDeleteAll()
  {
    Object localObject1 = new ArrayList();
    for (int i = 0; i < 10; i++) {
      ((List)localObject1).add(createEntityWithRandomPk());
    }
    this.dao.insertInTx((Iterable)localObject1);
    this.dao.deleteAll();
    AndroidTestCase.assertEquals(0L, this.dao.count());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      localObject2 = this.daoAccess.getKey(localObject2);
      AndroidTestCase.assertNotNull(localObject2);
      AndroidTestCase.assertNull(this.dao.load(localObject2));
    }
  }
  
  public void testDeleteByKeyInTx()
  {
    Object localObject1 = new ArrayList();
    for (int i = 0; i < 10; i++) {
      ((List)localObject1).add(createEntityWithRandomPk());
    }
    this.dao.insertInTx((Iterable)localObject1);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(this.daoAccess.getKey(((List)localObject1).get(0)));
    ((List)localObject2).add(this.daoAccess.getKey(((List)localObject1).get(3)));
    ((List)localObject2).add(this.daoAccess.getKey(((List)localObject1).get(4)));
    ((List)localObject2).add(this.daoAccess.getKey(((List)localObject1).get(8)));
    this.dao.deleteByKeyInTx((Iterable)localObject2);
    AndroidTestCase.assertEquals(((List)localObject1).size() - ((List)localObject2).size(), this.dao.count());
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      AndroidTestCase.assertNotNull(localObject2);
      AndroidTestCase.assertNull(this.dao.load(localObject2));
    }
  }
  
  public void testDeleteInTx()
  {
    Object localObject1 = new ArrayList();
    for (int i = 0; i < 10; i++) {
      ((List)localObject1).add(createEntityWithRandomPk());
    }
    this.dao.insertInTx((Iterable)localObject1);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(((List)localObject1).get(0));
    ((List)localObject2).add(((List)localObject1).get(3));
    ((List)localObject2).add(((List)localObject1).get(4));
    ((List)localObject2).add(((List)localObject1).get(8));
    this.dao.deleteInTx((Iterable)localObject2);
    AndroidTestCase.assertEquals(((List)localObject1).size() - ((List)localObject2).size(), this.dao.count());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      localObject1 = this.daoAccess.getKey(localObject1);
      AndroidTestCase.assertNotNull(localObject1);
      AndroidTestCase.assertNull(this.dao.load(localObject1));
    }
  }
  
  public void testInsertAndLoad()
  {
    Object localObject1 = nextPk();
    Object localObject2 = createEntity(localObject1);
    this.dao.insert(localObject2);
    AndroidTestCase.assertEquals(localObject1, this.daoAccess.getKey(localObject2));
    localObject1 = this.dao.load(localObject1);
    AndroidTestCase.assertNotNull(localObject1);
    AndroidTestCase.assertEquals(this.daoAccess.getKey(localObject2), this.daoAccess.getKey(localObject1));
  }
  
  public void testInsertInTx()
  {
    this.dao.deleteAll();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < 20; i++) {
      localArrayList.add(createEntityWithRandomPk());
    }
    this.dao.insertInTx(localArrayList);
    AndroidTestCase.assertEquals(localArrayList.size(), this.dao.count());
  }
  
  public void testInsertOrReplaceInTx()
  {
    this.dao.deleteAll();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (int i = 0; i < 20; i++)
    {
      Object localObject = createEntityWithRandomPk();
      if (i % 2 == 0) {
        localArrayList1.add(localObject);
      }
      localArrayList2.add(localObject);
    }
    this.dao.insertOrReplaceInTx(localArrayList1);
    this.dao.insertOrReplaceInTx(localArrayList2);
    AndroidTestCase.assertEquals(localArrayList2.size(), this.dao.count());
  }
  
  public void testInsertOrReplaceTwice()
  {
    Object localObject = createEntityWithRandomPk();
    long l1 = this.dao.insert(localObject);
    long l2 = this.dao.insertOrReplace(localObject);
    if (this.dao.getPkProperty().type == Long.class) {
      AndroidTestCase.assertEquals(l1, l2);
    }
  }
  
  public void testInsertTwice()
  {
    Object localObject = createEntity(nextPk());
    this.dao.insert(localObject);
    try
    {
      this.dao.insert(localObject);
      AndroidTestCase.fail("Inserting twice should not work");
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;) {}
    }
  }
  
  public void testLoadAll()
  {
    this.dao.deleteAll();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < 15; i++) {
      localArrayList.add(createEntity(nextPk()));
    }
    this.dao.insertInTx(localArrayList);
    List localList = this.dao.loadAll();
    AndroidTestCase.assertEquals(localArrayList.size(), localList.size());
  }
  
  public void testLoadPk()
  {
    runLoadPkTest(0);
  }
  
  public void testLoadPkWithOffset()
  {
    runLoadPkTest(10);
  }
  
  public void testQuery()
  {
    this.dao.insert(createEntityWithRandomPk());
    Object localObject1 = nextPk();
    this.dao.insert(createEntity(localObject1));
    this.dao.insert(createEntityWithRandomPk());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("WHERE ");
    ((StringBuilder)localObject2).append(this.dao.getPkColumns()[0]);
    ((StringBuilder)localObject2).append("=?");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject2 = this.dao.queryRaw((String)localObject2, new String[] { localObject1.toString() });
    AndroidTestCase.assertEquals(1, ((List)localObject2).size());
    AndroidTestCase.assertEquals(localObject1, this.daoAccess.getKey(((List)localObject2).get(0)));
  }
  
  public void testReadWithOffset()
  {
    Object localObject1 = nextPk();
    Object localObject3 = createEntity(localObject1);
    this.dao.insert(localObject3);
    localObject3 = queryWithDummyColumnsInFront(5, "42", localObject1);
    try
    {
      Object localObject4 = this.daoAccess.readEntity((Cursor)localObject3, 5);
      AndroidTestCase.assertEquals(localObject1, this.daoAccess.getKey(localObject4));
      return;
    }
    finally
    {
      ((Cursor)localObject3).close();
    }
  }
  
  public void testRowId()
  {
    Object localObject1 = createEntityWithRandomPk();
    Object localObject2 = createEntityWithRandomPk();
    boolean bool;
    if (this.dao.insert(localObject1) != this.dao.insert(localObject2)) {
      bool = true;
    } else {
      bool = false;
    }
    AndroidTestCase.assertTrue(bool);
  }
  
  public void testSave()
  {
    if (!checkKeyIsNullable()) {
      return;
    }
    this.dao.deleteAll();
    Object localObject = createEntity(null);
    if (localObject != null)
    {
      this.dao.save(localObject);
      this.dao.save(localObject);
      AndroidTestCase.assertEquals(1L, this.dao.count());
    }
  }
  
  public void testSaveInTx()
  {
    if (!checkKeyIsNullable()) {
      return;
    }
    this.dao.deleteAll();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (int i = 0; i < 20; i++)
    {
      Object localObject = createEntity(null);
      if (i % 2 == 0) {
        localArrayList1.add(localObject);
      }
      localArrayList2.add(localObject);
    }
    this.dao.saveInTx(localArrayList1);
    this.dao.saveInTx(localArrayList2);
    AndroidTestCase.assertEquals(localArrayList2.size(), this.dao.count());
  }
  
  public void testUpdate()
  {
    this.dao.deleteAll();
    Object localObject = createEntityWithRandomPk();
    this.dao.insert(localObject);
    this.dao.update(localObject);
    AndroidTestCase.assertEquals(1L, this.dao.count());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\test\AbstractDaoTestSinglePk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */