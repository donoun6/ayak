CREATE TABLE Medicine (
   Mid            BIGINT      	 AUTO_INCREMENT	PRIMARY KEY,
   M_Company        VARCHAR(30),
   M_DrugName       VARCHAR(100) ,     
   M_DrugEffect     VARCHAR(2000),  
   M_UseDrug        VARCHAR(2000) ,  
   M_BeforeWarn     VARCHAR(2000) ,  
   M_AfterWarn      VARCHAR(2000) ,  
   M_Interaction    VARCHAR(2000) ,  
   M_SideEffect     VARCHAR(2000) ,  
   M_StorageMethod  VARCHAR(2000) ,  
   M_DrugImage      VARCHAR(200)  
) AUTO_INCREMENT = 1

select * from Medicine;

delete from Medicine;

INSERT INTO Medicine(M_Company, M_DrugName, M_DrugEffect, M_UseDrug, M_BeforeWarn, M_AfterWarn, M_Interaction
,M_SideEffect, M_StorageMethod, M_DrugImage) values ('동아','활명','감기','ㅎㅎ','ㅎㅎ','ㅎㅎ','ㅎㅎ','ㅎㅎ','ㅎㅎ','ㅎㅎ')
drop table Medicine;

select * from Medicine where M_company LIKE '%동아%';