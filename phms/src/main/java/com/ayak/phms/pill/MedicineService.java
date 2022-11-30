package com.ayak.phms.pill;

import java.util.List;

public class MedicineService {
	Medicine medi = new Medicine();
	MedicineDao medi_Dao = new MedicineDao();
	
	public List<Medicine> getList() {
		return medi_Dao.All_list();
	}
	
	public List<Medicine> getListByDrugName(String Name) {
		medi.setM_DrugName(Name);
		return medi_Dao.All_listByDrugName(medi.getM_DrugName());
	}
	
	public List<Medicine> getListByCompany(String company) {
		medi.setM_Company(company);
		return medi_Dao.All_listByCompany(medi.getM_Company());
	}
	
	public List<Medicine> getListByDrugEffect(String Effect) {
		medi.setM_DrugEffect(Effect);
		return medi_Dao.All_listByDrugEffect(medi.getM_DrugEffect());
	}
}
