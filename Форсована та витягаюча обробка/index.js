let express = require('express');

let xmlserver=express();

const port = 2303;
xmlserver.listen(port);
console.log(`Server is running on port ${port}`);
console.log(`http://localhost:${port}`);

let etractionFileName=__dirname+"/etraction.xml"
let forceFileName=__dirname+"/force.xml"

xmlserver.use(express.static(__dirname));

xmlserver.get('/etraction', function(req, res){
    res.sendFile(etractionFileName);
});
xmlserver.get('/force', function(req, res){
    res.sendFile(forceFileName);
});