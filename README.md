[![](https://jitpack.io/v/sam38124/JzFixLanguage.svg)](https://jitpack.io/#sam38124/JzFixLanguage)
[![Platform](https://img.shields.io/badge/平台-%20Android%20-brightgreen.svg)](https://github.com/sam38124)
[![characteristic](https://img.shields.io/badge/特點-%20輕量級%20%7C%20簡單易用%20%20%7C%20穩定%20-brightgreen.svg)](https://github.com/sam38124)
# JzFixLanguage
因為最近業務頻繁要求更改多國語言的文案，加上已有超過10項以上的上架APP，改起來的工程十分號大，所以開發一個框架用來多國語言的臨時修改，當產品未需進行重大更新，即可在網路路徑上臨時修改多國語言，待下次版本更新時在修改!!
## 目錄
* [如何導入到專案](#Import)
* [開始使用](#Use)
* [關於我](#About)

<a name="Import"></a>
## 如何導入到項目
> 支持jcenter。 <br/>

### jcenter導入方式
在app專案包的build.gradle中添加
```kotlin
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

在需要用到這個庫的module中的build.gradle中的dependencies中加入
```kotlin
dependencies {
  implementation 'com.github.sam38124:JzFixLanguage:2.1'}
```
<a name="Use"></a>
## 快速使用

### 1.建立TXT，輸入修改內容，並且儲存編碼格式為UTF-8，將檔案置於你的伺服器路徑
#### * 第一行為版本號，用來判斷是否要進行更新
```kotlin
"version"="1.0";
```
#### * 之後的每一行為修改內容，將錯誤字元修改為正確字元
```kotlin
"錯誤字元"="正確字元";
```
#### * "必須使用 \ "進行轉義
### 2.開始使用
#### * 於Application添加此行代碼
```kotlin
//https://demo.txt
 FixLanguage.newInstance.setUP(this,"https://demo.txt",object :callback{
            override fun result(a: Boolean) {
                Log.e("加載結果","$a")
            }
        })
```
#### * 修正rootView裡面的內容(會自動遍歷內容進行多國語言的修改，無需修正的話則不修改)
```kotlin
//Activity中
var rootView=findViewById<View>(android.R.id.content).rootView.fixLanguage()
rootView.fixLanguage()
//Fragment中
var  rootview = inflater.inflate(layoutID, container, false)
rootView.fixLanguage()
```
#### * 取得修正內容(無需修正的話則返回原來的值)
```kotlin
resources.jzString(R.string.repl)
```


<a name="About"></a>
### 關於我
橙的電子android and ios developer

*line:sam38124

*gmail:sam38124@gmail.com
