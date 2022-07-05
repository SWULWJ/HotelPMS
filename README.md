# StoreRecord接口文档

### n：根据Id查询库存

#### c：

* URL：/queryStoreRecordsById

* Input： 

    ```java
    String Id
    ```

* Output： `List<StoreRecords>`

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

* Output： `"success" or "failed"`

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

---

### n：展示库存列表

#### c：

* URL：/queryAllStoreRecords

* Input： `null`

* Output： `List<StoreRecords>   `

---

### n：通过名字查询所有库存

#### c：

* URL：/queryStoreRecordsByName

* Input：

```java
	String name;
```

* Output： `List<StoreRecords>   `
