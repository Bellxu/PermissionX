# PermissionX

PermissionX是我按照郭霖老师的<<第一行代码>>写的

我原来想按照书里去jcenter里的发布的但是发现他不免费了 所以我用了jitpack

如果想用PermissionX 请先添加

```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

如果是高版本的gradle,请在settings.gradle里添加
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://www.jitpack.io' }
    }
}
```

然后在所需要的项目的build.gradle里添加

```groovy
dependencies {
    ...
    implementation 'com.github.Bellxu:PermissionX:1.1'
}
```
然后就可以使用了
```kotlin
        PermissionX.request(this,Manifest.permission.CALL_PHONE){
            allGranted,deniedList->
            if (allGranted) {
                doCall()
            }else{
                Toast.makeText(this,"权限被拒:$deniedList",Toast.LENGTH_SHORT).show()
            }
        }
```
