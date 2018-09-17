csdn 原始文档：
https://blog.csdn.net/xiaxl/article/details/72593871


# Android  MVC MVP MVVM


注：
本篇文章中，提供的MVC MVP MVVM 写法的Demo，与Google的标准写法会存在些许不同(`本文案例demo是基于google的标准写法和自己这几年的工作总结，进行调整后的写法，自认为非常适合自己也比较适合大众的写法`)


## MVC

MVC的关系图如下：

![enter image description here](https://github.com/xiaxveliang/Android_APPArchitecture_Demo/blob/normal_mvvm/image/0001.png)

之前做过一个变种MVC的Demo：
https://github.com/xiaxveliang/Android_APPArchitecture_Demo/tree/master
该Demo的相关文档介绍：
https://blog.csdn.net/xiaxl/article/details/72593945

## MVP

MVP模式是对MVC模式的改进

+ 将Activity亦看做是一个View，负责UI展示；
+ 抽象出一个Presenter层，处理业务逻辑操作；
+ Model层用来获取"Remote数据"或"已缓存到本地的数据"；

View与Presenter、Model与Presenter均通过接口进行数据交换，从而实现Model层与View层进行解耦。

### todo-mvp 

Model、View、Presenter的关系如下图所以：

![enter image description here](https://github.com/xiaxveliang/Android_APPArchitecture_Demo/blob/normal_mvvm/image/0002.png)

对MVP最好的了解方式，其实是`googlesamples的todo-mvp`的demo：
[googlesamples的todo-mvp](https://github.com/googlesamples/android-architecture/tree/todo-mvp)

对 todo-mvp 不进行介绍...

### 我喜欢的MVP写法

`googlesamples的todo-mvp`的代码相对较多，这里我做了一个简单Demo (这个Demo是我喜欢的写法)，源码地址如下：
[Android_APPArchitecture_Demo 工程 normal_mvp 分支](https://github.com/xiaxveliang/Android_APPArchitecture_Demo/tree/normal_mvp)

**这里的Demo与google的todo-mvp 有些不同，具体表现在：**

+ Presenter只负责Model与View的解耦，不包含相关业务逻辑操作；Presenter拿到Model的数据后，不做任何处理直接回调到对应的Activity；
+ Activity拿到数据后，根据数据直接更新UI。

**为什么这么写，这里有一个思考：**

怎么样写业务代码更简单，`我认为"只做UI展示"不包含“用户交互”的业务逻辑最简单`。那有没有一种代码的写法，可以把用户操作，转化为一种UI的更新操作？

这里我给出的方案是：`将“用户交互”转化为一种数据更新`

+ 用户对View的操作，全部回调到对应的Activity；
+ Activity通过持有的Presenter 向对应的Model 请求数据资源，最终会被转化为UI更新；

架构图如下：

![enter image description here](https://github.com/xiaxveliang/Android_APPArchitecture_Demo/blob/normal_mvvm/image/0003.png)

## MVVM



### todo-mvvm-databinding

Model、View、Presenter的关系如下图所以：

![enter image description here](https://github.com/xiaxveliang/Android_APPArchitecture_Demo/blob/normal_mvvm/image/0004.png)

对MVVM最好的了解方式，其实是`googlesamples的todo-mvvm-databinding`的demo：
[googlesamples的todo-mvvm-databinding](https://github.com/googlesamples/android-architecture/tree/todo-mvvm-databinding/)

对 todo-mvvm-databinding 不进行介绍...


### 做了一个Demo

`googlesamples的todo-mvvm-databinding`的代码相对较多，这里我做了一个简单Demo (这个Demo是我喜欢的写法)，源码地址如下：
[Android_APPArchitecture_Demo 工程 normal_mvvm 分支]
https://github.com/xiaxveliang/Android_APPArchitecture_Demo/tree/normal_mvvm


