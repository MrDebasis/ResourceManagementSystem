

#REGISTRACTION URL-http://localhost:8088/resource/restn
#METHOD-POST
#JSON BODY:
{
        "country":"india",
        "globalGroupID":"1123",
        "employeeId": "796",
        "emailId": "somesh@gmail.com",
		"password": "somesh",
        "name": "somesh",
		"localGrade": "vhgvv",
        "leaveApplied": "Z",
        "status": "inactive",
		"grade": "a4",
        "type":"fresher",
	    "officeCity":"banglore"
    }
#FORGETPASSWORD URL-http://localhost:8088/resource/forgetpass/{EMPID}/{EMAIL}/{NEW PASSWORD}
#METHOD-POST
#EX-http://localhost:8088/resource/forgetpass/796/somesh@gmail.com/11234


#LOGIN-http://localhost:8088/resource/login
#METHOD-GET
#JSON BODY-
{
	"employeeId":"796",
		"password":"11234"
		
}
#FILTER URL:http://localhost:8088/resource/filter/{STATUS}/{TYPE}/{CITY}
#EXAMPLE-http://localhost:8088/resource/filter/inactive/fresher/banglore
#METHOD-GET

#EXCEL SHEET:  #URL----http://localhost:8088/resource/{STATUS}/{TYPE}/{CITY}/download/Resources.xlsx
#EXAMPLE: http://localhost:8088/resource/inactive/fresher/banglore/download/Resources.xlsx



#DeleteById:http://localhost:8088/resource/delete/{employeeId}
#Example: http://localhost:8088/resource/delete/79
#Mehod: Delete

#FindAll: http://localhost:8088/resource/filter/all
#method: get
















