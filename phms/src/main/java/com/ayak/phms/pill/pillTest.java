package com.ayak.phms.pill;

import java.util.List;

public class pillTest {
	public static void main(String[] args) {
		System.out.println("약정보");
		
		MedicineService medi_service = new MedicineService();
		Medicine medi = new Medicine();
		
		
//		List<Medicine> medi_list = medi_dao.All_list();
		List<Medicine> medi_list = medi_service.getListByCompany("동");
		
		for(Medicine medis : medi_list) {
			System.out.println("업체명 : "+medis.getM_Company());
			System.out.println("약이름 : "+medis.getM_DrugName());
			System.out.println(" 효능 : " + medis.getM_DrugEffect());
			System.out.println("사욥법 : " + medis.getM_UseDrug());
			System.out.println("주의사항(복용전) : " + medis.getM_BeforeWarn());
			System.out.println("주의사항(복용후) : " + medis.getM_AfterWarn());
			System.out.println("상호작용 : " + medis.getM_Interaction());
			System.out.println("부작용 : " + medis.getM_SideEffect());
			System.out.println("보관법 : " + medis.getM_StorageMethod());
			System.out.println("약 이미지 : " + medis.getM_DrugImage());
		}
	}
}
