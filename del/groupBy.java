        Map<List<Object>, InAndOutStock> groupByMap = inAndOutStockList.stream().collect(Collectors.toMap(
                inAndOutStock -> {
                    List<Object> tempList = new ArrayList<>();

                    tempList.add(inAndOutStock.getMaterialCode());
                    tempList.add(inAndOutStock.getItemNum());
                    tempList.add(inAndOutStock.getExecuteNum());
                    return tempList;
                },
                inAndOutStock -> {
                    InAndOutStock inAndOutStock1=new InAndOutStock();
                    BeanUtils.copyProperties(inAndOutStock,inAndOutStock1);


                    if(inAndOutStock.getTypeTellInOrOut().equals(MaterialServiceImpl.TypeTellInOrOut.outType)){
                        inAndOutStock1.setInOrOutCount(inAndOutStock.getInOrOutCount());
                    }else {
                        inAndOutStock1.setInOrOutCount(BigDecimal.ZERO);
                    }
                    return inAndOutStock1;
                },
                (existing, replacement) -> {
                    if(replacement.getTypeTellInOrOut().equals(MaterialServiceImpl.TypeTellInOrOut.outType)) {
                        existing.setInOrOutCount(existing.getInOrOutCount().add(replacement.getInOrOutCount()));

                    }
                    return existing;
                }
        ));