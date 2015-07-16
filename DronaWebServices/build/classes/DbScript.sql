desc organisation;
 insert into address_details(address_Id,created_by,created_date,status,country,phone_no1,postal_code) value(1,1,'2015-03-01 00:01:01',2,"india","45678987","23432");
 insert into organisation(organisation_id,created_by,created_date,status,organisation_name,Address_Id_Fk,Parent_Org_Id,Org_Type) value (1,1,'2015-01-01 01:01:01',2,"Test123",1,1,1);
  insert into organisation(organisation_id,created_by,created_date,status,organisation_name,Address_Id_Fk,Parent_Org_Id,Org_Type) value (2,1,'2015-01-01 01:01:01',2,"institute",1,1,2);