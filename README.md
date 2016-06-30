# AndroidEdit

####EditText的撤销和恢复撤销操作
#####使用
* 引入库
	* 待上传
* 初始化

```java
    mEditText = ((EditText) findViewById(R.id.editText));
    //创建PerformEdit，一定要传入不为空的EditText
    mPerformEdit = new PerformEdit(mEditText);
    mPerformEdit.setDefaultText("这是初始值,不做撤销记录");
```

* 撤销和恢复

```java
	//撤销
	mPerformEdit.undo();
    //重做
    mPerformEdit.redo();
    //清除历史
    mPerformEdit.clearHistory();
```

* 演示图

	![Image](image/image.gif)


