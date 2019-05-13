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

## 数据库设计 v2
新增behavior表记录用户行为，info_fav_read中间表用于记录用户与消息之间的收藏查看关系，更新用户表中头像链接字段和性别字段，更新数据库设计文件夹中属性和表设计图。
