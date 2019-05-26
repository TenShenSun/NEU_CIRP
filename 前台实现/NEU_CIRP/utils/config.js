//接口url配置文件

var baseUrl = 'https://www.wenshengtech.cn/forum';

var urlList = {
    // getNewsList: baseUrl + '/user/wxid_0000220',
    // getNewsListOrderByTime: baseUrl + '/list/informationOrderByTime',
    newInfoList: baseUrl + '/list/informationOrderByTime',
    hotNews: baseUrl + '/list/informationOrderByFavAndTime',
    setUser: baseUrl + '/user',
    getInfo : (id) => { return baseUrl + '/information/' + id },
    myfavor : (userId) => { return baseUrl + '/list/informationOnUserWithFav/' + userId },
    publishHistory : (userId) => { return baseUrl + '/list/informationOnUserWithPost/' + userId },
    viewHistory : (userId) => { return baseUrl + '/list/informationOnUserWithView/' + userId },
    viewByType : (typeId) => { return baseUrl + '/list/informationGroupByTypeid/' + typeId }
}

module.exports = {
  urlList: urlList
}