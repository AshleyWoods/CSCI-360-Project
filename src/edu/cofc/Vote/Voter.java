package edu.cofc.Vote;
import java.util.Random;

import edu.cofc.Registration.Controller.VoterRegistrationController;

public class Voter {
	//Creates the voter object as the information expert and reaches to the textInterface as it is the expert on anything to do with stored information
		private Random rand = new Random();


		private VoterRegistrationController voterRegCtrller; 

		private String firstName; // = 				voterRegCtrller.firstNameText.toString();
		private String lastName; // = 				voterRegCtrller.lastNameText.toString();
		private String middleInitial; //=			voterRegCtrller.middleInitialText.toString();
		private String suffix; //=					voterRegCtrller.suffixText.toString();
		private String sex; //= 					voterRegCtrller.sexComboBox.toString();
		private String race; //=					voterRegCtrller.raceComboBox.toString();
		private String ssn; //=						voterRegCtrller.ssnText.toString();
		private String streetResidential; //=		voterRegCtrller.streetText.toString();
		private String cityResidential; // = 		voterRegCtrller.cityText.toString();
		private String stateResidential; // = 		voterRegCtrller.stateText.toString();
		private String zipResidential ;//= 		voterRegCtrller.zipText.toString();
		private String aptResidential;//=			voterRegCtrller.aptText.toString();
		private String inCityLimits;//=			voterRegCtrller.cityLimitComboBox.toString();
		private String streetMailing ;//= 			voterRegCtrller.streetMailingText.toString();
		private String cityMailing;//=				voterRegCtrller.cityMailingText.toString();
		private String stateMailing;//=			voterRegCtrller.stateMailingText.toString();
		private String zipMailing;//=				voterRegCtrller.zipMailingText.toString();
		private String birthdayDate;//=			voterRegCtrller.birthdayDateText.toString();
		private String birthdayMonth ;//= 			voterRegCtrller.birthMonthComboBox.toString();
		private String birthdayYear ;//= 			voterRegCtrller.birthdayYearText.toString();
		private String homePhone;//=				voterRegCtrller.homePhoneText.toString();
		private String workPhone;//=				voterRegCtrller.workPhoneText.toString();
		private String dlNumber;//=				voterRegCtrller.dlNumberText.toString();
		private int voterID;//= 					rand.nextInt(100000);

	//Constructor 1 - Creator
		public Voter(String firstName, String lastName, String MI, String d1Number, int ID){
			//1 - SSN
			//2 - VRN
			//3 - DLN
			if (ID == 1){
				this.firstName = firstName;
				this.lastName = lastName;
				this.middleInitial = MI;
				this.ssn = d1Number;
			}
			else if(ID == 2){
				this.firstName = firstName;
				this.lastName = lastName;
				this.middleInitial = MI;
				this.voterID = Integer.parseInt(d1Number);
			}
			else{
				this.firstName = firstName;
				this.lastName = lastName;
				this.middleInitial = MI;
				this.dlNumber = d1Number;
			}

			this.suffix = 			"";
			this.sex = 				"";
			this.race = 			"";
			this.ssn = 				"";
			this.streetResidential = "";
			this.cityResidential=	"";
			this.stateResidential = "";
			this.zipResidential = 	"";
			this.aptResidential= 	"";
			this.inCityLimits = 	"";
			this.streetMailing = 	"";
			this.cityMailing=		"";
			this.stateMailing = 	"";
			this.zipMailing = 		"";
			this.birthdayDate = 	"";
			this.birthdayMonth = 	"";
			this.birthdayYear = 	"";
			this.homePhone = 		"";
			this.workPhone=			"";
			this.voterID = rand.nextInt(100000);

		}

//Constructor 2, Creator
		public Voter(String firstName, String lastName, String middleInitial, String suffix, String sex,
				  String race, 	String ssn,  String streetResidential,String cityResidential, String stateResidential, 
				  String zipResidential, String aptResidential,String inCityLimits, String streetMailing,
				  String cityMailing, String stateMailing,String zipMailing, String birthdayDate, String birthdayMonth, String birthdayYear,
				  String homePhone, String workPhone, String dlNumber, int voterID) {

		
				this.firstName = 		firstName;
				this.lastName = 		lastName;
				this.middleInitial= 	middleInitial;
				this.suffix = 			suffix;
				this.sex = 				sex;
				this.race = 			race;
				this.ssn = 				ssn;
				this.streetResidential = streetResidential;
				this.cityResidential=	cityResidential;
				this.stateResidential = stateResidential;
				this.zipResidential = 	zipResidential;
				this.aptResidential= 	aptResidential;
				this.inCityLimits = 	inCityLimits;
				this.streetMailing = 	streetMailing;
				this.cityMailing=		cityMailing;
				this.stateMailing = 	stateMailing;
				this.zipMailing = 		zipMailing;
				this.birthdayDate = 	birthdayDate;
				this.birthdayMonth = 	birthdayMonth;
				this.birthdayYear = 	birthdayYear;
				this.homePhone = 		homePhone;
				this.workPhone=			workPhone;
				this.dlNumber = 		dlNumber;
				this.voterID = 			voterID;
			
	}//END CONSTRUCTOR }
		//VOTERID SETTER AND GETTER
			public int getvoterID() {
				
				return this.voterID;
				
			}
		//FIRST NAME GETTER AND SETTER 
			public String getFirstName() {
				return this.firstName;
			}
			public void setFirstName(String s) {
				firstName = s;
			}
			//LAST NAME GETTER AND SETTER
			public String getLastName() {
				return this.lastName;
			}
			public void setLastName(String s) {
				lastName = s;
			}
			//MIDDLE INTIAL GETTER AND SETTER
			public String getMiddleInitial() {
				return this.middleInitial;
			}
			public void setMiddleInitial(String s) {
				middleInitial = s;
			}
			//SUFFIX GETTER AND SETTER 
			public String getSuffix() {
				return this.suffix;
			}
			public void setSuffix(String s) {
				suffix = s;
			}
			//SEX GETTER AND SETTER
			public String getSex() {
				return this.sex;
			}
			public void setSex(String sx) {
				sex = sx;
			}
			//RACE GETTER AND SETTER 
			public String getRace() {
				return this.race;
			}
			public void setRace(String s) {
				race = s;
			}
			//SSN GETTER AND SETTER 
			public String getSSN() {
				return this.ssn;
			}
			public void setSSN(String s) {
				ssn = s;
			}
			//STREET RESIDENTAL ADDRESS GETTER AND SETTER 
			public String getStreetResidential() {
				return this.streetResidential;
			}
			public void setStreetResidential(String s) {
				streetResidential = s;
			}
			//CITY RESDIENTAL ADDRESS GETTER AND SETTER
			public String getCityResidential() {
				return this.cityResidential;
			}
			public void setCityResidental(String s) {
				cityResidential = s;
			}
			//STATE RESIDENTAL ADDRESS GETTER AND SETTER
			public String getStateResidental() {
				return this.stateResidential;
			}
			public void setStateResidential(String s) {
				stateResidential = s;
			}
			//ZIP RESIDENTAL ADDRESS GETTER AND SETTER 
			public String getZipResidential() {
				return this.zipResidential;
			}
			public void setZipResidential(String s) {
				zipResidential= s;
			}
			//APT RESIDENTIAL ADDRESS GETTER AND SETTER
			public String getAptResidential() {
				return this.aptResidential;
			}
			public void setAptResidential(String s) {
				aptResidential= s;
			}
			//INCITYLIMITS GETTER AND SETTER
			public String getCityLimits() {
				return this.inCityLimits;
			}
			public void setInCityLimits(String s) {
				inCityLimits= s;
			}
			//STREET MAILING ADDRESS GETTER AND SETTER
			public String getStreetMailing() {

				return this.streetMailing;
			}
			public void setStreetMailing(String s) {
				streetMailing= s;
			}
			//CITY MIALING ADDRESSS GETTER AND SETTER
			public String getCityMailing() {

				return this.cityMailing;
			}
			public void setCityMailing(String s) {
				cityMailing= s;
			}
			//STATE MAILING ADDRESS GETTER AND SETTER 
			public String getStateMailing() {

				return this.stateMailing;
			}
			public void setStateMailing(String s) {
				stateMailing= s;
			}
			//ZIP MAILING 
			public String getZipMailing() {

				return this.zipMailing;
			}
			public void setZipMailing(String s) {
				zipMailing= s;
			}
			//BIRTHDAY DAY GETTER AND SETTER
			public String getBirthdayDate() {
				return this.birthdayDate;
			}
			public void setBirthdayDate(String s) {
				birthdayDate = s;
			}
			//BIRTHDAY MONTH GETTER AND SETTER
			public String getBirthdayMonth() {

				return this.birthdayMonth;
			}
			public void setBirthdayMonth(String s) {
				birthdayMonth= s;
			}
			//BIRTHDAY YEAR GETTER AND SETTER
			public String getBirthdayYear() {

				return this.birthdayYear;
			}
			public void setBirthdayYear(String s) {
				birthdayYear= s;
			}
			//HOMEPHONE GETTER AND SETTER
			public String getHomePhone() {

				return this.homePhone;
			}
			public void setHomePhone(String s) {
				homePhone= s;
			}
			//WORK PHONE GETTER AND SETTER
			public String getWorkPhone() {

				return this.workPhone;
			}
			public void setWorkPhone(String s) {
				workPhone= s;
			}
			//DL NUMBER GETTER AND SETTER 
			public String getDLNumber() {

				return this.dlNumber;
			}
			public void setDLNumber(String s) {
				dlNumber= s;
			}
			//PRINT OUT PERSON INFORMATION 
			public void printPersonInfo() {
				System.out.print ("first name: " 		+ 			firstName 			+ 
									"last name: " 		+ 			lastName			+ 
									"middle intial" 	+ 			middleInitial 		+ 
									"suffix : " 		+ 			suffix 				+ 
									"sex: "				+ 			sex 				+  
									"race: "			+ 			race 				+  
									"ssn: "				+			ssn 				+ 
									"street Residential"+			streetResidential 	+	 
									"city Residential: "+ 			cityResidential 	+ 
									"state Residential:"+ 			stateResidential	+ 
									"zip Residential: "	+ 			zipResidential		+  
									"in city limits: "	+ 			inCityLimits		+ 
									"street Mailing: "	+ 			streetMailing		+  
									"city Mailing: "	+ 			cityMailing 		+ 
									"zipMailing: "		+ 			zipMailing			+ 
									"birthday date: " 	+			birthdayDate		+ 
									"birthday month: "	+			birthdayMonth		+ 
									"bithday year: "	+			birthdayYear		+ 
									"home phone: "		+ 			homePhone			+  
									"work phone: "		+ 			workPhone			+ 
									"dlNumber: "		+ 			dlNumber			);
						
			}//END PRINTPERSONINFO()

	}

