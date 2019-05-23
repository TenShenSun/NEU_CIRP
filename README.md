# NEU_CIRP
NEU 校园信息发布平台

功能描述：

​	信息发布平台，设置角色权限（官方账号，社团账号，个人账号），按照发布时间排序，可以通过类别筛选，类别有（官方，社团，失物招领，二手交易，表白墙，（可以设置匿名），其他）六个类别。

图标：https://www.iconfont.cn/

2天完成，5.5—5.7

目前需要解决：

1. 第一版第一张图（孙做）
2. 微信获取用户登录消息（微信登录），获取用户信息（谢做）（绑定学号待定）
3. 找图标（谢做）
4. 数据库（韬韬）
5. 后台（生做）
6. 和孙联调，传json（我和韬韬）ajax，from

git

1. 先pull再push

2. 有冲突先解决冲突

   
## 数据库设计 v1
三张表，用户表（user）、消息表（information）、类型消息关联表（type_info）。用户表和消息表一对多关联，类型消息关联表和消息表一对多关联。具体数据库中属性和表设计图在数据库设计文件夹中。

## 数据库设计 v2

新增behavior表记录用户行为，info_fav_read中间表用于记录用户与消息之间的收藏查看关系，更新用户表中头像链接字段和性别字段，更新数据库设计文件夹中属性和表设计图。



## 后台实现 v1

使用SSM框架  
前后台交互举例  
### User 用户表控制
增删改查使用Restful风格  

url | Method | Type
---|---|---
/user | RequestMethod.POST | 增加
/user/{id} | RequestMethod.GET | 查询
/user/{id} | RequestMethod.DELETE | 删除
/user | RequestMethod.PUT | 更新
### TypeInfo 类型表控制
url | Method | Type
---|---|---
/typeInfo | RequestMethod.POST | 增加
/typeInfo/{id} | RequestMethod.GET | 查询
/typeInfo/{id} | RequestMethod.DELETE | 删除
/typeInfo | RequestMethod.PUT | 更新
### Information 信息表控制
url | Method | Type
---|---|---
/information | RequestMethod.POST | 增加
/information/{id} | RequestMethod.GET | 查询
/information/{id} | RequestMethod.DELETE | 删除
/information | RequestMethod.PUT | 更新
### 具体json交互 
#### post，put
1. 设置header
content-type:application/json  
![image](https://note.youdao.com/yws/public/resource/b206b0696902b63dba4730bf7b2d837a/xmlnote/DC00D0A6FA1C4F049A1E97E87FBBD767/22137)  
2. 构造json数据  
![image](https://note.youdao.com/yws/public/resource/b206b0696902b63dba4730bf7b2d837a/xmlnote/E870E41A99F445F9867FDAF7E5F8D07F/22134)  

#### get,delete
1. 设置参数
![image](https://note.youdao.com/yws/public/resource/b206b0696902b63dba4730bf7b2d837a/xmlnote/6F51867C666F4DB89CB8C2F16FF00021/22155)



### mybatis插件分页实现

> [github地址](https://github.com/pagehelper/Mybatis-PageHelper )

### 通用Mapper

<https://github.com/abel533/Mapper> 



分页：

物理分页（就是直接通过SQL进行在数据库中直接分页,得到的数据就是我们想要分页之后的数据） 

拦截器：

拦截器在流行的开源框架中很常见，其依赖的技术就是Java的动态代理。

- 业务组件：被代理和被拦截的对象
- 代理处理器：实现了InvocationHandler接口的一个对象
- 代理对象：Proxy对象
- 拦截器：普通的JavaBean，在调用业务方法之前或者之后自动拦截并执行自己的一些方法
- 客户端：执行业务处理的入口







## 前端实现

### 上传图片到七牛云

1. 上传图片有两种方式：

（1）通过服务器，将文件上传到服务端，由服务端上传到七牛云

（2）通过前端js，将文件直接上传到七牛云

两种方式都可以完成上传，但是前者还需占用服务端的带宽来上传文件，然后再由服务端上传；而后者仅占用客户端的资源，这样可以减轻服务端的压力。 

> [qiniu-wxapp-sdk](https://github.com/gpake/qiniu-wxapp-sdk )

Qiniu-wxapp-SDK  为客户端 SDK，没有包含 token 生成实现，为了安全，token 建议通过网络从服务端获取，具体生成代码可以参考以下服务端 SDK 的文档。SDK Demo中暂时没有包含这部分。 

知识补充：

> [token的作用及实现原理](https://blog.csdn.net/qq_32784541/article/details/79655146 )

身份验证

第一次用户登录，服务端生成一个token，然后将token保存到session中，并返回生成的token。客户端保存在cookie中

以后每次用户登录，会将用户的cookie中token一起提交，服务端检测时间是否超时和是否匹配。

> [Java实现基于token认证](https://blog.csdn.net/kkkun_joe/article/details/81878231 )



调用wx.chooseImage()成功后，会返回选择的图片的地址

http://tmp/wxd9921564024416e0.o6zAJsxauGRxccxhz-IOlMoWseh4.OjWvJKx2q7fE51efa06a3223604f946dc6896ac49658.jpg 

可以看到地址是在生成了一个临时文件



配置CNAME

待总结，出一篇博客

一些网址

> <https://portal.qiniu.com/certificate/ssl#cert> 
>
> <https://portal.qiniu.com/cdn/domain/create?ref=developer.qiniu.com> 
>
> <https://developer.qiniu.com/fusion/kb/1319/test-domain-access-restriction-rules> 
>
> <https://dns.console.aliyun.com/?spm=5176.12818093.recent.ddns.488716d0bsZpdN#/dns/setting/wenshengtech.cn> 
>
> 











## 用户画像

### 用户属性

统计本小程序的男女比例

统计本小程序使用的人的城市

### 用户行为
0 login（登录）、 1 brower （浏览）、2 search（搜索）、 3 collect （收藏）{"user_id":"1111,"behavior":"{"type":1}"}



行为信息还需要加一个，用户登录记录一次，用户登离记录一次，记录用户停留时间



