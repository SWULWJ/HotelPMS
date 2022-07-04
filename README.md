# StoreRecord接口文档

### n：根据Id查询库存

#### c：

* URL：/queryStoreById

* Input： 

    ```java
    String Id
    ```

* Output： `List<StoreRecords>`

#### s：忽略

#### d：忽略

---

### n：新增一条库存记录

#### c：

* URL：/addStoreRecords

* Input： 

 ```java
 	String id
 	String name
 	String amount
 	String price
 ```

* Output： `List<StoreRecords>`

#### s：草，走，忽略ጿ ኈ ቼ ዽ ጿ

#### d：草，走，忽略ጿ ኈ ቼ ዽ ጿ

---

### n：更新一条库存记录

#### c：

* URL：/updateStoreRecords

* Input： 

 ```java
	String id
	String name
	String amount
	String price
 ```

* Output： `"success" or "failed"   `

#### s：草，走，忽略ጿ ኈ ቼ ዽ ጿ

#### d：草，走，忽略ጿ ኈ ቼ ዽ ጿ

---

### n：删除一条库存记录

#### c：

* URL：/deleteStoreRecords

* Input： 

 ```java
	String id
	String name
	String amount
	String price
 ```

* Output： `"success" or "failed"   `

#### s：草，走，忽略ጿ ኈ ቼ ዽ ጿ

#### d：草，走，忽略ጿ ኈ ቼ ዽ ጿ

---

### n：展示库存列表

#### c：

* URL：/queryAllStoreRecords

* Input： `null`

* Output： `"success" or "failed"   `

#### s：草，走，忽略ጿ ኈ ቼ ዽ ጿ

#### d：草，走，忽略ጿ ኈ ቼ ዽ ጿ

---

### n：通过名字查询所有库存

#### c：

* URL：/queryStoreRecordsByName

* Input：

```java
	String name;
```

* Output： `List<StoreRecords>   `

#### s：草，走，忽略ጿ ኈ ቼ ዽ ጿ

#### d：草，走，忽略ጿ ኈ ቼ ዽ ጿ