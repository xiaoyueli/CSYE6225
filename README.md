# CSYE6225
Structure:
datamodel: Lecture/LectureDB, Course/CourseDB, Professor/ProfessorDB, Student/StudentDB, Board, Toster
Service: LectureService, CourseService, ProfessorService, StudentService
Router: LectureResourse, CourseResourse, ProfessorResourse, StudentResourse

RestFul operations:
Example of Course Service:

partOne: create/update/delete course

@GET all course
http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/courses

@POST
http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/courses
intput:
{
  "courseName":"JAVA"  
}
output:
{
    "courseID": 1,
    "courseName": "JAVA",
    "enrolledStudents": {
        "entry": []
    },
    "lectures": {
        "entry": []
    }
}

@PUT
http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/courses/1
input:
{
  "courseName":"Cloud"
}
output:
{
    "courseID": 1,
    "courseName": "Cloud",
    "enrolledStudents": {
        "entry": []
    },
    "lectures": {
        "entry": []
    }
}

@DELETE
http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/courses/1

=================================================================
PartTwo: add professor to course

<--Create professor in ProfessorDB-->
@POST
http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/professors
input:
{
	"firstName":"Avinav",
	"department":"Information Systems"
}
output:
{
    "department": "Information Systems",
    "firstName": "Avinav",
    "professorID": 1,
    "startDate": "2018-10-21T00:46:43.969"
}

<--Add professor 1 to course 1-->
@GET
http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/courses/1/addprofessor/1
output:
{
    "courseID": 1,
    "courseName": "Computer Science",
    "enrolledStudents": {
        "entry": []
    },
    "lectures": {
        "entry": []
    },
    "prof": {
        "department": "Information Systems",
        "firstName": "Avinav",
        "professorID": 1,
        "startDate": "2018-10-21T00:46:43.969"
    }
}
=================================================================================
PartThree: add Lectures to course

<--create Lecture in LectureDB-->

@POST
http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/lectures
input:
{
	"title":"cloudcomputing",
	"notes":"cloud storage",
	"matrials":"URLs • State is transferred from the server to the client • State is a point in time view of the data • Data can come in many forms - • Structured • Unstructured • Semi-Structured"
}
output:
{
    "matrials": "URLs • State is transferred from the server to the client • State is a point in time view of the data • Data can come in many forms - • Structured • Unstructured • Semi-Structured",
    "notes": "cloud storage",
    "title": "cloudcomputing"
}

<--add lecture of cloudcomputing to course 1-->
@GET
http://xiaoyueli.us-east-2.elasticbeanstalk.com/webapi/courses/1/addlecture/cloudcomputing
output:
{
    "courseID": 1,
    "courseName": "Cloud",
    "enrolledStudents": {
        "entry": []
    },
    "lectures": {
        "entry": [
            {
                "key": "cloudcomputing",
                "value": {
                    "matrials": "URLs • State is transferred from the server to the client • State is a point in time view of the data • Data can come in many forms - • Structured • Unstructured • Semi-Structured",
                    "notes": "cloud storage",
                    "title": "cloudcomputing"
                }
            }
        ]
    },
    "prof": {
        "department": "Information Systems",
        "firstName": "Avinav",
        "professorID": 1,
        "startDate": "2018-10-21T00:46:43.969"
    }
}

===========================================================================
leave student, program to assignment2 :D



