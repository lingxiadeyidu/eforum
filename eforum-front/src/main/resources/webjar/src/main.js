// 加载css
require('./assets/css/bootstrap.css');
require('./assets/css/eforum.css');
require('./lib/crop/ng-img-crop.css');

// 启动angular应用
require('./app');

require('./service/articleService');
require('./service/userService');
require('./service/replyService');
require('./service/fileService');
require('./service/personalInformationService');
require('./util/commonUtil');

// 加载angular自定义指令
require('./directive/headerDirective');
require('./directive/footerDirective');
require('./directive/articleItemDirective');
require('./directive/sidebarDirective');
require('./directive/replyDirective');
require('./directive/imageDirective');

// 加载angular控制器
require('./controller/appController');
require('./controller/headerController');
require('./controller/mainController');
require('./controller/aboutController')
require('./controller/loginController');
require('./controller/regController');
require('./controller/articleController');
require('./controller/messageController');
require('./controller/favoriteController');
require('./controller/personalInformationController');
require('./controller/headPortraitController');
require('./controller/articleListController');
require('./controller/pubArticleController');
require('./controller/replyController');