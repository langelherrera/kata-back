The application run in port 8082

for create a product needs, basic auth

httpMethod: POST
Endpoint: <baseUrl>/tasks

username: test
password: test

payload
{
    "title":"title of the task",
    "description":"description of the task "
}
------------------------------------------
for get all Taks, create a request to /task

httpMethod: GET
Endpoint: <baseUrl>/tasks

basic Auth

username: test
password: test

----------------------------------------

for delete a task, create a request to /taks/{id}

httpMethod: DELETE
Endpoint: <baseUrl>/tasks/{id}

basic Auth

username: test
password: test
