
let express = require('express');


let xmlserver=express();
xmlserver.listen(8888);
console.log('Server is running on port 8888');
let fileName=__dirname+"/firstxml.xml"

xmlserver.use(express.static(__dirname));

xmlserver.get('/', function(req, res){
    res.sendFile(fileName);
});
