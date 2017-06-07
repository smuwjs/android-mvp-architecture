# android-mvp-architecture
[ ![Download](https://api.bintray.com/packages/smuwjs/maven/arch/images/download.svg) ](https://bintray.com/smuwjs/maven/arch/_latestVersion)
[ ![Build Status](https://travis-ci.org/smuwjs/android-mvp-architecture.svg?branch=master) ](https://travis-ci.org/smuwjs/android-mvp-architecture)
[ ![API](https://img.shields.io/badge/API-15%2B-blue.svg?style=flat-square) ](https://developer.android.com/about/versions/android-4.0.3.html)
[ ![License](http://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square) ](http://www.apache.org/licenses/LICENSE-2.0)

## This repository contains a detailed sample app that implements MVP architecture using Dagger2, RxJava, Retrofit and so on, to make your developing quicker and easier.

[中文说明](README-zh.md)

## Architectural
![架构图](doc/uml/architecture.png "架构图")

## Reference 
1. [JessYanCoding/MVPArms](https://github.com/JessYanCoding/MVPArms)

## Usage
If you are building a new project, directly to the entire project **clone** (or download), as **Demo** as the main module, then the package name into their own package name , **Demo** contains the package structure can be used directly, a mainstream `MVP` +` Dagger2` + `Retrofit` +` Rxjava` framework so easy to build successful, and now you refer **Demo Mvp** Package under the **UserActivity** format,Use Template to automatically generate MVP, Dagger2 related classes under the corresponding package, with access to [Wiki documents](https://github.com/smuwjs/android-mvp-architecture/wiki).

## Wiki
[Detailed usage reference Wiki](https://github.com/smuwjs/android-mvp-architecture/wiki)

## Functionality & Libraries
1. [`Mvp` Google's official` Mvp` architecture project, which contains several different schema branches (this is the Dagger branch).](https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger/)
2. [`Dagger2`](https://github.com/google/dagger)
3. [`Rxjava`](https://github.com/ReactiveX/RxJava)
4. [`RxAndroid`](https://github.com/ReactiveX/RxAndroid)
5. [`Rxlifecycle`](https://github.com/trello/RxLifecycle)
6. [`RxCache`](https://github.com/VictorAlbertos/RxCache)
7. [`RxPermissions`](https://github.com/tbruyelle/RxPermissions)
8. [`RxErroHandler`](https://github.com/JessYanCoding/RxErrorHandler)
9. [`Retrofit`](https://github.com/square/retrofit)
10. [`Okhttp`](https://github.com/square/okhttp)
11. [`Autolayout`](https://github.com/hongyangAndroid/AndroidAutoLayout)
12. [`Gson`](https://github.com/google/gson)
13. [`Butterknife`](https://github.com/JakeWharton/butterknife)
14. [`Androideventbus`](https://github.com/hehonghui/AndroidEventBus)
15. [`Timber`](https://github.com/JakeWharton/timber)
16. [`Glide`](https://github.com/bumptech/glide)
17. [`LeakCanary`](https://github.com/square/leakcanary)



## Acknowledgements 
Thanks to all the three libraries used in this framework **Author**, and all for the 'Open Sourece' selfless contributions **Developer** and **Organizations**, so that we can better work and study, I will also spare time return to the open source community

## License
``` 
 Copyright 2017, jeeson      
  
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at 
 
       http://www.apache.org/licenses/LICENSE-2.0 

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
