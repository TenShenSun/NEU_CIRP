<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>
    <!-- Bootstrap -->
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/bootstrap/js/jquery.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%--&lt;%&ndash;<%= request.getAttribute("user") %>
<h2>Hello World!,${user.id}</h2>&ndash;%&gt;
<h2 align="center">欢迎来到东北大学高校信息发布平台</h2>
<div align="center">
    <button class="btn btn-success">hello</button>
    <button>hello2</button>
    &lt;%&ndash;
    2. 简介
    3. 使用说明
    4. 接口说明
    5. 示例
    6. 扩展&ndash;%&gt;
    <p>介绍：后台采用Restful风格</p>
</div>--%>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h3 class="text-center">
                欢迎来到东北大学高校信息发布平台
            </h3>
            <div class="tabbable" id="tabs-79849">
                <ul class="nav nav-tabs">
                    <li>
                        <a data-toggle="tab" href="#panel-1">简介</a>
                    </li>
                    <li class="active">
                        <a data-toggle="tab" href="#panel-3">接口说明</a>
                    </li>
                    <li>
                        <a data-toggle="tab" href="#panel-4">示例</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane" id="panel-1">
                        <p>
                            本系统采用，嘚吧嘚吧嘚吧嘚吧的，实现了啥啥啥啥啥啥
                        </p>
                    </div>
                    <div class="tab-pane active" id="panel-3">
                        <p>
                        <div class="row-fluid">
                            <div class="span12">
                                <div class="accordion" id="accordion-344784">
                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a class="accordion-toggle" data-parent="#accordion-344784" data-toggle="collapse"
                                               href="#accordion-element-731088">用户</a>
                                        </div>
                                        <div class="accordion-body collapse" id="accordion-element-731088">
                                            <div class="accordion-inner">
                                                <h3>
                                                    用户接口列表
                                                </h3>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th>
                                                        </th>
                                                        <th>
                                                            url
                                                        </th>
                                                        <th>
                                                            method
                                                        </th>
                                                        <th>
                                                            解释
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            增加
                                                        </td>
                                                        <td>
                                                            /user
                                                        </td>
                                                        <td>
                                                            RequestMethod.POST
                                                        </td>
                                                        <td>
                                                            通过传入的Json格式数据指定数据库中新增用户的各项属性
                                                        </td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>
                                                            删除
                                                        </td>
                                                        <td>
                                                            /user/{id}
                                                        </td>
                                                        <td>
                                                            RequestMethod.DELETE
                                                        </td>
                                                        <td>
                                                            通过id将对应的用户在数据库中删除
                                                        </td>
                                                    </tr>
                                                    <tr class="error">
                                                        <td>
                                                            修改
                                                        </td>
                                                        <td>
                                                            /user
                                                        </td>
                                                        <td>
                                                            RequestMethod.PUT
                                                        </td>
                                                        <td>
                                                            通过传入的Json格式数据指定更新对应id的用户的各项属性
                                                        </td>
                                                    </tr>
                                                    <tr class="warning">
                                                        <td>
                                                            获取
                                                        </td>
                                                        <td>
                                                            /user/{id}
                                                        </td>
                                                        <td>
                                                            RequestMethod.GET
                                                        </td>
                                                        <td>
                                                            通过id获取对应的用户信息，以Json格式数据传递给用户
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <h3>
                                                    用户表中字段
                                                </h3>
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                        <th>
                                                            字段名
                                                        </th>
                                                        <th>
                                                            存储内容
                                                        </th>
                                                        <th>
                                                            存储格式
                                                        </th>
                                                        <th>
                                                            解释
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            id
                                                        </td>
                                                        <td>
                                                            标识
                                                        </td>
                                                        <td>
                                                            varchar(255)
                                                        </td>
                                                        <td>
                                                            区分每一微信用户的唯一标识
                                                        </td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>
                                                            username
                                                        </td>
                                                        <td>
                                                            用户名
                                                        </td>
                                                        <td>
                                                            varchar（255）
                                                        </td>
                                                        <td>
                                                            公告中附带的发布人姓名
                                                        </td>
                                                    </tr>
                                                    <tr class="error">
                                                        <td>
                                                            type
                                                        </td>
                                                        <td>
                                                            用户权限
                                                        </td>
                                                        <td>
                                                            varchar(255)
                                                        </td>
                                                        <td>
                                                            0代表普通用户，1代表社团负责人，2代表管理员
                                                        </td>
                                                    </tr>
                                                    <tr class="warning">
                                                        <td>
                                                            org_name
                                                        </td>
                                                        <td>
                                                            所属组织
                                                        </td>
                                                        <td>
                                                            varchar(255)
                                                        </td>
                                                        <td>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a class="accordion-toggle" data-parent="#accordion-344784" data-toggle="collapse"
                                               href="#accordion-element-520555">消息类型</a>
                                        </div>
                                        <div class="accordion-body collapse" id="accordion-element-520555">
                                            <div class="accordion-inner">
                                                <h3>
                                                    消息类型接口列表
                                                </h3>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th>
                                                        </th>
                                                        <th>
                                                            url
                                                        </th>
                                                        <th>
                                                            method
                                                        </th>
                                                        <th>
                                                            解释
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            增加
                                                        </td>
                                                        <td>
                                                            /typeInfo
                                                        </td>
                                                        <td>
                                                            RequestMethod.POST
                                                        </td>
                                                        <td>
                                                            通过传入的Json格式数据指定数据库中新增消息类型的各项属性
                                                        </td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>
                                                            删除
                                                        </td>
                                                        <td>
                                                            /typeInfo/{id}
                                                        </td>
                                                        <td>
                                                            RequestMethod.DELETE
                                                        </td>
                                                        <td>
                                                            通过id将对应的消息类型在数据库中删除
                                                        </td>
                                                    </tr>
                                                    <tr class="error">
                                                        <td>
                                                            修改
                                                        </td>
                                                        <td>
                                                            /typeInfo
                                                        </td>
                                                        <td>
                                                            RequestMethod.PUT
                                                        </td>
                                                        <td>
                                                            通过传入的Json格式数据指定更新对应id的消息类型的各项属性
                                                        </td>
                                                    </tr>
                                                    <tr class="warning">
                                                        <td>
                                                            获取
                                                        </td>
                                                        <td>
                                                            /typeInfo/{id}
                                                        </td>
                                                        <td>
                                                            RequestMethod.GET
                                                        </td>
                                                        <td>
                                                            通过id获取对应的消息类型信息，以Json格式数据传递给用户
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <h3>
                                                    消息类型表中字段
                                                </h3>
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                        <th>
                                                            字段名
                                                        </th>
                                                        <th>
                                                            存储内容
                                                        </th>
                                                        <th>
                                                            存储格式
                                                        </th>
                                                        <th>
                                                            解释
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            id
                                                        </td>
                                                        <td>
                                                            标识
                                                        </td>
                                                        <td>
                                                            int
                                                        </td>
                                                        <td>
                                                            区分每一消息类型的唯一标识
                                                        </td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>
                                                            name
                                                        </td>
                                                        <td>
                                                            消息类型名称
                                                        </td>
                                                        <td>
                                                            varchar（255）
                                                        </td>
                                                        <td>
                                                            公告可以按照消息类型进行分类
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="accordion-group">
                                        <div class="accordion-heading">
                                            <a class="accordion-toggle" data-parent="#accordion-344784" data-toggle="collapse"
                                               href="#accordion-element-151515">消息</a>
                                        </div>
                                        <div class="accordion-body in collapse" id="accordion-element-151515">
                                            <div class="accordion-inner">
                                                <h3>
                                                    消息接口列表
                                                </h3>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th>
                                                        </th>
                                                        <th>
                                                            url
                                                        </th>
                                                        <th>
                                                            method
                                                        </th>
                                                        <th>
                                                            解释
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            增加
                                                        </td>
                                                        <td>
                                                            /information
                                                        </td>
                                                        <td>
                                                            RequestMethod.POST
                                                        </td>
                                                        <td>
                                                            通过传入的Json格式数据指定数据库中新增消息的各项属性
                                                        </td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>
                                                            删除
                                                        </td>
                                                        <td>
                                                            /information/{id}
                                                        </td>
                                                        <td>
                                                            RequestMethod.DELETE
                                                        </td>
                                                        <td>
                                                            通过id将对应的消息在数据库中删除
                                                        </td>
                                                    </tr>
                                                    <tr class="error">
                                                        <td>
                                                            修改
                                                        </td>
                                                        <td>
                                                            /information
                                                        </td>
                                                        <td>
                                                            RequestMethod.PUT
                                                        </td>
                                                        <td>
                                                            通过传入的Json格式数据指定更新对应id的消息的各项属性
                                                        </td>
                                                    </tr>
                                                    <tr class="warning">
                                                        <td>
                                                            获取
                                                        </td>
                                                        <td>
                                                            /information/{id}
                                                        </td>
                                                        <td>
                                                            RequestMethod.GET
                                                        </td>
                                                        <td>
                                                            通过id获取对应的消息，以Json格式数据传递给用户
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <h3>
                                                    消息表中字段
                                                </h3>
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                        <th>
                                                            字段名
                                                        </th>
                                                        <th>
                                                            存储内容
                                                        </th>
                                                        <th>
                                                            存储格式
                                                        </th>
                                                        <th>
                                                            解释
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>
                                                            id
                                                        </td>
                                                        <td>
                                                            标识
                                                        </td>
                                                        <td>
                                                            int
                                                        </td>
                                                        <td>
                                                            区分消息的唯一标识
                                                        </td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>
                                                            user_id
                                                        </td>
                                                        <td>
                                                            用户id
                                                        </td>
                                                        <td>
                                                            varchar（255）
                                                        </td>
                                                        <td>
                                                            用于与用户表关联
                                                        </td>
                                                    </tr>
                                                    <tr class="error">
                                                        <td>
                                                            type_id
                                                        </td>
                                                        <td>
                                                            消息类型id
                                                        </td>
                                                        <td>
                                                            int
                                                        </td>
                                                        <td>
                                                            用于与消息类型表关联
                                                        </td>
                                                    </tr>
                                                    <tr class="warning">
                                                        <td>
                                                            location
                                                        </td>
                                                        <td>
                                                            组织地点
                                                        </td>
                                                        <td>
                                                            varchar(255)
                                                        </td>
                                                        <td>
                                                            定义消息地点，可为空
                                                        </td>
                                                    </tr>
                                                    <tr class="error">
                                                        <td>
                                                            topic
                                                        </td>
                                                        <td>
                                                            标题
                                                        </td>
                                                        <td>
                                                            varchar(255)
                                                        </td>
                                                        <td>
                                                            消息标题
                                                        </td>
                                                    </tr>
                                                    <tr class="danger">
                                                        <td>
                                                            content
                                                        </td>
                                                        <td>
                                                            内容
                                                        </td>
                                                        <td>
                                                            varchar(255)
                                                        </td>
                                                        <td>
                                                            消息内容
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </p>
                    </div>
                    <div class="tab-pane" id="panel-4">
                        <p>
                            第四部分内容.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <div>
                <div>
                    <div>
                        <div>
                            <div class="_8kySt _1ZUe4">
                                <div class="_3BHfs">
                                    <div class="_3kCD8">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <div>
                    <div>
                        <div>
                            <div class="_3F-Wk _3mEyK _2Qe2S">
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div>
                <div>
                    <div>
                        <div>
                            <div class="_8kySt _1A-5q _2TZgI _1ZUe4">
                                <div class="_3BHfs">
                                    <div class="_3kCD8">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
