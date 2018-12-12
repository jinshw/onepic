function createIndexDB(dbName, version,callback) {//根据数据库名称和数据库版本号来打开或者新建一个数据库
    var version = version || 1;
    var request = window.indexedDB.open(dbName, version);
    request.onerror = function (e) { //新建或打开数据失败的回调函数
        console.log(e);
    };

    request.onsuccess = function (e) { //新建或打开数据库成功的回调
        mydb.db = e.target.result; // 把result赋值给对象属性
        if(typeof callback == 'function'){
            callback();
        }
    };

    //初始化object store  也可以//删除object store
    request.onupgradeneeded = function (e) {
        var db = e.target.result;
        if (!db.objectStoreNames.contains('Maps')) { //是否包含员工这个对象
            //db.createObjectStore('Employees',{keyPath:'id'}); // keyPath 指定对象的哪个属性作为主键
            //db.createObjectStore('Employees',{autoIncrement:true}); //keyGenerate   主键自增长 ，任意值，
            var store = db.createObjectStore('Maps', {keyPath: 'id'}); // 同时返回一个store
            store.createIndex('listIndex', 'list', {unique: true}); //创建name的索引
            // store.createIndex('datasIndex', 'datas', {unique: true});//创建age的索引
        }
        /*//删除object store
        if(db.objectStoreNames.contains('Employees')) {  //先查询是否存在
            db.deleteObjectStore('Employees');
        }*/

        console.log("db version change to" + version);
    };

}

var mydb = {
    name: 'firstDB',
    version: 1, //只能是整数，3.31--->会转成3
    db: null
};
// employee数据
var employee = [{
    id: 'lx001',
    name: 'lucas',
    age: 20
},
    {
        id: 'lx002',
        name: 'lucy',
        age: 18
    },
    {
        id: 'lx003',
        name: 'mike',
        age: 22
    },
    {
        id: 'lx004',
        name: 'susan',
        age: 21
    }
];

//添加数据
function addData(db, storename,data) {
    var transaction = db.transaction(storename, "readwrite");//首先获取事务
    var store = transaction.objectStore(storename);//根据事务获取对应的storename获取我们新建数据库的store
    // for (var i = 0; i < employee.length; i++) {//遍历我们的数据
    //     store.add(employee[i]);//add到store中
    // }
    store.add(data);//add到store中
}

//使用游标来获取值，结合索引
function getDataByFetch(db, storename, indexType, indexName) {
    var transaction = db.transaction(storename);
    var store = transaction.objectStore(storename);
    var index = store.index(indexType); //
    var request = index.openCursor(IDBKeyRange.only(indexName)); //打开游标，得到一个请求；store打开的是哪个类型的索引，only中就是哪个索引的值
    request.onsuccess = function (e) {
        var cursor = e.target.result;
        if (cursor) {
            console.log(cursor.key)
            var e = cursor.value;
            console.log(e);
            cursor.continue(); //游标下一位，没有会返回undefined
        }
    }
}


//根据id获取数据
function getDataByKey(db, storename, id ,callback) {
    var transaction = db.transaction(storename, 'readwrite');//先获取事务
    var store = transaction.objectStore(storename);//获取object store
    var req = store.get(id); // 根据指定的keyPath的值查询 即id值
    req.onsuccess = function (e) {
        var vals = e.target.result;
        console.log(vals);
        if(typeof callback === "function"){
            callback(vals);
        }
    }
}

//利用索引来获取值
function getDataByIndex(db, storename, indexType, indexName) {
    var transaction = db.transaction(storename);//根据storename获取事务
    var store = transaction.objectStore(storename); //storename为参数用事务获取store
    var index = store.index(indexType);//使用index方法获取IDBIndex对象
    index.get(indexName).onsuccess = function (e) {
        var e = e.target.result;
        console.log(e);
    }
}

//同时也可以使用游标来获取值，结合索引
function getDataByFetch(db, storename, indexType, indexName) {
    var transaction = db.transaction(storename);
    var store = transaction.objectStore(storename);
    var index = store.index(indexType); //
    var request = index.openCursor(IDBKeyRange.only(indexName)); //打开游标，得到一个请求；store打开的是哪个类型的索引，only中就是哪个索引的值
    request.onsuccess = function (e) {
        var cursor = e.target.result;
        if (cursor) {
            console.log(cursor.key)
            var e = cursor.value;
            console.log(e);
            cursor.continue(); //游标下一位，没有会返回undefined
        }
    }
}

// 更新数据
function updateData(db, storename, id) {
    var transaction = db.transaction(storename, 'readwrite'); //获取事务
    var store = transaction.objectStore(storename);// 得到指定的object store
    var req = store.get(id);//根据id查找指定的对象
    req.onsuccess = function (e) {
        var employee = e.target.result;//得到对象
        employee.age = 19;//修改值
        store.put(employee);//将修改之后的值放回指定的object store中
    };
}


// 根据id删除指定数据
function deleteData(db, storename, id) {
    var transaction = db.transaction(storename, 'readwrite');//获取事务
    var store = transaction.objectStore(storename); // 得到对应的object store
    store.delete(id);// 根据id删除对应store中的数据
}

//清空object　store
function clearStore(db, storename,callback) {
    var transaction = db.transaction(storename, 'readwrite'); // 首先获取事务
    var store = transaction.objectStore(storename); //其次得到指定的object store
    store.clear(); // store调用clear方法
    callback();
}



