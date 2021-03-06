--pre return
--关键属性: CRET01_FO_STATUS : Filing obligation status 1.ISSUED(成功在02表产生税单) 2.FILED(以前的期数中已经有税单不再产生)
select * from TRET01_FILING_OBLIGATION t1 where t1.CRET01_FO_STATUS='nvc';
desc TRET01_FILING_OBLIGATION;

--return tax
select * from TRET02_RETURN;
--return ver
select * from TRET03_RETURN_VERSION;
--return content
select * from TRET04_RETURN_CONTENT;
--batch record
select * from TRET05_BATCH;
select * from TRET06_RETURN_REQUEST;
--tax type
select * from TRET09_TAXTYPE;
--type code
select * FROM TRET11_RETURN_TYPE;

--taxpyer
select * from TREG01_TAXPAYER;
--d9978168-9e91-47e9-be3a-0c09790fe9a9 : 03100000   查找 纳税局 用户信息
select * from APEX_USER_LOGIN where SYS_GUID='d9978168-9e91-47e9-be3a-0c09790fe9a9';
--查找纳税局人员的 注册信息  关键字段 organization_guid对应APEX_ORGANIZATION的SYS_GUID
select * from APEX_ORG_USER a where a.USER_GUID='d9978168-9e91-47e9-be3a-0c09790fe9a9' ;
--根据纳税局人员找到对应的 办公室
select * from APEX_ORGANIZATION where SYS_GUID='114';
select * from TREG20_BRANCH;
select * from TRET20_RETURN_DETAIL_PAYE;


-----------------------------------------
set serveroutput on
DECLARE
user_num number := 1;
begin
Loop 
Exit when user_num>100;

user_num := user_num+1;
end Loop;
DBMS_OUTPUT.put_line(user_num);
end;



----------------------------------------
--查看列名属性长度注释
select u.TABLE_NAME,u.COLUMN_NAME,u.DATA_TYPE,u.DATA_LENGTH,uc.COMMENTS
from 
USER_TAB_COLUMNS u 
left join 
USER_COL_COMMENTS uc
on u.COLUMN_NAME=uc.COLUMN_NAME
where 
u.TABLE_NAME=uc.TABLE_NAME
and
u.TABLE_NAME='TRET01_FILING_OBLIGATION';


--ENGLISH_UNITED KINGDOM.WE8MSWIN1252
select userenv('language') from dual;
