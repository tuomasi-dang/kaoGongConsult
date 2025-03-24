-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: kao_gong_consult
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '地址',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人',
  `phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
  `isdefault` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '否' COMMENT '是否默认地址',
  `userid` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='地址';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'2025-03-05 01:15:23','北京市朝阳区朝阳路1号','李明','19819881111','是',11),(2,'2025-03-05 01:15:23','上海市浦东新区张江路2号','王伟','19819882222','是',12),(3,'2025-03-05 01:15:23','广州市天河区天河路3号','张强','19819883333','是',13),(4,'2025-03-05 01:15:23','深圳市南山区科技南路4号','刘洋','19819884444','是',14),(5,'2025-03-05 01:15:23','杭州市西湖区文三路5号','陈晨','19819885555','是',15),(6,'2025-03-05 01:15:23','成都市武侯区人民南路6号','杨阳','19819886666','是',16),(7,'2025-03-05 01:15:23','武汉市洪山区珞喻路7号','赵敏','19819887777','是',17),(8,'2025-03-05 01:15:23','南京市鼓江区中山路8号','黄磊','19819888888','是',18),(9,'2025-03-05 01:15:23','西安市雁塔区长安路9号','周杰','19819889999','是',19),(10,'2025-03-05 01:15:23','重庆市渝北区红锦大道10号','吴昊','19819880000','是',20),(11,'2025-03-05 02:44:31','北京市海淀区人民北路11号','张伟','13623666666','否',1735631002186),(12,'2025-03-05 02:45:52','深圳市南山区华侨城12号','李娜','13723777777','是',71),(13,'2025-03-16 02:32:15','上海市','托马斯','18435811638','是',1735631002186);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baokaozhinan`
--

DROP TABLE IF EXISTS `baokaozhinan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baokaozhinan` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `baokaotiaojian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '报考条件',
  `xuelitiaojian` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学历条件',
  `baomingshijian` date DEFAULT NULL COMMENT '报名时间',
  `baomingwangzhi` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '报名网址',
  `feiyongjiaona` double DEFAULT NULL COMMENT '费用缴纳',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `xiangqingjianjie` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '详情简介',
  `thumbsup_number` int DEFAULT '0' COMMENT '赞',
  `crazily_number` int DEFAULT '0' COMMENT '踩',
  `storeup_number` int DEFAULT '0' COMMENT '收藏数',
  `discuss_number` int DEFAULT '0' COMMENT '评论数',
  `bumenmingcheng` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称',
  `zhiweidaima` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '职位代码',
  `zhiweimingcheng` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '职位名称',
  `kemuleibie` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '科目类别(A/B/C类)',
  `zhaokaorenshu` int NOT NULL COMMENT '招考人数',
  `xueliyaoqiu` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学历要求',
  `zhuanyeyaoqiu` text COLLATE utf8mb4_unicode_ci COMMENT '专业要求',
  `zhengzhimianmao` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '政治面貌要求',
  `zixundianhua` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '咨询电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='报考指南';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baokaozhinan`
--

LOCK TABLES `baokaozhinan` WRITE;
/*!40000 ALTER TABLE `baokaozhinan` DISABLE KEYS */;
INSERT INTO `baokaozhinan` VALUES (1,'2025-03-23 12:21:14','封面1','报考条件1','学历条件1','2023-10-01','http://example.com',100,'2023-09-01 10:00:00','<p><strong>职位名称：</strong>文字综合职位</p>\r\n<p><strong>部门名称：</strong>中国人民政治协商会议吉林省委员会办公厅</p>\r\n<p><strong>报考条件：</strong>报考条件1</p>\r\n<p><strong>学历要求：</strong>大学本科以上学历</p>\r\n<p><strong>专业要求：</strong>不限</p>\r\n<p><strong>政治面貌：</strong>中共党员</p>\r\n<p><strong>招聘人数：</strong>1 人</p>\r\n<p><strong>报名时间：</strong>2023-10-01</p>\r\n<p><strong>报名网址：</strong><a href=\"http://example.com\" target=\"_blank\">点击报名</a></p>\r\n<p><strong>费用缴纳：</strong>100 元</p>\r\n<p><strong>咨询电话：</strong>0431-82892151</p>',9,2,5,4,'中国人民政治协商会议吉林省委员会办公厅','001','文字综合职位','A',1,'大学本科以上学历','不限','中共党员','0431-82892151'),(2,'2025-03-23 12:21:14','封面2','报考条件2','学历条件2','2023-10-02','http://example.com',150,'2023-09-02 10:00:00','<p><strong>职位名称：</strong>监督检查审查调查职位1</p>\r\n<p><strong>部门名称：</strong>中共吉林省纪律检查委员会吉林省监察委员会</p>\r\n<p><strong>报考条件：</strong>报考条件2</p>\r\n<p><strong>学历要求：</strong>大学本科以上学历</p>\r\n<p><strong>专业要求：</strong>本科专业为：法学（030101K）；研究生专业为：法学（030100），法律（035100），法律（法学）（035102）</p>\r\n<p><strong>政治面貌：</strong>中共党员</p>\r\n<p><strong>招聘人数：</strong>3 人</p>\r\n<p><strong>报名时间：</strong>2023-10-02</p>\r\n<p><strong>报名网址：</strong><a href=\"http://example.com\" target=\"_blank\">点击报名</a></p>\r\n<p><strong>费用缴纳：</strong>150 元</p>\r\n<p><strong>咨询电话：</strong>0431-88902290</p>',16,3,7,5,'中共吉林省纪律检查委员会吉林省监察委员会','001','监督检查审查调查职位1','A',3,'大学本科以上学历','本科专业为：法学（030101K）；研究生专业为：法学（030100），法律（035100），法律（法学）（035102）','中共党员','0431-88902290'),(3,'2025-03-23 12:21:14','封面3','报考条件3','学历条件3','2023-10-03','http://example.com',200,'2023-09-03 10:00:00','<p><strong>职位名称：</strong>监督检查审查调查职位2</p>\r\n<p><strong>部门名称：</strong>中共吉林省纪律检查委员会吉林省监察委员会</p>\r\n<p><strong>报考条件：</strong>报考条件3</p>\r\n<p><strong>学历要求：</strong>大学本科以上学历</p>\r\n<p><strong>专业要求：</strong>本科专业为：法学（030101K），金融学，投资学，审计学，会计学；研究生专业为：纪检监察学，法学（0301），法律（0351），审计，会计，会计学，金融，金融学</p>\r\n<p><strong>政治面貌：</strong>中共党员</p>\r\n<p><strong>招聘人数：</strong>3 人</p>\r\n<p><strong>报名时间：</strong>2023-10-03</p>\r\n<p><strong>报名网址：</strong><a href=\"http://example.com\" target=\"_blank\">点击报名</a></p>\r\n<p><strong>费用缴纳：</strong>200 元</p>\r\n<p><strong>咨询电话：</strong>0431-88902290</p>',20,4,10,5,'中共吉林省纪律检查委员会吉林省监察委员会','002','监督检查审查调查职位2','A',3,'大学本科以上学历','本科专业为：法学（030101K），金融学，投资学，审计学，会计学；研究生专业为：纪检监察学，法学（0301），法律（0351），审计，会计，会计学，金融，金融学','中共党员','0431-88902290'),(4,'2025-03-23 12:21:14','封面4','报考条件4','学历条件4','2023-10-04','http://example.com',250,'2023-09-04 10:00:00','详情简介4',26,5,12,6,'中共吉林省纪律检查委员会吉林省监察委员会','003','监督检查审查调查职位3','A',4,'硕士研究生以上学历','研究生专业为：纪检监察学，法学（0301），法律（0351），审计，会计，会计学','中共党员','0431-88902290'),(5,'2025-03-23 12:21:14','封面5','报考条件5','学历条件5','2023-10-05','http://example.com',300,'2023-09-05 10:00:00','<p><strong>职位名称：</strong>文字综合职位1</p>\r\n<p><strong>部门名称：</strong>中共吉林省委宣传部</p>\r\n<p><strong>报考条件：</strong>报考条件5</p>\r\n<p><strong>学历要求：</strong>硕士研究生以上学历</p>\r\n<p><strong>专业要求：</strong>研究生专业为：哲学（01）、经济学（02）、法学（03）、教育学（04）、文学（05）、历史学（06）、管理学（12）</p>\r\n<p><strong>政治面貌：</strong>中共党员</p>\r\n<p><strong>招聘人数：</strong>1 人</p>\r\n<p><strong>报名时间：</strong>2023-10-05</p>\r\n<p><strong>报名网址：</strong><a href=\"http://example.com\" target=\"_blank\">点击报名</a></p>\r\n<p><strong>费用缴纳：</strong>300 元</p>\r\n<p><strong>咨询电话：</strong>0431-88902307</p>',30,6,15,7,'中共吉林省委宣传部','001','文字综合职位1','A',1,'硕士研究生以上学历','研究生专业为：哲学（01）、经济学（02）、法学（03）、教育学（04）、文学（05）、历史学（06）、管理学（12）','中共党员','0431-88902307'),(6,'2025-03-23 12:21:14','封面6','报考条件6','学历条件6','2023-10-06','http://example.com',350,'2023-09-06 10:00:00','详情简介6',35,7,18,8,'中共吉林省委宣传部','002','文字综合职位2','A',2,'硕士研究生以上学历','研究生专业为：哲学（01）、经济学（02）、法学（03）、教育学（04）、文学（05）、历史学（06）、管理学（12）','中共党员','0431-88902307'),(7,'2025-03-23 12:21:14','封面7','报考条件7','学历条件7','2023-10-07','http://example.com',400,'2023-09-07 10:00:00','详情简介7',40,8,20,9,'中共吉林省委统一战线工作部','001','文字综合职位','A',1,'大学本科以上学历','本科专业为：法学类，政治学类，马克思主义理论类，中国语言文学类，历史学类；研究生专业为：法学，政治学，马克思主义理论，法律，中国语言文学，中国史','中共党员','0431-88902427'),(8,'2025-03-23 12:21:14','封面8','报考条件8','学历条件8','2023-10-08','http://example.com',450,'2023-09-08 10:00:00','<p><strong>职位名称：</strong>新闻宣传职位</p>\r\n<p><strong>部门名称：</strong>中共吉林省委统一战线工作部</p>\r\n<p><strong>报考条件：</strong>报考条件8</p>\r\n<p><strong>学历要求：</strong>大学本科以上学历</p>\r\n<p><strong>专业要求：</strong>不限</p>\r\n<p><strong>政治面貌：</strong>中共党员</p>\r\n<p><strong>招聘人数：</strong>2 人</p>\r\n<p><strong>报名时间：</strong>2023-10-08</p>\r\n<p><strong>报名网址：</strong><a href=\"http://example.com\" target=\"_blank\">点击报名</a></p>\r\n<p><strong>费用缴纳：</strong>450 元</p>\r\n<p><strong>咨询电话：</strong>0431-88902427</p>',46,9,22,10,'中共吉林省委统一战线工作部','002','新闻宣传职位','A',2,'大学本科以上学历','不限','中共党员','0431-88902427'),(9,'2025-03-23 12:21:14','封面9','报考条件9','学历条件9','2023-10-09','http://example.com',500,'2023-09-09 10:00:00','详情简介9',50,10,25,11,'中国国民党革命委员会吉林省委员会','001','文字综合职位','A',1,'大学本科以上学历','不限','不限','0431-85086974'),(10,'2025-03-23 12:21:14','封面10','报考条件10','学历条件10','2023-10-10','http://example.com',550,'2023-09-10 10:00:00','详情简介10',56,11,27,13,'中国民主同盟吉林省委员会','001','文字综合职位','A',1,'大学本科以上学历','不限','不限','0431-85821075'),(11,'2025-03-23 12:41:32','封面11','须具有普通高等学校本科学历并取得相应学位；具有国家A类《法律职业资格证书》；不违反《中华人民共和国法官法》中关于回避的规定，不违反吉林省高级人民法院关于对配偶父母子女及其他近亲属从事律师职业的机关在职人员实行回避的有关规定','大学本科以上学历','2025-03-01','http://example.com',0,'2025-02-01 10:00:00','长春市朝阳区人民法院法官助理职位2',0,0,1,0,'长春市朝阳区人民法院','003','法官助理职位2','A',3,'大学本科以上学历','法学（030101K）；研究生专业为：法学（0301），法律（0351）','不限','0431-88558711'),(12,'2025-03-23 12:41:32','封面12','须具有普通高等学校本科学历并取得相应学位；具有国家A类《法律职业资格证书》；不违反《中华人民共和国法官法》中关于回避的规定，不违反吉林省高级人民法院关于对配偶父母子女及其他近亲属从事律师职业的机关在职人员实行回避的有关规定；需经常加班、外出调查取证，工作强度较大，限男性','大学本科以上学历','2025-03-01','http://example.com',0,'2025-02-01 10:00:00','长春市朝阳区人民法院法官助理职位3',0,0,0,0,'长春市朝阳区人民法院','004','法官助理职位3','A',3,'大学本科以上学历','法学（030101K）；研究生专业为：法学（0301），法律（0351）','不限','0431-88558711'),(13,'2025-03-23 12:41:32','封面13','须具有普通高等学校本科学历并取得相应学位；具有国家A类《法律职业资格证书》；不违反《中华人民共和国法官法》中关于回避的规定，不违反吉林省高级人民法院关于对配偶父母子女及其他近亲属从事律师职业的机关在职人员实行回避的有关规定','大学本科以上学历','2025-03-01','http://example.com',0,'2025-02-01 10:00:00','长春市朝阳区人民法院法官助理职位4',0,0,0,0,'长春市朝阳区人民法院','005','法官助理职位4','A',2,'大学本科以上学历','法学（030101K）；研究生专业为：法学（0301），法律（0351）','不限','0431-88558711'),(14,'2025-03-23 12:41:32','封面14','须具有普通高等学校本科学历并取得相应学位；具有国家A类《法律职业资格证书》；不违反《中华人民共和国法官法》中关于回避的规定，不违反吉林省高级人民法院关于对配偶父母子女及其他近亲属从事律师职业的机关在职人员实行回避的有关规定；需经常加班、外出调查取证，工作强度较大，限男性','大学本科以上学历','2025-03-01','http://example.com',0,'2025-02-01 10:00:00','长春市南关区人民法院法官助理职位1',0,0,0,0,'长春市南关区人民法院','004','法官助理职位1','A',3,'大学本科以上学历','法学（030101K）；研究生专业为：法学（0301），法律（0351）','不限','0431-88558711');
/*!40000 ALTER TABLE `baokaozhinan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `tablename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'kaoyanziliao' COMMENT '商品表名',
  `goodid` bigint NOT NULL COMMENT '商品id',
  `goodname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `buynumber` int DEFAULT NULL COMMENT '购买数量',
  `price` double DEFAULT NULL COMMENT '单价',
  `discountprice` double DEFAULT NULL COMMENT '折扣价',
  `userid` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `price` (`price`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`price`) REFERENCES `kaoyanziliao` (`price`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='购物车';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,'2024-12-31 07:44:07','kaoyanziliao',1,'行政职业能力测试','file/kaoyanziliaoFengmian1.jpg',1,99.9,NULL,1735631002186),(2,'2024-12-31 07:44:12','kaoyanziliao',10,'公务员面试秘籍','file/kaoyanziliaoFengmian10.jpg',1,99.9,NULL,1735631002186),(4,'2025-03-24 07:22:40','kaoyanziliao',7,'申论范文宝典','file/kaoyanziliaoFengmian7.jpg',1,99.9,NULL,1735631002186),(7,'2025-03-24 08:36:30','kaoyanziliao',8,'申论范文精析','file/kaoyanziliaoFengmian8.jpg',1,99.9,NULL,1735631002186);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `adminid` bigint DEFAULT NULL COMMENT '管理员id',
  `ask` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '提问内容',
  `reply` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `isreply` int DEFAULT NULL COMMENT '是否回复',
  `userid` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='客服聊天';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (1,'2025-03-05 01:15:23',1,'请问报考北京大学计算机科学与技术专业需要哪些条件？','需要本科及以上学历，且为全日制本科。',1,1),(2,'2025-03-05 01:15:23',2,'清华大学软件工程专业的学费是多少？','学费为每年8000元。',2,2),(3,'2025-03-05 01:15:23',3,'复旦大学金融学专业的就业方向有哪些？','毕业生可以从事银行、证券、保险等金融行业。',3,3),(4,'2025-03-05 01:15:23',4,'上海交通大学电子信息工程专业的课程设置如何？','课程包括电路原理、信号与系统、数字信号处理等。',4,4),(5,'2025-03-05 01:15:23',5,'浙江大学机械工程专业的实验室条件如何？','实验室设备先进，涵盖机械设计、制造、自动化等领域。',5,5),(6,'2025-03-05 01:15:23',6,'南京大学化学工程专业的研究方向有哪些？','研究方向包括化工过程优化、新材料开发等。',6,6),(7,'2025-03-05 01:15:23',7,'中山大学临床医学专业的实习机会如何？','实习机会丰富，与多家三甲医院有合作关系。',7,7),(8,'2025-03-05 01:15:23',8,'华中科技大学土木工程专业的毕业生就业率如何？','毕业生就业率高达95%以上。',8,8),(9,'2025-03-05 01:15:23',9,'武汉大学法学专业的师资力量如何？','师资力量雄厚，有多位知名法学教授。',9,9),(10,'2025-03-05 01:15:23',10,'四川大学新闻传播学专业的实践机会如何？','实践机会丰富，与多家媒体有合作关系。',10,10),(11,'2025-03-05 02:44:42',NULL,'你好，我想咨询一下厦门大学经济学专业的报考条件。',NULL,0,1735631002186),(12,'2025-03-05 02:48:58',1,NULL,'需要本科及以上学历，且为全日制本科。',0,1735631002186),(13,'2025-03-15 08:27:18',NULL,'2025年考公的政策条件怎么样',NULL,0,1735631002186),(14,'2025-03-15 08:30:41',1,NULL,'人数下降，同学放心报考',0,1735631002186),(15,'2025-03-15 10:53:34',NULL,'测试',NULL,0,1735631002186),(16,'2025-03-15 11:03:25',NULL,'你好',NULL,0,1735631002186),(17,'2025-03-15 11:14:19',NULL,'你好，今天上海天气怎么样\n',NULL,0,1735631002186),(21,'2025-03-15 11:27:26',NULL,'测试',NULL,0,1735631002186),(22,'2025-03-15 13:10:23',NULL,'哈哈哈哈',NULL,0,1735631002186),(23,'2025-03-22 05:54:52',NULL,'你好\n',NULL,0,1735631002186),(24,'2025-03-22 07:08:52',NULL,'1+1=？',NULL,0,1735631002186),(25,'2025-03-22 08:08:24',NULL,'你是谁',NULL,0,1735631002186),(26,'2025-03-22 09:58:05',NULL,'1',NULL,1,1735631002186);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `value` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '值',
  `url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='轮播图';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'2024-12-31 06:57:58','swiper1','file/swiperPicture1.jpg',NULL),(2,'2024-12-31 06:57:58','swiper2','file/swiperPicture2.jpg',NULL),(3,'2024-12-31 06:57:58','swiper3','file/swiperPicture4.jpg',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussbaokaozhinan`
--

DROP TABLE IF EXISTS `discussbaokaozhinan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discussbaokaozhinan` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `avatarurl` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `nickname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='报考指南评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussbaokaozhinan`
--

LOCK TABLES `discussbaokaozhinan` WRITE;
/*!40000 ALTER TABLE `discussbaokaozhinan` DISABLE KEYS */;
INSERT INTO `discussbaokaozhinan` VALUES (1,'2024-12-31 07:43:45',1,1735631002186,'file/1735630998175.jpg','11','<p>666</p>',NULL),(2,'2025-03-23 13:43:15',1,1735631002186,'file/1735631113990.jpg','111','<p>可以的</p>',NULL),(3,'2025-03-23 15:03:58',2,1735631002186,'file/1735631113990.jpg','111','<p>这个岗位不错</p>',NULL),(4,'2025-03-24 06:12:08',10,1735631002186,'file/1735631113990.jpg','','<p>不错</p>',NULL);
/*!40000 ALTER TABLE `discussbaokaozhinan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusskaoyanziliao`
--

DROP TABLE IF EXISTS `discusskaoyanziliao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discusskaoyanziliao` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NOT NULL COMMENT '关联表id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `avatarurl` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `nickname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `reply` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='考研资料评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusskaoyanziliao`
--

LOCK TABLES `discusskaoyanziliao` WRITE;
/*!40000 ALTER TABLE `discusskaoyanziliao` DISABLE KEYS */;
INSERT INTO `discusskaoyanziliao` VALUES (1,'2024-12-31 07:49:19',1,1735631002186,'file/1735631113990.jpg','11','<p>666</p>',NULL),(2,'2025-03-15 06:59:36',1,1735631002186,'file/1735631113990.jpg','','<p>可以的</p>',NULL),(3,'2025-03-15 06:59:51',1,1735631002186,'file/1735631113990.jpg','','<p>哈哈哈</p>',NULL),(4,'2025-03-16 02:47:54',3,1735631002186,'file/1735631113990.jpg','111','<p>这本书不错，推荐</p>',NULL),(5,'2025-03-24 08:38:19',1,1735631002186,'file/1735631113990.jpg','111','<p>可以不错</p>',NULL);
/*!40000 ALTER TABLE `discusskaoyanziliao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '帖子标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '帖子内容',
  `parentid` bigint NOT NULL DEFAULT '0' COMMENT '父节点id',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `avatarurl` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `isdone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
  `is_top` int DEFAULT '0' COMMENT '是否置顶',
  `top_time` datetime DEFAULT NULL COMMENT '置顶时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='论坛交流';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (1,'2025-03-01 00:00:00','备考公务员的经验分享','大家好，我想分享一下我的备考经验，希望对大家有帮助！',0,1,'张三',NULL,'开放',0,NULL),(2,'2025-03-01 01:00:00','行测高分技巧','如何在行测考试中快速提升分数？求大神指点！',0,2,'李四',NULL,'开放',0,NULL),(3,'2025-03-01 02:00:00','申论写作模板','求分享一些申论写作的万能模板！',0,3,'王五',NULL,'开放',0,NULL),(4,'2025-03-01 03:00:00','2025年公务员考试大纲解读','今年的考试大纲有哪些变化？大家怎么看？',0,4,'赵六',NULL,'开放',0,NULL),(5,'2025-03-01 04:00:00','如何选择适合自己的岗位','公务员岗位那么多，如何选择最适合自己的？',0,5,'孙七',NULL,'开放',0,NULL),(6,'2025-03-01 05:00:00','备考公务员的经验分享','谢谢楼主分享，受益匪浅！',1,6,'周八',NULL,'开放',0,NULL),(7,'2025-03-01 06:00:00','行测高分技巧','行测要多刷题，建议每天做一套模拟题。',2,7,'吴九',NULL,'开放',0,NULL),(8,'2025-03-01 07:00:00','申论写作模板','可以参考一些名师的课程，模板很实用。',3,8,'郑十',NULL,'开放',0,NULL),(9,'2025-03-01 08:00:00','2025年公务员考试大纲解读','今年大纲变化不大，重点还是在行测和申论。',4,9,'钱十一',NULL,'开放',0,NULL),(10,'2025-03-01 09:00:00','如何选择适合自己的岗位','建议先看自己的专业和兴趣，再结合岗位要求。',5,10,'吴十二',NULL,'开放',0,NULL),(11,'2025-02-28 23:00:00','置顶帖：2025年公务员考试报名时间','2025年公务员考试报名时间已公布，大家抓紧时间准备！',0,1,'管理员','file/Avatarurl1.jpg','开放',1,'2025-03-01 07:00:00'),(12,'2025-02-28 23:30:00','置顶帖：论坛规则及发帖须知','请大家遵守论坛规则，文明发言，共同维护良好的讨论氛围！',0,1,'管理员','file/Avatarurl1.jpg','开放',1,'2025-03-01 07:30:00'),(13,'2025-03-02 00:00:00','公务员考试备考计划','如何制定一个科学的备考计划？',0,11,'陈十三',NULL,'开放',0,NULL),(14,'2025-03-02 01:00:00','行测刷题推荐','有没有推荐的行测刷题APP或者资料？',0,12,'刘十四',NULL,'开放',0,NULL),(15,'2025-03-02 02:00:00','申论热点分析','有哪些热点话题是今年申论可能考到的？',0,13,'黄十五',NULL,'开放',0,NULL),(16,'2025-03-02 03:00:00','体能测试准备','体能测试需要注意哪些事项？',0,14,'何十六',NULL,'开放',0,NULL),(17,'2025-03-02 04:00:00','备考心态调整','备考压力太大了，大家是怎么调整心态的？',0,15,'周十七',NULL,'开放',0,NULL),(18,'2025-03-02 05:00:00','公务员考试备考计划','计划要细化到每天，建议每天固定时间学习。',13,16,'吴十八',NULL,'开放',0,NULL),(19,'2025-03-02 06:00:00','行测刷题推荐','推荐粉笔APP，题目质量很高。',14,17,'郑十九',NULL,'开放',0,NULL),(20,'2025-03-02 07:00:00','申论热点分析','今年可能会考到环境保护相关的热点。',15,18,'钱二十',NULL,'开放',0,NULL),(21,'2025-03-02 08:00:00','体能测试准备','体能测试要提前训练，尤其是跑步和引体向上。',16,19,'孙二一',NULL,'开放',0,NULL),(22,'2025-03-02 09:00:00','备考心态调整','可以每天适当运动，缓解压力。',17,20,'李二二',NULL,'开放',0,NULL),(23,'2025-03-03 00:00:00','公务员考试面试技巧','面试环节有哪些注意事项？',0,21,'张二三',NULL,'开放',0,NULL),(24,'2025-03-03 01:00:00','备考公务员的常见误区','备考公务员时有哪些误区需要避免？',0,22,'王二四',NULL,'开放',0,NULL),(25,'2025-03-03 02:00:00','行测时间分配','行测考试时间怎么分配最合理？',0,23,'赵二五',NULL,'开放',0,NULL),(26,'2025-03-03 03:00:00','申论写作的高分要点','申论写作如何抓住阅卷老师的眼球？',0,24,'孙二六',NULL,'开放',0,NULL),(27,'2025-03-03 04:00:00','公务员考试复习资料推荐','求推荐一些高质量的复习资料！',0,25,'周二七',NULL,'开放',0,NULL),(28,'2025-03-15 07:43:31',NULL,'<p>收到</p>',12,1735631002186,'111','file/1735631113990.jpg',NULL,0,NULL),(29,'2025-03-15 07:46:14',NULL,'<h3><span style=\"color: rgb(225, 60, 57);\"><strong>我引体向上才能做十个😅</strong></span></h3>',21,1735631002186,'111','file/1735631113990.jpg',NULL,0,NULL),(30,'2025-03-15 07:46:45',NULL,'<p>不对，现在只能做5个了😷</p>',29,1735631002186,'111','file/1735631113990.jpg',NULL,0,NULL),(31,'2025-03-15 07:49:17',NULL,'<h4><span style=\"color: rgb(54, 88, 226);\"><strong>比我强多了，我一个都费力，天呐，怎么活💩</strong></span></h4>',21,80,'101010','file/xueshengTouxiang10.jpg',NULL,0,NULL),(32,'2025-03-15 07:53:21',NULL,'<p> <img src=\"http://localhost:8080/cl22771684/file/1742025184577.png\" alt=\"\" data-href=\"\" style=\"\"/></p><p>这个我很推荐</p>',14,80,'101010','file/xueshengTouxiang10.jpg',NULL,0,NULL),(33,'2025-03-15 08:03:21',NULL,'<p>吃淡食</p>',23,80,'101010','file/xueshengTouxiang10.jpg',NULL,0,NULL),(34,'2025-03-15 08:15:33',NULL,'<p><img src=\"http://localhost:8080/cl22771684/file/1742026520226.png\" alt=\"\" data-href=\"\" style=\"\"/></p>',32,80,'101010','file/xueshengTouxiang10.jpg',NULL,0,NULL),(35,'2025-03-15 08:52:52',NULL,'<p><img src=\"http://localhost:8080/cl22771684/file/1742028769711.png\" alt=\"\" data-href=\"\" style=\"\"/></p>',32,1735631002186,'111','file/1735631113990.jpg',NULL,0,NULL);
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendship_link`
--

DROP TABLE IF EXISTS `friendship_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friendship_link` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `link_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '链接名称',
  `link_image` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '链接图片',
  `link_url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '链接地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='友情链接';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendship_link`
--

LOCK TABLES `friendship_link` WRITE;
/*!40000 ALTER TABLE `friendship_link` DISABLE KEYS */;
INSERT INTO `friendship_link` VALUES (1,'2024-12-31 06:57:58','CSDN','file/fl1.jpg','https://www.csdn.net/'),(2,'2024-12-31 06:57:58','凤凰资讯','file/fl2.jpg','https://news.ifeng.com/'),(3,'2024-12-31 06:57:58','网易云音乐','file/fl3.jpg','https://music.163.com/'),(4,'2024-12-31 06:57:58','抖音','file/fl4.jpg','https://www.douyin.com/'),(5,'2024-12-31 06:57:58','麦当劳','file/fl5.jpg','https://www.mcdonalds.com.cn/'),(6,'2024-12-31 06:57:58','芒果TV','file/fl6.jpg','https://www.mgtv.com/'),(7,'2024-12-31 06:57:58','天猫','file/fl7.jpg','https://www.tmall.com/'),(8,'2024-12-31 06:57:58','携程','file/fl8.jpg','https://www.ctrip.com/'),(9,'2024-12-31 06:57:58','优酷','file/fl9.jpg','https://www.youku.com/'),(10,'2024-12-31 06:57:58','Bilibili','file/fl10.jpg','https://www.bilibili.com/');
/*!40000 ALTER TABLE `friendship_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaoyanziliao`
--

DROP TABLE IF EXISTS `kaoyanziliao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kaoyanziliao` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ziliaomingcheng` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资料名称',
  `ziliaofenlei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资料分类',
  `fengmian` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `shangchuanshijian` datetime DEFAULT NULL COMMENT '上传时间',
  `ziliaoxiangqing` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '资料详情',
  `thumbsup_number` int DEFAULT NULL COMMENT '赞',
  `crazily_number` int DEFAULT NULL COMMENT '踩',
  `storeup_number` int DEFAULT NULL COMMENT '收藏数',
  `discuss_number` int DEFAULT NULL COMMENT '评论数',
  `onelimittimes` int DEFAULT '-1' COMMENT '单限',
  `alllimittimes` int DEFAULT '-1' COMMENT '库存',
  `price` double DEFAULT '0' COMMENT '价格',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  PRIMARY KEY (`id`),
  KEY `kaoyanziliao_price` (`price`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='考研资料';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaoyanziliao`
--

LOCK TABLES `kaoyanziliao` WRITE;
/*!40000 ALTER TABLE `kaoyanziliao` DISABLE KEYS */;
INSERT INTO `kaoyanziliao` VALUES (1,'2024-12-31 06:57:58','行政职业能力测试','行测','file/kaoyanziliaoFengmian1.jpg,file/kaoyanziliaoFengmian2.jpg,file/kaoyanziliaoFengmian3.jpg','2024-12-31 14:57:58','行政职业能力测试',2,1,1,5,1,97,99.9,'2024-12-31 14:57:58'),(2,'2024-12-31 06:57:58','公务员行测通用词汇','行测','file/kaoyanziliaoFengmian2.jpg,file/kaoyanziliaoFengmian3.jpg,file/kaoyanziliaoFengmian4.jpg','2024-12-31 14:57:58','公务员行测通用词汇',2,2,2,2,2,99,99.9,'2024-12-31 14:57:58'),(3,'2024-12-31 06:57:58','行测数学精讲','行测','file/kaoyanziliaoFengmian3.jpg,file/kaoyanziliaoFengmian4.jpg,file/kaoyanziliaoFengmian5.jpg','2024-12-31 14:57:58','行测数学精讲',4,3,3,4,3,99,99.9,'2024-12-31 14:57:58'),(4,'2024-12-31 06:57:58','行测言语能力提升指南','行测','file/kaoyanziliaoFengmian4.jpg,file/kaoyanziliaoFengmian5.jpg,file/kaoyanziliaoFengmian6.jpg','2024-12-31 14:57:58','行测言语能力提升指南',4,4,4,4,4,99,99.9,'2024-12-31 14:57:58'),(5,'2024-12-31 06:57:58','行测判断推理高分经典题解','行测','file/kaoyanziliaoFengmian5.jpg,file/kaoyanziliaoFengmian6.jpg,file/kaoyanziliaoFengmian7.jpg','2024-12-31 14:57:58','行测判断推理高分经典题解',5,5,5,5,5,99,99.9,'2024-12-31 14:57:58'),(6,'2024-12-31 06:57:58','公务员申论经典教材','申论','file/kaoyanziliaoFengmian6.jpg,file/kaoyanziliaoFengmian7.jpg,file/kaoyanziliaoFengmian8.jpg','2024-12-31 14:57:58','公务员申论经典教材',6,6,6,6,6,99,99.9,'2024-12-31 14:57:58'),(7,'2024-12-31 06:57:58','申论范文宝典','申论','file/kaoyanziliaoFengmian7.jpg,file/kaoyanziliaoFengmian8.jpg,file/kaoyanziliaoFengmian9.jpg','2024-12-31 14:57:58','申论范文宝典',7,7,7,7,7,98,99.9,'2024-12-31 14:57:58'),(8,'2024-12-31 06:57:58','申论范文精析','申论','file/kaoyanziliaoFengmian8.jpg,file/kaoyanziliaoFengmian9.jpg,file/kaoyanziliaoFengmian10.jpg','2024-12-31 14:57:58','申论范文精析',9,8,8,8,8,97,99.9,'2024-12-31 14:57:58'),(9,'2024-12-31 06:57:58','申论高分写作指南','申论','file/kaoyanziliaoFengmian9.jpg,file/kaoyanziliaoFengmian10.jpg,file/kaoyanziliaoFengmian11.jpg','2024-12-31 14:57:58','申论高分写作指南',9,9,9,9,9,99,99.9,'2024-12-31 14:57:58'),(10,'2024-12-31 06:57:58','公务员面试秘籍','面试','file/kaoyanziliaoFengmian10.jpg,file/kaoyanziliaoFengmian11.jpg,file/kaoyanziliaoFengmian12.jpg','2024-12-31 14:57:58','公务员面试秘籍',10,10,10,10,10,99,99.9,'2024-12-31 14:57:58');
/*!40000 ALTER TABLE `kaoyanziliao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kemu`
--

DROP TABLE IF EXISTS `kemu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kemu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `kemu` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '科目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='科目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kemu`
--

LOCK TABLES `kemu` WRITE;
/*!40000 ALTER TABLE `kemu` DISABLE KEYS */;
INSERT INTO `kemu` VALUES (1,'2025-03-05 01:15:23','文字综合职位'),(2,'2025-03-05 01:15:23','监督检查审查调查职位1'),(3,'2025-03-05 01:15:23','文字综合职位1'),(4,'2025-03-05 01:15:23','文字综合职位2'),(5,'2025-03-05 01:15:23','文字综合职位'),(6,'2025-03-05 01:15:23','新闻宣传职位'),(7,'2025-03-05 01:15:23','文字综合职位'),(8,'2025-03-05 01:15:23','法官助理职位2'),(9,'2025-03-05 01:15:23','法官助理职位3'),(10,'2025-03-05 01:15:23','法官助理职位4');
/*!40000 ALTER TABLE `kemu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2024-12-31 06:57:58','[{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"users\",\"menu\":\"管理员\",\"menuJump\":\"列表\",\"tableName\":\"users\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"xuesheng\",\"menu\":\"学生\",\"menuJump\":\"列表\",\"tableName\":\"xuesheng\"}],\"fontClass\":\"icon-user8\",\"menu\":\"用户管理\",\"unicode\":\"&#xef9e;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"kemu\",\"menu\":\"科目\",\"menuJump\":\"列表\",\"tableName\":\"kemu\"}],\"fontClass\":\"icon-common15\",\"menu\":\"科目管理\",\"unicode\":\"&#xedfc;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"classname\":\"baokaozhinan\",\"menu\":\"报考指南\",\"menuJump\":\"列表\",\"tableName\":\"baokaozhinan\"}],\"fontClass\":\"icon-common11\",\"menu\":\"报考指南管理\",\"unicode\":\"&#xeded;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"ziliaofenlei\",\"menu\":\"资料分类\",\"menuJump\":\"列表\",\"tableName\":\"ziliaofenlei\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"资料分类统计\",\"查看评论\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"资料分类统计\",\"查看评论\",\"首页总数\",\"首页统计\"],\"classname\":\"kaoyanziliao\",\"menu\":\"考公资料\",\"menuJump\":\"列表\",\"tableName\":\"kaoyanziliao\"}],\"fontClass\":\"icon-common43\",\"menu\":\"考公资料管理\",\"unicode\":\"&#xef27;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"menu\":\"商品订单\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"menu\":\"未支付订单\",\"menuJump\":\"未支付\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"发货\",\"物流\",\"核销\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"发货\"],\"menu\":\"已支付订单\",\"menuJump\":\"已支付\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"物流\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"menu\":\"已完成订单\",\"menuJump\":\"已完成\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"menu\":\"已取消订单\",\"menuJump\":\"已取消\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"物流\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"menu\":\"已退款订单\",\"menuJump\":\"已退款\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"确认收货\",\"物流\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"物流\"],\"menu\":\"已发货订单\",\"menuJump\":\"已发货\",\"tableName\":\"orders\"}],\"fontClass\":\"icon-common16\",\"menu\":\"订单管理\",\"unicode\":\"&#xedfd;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"查看评论\"],\"classname\":\"forum\",\"menu\":\"论坛交流\",\"tableName\":\"forum\"}],\"fontClass\":\"icon-common20\",\"menu\":\"论坛管理\",\"unicode\":\"&#xee02;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-pic\",\"buttons\":[\"查看\",\"修改\"],\"classname\":\"config\",\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"news\",\"menu\":\"考研资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\",\"删除\"],\"classname\":\"chat\",\"menu\":\"客服聊天\",\"menuJump\":\"列表\",\"tableName\":\"chat\"}],\"fontClass\":\"icon-common35\",\"menu\":\"系统管理\",\"unicode\":\"&#xee8c;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"查看\"],\"classname\":\"baokaozhinan\",\"menu\":\"报考指南\",\"menuJump\":\"列表\",\"tableName\":\"baokaozhinan\"}],\"menu\":\"报考指南管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-clothes\",\"buttons\":[\"查看\",\"新增\"],\"classname\":\"forum\",\"menu\":\"论坛交流\",\"menuJump\":\"列表\",\"tableName\":\"forum\"}],\"menu\":\"论坛交流\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-form\",\"buttons\":[\"查看\"],\"classname\":\"cart\",\"menu\":\"购物车\",\"menuJump\":\"列表\",\"tableName\":\"cart\"}],\"menu\":\"购物车管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"新增\",\"查看\"],\"classname\":\"chat\",\"menu\":\"客服聊天\",\"menuJump\":\"列表\",\"tableName\":\"chat\"}],\"menu\":\"客服聊天管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"classname\":\"news\",\"menu\":\"考研资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"新闻资讯管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"查看\"],\"classname\":\"kaoyanziliao\",\"menu\":\"考公资料\",\"menuJump\":\"列表\",\"tableName\":\"kaoyanziliao\"}],\"menu\":\"考公资料管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"pathName\":\"users\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"商品订单\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"未支付订单\",\"menuJump\":\"未支付\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"发货\",\"物流\",\"核销\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"已支付订单\",\"menuJump\":\"已支付\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"物流\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"已完成订单\",\"menuJump\":\"已完成\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"已取消订单\",\"menuJump\":\"已取消\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"物流\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"已退款订单\",\"menuJump\":\"已退款\",\"tableName\":\"orders\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"日销量统计\",\"月销量统计\",\"日销额统计\",\"月销额统计\",\"品销量统计\",\"导出\",\"首页总数\",\"首页统计\",\"确认收货\",\"物流\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"物流\",\"确认收货\"],\"menu\":\"已发货订单\",\"menuJump\":\"已发货\",\"tableName\":\"orders\"}],\"fontClass\":\"icon-common16\",\"menu\":\"订单管理\",\"unicode\":\"&#xedfd;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"classname\":\"forum\",\"menu\":\"我的发布\",\"menuJump\":\"14\",\"tableName\":\"forum\"}],\"fontClass\":\"icon-common20\",\"menu\":\"论坛管理\",\"unicode\":\"&#xee02;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"查看\",\"删除\"],\"classname\":\"storeup\",\"menu\":\"我的收藏\",\"menuJump\":\"1\",\"tableName\":\"storeup\"}],\"fontClass\":\"icon-common44\",\"menu\":\"我的收藏管理\",\"unicode\":\"&#xef28;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"address\",\"menu\":\"地址\",\"menuJump\":\"列表\",\"tableName\":\"address\"}],\"fontClass\":\"icon-common19\",\"menu\":\"地址管理\",\"unicode\":\"&#xee00;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"查看\"],\"classname\":\"baokaozhinan\",\"menu\":\"报考指南\",\"menuJump\":\"列表\",\"tableName\":\"baokaozhinan\"}],\"menu\":\"报考指南管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-clothes\",\"buttons\":[\"查看\",\"新增\"],\"classname\":\"forum\",\"menu\":\"论坛交流\",\"menuJump\":\"列表\",\"tableName\":\"forum\"}],\"menu\":\"论坛交流\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-form\",\"buttons\":[\"查看\"],\"classname\":\"cart\",\"menu\":\"购物车\",\"menuJump\":\"列表\",\"tableName\":\"cart\"}],\"menu\":\"购物车管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"新增\",\"查看\"],\"classname\":\"chat\",\"menu\":\"客服聊天\",\"menuJump\":\"列表\",\"tableName\":\"chat\"}],\"menu\":\"客服聊天管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"classname\":\"news\",\"menu\":\"考研资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"新闻资讯管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"查看\"],\"classname\":\"kaoyanziliao\",\"menu\":\"考公资料\",\"menuJump\":\"列表\",\"tableName\":\"kaoyanziliao\"}],\"menu\":\"考公资料管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"pathName\":\"xuesheng\",\"roleName\":\"学生\",\"tableName\":\"xuesheng\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `introduction` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='考研资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'2024-12-31 06:57:58','余生，愿你活出自己的精彩','曾几何时，为了让自己显得合群，选择去做自己不喜欢的事;为了讨好喜欢的人，一次次地委屈自己;甚至，为了陌生人的一个眼神，就陷入了深深的自我怀疑。','file/newsPicture1.jpg','可是，这样小心翼翼的你，一定很累吧。你以为照顾了所有人的想法，就能得到他们的喜欢;你以为逼着自己合群，就能真的合群。直到后来才发现，在日复一日对自己的为难中，你逐渐弄丢了真实的自己.\n殊不知，人生在世，最不值得的事情，就是在别人的眼光中，迷失自己。其实，正如世界上没有十全十美的人，你也同样无法做到让每个人满意。\n世上没有不快乐的人，只有不肯让自己快乐的心。有一句话说:\n如果一段关系让你变得卑微，你可以选择抽身离去;如果一个人总是让你悲伤哭泣，你要学会放手。\n始终相信，每个人最初的样子，都是最美好的。真正喜欢你的人，会喜欢你原来的样子:真正爱你的从来不需要你的委曲求全。\n后半生，请把身上的枷锁，全部解除。去做喜欢的事，去听自己内心的声音。你会发现，这世上没有什么事情比活出自己更加幸福。\n要相信，真实的自己亦是一道风景线。你若盛开，清风自来。愿你此生尽兴，不负韶华，'),(2,'2024-12-31 06:57:58','岁月无常，好好珍惜','常听到这样的话，如果一切可以重新开始，我一定改掉任性，学会坚持，如果有下辈子，我一定好好珍惜，不会再弄丢原本属于自己的幸福。','file/newsPicture2.jpg','然而，世上有很多事情没有再来一次的机会，一旦错失就意味着无法弥补，正如人与人之间，有的只是一世的缘分，一旦转身，就意味着再无可能。\n这一生只活一次，有些人也只爱一回。\n所以，在拥有时就好好把握，对于来世，可以适当憧憬，但不要一昧去幻想，活着，唯有珍惜身边做好眼前事，才能让明天少一些遗憾。人，\n既然有幸来到这个世上，那就要努力把这辈子活好。岁月其实远没有想象中的那么漫长，若是能爱就好好爱，别让说好相伴一生的人，中途散走;若是当下能相知相守，就别去等待虚无缥缈的未来。\n就像一位网友留言说的:我从来不去期待下辈子，我要的只有今生，世事无常，来世是怎样的光景，谁都无法预知。对我来说，在有限的时光里，善待爱自己及自己爱的人，用心珍惜相聚的每一时刻，努力过好当下就足够了。\n时光匆匆，韶华似水，每个人都只有这短暂的一生。\n有些事，如果喜欢就坚定努力的去做，有些人，如果爱就真诚用心地去爱，别幻想着重来，别总是寄希望于下辈子。\n下辈子，彼此也许再也不会遇见，就算遇见了，谁还会记得谁，今生相互承诺的两个人，来生也许相见不相识。\n想起之前看过的一句话:人生没有假如，我们没有来世，下辈子，你我也许只是大千世界里互不相识的两个陌生人。\n的确，生命只有一次，今生有幸相遇的人，下辈子不一定能遇见，就算能遇见，谁能把谁陪伴，谁又是谁的谁?\n余生不长，趁着岁月未老，好好珍惜这辈子的缘分吧，别等到失去了才悔不该当初。'),(3,'2024-12-31 06:57:58','与其背着烦恼活，不如带着美好过','一直觉得，感情里，无疾而终并不可怕，可怕的是结束后，你还抱着回忆不肯放;岁月中，失去并不可怕，可怕的是失去后，你还揪着曾经不肯忘。\n有些事，明知道不应该继续，却始终没有转身的勇气;有些人，明知道已经成为过去，却还是舍不得放手;有时候，明知道纠缠于往事旧人只会徒增伤悲，却仍然执着的去回忆，去留恋。','file/newsPicture3.jpg','人生短短几十年，为什么要蹉跎浪费在无可挽回的失去上，为什么不酒脱一点，看开一点，活得轻松快乐一点。\n这世间，没有谁的人生是十全十美的，总要面对一些离别，总要经历一些失去，如果总对身边的一切执念太深，只会越活越累。\n时间不停向前，人也不可避免的要向前看。面对一些不如意、不顺心的事，该放的就放，该忘的就忘，别总把自己困在失败的悲伤中。\n生而为人，放不是无能，而是一种洒脱，忘更不是懦弱，而是一种智慧。\n在来去匆匆，聚散不定的现实里，放下不属于自己的感情，才能有新的开始，忘记心中的烦恼，才能收获愉快的心情。\n所以，有些离开的人，该放就放下吧，一直念念不忘，伤害的是自己，有些烦心事，该忘就忘了吧一直耿耿于怀，痛苦的是自己。\n-辈子本就不长，何必让自己活得那么累，过去的情就让它过去，别再留恋，想不通的事就算了，别再纠结。\n人生的旅途，总有些事让人烦，总有些情让人伤。只有学会忘记过往的不如意，忘记一些不必要的烦恼，以轻盈的身心重新出发，才不会被旧人旧事所累。\n记得，每个人心灵的空间都是有限的，当装多了纠结与伤感，就装不下自在与欢快了。要想日子过得简单轻松一点，就要懂得放下执念，忘掉痛苦，清除伤。'),(4,'2024-12-31 06:57:58','理想很丰满，现实很骨感','游戏里的你帅气无比，乘风御剑，通关杀敌无所不能，你满足于那其中的成就感，你满足于通关的畅快淋漓。','file/newsPicture4.jpg','年轻人，可那毕竟不是现实，理想很丰满，现实很骨感这不是玩笑，你不走出来，怎么会知\n你真的想等到某天喜欢上一个姑娘时，才去纠结咖啡钱电影钱你要如何与爸妈张口，才去苦恼为她买礼物你要怎样省吃俭用节衣缩食?\n你没有挥金如土的.魄力，没有殷实的家境，没有既定的光芒锦绣的前程，二十出头的年纪，你不努力，你想拿什么报答那个在你身边用最好的青春陪伴你的姑娘?你又拿什么报答含辛茹苦养育你这么多年的父母?\n生活不是游戏，不会给你那么多反复再来的机会，青春年少风华正茂，年轻人，你不努力，你想指望什么?\n年轻人，走出来奋斗吧!累也好苦也罢。如果你现在对自己各种放纵，你指望以后你用什么条件来放松?\n年轻人，你要努力赚钱，为了自己，也为了你爸妈。为了他们在以后逛商场的时候，可以给自己买东西像给你买东西一样毫不犹豫。为了他们可以在同老友谈起你时可以一脸安详，而不是想着，这个月，儿子交了房租还有钱吃饭么。我们这个年龄的人，已经像吸血鬼一样巴着父母活了二十多年了，还真的要继续吸着他们的血活下去么?\n年轻人，停止期望凡事简单容易。如果总是挑简单的事情做，那你永远成不了大器，生活总会在始料不及时考验你，所以你必须挑战困难，保持坚强，世上任何值得拥有的东西都需要付诸努力，勤奋与自律，倘若自甘平庸，那你就会变得庸碌无为。\n年轻人，与我们一起，挑战一下自己，拥抱一下梦想。你想要的生活，跳起来，一定够得到!'),(5,'2024-12-31 06:57:58','理想是一种精神上的追求','如果前方是一片黑暗，理想是否会黯淡?黑暗终究不能限制理想的步伐，只是需要时间。','file/newsPicture5.jpg','是否会撕裂黑暗的结界?给理想一点时间，是否会完成理想的目标?太多时候，黑给黑暗一缕曙光，暗限制了理想的脚步，时间成了撕裂黑暗的曙光。社会的压抑，未知的迷茫，甚至是事实的打击，都成了所谓的黑暗。\n理想应该是一种精神上的追求，一种我们内心深处的渴望。也许理想的种类太多，不一样的人也有不一样的理想。但唯一的共同点就是我们在追求，追求自己精神上亦或是心中的目标。但总是不尽人意，一来存在太多不确定因素，二来时间还不够。理想并不是一而就的空话。\n想过放弃，因为理想与现实的差距。但又不想放弃，因为理想是精神上的追求心中的渴望。纠结了太多，却是否想过在纠结的时候，已经选择了错过。被刻意选择的错过是什么?是路过。我们在不经意间路过了多少理想，只是因为纠结。如果坚定自己的理想，用时间去行动，是否会少几次刻意的错过:-次，与一位朋友谈到如何乐观，然后追求理想。朋友想了一会儿，给我的回答是正能量与时间。他说，想要乐观就要不断给自己正能量。事物有阴阳两面，如果阳代表乐观，那在我们看待一件事时要看阳面千万别看阴面。这样自己不会消极，某种程度上来说就是一种正能量。想要追求理想，务必要花费时间。正如没有风平浪静的大海，想要追求理想，要时间。给理想一点时间，让自己去追求，不顾切的追求。\n点点滴滴的小事构成了我们的生活，点点滴滴的努力给理想铺平了路。每一次小成功都为理想迈进了一步。每一次失败，都告诉我们一些教训，反方向来说为下一次成功提供了经验。不要觉得失败是可怕的，长远来看，正是失败才有了成功。\n时间在流逝。如果安于现状，就会乐不思。理想需要时间不代表我们可以挥霍，我们能做的是珍惜时间，去为理想拼搏。\n间接意义上讲，理想的时间是我们的努力。\n如果正在路上，一直任性向前走，忘记时间不回头。'),(6,'2024-12-31 06:57:58','人生如梦，梦想是帆','人生如梦，梦想是帆，每个人都有一个只属于自己的梦，但我们同属一个国家，所以每个人的梦又与国家的兴衰荣辱紧密相连。先哲顾炎武曾说:天下兴亡，匹夫有责。只有国家好，大家才能好。','file/newsPicture6.jpg','我依然清楚的记得:\n当甲午战争战败，日寇无礼踏破中国的门户;当八国联军侵入北京，无情掠夺中国的财产:当七七事变发生，中国的老人、妇孺被残忍杀害的时候，我在想那时中国的梦是怎样的!\n我虽不曾亲眼看到，但那却是铁一般的事实。因为从老人们那深邃的眼神中可以感到无尽的愤懑;从他们干瘪的脸颊可以看到深情的泪水，从他们嘹亮的军歌中可以想到那奋勇杀敌时的豪迈;从他们激昂话语中听到那誓要捍卫家园振兴中华的誓言。作为新一代青年的我们难道不应该树立远大的理想，付之以踏实的行动，去继承先辈们的使命。去实现中华民族的伟大崛起和复兴吗?\n有梦才能使中国繁荣!\n在改革开放以来中国取得了一系列的可以载入中国史册的成就。香港、澳门的回归，经济特区的建立，使中国成为发展国家中的经济大国，科技先进国和军事强国。当中国成功举办奥运的时候，当神九飞天的时候，当蛟龙入海的时候，当航母下水的时候，当莫言荣获诺贝尔文学奖的时候。我相信每个人都感觉到了无比的自豪。但是现在的中国与其他发达国家还有很大差距。作为新一代的我们，难道不应该志存高远吗?\n我想有的人会说，我们的力量是有限的。的确个人的力量很渺小，但是中国梦就是因一个个微不足道的个人的梦一直汇集、汇集，然后凝聚成的一个巨大的梦。冯至在《十四行诗》中写道，我们准备着，深深领受，那些意想不到的奇迹，在漫长的岁月里，忽然有彗星的出现，狂风乍起。\n梦想是美丽的，它是美的期望;梦想是阳光的，它使人由浮躁走向踏实;梦想是充满力量的，它可以激发人身体里无限的潜能。我们期盼的是国泰民安、经济发展、政治清明、文化繁荣、社会和谐、生态良\n好、公平正义。这才是中国人伟大的梦'),(7,'2024-12-31 06:57:58','若月亮没来-王宇宙Leto，乔浚丞','《若月亮没来(若是月亮还没来)》是王宇宙Leto，乔浚丞演唱的歌曲，于2024年1月22日上线发行。','file/newsPicture7.jpg','风吹过山 船靠了岸  风光呀 一点点看  我走向北 你去往南\n故事呀 一篇篇翻  好烦 又加班到很晚  你搭上空荡的 地铁已是末班\n好烦 很爱却要分开  恋爱谈不明白  好烦 接近理想好难 却又还很不甘\n如何拥抱平淡  如果 最难得到圆满  不如选择坦然 若是月亮还没来\n路灯也可照窗台  照着白色的山茶花微微开  若是晨风还没来\n晚风也可吹入怀  吹着那一地树影温柔摇摆  你总以为你不够好\n不够苗条和美貌  可是完美谁能达到  做你自己就很好\n烦恼烦恼拥有太少  没有房车没有钞票  可爱你的人永远会 \n把你当做心尖珍宝  我也懂大多数的时候  你只想逃离这世界\n我也懂太多的情绪在  一个人失眠的深夜 你可以是悲伤或者埋怨\n但请不要放弃明天  这一直灰暗的世界  我想看见你的笑脸\n若是月亮还没来  路灯也可照窗台  照着白色的山茶花微微开\n若是晨风还没来  晚风也可吹入怀  吹着那一地树影温柔摇摆\n若是月亮还没来  路灯也可照窗台  照着白色的山茶花微微开\n若是晨风还没来  晚风也可吹入怀  吹着那一地树影温柔摇摆\n李哲今年1月份创作了《若月亮没来》这首歌。随着歌曲的热度不断上升，约他写歌的人越来越多，他的工作变得更加繁忙。\n近年来，李哲凭借对音乐的热爱和不懈的努力，创作了几百首音乐作品，其中不乏广为人知的佳作，例如王栎鑫的《一个人》、何赛飞与叶炫清在央视演唱的《木兰诗》等歌曲，都是由李哲作曲。\n如今，李哲的音乐才华和努力得到了业界的广泛认可，他的音乐作品多次登上各大音乐平台的热歌榜，成为备受瞩目的新生代音乐人。现在，走在街头、坐在车里，经常会听到自己的作品。看到自己的音乐作品受到如此广泛的喜爱和认可，我感到非常有成就感。李哲笑着说，他会努力创作更多优秀音乐作品，为家乡争光。'),(8,'2024-12-31 06:57:58','-米阳光传递一份温暖','黑暗中跌倒，坚强里苦笑。只是因为青春还在，所以梦想一直在路上。当年华未曾老去，青春没有散场，留给幽暗的岁月，还有几分值得珍藏?孤独无助时、伤心难过时总爱恣意挥霍愤怒。伤了、痛了原本以为就都结束了;可是心里还不甘愿放弃，就只为一个理由，有梦想的人永不孤单。','file/newsPicture8.jpg','放进去了的青春，走不出来的悲伤却总是给年少时的我们留下太多无法割舍的情怀。记录岁月的足迹，聆听时光的故事。然轻吟浅唱出，青春嘉年华。\n故事里总会有，那些太多感慨于时间的无情，太多对往事的追忆，太多的太多，而今刻在了心里也停泻在了流年里。一段无法抹去的回忆，也只不过是一场烟火燃放的瞬间，却也一辈子在脑海里兜兜转转。很是怀念那些相遇的日子，邂逅了幸福也留在了时间轨迹里。时而想起，那些曾肩并肩奋斗的日子，那些写满感动与快乐的岁月。\n如今，我们似乎渐行渐远，彼此奋斗着青春的轮回。渐渐的，我们都长大了，时间改变了我们时刻分享彼此快乐与不快乐的习惯，青春的渐逝，岁月的更迭让我们变得都不再联系，身边的朋友也越来越少;那些欢笑，那些幸福的流年也随着我们的陌生而变得更加奢侈。也许多年以后，我们都有了自己的朋友，有了自己关心的人。那时，我们再细数那些癫狂在你生命里一辈子的记忆故事，蓦然发现一切都停留在了回忆里。'),(9,'2024-12-31 06:57:58','自己的路自己走，自己的心自己懂','岛上书店》中有句话:每个人的生命里，都有最艰难的那一年，将人生变得美好而辽阔。\n你有没有经历过那么一年，在走过的岁月中跋涉得异常艰难困苦，却仍无法灭前行的勇气。哪怕所有人都极力劝阻，也要不甘心地试一试;哪怕前方已没有道路，却还在坚定前行;哪怕再看不到任何希望，也要竭尽全力地为自己争取一个机会。','file/newsPicture9.jpg','你开始不动声色的扮演着一个大人，经历着生活日复一日的打。\n每天醒在天还没亮的五六点，挤过早高峰的地下铁，面对成山的工作，加班到深夜倒下就睡更成为了日常，还要应付各色的人际关系，逐渐开始接受努力也不一定有回报的道理。\n这段日子也许很长，但你没有放弃对生活的信心，始终相信人生总会变得一帆风顺，更坚信每件事的最后都会有一个好的结局，如果不是，说明还没到最后。\n于是你树立新的目标，让这一年的奔波更有方向。\n虽然永远无法预料明天是晴是雨，也无法预知你在乎的人是否还在身边，你一直以来的坚持究竟能换来什么。\n但你能决定的是，今天有没有备好雨伞，有没有好好爱人以及是否为自己追求的理想拼尽全力。\n永远不要只看见前方路途遥远而忘了从前的自己坚持了多久才走到了这里，\n今天拼尽全力虽然艰辛万分，在未来都将成为落在你身上的礼物。'),(10,'2024-12-31 06:57:58','愿你有明天可奔赴，有过往可回头','此去经年，用一张离家的车票，换一段有故事可说的人生。\n大概就是那时候怀揣着梦想，背上了行囊，一腔热血决定远行的你。独自拎着一只行李箱，背着双肩包在深夜抵达一个陌生的城市，站在人潮涌动的车站出口，望着宽敞公路上车水马龙的喧嚣，城市里亮如白昼的繁华。','file/newsPicture10.jpg','这世界上的人们都活的匆匆忙忙，每个人看起来都很焦虑，每个人都有自己的苦楚，却往往找不到人可以诉说。也许你的倾诉，对别人来说是一种打扰，而且别人没经历过你的经历，所以无法体会你的心情。我们总是在心情不好的时候拿着手机，翻翻通讯录，然后再默默放下手机，压住心中那股想要找人说说话的想法。\n等到低落的情绪慢慢有些好转，才开始明白，人这一生，无论是什么样的路，都是自己的选择，冲动也好，深思熟虑也罢，自己选的路，不管多难，都要自己走下去。心中的感受，不管是复杂还是简单，都只能自己来懂，别人帮不了你，也安慰不了你，顶多给你一些无济于事的劝告，最后还得靠自己想开。你选的幸福，你自己享受;你选的眼泪，你自己来流，生活就是如此，自己的路，自己走;自己的心，自己懂。');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `orderid` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单编号',
  `tablename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'kaoyanziliao' COMMENT '商品表名',
  `goodid` bigint NOT NULL COMMENT '商品id',
  `goodname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `buynumber` int DEFAULT NULL COMMENT '购买数量',
  `price` double DEFAULT NULL COMMENT '单价',
  `total` double DEFAULT NULL COMMENT '总价',
  `type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付类型',
  `status` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单状态',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `tel` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
  `consignee` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `logistics` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '物流',
  `role` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户角色',
  `userid` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderid` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2024-12-31 07:44:35','20241231154435598467','kaoyanziliao',1,'行政职业能力测试','file/kaoyanziliaoFengmian1.jpg',1,99.9,99.9,'1','已完成','人民北路','13623666666','张三','','<p>顺丰物流，已经在路上了，小主耐心等待哦</p>','xuesheng',1735631002186),(2,'2024-12-31 07:44:35','20241231154435618948','kaoyanziliao',10,'资料名称10','file/kaoyanziliaoFengmian10.jpg',1,99.9,99.9,'1','已退款','人民北路','13623666666','张三','',NULL,'xuesheng',1735631002186),(3,'2024-12-31 07:45:56','20241231154556164453','kaoyanziliao',1,'行政职业能力测试','file/kaoyanziliaoFengmian1.jpg',1,99.9,99.9,'1','已支付','华侨城','13723777777','李四','',NULL,'xuesheng',71),(4,'2025-03-16 02:32:27','20250316103227285743','kaoyanziliao',3,'行测数学精讲','file/kaoyanziliaoFengmian3.jpg',1,99.9,99.9,'1','已退款','上海市','18435811638','托马斯','',NULL,'xuesheng',1735631002186),(5,'2025-03-16 02:34:11','20250316103411822812','kaoyanziliao',3,'行测数学精讲','file/kaoyanziliaoFengmian3.jpg',1,99.9,99.9,'1','已退款','上海市','18435811638','托马斯','这本真题真的不错，非常推荐！',NULL,'xuesheng',1735631002186),(6,'2025-03-24 08:12:38','20250324161238376227','kaoyanziliao',8,NULL,'file/kaoyanziliaoFengmian8.jpg',2,99.9,199.8,'1','已支付','上海市','18435811638','托马斯','',NULL,'xuesheng',1735631002186),(7,'2025-03-24 08:38:00','20250324163800295900','kaoyanziliao',7,'申论范文宝典','file/kaoyanziliaoFengmian7.jpg',1,99.9,99.9,'1','已支付','北京市海淀区人民北路11号','13623666666','张伟','',NULL,'xuesheng',1735631002186);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storeup` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint DEFAULT NULL COMMENT 'refid',
  `tablename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `userid` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='我的收藏';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
INSERT INTO `storeup` VALUES (3,'2025-03-15 06:59:22',1,'kaoyanziliao','行政职业能力测试','file/kaoyanziliaoFengmian1.jpg','21',NULL,NULL,1735631002186),(4,'2025-03-16 02:47:38',3,'kaoyanziliao','行测数学精讲','file/kaoyanziliaoFengmian3.jpg','21',NULL,NULL,1735631002186),(5,'2025-03-23 15:40:38',1,'baokaozhinan','文字综合职位','封面1','1',NULL,NULL,1735631002186),(9,'2025-03-23 16:24:52',10,'baokaozhinan','文字综合职位','封面10','21',NULL,NULL,1735631002186),(10,'2025-03-24 06:07:21',4,'baokaozhinan','监督检查审查调查职位3','封面4','21',NULL,NULL,1735631002186),(11,'2025-03-24 06:08:06',11,'baokaozhinan','法官助理职位2','封面11','1',NULL,NULL,1735631002186),(12,'2025-03-24 07:21:46',2,'baokaozhinan','监督检查审查调查职位1','封面2','21',NULL,NULL,1735631002186),(14,'2025-03-24 08:25:17',8,'baokaozhinan','新闻宣传职位','封面8','21',NULL,NULL,1735631002186),(15,'2025-03-24 08:36:58',8,'kaoyanziliao','申论范文精析','file/kaoyanziliaoFengmian8.jpg','21',NULL,NULL,1735631002186);
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1,'admin','users','管理员','9iax7lvon1cmz5gg86nfh7pe73dbnic8','2024-12-31 07:39:03','2025-03-23 05:52:20'),(2,71,'账号1','xuesheng','学生','4vvz81ay1rm92q5yy14i1fr7d0gr3kxq','2024-12-31 07:39:10','2024-12-31 08:45:35'),(3,1735631002186,'11','xuesheng','学生','ja1e7n6vs92f2k37dd9oan427o2v9gya','2024-12-31 07:43:28','2025-03-24 10:05:36'),(4,80,'101010','xuesheng','学生','vd5ts3udob9yfv4trvjs1lgx6hpwphmm','2025-03-15 07:47:53','2025-03-15 08:47:54');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '管理员' COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-12-31 06:57:58','admin','admin','管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xuesheng`
--

DROP TABLE IF EXISTS `xuesheng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xuesheng` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
  `mima` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `xingming` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `touxiang` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `shouji` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机',
  `money` double DEFAULT '0' COMMENT '余额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1735631002187 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='学生';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xuesheng`
--

LOCK TABLES `xuesheng` WRITE;
/*!40000 ALTER TABLE `xuesheng` DISABLE KEYS */;
INSERT INTO `xuesheng` VALUES (71,'2024-12-31 06:57:58','1111','123456','李明','男','file/xueshengTouxiang1.jpg','19819881111',100.1),(72,'2024-12-31 06:57:58','2222','123456','王伟','男','file/xueshengTouxiang2.jpg','19819881112',200),(73,'2024-12-31 06:57:58','3333','123456','张强','男','file/xueshengTouxiang3.jpg','19819881113',200),(74,'2024-12-31 06:57:58','4444','123456','刘洋','男','file/xueshengTouxiang4.jpg','19819881114',200),(75,'2024-12-31 06:57:58','5555','123456','陈晨','男','file/xueshengTouxiang5.jpg','19819881115',200),(76,'2024-12-31 06:57:58','6666','123456','杨阳','男','file/xueshengTouxiang6.jpg','19819881116',200),(77,'2024-12-31 06:57:58','7777','123456','赵敏','男','file/xueshengTouxiang7.jpg','19819881117',200),(78,'2024-12-31 06:57:58','8888','123456','黄磊','男','file/xueshengTouxiang8.jpg','19819881118',200),(79,'2024-12-31 06:57:58','9999','123456','周杰','男','file/xueshengTouxiang9.jpg','19819881119',200),(80,'2024-12-31 06:57:58','101010','123456','吴昊','男','file/xueshengTouxiang10.jpg','19819881110',200),(1735631002186,'2024-12-31 07:43:22','111','123456','张伟','男','file/1735631113990.jpg','13623666666',9600.4);
/*!40000 ALTER TABLE `xuesheng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ziliaofenlei`
--

DROP TABLE IF EXISTS `ziliaofenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ziliaofenlei` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ziliaofenlei` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资料分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资料分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ziliaofenlei`
--

LOCK TABLES `ziliaofenlei` WRITE;
/*!40000 ALTER TABLE `ziliaofenlei` DISABLE KEYS */;
INSERT INTO `ziliaofenlei` VALUES (1,'2024-12-31 06:57:58','行测'),(2,'2024-12-31 06:57:58','行测'),(3,'2024-12-31 06:57:58','行测'),(4,'2024-12-31 06:57:58','行测'),(5,'2024-12-31 06:57:58','行测'),(6,'2024-12-31 06:57:58','申论'),(7,'2024-12-31 06:57:58','申论'),(8,'2024-12-31 06:57:58','申论'),(9,'2024-12-31 06:57:58','面试'),(10,'2024-12-31 06:57:58','面试'),(11,'2024-12-31 07:47:37','面试');
/*!40000 ALTER TABLE `ziliaofenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'kao_gong_consult'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-24 17:20:49
