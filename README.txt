## please find the API end-points below

## Employee details
1.Save record Employee- 
	URL - http://localhost:8080/rest-api/saveEmployee - POST
	
	Body - {
    		"empName": "Jon",
    		"technology":"python",
    		"mobileNumber":"1234567890",
   		"empSalary":25000
		}
		
2.Update employee record-
	URL - http://localhost:8080/rest-api/updateEmployee - PUT
	Body - {
    		"empId":1,
    		"empName": "Tony",
    		"technology":"java",
    		"mobileNumber":"1234567890",
    		"empSalary":55000
		}

3.Delete record- URL - http://localhost:8080/rest-api/deleteEmployee/{empID} - DELETE

4.View all records - URL - http://localhost:8080/rest-api/getEmployees - GET

## Task details
1.Add task - 
	URL - http://localhost:8080/rest-api/addTask - POST
	
	Body - {
		    "taskAssigned" : "testing",
		    "estimatedTime" : "15 hrs",
		    "employee" : {
		        "empId":2
		    }
		}
		
2.Update task record-
	URL - http://localhost:8080/rest-api/updateTask - PUT
	Body - {
		    "taskId":2,
		    "taskAssigned" : "deployment",
		    "estimatedTime" : "25 hrs",
		    "employee" : {
		        "empId":1
		    }
		}

3.Delete Task- URL - http://localhost:8080/rest-api/deleteTask/{taskID} - DELETE

4.View all records - URL - http://localhost:8080/rest-api/getTasks - GET