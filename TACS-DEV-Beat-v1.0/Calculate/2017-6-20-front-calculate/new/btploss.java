        Tret28BptLoss tret28BptLossCurrent = new Tret28BptLoss();
    	tret28BptLossCurrent.setCreg01Tin(tin);
    	tret28BptLossCurrent.setCret02TaxYear(taxYear);
    	tret28BptLossCurrent.setCreet09TaxTypeUid(taxTypeUid);
    	tret28BptLossCurrent.setCret28LossType(lossType);
    	Tret28BptLoss tret28BptLossSelectedCurrent = tret28BptLossDAO.selectByRecord(tret28BptLossCurrent);
		tret28BptLossSelectedCurrent.getCret28BptLoss();