# counter-api
It is a Spring MVC Restful application which provide the solution of the following tasks , given sample paragraphs from file.

Task 1: Search the following texts, which will return the counts respectively.

Sample Request
> curl http://host/counter-api/search -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -d’{“searchText”:[“Duis”, “Sed”, “Donec”, “Augue”, “Pellentesque”, “123”]}’ -H"Content-Type: application/json" –X POST

Example :
curl -H "Content-Type: application/json" -H 'Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==' -X POST -d '{"searchText": ["Duis", "Sed", "Donec", "Augue", "Pellentesque", "123"]}'  'http://localhost:8285/counter-api/search'

Result obtained : {"count":[{"Duis":11},{"Sed":16},{"Donec":8},{"Augue":7},{"Pellentesque":6},{"123":0}]}

Task 2: Provide the top 20 (as Path Variable) Texts, which has the highest counts in the Sample Paragraphs provided.

The following curl command should be executed and result expected in csv format. Should be able to put 10, 20, 30 or 5 as the top listing.

Sample Request
> curl http://host/counter-api/top/20 -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -
H”Accept: text/csv”

Example :
curl http://localhost:8085/counter-api/top/20 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Accept: text/csv"
Result obtained :
eget|17
vel|17
sed|16
in|15
et|14
eu|13
ut|13
sit|12
nulla|12
metus|12
amet|12
id|12
ac|12
ipsum|11
duis|11
nec|11
vitae|11
at|11
dolor|10
non|10





