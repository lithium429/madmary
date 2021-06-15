### shop_goods商品表
```java
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Comment("商品名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String name;

    @Comment("名称颜色")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String nameColor;

    @Comment("商品描述")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String note;

    @Comment("商品详情")
    @ColDefine(type = ColType.TEXT)
    private String content;

    @Comment("商品型号")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String model;

    @Comment("商品类型")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String classId;

    @Comment("品牌")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String brandId;

    @Comment("产地")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String place;

    @Comment("赠送积分")
    @ColDefine(type = ColType.INT)
    private Integer score;

    @Comment("起购数量")
    @ColDefine(type = ColType.INT)
    private Integer minNum;

    @Comment("最大购买量")
    @ColDefine(type = ColType.INT)
    private Integer maxNum;

    @Comment("浏览量")
    @ColDefine(type = ColType.INT)
    private Integer viewNum;

    @Comment("销量")
    @ColDefine(type = ColType.INT)
    private Integer saleNum;

    @Comment("库存单位")
    @ColDefine(type = ColType.VARCHAR, width = 10)
    private String stockUnit;

    @Comment("最低销售价 单位:分")
    private Long minPrice;

    @Comment("最高销售价 单位:分")
    private Long maxPrice;

    @Comment("扣减库存")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean downStock;

    @Comment("首页推荐")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean showIndex;

    @Comment("上架状态")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @Comment("是否启用规格")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean hasSpec;

    @Comment("商品图")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String picUrl;

    @Comment("是否需要安装服务")
    @ColDefine(type = ColType.BOOLEAN)
    @Default(value = "0")
    private boolean needInstallation;
    
    /*******************以上是原生自营获取字段，以下是第三方商品品新增字段**************************************/

    @Comment("商品来源")
    @ColDefine(type = ColType.INT,width = 2)
    @Default("0")
    private Integer source;

    @Comment("外链地址")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String link;

    //苏宁商品SPU
    @Comment("商品spu")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String spuId;

    //苏宁商品展示价格使用-价格对应的sku商品
    @Comment("列表/热卖展示sku")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String hotSku;

    //苏宁商品展示价格使用-价格对应的sku商品
    @Comment("列表/热卖展示supplierCode")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String hotSupplierCode;

    @Comment("第三方商品品牌名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String brandName;

```

### shop_goods_product货品表/单品
```java
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @PrevInsert(els = {@EL("uuid()")})
    private String id;
    
    //即上面shop_goods商品id 
    //一个商品根据规格有多个货品
    @Column
    @Comment("商品ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String goodsId;
    
    @Column
    @Comment("规格值")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String productSpec;
    
    @Column
    @Comment("规格编码")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String sku;
    
    @Column
    @Comment("条形码")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String barcode;
    
    @Column
    @Comment("销售价 单位:分")
    private Long salePrice;
    
    @Column
    @Comment("市场价 单位:分")
    private Long marketPrice;
    
    @Column
    @Comment("库存")
    @ColDefine(type = ColType.INT)
    private Integer stock;
    
    @Column
    @Comment("重量 单位:KG")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String weight;
    
    /*******************以上是原生自营获取字段，以下是第三方货品新增字段**************************************/

    @Column
    @Comment("商品来源")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer source;
    
    @Column
    @Comment("供应商code")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String supplierCode;
    
    /**
     * @see com.osdiot.nb.third.suning.enums.SuningStockStateEnum
     */
    @Column
    @Comment("库存状态")
    @ColDefine(type = ColType.INT, width = 10)
    private Integer stockState;
    
    //苏宁
    @Column
    @Comment("商品名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String name;
    
    //苏宁商品冗余字段
    @Column
    @Comment("品类名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String buName;
    
    //苏宁商品冗余字段
    @Column
    @Comment("品牌名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String brandName;
    
    //苏宁商品冗余字段
    //类似goodsId,苏宁商品通码
    @Column
    @Comment("spu")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String spu;
    
    @Column
    @Comment("商品主图")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String img;
    
    //苏宁商品字段
    @Column
    @Comment("体积")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String volume;
    
    //苏宁商品最小起订量
    @Column
    @Comment("起购数量")
    @ColDefine(type = ColType.INT)
    private Integer minNum;
```
---
### goods/detail/{id}接口返回
#### 自营商品
```json
{
  "code": 0,
  "msg": "操作成功",
  "data": {
    //商品 shopGoods
    "shopGoods": {
      "id": "vuburqkre2hvrr0ivtb7f7ts9a",
      "name": "铜管",
      "note": "100mm",
      "content": "<p>铜管1000</p>",
      "classId": "2c4p9eeehmimmpn579nc72d8ua",
      "score": 1,
      "minNum": 1,
      "maxNum": 0,
      "viewNum": 2,
      "saleNum": 0,
      "stockUnit": "个",
      "minPrice": 200,
      "maxPrice": 300,
      "downStock": true,
      "showIndex": false,
      "disabled": false,
      "hasSpec": true,
      "needInstallation": false,
      "imageList": [],
      //商品下所属货品 goodsProducts
      //点击购买或者加入购物车实际上选择的是这2种规格的货品
      //只有货品有sku唯一标号，与shop_goods商品是父子关系，每一个shop_goods_product
      //都有一个商品父类，每个商品必有一个货品对应，多种规格则有多个货品，第三方商品也是
      "goodsProducts": [{
        "id": "e01397c9e43842f8aa1686f4d2c59761",
        "goodsId": "vuburqkre2hvrr0ivtb7f7ts9a",
        "productSpec": "10mm",
        "sku": "1001",
        "barcode": "",
        "salePrice": 200,
        "marketPrice": 200,
        "stock": 999,
        "weight": "0.20",
        "source": 0,
        "createdBy": "superadminId",
        "createdAt": 1623751630517,
        "updatedBy": "superadminId",
        "updatedAt": 1623751630517,
        "delFlag": false
      }, {
        "id": "f0a53c531a5b4d50b9c6370463c9131f",
        "goodsId": "vuburqkre2hvrr0ivtb7f7ts9a",
        "productSpec": "15mm",
        "sku": "1002",
        "barcode": "",
        "salePrice": 300,
        "marketPrice": 300,
        "stock": 999,
        "weight": "0.50",
        "source": 0,
        "createdBy": "superadminId",
        "createdAt": 1623751630520,
        "updatedBy": "superadminId",
        "updatedAt": 1623751630520,
        "delFlag": false
      }],
      //0标识自营商品
      "source": 0, 
      "createdBy": "superadminId",
      "createdAt": 1623751630437,
      "updatedBy": "superadminId",
      "updatedAt": 1623751630437,
      "delFlag": false
    },
    //规格列表
    "specList": [{
      "id": "370ae053cc7945928a8519278b6458a2",
      "goodsId": "vuburqkre2hvrr0ivtb7f7ts9a",
      "name": "直径",
      "type": "txt",
      //每个规格值 
      "vals": [{
        "id": "675322d9ec8e4133ab11cb3db8761997",
        "goodsId": "vuburqkre2hvrr0ivtb7f7ts9a",
        "specId": "370ae053cc7945928a8519278b6458a2",
        "name": "10mm",
        "picUrl": "",
        "createdBy": "superadminId",
        "createdAt": 1623751630487,
        "updatedBy": "superadminId",
        "updatedAt": 1623751630487,
        "delFlag": false
      }, {
        "id": "4b6d38e58299426f9f45357b01993413",
        "goodsId": "vuburqkre2hvrr0ivtb7f7ts9a",
        "specId": "370ae053cc7945928a8519278b6458a2",
        "name": "15mm",
        "picUrl": "",
        "createdBy": "superadminId",
        "createdAt": 1623751630499,
        "updatedBy": "superadminId",
        "updatedAt": 1623751630499,
        "delFlag": false
      }],
      "createdBy": "superadminId",
      "createdAt": 1623751630468,
      "updatedBy": "superadminId",
      "updatedAt": 1623751630468,
      "delFlag": false
    }],
    //商品价格列表,自营商品独有,主要根据用户会员设置商品会员价格,第三方商品
    //是直接接口调用单品价格
    "priceList": [],
    //安装服务列表 自营商品独有，目前不涉及这里逻辑保持不动
    "installationTypeList": []
  }
}

```
#### 第三方货品 苏宁为例
```json
{
  "code": 0,
  "msg": "操作成功",
  "data": {
    //商品
    "shopGoods": {
      "id": "q9q66t6h1eh4moojjhjqqejj86",
      "name": "钥匙扣HAHA",
      "model": "1",
      "classId": "2c4p9eeehmimmpn579nc72d8ua",
      "place": "中国北京北京市",
      "viewNum": 58,
      "minPrice": 25,
      "maxPrice": 25,
      "downStock": false,
      "showIndex": false,
      "disabled": false,
      "hasSpec": false,
      "picUrl": "https://imgservice3.suning.cn/uimg1/b2c/image/tnCu0nWUIdk6ME8-UAjObg.jpg",
      "needInstallation": false,
      "source": 2,
      "hotSku": "761431625",
      "hotSupplierCode": "0000000000",
      //品牌名称 直接在页面使用
      "brandName": "狼人",
      "createdBy": "",
      "createdAt": 1623733112311,
      "updatedBy": "",
      "updatedAt": 1623733112311,
      "delFlag": false
    },
    //sku货品 字段基本与自营一样
    //salePrice是列表价格只提供展示参考
    //苏宁货品不提供库存字段，需调用价格接口查询是否可以销售
    "goodsProducts": [{
      "id": "108dd66e2d134be99705da11f1034fea",
      "goodsId": "q9q66t6h1eh4moojjhjqqejj86",
      "productSpec": "7614316250000000000",
      "sku": "761431625",
      "salePrice": 25,
      "marketPrice": 0,
      "weight": "1.000",
      "source": 2,
      "supplierCode": "0000000000",
      "stockState": 1,
      "name": "测试",
      "buName": "百货",
      "brandName": "狼人",
      "img": "https://imgservice3.suning.cn/uimg1/b2c/image/tnCu0nWUIdk6ME8-UAjObg.jpg",
      "volume": "3.000",
      "minNum": 1,
      "createdBy": "",
      "createdAt": 1623733112469,
      "updatedBy": "",
      "updatedAt": 1623733112469,
      "delFlag": false
    }]
  }
}
```
#### 价格接口-列表或首页点击第三方商品进入详情页调用   
进入详情页可能存在一个商品下多个货品，苏宁价格使用货品goodsProducts第一个货品sku   
和supplierCode+区域名称进行查询
```json
//该数据为苏宁价格查询返回
{
    "code": 0,
    "msg": "操作成功",
    "data": {
      //可售数量 以最低销售量查询的
      "arrivalQty": "1",
      //苏宁城市编码
      "cityCode": "551",
      //该地址是否支持配送，0-支持，1-不支持 
      "deliveryOrNot": "1",
      //价格 分
      "price": 25,
      //区域编码
      "regionCode": "03",
      //SKu
      "skuId": "761431625",
      //0-无货，1-有货，2-下架，3-暂不销售 4-库存不足
      "state": "1",
      //供应商编号
      "supplierCode": "0000000000"
    }
}
```
第三方商品与自营商品主要区别在于   
1. 库存，自营商品库存购买限制逻辑不适用,苏宁商品能否销售是看价格接口state字段   
   第三方商品库存剩余数量不显示
2. 价格，第三方商品列表价格可能与进入详情页接口返回价格不一致,自营商品价格逻辑不适用  
   自营商品按原有逻辑执行，第三方取接口返回价格不需要计算会员价最低销售价等   

