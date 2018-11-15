# CSYE6225 
## Structure:
* datamodel: Student, Professor, Course, Board, Announcements, DynamoDBConnector
* Service: StudentService, CourseService, ProfessorService, BoardService, AnnouncementsService
* Router: StudentResourse, CourseResourse, ProfessorResourse, BoardResourse, AnnouncementsResourse

## RestFull Operation Example of Student

* Post Student: 
```
POST: http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/students/
input:
{
    "fitseName":"xiaohua",
	"lastName":"wang",
	"department":"Information Systems"
}
 output:
{
    "department": "Information Systems",
    "id": "016d2c2a-0a30-414c-b522-08328904e0f6",
    "joiningDate": "2018-11-15T08:01:42.993",
    "lastName": "wang",
    "registeredCourses": [],
    "studentID": 1
}
```

* Add course 
```
GET: http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/students/016d2c2a-0a30-414c-b522-08328904e0f6/info6225
output:
{
    "department": "Information Systems",
    "id": "016d2c2a-0a30-414c-b522-08328904e0f6",
    "joiningDate": "2018-11-15T08:01:42.993",
    "lastName": "wang",
    "registeredCourses": [
        "info6225"
    ],
    "studentID": 1
}
```

* Get all student
```
GET: http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/students
```

* Get Student by ID
```
GET: http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/students/016d2c2a-0a30-414c-b522-08328904e0f6
```

* Update Student
```
PUT: http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/students/016d2c2a-0a30-414c-b522-08328904e0f6
input:
{
	"fitseName":"xiaohua",
	"lastName":"wang",
	"department":"Computer Science"
}
output:
{
    "department": "Computer Science",
    "id": "016d2c2a-0a30-414c-b522-08328904e0f6",
    "joiningDate": "2018-11-15T08:01:42.993",
    "lastName": "wang",
    "registeredCourses": [
        "info6225"
    ],
    "studentID": 1
}
```

* Delete Student
```
Delete: http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/students/016d2c2a-0a30-414c-b522-08328904e0f6
```








