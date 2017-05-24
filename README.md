## Android APP架构思考


从2011年到现在，做了几年的Android应用与Android平台上Opengl es应用开发，下面是关于Android APP开发架构的一些思考：

构建框架的最终目的是增强项目代码的**可读性 ，维护性 和方便测试** ，如果背离了这个初衷，为了使用而使用，最终是得不偿失的。

从根本上来讲，要解决上述的三个问题，核心思想无非两种：**一个是分层 ，一个是模块化** 。两个方法最终要实现的就是解耦，分层讲的是纵向层面上的解耦，模块化则是横向上的解耦。

在写Android APP相关代码时，如果“**客户端只做数据展示，不做用户交互逻辑**”这样的APP，基本Bug都很少。思考其原因，可能是这样的APP代码逻辑简单。

我们知道 **代码越简单、易读，越不易出bug**，但APP功能越来越复杂，代码量越来越多，好像随之代码也会越来越复杂。

### 一、那我们能不能设计一个，`只做数据展示，不做用户交互`的APP架构呢？
![这里写图片描述](http://img.blog.csdn.net/20170521091447663?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveGlheGw=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 
上边的截图，是关于 **只做数据展示，不做用户交互**的APP架构思考。

朋友们可能已经注意到，这是典型的MVC。
这里Model层来管理数据，并继承Observable，而每一个controller(Activity)均实现Observer。这样若某一个Activity需要获取某一种类型Model数据时，只要在其对应Model中注册观察者。

### 二、下边是关于上图的简单介绍：
+ (1)、用户触发登录——>帐号密码请求服务器——>服务端返回登录数据——>登录model(登录model存登录用户数据)——>登录model通知“登录Controller”——>更新登录页面UI
                                                                                                            ——>登录model(登录model存登录用户数据)——>登录model通知“更新用户详情Controller”——>更新用户详情页面UI
+ (2)、这里model为被观察者,controller可根据需要在相应model进行观察者注册,这样model层中对应数据发生变化时，对应的controller便可收到页面更新的通知，完成页面更新。

### 三、那`只做数据展示，不做用户交互`又是怎么回事呢？

+ (1)、这里通过Model把用户操作转化为数据更新( 用户操作——>Model——>回调所有的观察者Observer(controller)——>更新UI )
+ (2) 、另一个好处是，可以用这套回调机制，替换Android中的广播来传递消息(单进程中)
        所有数据的变化，均通知对应的数据Model，通过Model回调到对应的Activity，Activity再更新UI

### 四、目前这种小架构是可以满足一般业务量APP需求的，那随着`业务量的增大，该如何设计APP框架呢`？

以上的框架图是可以满足一般的Android APP业务需求的。但如果客户端功能越来越复杂，可`按业务分为不同的功能模块`，模块内部使用以上介绍的框架和通信方式。
`模块内部，采用观察者回调进行通信；模块之间采用广播(或者其他进程间通信方式)进行通信`：
![这里写图片描述](http://img.blog.csdn.net/20170521091529180?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveGlheGw=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 
这里以广播举例：
+ 1、主模块内部采用事件回调进行通信
+ 2、主模块使用广播将事件传递给子模块
+ 3、每个子模块内部采用事件回调进行通信

### 五、与MVP MVC的比较

#### 在`无用户UI操作`介入时`小架构`MVC之间的关系如下
![这里写图片描述](http://img.blog.csdn.net/20170524155554688?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveGlheGw=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
正好与MVP的不谋而合，MVP三者的关系如下：

![enter image description here](http://img.blog.csdn.net/20170520083318991?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveGlheGw=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

关于MVP的文章，可参考[Android MVC MVP MVVM](http://blog.csdn.net/xiaxl/article/details/72593871)

#### 在`用户UI操作`介入后`小架构`MVC之间的关系如下
![这里写图片描述](http://img.blog.csdn.net/20170524155708299?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveGlheGw=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

传统的MVC模型如下：
![enter image description here](http://img.blog.csdn.net/20170520083218154?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveGlheGw=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

关于MVC的文章，可参考[Android MVC MVP MVVM](http://blog.csdn.net/xiaxl/article/details/72593871)

PS: **由此可见，`小框架`与传统的MVC又也有所不同，算`是MVC的一个变种`，`类似于MVP`**





