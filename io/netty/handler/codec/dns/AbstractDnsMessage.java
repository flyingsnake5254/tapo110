package io.netty.handler.codec.dns;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractDnsMessage
  extends AbstractReferenceCounted
  implements DnsMessage
{
  private static final int SECTION_COUNT = 4;
  private static final int SECTION_QUESTION = DnsSection.QUESTION.ordinal();
  private static final ResourceLeakDetector<DnsMessage> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DnsMessage.class);
  private Object additionals;
  private Object answers;
  private Object authorities;
  private short id;
  private final ResourceLeakTracker<DnsMessage> leak = leakDetector.track(this);
  private DnsOpCode opCode;
  private Object questions;
  private boolean recursionDesired;
  private byte z;
  
  protected AbstractDnsMessage(int paramInt)
  {
    this(paramInt, DnsOpCode.QUERY);
  }
  
  protected AbstractDnsMessage(int paramInt, DnsOpCode paramDnsOpCode)
  {
    setId(paramInt);
    setOpCode(paramDnsOpCode);
  }
  
  private void addRecord(int paramInt1, int paramInt2, DnsRecord paramDnsRecord)
  {
    checkQuestion(paramInt1, paramDnsRecord);
    Object localObject = sectionAt(paramInt1);
    if (localObject == null)
    {
      if (paramInt2 == 0)
      {
        setSection(paramInt1, paramDnsRecord);
        return;
      }
      paramDnsRecord = new StringBuilder();
      paramDnsRecord.append("index: ");
      paramDnsRecord.append(paramInt2);
      paramDnsRecord.append(" (expected: 0)");
      throw new IndexOutOfBoundsException(paramDnsRecord.toString());
    }
    if ((localObject instanceof DnsRecord))
    {
      ArrayList localArrayList;
      if (paramInt2 == 0)
      {
        localArrayList = newRecordList();
        localArrayList.add(paramDnsRecord);
        localArrayList.add(castRecord(localObject));
        paramDnsRecord = localArrayList;
      }
      else
      {
        if (paramInt2 != 1) {
          break label156;
        }
        localArrayList = newRecordList();
        localArrayList.add(castRecord(localObject));
        localArrayList.add(paramDnsRecord);
        paramDnsRecord = localArrayList;
      }
      setSection(paramInt1, paramDnsRecord);
      return;
      label156:
      paramDnsRecord = new StringBuilder();
      paramDnsRecord.append("index: ");
      paramDnsRecord.append(paramInt2);
      paramDnsRecord.append(" (expected: 0 or 1)");
      throw new IndexOutOfBoundsException(paramDnsRecord.toString());
    }
    ((List)localObject).add(paramInt2, paramDnsRecord);
  }
  
  private void addRecord(int paramInt, DnsRecord paramDnsRecord)
  {
    checkQuestion(paramInt, paramDnsRecord);
    Object localObject = sectionAt(paramInt);
    if (localObject == null)
    {
      setSection(paramInt, paramDnsRecord);
      return;
    }
    if ((localObject instanceof DnsRecord))
    {
      ArrayList localArrayList = newRecordList();
      localArrayList.add(castRecord(localObject));
      localArrayList.add(paramDnsRecord);
      setSection(paramInt, localArrayList);
      return;
    }
    ((List)localObject).add(paramDnsRecord);
  }
  
  private static <T extends DnsRecord> T castRecord(Object paramObject)
  {
    return (DnsRecord)paramObject;
  }
  
  private static DnsRecord checkQuestion(int paramInt, DnsRecord paramDnsRecord)
  {
    if ((paramInt == SECTION_QUESTION) && (!(ObjectUtil.checkNotNull(paramDnsRecord, "record") instanceof DnsQuestion)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("record: ");
      localStringBuilder.append(paramDnsRecord);
      localStringBuilder.append(" (expected: ");
      localStringBuilder.append(StringUtil.simpleClassName(DnsQuestion.class));
      localStringBuilder.append(')');
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramDnsRecord;
  }
  
  private void clear(int paramInt)
  {
    Object localObject = sectionAt(paramInt);
    setSection(paramInt, null);
    if ((localObject instanceof ReferenceCounted))
    {
      ((ReferenceCounted)localObject).release();
    }
    else if ((localObject instanceof List))
    {
      localObject = (List)localObject;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ReferenceCountUtil.release(((Iterator)localObject).next());
        }
      }
    }
  }
  
  private int count(int paramInt)
  {
    Object localObject = sectionAt(paramInt);
    if (localObject == null) {
      return 0;
    }
    if ((localObject instanceof DnsRecord)) {
      return 1;
    }
    return ((List)localObject).size();
  }
  
  private static ArrayList<DnsRecord> newRecordList()
  {
    return new ArrayList(2);
  }
  
  private <T extends DnsRecord> T recordAt(int paramInt)
  {
    Object localObject = sectionAt(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof DnsRecord)) {
      return castRecord(localObject);
    }
    localObject = (List)localObject;
    if (((List)localObject).isEmpty()) {
      return null;
    }
    return castRecord(((List)localObject).get(0));
  }
  
  private <T extends DnsRecord> T recordAt(int paramInt1, int paramInt2)
  {
    Object localObject = sectionAt(paramInt1);
    if (localObject != null)
    {
      if ((localObject instanceof DnsRecord))
      {
        if (paramInt2 == 0) {
          return castRecord(localObject);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("index: ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("' (expected: 0)");
        throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
      }
      return castRecord(((List)localObject).get(paramInt2));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("index: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" (expected: none)");
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  private <T extends DnsRecord> T removeRecord(int paramInt1, int paramInt2)
  {
    Object localObject = sectionAt(paramInt1);
    if (localObject != null)
    {
      if ((localObject instanceof DnsRecord))
      {
        if (paramInt2 == 0)
        {
          localObject = castRecord(localObject);
          setSection(paramInt1, null);
          return (T)localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("index: ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" (expected: 0)");
        throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
      }
      return castRecord(((List)localObject).remove(paramInt2));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("index: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" (expected: none)");
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  private Object sectionAt(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return this.additionals;
          }
          throw new Error();
        }
        return this.authorities;
      }
      return this.answers;
    }
    return this.questions;
  }
  
  private static int sectionOrdinal(DnsSection paramDnsSection)
  {
    return ((DnsSection)ObjectUtil.checkNotNull(paramDnsSection, "section")).ordinal();
  }
  
  private <T extends DnsRecord> T setRecord(int paramInt1, int paramInt2, DnsRecord paramDnsRecord)
  {
    checkQuestion(paramInt1, paramDnsRecord);
    Object localObject = sectionAt(paramInt1);
    if (localObject != null)
    {
      if ((localObject instanceof DnsRecord))
      {
        if (paramInt2 == 0)
        {
          setSection(paramInt1, paramDnsRecord);
          return castRecord(localObject);
        }
        paramDnsRecord = new StringBuilder();
        paramDnsRecord.append("index: ");
        paramDnsRecord.append(paramInt2);
        paramDnsRecord.append(" (expected: 0)");
        throw new IndexOutOfBoundsException(paramDnsRecord.toString());
      }
      return castRecord(((List)localObject).set(paramInt2, paramDnsRecord));
    }
    paramDnsRecord = new StringBuilder();
    paramDnsRecord.append("index: ");
    paramDnsRecord.append(paramInt2);
    paramDnsRecord.append(" (expected: none)");
    throw new IndexOutOfBoundsException(paramDnsRecord.toString());
  }
  
  private void setRecord(int paramInt, DnsRecord paramDnsRecord)
  {
    clear(paramInt);
    setSection(paramInt, checkQuestion(paramInt, paramDnsRecord));
  }
  
  private void setSection(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            this.additionals = paramObject;
            return;
          }
          throw new Error();
        }
        this.authorities = paramObject;
        return;
      }
      this.answers = paramObject;
      return;
    }
    this.questions = paramObject;
  }
  
  public DnsMessage addRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord)
  {
    addRecord(sectionOrdinal(paramDnsSection), paramInt, paramDnsRecord);
    return this;
  }
  
  public DnsMessage addRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    addRecord(sectionOrdinal(paramDnsSection), paramDnsRecord);
    return this;
  }
  
  public DnsMessage clear()
  {
    for (int i = 0; i < 4; i++) {
      clear(i);
    }
    return this;
  }
  
  public DnsMessage clear(DnsSection paramDnsSection)
  {
    clear(sectionOrdinal(paramDnsSection));
    return this;
  }
  
  public int count()
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j += count(i);
      i++;
    }
    return j;
  }
  
  public int count(DnsSection paramDnsSection)
  {
    return count(sectionOrdinal(paramDnsSection));
  }
  
  protected void deallocate()
  {
    clear();
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.close(this);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DnsMessage)) {
      return false;
    }
    paramObject = (DnsMessage)paramObject;
    if (id() != ((DnsMessage)paramObject).id()) {
      return false;
    }
    if ((this instanceof DnsQuery))
    {
      if (!(paramObject instanceof DnsQuery)) {
        return false;
      }
    }
    else if ((paramObject instanceof DnsQuery)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return id() * 31 + (this instanceof DnsQuery ^ true);
  }
  
  public int id()
  {
    return this.id & 0xFFFF;
  }
  
  public boolean isRecursionDesired()
  {
    return this.recursionDesired;
  }
  
  public DnsOpCode opCode()
  {
    return this.opCode;
  }
  
  public <T extends DnsRecord> T recordAt(DnsSection paramDnsSection)
  {
    return recordAt(sectionOrdinal(paramDnsSection));
  }
  
  public <T extends DnsRecord> T recordAt(DnsSection paramDnsSection, int paramInt)
  {
    return recordAt(sectionOrdinal(paramDnsSection), paramInt);
  }
  
  public <T extends DnsRecord> T removeRecord(DnsSection paramDnsSection, int paramInt)
  {
    return removeRecord(sectionOrdinal(paramDnsSection), paramInt);
  }
  
  public DnsMessage retain()
  {
    return (DnsMessage)super.retain();
  }
  
  public DnsMessage retain(int paramInt)
  {
    return (DnsMessage)super.retain(paramInt);
  }
  
  public DnsMessage setId(int paramInt)
  {
    this.id = ((short)(short)paramInt);
    return this;
  }
  
  public DnsMessage setOpCode(DnsOpCode paramDnsOpCode)
  {
    this.opCode = ((DnsOpCode)ObjectUtil.checkNotNull(paramDnsOpCode, "opCode"));
    return this;
  }
  
  public DnsMessage setRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    setRecord(sectionOrdinal(paramDnsSection), paramDnsRecord);
    return this;
  }
  
  public <T extends DnsRecord> T setRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord)
  {
    return setRecord(sectionOrdinal(paramDnsSection), paramInt, paramDnsRecord);
  }
  
  public DnsMessage setRecursionDesired(boolean paramBoolean)
  {
    this.recursionDesired = paramBoolean;
    return this;
  }
  
  public DnsMessage setZ(int paramInt)
  {
    this.z = ((byte)(byte)(paramInt & 0x7));
    return this;
  }
  
  public DnsMessage touch()
  {
    return (DnsMessage)super.touch();
  }
  
  public DnsMessage touch(Object paramObject)
  {
    ResourceLeakTracker localResourceLeakTracker = this.leak;
    if (localResourceLeakTracker != null) {
      localResourceLeakTracker.record(paramObject);
    }
    return this;
  }
  
  public int z()
  {
    return this.z;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\AbstractDnsMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */