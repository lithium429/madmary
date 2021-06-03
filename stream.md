```java 
List<Shop_goods_product> delSku = skuProducts.stream().filter(i -> prodPool.stream().map(x -> x.getString("skuId")).noneMatch(sukId -> i.getSku().equals(sukId))).collect(Collectors.toList());
