        Map<List<Object>, OutStockBo> groupMap = inAndOutStockList.stream().filter(inAndOutStock -> inAndOutStock.getTypeTellInOrOut() == MaterialServiceImpl.TypeTellInOrOut.outType).collect(Collectors.toMap(
                inAndOutStock -> {
                    List<Object> tempList = new ArrayList<>();

                    tempList.add(inAndOutStock.getMaterialCode());
                    tempList.add(inAndOutStock.getItemNum());
                    tempList.add(inAndOutStock.getNumber());
                    return tempList;
                },
                inAndOutStock -> {
                    OutStockBo outStockSumBo =new OutStockBo();
                    outStockSumBo.setMaterialCode(inAndOutStock.getMaterialCode());
                    outStockSumBo.setMaterialName(inAndOutStock.getMaterialName());
                    outStockSumBo.setItemNum(inAndOutStock.getItemNum());
                    outStockSumBo.setPickingNum(inAndOutStock.getNumber());

//                    if(inAndOutStock.getTypeTellInOrOut().equals(MaterialServiceImpl.TypeTellInOrOut.outType)){
                        outStockSumBo.setOutStockCountTotal(inAndOutStock.getInOrOutCount().negate());
                        outStockSumBo.setOutStockAmountTotal(inAndOutStock.getInOrOutCount().negate().multiply(inAndOutStock.getRecordPrice()));

//                        return Optional.of(outStockSumBo);
//                    }else {
//                        outStockSumBo.setOutStockCountTotal(BigDecimal.ZERO);
//                        outStockSumBo.setOutStockAmountTotal(BigDecimal.ZERO);
//                        return Optional.empty();
//                    }
                    return outStockSumBo;
                },
                (existing, replacement) -> {
                    existing.setOutStockCountTotal(existing.getOutStockCountTotal().add(replacement.getOutStockCountTotal()));
                    existing.setOutStockAmountTotal(existing.getOutStockAmountTotal().add(replacement.getOutStockAmountTotal()));
                    return existing;
                }
        ));