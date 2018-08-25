package com.cg.equipment.stepDefinitions;


import java.util.List;


import org.junit.Assert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.cg.equipment.bean.CompTrak;
import com.cg.equipment.bean.EquipmentRecord;
import com.cg.equipment.bean.Location;
import com.cg.equipment.bean.PurchaseType;
import com.cg.equipment.bean.UserBean;


import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class EquipmentTrackingFeatureStepDefinition {
	
	
	private TestRestTemplate restTemplate;
	//private ResponseEntity<String> responseEntityString;
	private ResponseEntity<EquipmentRecord> responseEntityEquipment;
	private ResponseEntity<List> responseEntityList;
	
	@Before
	public void setUpTestEnv() {
		restTemplate=new TestRestTemplate();
	}
	

	/*@When("^user tries to add a new record with valid details$")
	public void user_tries_to_add_a_new_record_with_valid_details() throws Throwable {
		EquipmentRecord record= getEquipmentRecord();
		
		MultiValueMap<String, Object> map=new LinkedMultiValueMap<>();
		map.add("eId", record.geteId());
		map.add("user", record.getUser());
		map.add("location", record.getLocation());
		map.add("purchaseType", record.getPurchaseType());
		map.add("compTrak", record.getCompTrak());
		map.add("userStatus", record.getUseStatus());
		map.add("auditIndicator", record.isAuditIndicator());
		map.add("auditDate", record.getAuditDate());
		map.add("comments", record.getComments());
		map.add("stockLocation", record.getStockLocation());
		map.add("equipmentTag", record.getEquipmentTag());
		map.add("lastScanDate", record.getLastScanDate());
		
		responseEntityEquipment=restTemplate.getForEntity("http://localhost:9999/addrecord", EquipmentRecord.class) ; 
	}

	@Then("^the new record should be added to the database$")
	public void the_new_record_should_be_added_to_the_database() throws Throwable {
	    
		 Assert.assertEquals(HttpStatus.OK, responseEntityEquipment.getStatusCode());
	}
	
	private EquipmentRecord getEquipmentRecord() {
		EquipmentRecord record= new EquipmentRecord();
		UserBean userBean=new UserBean();
		Location location=new Location();
		PurchaseType purchase=new PurchaseType();
		CompTrak compTrak=new CompTrak();
		record.seteId("e03");
		userBean.setUserId("u03");
		userBean.setUserName("user3");
		userBean.setDepartmentId("d103");
		userBean.setPassword("system3");
		userBean.setAuthorisation(true);
		record.setUser(userBean);
		location.setLocationId("l03");
		location.setLocationName("Pune");
		record.setLocation(location);
		purchase.setpId("p03");
		purchase.setPurchaseType("Opensource");
		purchase.setPurchaseDate("2013-04-12");
		record.setPurchaseType(purchase);
		compTrak.setComputerName("BLR4");
		compTrak.setDiskCapacity("500GB");
		compTrak.setFreeSpace("92GB");
		compTrak.setLastScanDateComp("2018-07-07");
		compTrak.setMachineId("m03");
		compTrak.setNetworkCardManufacturer("Melco");
		compTrak.setNetworkCardNumber("c0113");
		compTrak.setOperatingSystem("Linux");
		compTrak.setOsVersion("8");
		compTrak.setTotalInstalledMemory("700Mb");
		record.setCompTrak(compTrak);
		record.setUseStatus("In Stock");
		record.setAuditIndicator(true);
		record.setAuditDate("2018-06-17");
		record.setComments("Installed date - 2013-09-28, In stock");
		record.setStockLocation("Bangalore");
		record.setEquipmentTag("7777777777");
		record.setLastScanDate("2018-07-01");
		return record;
	}*/
	
	@When("^user give call to '/records' service$")
	public void user_give_call_to_records_service() throws Throwable {
		responseEntityList=restTemplate.getForEntity("http://localhost:9999/records", List.class);
	}

	@Then("^user should be able to view all Equipment records$")
	public void user_should_be_able_to_view_all_Equipment_records() throws Throwable {
		Assert.assertEquals(HttpStatus.OK, responseEntityList.getStatusCode());
	}
	
	@When("^user give call to '/recordsbyEquipmentTag' service$")
	public void user_give_call_to_recordsbyEquipmentTag_service() throws Throwable {
		/*String p="s02";
		responseEntityProduct=restTemplate.getForEntity("http://localhost:9999/productbyId/s03",Product.class); */
		responseEntityEquipment=restTemplate.getForEntity("http://localhost:9999/recordsbyEquipmentTag/9874563210", EquipmentRecord.class);
	}

	@Then("^user should be able to view all Equipment records for the given Equipment tag$")
	public void user_should_be_able_to_view_all_Equipment_records_for_the_given_Equipment_tag() throws Throwable {
		Assert.assertEquals(HttpStatus.OK, responseEntityEquipment.getStatusCode());
	}

	@When("^user give call to '/recordsbyUserId' service$")
	public void user_give_call_to_recordsbyUserId_service() throws Throwable {
		responseEntityEquipment=restTemplate.getForEntity("http://localhost:9999/recordsbyUserId/u01", EquipmentRecord.class);  
	}

	@Then("^user should be able to view all Equipment records for the given user Id$")
	public void user_should_be_able_to_view_all_Equipment_records_for_the_given_user_Id() throws Throwable {
		Assert.assertEquals(HttpStatus.OK, responseEntityEquipment.getStatusCode());
	}

	@When("^user give call to '/recordsbyLocation' service$")
	public void user_give_call_to_recordsbyLocation_service() throws Throwable {
		responseEntityEquipment=restTemplate.getForEntity("http://localhost:9999/recordsbyLocation/Bangalore", EquipmentRecord.class); 
	}

	@Then("^user should be able to view all Equipment records for the given Location$")
	public void user_should_be_able_to_view_all_Equipment_records_for_the_given_Location() throws Throwable {
		Assert.assertEquals(HttpStatus.OK, responseEntityEquipment.getStatusCode());
	}


}
