
var http = require('http');
var serveStatic = require('serve-static');

var servePublic = serveStatic('public', {'index': ['index.html', 'index.htm']});

http.createServer(function handler(req, res) {
	console.log(req.method, req.url, 'HTTP'+req.httpVersion, req.headers); // , req is too long

	res.setHeader('Access-Control-Allow-Origin', '*');
    
    servePublic(req, res, function nextHandler(req, res){
    });    
}).listen(8080, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
