let xmldom = require('xmldom');
let fs = require("fs");

let xmlString = fs.readFileSync('file.xml', 'utf8')
let parser = new xmldom.DOMParser()
let xmlDoc = parser.parseFromString(xmlString, "text/xml")
let res = xmlToJson(xmlDoc)

write('result.json', JSON.stringify(res))

function write(filename, string) {
    fs.writeFile(filename, string, err => {
        if (err) console.log('Fail', err)
        else console.log('Done')
    })
}

function xmlToJson (xml) {
    var obj = {};

    if (xml.nodeType === 1) { // element
        // do attributes
        if (xml.attributes.length > 0) {
            for (var j = 0; j < xml.attributes.length; j++) {
                var attribute = xml.attributes.item(j);
                obj[attribute.nodeName] = attribute.nodeValue;
            }
        }
    } else if (xml.nodeType === 3) { // text
        if (xml.nodeValue.trim() !== "")
            obj = xml.nodeValue;
    }

    // do childrens
    if (xml.hasChildNodes()) {
        for (var i = 0; i < xml.childNodes.length; i++) {
            var item = xml.childNodes.item(i);
            var nodeName = item.nodeName;
            if (nodeName !== undefined) {
                if (typeof (obj[nodeName]) == "undefined") {
                    if (nodeName === "#text" && item.nodeValue.trim() === "") {

                    } else {
                        if (nodeName === "#text")
                            obj = xmlToJson(item);
                        else obj[nodeName] = xmlToJson(item);
                    }
                } else {
                    if (typeof (obj[nodeName].push) == "undefined") {
                        var old = obj[nodeName];
                        obj[nodeName] = [];
                        if (nodeName !== "#text")
                            obj[nodeName].push(old);
                    }
                    obj[nodeName].push(xmlToJson(item));
                }
            }
        }
    }
    return obj;
}