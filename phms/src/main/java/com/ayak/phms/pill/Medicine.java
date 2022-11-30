package com.ayak.phms.pill;

public class Medicine {
	private long Mid;
	private String M_Company;  // 업체명
	private String M_DrugName; // 약이름
	private String M_DrugEffect; // 약 효능
	private String M_UseDrug;  // 사용법
	private String M_BeforeWarn;  // 복용전 주의사항
	private String M_AfterWarn;	  // 복용후 주의사항
	private String M_Interaction; // 상호작용
	private String M_SideEffect;  // 부작용
	private String M_StorageMethod;  // 보관법
	private String M_DrugImage;  // 이미지
	
	
	public Medicine() {
		super();
	}
	
	public Medicine(String m_Company, String m_DrugName, String m_DrugEffect, String m_UseDrug,
			String m_BeforeWarn, String m_AfterWarn, String m_Interaction, String m_SideEffect, String m_StorageMethod,
			String m_DrugImage) {
		super();
		M_Company = m_Company;
		M_DrugName = m_DrugName;
		M_DrugEffect = m_DrugEffect;
		M_UseDrug = m_UseDrug;
		M_BeforeWarn = m_BeforeWarn;
		M_AfterWarn = m_AfterWarn;
		M_Interaction = m_Interaction;
		M_SideEffect = m_SideEffect;
		M_StorageMethod = m_StorageMethod;
		M_DrugImage = m_DrugImage;
	}
	
	public long getMid() {
		return Mid;
	}
	public String getM_Company() {
		return M_Company;
	}
	public String getM_DrugName() {
		return M_DrugName;
	}
	public String getM_UseDrug() {
		return M_UseDrug;
	}
	public String getM_BeforeWarn() {
		return M_BeforeWarn;
	}
	public String getM_AfterWarn() {
		return M_AfterWarn;
	}
	public String getM_Interaction() {
		return M_Interaction;
	}
	public String getM_SideEffect() {
		return M_SideEffect;
	}
	public String getM_StorageMethod() {
		return M_StorageMethod;
	}
	public String getM_DrugImage() {
		return M_DrugImage;
	}
	public void setMid(long mid) {
		Mid = mid;
	}
	public void setM_Company(String m_Company) {
		M_Company = m_Company;
	}
	public void setM_DrugName(String m_DrugName) {
		M_DrugName = m_DrugName;
	}
	public void setM_UseDrug(String m_UseDrug) {
		M_UseDrug = m_UseDrug;
	}
	public void setM_BeforeWarn(String m_BeforeWarn) {
		M_BeforeWarn = m_BeforeWarn;
	}
	public void setM_AfterWarn(String m_AfterWarn) {
		M_AfterWarn = m_AfterWarn;
	}
	public void setM_Interaction(String m_Interaction) {
		M_Interaction = m_Interaction;
	}
	public void setM_SideEffect(String m_SideEffect) {
		M_SideEffect = m_SideEffect;
	}
	public void setM_StorageMethod(String m_StorageMethod) {
		M_StorageMethod = m_StorageMethod;
	}
	public void setM_DrugImage(String m_DrugImage) {
		M_DrugImage = m_DrugImage;
	}
	public String getM_DrugEffect() {
		return M_DrugEffect;
	}
	public void setM_DrugEffect(String m_DrugEffect) {
		M_DrugEffect = m_DrugEffect;
	}
	
	
	
}
